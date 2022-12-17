package com.chrischlin.lil.learnspring.web;

import com.chrischlin.lil.learnspring.business.ReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/guests")
public class GuestsController {

    private final ReservationService reservationService;

    public GuestsController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public String getGuests(Model model) {
        model.addAttribute("guests", reservationService.getAllGuests(true));
        return "guests";
    }
}
