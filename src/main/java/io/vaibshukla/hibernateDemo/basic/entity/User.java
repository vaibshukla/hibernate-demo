package io.vaibshukla.hibernateDemo.basic.entity;

import lombok.*;

@Builder
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Long id;

    private String firstName;

    private String lastName;

}
