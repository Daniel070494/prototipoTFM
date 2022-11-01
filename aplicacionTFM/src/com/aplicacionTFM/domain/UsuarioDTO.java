package com.aplicacionTFM.domain;

public class UsuarioDTO {
	
	private String userN;
	private String nombre;
	private String apPaterno;
	private String apMaterno;
	private String rfc;
	private String email;
	private String totalCarrito;
	
	
	public String getUserN() {
		return userN;
	}
	public void setUserN(String userN) {
		this.userN = userN;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApPaterno() {
		return apPaterno;
	}
	public void setApPaterno(String apPaterno) {
		this.apPaterno = apPaterno;
	}
	public String getApMaterno() {
		return apMaterno;
	}
	public void setApMaterno(String apMaterno) {
		this.apMaterno = apMaterno;
	}
	public String getRfc() {
		return rfc;
	}
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTotalCarrito() {
		return totalCarrito;
	}
	public void setTotalCarrito(String totalCarrito) {
		this.totalCarrito = totalCarrito;
	}
		
}
