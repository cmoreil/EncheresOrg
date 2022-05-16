package fr.eni.ecole.Encheres.bll.managers;

public abstract class ManagerFactory {

	public static UserManager getUserManager() {
		return UserManagerImpl.getInstance();
	}
	
	public static InscriptionManager getInscriptionManager() {
		return InscriptionManagerImpl.getInstance();
	}
	
	public static AuctionManager getAuctionManager() {
		return AuctionManagerImpl.getInstance();
	}
	
	public static ArticleManager getArticleManager() {
		return ArticleManagerImpl.getInstance();
	}
	
	public static CategoryManager getCategoryManager() {
		return CategoryManagerImpl.getInstance();
	}
	
	public static DispatchManager getDispatchManager() {
		return DispatchManagerImpl.getInstance();
	}
	
	public static VenteManager getVenteManager() {
		return VenteManagerImpl.getInstance();
	}
	
}
