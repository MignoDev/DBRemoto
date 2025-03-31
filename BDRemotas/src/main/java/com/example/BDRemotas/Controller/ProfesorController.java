package com.example.BDRemotas.Controller;

import com.example.BDRemotas.model.Profesor;
import com.example.BDRemotas.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api")
public class ProfesorController {

    @Autowired
    public ProfesorService profesorService;

    public ResponseEntity<?> listar()
    {
        try {

            List<Profesor> response = profesorService.list();

            if(response.isEmpty()){
                return ResponseEntity.noContent().build();
            }

            return ResponseEntity.ok(response);

        } catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al obtener la lista de profesores: " + e.getMessage());
        }
    }

    public ResponseEntity<?> ver(long id)
    {
        try {
            Profesor response = profesorService.findById(id);
            return ResponseEntity.ok(response);

        } catch (RuntimeException e)
        {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(e.getMessage());
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al obtener el profesor con el id" + id + ": " + e.getMessage());
        }
    }

    public ResponseEntity<?> guardar (Profesor profesor)
    {
        try{
            return ResponseEntity.ok("Se ha guardado correctamente");
        } catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al guardar: " + e.getMessage());
        }
    }

    public ResponseEntity<?> eliminarId (long id)
    {
        try {
            return ResponseEntity.ok().build();
        } catch (RuntimeException e)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar: " + e.getMessage());
        }
    }

    public ResponseEntity<?> actualizar (Profesor profesor)
    {
        try {

            return ResponseEntity.ok().build();

        } catch (RuntimeException e)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar: " + e.getMessage());
        }
    }

}
