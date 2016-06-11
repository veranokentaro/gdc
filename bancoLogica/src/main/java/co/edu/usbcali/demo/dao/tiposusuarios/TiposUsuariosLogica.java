package co.edu.usbcali.demo.dao.tiposusuarios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

 
import co.edu.usbcali.demo.dao.tipodocumento.ITipoDocumentoDAO;
import co.edu.usbcali.demo.modelo.Clientes;
import co.edu.usbcali.demo.modelo.TiposDocumentos;
import co.edu.usbcali.demo.modelo.TiposUsuarios;

@Service
@Scope("singleton")
public class TiposUsuariosLogica implements ITiposUsuariosLogica {
	
	 
	@Autowired
	private ITiposUsuariosDAO tiposUsuariosDAO;
	

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void grabar(TiposUsuarios tiposUsuarios) throws Exception {
		if(tiposUsuarios==null){
			throw new Exception("El tipo de usuario es null");
		}
		if(tiposUsuarios.getTusuNombre()==null || tiposUsuarios.getTusuNombre().trim().equals("")==true){
			throw new Exception("El nombre es obligatorio");
		}
		if(tiposUsuarios.getTusuCodigo()==0){
			throw new Exception("El c�digo es obligatorio");
		}
		
		tiposUsuariosDAO.grabar(tiposUsuarios);
		
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void modificar(TiposUsuarios tiposUsuarios) throws Exception {
		if(tiposUsuarios==null){
			throw new Exception("El tipo de usuario es null");
		}
		if(tiposUsuarios.getTusuNombre()==null || tiposUsuarios.getTusuNombre().trim().equals("")==true){
			throw new Exception("El nombre es obligatorio");
		}
		if(tiposUsuarios.getTusuCodigo()==0){
			throw new Exception("El c�digo es obligatorio");
		}
		
		
		tiposUsuariosDAO.modificar(tiposUsuarios);

	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void borrar(TiposUsuarios tiposUsuarios) throws Exception {
		if(tiposUsuarios==null){
			throw new Exception("El tipo de usuario es null");
		}
		TiposUsuarios entity=tiposUsuariosDAO.consultarUsuarioPorId(tiposUsuarios.getTusuCodigo());
		if(entity==null){
			throw new Exception("El tipos de usuario que desea eliminar no existe");
		}
		
		tiposUsuariosDAO.borrar(entity);

	}

	@Override
	@Transactional(readOnly=true)
	public TiposUsuarios consultarTipoUsuarioPorId(long tipoUserId) throws Exception {
		return tiposUsuariosDAO.consultarUsuarioPorId(tipoUserId);
	}

	@Override
	@Transactional(readOnly=true)
	public List<TiposUsuarios> consultarTodos() throws Exception {		
		return tiposUsuariosDAO.consultarTodos();
	}

}
