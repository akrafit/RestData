package ru.rest.data.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.rest.data.dto.Dto;
import ru.rest.data.dto.TicketDto;
import ru.rest.data.entity.Ticket;
import ru.rest.data.service.TicketService;

import java.util.List;

@RestController
public class RestApiController {
    private final TicketService ticketService;

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

    @GetMapping("tickets")
    public ResponseEntity<List<TicketDto>> getExaminationTicketDto() {
        return ticketService.getExaminationTicketList("spring", 10);
    }
}
