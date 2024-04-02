package com.nexdew.storeservice.payload.response;


import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Getter
@Setter
public class ApiResponse {
private HttpStatus status;
private Date date;
private Object data;

    public ApiResponse(HttpStatus status, Object data) {
        this.status = status;
        this.date=new Date();
        this.data = data;
    }
}
