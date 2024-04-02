package org.sai.samithi.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Builder
@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
@Entity
public class Contact {

    @Id
    @SequenceGenerator(name="contact_seq_gen", sequenceName = "contact_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contact_seq_gen")
    @Setter(AccessLevel.NONE)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String telephone;

    @Column(nullable = false)
    private String subject;

    @Column(nullable = false)
    private String message;

    @CreatedDate
    private Date createdAt;

}
