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
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bancoADLS.springboot.app.models.dao.ICuentaDao;
import com.bancoADLS.springboot.app.models.entity.Cuenta;

@Controller
public class CuentaController {
	
	@Autowired
	private ICuentaDao cuentaDao;
	
	@RequestMapping(value = "/lista", method = RequestMethod.GET)
	public String cuentaLista(Model model, Map<String, Object> modelCuenta) {
		Cuenta cuenta = new Cuenta();
		modelCuenta.put("cuenta", cuenta);
		model.addAttribute("titulo", "Lista de cuentas");
		model.addAttribute("cuentas", cuentaDao.findAll());

		return "lista";
	}
	
	@RequestMapping(value = "/form-cuenta")
	public String crear(Map<String, Object> model) {
		Cuenta cuenta = new Cuenta();
		model.put("cuenta", cuenta);
		model.put("titulo", "Nueva cuenta, favor de llenar los datos");
		return "form-cuenta";
	}
	
	@RequestMapping(value = "/form-cuenta/{id}")
	public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model) {
		Cuenta cuenta = null;
		if (id > 0) {
			cuenta = cuentaDao.findOne(id);
		} else {
			return "redirect:/lista";
		}
		model.put("cuenta", cuenta);
		model.put("titulo", "Favor de editar la cuenta");
		return "form-cuenta";

	}
	
	@RequestMapping(value = "form-cuenta", method = RequestMethod.POST)
	public String guardar(@Valid Cuenta cuenta, BindingResult result, Model model, SessionStatus status, RedirectAttributes flash) {
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de la cuenta");
			model.addAttribute("result", result.hasErrors());
			model.addAttribute("mensaje", "Error al registrar la cuenta");
			return "form-cuenta";
		} else {
			model.addAttribute("result", false);
			model.addAttribute("errList", "");
		}

		flash.addAttribute("completeMsj", "Se ha guardado correctamente");
		cuentaDao.save(cuenta);
		status.setComplete(); 	

		return "redirect:form-cuenta";
	}
	
	@RequestMapping(value = "/buscar-por-id", method = RequestMethod.POST)
	public String buscarPorId(Cuenta cuenta, RedirectAttributes flash) {

		if (cuentaDao.findOne(cuenta.getIdCuenta()) != null) {
			flash.addFlashAttribute("encontrarCuentas", cuentaDao.findOne(cuenta.getIdCuenta()));
			flash.addFlashAttribute("mensajeSuccess", "Se encontró la cuenta solicitada");
		} else
			flash.addFlashAttribute("mensajeError", "No se encontró la cuenta solicitada");

		return "redirect:/lista";
	}

}
