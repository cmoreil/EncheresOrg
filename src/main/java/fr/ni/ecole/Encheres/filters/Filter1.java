package fr.ni.ecole.Encheres.filters;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class filter
 */
@WebFilter("/connect/*")
public class Filter1 implements Filter{

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain)
			throws IOException, ServletException {
		
		HttpServletResponse response = (HttpServletResponse) resp;
		HttpServletRequest request = (HttpServletRequest) req;
		
		if((request.getSession().getAttribute("userConnected")) != null) {
			filterChain.doFilter(req, resp);
		}else {
			response.sendRedirect(request.getContextPath() + "/index");
		}
	}

}
