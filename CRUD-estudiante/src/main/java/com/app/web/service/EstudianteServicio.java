package com.app.web.service;

import java.util.List;

import com.app.web.entities.Estudiante;

public interface EstudianteServicio {

	public List<Estudiante> listarEstudiantes();
	
	public Estudiante guardarEstudiante(Estudiante estudiante);
	
	public Estudiante buscarEstudiante(Long id);
	
	public Estudiante actualizarEstudiante(Estudiante estudiante);
	
	public void eliminarEstudiante(Long id);
}
