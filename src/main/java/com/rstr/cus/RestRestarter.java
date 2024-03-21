package com.rstr.cus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.devtools.restart.Restarter;
import org.springframework.stereotype.Component;

@Component
public class RestRestarter {
    Logger logger = LoggerFactory.getLogger(getClass());
    public void restart() {

        Restarter targetRestarter = Restarter.getInstance();
        // System.out.println(targetRestarter);

        // adding jar
        logger.info("** adding jar");
        targetRestarter.restart(); // restart the application when added jar
    }
}
