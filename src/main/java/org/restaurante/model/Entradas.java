package org.restaurante.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "tb_entrada")

public class Entradas {
	
	@Id
	private String id_entrada;
	private String des_entrada;
	private double pre_entrada;
	private int est_entrada;
	
	public Entradas(String id_entrada, String des_entrada, double pre_entrada, int est_entrada) {
		super();
		this.id_entrada = id_entrada;
		this.des_entrada = des_entrada;
		this.pre_entrada = pre_entrada;
		this.est_entrada = est_entrada;
	}
	
	public Entradas() {
		
	}
	
	public String getId_entrada() {
		return id_entrada;
	}
	public void setId_entrada(String id_entrada) {
		this.id_entrada = id_entrada;
	}
	public String getDes_entrada() {
		return des_entrada;
	}
	public void setDes_entrada(String des_entrada) {
		this.des_entrada = des_entrada;
	}
	public double getPre_entrada() {
		return pre_entrada;
	}
	public void setPre_entrada(double pre_entrada) {
		this.pre_entrada = pre_entrada;
	}
	public int getEst_entrada() {
		return est_entrada;
	}
	public void setEst_entrada(int est_entrada) {
		this.est_entrada = est_entrada;
	}
	
	
	
}
