package filters;

import jakarta.servlet.*;

import java.io.IOException;


public class BoardFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        System.out.println("doFilter()!");
    }
}
