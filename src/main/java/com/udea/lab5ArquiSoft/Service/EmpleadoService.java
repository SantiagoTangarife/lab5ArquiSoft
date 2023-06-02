package com.udea.lab5ArquiSoft.Service;

import com.udea.lab5ArquiSoft.Dao.IEmpleado;
import com.udea.lab5ArquiSoft.Model.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {

    @Autowired
    IEmpleado iEmpleado;

   /* public Empleado save(Empleado e) {return iEmpleado.save(e);}
    public Empleado update(Empleado e) {return iEmpleado.save(e);}
    public void delete(Empleado e) {
        iEmpleado.delete(e);}
    public Iterable<Empleado> list(){return iEmpleado.findAll();}
    public Optional<Empleado> listId(long id){return iEmpleado.findById(id);}*/













    public List<Empleado> findAll(){
        //capturar y enviar los elementos de la bas de datos
        return (List<Empleado>) iEmpleado.findAll();

    }



    //crear un Nuevo elemento

    public ResponseEntity<Empleado> save(@RequestBody Empleado empleado){
        //guardar
        Empleado result= iEmpleado.save(empleado);

        return  ResponseEntity.ok(result);
    }




    //buscar segun su id

    public ResponseEntity<Empleado> findById(@PathVariable Long id){
        //usamos siempre un optional para no tratar con excepciones de alcance por id, debido a un id incorrecto
        Optional<Empleado> optionalEmpleado= iEmpleado.findById(id);
        if(optionalEmpleado.isPresent())
            //si existe lo devuelvo
            return  ResponseEntity.ok(optionalEmpleado.get());
        else
            //si no existe debolvemos un 404 con un response entity
            return ResponseEntity.notFound().build();
    }

    //borrar un elemento de la DB

    public ResponseEntity<Empleado> delete(@PathVariable Long id){

        if (!iEmpleado.existsById(id)) { //si el Id NO existe (NUMEO MUY GRANDE)
            return ResponseEntity.notFound().build();
        }
        iEmpleado.deleteById(id);
        return ResponseEntity.noContent().build();

    }

    //actualizar un elemento existente

    public ResponseEntity<Empleado> update(@RequestBody Empleado empleado){
        if(empleado.getCc()==null){ //no le mande un numero de cedula
            return ResponseEntity.badRequest().build();
        }
        if(!iEmpleado.existsById(empleado.getCc())){ //si el Id NO existe (NUMEO MUY GRANDE)
            return ResponseEntity.notFound().build();
        }
        //de lo contrario
        Empleado result= iEmpleado.save(empleado);
        return ResponseEntity.ok(result);


    }


}
