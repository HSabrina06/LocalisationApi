package com.api.localisation.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Localisation {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Column
    @NonNull
    private String name;
    @Column
    @NonNull
    private String lan;
    @Column
    @NonNull
    private String lng;
    @NonNull
    @Enumerated(EnumType.ORDINAL)
    private TypeState type;
}
