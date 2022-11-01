package com.aplicacionTFM.repository;

import java.util.List;

import com.aplicacionTFM.domain.CarritoDTO;
import com.aplicacionTFM.domain.ProductoDTO;
import com.aplicacionTFM.domain.RespuestaDTO;

public interface ProductoDAO {
	
	public List<ProductoDTO> getListaProductosOferta(String categoria);
	public List<CarritoDTO> getListaCarrito(String usuario);
	public RespuestaDTO agregarCarrito(String prodeucto, String usuario, String cantidad, String fecha);
	public RespuestaDTO editaCarrito(String car_n, String cantidad);

}
