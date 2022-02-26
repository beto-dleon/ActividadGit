package com.bancoADLS.springboot.app.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.InitBinder;

import com.bancoADLS.springboot.app.editors.CuentaPropertyEditor;
import com.bancoADLS.springboot.app.errors.DBBancoException;
import com.bancoADLS.springboot.app.models.dao.ICuentaDao;
import com.bancoADLS.springboot.app.models.dao.ITarjetaDao;
import com.bancoADLS.springboot.app.models.entity.Cuenta;
import com.bancoADLS.springboot.app.models.entity.Tarjeta;

@Controller
@SessionAttributes("tarjeta")
public class TarjetaController {
	
	@Autowired
	private ITarjetaDao tarjetaDao;
	
	@Autowired
	private ICuentaDao cuentaDao;
	
	@Autowired
	private CuentaPropertyEditor cuentaEditor;
	
	@InitBinder
	public void InitBinder(WebDataBinder binder) {
		
		binder.registerCustomEditor(Cuenta.class, "cuenta", cuentaEditor);
	}
	
	@RequestMapping(value = "/tarjetas-lista", method = RequestMethod.GET)
	public String listar(Model model, Map<String, Object> modelTarjeta) {
		Tarjeta tarjeta = new Tarjeta();
		modelTarjeta.put("tarjeta", tarjeta);
		model.addAttribute("titulo", "Lista de tarjetas");
		model.addAttribute("tarjetas", tarjetaDao.findAll());
		return "tarjetas-lista";
	}
	
	@RequestMapping(value="/form-tarjeta")
	public String crear(Map<String, Object> model, Model modelList) {
		
		Tarjeta tarjeta = new Tarjeta();
		List<Cuenta> listaCuentas = cuentaDao.findAll();
		model.put("tarjeta", tarjeta);
		
		modelList.addAttribute("listaCuentas", listaCuentas);
		model.put("titulo", "Llenar los datos de la nueva tarjeta");
		
		return "form-tarjeta";
	}
	
	@RequestMapping(value="/form-tarjeta/{id}")
	public String editar(@PathVariable(value="id") Long id, Map<String, Object> model,  Model modelList , RedirectAttributes flash){
		
		try {
			Tarjeta tarjeta = null;
			
			if(id != null && id > 0) {
				tarjeta = tarjetaDao.findOne(id);
			}else {
				flash.addFlashAttribute("mensaje", "Ha ocurrido un problema");
				return "form-tarjeta";
			}
			
			model.put("tarjeta", tarjeta);
			model.put("titulo", "Editar tarjeta");
			modelList.addAttribute("listaCuentas", cuentaDao.findAll());
		}catch(DBBancoException e) {
			e.printStackTrace();
			flash.addFlashAttribute("mensaje", e.getMessage());
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "form-tarjeta";
	}
	
	@RequestMapping(value = "/form-tarjeta", method = RequestMethod.POST)
	public String guardar(@Valid Tarjeta tarjeta, BindingResult result, Model model, SessionStatus status,
			RedirectAttributes flash) {

		if (result.hasErrors()) {
			model.addAttribute("titulo", "Llene correctamente los campos");
			model.addAttribute("result", result.hasErrors());
			model.addAttribute("mensaje", "Error al enviar los datos, por favor escriba correctamente los campos");
			return "form-tarjeta";
		} else {
			model.addAttribute("result", false);
		}
		
		model.addAttribute("titulo", "Formulario de tarjeta");
		model.addAttribute("mensaje", "Se envio la informacion exitosamente");
		try {
			tarjetaDao.save(tarjeta);
		} catch (DBBancoException e) {
			e.printStackTrace();
			flash.addFlashAttribute("mensaje", e.getMessage());
		}
		status.setComplete();

		return "redirect:form-tarjeta";
	}
	
	@RequestMapping(value = "/eliminar-tarjeta/{id}")
	public String eliminar(@PathVariable(value = "id") Long id) {

		if (id != null && id > 0) {
			tarjetaDao.delete(id);
		}
		return "redirect:/tarjetas-lista";
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
