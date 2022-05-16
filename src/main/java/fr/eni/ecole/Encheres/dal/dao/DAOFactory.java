package fr.eni.ecole.Encheres.dal.dao;

public abstract class DAOFactory {

	public static UserDao getUserDao() {
		return UserDaoImpl.getInstance();
	}
	
	public static DispatchDao getDispatchDao() {
		return DispatchDaoImpl.getInstance();
	}
	
	public static CategoryDao getCategoryDao() {
		return CategoryDaoImpl.getInstance();
	}
	
	public static AuctionDao getAuctionDao() {
		return AuctionDaoImpl.getInstance();
	}
	
	public static ArticleDao getArticleDao() {
		return ArticleDaoImpl.getInstance();
	}
}
