package com.app.service;

import java.util.ArrayList;
import java.util.List;

import com.app.entity.Equipement;
import com.app.entity.Order;
import com.app.repository.EquipmentRepository;

public class EquipmentService {

	private EquipmentRepository equipementRepostiry;
	
	public EquipmentService() {
		this.equipementRepostiry = new EquipmentRepository();
	}
	public void SaveEquipment(Equipement equipement) {
		equipementRepostiry.AddEquipment(equipement);
	}
	public List<Equipement> getAllEquipment(){
		return equipementRepostiry.getAllEquipment();
	}
	public Equipement findById(long id) {
		return equipementRepostiry.findById(id);
	}
	public void deleteEquipment(Equipement equipement) {
		List<Order> ordersCopy = new ArrayList<>(equipement.getOrders());
		for(Order o:ordersCopy) {
			o.removeEquipment();
		}
		equipementRepostiry.deleteEquipment(equipement);
	}
	public Equipement updateEquipment(Equipement equipement) {
		return equipementRepostiry.updateEquipement(equipement);
	}
}

