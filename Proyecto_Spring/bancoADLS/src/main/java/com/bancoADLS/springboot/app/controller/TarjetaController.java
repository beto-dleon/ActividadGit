package com.bancoADLS.springboot.app.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bancoADLS.springboot.app.models.dao.ITarjetaDao;
import com.bancoADLS.springboot.app.models.entity.Tarjeta;

@Controller
public class TarjetaController {
	
	@Autowired
	private ITarjetaDao tarjetaDao;
	
	@RequestMapping(value = "/tarjetas-lista", method = RequestMethod.GET)
	public String listar(Model model, Map<String, Object> modelTarjeta) {
		Tarjeta tarjeta = new Tarjeta();
		modelTarjeta.put("tarjeta", tarjeta);
		model.addAttribute("titulo", "Lista de tarjetas");
		model.addAttribute("tarjetas", tarjetaDao.findAll());
		return "tarjetas-lista";
	}
	
	@RequestMapping(value="/buscar-tarjeta-numeroId", method = RequestMethod.POST)
	public String busacarTarjetaPorNumeroOIdCuenta(Tarjeta tarjeta, RedirectAttributes flash) {
		
		if(tarjetaDao.findByNumeroTarjeta(tarjeta.getNumeroTarjeta()) != null) {
			flash.addFlashAttribute("encontrarTarjetas", tarjetaDao.findByNumeroTarjeta(tarjeta.getNumeroTarjeta()));
			flash.addFlashAttribute("mensajeSuccess", "Se encontro la tarjeta con numero "+tarjetaDao.findByNumeroTarjeta(tarjeta.getNumeroTarjeta()).getNumeroTarjeta());
		}else if(!tarjetaDao.findByCuentaId(Long.parseLong(tarjeta.getNumeroTarjeta())).isEmpty()) {
			flash.addFlashAttribute("encontrarTarjetas",tarjetaDao.findByCuentaId(Long.parseLong(tarjeta.getNumeroTarjeta())));
			flash.addFlashAttribute("mensajeSuccess", "Se encontraron "+tarjetaDao.findByCuentaId(Long.parseLong(tarjeta.getNumeroTarjeta())).size() +" tarjetas");
		}else flash.addFlashAttribute("mensajeError", "No se encontró ningun registro");
		
		
		return "redirect:/tarjetas-lista";
	}
	

}
