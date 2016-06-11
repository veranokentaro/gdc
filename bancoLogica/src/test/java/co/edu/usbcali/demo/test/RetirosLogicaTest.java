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
import co.edu.usbcali.demo.dao.retiros.IRetirosLogica;
import co.edu.usbcali.demo.dao.tipodocumento.ITipoDocumentoLogica;
import co.edu.usbcali.demo.dao.usuarios.IUsuariosLogica;
import co.edu.usbcali.demo.modelo.Clientes;
import co.edu.usbcali.demo.modelo.Consignaciones;
import co.edu.usbcali.demo.modelo.ConsignacionesId;
import co.edu.usbcali.demo.modelo.Cuentas;
import co.edu.usbcali.demo.modelo.Retiros;
import co.edu.usbcali.demo.modelo.RetirosId;
import co.edu.usbcali.demo.modelo.TiposDocumentos;
import co.edu.usbcali.demo.modelo.Usuarios;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class RetirosLogicaTest {
	
	private static final Logger log=LoggerFactory.getLogger(RetirosLogicaTest.class);
	
	@Autowired
	private ICuentasLogica cuentaLogica;
	
	@Autowired
	private IUsuariosLogica usuarioLogica;
	
	@Autowired
	private IRetirosLogica retirosLogica;
	
	@Test
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	@Rollback(false)
	public void atest()throws Exception {
        Cuentas cuenta = cuentaLogica.consultarCuentaPorId("4008-5305-0010");  
        Usuarios usuario = usuarioLogica.consultarUsuarioPorId(10);
        RetirosId retirosId = new RetirosId(101, cuenta.getCueNumero());
        
	   	Retiros retiros = new Retiros();
	   	retiros.setCuentas(cuenta);
	   	retiros.setRetFecha(new Date());
	   	retiros.setUsuarios(usuario);
	   	retiros.setId(retirosId);
	   	retiros.setRetValor(new BigDecimal("120000"));
	   	retiros.setRetDescripcion("OTRAS RETIROS");
	   	
	   	retirosLogica.grabar(retiros);
        //assertNotNull("Tipo documento nulo",consignacionesLogica.consultarConsignacionPor(consignaciones.getId().getConCodigo()));
        //log.info("Nueva consignacion: "+consignacionesLogica.consultarConsignacionPor(consignaciones.getId().getConCodigo()).getConDescripcion());

	}
	
	
	@Test
	@Transactional(readOnly=true)
	public void btest()throws Exception {
	//Consultar tipos de documento
		List<Retiros> lstRetiros = retirosLogica.consultarTodos();
		for(Retiros retiros : lstRetiros){
			log.info("Retiros: "+retiros.getRetDescripcion());
		}
	}
	
	@Test
	@Transactional(readOnly=true)
	public void ztest()throws Exception {
	//Consultar tipos de documento
		List<Retiros> lstRetiros  = retirosLogica.consultarTodos();
		for(Retiros retiros : lstRetiros){
			log.info("Consignaciones: "+retiros.getRetDescripcion());
		}
	}
	
	@Test
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	@Rollback(false)
	public void ctest()throws Exception {
		Retiros retiros=retirosLogica.consultarRetirosPor(101,"4008-5305-0010");
		retiros.setRetFecha(new Date());
		retirosLogica.modificar(retiros);
		
		retiros=retirosLogica.consultarRetirosPor(101,"4008-5305-0010");
		assertNotNull("El cliente no exsiste",retiros);
		log.info("NUEVO NOMBRE DOC: "+retiros.getRetFecha());
	}
	
	@Test
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	@Rollback(false)
	public void dtest()throws Exception {
		Retiros retiros=retirosLogica.consultarRetirosPor(101,"4008-5305-0010");
		assertNotNull("El consignaciones no exsiste",retiros);
		retirosLogica.borrar(retiros);
	}


	
	

}