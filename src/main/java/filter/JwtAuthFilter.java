package filter;

import com.livraison.Livraison.jwt.JwtTokenProvider;
import com.livraison.Livraison.security.SecurityConstant;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthFilter extends OncePerRequestFilter {
    private JwtTokenProvider jwtTokenProvider;
    public JwtAuthFilter(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
if (request.getMethod().equalsIgnoreCase(SecurityConstant.OPTIONS_HTTP_METHOD))
    response.setStatus(HttpStatus.OK.value());
else
{
    String authorizationHeader= request.getHeader(HttpHeaders.AUTHORIZATION);
    if(authorizationHeader == null || authorizationHeader.startsWith(SecurityConstant.TOKEN_PREFIX))
    {
        filterChain.doFilter(request,response);
        return;
    }
}

    }


}
