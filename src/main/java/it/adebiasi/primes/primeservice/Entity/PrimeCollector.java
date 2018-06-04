package it.adebiasi.primes.primeservice.Entity;

import java.util.ArrayList;
import java.util.List;

public class PrimeCollector {

    private long prime;

    private List<Long> previousPrimes = new ArrayList<>();

    public PrimeCollector(long prime) {
        this.prime = prime;
    }

    public long getPrime() {
        return prime;
    }

    public List<Long> getPreviousPrimes() {
        return previousPrimes;
    }

    public void setPreviousPrimes(List<Long> previousPrimes) {
        this.previousPrimes = previousPrimes;
    }

    public void addPrime(long i) {
        previousPrimes.add(i);
    }
}
