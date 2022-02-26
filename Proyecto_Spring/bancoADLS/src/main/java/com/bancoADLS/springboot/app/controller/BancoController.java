package com.bancoADLS.springboot.app.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bancoADLS.springboot.app.models.dao.IBancoDao;
import com.bancoADLS.springboot.app.models.entity.Banco;



@Controller
@SessionAttributes("banco")
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
	
	@RequestMapping(value="/form-banco")
	public String crear(Map<String, Object> model) {
		
		Banco banco = new Banco();
		
		model.put("banco", banco);
		
		model.put("titulo", "Nuevo Banco, llenar los datos");
		
		return "form-banco";
		
	}
	
	@RequestMapping(value = "/form-banco/{id}")
	public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model) {
		Banco banco = null;
		if (id > 0) {
			banco = bancoDao.findOne(id);
		} else {
			return "redirect:/bancos-lista";
		}
		model.put("banco", banco);
		model.put("titulo", "Modificar el banco");
		return "form-banco";

	}
	
	@RequestMapping(value = "/form-banco", method = RequestMethod.POST)
	public String guardar(@Valid Banco banco, BindingResult result, Model model, SessionStatus status, RedirectAttributes flash) {
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Llenar la información correctamente");
			model.addAttribute("result", result.hasErrors());
			model.addAttribute("mensaje", "Error al registrar el banco, verificar la información");
			return "form-banco";
		}else{
			model.addAttribute("result", false);
		}

		model.addAttribute("titulo", "Formulario del banco");
		model.addAttribute("mensaje", "Se guardo correctamente la información");
		
		try {
			bancoDao.save(banco);
		}catch(Exception e) {
			e.printStackTrace();
			flash.addFlashAttribute("mensaje", e.getMessage());
		}
		
		status.setComplete(); 	

		return "redirect:form-banco";
	}
	
	@RequestMapping(value = "/eliminar-banco/{id}")
	public String eliminar(@PathVariable(value = "id") Long id) {

		if (id != null && id > 0) {
			bancoDao.delete(id);
		}
		return "redirect:/bancos-lista";
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
