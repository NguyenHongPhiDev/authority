package com.example.authority.domain.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
public class AuthenticationExceptionHandler implements AuthenticationEntryPoint {
    private final ObjectMapper mapper;

    @Override
    public void commence(final HttpServletRequest request,
                         final HttpServletResponse response,
                         final AuthenticationException exception) throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        try (ServletOutputStream out = response.getOutputStream()) {
            final BaseResponse error = BaseResponse.error(HttpServletResponse.SC_UNAUTHORIZED, exception.getMessage());
            mapper.writeValue(out, error);
        }
    }
}
