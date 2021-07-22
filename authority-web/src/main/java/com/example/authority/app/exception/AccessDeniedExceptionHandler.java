package com.example.authority.app.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@RequiredArgsConstructor
public class AccessDeniedExceptionHandler implements AccessDeniedHandler {
    private final ObjectMapper mapper;

    @Override
    public void handle(final HttpServletRequest request,
                       final HttpServletResponse response,
                       final AccessDeniedException exception) throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);

        try (ServletOutputStream out = response.getOutputStream()) {
            final BaseResponse error = BaseResponse.error(HttpServletResponse.SC_FORBIDDEN, exception.getMessage());
            mapper.writeValue(out, error);
        }
    }
}
