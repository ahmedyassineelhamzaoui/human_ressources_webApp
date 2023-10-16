package com.app.entity;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String headOfDepartment;

    @OneToMany(mappedBy = "department")
    private List<User> users;

	public Departement() {
		// TODO Auto-generated constructor stub
	}

	public Departement(String name, String description, String headOfDepartment, List<User> users) {
		super();
		this.name = name;
		this.description = description;
		this.headOfDepartment = headOfDepartment;
		this.users = users;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHeadOfDepartment() {
		return headOfDepartment;
	}

	public void setHeadOfDepartment(String headOfDepartment) {
		this.headOfDepartment = headOfDepartment;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Departement [id=" + id + ", name=" + name + ", description=" + description + ", headOfDepartment="
				+ headOfDepartment + ", employees=" + users + "]";
	}

}