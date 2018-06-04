package it.adebiasi.primes.primeservice.service;

import it.adebiasi.primes.primeservice.Entity.PrimeCollector;

public interface PrimeService {

    /**
     * Get all the prime number up to the number passed as parameter
     *
     * @param n
     * @return
     */
    PrimeCollector getPrimeUpToN(long n);
}
