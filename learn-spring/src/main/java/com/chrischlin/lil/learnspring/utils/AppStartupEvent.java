package com.chrischlin.lil.learnspring.utils;

import com.chrischlin.lil.learnspring.data.Room;
import com.chrischlin.lil.learnspring.data.RoomRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {
    private final RoomRepository roomRepository;

    private static final Logger logger = LoggerFactory.getLogger("AppStartupEvent");

    public AppStartupEvent(RoomRepository repository) {
        this.roomRepository = repository;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Iterable<Room> rooms = roomRepository.findAll();
        rooms.forEach(s -> logger.info(s.toString()));
    }
}
