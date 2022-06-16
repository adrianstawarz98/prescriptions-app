package com.thesis.prescriptionsapp.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "doctors")
public class Doctor
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @OneToMany
    @JoinColumn(name = "doctor")
    private List<Prescription> prescriptions;

    private String name;
}
