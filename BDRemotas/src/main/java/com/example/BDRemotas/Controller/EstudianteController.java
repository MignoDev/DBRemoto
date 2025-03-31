package com.example.BDRemotas.Controller;

import com.example.BDRemotas.model.Estudiante;
import com.example.BDRemotas.model.Profesor;
import com.example.BDRemotas.service.EstudianteService;
import com.example.BDRemotas.service.ProfesorService;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiante")
public class EstudianteController {

    @Autowired
    public EstudianteService estudianteService;

    @GetMapping("/listar")
    public ResponseEntity<?> listar()
    {
        try {

            List<Estudiante> response = estudianteService.list();

            if(response.isEmpty()){
                return ResponseEntity.noContent().build();
            }

            return ResponseEntity.ok(response);

        } catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al obtener la lista de profesores: " + e.getMessage());
        }
    }

    @GetMapping("/ver/{id}")
    public ResponseEntity<?> ver(@PathVariable long id)
    {
        try {
            Estudiante response = estudianteService.findById(id);
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

    @PostMapping("/guardar")
    public ResponseEntity<?> guardar (@RequestBody Estudiante profesor)
    {
        try{
            return ResponseEntity.ok("Se ha guardado correctamente");
        } catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al guardar: " + e.getMessage());
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarId (@PathVariable long id)
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

    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizar (@RequestBody Estudiante profesor)
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
