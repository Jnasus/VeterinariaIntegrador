package com.huellitasChalacas.VeterinariaIntegrador.repository;

import com.huellitasChalacas.VeterinariaIntegrador.model.Tratamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TratamientoRepository extends JpaRepository<Tratamiento, Integer>, JpaSpecificationExecutor<Tratamiento> {

}
