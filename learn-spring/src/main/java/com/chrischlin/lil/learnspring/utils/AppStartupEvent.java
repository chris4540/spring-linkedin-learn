package com.chrischlin.lil.learnspring.utils;

import com.chrischlin.lil.learnspring.business.ReservationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {
    private final ReservationService reservationService;
    private final DateUtils dateUtils;

    private static final Logger logger = LoggerFactory.getLogger("AppStartupEvent");

    public AppStartupEvent(ReservationService reservationService, DateUtils dateUtils) {
        this.reservationService = reservationService;
        this.dateUtils = dateUtils;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Date date = dateUtils.createDateFromDateString("2022-01-01");
        var reservations =
            reservationService.getRoomReservationsForDate(date);
        reservations.forEach(o -> logger.info(o.toString()));
    }
}
