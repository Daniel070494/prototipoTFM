package com.aplicacionTFM.repositiry.impl;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.aplicacionTFM.domain.CarritoDTO;
import com.aplicacionTFM.domain.ProductoDTO;
import com.aplicacionTFM.domain.RespuestaDTO;
import com.aplicacionTFM.repository.ProductoDAO;

@Repository("productoDAOImpl")
public class ProductoDAOImpl implements ProductoDAO {
	
	@Autowired
	@Qualifier("jdbcTemplate")
	private JdbcTemplate jdbcTemplate;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<ProductoDTO> getListaProductosOferta(String categoria) {
		StringBuffer query = new StringBuffer();
		
		List<ProductoDTO> lista = null;
		
		query.append("\n SELECT ");
		query.append("\n     p.pro_n,");
		query.append("\n     p.nombre,");
		query.append("\n     p.precio, ");
		query.append("\n     p.imagen, ");
		query.append("\n     p.descripcion, ");
		query.append("\n     p.stock, ");
		query.append("\n     p.en_oferta, ");
		query.append("\n     DATE_FORMAT(fecha_registro, '%d/%m/%Y') AS fecha_registro, ");
		query.append("\n     c.descripcion as categoria, ");
		query.append("\n     op.descripcion as opcion_producto ");
		query.append("\n FROM ");
		query.append("\n     producto p, ");
		query.append("\n     categoria c, ");
		query.append("\n     estatus e, ");
		query.append("\n     opcion_producto op ");
		query.append("\n WHERE ");
		query.append("\n     p.cat_n = c.cat_n ");
		query.append("\n     AND p.est_n = e.est_n ");
		query.append("\n 	AND e.activo = 1 ");
		query.append("\n 	AND p.cat_n = " + categoria);
		query.append("\n     and p.opc_n = op.opc_n ");

		System.out.println("Query productos en oferta: " + query.toString());
		
		lista = (List<ProductoDTO>) jdbcTemplate.query(query.toString(), new RowMapper() {
			@Override
			public ProductoDTO mapRow(ResultSet rs, int filas) throws SQLException {
				ProductoDTO fila = new ProductoDTO();
				
				fila.setPro_n(rs.getString("pro_n"));
				fila.setPrecio(rs.getString("precio"));
				fila.setNombre(rs.getString("nombre"));
				fila.setImagen(rs.getString("imagen"));
				fila.setDescripcion(rs.getString("descripcion"));
				fila.setStock(rs.getString("stock"));
				fila.setFecha_registro(rs.getString("fecha_registro"));
				fila.setCategoria(rs.getString("categoria"));
				
				return fila;
			}
		});
		
		return lista;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<CarritoDTO> getListaCarrito(String usuario) {
		StringBuffer query = new StringBuffer();
		
		List<CarritoDTO> lista = null;
		
		query.append("\n SELECT " );
		query.append("\n     c.car_n," );
		query.append("\n     c.cantidad," );
		query.append("\n     p.nombre as nombre_producto," );
		query.append("\n     CONCAT(u.nombre," );
		query.append("\n             ' '," );
		query.append("\n             u.ap_paterno," );
		query.append("\n             ' '," );
		query.append("\n             u.ap_materno) AS nombre_usuario," );
		query.append("\n 	u.email," );
		query.append("\n     DATE_FORMAT(c.fecha, '%d/%m/%Y') AS fecha" );
		query.append("\n FROM" );
		query.append("\n     carrito c," );
		query.append("\n     producto p," );
		query.append("\n     usuario u" );
		query.append("\n     where u.user_n = 1" );
		query.append("\n     and c.pro_n = p.pro_n" );
		query.append("\n     and c.user_n = u.user_n" );
		
		System.out.println("Query productos en oferta: " + query.toString());
		
		lista = (List<CarritoDTO>) jdbcTemplate.query(query.toString(), new RowMapper() {
			@Override
			public CarritoDTO mapRow(ResultSet rs, int filas) throws SQLException {
				CarritoDTO fila = new CarritoDTO();
				
				fila.setCarN(rs.getString("car_n"));
				fila.setCantidad(rs.getString("cantidad"));
				fila.setNombre_producto(rs.getString("nombre_producto"));
				fila.setNombre_usuario(rs.getString("nombre_usuario"));
				fila.setEmail(rs.getString("email"));
				fila.setFecha(rs.getString("fecha"));
				
				return fila;
			}
		});
		
		return lista;
	}

	@Override
	public RespuestaDTO agregarCarrito(String prodeucto, String usuario, String cantidad, String fecha) {
	    RespuestaDTO respuestaDTO = new RespuestaDTO();
	    StringBuffer query = new StringBuffer();
	    
	    query.append("INSERT INTO carrito (pro_n, user_n, cantidad, fecha) VALUES (");
	    query.append(prodeucto + "," + usuario + "," + cantidad + ", sysdate())");

	    
	    System.out.println("Query agrega carreto: " + query.toString());
	    
	    int rowsAffected = jdbcTemplate.update(query.toString());
	    
	    respuestaDTO.setCodigo((rowsAffected > 0) ? new BigDecimal(0) : null);
	    respuestaDTO.setDescripcion(((rowsAffected > 0) ? "¡Se agrego con éxito!" : "¡Error al agregar el producto!"));
	    return respuestaDTO;

	}

	@Override
	public RespuestaDTO editaCarrito(String car_n, String cantidad) {
	    RespuestaDTO respuestaDTO = new RespuestaDTO();
	    StringBuffer query = new StringBuffer();
	    
	    query.append("UPDATE carrito SET cantidad = "+cantidad+" WHERE (car_n = "+car_n+")");
	    

	    
	    System.out.println("Query edita carreto: " + query.toString());
	    
	    int rowsAffected = jdbcTemplate.update(query.toString());
	    
	    respuestaDTO.setCodigo((rowsAffected > 0) ? new BigDecimal(0) : null);
	    respuestaDTO.setDescripcion(((rowsAffected > 0) ? "¡Se modificó con éxito!" : "¡Error al editar el producto!"));
	    return respuestaDTO;
	}

}
