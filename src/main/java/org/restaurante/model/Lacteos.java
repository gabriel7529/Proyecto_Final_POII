package org.restaurante.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "tb_lacteos")
public class Lacteos {

	@Id
	private String id_lacteo;
	private String des_lacteo;
	private double pre_lacteo;
	private int est_lacteo;
	private String imagen;
	
	public Lacteos(String id_lacteo, String des_lacteo, double pre_lacteo, int est_lacteo, String imagen) {
		super();
		this.id_lacteo = id_lacteo;
		this.des_lacteo = des_lacteo;
		this.pre_lacteo = pre_lacteo;
		this.est_lacteo = est_lacteo;
		this.imagen = imagen;
	}
	
	public Lacteos() {
		
	}

	public String getId_lacteo() {
		return id_lacteo;
	}

	public void setId_lacteo(String id_lacteo) {
		this.id_lacteo = id_lacteo;
	}

	public String getDes_lacteo() {
		return des_lacteo;
	}

	public void setDes_lacteo(String des_lacteo) {
		this.des_lacteo = des_lacteo;
	}

	public double getPre_lacteo() {
		return pre_lacteo;
	}

	public void setPre_lacteo(double pre_lacteo) {
		this.pre_lacteo = pre_lacteo;
	}

	public int getEst_lacteo() {
		return est_lacteo;
	}

	public void setEst_lacteo(int est_lacteo) {
		this.est_lacteo = est_lacteo;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	
}
