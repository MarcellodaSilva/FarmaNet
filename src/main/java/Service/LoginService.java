package Service;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.inject.Inject;

import exception.ValidacaoException;
import model.entity.Usuario;

@Stateless
public class LoginService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioService usuarioService;

	public Usuario logar(String senha, String login) throws ValidacaoException {
		if (!senha.trim().isEmpty() && !login.trim().isEmpty()) {
			Usuario user = usuarioService.getUsuarioByLoginSenha(login, senha);
			return user;
		} else {
			throw new ValidacaoException("Erro de Login");
		}

	}

}
