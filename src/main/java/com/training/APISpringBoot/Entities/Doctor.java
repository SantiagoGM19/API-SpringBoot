package com.training.APISpringBoot.Entities;


import lombok.Data;

import javax.persistence.*;

@Entity(name = "Doctor")
@Table(name = "doctors")
@PrimaryKeyJoinColumn(name = "doctorId")
@Data
public class Doctor extends Person{

    private String specialization;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private Long fkPersonId;
}
