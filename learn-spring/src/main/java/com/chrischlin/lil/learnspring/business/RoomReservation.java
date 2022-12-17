package com.chrischlin.lil.learnspring.business;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * This is the PTO of the combination of the data models. This is used as the view
 * of the web application
 */
@Getter
@Setter
@ToString
public class RoomReservation {
    private long roomId;
    private long guestId;
    private String roomName;
    private String roomNumber;
    private String firstName;
    private String lastName;
    private Date date;
}
