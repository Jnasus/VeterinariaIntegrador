/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.adminController;

import com.huellitasChalacas.VeterinariaIntegrador.dto.ProductoDTO;
import com.huellitasChalacas.VeterinariaIntegrador.mapper.ProductoMapper;
import com.huellitasChalacas.VeterinariaIntegrador.model.Producto;
import com.huellitasChalacas.VeterinariaIntegrador.service.ProductoService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

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
@RequestMapping("/api/v1/admin/producto")
public class ProductoAdminController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private ProductoMapper productoMapper;

    // Obtener todas las categorías de productos
    @GetMapping
    public ResponseEntity<List<ProductoDTO>> getAllCategoriasProducto() {
        List<Producto> productos = productoService.findAll();
        List<ProductoDTO> productoDTOs = productoMapper.toDtoList(productos);
        return new ResponseEntity<>(productoDTOs, HttpStatus.OK);
    }

    // Obtener una categoría de producto por ID
    @GetMapping("/{id}")
    public ResponseEntity<ProductoDTO> getProductoById(@PathVariable Integer id) {
        Producto producto = productoService.findById(id);
        if (producto != null) {
            ProductoDTO productoDTO = productoMapper.toDto(producto);
            return new ResponseEntity<>(productoDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Crear una nueva categoría de producto
    @PostMapping
    public ResponseEntity<ProductoDTO> createProducto(@RequestBody ProductoDTO productoDTO) {
        Producto producto = productoMapper.toEntity(productoDTO);
        Producto newProducto = productoService.save(producto);
        ProductoDTO newProductoDTO = productoMapper.toDto(newProducto);
        return new ResponseEntity<>(newProductoDTO, HttpStatus.CREATED);
    }

    // Actualizar una categoría de producto existente
    @PutMapping("/{id}")
    public ResponseEntity<ProductoDTO> updateProducto(@PathVariable Integer id, @RequestBody ProductoDTO productoDTO) {
        Producto existingProducto = productoService.findById(id);
        if (existingProducto != null) {
            Producto producto = productoMapper.toEntity(productoDTO);
            producto.setIdArticulo(id); // Asegura que se actualice la categoría correcta
            Producto updatedProducto = productoService.save(producto);
            ProductoDTO updatedProductoDTO = productoMapper.toDto(updatedProducto);
            return new ResponseEntity<>(updatedProductoDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar una categoría de producto por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProducto(@PathVariable Integer id) {
        Producto existingProducto = productoService.findById(id);
        if (existingProducto != null) {
            productoService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
