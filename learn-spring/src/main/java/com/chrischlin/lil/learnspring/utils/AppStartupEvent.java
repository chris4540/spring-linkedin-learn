package com.chrischlin.lil.learnspring.utils;

import com.chrischlin.lil.learnspring.data.GuestRepository;
import com.chrischlin.lil.learnspring.data.ReservationRepository;
import com.chrischlin.lil.learnspring.data.RoomRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {
    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;
    private final ReservationRepository reservationRepository;


    private static final Logger logger = LoggerFactory.getLogger("AppStartupEvent");

    public AppStartupEvent(RoomRepository roomRepo,
                           GuestRepository guestRepo,
                           ReservationRepository resRepo) {
        this.roomRepository = roomRepo;
        this.guestRepository = guestRepo;
        this.reservationRepository = resRepo;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        roomRepository.findAll().forEach(o -> logger.info(o.toString()));
        logger.info("-----------------------");
        guestRepository.findAll().forEach(o -> logger.info(o.toString()));
        logger.info("-----------------------");
        reservationRepository.findAll().forEach(o -> logger.info(o.toString()));
    }
}
