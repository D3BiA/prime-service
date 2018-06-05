package it.adebiasi.primes.primeservice.service;

import it.adebiasi.primes.primeservice.Entity.PrimeCollector;
import it.adebiasi.primes.primeservice.exception.NumberToBigException;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest
public class PrimeServiceImplTest {

    private long[] testPrimes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};

    private PrimeServiceImpl primeService;

    @Before
    public void tearUp() {
        primeService = new PrimeServiceImpl();
        ReflectionTestUtils.setField(primeService, "maxAllowed", 30000000L);
    }

    @Test
    public void testPrimeRecognition() throws NumberToBigException {
        PrimeCollector collector = primeService.getPrimeUpToN(101);
        assertNotNull(collector);
        int i = 0;
        for (long prime : testPrimes) {
            assertEquals(prime, collector.getPrimes().get(i++).longValue());
        }
    }

    @Test
    public void testNegativeNumber() throws NumberToBigException {
        //It doesn't exists a negative prime
        PrimeCollector collector = primeService.getPrimeUpToN(-1);
        assertEquals(-1, collector.getInitial());
        assertEquals(0, collector.getPrimes().size());
    }

    @Test(expected = NumberToBigException.class)
    public void testBigNumberErrorCondition() throws NumberToBigException {
        PrimeCollector collector = primeService.getPrimeUpToN(999999999999L);
    }
}
