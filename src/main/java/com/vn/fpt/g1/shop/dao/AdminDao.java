package com.vn.fpt.g1.shop.dao;

import com.vn.fpt.g1.shop.dbcontext.DbContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminDao extends DbContext {
    private Connection conn = null ;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
}
