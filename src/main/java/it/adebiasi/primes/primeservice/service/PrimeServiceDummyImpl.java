package it.adebiasi.primes.primeservice.service;

import it.adebiasi.primes.primeservice.Entity.PrimeCollector;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("dummy")
@Service
public class PrimeServiceDummyImpl implements PrimeService {

    @Override
    public PrimeCollector getPrimeUpToN(long n) {
        return new PrimeCollector(n);
    }
}
