package com.ies.spring.back.apirest.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="cliente")
public class Cliente implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "no puede ir vacío")
	@NotEmpty
	@Size(min = 4, max = 12)
	@Column(nullable = false)
	private String nombre;
	
	@NotNull(message = "no puede ir vacío")
	@NotEmpty
	private String apellido;
	
	@NotNull(message = "no puede ir vacío")
	@NotEmpty
	@Email
	@Column(nullable = false, unique = false)
	private String email;
	
	@NotNull(message = "no puede ir vacío")
	@Column(name="create_at")
	@Temporal(TemporalType.DATE)
	private Date crateAt;
	
	//@PrePersist
	//public void prePersist() {
		//crateAt = new Date();
	//}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCrateAt() {
		return crateAt;
	}

	public void setCrateAt(Date crateAt) {
		this.crateAt = crateAt;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
