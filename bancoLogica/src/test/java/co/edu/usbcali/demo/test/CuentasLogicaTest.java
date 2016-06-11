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
import co.edu.usbcali.demo.modelo.Clientes;
import co.edu.usbcali.demo.modelo.Cuentas;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class CuentasLogicaTest {
	
	private static final Logger log=LoggerFactory.getLogger(CuentasLogicaTest.class);
	

	@Autowired
	private ICuentasLogica cuentaLogica;
	
	@Autowired
	private IClienteLogica clienteLogica;
	
	@Test
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	@Rollback(false)
	public void atest()throws Exception {
		Clientes cliente = clienteLogica.consultarClinetePorId(151234); 
	   	Cuentas cuenta = new Cuentas();
	   	cuenta.setCueActiva("SI");
	   	cuenta.setCueClave("3281");
	   	cuenta.setCueNumero("1234-4567-9876-1254");
	   	cuenta.setCueSaldo(new BigDecimal("1200000"));
	   	cuenta.setClientes(cliente);
        cuentaLogica.grabar(cuenta);
        //assertNotNull("Tipo documento nulo",cuentaLogica.consultarCuentaPorId(cuenta.getCueNumero()));

	}
	
	
	@Test
	@Transactional(readOnly=true)
	public void btest()throws Exception {
	//Consultar tipos de documento
		List<Cuentas> lstCuentas = cuentaLogica.consultarTodos();
		for(Cuentas cuenta : lstCuentas){
			log.info("Tipo documento: "+cuenta.getCueNumero());
		}
	}
	
	@Test
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	@Rollback(false)
	public void ctest()throws Exception {
 		Cuentas cuenta=cuentaLogica.consultarCuentaPorId("1234-4567-9876-1254");
		cuenta.setCueSaldo(new BigDecimal("800000"));
		cuentaLogica.modificar(cuenta);
		
		cuenta=cuentaLogica.consultarCuentaPorId(cuenta.getCueNumero());
		assertNotNull("El cliente no exsiste",cuenta);
		log.info("NUEVO SALDO: "+cuenta.getCueSaldo());
	}
	
	@Test
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	@Rollback(false)
	public void dtest()throws Exception {
		Cuentas cuenta=cuentaLogica.consultarCuentaPorId("1234-4567-9876-1254");
		assertNotNull("El cliente no exsiste",cuenta);
		cuentaLogica.borrar(cuenta);
	}

	//@Test
	@Transactional(readOnly=true)
	public void etest()throws Exception {
		List<Clientes> losClientes=clienteLogica.consultarTodos();
		for (Clientes clientes : losClientes) {
			log.info(clientes.getCliNombre());
		}
	}
	
	

}