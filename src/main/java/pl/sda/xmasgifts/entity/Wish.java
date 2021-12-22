package pl.sda.xmasgifts.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Wish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String description;

    private boolean fulfill;

    @ManyToOne
    private Person owner;

    @ManyToOne
    private Person gifter;
}
