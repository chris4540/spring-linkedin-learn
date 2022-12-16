package com.chrischlin.lil.learnspring.webservices;

import com.chrischlin.lil.learnspring.business.ReservationService;
import com.chrischlin.lil.learnspring.data.Guest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/api/guests")
public class GuestController {
    private final ReservationService reservationService;

    /** Autowired **/
    public GuestController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public List<Guest> all() {
        return reservationService.getAllGuests(true);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Guest add(@RequestBody Guest guest) {
        return reservationService.addGuest(guest);
    }
}
