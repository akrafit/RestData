package ru.rest.data.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ru.rest.data.entity.Ticket;

import java.util.List;


@Repository
public class TicketRepository {

    private final SessionFactory sessionFactory;

    public TicketRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addTicket(Ticket ticket) {
        Session session = sessionFactory.openSession();
        session.save(ticket);
    }

    public List<Ticket> findTicketsByTypeAndLimit(String typeQuestion, int limit) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Ticket where type = :type");
        query.setParameter("type", typeQuestion);
        query.setMaxResults(limit);
        List<Ticket> list = query.list();
        return list;
    }
}
