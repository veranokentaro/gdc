package co.edu.usbcali.demo.dao.tipodocumento;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import co.edu.usbcali.demo.dao.tipodocumento.ITipoDocumentoDAO;
import co.edu.usbcali.demo.modelo.Clientes;
import co.edu.usbcali.demo.modelo.TiposDocumentos;

@Service
@Scope("singleton")
public class TipoDocumentoValidation implements ITipoDocumentoLogica {
	
	private Logger log=LoggerFactory.getLogger(TipoDocumentoValidation.class);
	
	@Autowired
	private ITipoDocumentoDAO tipoDocumentoDAO;
	
 
	@Autowired
	private Validator validator;
	

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void grabar(TiposDocumentos tiposDocumentos) throws Exception {
		
		StringBuilder stringBuilder=new StringBuilder();
		
		Set<ConstraintViolation<TiposDocumentos>> constraintViolations=validator.validate(tiposDocumentos);
		if(constraintViolations.size()>0){
			for (ConstraintViolation<TiposDocumentos> constraintViolation : constraintViolations) {
				log.error(constraintViolation.getPropertyPath().toString());
				log.error(constraintViolation.getMessage());
				stringBuilder.append(constraintViolation.getPropertyPath().toString());
				stringBuilder.append("-");
				stringBuilder.append(constraintViolation.getMessage());
				stringBuilder.append(",");
			}
			throw new Exception(stringBuilder.toString());
		}
		
		 
		tipoDocumentoDAO.grabar(tiposDocumentos);
		
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void modificar(TiposDocumentos tiposDocumentos) throws Exception {
StringBuilder stringBuilder=new StringBuilder();
		
		Set<ConstraintViolation<TiposDocumentos>> constraintViolations=validator.validate(tiposDocumentos);
		if(constraintViolations.size()>0){
			for (ConstraintViolation<TiposDocumentos> constraintViolation : constraintViolations) {
				log.error(constraintViolation.getPropertyPath().toString());
				log.error(constraintViolation.getMessage());
				stringBuilder.append(constraintViolation.getPropertyPath().toString());
				stringBuilder.append("-");
				stringBuilder.append(constraintViolation.getMessage());
				stringBuilder.append(",");
			}
			throw new Exception(stringBuilder.toString());
		}
		 
		tipoDocumentoDAO.modificar(tiposDocumentos);

	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void borrar(TiposDocumentos tiposDocumentos) throws Exception {
StringBuilder stringBuilder=new StringBuilder();
		
		Set<ConstraintViolation<TiposDocumentos>> constraintViolations=validator.validate(tiposDocumentos);
		if(constraintViolations.size()>0){
			for (ConstraintViolation<TiposDocumentos> constraintViolation : constraintViolations) {
				log.error(constraintViolation.getPropertyPath().toString());
				log.error(constraintViolation.getMessage());
				stringBuilder.append(constraintViolation.getPropertyPath().toString());
				stringBuilder.append("-");
				stringBuilder.append(constraintViolation.getMessage());
				stringBuilder.append(",");
			}
			throw new Exception(stringBuilder.toString());
		}
		TiposDocumentos entity=tipoDocumentoDAO.consultarTipoDocumentoId(tiposDocumentos.getTdocCodigo());
		if(entity==null){
			throw new Exception("El tipo de documento que desea eliminar no existe");
		}
		
		tipoDocumentoDAO.borrar(entity);

	}

	@Override
	@Transactional(readOnly=true)
	public TiposDocumentos consultarTipoDocumentoPorId(long tipoDocId) throws Exception {
		return tipoDocumentoDAO.consultarTipoDocumentoId(tipoDocId);
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<TiposDocumentos> consultarTodos() throws Exception {		
		return tipoDocumentoDAO.consultarTodos();
	}

}
