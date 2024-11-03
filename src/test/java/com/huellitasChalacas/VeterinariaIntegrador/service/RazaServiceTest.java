/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.service;

import com.huellitasChalacas.VeterinariaIntegrador.model.Raza;
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
public class RazaServiceTest {
    
    public RazaServiceTest() {
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
     * Test of findAll method, of class RazaService.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        RazaService instance = new RazaService();
        List<Raza> expResult = null;
        List<Raza> result = instance.findAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findById method, of class RazaService.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        Integer id = null;
        RazaService instance = new RazaService();
        Raza expResult = null;
        Raza result = instance.findById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of save method, of class RazaService.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        Raza raza = null;
        RazaService instance = new RazaService();
        Raza expResult = null;
        Raza result = instance.save(raza);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteById method, of class RazaService.
     */
    @Test
    public void testDeleteById() {
        System.out.println("deleteById");
        Integer id = null;
        RazaService instance = new RazaService();
        instance.deleteById(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
