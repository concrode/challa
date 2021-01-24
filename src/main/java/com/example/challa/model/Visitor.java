package com.example.challa.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Document(collation = "Visitor")
public class Visitor {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private Date checkInTime;

    public Visitor(String firstName, String lastName, String phoneNumber, String email, Date checkInTime) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.checkInTime = checkInTime;
    }


}
