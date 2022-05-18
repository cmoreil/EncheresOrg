package fr.eni.ecole.Encheres.bll.managers;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import fr.eni.ecole.Encheres.dal.dao.DAOFactory;
import fr.eni.ecole.Encheres.dal.dao.UserDao;
import fr.eni.ecole.Encheres.modeles.bll.bo.User;

public class UserManagerImpl implements UserManager {

	private static UserManager instance = null;
	private UserDao userDao = DAOFactory.getUserDao();

	private UserManagerImpl() {
	}

	public static UserManager getInstance() {
		if (instance == null) {
			instance = new UserManagerImpl();
		}
		return instance;
	}

	@Override
	public String cryptedPsswd(String password) {
		// md5
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		byte[] md5sum = md.digest(password.getBytes());
		String pwdOutput = String.format("%032X", new BigInteger(1, md5sum));
		return pwdOutput;
	}

	@Override
	public User save(User user) {
		//cryptage mdp
		String password = user.getPassword();
		String cryptedPasswd = cryptedPsswd(password);
		user.setPassword(cryptedPasswd);
		userDao.save(user);
		return user;
	}

	@Override
	public User findByEmailAndMdp(String mail, String password) {
		String psswdCrypted = cryptedPsswd(password);
		return userDao.findByEmailAndMdp(mail, psswdCrypted);
	}

	@Override
	public User update(User utilisateurAModifier) {
		String mdpcrypte2 = cryptedPsswd(utilisateurAModifier.getPassword());
		utilisateurAModifier.setPassword(mdpcrypte2);
		return userDao.update(utilisateurAModifier);
	}

	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

}
