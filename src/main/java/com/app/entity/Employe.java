package com.app.entity;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String position;
    private Date hireDate;


    @OneToMany(mappedBy = "assignedEmployee")
    private List<Equipement> assignedEquipment;

    @ManyToOne
    private Departement department;

    @OneToMany(mappedBy = "assignedEmployee")
    private List<Task> assignedTasks;


}
