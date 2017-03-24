/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filtro;

import beans.LoginBean;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author ciro
 */
@WebFilter(filterName = "ContatorFilter", urlPatterns = "/faces/index.xhtml", dispatcherTypes = DispatcherType.REQUEST)
public class LoginFiltro implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpSession sessao = ((HttpServletRequest)request).getSession();
        LoginBean loginBean = (LoginBean) sessao.getAttribute("loginBean");
        if (loginBean == null) {
            //não logado para pagina de login
        }
        else {
            //sim logado para a pagina index.html
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {        
    }
    
}
