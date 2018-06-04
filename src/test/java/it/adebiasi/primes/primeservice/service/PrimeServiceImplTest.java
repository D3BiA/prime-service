package it.adebiasi.primes.primeservice.service;

import it.adebiasi.primes.primeservice.Entity.PrimeCollector;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PrimeServiceImplTest {

    private long[] testPrimes = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101};

    @Test
    public void testPrimeRecognition() {
        PrimeService primeService = new PrimeServiceImpl();
        PrimeCollector collector = primeService.getPrimeUpToN(101);
        assertNotNull(collector);
        int i=0;
        for(long prime : testPrimes){
            assertEquals(prime,collector.getPreviousPrimes().get(i++).longValue());
        }
    }
}
