package net.itinajero.app.model;

import java.util.Arrays;
import java.util.List;

public class Contacto {
	private int id;
	private String nombre;
	private String email;
	private int rating;
	private String[] generos;
	private List<String> notificaciones;
	private String comentarios;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the rating
	 */
	public int getRating() {
		return rating;
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(int rating) {
		this.rating = rating;
	}

	/**
	 * @return the generos
	 */
	public String[] getGeneros() {
		return generos;
	}

	/**
	 * @param generos the generos to set
	 */
	public void setGeneros(String[] generos) {
		this.generos = generos;
	}


	

	/**
	 * @return the notificaciones
	 */
	public List<String> getNotificaciones() {
		return notificaciones;
	}

	/**
	 * @param notificaciones the notificaciones to set
	 */
	public void setNotificaciones(List<String> notificaciones) {
		this.notificaciones = notificaciones;
	}

	/**
	 * @return the comentarios
	 */
	public String getComentarios() {
		return comentarios;
	}

	/**
	 * @param comentarios the comentarios to set
	 */
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public Contacto() {
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Contacto [id=");
		builder.append(id);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", email=");
		builder.append(email);
		builder.append(", rating=");
		builder.append(rating);
		builder.append(", generos=");
		builder.append(Arrays.toString(generos));
		builder.append(", notificaciones=");
		builder.append(notificaciones);
		builder.append(", comentarios=");
		builder.append(comentarios);
		builder.append("]");
		return builder.toString();
	}

}
