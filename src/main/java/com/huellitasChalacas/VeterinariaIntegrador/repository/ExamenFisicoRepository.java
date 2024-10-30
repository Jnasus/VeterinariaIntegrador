package com.huellitasChalacas.VeterinariaIntegrador.repository;

import com.huellitasChalacas.VeterinariaIntegrador.model.ExamenFisico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamenFisicoRepository extends JpaRepository<ExamenFisico, Integer>, JpaSpecificationExecutor<ExamenFisico> {

}
