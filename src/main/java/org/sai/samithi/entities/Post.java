package org.sai.samithi.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Builder
@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
@Entity
public class Post {

    @Id
    @SequenceGenerator(name="post_seq_gen", sequenceName = "post_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_seq_gen")
    @Setter(AccessLevel.NONE)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Date publishedOn;

    @Column(nullable = false)
    private String url;

}

