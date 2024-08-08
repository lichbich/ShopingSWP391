package com.vn.fpt.g1.shop.dao;

import com.vn.fpt.g1.shop.dbcontext.DbContext;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserDao extends DbContext {
    private final Connection connection = DbContext.getConnection();
    public String abc (){
        return "Select * from ";
//        connection.close();
    }
}
