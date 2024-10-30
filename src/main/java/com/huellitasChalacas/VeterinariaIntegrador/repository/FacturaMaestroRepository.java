package com.huellitasChalacas.VeterinariaIntegrador.repository;

import com.huellitasChalacas.VeterinariaIntegrador.model.FacturaMaestro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaMaestroRepository extends JpaRepository<FacturaMaestro, Integer>, JpaSpecificationExecutor<FacturaMaestro> {

}
