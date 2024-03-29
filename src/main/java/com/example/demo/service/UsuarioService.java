package com.example.demo.service;


import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario encontrarUsuarioPorNombre(String nombre){

        return usuarioRepository.findByNombre(nombre);
    }

    public Usuario guardarUsuario(Usuario usuario){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        usuario.setContrasena(passwordEncoder.encode(usuario.getContrasena()));

        return usuarioRepository.save(usuario);
    }
}
