/**
 * 
 */
package employee.table.hibernate.annotation.web.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.hibernate.SessionFactory;

/**
 * Classe para interceptar as requisi��es que chegam ao servidor.
 * 
 * @author Baracho
 * 
 * @since 06/10/2014
 * 
 * @version 1.0
 * 
 */
public class ConnectionHibernateFilter implements Filter {

	// Vari�veis de inst�ncia

	private SessionFactory sessionFactory;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub

		this.sessionFactory = HibernateUtil.getSessionFactory();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 * javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub

		try {
			this.sessionFactory.openSession();
			this.sessionFactory.getCurrentSession().beginTransaction();
			filterChain.doFilter(servletRequest, servletResponse);
			this.sessionFactory.getCurrentSession().getTransaction().commit();
			this.sessionFactory.getCurrentSession().close();

		} catch (Throwable e) {
			// TODO: handle exception

			try {

				if (this.sessionFactory.getCurrentSession().getTransaction()
						.isActive()) {

					this.sessionFactory.getCurrentSession().getTransaction()
							.rollback();
				}

			} catch (Throwable e2) {
				// TODO: handle exception

				e2.printStackTrace();
			}

			throw new ServletException(e);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
