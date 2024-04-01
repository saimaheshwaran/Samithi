package org.sai.samithi.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Builder
@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
@Entity
public class Home {

    @Id
    @SequenceGenerator(name="home_seq_gen", sequenceName = "home_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "home_seq_gen")
    @Setter(AccessLevel.NONE)
    private Integer id;

    @Column(nullable = false)
    private String pairKey;

    @Column(nullable = false)
    private String pairValue;

}
