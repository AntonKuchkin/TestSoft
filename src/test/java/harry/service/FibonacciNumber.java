package harry.service;

import java.time.LocalDate;

public class FibonacciNumber {

    public Integer getFibonacciNumberByDate() {
        LocalDate date = LocalDate.now();
        Integer num = date.getDayOfMonth();
        Integer fibonacciNumber = getFibonacciValue(num);
        return fibonacciNumber;
    }

    private Integer getFibonacciValue(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return getFibonacciValue(n - 1) + getFibonacciValue(n - 2);
        }
    }
}
