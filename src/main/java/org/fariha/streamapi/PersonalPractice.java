package org.fariha.streamapi;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PersonalPractice {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Test1 {
        String val1;
        String val2;
        int number;

        @Override
        public String toString() {
            return (val1 + " " + val2);
        }
    }

    public static void main(String[] args) {
        List<Test1> lst1 = new ArrayList<>();
        lst1.add(new Test1("1:val1", "1:val2", 10));
        lst1.add(new Test1("2:val1", "2:val2", 20));
        lst1.add(new Test1("3:val1", "3:val2", 30));
        lst1.add(new Test1("4:val1", "4:val2", 40));
        lst1.add(new Test1("5:val1", null, 50));

        //Non terminal methods
        List<String> list = lst1.stream()
                .filter(test -> test.getVal2() != null)
                .map(Test1::getVal1)
                .sorted((val1, val2) -> {
                    return val2.compareToIgnoreCase(val1);
                })
                .toList();

        System.out.println("Non terminal operators: " + list);

     /*   lst1.stream()
                .forEach(test -> {
                    test.setVal1(" modified");  // Modify val1
                    test.setVal2("Modified val2");  // Modify val2
                });*/

        System.out.println("Modified List: " + lst1);


        Optional<Integer> concatenatedVal1 = lst1.stream()
                .map(Test1::getNumber)  // Extract val1 from each Test1 object
                .reduce(Integer::sum);  // Concatenate values with a comma

        // Print the result
        concatenatedVal1.ifPresent(System.out::println);  // Output: 1:val1, 2:val1, 3:val1, 4:val1, 5:val1

    }
}
