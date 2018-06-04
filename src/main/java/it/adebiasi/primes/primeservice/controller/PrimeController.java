package it.adebiasi.primes.primeservice.controller;

import it.adebiasi.primes.primeservice.Entity.PrimeCollector;
import it.adebiasi.primes.primeservice.service.PrimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

@RestController
public class PrimeController {

    private PrimeService service;

    @Autowired
    public PrimeController(PrimeService service) {
        this.service = service;
        Assert.notNull(service, "The PrimeService must not be null");
    }

    @RequestMapping(path = "/{number}", method = RequestMethod.GET)
    @ResponseBody
    public PrimeCollector getPrimeUpToN(@PathVariable long number) {
        return service.getPrimeUpToN(number);
    }
}
