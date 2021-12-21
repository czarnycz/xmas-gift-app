package pl.sda.xmasgifts.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;

    private String username;

    private String email;

    @OneToMany
    private Set<Wish> wishes;

    @OneToMany
    private Set<Wish> gifts;
}
