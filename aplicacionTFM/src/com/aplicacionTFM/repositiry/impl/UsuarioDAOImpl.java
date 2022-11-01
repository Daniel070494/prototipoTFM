package com.aplicacionTFM.repositiry.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.aplicacionTFM.domain.UsuarioDTO;
import com.aplicacionTFM.repository.UsuarioDAO;

@Service("usuarioDAOImpl")
public class UsuarioDAOImpl implements UsuarioDAO {
	
	@Autowired
	@Qualifier("jdbcTemplate")
	private JdbcTemplate jdbcTemplate;

	@SuppressWarnings("unchecked")
	@Override
	public UsuarioDTO consultaUsuario(String userN) {
		StringBuffer query = new StringBuffer();
		UsuarioDTO usuario = null;
		
		query.append("\n SELECT distinct U.user_n, " );
		query.append("\n 	U.email, " );
		query.append("\n 	U.nombre, ");
		query.append("\n 		U.ap_materno, ");
		query.append("\n 		U.ap_paterno,");
		query.append("\n 		U.rfc,");
		query.append("\n 		U.telefono, ");
		query.append("\n 		(select distinct count(car_n) from carrito where c.user_n = U.user_n) as totalCarrito ");
		query.append("\n FROM usuario U, estatus e, carrito c");
		query.append("\n WHERE U.est_n = e.est_n");
		query.append("\n  AND U.user_n = c.user_n");
		query.append("\n AND e.est_n = 'ACT' ");
		query.append("\nand u.email like '%"+userN+"%';");

		
		System.out.println("Query consulta usuario: " + query.toString());
		
		try{
		usuario = (UsuarioDTO) jdbcTemplate.queryForObject(query.toString(), new RowMapper() {
			
			@Override
			public UsuarioDTO mapRow(ResultSet rs, int rows) throws SQLException {
				UsuarioDTO fila = new UsuarioDTO();
				
				fila.setUserN(rs.getString("user_n"));
				fila.setNombre(rs.getString("nombre"));
				fila.setApPaterno(rs.getString("ap_paterno"));
				fila.setApMaterno(rs.getString("ap_materno"));
				fila.setRfc(rs.getString("rfc"));
				fila.setEmail(rs.getString("email"));
				fila.setTotalCarrito(rs.getString("totalCarrito"));
				
				return fila;
			}
		});
		} catch(DataAccessException e){
			System.out.println(e.toString());
		}
		return usuario;
	}

}
