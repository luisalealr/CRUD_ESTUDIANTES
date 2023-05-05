package com.app.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.web.entities.Estudiante;
import com.app.web.service.EstudianteServicio;

@Controller
public class EstudianteControlador {

	@Autowired
	private EstudianteServicio servicio;

	@GetMapping({ "/", "/estudiantes" })
	public String listarEstudiantes(Model modelo) {
		modelo.addAttribute("estudiantes", servicio.listarEstudiantes());
		return "estudiante";// nos retorna al archivo estudiantes
	}

	@GetMapping("/estudiantes/nuevo")
	public String mostrarFormulario(Model modelo) {
		Estudiante estudiante = new Estudiante();
		modelo.addAttribute("estudiante", estudiante);
		return "crear-estudiante";
	}

	@PostMapping("/estudiantes")
	public String guardarEstudiante(@ModelAttribute("estudiante") Estudiante estudiante) {
		servicio.guardarEstudiante(estudiante);
		return "redirect:/estudiantes";
	}

	@GetMapping("/estudiantes/{id}/editar")
	public String mostrarFormularioEditar(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("estudiante", servicio.buscarEstudiante(id));
		return "editar-estudiante";
	}

	@PostMapping("/estudiantes/{id}")
	public String actualizarEstudiante(@PathVariable Long id, @ModelAttribute("estudiante") Estudiante estudiante) {
		Estudiante estudianteExistente = servicio.buscarEstudiante(id);
		estudianteExistente.setId(id);
		estudianteExistente.setNombre(estudiante.getNombre());
		estudianteExistente.setApellido(estudiante.getApellido());
		estudianteExistente.setEmail(estudiante.getEmail());
		servicio.actualizarEstudiante(estudianteExistente);
		return "redirect:/estudiantes";
	}

	@GetMapping("/estudiantes/{id}/eliminar")
	public String eliminarEstudiante(@PathVariable Long id) {
		servicio.eliminarEstudiante(id);
		return "redirect:/estudiantes";
	}
}
