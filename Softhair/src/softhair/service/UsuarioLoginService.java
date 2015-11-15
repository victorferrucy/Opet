/**
 * 
 */
package softhair.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import softhair.model.CargoSistema;
import softhair.model.Usuario;
import softhair.model.dao.UsuarioDao;

/**
 * @author Victor Ferrucy
 *
 */
public class UsuarioLoginService implements UserDetailsService {

	@Autowired
	private UsuarioDao usuarioDao;

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Usuario usuario = usuarioDao.buscar(login);

		if (usuario == null) {
			System.out.println("USUARIO NAO ENCONTRADO!");
			throw new UsernameNotFoundException("Usuário " + login + " não encontrado");
		}

		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		List<CargoSistema> cargos = usuarioDao.buscarCargos(usuario.getIdUsuario());
		for (CargoSistema cargo : cargos) {
			System.out.println("NOME CARGO " + cargo.getNomeCargo());
			authorities.add(new SimpleGrantedAuthority(cargo.getNomeCargo()));
		}
		System.out.println("USUARIO SERVICE" + usuario.getLogin() + usuario.getSenha());
		return new User(usuario.getLogin(), usuario.getSenha(), enabled, accountNonExpired, credentialsNonExpired,
				accountNonLocked, authorities);
	}

}
