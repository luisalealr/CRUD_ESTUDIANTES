package com.app.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.web.entities.Estudiante;

public interface EstudianteRepositorio extends JpaRepository<Estudiante, Long>{

	
}
