package com.adminViajes.security;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.support.SessionFlashMapManager;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CustomLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws ServletException, IOException {
        SessionFlashMapManager fManager = new SessionFlashMapManager();
        FlashMap fMap = new FlashMap();
        fMap.put("Success", "Bienvenido, Ha iniciado Sesion con Exito");
        fManager.saveOutputFlashMap(fMap, request, response);
        super.onAuthenticationSuccess(request, response, authentication);
    }
}
