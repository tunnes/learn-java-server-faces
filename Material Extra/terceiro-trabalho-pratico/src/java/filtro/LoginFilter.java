/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filtro;

import beans.Login;
import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author tunnes (Ayrton Felipe)
 * @author gmoraiz (Gabriel Morais)
 * @author tarcisioLima (Tarcisio Lima)
 * 
 */
@WebFilter(filterName = "LoginFilter",
        urlPatterns = "/faces/pagina_principal.xhtml",
        dispatcherTypes = DispatcherType.REQUEST)
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {        
    }

    @Override
    @SuppressWarnings("empty-statement")
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest)request).getSession();
        Login login = (Login) session.getAttribute("login");
        if (login == null) {
            System.out.println("Usuário não autenticado.");
            
            String contextPath = ((HttpServletRequest)request).getContextPath();
            ((HttpServletResponse)response).sendRedirect(contextPath + "/faces/pagina_deslogado.xhtml");
        }
        else {
            session.setAttribute("login", login);
            System.out.println("Usuário autenticado.");
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {        
    }    
}
