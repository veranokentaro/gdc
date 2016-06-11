  package co.edu.usbcali.demo.dao.consignacionesid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

 
import co.edu.usbcali.demo.dao.tipodocumento.ITipoDocumentoDAO;
import co.edu.usbcali.demo.modelo.Clientes;
import co.edu.usbcali.demo.modelo.TiposDocumentos;
import co.edu.usbcali.demo.modelo.ConsignacionesId;

@Service
@Scope("singleton")
public class ConsignacionesIdLogica implements IConsignacionesIdLogica {
	
	 
	@Autowired
	private IConsignacionesIdDAO consignacionesIdDAO;
	

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void grabar(ConsignacionesId consignacionesId) throws Exception {
		if(consignacionesId==null){
			throw new Exception("La consignacion es null");
		}
		if(consignacionesId.getCueNumero()==null || consignacionesId.getCueNumero().trim().equals("")==true){
			throw new Exception("El numero de la consignaci�n es obligatorio");
		}
		if(consignacionesId.getConCodigo()==0){
			throw new Exception("El c�digo es obligatorio");
		}
		
		consignacionesIdDAO.grabar(consignacionesId);
		
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void modificar(ConsignacionesId consignacionesId) throws Exception {
		if(consignacionesId==null){
			throw new Exception("La consignacion es null");
		}
		if(consignacionesId.getCueNumero()==null || consignacionesId.getCueNumero().trim().equals("")==true){
			throw new Exception("El numero de la consignaci�n es obligatorio");
		}
		if(consignacionesId.getConCodigo()==0){
			throw new Exception("El c�digo es obligatorio");
		}
		
		
		consignacionesIdDAO.modificar(consignacionesId);

	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void borrar(ConsignacionesId consignacionesId) throws Exception {
		if(consignacionesId==null){
			throw new Exception("El tipo de usuario es null");
		}
		ConsignacionesId entity=consignacionesIdDAO.consultarConsignacionIdPorId(consignacionesId.getConCodigo());
		if(entity==null){
			throw new Exception("El tipos de usuario que desea eliminar no existe");
		}
		
		consignacionesIdDAO.borrar(entity);

	}

	@Override
	@Transactional(readOnly=true)
	public ConsignacionesId consultarConsignacionIdPorId(long tipoUserId) throws Exception {
		return consignacionesIdDAO.consultarConsignacionIdPorId(tipoUserId);
	}

	@Override
	@Transactional(readOnly=true)
	public List<ConsignacionesId> consultarTodos() throws Exception {		
		return consignacionesIdDAO.consultarTodos();
	}

}
