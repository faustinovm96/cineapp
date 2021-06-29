package net.itinajero.app.service;

import java.util.List;

import net.itinajero.app.model.Noticia;

public interface INoticiasService {
	
	void guardar(Noticia noticia);
	
	List<Noticia> buscarUltimas();
	
	List<Noticia> buscarTodas();
	
	Noticia buscarPorId(int idNoticia);
	
	void eliminar(int idNoticia);
	
}
