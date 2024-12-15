/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/**
 *
 * @author jtorr
 */
@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    //private static final String TARGET_URL = "http://localhost:8080/swagger-ui/index.html";

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        // Obtener el usuario autenticado
        String username = authentication.getName();

        // Registrar el evento de login (opcional)
        System.out.println("Login exitoso para el usuario: " + username);

        // Redirigir al usuario a la página de documentación de la API
        response.sendRedirect("/swagger-ui/index.html");
    }

}
