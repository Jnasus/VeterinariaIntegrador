/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.controller;

import com.huellitasChalacas.VeterinariaIntegrador.model.CategoriaProducto;
import com.huellitasChalacas.VeterinariaIntegrador.service.CategoriaProductoService;
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
@RequestMapping("/api/v1/categoriaProducto")

public class CategoriaProductoController {
    
    @Autowired
    private CategoriaProductoService categoriaProductoService;
    
    // Obtener todas las categorías
    @GetMapping
    public ResponseEntity<List<CategoriaProducto>> getAllCategoriaProductos() {
        List<CategoriaProducto> categoriaProducto = categoriaProductoService.listarTodasLasCategoriasProducto();
        return new ResponseEntity<>(categoriaProducto, HttpStatus.OK);
    }

    // Obtener una categoría por ID
    @GetMapping("/{id}")
    public ResponseEntity<CategoriaProducto> getCategoriaProductoById(@PathVariable Integer id) {
        CategoriaProducto categoria = categoriaProductoService.obtenerCategoriaProductoPorId(id);
        if (categoria != null) {
            return new ResponseEntity<>(categoria, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Crear una nueva categoría
    @PostMapping
    public ResponseEntity<CategoriaProducto> createCategoriaProducto(@RequestBody CategoriaProducto categoria) {
        CategoriaProducto newCategoriaProducto = categoriaProductoService.crearCategoriaProducto(categoria);
        return new ResponseEntity<>(newCategoriaProducto, HttpStatus.CREATED);
    }

    // Actualizar una categoría existente
    @PutMapping("/{id}")
    public ResponseEntity<CategoriaProducto> updateCategoriaProducto(@PathVariable Integer id, @RequestBody CategoriaProducto categoria) {
        CategoriaProducto existingCategoriaProducto = categoriaProductoService.obtenerCategoriaProductoPorId(id);
        if (existingCategoriaProducto != null) {
            categoria.setIdCategoria(id); // Asegura que se actualice la categoría correcta
            CategoriaProducto updatedCategoriaProducto = categoriaProductoService.crearCategoriaProducto(categoria);
            return new ResponseEntity<>(updatedCategoriaProducto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar una categoría por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoriaProducto(@PathVariable Integer id) {
        CategoriaProducto existingCategoriaProducto = categoriaProductoService.obtenerCategoriaProductoPorId(id);
        if (existingCategoriaProducto != null) {
            categoriaProductoService.eliminarCategoriaProducto(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
