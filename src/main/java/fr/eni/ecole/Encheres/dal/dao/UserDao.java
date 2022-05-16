package fr.eni.ecole.Encheres.dal.dao;

import java.util.List;

import fr.eni.ecole.Encheres.modeles.bll.bo.User;

public interface UserDao {

	public User update(User utilisateurAModifier);

	public User save(User user);
	public User findByEmailAndMdp(String mail, String password);
	void delete(User user);
	public List<User> findAll();
	
}
