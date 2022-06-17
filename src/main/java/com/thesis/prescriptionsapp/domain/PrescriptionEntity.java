package com.thesis.prescriptionsapp.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "prescriptions")
public class PrescriptionEntity
{
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prescriptionId;
    @Column(name = "name", nullable = false)
    private String prescriptionName;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date prescriptionCreatedAt;
    private String prescriptionDoctor;
    private String prescriptionUser;
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private AppUser user;
//    @ManyToOne
//    @JoinColumn(name = "doctor_id")
//    private Doctor doctor;


    public Long getPrescriptionId()
    {
        return prescriptionId;
    }

    public void setPrescriptionId(Long prescriptionId)
    {
        this.prescriptionId = prescriptionId;
    }

    public String getPrescriptionName()
    {
        return prescriptionName;
    }

    public void setPrescriptionName(String prescriptionName)
    {
        this.prescriptionName = prescriptionName;
    }

    public Date getPrescriptionCreatedAt()
    {
        return prescriptionCreatedAt;
    }

    public void setPrescriptionCreatedAt(Date prescriptionCreatedAt)
    {
        this.prescriptionCreatedAt = prescriptionCreatedAt;
    }

    public String getPrescriptionDoctor()
    {
        return prescriptionDoctor;
    }

    public void setPrescriptionDoctor(String prescriptionDoctor)
    {
        this.prescriptionDoctor = prescriptionDoctor;
    }

    public String getPrescriptionUser()
    {
        return prescriptionUser;
    }

    public void setPrescriptionUser(String prescriptionUser)
    {
        this.prescriptionUser = prescriptionUser;
    }

    @PrePersist
    void createdAt()
    {
        this.prescriptionCreatedAt = new Date();
    }
}
