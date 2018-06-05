package it.adebiasi.primes.primeservice.controller;

import it.adebiasi.primes.primeservice.Entity.PrimeCollector;
import it.adebiasi.primes.primeservice.service.PrimeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PrimeControllerTest {

    @InjectMocks
    private PrimeController controller;

    @Mock
    private PrimeService primeService;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testPrimeNumbersJsonCall() throws Exception {
        long initials = 5;
        PrimeCollector collector = new PrimeCollector(initials);
        collector.addPrime(2);
        collector.addPrime(3);

        when(primeService.getPrimeUpToN(initials)).thenReturn(collector);
        mockMvc.perform(get("/" + initials).accept(MediaType.APPLICATION_JSON)).andExpect(jsonPath("$.Initial").value(initials))
                .andExpect(jsonPath("Primes").value("[2,3]")).andExpect(status().isOk());
    }

    @Test
    public void testPrimeNumbersXmlCall() throws Exception {
        long initials = 5;
        PrimeCollector collector = new PrimeCollector(initials);
        collector.addPrime(2);
        collector.addPrime(3);

        when(primeService.getPrimeUpToN(initials)).thenReturn(collector);
        mockMvc.perform(get("/" + initials).accept(MediaType.APPLICATION_XML))
                .andExpect(xpath("PrimeCollector/Initial").number(5d))
                .andExpect(xpath("PrimeCollector/Primes").string("[2,3]"))
                .andExpect(status().isOk());
    }
}
