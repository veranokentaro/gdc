package co.edu.usbcali.demo.test;

import static org.junit.Assert.assertNotNull;

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

import co.edu.usbcali.demo.dao.cliente.IClienteLogica;
import co.edu.usbcali.demo.dao.tipodocumento.ITipoDocumentoLogica;
import co.edu.usbcali.demo.modelo.Clientes;
import co.edu.usbcali.demo.modelo.TiposDocumentos;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class TipoDocumentoLogicaTest {
	
	private static final Logger log=LoggerFactory.getLogger(TipoDocumentoLogicaTest.class);
	
	@Autowired
	private IClienteLogica clienteLogica;
	
	@Autowired
	private ITipoDocumentoLogica tipoDocumentoLogica;
	
	@Test
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	@Rollback(false)
	public void atest()throws Exception {
         
	   	TiposDocumentos tipoDocumento = new TiposDocumentos();
	   	tipoDocumento.setTdocCodigo(101);
	   	tipoDocumento.setTdocNombre("PASAPORTE");
	   	
        tipoDocumentoLogica.grabar(tipoDocumento);
        assertNotNull("Tipo documento nulo",tipoDocumentoLogica.consultarTipoDocumentoPorId(tipoDocumento.getTdocCodigo()));
        log.info("Nuevo documento: "+tipoDocumentoLogica.consultarTipoDocumentoPorId(tipoDocumento.getTdocCodigo()).getTdocNombre());

	}
	
	
	@Test
	@Transactional(readOnly=true)
	public void btest()throws Exception {
	//Consultar tipos de documento
		List<TiposDocumentos> lsTiposDocumentos = tipoDocumentoLogica.consultarTodos();
		for(TiposDocumentos tiposDocumentos : lsTiposDocumentos){
			log.info("Tipo documento: "+tiposDocumentos.getTdocNombre());
		}
	}
	
	@Test
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	@Rollback(false)
	public void ctest()throws Exception {
		TiposDocumentos tipoDocumento=tipoDocumentoLogica.consultarTipoDocumentoPorId(101);	
		tipoDocumento.setTdocNombre("LICENCIA DE CONDUCCI�N");
		tipoDocumentoLogica.modificar(tipoDocumento);
		
		tipoDocumento=tipoDocumentoLogica.consultarTipoDocumentoPorId(101);
		assertNotNull("El cliente no exsiste",tipoDocumento);
		log.info("NUEVO NOMBRE DOC: "+tipoDocumento.getTdocNombre());
	}
	
	@Test
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	@Rollback(false)
	public void dtest()throws Exception {
		TiposDocumentos tipoDocumento=tipoDocumentoLogica.consultarTipoDocumentoPorId(101);
		assertNotNull("El cliente no exsiste",tipoDocumento);
		tipoDocumentoLogica.borrar(tipoDocumento);
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