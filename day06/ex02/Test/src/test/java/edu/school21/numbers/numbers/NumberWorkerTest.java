package edu.school21.numbers.numbers;

import edu.school21.numbers.NumberWorker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class NumberWorkerTest {

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 5, 7, 11, 13, 17, 19})
    public void IsPrimeForPrimes(int prime) throws Exception {
        Assertions.assertTrue(new NumberWorker().IsPrime(prime));
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 6, 8, 9, 10, 12, 14, 15, 16, 18, 20})
    public void isPrimeForNotPrimes (int notPrime) throws Exception {
        assertFalse(new NumberWorker().IsPrime(notPrime));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, -1, -2, -3, -4, -5, -6, -7})
    public void isPrimeForIncorrectNumbers(int incorrectNum) {
       assertThrows(Exception.class, () -> new NumberWorker().IsPrime(incorrectNum));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv")
    public void isSumCorrect(int number, int answer) {
        assertEquals(answer, new NumberWorker().digitsSum(number));
    }
}
