/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.adminController;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.huellitasChalacas.VeterinariaIntegrador.dto.CategoriaProductoDTO;
import com.huellitasChalacas.VeterinariaIntegrador.model.CategoriaProducto;
import com.huellitasChalacas.VeterinariaIntegrador.mapper.CategoriaProductoMapper;
import com.huellitasChalacas.VeterinariaIntegrador.service.CategoriaProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author jtorr
 */
@RestController
@RequestMapping("/api/v1/admin/categoriaproducto")
public class CategoriaProductoAdminController {

    @Autowired
    private CategoriaProductoService categoriaProductoService;

    @Autowired
    private CategoriaProductoMapper categoriaProductoMapper;

    // Obtener todas las categorías de productos
    @GetMapping
    public ResponseEntity<List<CategoriaProductoDTO>> getAllCategoriasProducto() {
        List<CategoriaProducto> categoriasProducto = categoriaProductoService.listarTodasLasCategoriasProducto();
        List<CategoriaProductoDTO> categoriaProductoDTOs = categoriaProductoMapper.toDtoList(categoriasProducto);
        return new ResponseEntity<>(categoriaProductoDTOs, HttpStatus.OK);
    }

    // Obtener una categoría de producto por ID
    @GetMapping("/{id}")
    public ResponseEntity<CategoriaProductoDTO> getCategoriaProductoById(@PathVariable Integer id) {
        CategoriaProducto categoriaProducto = categoriaProductoService.obtenerCategoriaProductoPorId(id);
        if (categoriaProducto != null) {
            CategoriaProductoDTO categoriaProductoDTO = categoriaProductoMapper.toDTO(categoriaProducto);
            return new ResponseEntity<>(categoriaProductoDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Crear una nueva categoría de producto
    @PostMapping
    public ResponseEntity<CategoriaProductoDTO> createCategoriaProducto(@RequestBody CategoriaProductoDTO categoriaProductoDTO) {
        CategoriaProducto categoriaProducto = categoriaProductoMapper.toEntity(categoriaProductoDTO);
        CategoriaProducto newCategoriaProducto = categoriaProductoService.crearCategoriaProducto(categoriaProducto);
        CategoriaProductoDTO newCategoriaProductoDTO = categoriaProductoMapper.toDTO(newCategoriaProducto);
        return new ResponseEntity<>(newCategoriaProductoDTO, HttpStatus.CREATED);
    }

    // Actualizar una categoría de producto existente
    @PutMapping("/{id}")
    public ResponseEntity<CategoriaProductoDTO> updateCategoriaProducto(@PathVariable Integer id, @RequestBody CategoriaProductoDTO categoriaProductoDTO) {
        CategoriaProducto existingCategoriaProducto = categoriaProductoService.obtenerCategoriaProductoPorId(id);
        if (existingCategoriaProducto != null) {
            CategoriaProducto categoriaProducto = categoriaProductoMapper.toEntity(categoriaProductoDTO);
            categoriaProducto.setIdCategoria(id); // Asegura que se actualice la categoría correcta
            CategoriaProducto updatedCategoriaProducto = categoriaProductoService.actualizarCategoriaProducto(categoriaProducto);
            CategoriaProductoDTO updatedCategoriaProductoDTO = categoriaProductoMapper.toDTO(updatedCategoriaProducto);
            return new ResponseEntity<>(updatedCategoriaProductoDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar una categoría de producto por ID
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
