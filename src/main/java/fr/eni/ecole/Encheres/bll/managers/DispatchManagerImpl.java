package fr.eni.ecole.Encheres.bll.managers;

import fr.eni.ecole.Encheres.dal.dao.DAOFactory;
import fr.eni.ecole.Encheres.dal.dao.DispatchDao;
import fr.eni.ecole.Encheres.modeles.bll.bo.Dispatch;

public class DispatchManagerImpl implements DispatchManager {

	private static DispatchManager instance = null;
	private DispatchDao DispatchDao = DAOFactory.getDispatchDao();
	
	private DispatchManagerImpl() {
	}

	public static DispatchManager getInstance() {
		if (instance == null) {
			instance = new DispatchManagerImpl();
		}
		return instance;
	}

	@Override
	public Dispatch save(Dispatch dispatch) {
		//vérif si set à faire
		DispatchDao.save(dispatch);
		return dispatch;
	}
}
