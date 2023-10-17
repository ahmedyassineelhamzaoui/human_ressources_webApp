package com.app.entity;
import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Equipement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    private Date purchaseDate;
    private Date maintenanceDate;
    private String status;

    @ManyToOne
    @JoinColumn(name = "assigned_user_id")
    private User assignedUser;
}