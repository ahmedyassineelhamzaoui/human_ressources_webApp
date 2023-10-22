package com.app.service;

import com.app.repository.EquipmentRepository;

public class EquipmentService {

	private EquipmentRepository equipementRepostiry;
	
	public EquipmentService() {
		this.equipementRepostiry = new EquipmentRepository();
	}
	
}
