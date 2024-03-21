package com.rstr.cus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;

public class CusRestarApplicationListener implements ApplicationListener<ApplicationEvent>, Ordered {
    Logger logger = LoggerFactory.getLogger(getClass());
    private int order = Ordered.HIGHEST_PRECEDENCE;

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        logger.info("## cus-application-listener caught event: {}", event.getClass().getName());
        if (event instanceof ApplicationStartingEvent startingEvent) {
            staringEvent(startingEvent);
        }
        if (event instanceof ApplicationPreparedEvent preparedEvent) {
            preparedEvent(preparedEvent);
        }

        if (event instanceof ApplicationReadyEvent || event instanceof ApplicationFailedEvent) {
            // do something...
        }

        if (event instanceof ApplicationFailedEvent failedEvent) {
            failedEvent(failedEvent);
        }

    }
    private void staringEvent(ApplicationStartingEvent startingEvent) {
        if (!CusRestarter.INITIALIZED) {
            String[] args = startingEvent.getArgs();
            CusRestarter.initialize(args);
        }
    }

    private void preparedEvent(ApplicationPreparedEvent preparedEvent) {}

    private void failedEvent(ApplicationFailedEvent failedEvent) {}

    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public int getOrder() {
        return this.order;
    }
}
