package com.metamong.dao;

import java.sql.Connection;

public interface DbConnection {
    public Connection getConnection() throws Exception;
}
