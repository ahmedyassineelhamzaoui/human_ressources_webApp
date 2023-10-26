package com.app.entity;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
	
	

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    @Column(unique = true)
	    private Date date_emprunt;
	    private Date date_retour;


	   
	    @ManyToOne
	    @JoinColumn(name = "equipement_id")
	    private Equipement equipement;

	    @ManyToOne
	    @JoinColumn(name = "user_id")
	    private User user;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Date getDate_emprunt() {
			return date_emprunt;
		}

		public void setDate_emprunt(Date date_emprunt) {
			this.date_emprunt = date_emprunt;
		}

		public Date getDate_retour() {
			return date_retour;
		}

		public void setDate_retour(Date date_retour) {
			this.date_retour = date_retour;
		}

		public Equipement getEquipement() {
			return equipement;
		}

		public void setEquipement(Equipement equipement) {
			this.equipement = equipement;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}
		

}
