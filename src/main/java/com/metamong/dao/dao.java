package com.metamong.dao;

import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;

@Repository
public class dao {

    // 커넥션 얻어오는 메서드
    public static Connection getConnection() throws Exception {
        // 드라이버 로드
        Class.forName("com.jdbc.cj.mysql.Driver");

        // 연결 정보 입력
        String dburl = "jdbc:mysq://localhost:3306/mydb";
        String username = "root";
        String password="";

        // 커넥션 생성 및 반환
        Connection conn = DriverManager.getConnection(dburl, username, password);
        return conn;
    }
}


