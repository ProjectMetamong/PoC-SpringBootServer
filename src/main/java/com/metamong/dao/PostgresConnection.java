package com.metamong.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;

@Repository
public class PostgresConnection implements DbConnection {

    // 커넥션 얻어오는 메서드
    public Connection getConnection() throws Exception {
        // 드라이버 로드
        Class.forName("org.postgresql.Driver");

        // 연결 정보 입력
        String dburl = "jdbc:postgresql://3.35.106.239:5433/metamong_db";
        String username = "user";
        String password = "1234";

        // 커넥션 생성 및 반환
        Connection conn = DriverManager.getConnection(dburl, username, password);
        return conn;
    }
}


