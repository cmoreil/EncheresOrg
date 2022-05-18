package fr.eni.ecole.Encheres.controllers;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import fr.eni.ecole.Encheres.bll.bo.SomeDailyJob;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class ChangeStatusTask implements ServletContextListener{
	
	private ScheduledExecutorService changeStatusTask;

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		changeStatusTask.shutdownNow();
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		changeStatusTask = Executors.newSingleThreadScheduledExecutor();
		changeStatusTask.scheduleAtFixedRate(new SomeDailyJob(), 0, 1, TimeUnit.DAYS);
		//changeStatusTask.scheduleAtFixedRate(new SomeHourlyJob(), 0, 1, TimeUnit.HOURS);
		//changeStatusTask.scheduleAtFixedRate(new SomeQuarterlyJob(), 0, 15, TimeUnit.MINUTES);
		//changeStatusTask.scheduleAtFixedRate(new SomeFiveSecondelyJob(), 0, 5, TimeUnit.SECONDS);
	}
	
	

}
