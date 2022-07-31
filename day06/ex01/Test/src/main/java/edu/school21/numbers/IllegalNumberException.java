package edu.school21.numbers;

import java.io.IOException;

public class IllegalNumberException extends IOException {
    public IllegalNumberException() {
        super ("Illegal number");
    }
}
