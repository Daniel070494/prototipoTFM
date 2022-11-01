package com.aplicacionTFM.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.aplicacionTFM.domain.CarritoDTO;
import com.aplicacionTFM.domain.ProductoDTO;
import com.aplicacionTFM.domain.RespuestaDTO;
import com.aplicacionTFM.domain.UsuarioDTO;
import com.aplicacionTFM.repository.ProductoDAO;
import com.aplicacionTFM.repository.UsuarioDAO;

@Controller
public class TrabajoTFTMController {
	
	@Autowired
	@Qualifier("productoDAOImpl")
	private ProductoDAO productoDAOImpl;
	
	@Autowired
	@Qualifier("usuarioDAOImpl")
	private UsuarioDAO usuarioDAO;
	
	@RequestMapping(value="/appVentas", method=RequestMethod.GET)
	public ModelAndView prncipal(@RequestParam(value="usuario",required=false) String usuario,
			HttpServletRequest request){
		
		
		ModelAndView mav = new ModelAndView("principal");	
			
		UsuarioDTO datosUusario = new UsuarioDTO();
		List<ProductoDTO> productos = null;

		
		datosUusario = usuarioDAO.consultaUsuario(usuario);


		mav.addObject("datosUusario", datosUusario);
		
		return mav;
	}
	
	@RequestMapping(value="/ofertas", method=RequestMethod.GET)
	public ModelAndView ofertas(@RequestParam(value="usuario",required=false) String usuario,
			HttpServletRequest request){
		
		
		ModelAndView mav = new ModelAndView("/pages/productos_oferta");	
			
		List<ProductoDTO> celulares = null;
		List<ProductoDTO> comida = null;
		List<ProductoDTO> electronica = null;
		List<ProductoDTO> deportes = null;
		List<ProductoDTO> musica = null;
		List<ProductoDTO> ropa = null;

		celulares = productoDAOImpl.getListaProductosOferta("10");
		comida = productoDAOImpl.getListaProductosOferta("2");

		mav.addObject("celulares", celulares);
		mav.addObject("comida", comida);

		
		return mav;
	}
	
	@RequestMapping(value="/carrito", method=RequestMethod.GET)
	public ModelAndView carrito(@RequestParam(value="usuario",required=false) String usuario,
			HttpServletRequest request){
		
		
		ModelAndView mav = new ModelAndView("/pages/carrito_compras");	
			
		List<CarritoDTO> listaCarrito = null;

		listaCarrito = productoDAOImpl.getListaCarrito(usuario);

		mav.addObject("listaCarrito", listaCarrito);

		
		return mav;
	}
	
	@RequestMapping(value="/productos/agregarCarrito", method=RequestMethod.GET)
	public ModelAndView guardar(
			@RequestParam("producto") String producto,
			@RequestParam("usuario") String usuario,
			@RequestParam("cantidad") String cantidad){
		
		RespuestaDTO mensaje = productoDAOImpl.agregarCarrito(producto, usuario, cantidad, "");
		
		 ModelAndView mav = new ModelAndView("/pages/respuestas");
		 mav.addObject("mensaje", mensaje);
		 
		
		return mav;
	}
	
	@RequestMapping(value="/productos/editaCantidad", method=RequestMethod.GET)
	public ModelAndView guardar(
			@RequestParam("cantidad") String cantidad,
			@RequestParam("car_n") String car_n){
		
		RespuestaDTO mensaje = productoDAOImpl.editaCarrito(car_n, cantidad);
		
		 ModelAndView mav = new ModelAndView("/pages/respuestas");
		 mav.addObject("mensaje", mensaje);
		 
		
		return mav;
	}

}
