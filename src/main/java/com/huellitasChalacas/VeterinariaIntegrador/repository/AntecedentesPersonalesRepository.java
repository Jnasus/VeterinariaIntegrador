package com.huellitasChalacas.VeterinariaIntegrador.repository;

import com.huellitasChalacas.VeterinariaIntegrador.model.AntecedentesPersonales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AntecedentesPersonalesRepository extends JpaRepository<AntecedentesPersonales, Integer>, JpaSpecificationExecutor<AntecedentesPersonales> {

}