package net.itinajero.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import net.itinajero.app.model.Noticia;

//@Service
public class NoticiasServiceImpl implements INoticiasService {

	@Override
	public void guardar(Noticia noticia) {
		System.out.println("Noticia desde la clase de servicio" + noticia);
	}

	@Override
	public List<Noticia> buscarUltimas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Noticia> buscarTodas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Noticia buscarPorId(int idNoticia) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(int idNoticia) {
		// TODO Auto-generated method stub
		
	}

}
