package com.vn.fpt.g1.shop.servlet;

import com.vn.fpt.g1.shop.common.BusinessCommon;
import com.vn.fpt.g1.shop.config.Constant;
import com.vn.fpt.g1.shop.exception.RestExceptionHandler;

import javax.annotation.processing.Messager;

public class ExampleServlet {
    public void abc (String username){
        String a = "qwerwqer";
        BusinessCommon.isValidPassword(a);
        BusinessCommon.isNumeric(a);
        Long b = BusinessCommon.convert(a, 1);
        if(!BusinessCommon.isNullOrEmpty(username, true)){
//            db.qwerweqr
        }
        throw new RestExceptionHandler(Constant.ACTION_FAILED);
    }
}
