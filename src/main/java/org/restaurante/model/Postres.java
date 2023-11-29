package org.restaurante.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_postres")
public class Postres {

	@Id
	private String id_postres;
	private String des_postres;
	private double pre_postres;
	private int est_postres;
	private String imagen; 
	
	public Postres(String id_postres, String des_postres, double pre_postres, int est_postres, String imagen) {
		super();
		this.id_postres = id_postres;
		this.des_postres = des_postres;
		this.pre_postres = pre_postres;
		this.est_postres = est_postres;
		this.imagen = imagen;
	}
	
	public Postres() {
		
	}

	public String getId_postres() {
		return id_postres;
	}

	public void setId_postres(String id_postres) {
		this.id_postres = id_postres;
	}

	public String getDes_postres() {
		return des_postres;
	}

	public void setDes_postres(String des_postres) {
		this.des_postres = des_postres;
	}

	public double getPre_postres() {
		return pre_postres;
	}

	public void setPre_postres(double pre_postres) {
		this.pre_postres = pre_postres;
	}

	public int getEst_postres() {
		return est_postres;
	}

	public void setEst_postres(int est_postres) {
		this.est_postres = est_postres;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	
}
