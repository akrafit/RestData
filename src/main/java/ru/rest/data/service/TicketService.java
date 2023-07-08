package ru.rest.data.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.rest.data.entity.Ticket;
import ru.rest.data.repository.TicketRepository;

@Service
@Transactional
public class TicketService {

    TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }


    public void addTicket(Ticket ticket){
        ticketRepository.addTicket(ticket);
    }
}
