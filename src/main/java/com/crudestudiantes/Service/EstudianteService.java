package com.crudestudiantes.Service;

import com.crudestudiantes.DAO.EstudianteDAO;
import com.crudestudiantes.Entity.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EstudianteService {

    @Autowired
    EstudianteDAO eDao;

    @Transactional
    public List<Estudiante> listarEstudiantes(){
        List<Estudiante> estudiantes = eDao.findAll();
        return estudiantes;
    }

    @Transactional
    public Estudiante buscarEstudianteId(Long id){
        Estudiante e = (Estudiante) eDao.findById(id).get();
        return e;
    }

    @Transactional
    public Estudiante guardarEstudiante(Estudiante e){
        return eDao.save(e);
    }

    @Transactional
    public Estudiante obtenerEstudiantePorId(Long id){
        return eDao.findById(id).get();
    }

    @Transactional
    public Estudiante actualizarEstudiante(Estudiante estudiante){
        return eDao.save(estudiante);
    }

    @Transactional
    public void eliminarEstudiante(Long id){
        eDao.deleteById(id);
    }

}
