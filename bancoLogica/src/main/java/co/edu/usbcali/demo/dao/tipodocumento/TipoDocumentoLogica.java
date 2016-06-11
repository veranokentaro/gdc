package co.edu.usbcali.demo.dao.tipodocumento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.demo.dao.cliente.IClienteDAO;
import co.edu.usbcali.demo.dao.tipodocumento.ITipoDocumentoDAO;
import co.edu.usbcali.demo.modelo.Clientes;
import co.edu.usbcali.demo.modelo.TiposDocumentos;

@Service
@Scope("singleton")
public class TipoDocumentoLogica implements ITipoDocumentoLogica {
	
	@Autowired
	private ITipoDocumentoDAO tipoDocumentoDAO;
	
	 

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void grabar(TiposDocumentos tiposDocumentos) throws Exception {
		if(tiposDocumentos==null){
			throw new Exception("El tipo de documento es null");
		}
		if(tiposDocumentos.getTdocNombre()==null || tiposDocumentos.getTdocNombre().trim().equals("")==true){
			throw new Exception("El nombre es obligatorio");
		}
		if(tiposDocumentos.getTdocCodigo()==0){
			throw new Exception("El codigo es obligatorio");
		}
		tipoDocumentoDAO.grabar(tiposDocumentos);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void modificar(TiposDocumentos tiposDocumentos) throws Exception {
		if(tiposDocumentos==null){
			throw new Exception("El tipo de documento es null");
		}
		if(tiposDocumentos.getTdocNombre()==null || tiposDocumentos.getTdocNombre().trim().equals("")==true){
			throw new Exception("El nombre es obligatorio");
		}
		if(tiposDocumentos.getTdocCodigo()==0){
			throw new Exception("El codigo es obligatorio");
		}
 
		tipoDocumentoDAO.modificar(tiposDocumentos);

	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void borrar(TiposDocumentos tiposDocumentos) throws Exception {
		if(tiposDocumentos==null){
			throw new Exception("El tipo de documento es null");
		}
		TiposDocumentos entity=tipoDocumentoDAO.consultarTipoDocumentoId(tiposDocumentos.getTdocCodigo());
		if(entity==null){
			throw new Exception("El tipo de documento que desea eliminar no existe");
		}
		
		tipoDocumentoDAO.borrar(entity);

	}

	 
	@Override
	@Transactional(readOnly=true)
	public List<TiposDocumentos> consultarTodos() throws Exception {		
		return tipoDocumentoDAO.consultarTodos();
	}

	@Override
	public TiposDocumentos consultarTipoDocumentoPorId(long tipoDocId) throws Exception {
		return tipoDocumentoDAO.consultarTipoDocumentoId(tipoDocId);
	}

}
