package net.itinajero.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.itinajero.app.model.Banner;
import net.itinajero.app.repository.BannersRepository;

//El error era no indicar el modelo como un bean compatible
@Service
public class BannersServiceJpa implements IBannerService {

	@Autowired
	private BannersRepository bannersRepo;
	
	@Override
	public void guardar(Banner banner) {
		bannersRepo.save(banner);
	}

	@Override
	public List<Banner> buscarTodos() {
		// TODO Auto-generated method stub
		return bannersRepo.findAll();
	}

	@Override
	public void eliminar(int idBanner) {
		bannersRepo.deleteById(idBanner);
	}

	@Override
	public Banner buscarPorId(int idBanner) {
		Optional<Banner> banner = bannersRepo.findById(idBanner);
		
		if(banner.isPresent()) {
			return banner.get();
		}
		
		return null;
	}

	@Override
	public List<Banner> buscarActivos() {
		// TODO Auto-generated method stub
		return bannersRepo.findByEstatusOrderByIdDesc("Activo");
	}

}
