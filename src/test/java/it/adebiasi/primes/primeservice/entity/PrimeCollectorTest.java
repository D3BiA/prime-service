package it.adebiasi.primes.primeservice.entity;

import it.adebiasi.primes.primeservice.Entity.PrimeCollector;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PrimeCollectorTest {

    @Test
    public void testCreation() {
        PrimeCollector prime = new PrimeCollector(1);
        assertEquals(1, prime.getInitial());
        assertEquals(0, prime.getPrimes().size());
    }

    @Test
    public void testAddPrime() {
        PrimeCollector prime = new PrimeCollector(2);
        prime.addPrime(2);
        assertEquals(1, prime.getPrimes().size());
        assertEquals(2, (long) prime.getPrimes().get(0));
    }
}
