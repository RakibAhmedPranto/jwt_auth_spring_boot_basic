package com.rea.app.common;

import com.rea.app.common.model.Response;
import org.springframework.http.HttpStatus;

public class ResponseObject {
    public static <T> Response<T> dataNotSavedOrUpdate(Response<T> response){
        response.setStatus(400);
        response.setSuccess(false);
        response.setMessage("Data Not Saved or Updated. Please check your input data!!");
        response.setData(null);
        return response;
    }

    public static <T> Response<T> dataSavedOrUpdateSuccess(Response<T> response, T data, int code){
        response.setStatus(code);
        response.setSuccess(true);
        response.setMessage("Data Saved or Updated!!");
        response.setData(data);
        return response;
    }

    public static <T> Response<T> dataFoundSuccess(Response<T> response, T data){
        response.setStatus(200);
        response.setSuccess(true);
        response.setMessage("Data Found!!");
        response.setData(data);
        return response;
    }

    public static <T> Response<T> dataNotFound(Response<T> response, T data){
        response.setStatus(404);
        response.setSuccess(false);
        response.setMessage("Resource Not Found!!");
        response.setData(null);
        return response;
    }
}
