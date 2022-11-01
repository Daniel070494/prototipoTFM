package com.aplicacionTFM.repository;

import com.aplicacionTFM.domain.RespuestaDTO;
import com.aplicacionTFM.domain.SesionActiva;

public interface LoginDAO {
	
	  public RespuestaDTO validaLogin(String usuario, String password, String rol);
		  public RespuestaDTO bloqueaUsuario(String usuario);
		  public SesionActiva obtenDatosSesionActiva(String usuario, String rol);
		 

}
