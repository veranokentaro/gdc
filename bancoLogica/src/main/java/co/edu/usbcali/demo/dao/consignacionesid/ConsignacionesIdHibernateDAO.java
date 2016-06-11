 package co.edu.usbcali.demo.dao.consignacionesid;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.demo.modelo.Clientes;
import co.edu.usbcali.demo.modelo.ConsignacionesId;

@Repository
@Scope("singleton")
public class ConsignacionesIdHibernateDAO implements IConsignacionesIdDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void grabar(ConsignacionesId consignacionesId) {
		sessionFactory.getCurrentSession().save(consignacionesId);		
	}

	@Override
	public void modificar(ConsignacionesId consignacionesId) {
		sessionFactory.getCurrentSession().update(consignacionesId);		
	}

	@Override
	public void borrar(ConsignacionesId consignacionesId) {
		sessionFactory.getCurrentSession().delete(consignacionesId);
	}

	@Override
	public ConsignacionesId consultarConsignacionIdPorId(long consigId) {
		return sessionFactory.getCurrentSession().get(ConsignacionesId.class, consigId);
	}

	@Override
	public List<ConsignacionesId> consultarTodos() {
		return sessionFactory.getCurrentSession().createCriteria(ConsignacionesId.class).list();
	}

}
