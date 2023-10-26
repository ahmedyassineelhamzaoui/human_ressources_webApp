package com.app.entity;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Equipement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    private Date purchaseDate;
    @Column(nullable=true)
    private Date maintenanceDate;
    private String status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User assignedUser;
    
    @OneToMany(mappedBy = "equipement")
    private List<Order> orders;
    
    
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public Date getMaintenanceDate() {
		return maintenanceDate;
	}

	public void setMaintenanceDate(Date maintenanceDate) {
		this.maintenanceDate = maintenanceDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getAssignedUser() {
		return assignedUser;
	}

	public void setAssignedUser(User assignedUser) {
		this.assignedUser = assignedUser;
	}

	@Override
	public String toString() {
		return "Equipement [id=" + id + ", name=" + name + ", type=" + type + ", purchaseDate=" + purchaseDate
				+ ", maintenanceDate=" + maintenanceDate + ", status=" + status + ", assignedUser=" + assignedUser
				+ "]";
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
    
}