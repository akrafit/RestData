package ru.rest.data.service;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.rest.data.dto.TicketDto;
import ru.rest.data.entity.Ticket;
import ru.rest.data.repository.TicketRepository;

import java.security.SecureRandom;
import java.util.*;

@Service
@Transactional
public class TicketService {
    TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public void addTicket(Ticket ticket) {
        ticketRepository.addTicket(ticket);
    }

    public ResponseEntity<List<TicketDto>> getExaminationTicketList(String sql, int limit) {
        List<Ticket> ticketList = ticketRepository.findTicketsByTypeAndLimit(sql);
        List<Ticket> ticketEntityList = new ArrayList<>();
        if (ticketList.size() > limit) {
            SecureRandom random = new SecureRandom();
            for (int i = 0; i < limit; i++) {
                int randomIndex = random.nextInt(ticketList.size());
                ticketEntityList.add(ticketList.remove(randomIndex));
            }
        }
        else{
            ticketEntityList = ticketList;
        }
        List<TicketDto> tickets = new ArrayList<>();
        for (Ticket ticket : ticketEntityList) {
            tickets.add(new TicketDto(ticket));
        }
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }
}
