package com.zyq.demo.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class LambdaTest2 {
    public static void main(String[] args) {
        Employee e1 = new Employee(1L, 9, "M", "A,B", "Feezor");
        Employee e2 = new Employee(2L, 29, "F", "A", "Roy");
        Employee e3 = new Employee(3L, 19, "M", "C,D", "Gussin");
        Employee e4 = new Employee(4L, 19, "M", "D,E", "Feezor");
        Employee e5 = new Employee(5L, 39, "F", "E", "Roy");
        Employee e6 = new Employee(6L, 29, "F", "F", "Roy");
        Employee e7 = new Employee(7L, 29, "F", "G", "Roy");
        Employee e8 = new Employee(8L, 29, "F", "H", "Roy");
        Employee e9 = new Employee(9L, 29, "F", "I", "Roy");
        List<Employee> list1 = new ArrayList<>();
        list1.addAll(Arrays.asList(new Employee[]{e1, e2, e3, e4}));
        List<Employee> list2 = new ArrayList<>();
        list2.addAll(Arrays.asList(new Employee[]{e5, e6, e7, e8}));
        List<Employee> list3 = new ArrayList<>();
        for (Employee list :list1) {
            Arrays.asList(list.getFirstName());
            list3.add(list);
        }
        System.out.println(list3);

        //AECFDG
      /*  LinkedList<String> list3 = list1.stream().map(Employee::getFirstName).collect(Collectors.toCollection(LinkedList::new));
        LinkedList<String> list4 = list2.stream().map(Employee::getFirstName).collect(Collectors.toCollection(LinkedList::new));
        List<LinkedList<String>> list5= new ArrayList<>();
        List<LinkedList<String>> list6= new ArrayList<>();
        list6.add(list4);
        list5.add(list3);
        list5.addAll(list6);
        System.out.println(orderByCross(list5));*/
    }

    public static List<String> orderByCross(List<LinkedList<String>> extensionWordsGroup) {
        List<String> result = new ArrayList<>();
        if (extensionWordsGroup.isEmpty()) return result;
        Set<String> existWords = new HashSet<>();
        int size = extensionWordsGroup.size();
        int totalSize = extensionWordsGroup.stream().mapToInt(Collection::size).sum();

        for (int i = 0; ; ) {
            if (i >= size) i = 0;
            LinkedList<String> wordsList = extensionWordsGroup.get(i);
            while (wordsList.size() > 0) {
                String word = wordsList.pollFirst();
                totalSize--;
                if (!word.isEmpty() && !existWords.contains(word)) {
                    result.add(word);
                    existWords.add(word);
                    break;
                }
            }
            i++;

            if (totalSize <= 0) break;
        }
        return result;
    }

}