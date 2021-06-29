package net.itinajero.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.itinajero.app.model.Noticia;
import net.itinajero.app.repository.NoticiasRepository;

@Service
public class NoticiasServiceJpa implements INoticiasService {

	@Autowired
	private NoticiasRepository noticiasRepo;
	
	@Override
	public void guardar(Noticia noticia) {
		noticiasRepo.save(noticia);
	}

	@Override
	public List<Noticia> buscarUltimas() {
		List<Noticia> noticiasLista = noticiasRepo.findTop3ByEstatusOrderByIdDesc("Activa");
		return noticiasLista;
	}

	@Override
	public List<Noticia> buscarTodas() {
		// TODO Auto-generated method stub
		return noticiasRepo.findAll();
	}

	@Override
	public Noticia buscarPorId(int idNoticia) {
		// TODO Auto-generated method stub
		Optional<Noticia> noticia = noticiasRepo.findById(idNoticia);
		
		if (noticia.isPresent()) {
			return noticia.get();
		}
		
		return null;

	}

	@Override
	public void eliminar(int idNoticia) {
		noticiasRepo.deleteById(idNoticia);
	}

}
