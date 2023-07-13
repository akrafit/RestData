package ru.rest.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.rest.data.entity.Ticket;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TicketDto {
    private Long id;
    private String title;
    private String image;
    private List<String> answers;
    private Integer correctAnswer;
    private Integer actualAnswer;
    public TicketDto(Ticket ticket) {
        this.id = ticket.getId();
        this.title = ticket.getTitle();
        this.image = ticket.getImage();
        this.correctAnswer = ticket.getCorrectAnswer();
        List<String> answers = new ArrayList<>();
        answers.add(ticket.getAnswerOne());
        answers.add(ticket.getAnswerTwo());
        answers.add(ticket.getAnswerThree());
        answers.add(ticket.getAnswerFour());
        this.answers = answers;
    }
}