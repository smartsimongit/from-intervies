package org.smart.simon.livecoding;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
* Даны два списка строк. Написать метод, который возвращает совпадения (общие элементы) между ними.
 */
public class CommonElements {

    public static Set<String> findCommonOpt (List<String> list1, List<String> list2) {
        Set<String> set1 = new HashSet<>(list1);
        Set<String> set2 = new HashSet<>(list2);
        set1.retainAll(set2);
        return set1;
    }

    public static List<String> findCommon(List<String> list1, List<String> list2) {
        Set<String> set2 = new HashSet<>(list2);
        return list1.stream()
                .filter(set2::contains)
                .toList();
    }

}
