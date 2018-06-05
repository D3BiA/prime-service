package it.adebiasi.primes.primeservice.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import it.adebiasi.primes.primeservice.util.InlineListDeserializer;

import java.util.ArrayList;
import java.util.List;

public class PrimeCollector {

    @JsonProperty(value = "Initial")
    private long initial;

    @JsonProperty(value = "Primes")
    @JsonSerialize(using = InlineListDeserializer.class)
    private List<Long> primes = new ArrayList<>();

    public PrimeCollector(long initial) {
        this.initial = initial;
    }

    public long getInitial() {
        return initial;
    }

    public List<Long> getPrimes() {
        return primes;
    }

    public void setPrimes(List<Long> primes) {
        this.primes = primes;
    }

    public void addPrime(long i) {
        primes.add(i);
    }
}
