package com.app.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.web.entities.Estudiante;
import com.app.web.repository.EstudianteRepositorio;

@Service
public class EstudianteServicioImpl implements EstudianteServicio{

	@Autowired
	private EstudianteRepositorio repositorio;
	
	@Override
	public List<Estudiante> listarEstudiantes() {
		return repositorio.findAll();
	}

	@Override
	public Estudiante guardarEstudiante(Estudiante estudiante) {
		return repositorio.save(estudiante);
	}

	@Override
	public Estudiante actualizarEstudiante(Estudiante estudiante) {
		return repositorio.save(estudiante);
	}

	@Override
	public Estudiante buscarEstudiante(Long id) {
		return repositorio.findById(id).get();
	}

	@Override
	public void eliminarEstudiante(Long id) {
		repositorio.deleteById(id);
	}

	
}
