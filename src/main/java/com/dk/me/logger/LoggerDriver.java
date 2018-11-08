package com.dk.me.logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.dk.me.util.Fibonacci;

import java.util.concurrent.TimeUnit;

public class LoggerDriver {

    private final static Logger logger = LogManager.getLogger();
    private final static Fibonacci fibonacci = new Fibonacci(20);

    public static void main(String args[]) {
        logger.trace("Enter main");

        while(true) {
            logger.trace("Generating random number");
            int n = fibonacci.randomNumber();
            logger.info("The fibonacci number at position {} is {}", n + 1, fibonacci.getFibonacciAt(n));
            try {
                logger.trace("Sleeping for  millis");
                TimeUnit.SECONDS.sleep(10);
                logger.trace("Finished sleeping");
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
        }
    }
}
