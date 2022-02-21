package com.bancoADLS.springboot.app.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bancoADLS.springboot.app.models.dao.IBancoDao;
import com.bancoADLS.springboot.app.models.entity.Banco;



@Controller
public class BancoController {
	
	@Autowired
	private IBancoDao bancoDao;
	
	@RequestMapping(value="/bancos-lista", method = RequestMethod.GET)
	public String listar(Model model, Map<String, Object> modelBanco) {
		Banco banco = new Banco();
		modelBanco.put("banco", banco);
		model.addAttribute("titulo", "Lista de bancos");
		model.addAttribute("bancos", bancoDao.findAll());
		return "bancos-lista";
	}
	
	@RequestMapping(value = "/buscar-banco-por-id", method = RequestMethod.POST)
	public String buscarPorId(Banco banco, RedirectAttributes flash) {

		if (bancoDao.findOne(banco.getIdBanco()) != null) {
			flash.addFlashAttribute("encontrarBancos", bancoDao.findOne(banco.getIdBanco()));
			flash.addFlashAttribute("mensajeSuccess", "Se encontró el banco solicitado");
		} else
			flash.addFlashAttribute("mensajeError", "No se encontró el banco solicitado");

		return "redirect:/bancos-lista";
	}

}
