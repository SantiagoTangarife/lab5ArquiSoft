package com.udea.lab5ArquiSoft.Dao;

import com.udea.lab5ArquiSoft.Model.Empleado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmpleado extends CrudRepository<Empleado,Long> {

}
