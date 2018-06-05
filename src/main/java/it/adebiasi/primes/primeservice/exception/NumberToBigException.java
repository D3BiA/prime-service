package it.adebiasi.primes.primeservice.exception;

import java.io.Serializable;

public class NumberToBigException extends Exception implements Serializable {

    private long initial;

    public NumberToBigException(long initial) {
        super(String.format("The provided parameters %d is too big, please retry with a smaller number", initial));
        this.initial = initial;
    }

    public long getInitial() {
        return initial;
    }

    public void setInitial(long initial) {
        this.initial = initial;
    }
}
