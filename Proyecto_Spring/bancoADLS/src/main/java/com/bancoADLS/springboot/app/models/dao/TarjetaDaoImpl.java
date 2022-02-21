package com.bancoADLS.springboot.app.models.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bancoADLS.springboot.app.models.entity.Tarjeta;

@Repository
public class TarjetaDaoImpl implements ITarjetaDao{
	
	@PersistenceContext
	private EntityManager em;
	
	

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<Tarjeta> findAll() {
		return em.createQuery("from Tarjeta").getResultList();
	}

	
	@Override
	@Transactional
	public void save(Tarjeta tarjeta) {
		if(tarjeta.getIdTarjeta() != null && tarjeta.getIdTarjeta() > 0) {
			em.merge(tarjeta);
		}else {
			em.persist(tarjeta);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Tarjeta findOne(Long id) {
		return em.find(Tarjeta.class, id);
	}
		
	@Override
	@Transactional(readOnly = true)
	public List<Tarjeta> findByCuentaId(Long cuentaId) {
		List<Tarjeta> tarjetas = new ArrayList<Tarjeta>();
		for(Tarjeta tarjeta : this.findAll()) {
			if(tarjeta.getCuenta().getIdCuenta() == cuentaId) {
				tarjetas.add(tarjeta);
			}
		}
		return tarjetas;
	}
	
	@Override
	@Transactional(readOnly=true)
	public Tarjeta findByNumeroTarjeta(String numero_tarjeta) {
		
		List<Tarjeta> listaTarjetas = this.findAll();
		Tarjeta tarjetaResult = null;
		
		for(Tarjeta tarjeta: listaTarjetas) {
			if(tarjeta.getNumeroTarjeta().equals(numero_tarjeta)) {
				tarjetaResult = tarjeta;
			}
		}
		
		return tarjetaResult;
	}

	@Override
	@Transactional
	public void delete(Long id) {
		em.remove(findOne(id));
	}

}
