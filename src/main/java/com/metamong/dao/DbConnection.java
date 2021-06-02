package com.metamong.dao;

import java.sql.Connection;

public interface DbConnection {
    Connection getConnection() throws Exception;
}
