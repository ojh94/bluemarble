package itschool.bluemarble.dao.base;

import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public abstract class CommonDao {
    //DB접속 정보
    final static private String dbDriver = "org.postgresql.Driver";
    final static private String dbUrl = "jdbc:postgresql://127.0.0.1:5432/postgres";
    final static private String dbUser = "postgres";
    final static private String dbPassword = "1234";

    HikariDataSource ds = new HikariDataSource();
    {
        ds.setDriverClassName(dbDriver);
        ds.setJdbcUrl(dbUrl);
        ds.setUsername(dbUser);
        ds.setPassword(dbPassword);
        //어래 pool size는 기존에 JDBC에서는 제공하지 않음
        ds.setMaximumPoolSize(5);
    }

    // 1. Connection 모듈
    protected Connection connect() {
        try {
            Connection connection = ds.getConnection();
            System.out.println("DB연결 성공");
            return connection;
        }catch (SQLException e) {
            throw new RuntimeException("DB 연결 실패",e);
        }
    }

}
