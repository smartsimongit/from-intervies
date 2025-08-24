package org.smart.simon.codereviews;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Currency;
import java.util.Date;

public class PaymentServiceReview {

    @RestController
    @RequestMapping("/api1")
    public class PaymentController {

        private final PaymentService paymentService = new PaymentService();

        @GetMapping("/pay")
        public ResponseEntity<String> pay(@RequestParam String amount,
                                          @RequestParam String currency,
                                          @RequestParam Long recipientId) {

            paymentService.processPayment(amount, currency, recipientId);
            return ResponseEntity.ok("processed at " + new Date());
        }
    }

    @Service
    public class PaymentService {

        @Transactional
        public void processPayment(String amountStr, String currencyCode, Long recipientId) {

            double amount = Double.parseDouble(amountStr);
            Currency currency = Currency.getInstance(currencyCode);
            double rate = getRateFromDb(currencyCode);
            double amountUsd = amount * rate;

            Long userId = (Long) SecurityContextHolder.getContext()
                    .getAuthentication()
                    .getPrincipal();

            User user = userRepository.findById(userId).orElse(null);

            Payment payment = new Payment(amountUsd, user, recipientId);

            if (amountUsd < 1000) createFee(amountUsd * 0.015, user);
            if (amountUsd > 1000) createFee(amountUsd * 0.01, user);
            if (amountUsd > 5000) createFee(amountUsd * 0.005, user);

            try {
                Connection c = jdbcTemplate.getDataSource().getConnection();
                Statement st = c.createStatement();
                st.executeUpdate("INSERT INTO payment VALUES (" + payment + ")");
            } catch (Exception e) {
                e.printStackTrace();
            }

            notificationRestClient.notify(payment);
            kafkaTemplate.send("payments", payment.toString());
            System.out.println("Processed at " + FMT.format(new Date()));
        }

        private double getRateFromDb(String code) {
            return jdbcTemplate.queryForObject(
                    "SELECT rate FROM fx_rates WHERE code = '" + code + "'",
                    Double.class
            );
        }

        private void createFee(double v, User u) {
            Fee f = new Fee(v, u);
            feeRepository.save(f);
        }
    }

    /* ======================= Заглушки для компиляции ======================= */

    class Payment {
        double a;
        User u;
        Long r;

        Payment(double a, User u, Long r) {
            this.a = a;
            this.u = u;
            this.r = r;
        }
    }

    class Fee {
        double v;
        User u;

        Fee(double v, User u) {
            this.v = v;
            this.u = u;
        }
    }

    class User {
        Long id;
    }

    interface FeeRepository {
        void save(Fee f);
    }

    interface UserRepository {
        Optional<User> findById(Long id);
    }

    class NotificationRestClient {
        void notify(Payment p) {
        }
    }

}


