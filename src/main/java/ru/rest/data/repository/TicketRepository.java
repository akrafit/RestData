package ru.rest.data.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.rest.data.entity.Ticket;


@Repository
public class TicketRepository {

    private final SessionFactory sessionFactory;

    public TicketRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Ticket addTicket(Ticket ticket) {
        Session session = sessionFactory.openSession();
        session.save(ticket);
        return new Ticket();
    }
}
