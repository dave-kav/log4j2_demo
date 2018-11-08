package com.dk.me.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

public class Fibonacci {

    private static final Logger logger = LogManager.getLogger();
    private Random r;
    private int limit;

    public Fibonacci(int limit) {
        logger.debug("Creating new util.Fibonacci object");
        this.limit = limit;
        logger.debug("Creating new util.Fibonacci class member Random object");
        r = new Random();
    }

    public int randomNumber() {
        logger.debug("Generating random number");
        return r.nextInt(limit);
    }

    public int getFibonacciAt(int index) {
        logger.debug("Generating fibonacci number at sequence index {}",  index + 1);
        return fibonacci(index);
    }


    private int fibonacci(int n) {
        if (n <= 1) {
            logger.trace("Reached fibonacci base case");
            return n;
        }
        else {
            logger.trace("Calling fibonacci recursively");
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}
