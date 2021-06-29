package net.itinajero.app.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="peliculas")
public class Pelicula {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String titulo;
	private int duracion;
	private String clasificacion;
	private String genero;
	private String imagen = "cinema.png"; // imagen por default	
	private Date fechaEstreno;	
	private String estatus="Activa";
	
	//@Transient
	@OneToOne
	@JoinColumn(name="idDetalle")
	private Detalle detalle;
	
	@OneToMany(mappedBy="pelicula", fetch=FetchType.EAGER)
	private List<Horario> horarios;
	
	/**
	 * @return the horarios
	 */
	public List<Horario> getHorarios() {
		return horarios;
	}
	/**
	 * @param horarios the horarios to set
	 */
	public void setHorarios(List<Horario> horarios) {
		this.horarios = horarios;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public String getClasificacion() {
		return clasificacion;
	}
	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public Date getFechaEstreno() {
		return fechaEstreno;
	}
	public void setFechaEstreno(Date fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	
	/**
	 * @return the detalle
	 */
	public Detalle getDetalle() {
		return detalle;
	}
	/**
	 * @param detalle the detalle to set
	 */
	public void setDetalle(Detalle detalle) {
		this.detalle = detalle;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pelicula [id=");
		builder.append(id);
		builder.append(", titulo=");
		builder.append(titulo);
		builder.append(", duracion=");
		builder.append(duracion);
		builder.append(", clasificacion=");
		builder.append(clasificacion);
		builder.append(", genero=");
		builder.append(genero);
		builder.append(", imagen=");
		builder.append(imagen);
		builder.append(", fechaEstreno=");
		builder.append(fechaEstreno);
		builder.append(", estatus=");
		builder.append(estatus);
		builder.append(", detalle=");
		builder.append(detalle);
		builder.append("]");
		return builder.toString();
	}
	
	public Pelicula() {
		System.out.println("Constructor de la Clase Pelicula...");
	}
	
}
