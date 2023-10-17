package com.ProjetoLombok.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProjetoLombok.entities.Usuario;
import com.ProjetoLombok.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	private final UsuarioRepository usuarioRepository; 
		
	@Autowired
	public UsuarioService (UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	public List<Usuario> buscaTodosUsuarios(){
		return usuarioRepository.findAll();
	}
	
	public Usuario buscaUsuarioId(Long Id) {
		Optional <Usuario> Usuario = usuarioRepository.findById(Id);
		return Usuario.orElse(null);
	}
	public Usuario salvaUsuario(Usuario Usuario) {
		return usuarioRepository.save(Usuario);
	}
	public Usuario alterarUsuario(Long id, Usuario alterarUsua) {
		Optional <Usuario> existeUsuario = usuarioRepository.findById(id);
		if (existeUsuario.isPresent()) {
			alterarUsua.setId(id);
			return usuarioRepository.save(alterarUsua);
		}
		return null;
	}
	public boolean apagarUsuario(Long id) {
		Optional <Usuario> existeUsuario = usuarioRepository.findById(id);
		if (existeUsuario.isPresent()){
			usuarioRepository.deleteById(id);
			return true;
		}
			return false;
	}
}
