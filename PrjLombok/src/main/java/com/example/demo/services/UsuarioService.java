package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entities.Usuario;
import com.example.demo.repositories.UsuarioRepository;

public class UsuarioService {
	
	private final UsuarioRepository usuariorepository;
	
	@Autowired
	public UsuarioService(UsuarioRepository usuariorepository) {
		this.usuariorepository = usuariorepository;
	}
	public List<Usuario> buscaTodosUsuarios(){
		return usuariorepository.findAll();
	}
	public Usuario buscaUsuarioId(Long id) {
		Optional <Usuario> Usuario = usuariorepository.findById(id);
		return Usuario.orElse(null);
	}
	public Usuario salvaUsuario(Usuario Usuario) {
		return usuariorepository.save(Usuario);
	}
	public Usuario alterarUsuario(Long id, Usuario alterarU) {
		Optional <Usuario> existeUsuario = usuariorepository.findById(id);
		if (existeUsuario.isPresent()) {
			alterarU.setId(id);
			return usuariorepository.save(alterarU);
		}
		return null;
	}
	public boolean apagarUsuario(Long id) {
		Optional <Usuario> existeUsuario = usuariorepository.findById(id);
		if (existeUsuario.isPresent()) {
			usuariorepository.deleteById(id);
			return true;
		}
		return false;
	}
}
