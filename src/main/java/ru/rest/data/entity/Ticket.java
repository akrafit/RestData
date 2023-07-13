package ru.rest.data.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "Ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "image")
    private String image;
    @Column(name = "answer_1")
    private String answerOne;
    @Column(name = "answer_2")
    private String answerTwo;
    @Column(name = "answer_3")
    private String answerThree;
    @Column(name = "answer_4")
    private String answerFour;
    @Column(name = "correct")
    private Integer correctAnswer;
    @Column(name = "actual")
    private Integer actualAnswer;
    @Column(name = "type")
    private String type;
}
