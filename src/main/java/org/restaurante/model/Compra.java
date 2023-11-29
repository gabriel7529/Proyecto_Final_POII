package org.restaurante.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_compra")
public class Compra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_compra;
	private String des_compra;
	private int cant_compra;
	
	public Compra(int id_compra, String des_compra, int cant_compra) {
		super();
		this.id_compra = id_compra;
		this.des_compra = des_compra;
		this.cant_compra = cant_compra;
	}
	
	
	public Compra() {
		
	}

	public int getId_compra() {
		return id_compra;
	}

	public void setId_compra(int id_compra) {
		this.id_compra = id_compra;
	}

	public String getDes_compra() {
		return des_compra;
	}

	public void setDes_compra(String des_compra) {
		this.des_compra = des_compra;
	}

	public int getCant_compra() {
		return cant_compra;
	}

	public void setCant_compra(int cant_compra) {
		this.cant_compra = cant_compra;
	}
}
