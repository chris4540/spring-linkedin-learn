package com.chrischlin.lil.learnspring.web;

import com.chrischlin.lil.learnspring.business.ReservationService;
import com.chrischlin.lil.learnspring.utils.DateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/reservations")
public class RoomReservationController {

    private final DateUtils dateUtils;
    private final ReservationService reservationService;

    public RoomReservationController(DateUtils dateUtils, ReservationService reservationService) {
        this.dateUtils = dateUtils;
        this.reservationService = reservationService;
    }

    @GetMapping
    public String getReservation(@RequestParam(value="date", required = false) String dateString,
                                 Model model) {
        // parse the date
        var date = dateUtils.createDateFromDateString(dateString);
        var roomReservations = reservationService.getRoomReservationsForDate(date);
        model.addAttribute("roomReservations", roomReservations);
        // Return the template page name
        return "roomRes";
    }
}
