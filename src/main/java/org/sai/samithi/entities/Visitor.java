package org.sai.samithi.entities;

import lombok.*;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Builder
@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
@Entity
public class Visitor {

    @Id
    @SequenceGenerator(name="visitor_seq_gen", sequenceName = "visitor_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "visitor_seq_gen")
    @Setter(AccessLevel.NONE)
    private Long id;

    private String ipAddress;

    private String userAgent;

    private String url;

    @CreatedDate
    private LocalDateTime visitTime;

}
