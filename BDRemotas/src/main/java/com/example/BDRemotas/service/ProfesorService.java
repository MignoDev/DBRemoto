package com.example.BDRemotas.service;

import com.example.BDRemotas.model.Profesor;
import com.example.BDRemotas.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesorService {

    @Autowired
    public ProfesorRepository profesorRepository;

    public Profesor save(Profesor profesor)
    {
        return profesorRepository.save(profesor);
    }

    public List<Profesor> list ()
    {
        return profesorRepository.findAll();
    }

    public Profesor findById(long id)
    {
        if (!profesorRepository.existsById(id))
        {
            throw new RuntimeException("Registro con el id " + id + " no existe");
        }
        return profesorRepository.getReferenceById(id);
    }

    public void deleteById(long id)
    {
        if (!profesorRepository.existsById(id))
        {
            throw new RuntimeException("El registro con el id " + id + " no existe");
        }
        profesorRepository.deleteById(id);
    }

    public void update (Profesor profesor)
    {
        if (!profesorRepository.existsById(profesor.getId()))
        {
            throw new RuntimeException("El registor no existe");
        }
        profesorRepository.save(profesor);
    }

}
