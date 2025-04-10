package com.huellitasChalacas.VeterinariaIntegrador.repository;

import com.huellitasChalacas.VeterinariaIntegrador.model.Raza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RazaRepository extends JpaRepository<Raza, Integer>, JpaSpecificationExecutor<Raza> {

}
