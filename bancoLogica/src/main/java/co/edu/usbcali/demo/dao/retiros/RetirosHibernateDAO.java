 package co.edu.usbcali.demo.dao.retiros;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.demo.modelo.Consignaciones;
import co.edu.usbcali.demo.modelo.ConsignacionesId;
import co.edu.usbcali.demo.modelo.Retiros;
import co.edu.usbcali.demo.modelo.RetirosId;

@Repository
@Scope("singleton")
public class RetirosHibernateDAO implements IRetirosDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void grabar(Retiros retiros) {
		sessionFactory.getCurrentSession().save(retiros);		
	}

	@Override
	public void modificar(Retiros retiros) {
		sessionFactory.getCurrentSession().update(retiros);		
	}

	@Override
	public void borrar(Retiros retiros) {
		sessionFactory.getCurrentSession().delete(retiros);
	}

	@Override
	public Retiros consultarRetirosPor(long codRetiro, String cuenta) {
		RetirosId retId = new RetirosId(codRetiro, cuenta);
		return sessionFactory.getCurrentSession().get(Retiros.class, retId);
	}

	@Override
	public List<Retiros> consultarTodos() {
		return sessionFactory.getCurrentSession().createCriteria(Retiros.class).list();
	}

}
