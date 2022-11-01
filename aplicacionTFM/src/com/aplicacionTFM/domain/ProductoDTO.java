package com.aplicacionTFM.domain;

public class ProductoDTO {
	
	private String pro_n;
	private String categoria;
	private String estatus;
	private String tipo;
	private String sku;
	private String nombre;
	private String descripcion;
	private String precio;
	private String stock;
	private String imagen;
	private String fecha_registro;
	private String oferta;
	
	public String getPro_n() {
		return pro_n;
	}
	public void setPro_n(String pro_n) {
		this.pro_n = pro_n;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public String getFecha_registro() {
		return fecha_registro;
	}
	public void setFecha_registro(String fecha_registro) {
		this.fecha_registro = fecha_registro;
	}
	public String getOferta() {
		return oferta;
	}
	public void setOferta(String oferta) {
		this.oferta = oferta;
	}
	@Override
	public String toString() {
		return "ProductoDTO [pro_n=" + pro_n + ", categoria=" + categoria + ", estatus=" + estatus + ", tipo=" + tipo
				+ ", sku=" + sku + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio
				+ ", stock=" + stock + ", imagen=" + imagen + ", fecha_registro=" + fecha_registro + ", oferta="
				+ oferta + "]";
	}

}
