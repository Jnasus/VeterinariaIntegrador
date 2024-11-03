/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.service;

import com.huellitasChalacas.VeterinariaIntegrador.model.Especies;
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
public class EspeciesServiceTest {
    
    public EspeciesServiceTest() {
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
     * Test of crearEspecie method, of class EspeciesService.
     */
    @Test
    public void testCrearEspecie() {
        System.out.println("crearEspecie");
        Especies especie = null;
        EspeciesService instance = new EspeciesService();
        Especies expResult = null;
        Especies result = instance.crearEspecie(especie);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actualizarEspecie method, of class EspeciesService.
     */
    @Test
    public void testActualizarEspecie() {
        System.out.println("actualizarEspecie");
        Especies especie = null;
        EspeciesService instance = new EspeciesService();
        Especies expResult = null;
        Especies result = instance.actualizarEspecie(especie);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarTodasLasEspecies method, of class EspeciesService.
     */
    @Test
    public void testListarTodasLasEspecies() {
        System.out.println("listarTodasLasEspecies");
        EspeciesService instance = new EspeciesService();
        List<Especies> expResult = null;
        List<Especies> result = instance.listarTodasLasEspecies();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerEspeciePorId method, of class EspeciesService.
     */
    @Test
    public void testObtenerEspeciePorId() {
        System.out.println("obtenerEspeciePorId");
        Integer id = null;
        EspeciesService instance = new EspeciesService();
        Especies expResult = null;
        Especies result = instance.obtenerEspeciePorId(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarEspecie method, of class EspeciesService.
     */
    @Test
    public void testEliminarEspecie() {
        System.out.println("eliminarEspecie");
        Integer id = null;
        EspeciesService instance = new EspeciesService();
        instance.eliminarEspecie(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
