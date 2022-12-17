package com.chrischlin.lil.learnspring.webservices;

import com.chrischlin.lil.learnspring.business.ReservationService;
import com.chrischlin.lil.learnspring.data.Room;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping(value="/api/rooms")
public class RoomController {
    private final ReservationService reservationService;

    /** Autowired **/
    public RoomController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public List<Room> all() {
        return reservationService.getAllRooms(true);
    }
}
