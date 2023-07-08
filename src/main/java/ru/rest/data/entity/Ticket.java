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
    //private List<String> answers;
    @Column(name = "correct")
    private Integer correctAnswer;
    @Column(name = "actual")
    private Integer actualAnswer;
}
