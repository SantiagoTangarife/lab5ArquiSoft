package com.udea.lab5ArquiSoft.Controller;

import com.udea.lab5ArquiSoft.Model.Empleado;
import com.udea.lab5ArquiSoft.Service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/empleado")
@CrossOrigin("*")
public class EmpleadoController {


    @Autowired
    EmpleadoService empleadoService;



    @GetMapping("/find-all")
    public List<Empleado> findAll() {
        return empleadoService.findAll();
    }

    @PostMapping("/save")
    public ResponseEntity<Empleado> save(@RequestBody Empleado empleado) {
        return empleadoService.save(empleado);
    }

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<Empleado> findById(@PathVariable Long id) {
        return empleadoService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Empleado> delete(@PathVariable Long id) {
        return empleadoService.delete(id);
    }

    @PutMapping("/update")
    public ResponseEntity<Empleado> update(@RequestBody Empleado empleado) {
        return empleadoService.update(empleado);
    }
}