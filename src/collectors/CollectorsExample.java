package collectors;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class CollectorsExample {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        CollectorsExample.class.getResourceAsStream("people.txt"))))
        {

            Stream<String> stream = reader.lines();

            stream.map(line -> {
                        String[] r = line.split(" ");
                        Person p = new Person(r[0].trim(), Integer.parseInt(r[1]));
                        persons.add(p);
                        return p;
                    })
                    .forEach(System.out::println);

//            Optional<Person> opt1 = persons
//                    .stream()
//                    .filter(p->p.getAge() > 20)
//                    .min(Comparator.comparing(Person::getAge));
//            System.out.println(opt1);
//
//            Optional<Person> opt2 = persons
//                    .stream()
//                    .filter(p->p.getAge() > 20)
//                    .max(Comparator.comparing(Person::getAge));
//            System.out.println(opt2);

//            Map<Integer,Long> map1 = persons.stream()
//                    .collect(Collectors.groupingBy(Person::getAge,Collectors.counting()));
//            System.out.println(map1);

//            Map<Integer,List<String>> map2 = persons.stream()
//                    .collect(Collectors.groupingBy(Person::getAge,Collectors.mapping(Person::getName,Collectors.toList())));
//            System.out.println(map2);

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
