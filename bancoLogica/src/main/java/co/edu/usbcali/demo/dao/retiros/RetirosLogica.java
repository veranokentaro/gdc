   package co.edu.usbcali.demo.dao.retiros;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

 
import co.edu.usbcali.demo.dao.tipodocumento.ITipoDocumentoDAO;
import co.edu.usbcali.demo.modelo.Clientes;
import co.edu.usbcali.demo.modelo.TiposDocumentos;
import co.edu.usbcali.demo.modelo.Retiros;

@Service
@Scope("singleton")
public class RetirosLogica implements IRetirosLogica {
	
	 
	@Autowired
	private IRetirosDAO retirosDAO;
	

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void grabar(Retiros retiros) throws Exception {
		if(retiros==null){
			throw new Exception("El   retiro es null");
		}
		if(retiros.getRetDescripcion()==null || retiros.getRetDescripcion().trim().equals("")==true){
			throw new Exception("La descripcion es obligatori");
		}
		if(retiros.getRetFecha() == null){
			throw new Exception("La fecha es obligatoria");
		}
		
		retirosDAO.grabar(retiros);
		
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void modificar(Retiros retiros) throws Exception {
		if(retiros==null){
			throw new Exception("El   retiro es null");
		}
		if(retiros.getRetDescripcion()==null || retiros.getRetDescripcion().trim().equals("")==true){
			throw new Exception("La descripcion es obligatori");
		}
		if(retiros.getRetFecha() == null){
			throw new Exception("La fecha es obligatoria");
		}
		
		
		retirosDAO.modificar(retiros);

	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void borrar(Retiros retiros) throws Exception {
		if(retiros==null){
			throw new Exception("El   retiro es null");
		}
		Retiros entity=retirosDAO.consultarRetirosPor(retiros.getId().getRetCodigo(),retiros.getId().getCueNumero());
		if(entity==null){
			throw new Exception("El tipos de usuario que desea eliminar no existe");
		}
		
		retirosDAO.borrar(entity);

	}

	@Override
	@Transactional(readOnly=true)
	public Retiros consultarRetirosPor(long tipoUser, String cuenta) throws Exception {
		return retirosDAO.consultarRetirosPor(tipoUser,cuenta);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Retiros> consultarTodos() throws Exception {		
		return retirosDAO.consultarTodos();
	}

}
