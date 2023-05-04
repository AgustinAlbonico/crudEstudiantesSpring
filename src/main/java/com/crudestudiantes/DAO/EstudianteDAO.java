package com.crudestudiantes.DAO;

import com.crudestudiantes.Entity.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteDAO extends JpaRepository<Estudiante, Long> {



}
