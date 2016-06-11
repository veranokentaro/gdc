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
import co.edu.usbcali.demo.modelo.Clientes;
import co.edu.usbcali.demo.modelo.Cuentas;
import co.edu.usbcali.demo.modelo.TiposUsuarios;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class TipoUsuariosLogicaTest {
	
	private static final Logger log=LoggerFactory.getLogger(TipoUsuariosLogicaTest.class);
	

	@Autowired
	private ICuentasLogica cuentaLogica;
	
	@Autowired
	private ITiposUsuariosLogica tipoUsuarioLogica;
	
	@Test
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	@Rollback(false)
	public void atest()throws Exception {
		//Clientes cliente = clienteLogica.consultarClinetePorId(151234); 
	   	
		TiposUsuarios tipoUsuario = new TiposUsuarios();
		tipoUsuario.setTusuCodigo(101);
		tipoUsuario.setTusuNombre("Cliente VIP");
		tipoUsuarioLogica.grabar(tipoUsuario);
        //assertNotNull("Tipo documento nulo",cuentaLogica.consultarCuentaPorId(cuenta.getCueNumero()));

	}
	
	@Test
	@Transactional(readOnly=true)
	public void btest()throws Exception {
	//Consultar tipos de documento
		List<TiposUsuarios> lstTiposUsuarios = tipoUsuarioLogica.consultarTodos();
		for(TiposUsuarios tiposUsuarios : lstTiposUsuarios){
			log.info("Tipo usuario: "+tiposUsuarios.getTusuNombre()+" cod: "+tiposUsuarios.getTusuCodigo());
		}
	}
	
	@Test
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	@Rollback(false)
	public void ctest()throws Exception {
		TiposUsuarios tipoUsuario = tipoUsuarioLogica.consultarTipoUsuarioPorId(101);
		tipoUsuario.setTusuNombre("CUENTA VIP");
		tipoUsuarioLogica.modificar(tipoUsuario);
		
		tipoUsuario=tipoUsuarioLogica.consultarTipoUsuarioPorId(101);
		assertNotNull("El cliente no exsiste",tipoUsuario);
		log.info("NUEVO TIPO: "+tipoUsuario.getTusuNombre());
	}
	
	@Test
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	@Rollback(false)
	public void dtest()throws Exception {
		TiposUsuarios tipoUsuario = tipoUsuarioLogica.consultarTipoUsuarioPorId(101);
		assertNotNull("El tipo de usuario no exsiste",tipoUsuario);
		tipoUsuarioLogica.borrar(tipoUsuario);
	}



	

}