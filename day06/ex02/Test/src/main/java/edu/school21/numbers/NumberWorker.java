package edu.school21.numbers;

import java.io.IOException;

public class NumberWorker {

    public boolean IsPrime(int number) throws IllegalNumberException {

        if (number < 2) {
            throw new IllegalNumberException();
        }
        for (int i = 2; i * i <= number && i <= 46340; i++) {
            if (number % i == 0)
                return (false);
        }
        return (true);
    }

    public int digitsSum(int number) {
        int sum = 0;

        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }
        return (sum);

    }
}

class IllegalNumberException extends IOException {
    public IllegalNumberException() {
        super ("Illegal number");
    }
}