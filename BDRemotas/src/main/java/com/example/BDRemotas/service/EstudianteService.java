package com.example.BDRemotas.service;

import com.example.BDRemotas.model.Estudiante;
import com.example.BDRemotas.model.Profesor;
import com.example.BDRemotas.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteService {

    @Autowired
    public EstudianteRepository estudianteRepository;

    public Estudiante save(Estudiante estudiante)
    {
        return estudianteRepository.save(estudiante);
    }

    public List<Estudiante> list ()
    {
        return estudianteRepository.findAll();
    }

    public Estudiante findById(long id)
    {
        if (!estudianteRepository.existsById(id))
        {
            throw new RuntimeException("Registro con el id " + id + " no existe");
        }
        return estudianteRepository.getReferenceById(id);
    }

    public void deleteById(long id)
    {
        if (!estudianteRepository.existsById(id))
        {
            throw new RuntimeException("El registro con el id " + id + " no existe");
        }
        estudianteRepository.deleteById(id);
    }

    public void update (Estudiante estudiante)
    {
        if (!estudianteRepository.existsById(estudiante.getCodigo()))
        {
            throw new RuntimeException("El registor no existe");
        }
        estudianteRepository.save(estudiante);
    }

}
