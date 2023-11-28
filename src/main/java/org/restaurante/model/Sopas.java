package org.restaurante.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_sopas")
public class Sopas {

	@Id
	private String id_sopa;
	private String des_sopa;
	private double pre_sopa;
	private int est_sopa;
	public Sopas(String id_sopa, String des_sopa, double pre_sopa, int est_sopa) {
		super();
		this.id_sopa = id_sopa;
		this.des_sopa = des_sopa;
		this.pre_sopa = pre_sopa;
		this.est_sopa = est_sopa;
	}
	
	public Sopas() {
		
	}

	public String getId_sopa() {
		return id_sopa;
	}

	public void setId_sopa(String id_sopa) {
		this.id_sopa = id_sopa;
	}

	public String getDes_sopa() {
		return des_sopa;
	}

	public void setDes_sopa(String des_sopa) {
		this.des_sopa = des_sopa;
	}

	public double getPre_sopa() {
		return pre_sopa;
	}

	public void setPre_sopa(double pre_sopa) {
		this.pre_sopa = pre_sopa;
	}

	public int getEst_sopa() {
		return est_sopa;
	}

	public void setEst_sopa(int est_sopa) {
		this.est_sopa = est_sopa;
	}
	
	
}
