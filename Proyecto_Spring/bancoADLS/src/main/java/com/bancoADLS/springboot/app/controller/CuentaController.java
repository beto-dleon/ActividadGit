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

import com.bancoADLS.springboot.app.errors.DBBancoException;
import com.bancoADLS.springboot.app.models.dao.ICuentaDao;
import com.bancoADLS.springboot.app.models.dao.ITarjetaDao;
import com.bancoADLS.springboot.app.models.entity.Cuenta;

@Controller
@SessionAttributes("cuenta")
public class CuentaController {
	
	@Autowired
	private ICuentaDao cuentaDao;
	
	@Autowired
	private ITarjetaDao tarjetaDao;
	
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
		model.put("titulo", "Llenar los datos de la nueva cuenta");
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
		model.put("titulo", "Modificar la cuenta");
		return "form-cuenta";

	}
	
	@RequestMapping(value = "/form-cuenta", method = RequestMethod.POST)
	public String guardar(@Valid Cuenta cuenta, BindingResult result, Model model, SessionStatus status, RedirectAttributes flash) {
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Llenar la información correctamente");
			model.addAttribute("result", result.hasErrors());
			model.addAttribute("mensaje", "Error al registrar la cuenta, verificar la información");
			return "form-cuenta";
		}else{
			model.addAttribute("result", false);
		}

		model.addAttribute("titulo", "Formulario de la cuenta");
		model.addAttribute("mensaje", "Se guardo correctamente la información");
		
		try {
			cuentaDao.save(cuenta);
		}catch(Exception e) {
			e.printStackTrace();
			flash.addFlashAttribute("mensaje", e.getMessage());
		}
		
		status.setComplete(); 	

		return "redirect:form-cuenta";
	}
	
	@RequestMapping(value = "/eliminar-cuenta/{id}")
	public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes flash) {

		try {
			if (id != null && id > 0) {
				if(tarjetaDao.findByCuentaId(id).isEmpty()) {
					cuentaDao.delete(id);
					flash.addFlashAttribute("mensaje", "Se ha eliminado la cuenta con ID: "+id);
		            flash.addFlashAttribute("clase", "danger"); 
				}else {
					flash.addFlashAttribute("mensaje", "Favor de eliminar las tarjetas relacionadas con la cuenta");
				}
			}
		}catch(DBBancoException e) {
			e.printStackTrace();
			flash.addFlashAttribute("mensaje", e.getMessage());
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/lista";
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
