package com.aplicacionTFM.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.aplicacionTFM.domain.UsuarioDTO;
import com.aplicacionTFM.domain.ProductoDTO;
import com.aplicacionTFM.repository.ProductoDAO;
import com.aplicacionTFM.repository.UsuarioDAO;

@Controller
public class UsuarioController {
	
	@Autowired
	@Qualifier("usuarioDAOImpl")
	private UsuarioDAO usuarioDAO;
	
	@Autowired
	@Qualifier("productoDAOImpl")
	private ProductoDAO productoDAOImpl;
	
	@RequestMapping(value="/usuarios", method=RequestMethod.GET)
	public ModelAndView consultaUsuario(@RequestParam(value="userN",required=false) String userN,
			HttpServletRequest request){
		
	//	SesionActiva sesionActiva = (SesionActiva) request.getSession(true).getAttribute("sesionActiva");
		
		ModelAndView mav = new ModelAndView("principal");
		
	//	if (sesionActiva != null && sesionActiva.getGnActor() != null) {
		
			
		UsuarioDTO usuario = new UsuarioDTO();
		List<ProductoDTO> productos = null;
		//HttpSession session = request.getSession();
					
		/*String actor = sesionActiva.getGsActorCve();
		
		String entidad = sesionActiva.getGsEntidadCve();
		
		String papel = sesionActiva.getGsPapelCve();
		String posiciones = null;*/
		
		usuario = usuarioDAO.consultaUsuario(userN);
		
		productos = productoDAOImpl.getListaProductosOferta("10");
		
		mav.addObject("usuario", usuario);
		mav.addObject("productos", productos);

		
	/*	} else {
			mav = new ModelAndView("Error");
		}*/
		return mav;
	}

}
