/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.service;

import com.huellitasChalacas.VeterinariaIntegrador.model.CategoriaProducto;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author jtorr
 */
public class CategoriaProductoServiceTest {
    
    public CategoriaProductoServiceTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of crearCategoriaProducto method, of class CategoriaProductoService.
     */
    @Test
    public void testCrearCategoriaProducto() {
        System.out.println("crearCategoriaProducto");
        CategoriaProducto categoriaProducto = null;
        CategoriaProductoService instance = new CategoriaProductoService();
        CategoriaProducto expResult = null;
        CategoriaProducto result = instance.crearCategoriaProducto(categoriaProducto);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actualizarCategoriaProducto method, of class CategoriaProductoService.
     */
    @Test
    public void testActualizarCategoriaProducto() {
        System.out.println("actualizarCategoriaProducto");
        CategoriaProducto categoriaProducto = null;
        CategoriaProductoService instance = new CategoriaProductoService();
        CategoriaProducto expResult = null;
        CategoriaProducto result = instance.actualizarCategoriaProducto(categoriaProducto);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerCategoriaProductoPorId method, of class CategoriaProductoService.
     */
    @Test
    public void testObtenerCategoriaProductoPorId() {
        System.out.println("obtenerCategoriaProductoPorId");
        Integer id = null;
        CategoriaProductoService instance = new CategoriaProductoService();
        CategoriaProducto expResult = null;
        CategoriaProducto result = instance.obtenerCategoriaProductoPorId(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarTodasLasCategoriasProducto method, of class CategoriaProductoService.
     */
    @Test
    public void testListarTodasLasCategoriasProducto() {
        System.out.println("listarTodasLasCategoriasProducto");
        CategoriaProductoService instance = new CategoriaProductoService();
        List<CategoriaProducto> expResult = null;
        List<CategoriaProducto> result = instance.listarTodasLasCategoriasProducto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarCategoriaProducto method, of class CategoriaProductoService.
     */
    @Test
    public void testEliminarCategoriaProducto() {
        System.out.println("eliminarCategoriaProducto");
        Integer id = null;
        CategoriaProductoService instance = new CategoriaProductoService();
        instance.eliminarCategoriaProducto(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
