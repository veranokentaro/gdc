package co.edu.usbcali.demo.test;

import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.demo.dao.Cuentas.ICuentasLogica;
import co.edu.usbcali.demo.dao.cliente.IClienteLogica;
import co.edu.usbcali.demo.dao.tiposusuarios.ITiposUsuariosLogica;
import co.edu.usbcali.demo.dao.usuarios.IUsuariosLogica;
import co.edu.usbcali.demo.modelo.Clientes;
import co.edu.usbcali.demo.modelo.Cuentas;
import co.edu.usbcali.demo.modelo.TiposUsuarios;
import co.edu.usbcali.demo.modelo.Usuarios;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class UsuarioLogicaTest {
	
	private static final Logger log=LoggerFactory.getLogger(UsuarioLogicaTest.class);
	

	@Autowired
	private IUsuariosLogica usuarioLogica;
	
	@Autowired
	private ITiposUsuariosLogica tiposUsuariosLogica;
	
    @Test
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	@Rollback(false)
	public void atest()throws Exception {
		TiposUsuarios tipoUsuario = tiposUsuariosLogica.consultarTipoUsuarioPorId(10);
	   	Usuarios usuario = new Usuarios();
	   	usuario.setTiposUsuarios(tipoUsuario);
	   	usuario.setUsuCedula(1112300983);
	   	usuario.setUsuClave("astra$12345");
	   	usuario.setUsuLogin("optimus");
	   	usuario.setUsuNombre("JOSE ARNES");
	   	usuarioLogica.grabar(usuario);
        //assertNotNull("Tipo documento nulo",cuentaLogica.consultarCuentaPorId(cuenta.getCueNumero()));

	}
	
	
	@Test
	@Transactional(readOnly=true)
	public void btest()throws Exception {
	//Consultar tipos de documento
		List<Usuarios> lstUsuarios = usuarioLogica.consultarTodos();
		for(Usuarios usuario : lstUsuarios){
			log.info("Usuario: "+usuario.getUsuLogin()+" cedula: "+usuario.getUsuCedula());
		}
	}
	
	@Test
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	@Rollback(false)
	public void ctest()throws Exception {
 		Usuarios usuario = usuarioLogica.consultarUsuarioPorId(1112300983);
 		usuario.setUsuNombre("ADRIANA INMOVIL");
 		usuarioLogica.modificar(usuario);
		
 		usuario=usuarioLogica.consultarUsuarioPorId(usuario.getUsuCedula());
		assertNotNull("El cliente no exsiste",usuario);
		log.info("NUEVO NOMBRE: "+usuario.getUsuNombre());
	}
	
	@Test
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	@Rollback(false)
	public void dtest()throws Exception {
		Usuarios usuario = usuarioLogica.consultarUsuarioPorId(1112300983);
    	assertNotNull("El usuario no exsiste",usuario);
    	usuarioLogica.borrar(usuario);
	}

	
	
	

}