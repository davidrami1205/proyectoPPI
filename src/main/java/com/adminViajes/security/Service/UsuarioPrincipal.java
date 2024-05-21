package com.adminViajes.security.Service;

import java.util.Collection;
//import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.adminViajes.modelo.entidad.Usuario;

public class UsuarioPrincipal implements UserDetails {

    private int idUsuario;
    // private String primerNombre;
    // private String segundoNombre;
    // private String primerApellido;
    // private String segundoApellido;
    // private String tipoDocumento;
    // private Long numeroDocumento;
    private String correo;
    private String contrasena;
    // private String rol;
    // private String estado;
    private Collection<? extends GrantedAuthority> authorities;

    public static UsuarioPrincipal build(Usuario usuario) {
        return new UsuarioPrincipal(usuario.getIdUsuario(), usuario.getCorreo(), usuario.getContrasena(), null);
    }

    public UsuarioPrincipal(int idUsuario, String correo, String contrasena,
            Collection<? extends GrantedAuthority> authorities) {
        this.idUsuario = idUsuario;
        this.correo = correo;
        this.contrasena = contrasena;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return contrasena;
    }

    @Override
    public String getUsername() {
        return correo;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

}
