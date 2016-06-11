    package co.edu.usbcali.demo.dao.consignaciones;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

 
import co.edu.usbcali.demo.dao.tipodocumento.ITipoDocumentoDAO;
import co.edu.usbcali.demo.modelo.Clientes;
import co.edu.usbcali.demo.modelo.TiposDocumentos;
import co.edu.usbcali.demo.modelo.Consignaciones;

@Service
@Scope("singleton")
public class ConsignacionesLogica implements IConsignacionesLogica {
	
	 
	@Autowired
	private IConsignacionesDAO consignacionesDAO;
	

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void grabar(Consignaciones consignaciones) throws Exception {
		if(consignaciones==null){
			throw new Exception("La consignacion es null");
		}
		if(consignaciones.getConDescripcion()==null || consignaciones.getConDescripcion().trim().equals("")==true){
			throw new Exception("El numero de la descripcion es obligatoria");
		}
		if(consignaciones.getConDescripcion()==null || consignaciones.getConDescripcion().trim().equals("")==true){
			throw new Exception("El numero de la descripcion es obligatoria");
		}
		
		
		if(consignaciones.getConFecha()==null ){
			throw new Exception("la fecha es obligatoria");
		}
		
		if(consignaciones.getConValor()==null){
			throw new Exception("El valor es obligatorio");
		}
		
		 
		
		consignacionesDAO.grabar(consignaciones);
		
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void modificar(Consignaciones consignaciones) throws Exception {
		if(consignaciones==null){
			throw new Exception("La consignacion es null");
		}
		if(consignaciones.getConDescripcion()==null || consignaciones.getConDescripcion().trim().equals("")==true){
			throw new Exception("El numero de la descripcion es obligatoria");
		}
		if(consignaciones.getConDescripcion()==null || consignaciones.getConDescripcion().trim().equals("")==true){
			throw new Exception("El numero de la descripcion es obligatoria");
		}
		
		
		if(consignaciones.getConFecha()==null ){
			throw new Exception("la fecha es obligatoria");
		}
		
		if(consignaciones.getConValor()==null){
			throw new Exception("El valor es obligatorio");
		}
		
		
		consignacionesDAO.modificar(consignaciones);

	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void borrar(Consignaciones consignaciones) throws Exception {
		if(consignaciones==null){
			throw new Exception("El tipo de usuario es null");
		}
		Consignaciones entity=consignacionesDAO.consultarConsignacionPor(consignaciones.getId().getConCodigo(),consignaciones.getId().getCueNumero());
		if(entity==null){
			throw new Exception("El tipos de usuario que desea eliminar no existe");
		}
		
		consignacionesDAO.borrar(entity);

	}

	@Override
	@Transactional(readOnly=true)
	public Consignaciones consultarConsignacionPor(long tipoUser, String cuenta) throws Exception {
		return consignacionesDAO.consultarConsignacionPor(tipoUser, cuenta);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Consignaciones> consultarTodos() throws Exception {		
		return consignacionesDAO.consultarTodos();
	}

}
