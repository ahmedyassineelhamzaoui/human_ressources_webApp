package com.app.entity;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class User {
	
	

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String username;
	    private String password;
	    private String firstName;
	    private String lastName;
	    private String email;
	    @Column(nullable=true)
	    private String position;
	    @Column(nullable=true)
	    private Date hireDate;


	   
	    @ManyToOne
	    @JoinColumn(name = "department_id")
	    private Departement department;

	    @ManyToOne
	    @JoinColumn(name = "role_id")
	    private Role role;

	    @OneToMany(mappedBy = "assignedUser")
	    private List<Equipement> assignedEquipment;

	    @OneToMany(mappedBy = "assignedUser")
	    private List<Task> assignedTasks;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPosition() {
			return position;
		}

		public void setPosition(String position) {
			this.position = position;
		}

		public Date getHireDate() {
			return hireDate;
		}

		public void setHireDate(Date hireDate) {
			this.hireDate = hireDate;
		}

		public List<Equipement> getAssignedEquipment() {
			return assignedEquipment;
		}

		public void setAssignedEquipment(List<Equipement> assignedEquipment) {
			this.assignedEquipment = assignedEquipment;
		}

		public Departement getDepartment() {
			return department;
		}

		public void setDepartment(Departement department) {
			this.department = department;
		}

		public List<Task> getAssignedTasks() {
			return assignedTasks;
		}

		public void setAssignedTasks(List<Task> assignedTasks) {
			this.assignedTasks = assignedTasks;
		}

		public Role getRole() {
			return role;
		}

		public void setRole(Role role) {
			this.role = role;
		}

}