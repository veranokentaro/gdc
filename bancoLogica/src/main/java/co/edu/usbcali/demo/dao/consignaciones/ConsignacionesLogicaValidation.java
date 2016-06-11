package co.edu.usbcali.demo.dao.consignaciones;
 /*   package co.edu.usbcali.dem.dao.consignaciones;

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
import co.edu.usbcali.demo.modelo.Consignaciones;

@Service
@Scope("singleton")
public class ConsignacionesLogicaValidation implements IConsignacionesLogica {
	
	private Logger log=LoggerFactory.getLogger(ConsignacionesLogicaValidation.class);
	
	@Autowired
	private IConsignacionesDAO consignacionesDAO;
	
	 
	@Autowired
	private Validator validator;
	

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void grabar(Consignaciones consignaciones) throws Exception {
		
		StringBuilder stringBuilder=new StringBuilder();
		
		Set<ConstraintViolation<Consignaciones>> constraintViolations=validator.validate(consignaciones);
		if(constraintViolations.size()>0){
			for (ConstraintViolation<Consignaciones> constraintViolation : constraintViolations) {
				log.error(constraintViolation.getPropertyPath().toString());
				log.error(constraintViolation.getMessage());
				stringBuilder.append(constraintViolation.getPropertyPath().toString());
				stringBuilder.append("-");
				stringBuilder.append(constraintViolation.getMessage());
				stringBuilder.append(",");
			}
			throw new Exception(stringBuilder.toString());
		}
		
	 
		consignacionesDAO.grabar(consignaciones);
		
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void modificar(Consignaciones consignaciones) throws Exception {
StringBuilder stringBuilder=new StringBuilder();
		
		Set<ConstraintViolation<Consignaciones>> constraintViolations=validator.validate(consignaciones);
		if(constraintViolations.size()>0){
			for (ConstraintViolation<Consignaciones> constraintViolation : constraintViolations) {
				log.error(constraintViolation.getPropertyPath().toString());
				log.error(constraintViolation.getMessage());
				stringBuilder.append(constraintViolation.getPropertyPath().toString());
				stringBuilder.append("-");
				stringBuilder.append(constraintViolation.getMessage());
				stringBuilder.append(",");
			}
			throw new Exception(stringBuilder.toString());
		}
		
		 
		consignacionesDAO.modificar(consignaciones);

	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void borrar(Consignaciones consignaciones) throws Exception {
StringBuilder stringBuilder=new StringBuilder();
		
		Set<ConstraintViolation<Consignaciones>> constraintViolations=validator.validate(consignaciones);
		if(constraintViolations.size()>0){
			for (ConstraintViolation<Consignaciones> constraintViolation : constraintViolations) {
				log.error(constraintViolation.getPropertyPath().toString());
				log.error(constraintViolation.getMessage());
				stringBuilder.append(constraintViolation.getPropertyPath().toString());
				stringBuilder.append("-");
				stringBuilder.append(constraintViolation.getMessage());
				stringBuilder.append(",");
			}
			throw new Exception(stringBuilder.toString());
		}
		Consignaciones entity=consignacionesDAO.consultarConsignacionPor(consignaciones.getId().getConCodigo());
		if(entity==null){
			throw new Exception("El tipo de usuario que desea eliminar no existe");
		}
		
		consignacionesDAO.borrar(entity);

	}

	@Override
	@Transactional(readOnly=true)
	public Consignaciones consultarConsignacionPor(long tipoUser) throws Exception {
		return consignacionesDAO.consultarConsignacionPor(tipoUser);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Consignaciones> consultarTodos() throws Exception {		
		return consignacionesDAO.consultarTodos();
	}

}
*/