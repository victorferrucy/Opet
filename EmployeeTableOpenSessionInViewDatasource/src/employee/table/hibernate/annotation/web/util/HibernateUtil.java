/**
 * 
 */
package employee.table.hibernate.annotation.web.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Classe para realizar a ponte entre o arquivo de conex�o e o banco de dados.
 * 
 * @author Baracho
 * 
 * @since 14/04/2013
 * 
 * @version 1.0
 * 
 *          Acessado em 16/05/2013:
 * 
 *          http://stackoverflow.com/questions/8621906/is
 *          -buildsessionfactory-deprecated-in-hibernate-4
 * 
 *          http://stackoverflow.com
 *          /questions/7986750/create-session-factory-in-hibernate-4
 * 
 *          http://blog.caelum.com.br/as-novidades-do-hibernate-4/
 * 
 *          http://docs.jboss.org/hibernate/core/3.6/javadocs/org/hibernate/cfg/
 *          AnnotationConfiguration.html
 * 
 *          http://docs.jboss.org/hibernate/core/3.6
 *          /javadocs/org/hibernate/cfg/Configuration.html
 */
public class HibernateUtil {

	// Vari�veis de inst�ncia

	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {

		ServiceRegistry serviceRegistry = null;

		try {

			Configuration configuration = new Configuration();

			configuration.configure("hibernate.cfg.xml");

			serviceRegistry = new ServiceRegistryBuilder().applySettings(
					configuration.getProperties()).buildServiceRegistry();

			return configuration.buildSessionFactory(serviceRegistry);

		} catch (Throwable e) {
			System.err
					.println("Criação inicial do objeto SessionFactory falhou. Erro: "
							+ e);
			throw new ExceptionInInitializerError(e);
		}
	}

	public static SessionFactory getSessionFactory() {

		return sessionFactory;
	}

	public static void main(String[] args) {

		Session session = null;

		try {

			session = HibernateUtil.getSessionFactory().openSession();

			System.out.println("\n Objeto SessionFactory criado com sucesso.");

		} finally {
			// TODO: handle exception

			if (session != null && session.isOpen()) {

				session.close();

				System.out
						.println("\n Objeto SessionFactory fechado com sucesso.");

			}
		}
	}

}
