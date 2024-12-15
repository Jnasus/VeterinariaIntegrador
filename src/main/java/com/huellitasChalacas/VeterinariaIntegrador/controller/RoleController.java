/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.controller;

import com.huellitasChalacas.VeterinariaIntegrador.model.Role;
import com.huellitasChalacas.VeterinariaIntegrador.service.RoleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jtorr
 */
@RestController
@RequestMapping("/api/v1/role")

public class RoleController {

    @Autowired
    private RoleService roleService;

    // Obtener todas las categorías
    @GetMapping
    public ResponseEntity<List<Role>> getAllRoles() {
        List<Role> roles = roleService.findAll();
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    // Obtener una categoría por ID
    @GetMapping("/{id}")
    public ResponseEntity<Role> getRolesById(@PathVariable Integer id) {
        Role roles = roleService.findById(id);
        if (roles != null) {
            return new ResponseEntity<>(roles, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Obtener una usuario por Username
    @GetMapping("/role/{nombre}")
    public ResponseEntity<Role> getRoleByNombre(@PathVariable String nombre) {
        Role role = roleService.findByNombre(nombre);
        return new ResponseEntity<>(role, HttpStatus.OK);
    }

    // Crear una nueva categoría
    @PostMapping
    public ResponseEntity<Role> createRoles(@RequestBody Role roles) {
        Role newRoles = roleService.save(roles);
        return new ResponseEntity<>(newRoles, HttpStatus.CREATED);
    }

    // Actualizar una categoría existente
    @PutMapping("/{id}")
    public ResponseEntity<Role> updateRoles(@PathVariable Integer id, @RequestBody Role roles) {
        Role existingRoles = roleService.findById(id);
        if (existingRoles != null) {
            roles.setIdRol(id); // Asegura que se actualice la categoría correcta
            Role updatedRoles = roleService.save(roles);
            return new ResponseEntity<>(updatedRoles, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar una categoría por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoles(@PathVariable Integer id) {
        Role existingRoles = roleService.findById(id);
        if (existingRoles != null) {
            roleService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
