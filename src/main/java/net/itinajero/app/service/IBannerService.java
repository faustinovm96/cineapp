package net.itinajero.app.service;

import java.util.List;

import net.itinajero.app.model.Banner;

public interface IBannerService {
	void guardar(Banner banner);
	List<Banner> buscarTodos();
	void eliminar(int idBanner);
	Banner buscarPorId(int idBanner);
	List<Banner> buscarActivos();
}
