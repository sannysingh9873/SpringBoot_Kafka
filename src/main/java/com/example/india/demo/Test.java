package com.example.india.demo;

import com.example.india.demo.dto.EmployeeDto;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {



        ArrayList<EmployeeDto> arrayList=new ArrayList<>();
        arrayList.add(new EmployeeDto(101,"sanny","bangalore"));
        arrayList.add(new EmployeeDto(102,"rakesh","hyd"));
        arrayList.add(new EmployeeDto(103,"singh","chennai"));
        arrayList.add(new EmployeeDto(103,"singh","bangalore"));
        arrayList.add(new EmployeeDto(103,"krsingh","chennai"));

        Consumer<List<EmployeeDto>> display= ls -> ls.stream().forEach(System.out::println);
        display.accept(arrayList);
       /* Map<String, Long> collect = arrayList.stream().collect
                (Collectors.groupingBy(EmployeeDto::getAddress, Collectors.counting()));
       // System.out.println(collect);
        List<String> arrayList2=new ArrayList<>();
        arrayList2.add("bangalore");
        arrayList2.add("bangalore");
        arrayList2.add("chennai");
        arrayList2.add("hyd");
        arrayList2.add("chennai");
        List<String> collect1 = Optional.of(arrayList2).orElse(Collections.emptyList())
                .stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(p -> p.getValue() > 1).map(Map.Entry::getKey)
                .collect(Collectors.toList());
        //System.out.println(collect1);

        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> integers1 = Arrays.asList(4,5,6, 7, 8, 9, 10);
        List<Integer> collect2 = Stream.of(integers, integers1).
                flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println(collect2);
        Set<Integer> nonDuplicate = Stream.concat(integers.stream(), integers1.stream()).collect(Collectors.toSet());
        System.out.println(nonDuplicate);*/
    }
}
