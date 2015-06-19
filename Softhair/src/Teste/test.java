/**
 * 
 */
package Teste;

import org.hibernate.Session;
import org.hibernate.Transaction;

import softhair.model.Funcionario;
import softhair.model.Usuario;
import softhair.util.HibernateUtil;

/**
 * @author Victor Ferrucy
 *
 */
public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		Usuario usuario = new Usuario();
		usuario.setLogin("Test2e");
		usuario.setSenha("teste2");
		usuario.setFuncionario(new Funcionario());
		
		session.save(usuario);
		transaction.commit();
	}

}
