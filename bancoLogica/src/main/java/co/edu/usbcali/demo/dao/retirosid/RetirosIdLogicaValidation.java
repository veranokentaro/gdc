package co.edu.usbcali.demo.dao.retirosid;

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
 
import co.edu.usbcali.demo.modelo.RetirosId;

@Service
@Scope("singleton")
public class RetirosIdLogicaValidation implements IRetirosIdLogica {
	
	private Logger log=LoggerFactory.getLogger(RetirosIdLogicaValidation.class);
	
	@Autowired
	private IRetirosIdDAO retirosIdDAO;
	
	 
	@Autowired
	private Validator validator;
	

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void grabar(RetirosId retirosId) throws Exception {
		
		StringBuilder stringBuilder=new StringBuilder();
		
		Set<ConstraintViolation<RetirosId>> constraintViolations=validator.validate(retirosId);
		if(constraintViolations.size()>0){
			for (ConstraintViolation<RetirosId> constraintViolation : constraintViolations) {
				log.error(constraintViolation.getPropertyPath().toString());
				log.error(constraintViolation.getMessage());
				stringBuilder.append(constraintViolation.getPropertyPath().toString());
				stringBuilder.append("-");
				stringBuilder.append(constraintViolation.getMessage());
				stringBuilder.append(",");
			}
			throw new Exception(stringBuilder.toString());
		}
		
	 
		retirosIdDAO.grabar(retirosId);
		
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void modificar(RetirosId retirosId) throws Exception {
StringBuilder stringBuilder=new StringBuilder();
		
		Set<ConstraintViolation<RetirosId>> constraintViolations=validator.validate(retirosId);
		if(constraintViolations.size()>0){
			for (ConstraintViolation<RetirosId> constraintViolation : constraintViolations) {
				log.error(constraintViolation.getPropertyPath().toString());
				log.error(constraintViolation.getMessage());
				stringBuilder.append(constraintViolation.getPropertyPath().toString());
				stringBuilder.append("-");
				stringBuilder.append(constraintViolation.getMessage());
				stringBuilder.append(",");
			}
			throw new Exception(stringBuilder.toString());
		}
		
		 
		retirosIdDAO.modificar(retirosId);

	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void borrar(RetirosId retirosId) throws Exception {
StringBuilder stringBuilder=new StringBuilder();
		
		Set<ConstraintViolation<RetirosId>> constraintViolations=validator.validate(retirosId);
		if(constraintViolations.size()>0){
			for (ConstraintViolation<RetirosId> constraintViolation : constraintViolations) {
				log.error(constraintViolation.getPropertyPath().toString());
				log.error(constraintViolation.getMessage());
				stringBuilder.append(constraintViolation.getPropertyPath().toString());
				stringBuilder.append("-");
				stringBuilder.append(constraintViolation.getMessage());
				stringBuilder.append(",");
			}
			throw new Exception(stringBuilder.toString());
		}
		RetirosId entity=retirosIdDAO.consultarRetirosIdPorId(retirosId.getRetCodigo());
		if(entity==null){
			throw new Exception("El tipo de usuario que desea eliminar no existe");
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
