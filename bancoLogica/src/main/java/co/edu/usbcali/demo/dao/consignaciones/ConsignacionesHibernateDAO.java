  package co.edu.usbcali.demo.dao.consignaciones;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.demo.modelo.Clientes;
import co.edu.usbcali.demo.modelo.Consignaciones;
import co.edu.usbcali.demo.modelo.ConsignacionesId;

@Repository
@Scope("singleton")
public class ConsignacionesHibernateDAO implements IConsignacionesDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void grabar(Consignaciones consignaciones) {
		sessionFactory.getCurrentSession().save(consignaciones);		
	}

	@Override
	public void modificar(Consignaciones consignaciones) {
		sessionFactory.getCurrentSession().update(consignaciones);		
	}

	@Override
	public void borrar(Consignaciones consignaciones) {
		sessionFactory.getCurrentSession().delete(consignaciones);
	}

	@Override
	public Consignaciones consultarConsignacionPor(long consig, String cuenta) {
		ConsignacionesId conId = new ConsignacionesId(consig, cuenta);
		return sessionFactory.getCurrentSession().get(Consignaciones.class, conId);
	}

	@Override
	public List<Consignaciones> consultarTodos() {
		return sessionFactory.getCurrentSession().createCriteria(Consignaciones.class).list();
	}

}
