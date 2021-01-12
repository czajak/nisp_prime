package com.example.demo.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AverageApiController {

    private static Logger LOG = LoggerFactory.getLogger(AverageApiController.class);

    @GetMapping("api/math/digits/{digit}")
    public ResponseEntity<Map<String, Boolean>> getAverage(@PathVariable("digit") String digit) {
        LOG.info("digits inside server, {}", digit);

        return ResponseEntity.ok(calculatePrime(digit));
    }

    private Map<String, Boolean> calculatePrime(String digit) {
        Map<String, Boolean> result = new HashMap<>();
        result.put("isPrime", isPrime(Integer.parseInt(digit)));
        return result;
    }

    static boolean isPrime(int n)
    {
        if (n <= 1)
            return false;

        else if (n == 2)
            return true;

        else if (n % 2 == 0)
            return false;

        for (int i = 3; i <= Math.sqrt(n); i += 2)
        {
            if (n % i == 0)
                return false;
        }
        return true;
    }

}