package com.adminViajes.security.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.adminViajes.modelo.entidad.Usuario;
import com.adminViajes.modelo.servicio.UsuarioServicio;

@Service
public class UserDetailServiceImp implements UserDetailsService {

    @Autowired
    UsuarioServicio usuarioServicio;

    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
        Usuario usuario = usuarioServicio.getByCorreo(correo).orElseThrow(() -> new UsernameNotFoundException(correo));
        return UsuarioPrincipal.build(usuario);
    }

}
