package co.edu.usbcali.demo.test;

import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.Date;
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
import co.edu.usbcali.demo.dao.consignaciones.IConsignacionesLogica;
import co.edu.usbcali.demo.dao.tipodocumento.ITipoDocumentoLogica;
import co.edu.usbcali.demo.dao.usuarios.IUsuariosLogica;
import co.edu.usbcali.demo.modelo.Clientes;
import co.edu.usbcali.demo.modelo.Consignaciones;
import co.edu.usbcali.demo.modelo.ConsignacionesId;
import co.edu.usbcali.demo.modelo.Cuentas;
import co.edu.usbcali.demo.modelo.TiposDocumentos;
import co.edu.usbcali.demo.modelo.Usuarios;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class ConsignacionesLogicaTest {
	
	private static final Logger log=LoggerFactory.getLogger(ConsignacionesLogicaTest.class);
	
	@Autowired
	private ICuentasLogica cuentaLogica;
	
	@Autowired
	private IUsuariosLogica usuarioLogica;
	
	@Autowired
	private IConsignacionesLogica consignacionesLogica;
	
	@Test
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	@Rollback(false)
	public void atest()throws Exception {
        Cuentas cuenta = cuentaLogica.consultarCuentaPorId("4008-5305-0010");  
        Usuarios usuario = usuarioLogica.consultarUsuarioPorId(10);
	   	ConsignacionesId consignacionId = new ConsignacionesId(101, cuenta.getCueNumero());
        
        Consignaciones consignaciones = new Consignaciones();
	   	consignaciones.setCuentas(cuenta);
	   	consignaciones.setConFecha(new Date());
	   	consignaciones.setUsuarios(usuario);
	   	consignaciones.setId(consignacionId);
	   	consignaciones.setConValor(new BigDecimal("120000"));
	   	consignaciones.setConDescripcion("OTRAS CONSIGNACIONES");
	   	
	   	consignacionesLogica.grabar(consignaciones);
        //assertNotNull("Tipo documento nulo",consignacionesLogica.consultarConsignacionPor(consignaciones.getId().getConCodigo()));
        //log.info("Nueva consignacion: "+consignacionesLogica.consultarConsignacionPor(consignaciones.getId().getConCodigo()).getConDescripcion());

	}
	
	
	@Test
	@Transactional(readOnly=true)
	public void btest()throws Exception {
	//Consultar tipos de documento
		List<Consignaciones> lstConsignaciones = consignacionesLogica.consultarTodos();
		for(Consignaciones consignaciones : lstConsignaciones){
			log.info("Consignaciones: "+consignaciones.getConDescripcion());
		}
	}
	
	@Test
	@Transactional(readOnly=true)
	public void ztest()throws Exception {
	//Consultar tipos de documento
		List<Consignaciones> lstConsignaciones = consignacionesLogica.consultarTodos();
		for(Consignaciones consignaciones : lstConsignaciones){
			log.info("Consignaciones: "+consignaciones.getConDescripcion());
		}
	}
	
	@Test
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	@Rollback(false)
	public void ctest()throws Exception {
		Consignaciones consignaciones=consignacionesLogica.consultarConsignacionPor(101,"4008-5305-0010");
		consignaciones.setConFecha(new Date());
		consignacionesLogica.modificar(consignaciones);
		
		consignaciones=consignacionesLogica.consultarConsignacionPor(101,"4008-5305-0010");
		assertNotNull("El cliente no exsiste",consignaciones);
		log.info("NUEVO NOMBRE DOC: "+consignaciones.getConFecha());
	}
	
	@Test
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	@Rollback(false)
	public void dtest()throws Exception {
		Consignaciones consignaciones=consignacionesLogica.consultarConsignacionPor(101,"4008-5305-0010");
		assertNotNull("El consignaciones no exsiste",consignaciones);
		consignacionesLogica.borrar(consignaciones);
	}


	
	

}