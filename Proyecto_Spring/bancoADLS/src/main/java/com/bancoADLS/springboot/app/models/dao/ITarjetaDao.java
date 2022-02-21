package com.bancoADLS.springboot.app.models.dao;

import java.util.List;

import com.bancoADLS.springboot.app.models.entity.Tarjeta;

public interface ITarjetaDao {
	
	
	public List<Tarjeta> findAll();

	
	public void save(Tarjeta tarjeta);

	
	public Tarjeta findOne(Long id);
	
	public List<Tarjeta> findByCuentaId(Long cuentaId);

	public Tarjeta findByNumeroTarjeta(String numero_tarjeta);

	
	public void delete(Long id);

}
