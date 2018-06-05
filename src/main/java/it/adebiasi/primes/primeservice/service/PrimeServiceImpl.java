package it.adebiasi.primes.primeservice.service;

import it.adebiasi.primes.primeservice.Entity.PrimeCollector;
import it.adebiasi.primes.primeservice.exception.NumberToBigException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("default")
@Service
public class PrimeServiceImpl implements PrimeService {

    @Value("${prime.maxallowed}")
    private Long maxAllowed;

    @Override
    public PrimeCollector getPrimeUpToN(long n) throws NumberToBigException {
        PrimeCollector collector = new PrimeCollector(n);
        if (n > maxAllowed) {
            throw new NumberToBigException(n);
        }
        calculatePrimes(collector, n);
        return collector;
    }

    private PrimeCollector calculatePrimes(PrimeCollector collector, long max) {
        for (long i = 0; i <= max; i++) {
            if (isPrime(i)) {
                collector.addPrime(i);
            }
        }
        return collector;
    }

    private boolean isPrime(long n) {
        if (n < 2) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        int sqrtN = (int) Math.sqrt(n) + 1;
        for (int i = 6; i <= sqrtN; i += 6)
            if (n % (i - 1) == 0 || n % (i + 1) == 0) return false;
        return true;
    }
}
