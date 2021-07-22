package com.example.authority.domain.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse {

    private Object data;
    private Meta meta;

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Meta {
        private Integer code;
        private String message;

        public static Meta ok() {
            return new Meta(HttpStatus.OK.value(), null);
        }
    }

    public static BaseResponse ok() {
        return new BaseResponse(null, Meta.ok());
    }

    public static BaseResponse ok(final Object data) {
        return new BaseResponse(data, Meta.ok());
    }

    public static BaseResponse error(final Integer code, final String msg) {
        final BaseResponse baseResponse = new BaseResponse();
        baseResponse.setMeta(new Meta(code, msg));

        return baseResponse;
    }
}
