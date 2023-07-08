package ru.rest.data.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.rest.data.dto.Dto;
import ru.rest.data.entity.Ticket;
import ru.rest.data.service.TicketService;

@RestController
public class RestApiController {
    private TicketService ticketService;

    public RestApiController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping("/hello")
    public ResponseEntity<Dto> hello() {
        Ticket ticket = new Ticket();
        ticket.setTitle("new");
        ticketService.addTicket(ticket);

        Dto dto = new Dto();
        dto.setName(ticket.getTitle());
        return new ResponseEntity<>(dto, HttpStatus.ACCEPTED);
    }
}
