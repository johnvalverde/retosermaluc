package com.sermaluc.reto.auth.filters;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sermaluc.reto.auth.model.UserDetailsCustom;
import com.sermaluc.reto.auth.model.User;
import com.sermaluc.reto.auth.services.JWTService;
import com.sermaluc.reto.utils.config.PathsUtil;
import com.sermaluc.reto.utils.model.ResponseApi;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.sermaluc.reto.auth.config.PathsAuth.AUTH;
import static com.sermaluc.reto.auth.config.PathsAuth.LOGIN;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    //generando clave secreta dinamicamente


    private AuthenticationManager authenticationManage;
    private JWTService jwtService;


    public JWTAuthenticationFilter(AuthenticationManager authenticationManage, JWTService jwtService) {
        this.authenticationManage = authenticationManage;
        this.jwtService = jwtService;
        setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher(PathsUtil.ROOT_API + AUTH + PathsUtil.VERSION + LOGIN, "POST"));
    }

    /*autentiacion que no necesita un formulario*/
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {


        String username = this.obtainUsername(request);
        username = username != null ? username.trim() : null;
        String password = "";
        if (username == null) {
            User user;
            try {
                user = new ObjectMapper().readValue(request.getInputStream(), User.class);
                username = user.getUsername().trim();
                password = user.getPassword().trim();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        return authenticationManage.authenticate(authenticationToken);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {

        UserDetailsCustom customUserDetails = (UserDetailsCustom) authResult.getPrincipal();

        String token = jwtService.create(authResult);
        Map<String, Object> body = new HashMap<>();
        body.put("token", token);
        body.put("user", customUserDetails);

        ResponseApi<Map<String, Object>> resultado = ResponseApi.build(body);

        response.getWriter().write(new ObjectMapper().writeValueAsString(resultado));
        response.setStatus(200);
        response.setContentType("application/json");
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        ResponseApi<?> responseApi = new ResponseApi<>();
        responseApi.setStatus(400);
        responseApi.setMessage("El usuario y la contraseña no coinciden, por favor verifique los datos ingresados.");
        responseApi.setBody(null);

        response.setStatus(200);
        response.getWriter().write(new ObjectMapper().writeValueAsString(responseApi));
        response.setContentType("application/json");
    }

}
