package com.bancoADLS.springboot.app.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "bancos")
public class Banco implements Serializable{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7018087598005270544L;


	@Column(name = "nombre")
	@NotEmpty
	private String nombre;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idBanco;
	
	@Column(name = "ubicación")
	@NotEmpty
	private String ubicacion;
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Long getIdBanco() {
		return idBanco;
	}
	public void setIdBanco(Long idBanco) {
		this.idBanco = idBanco;
	}
	
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

}
