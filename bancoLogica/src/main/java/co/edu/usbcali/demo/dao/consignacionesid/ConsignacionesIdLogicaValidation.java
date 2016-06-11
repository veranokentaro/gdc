  package co.edu.usbcali.demo.dao.consignacionesid;

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
import co.edu.usbcali.demo.modelo.ConsignacionesId;

@Service
@Scope("singleton")
public class ConsignacionesIdLogicaValidation implements IConsignacionesIdLogica {
	
	private Logger log=LoggerFactory.getLogger(ConsignacionesIdLogicaValidation.class);
	
	@Autowired
	private IConsignacionesIdDAO consignacionesIdDAO;
	
	 
	@Autowired
	private Validator validator;
	

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void grabar(ConsignacionesId consignacionesId) throws Exception {
		
		StringBuilder stringBuilder=new StringBuilder();
		
		Set<ConstraintViolation<ConsignacionesId>> constraintViolations=validator.validate(consignacionesId);
		if(constraintViolations.size()>0){
			for (ConstraintViolation<ConsignacionesId> constraintViolation : constraintViolations) {
				log.error(constraintViolation.getPropertyPath().toString());
				log.error(constraintViolation.getMessage());
				stringBuilder.append(constraintViolation.getPropertyPath().toString());
				stringBuilder.append("-");
				stringBuilder.append(constraintViolation.getMessage());
				stringBuilder.append(",");
			}
			throw new Exception(stringBuilder.toString());
		}
		
	 
		consignacionesIdDAO.grabar(consignacionesId);
		
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void modificar(ConsignacionesId consignacionesId) throws Exception {
StringBuilder stringBuilder=new StringBuilder();
		
		Set<ConstraintViolation<ConsignacionesId>> constraintViolations=validator.validate(consignacionesId);
		if(constraintViolations.size()>0){
			for (ConstraintViolation<ConsignacionesId> constraintViolation : constraintViolations) {
				log.error(constraintViolation.getPropertyPath().toString());
				log.error(constraintViolation.getMessage());
				stringBuilder.append(constraintViolation.getPropertyPath().toString());
				stringBuilder.append("-");
				stringBuilder.append(constraintViolation.getMessage());
				stringBuilder.append(",");
			}
			throw new Exception(stringBuilder.toString());
		}
		
		 
		consignacionesIdDAO.modificar(consignacionesId);

	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void borrar(ConsignacionesId consignacionesId) throws Exception {
StringBuilder stringBuilder=new StringBuilder();
		
		Set<ConstraintViolation<ConsignacionesId>> constraintViolations=validator.validate(consignacionesId);
		if(constraintViolations.size()>0){
			for (ConstraintViolation<ConsignacionesId> constraintViolation : constraintViolations) {
				log.error(constraintViolation.getPropertyPath().toString());
				log.error(constraintViolation.getMessage());
				stringBuilder.append(constraintViolation.getPropertyPath().toString());
				stringBuilder.append("-");
				stringBuilder.append(constraintViolation.getMessage());
				stringBuilder.append(",");
			}
			throw new Exception(stringBuilder.toString());
		}
		ConsignacionesId entity=consignacionesIdDAO.consultarConsignacionIdPorId(consignacionesId.getConCodigo());
		if(entity==null){
			throw new Exception("El tipo de usuario que desea eliminar no existe");
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
