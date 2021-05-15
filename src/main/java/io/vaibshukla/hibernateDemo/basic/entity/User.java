package io.vaibshukla.hibernateDemo.basic.entity;

import lombok.*;

import javax.persistence.*;

@Builder
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

}
