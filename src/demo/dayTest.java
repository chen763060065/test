package demo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class dayTest {

    public static void main(String[] args) {
        System.out.println(LocalDateTime.now());
        System.out.println(LocalDateTime.of(2021, 3, 11, 23, 59, 59));
        System.out.println(LocalDateTime.now().isAfter(LocalDateTime.of(2021, 3, 11, 23, 59, 59)));
    }
}
