package net.itinajero.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="detalles")
public class Detalle {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String director;
	private String actores;
	private String sinopsis;
	private String trailer;
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
	 * @return the director
	 */
	public String getDirector() {
		return director;
	}
	/**
	 * @param director the director to set
	 */
	public void setDirector(String director) {
		this.director = director;
	}
	/**
	 * @return the actores
	 */
	public String getActores() {
		return actores;
	}
	/**
	 * @param actores the actores to set
	 */
	public void setActores(String actores) {
		this.actores = actores;
	}
	/**
	 * @return the sinopsis
	 */
	public String getSinopsis() {
		return sinopsis;
	}
	/**
	 * @param sinopsis the sinopsis to set
	 */
	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}
	/**
	 * @return the trailer
	 */
	public String getTrailer() {
		return trailer;
	}
	/**
	 * @param trailer the trailer to set
	 */
	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}
	public Detalle() {
		System.out.println("Constructor de la clase Detalle");
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Detalle [id=");
		builder.append(id);
		builder.append(", director=");
		builder.append(director);
		builder.append(", actores=");
		builder.append(actores);
		builder.append(", sinopsis=");
		builder.append(sinopsis);
		builder.append(", trailer=");
		builder.append(trailer);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
}
