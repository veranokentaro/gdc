 package co.edu.usbcali.demo.dao.retirosid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

 
import co.edu.usbcali.demo.dao.tipodocumento.ITipoDocumentoDAO;
import co.edu.usbcali.demo.modelo.Clientes;
import co.edu.usbcali.demo.modelo.TiposDocumentos;
import co.edu.usbcali.demo.modelo.RetirosId;

@Service
@Scope("singleton")
public class RetirosIdLogica implements IRetirosIdLogica {
	
	 
	@Autowired
	private IRetirosIdDAO retirosIdDAO;
	

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void grabar(RetirosId retirosId) throws Exception {
		if(retirosId==null){
			throw new Exception("El id del retiro es null");
		}
		if(retirosId.getCueNumero()==null || retirosId.getCueNumero().trim().equals("")==true){
			throw new Exception("El numero de cuenta es obligatorio");
		}
		if(retirosId.getRetCodigo()==0){
			throw new Exception("El c�digo es obligatorio");
		}
		
		retirosIdDAO.grabar(retirosId);
		
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void modificar(RetirosId retirosId) throws Exception {
		if(retirosId==null){
			throw new Exception("El id del retiro es null");
		}
		if(retirosId.getCueNumero()==null || retirosId.getCueNumero().trim().equals("")==true){
			throw new Exception("El numero de cuenta es obligatorio");
		}
		if(retirosId.getRetCodigo()==0){
			throw new Exception("El c�digo es obligatorio");
		}
		
		
		retirosIdDAO.modificar(retirosId);

	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void borrar(RetirosId retirosId) throws Exception {
		if(retirosId==null){
			throw new Exception("El tipo de usuario es null");
		}
		RetirosId entity=retirosIdDAO.consultarRetirosIdPorId(retirosId.getRetCodigo());
		if(entity==null){
			throw new Exception("El tipos de usuario que desea eliminar no existe");
		}
		
		retirosIdDAO.borrar(entity);

	}

	@Override
	@Transactional(readOnly=true)
	public RetirosId consultarRetirosIdPorId(long tipoUserId) throws Exception {
		return retirosIdDAO.consultarRetirosIdPorId(tipoUserId);
	}

	@Override
	@Transactional(readOnly=true)
	public List<RetirosId> consultarTodos() throws Exception {		
		return retirosIdDAO.consultarTodos();
	}

}
