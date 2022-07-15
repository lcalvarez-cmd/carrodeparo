package com.hospitalsanjose.gov.co.controllers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hospitalsanjose.gov.co.model.Cardio_vas_cambio;
import com.hospitalsanjose.gov.co.model.Cardio_vas_lote;
import com.hospitalsanjose.gov.co.model.Cardio_vas_medicamento;
import com.hospitalsanjose.gov.co.model.Estado;
import com.hospitalsanjose.gov.co.service.ICardio_vas_loteService;
import com.hospitalsanjose.gov.co.service.ICardio_vas_medicamentoService;
import com.hospitalsanjose.gov.co.service.IEstadoService;

@Controller
@RequestMapping("/cardiovascular")
public class CardioVascularController {
	
	@Autowired
	private ICardio_vas_loteService loteService;
	
	@Autowired
	private ICardio_vas_medicamentoService medicamentoService;
	
	@Autowired
	private IEstadoService estadoService;
	
	@GetMapping("/formMedicamentos")
	public String cariovasmedicamentos(Cardio_vas_lote lote, Model modelo) {
		modelo.addAttribute("title","Formulario Medicamentos");
		return "cardiovascular/formCardMedicamentos";
	}
	
	@GetMapping("/formDispoMedicos")
	public String cardiodispomedicos(Model modelo) {
		modelo.addAttribute("title","Formulario Insumos");
		return "cardiovascular/formCardDispoMedicos";
	}
	
	@GetMapping("/datosmedicamentos")
	public String cardiodatosMedicamentos(Model modelo) {
		modelo.addAttribute("title","Datos Medicamentos");
		modelo.addAttribute("lotes", loteService.buscarTodos());

		for (Cardio_vas_lote  i : loteService.buscarTodos()) {
			try {
				
				Calendar fechaAct = new GregorianCalendar();
				Calendar fechaVen = new GregorianCalendar();
				fechaAct.setTime(i.getFecha_vencimiento());
				fechaVen.setTime(new Date());
				
				int difA = fechaAct.get(Calendar.YEAR) - fechaVen.get(Calendar.YEAR);
				int difM = difA * 12 + fechaAct.get(Calendar.MONTH) - fechaVen.get(Calendar.MONTH);
				
//				System.out.println(i.getLote()+" "+fechaAct.getTime()+" - "+fechaVen.getTime() +" = "+difM);
				if(difM >= 6 && difM <=8 ) {
					Estado estado = estadoService.buscarporId(3);//estado 3 por verncer, estado 2 vencido
					i.setEstado(estado);
					loteService.guardar(i);
				}
				if(difM <= 6) {
					Estado estado = estadoService.buscarporId(2);//estado 3 por verncer, estado 2 vencido
					i.setEstado(estado);
					loteService.guardar(i);
				}
			} catch (Exception e) {
				System.out.println("error cambiando la fecha");
			}
		}
//redirect.addFlashAttribute("msj", "Este lote ya esta asignado a un medicamento, no se puede guardar.").addFlashAttribute("clase","warning");
		
		return "cardiovascular/tblMedicamentos";
	}
	
	@GetMapping("/datosdispomedicos")
	public String cardiodatosdispomedicos(Model modelo) {
		modelo.addAttribute("title","Datos Insumos");
		return "cardiovascular/tblDispoMedicos";
	}
	
	@PostMapping("/medicamento/save")//capturo el medicamento, lote y fecha no son caracteristicas de medicamento como tal
	public String guardarMedicamento(Cardio_vas_lote lote,RedirectAttributes redirect, Model modelo) { //Cardio_vas_medicamento medicamento, @RequestParam("lote") String lote, @RequestParam("fecha") Date fecha,@RequestParam("cantidad") Integer cantidad, @RequestParam("registroinvima") String registroinvima
		Cardio_vas_medicamento objMedicamento = medicamentoService.buscarporNombre(lote.getCardio_vas_medicamento().getNombre());
		Cardio_vas_lote auxlote = loteService.buscarPorLote(lote.getLote());
		Estado estado = estadoService.buscarporId(1);
		
		if(auxlote == null) {//si el lote no esta se crea el medicamento aunque ya se tenga en bd un medicamento con ese nombre
			objMedicamento = new Cardio_vas_medicamento(); //creamos el medicamento
			objMedicamento.setNombre(lote.getCardio_vas_medicamento().getNombre());
			objMedicamento.setFecha_revision(new Date());
			objMedicamento.setFirma_revision("usuario 1");
			
			estado.agrerarCardio_vas_lote(lote);//agrego el lote al estado
			objMedicamento.agregarCardio_vas_lote(lote); //agrego el lote al medicamento
			
			lote.setEstado(estado);//agrego al lote el estado
			lote.setCardio_vas_medicamento(objMedicamento);//agrego el medicamento al lote
			
			medicamentoService.guardar(objMedicamento); //guardamos en la bd el medicamento tambien guarda el lote

			redirect.addFlashAttribute("msj","Medicamento Guardado Extiosamente").addFlashAttribute("clase", "success");
		}
		else if(auxlote != null) {//lote ya esta en la bd y solo debe haber un lote
			redirect.addFlashAttribute("msj", "Este lote ya esta asignado a un medicamento, no se puede guardar.").addFlashAttribute("clase","warning");
		}
		return "redirect:/cardiovascular/formMedicamentos";
//		return "cardiovascular/formCardMedicamentos";
	}
 
	@GetMapping("/prueba")
	public String prueba() {
		System.out.println("probando cambio de lotes ");
		Cardio_vas_lote loteantiguo = loteService.buscarPorId((long) 1);
		Cardio_vas_lote loteporelquevoyacambiar = loteService.buscarPorId((long) 2);
		
		Cardio_vas_cambio cambio= new Cardio_vas_cambio();
		cambio.setFecha_cambio(new Date());
		cambio.setLoteAntiguo(loteantiguo);
		cambio.setLoteNuevo(loteporelquevoyacambiar);//agrego el lote nuevo
		
		loteantiguo.setCambio(cambio);//al lote aniguo le digo el cambio que hago
		
		loteService.guardar(loteantiguo);
		loteService.guardar(loteporelquevoyacambiar);
		
		return "index";
	}
	
	@GetMapping("/firmarevision/{id}")
	public String firmarrevision(@PathVariable("id") long id) {
		
		Cardio_vas_lote lote = loteService.buscarPorId(id);
		lote.getCardio_vas_medicamento().setFecha_revision(new Date());
		lote.getCardio_vas_medicamento().setFirma_revision("usuario insertar");
		medicamentoService.guardar(lote.getCardio_vas_medicamento());
		return "redirect:/cardiovascular/datosmedicamentos";
//		return "index";
	}
	
	@GetMapping("/modificarmedicamento/{id}")
	public String modificarMedicamento(@PathVariable("id") long id, Model modelo) {
		modelo.addAttribute("lote", loteService.buscarPorId(id));
		return "cardiovascular/formCambioMedicamento";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
}
