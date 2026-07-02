package com.spring.ioc.advanced.beans;

/**
 * Bean with factory method
 */
public class DataSourceFactory {

    // Static factory method
    public static DataSource createDataSource(String dbType) {
        System.out.println("Creating DataSource using factory method for type: " + dbType);

        if ("mysql".equals(dbType)) {
            return new MysqlDataSource();
        } else if ("postgres".equals(dbType)) {
            return new PostgresDataSource();
        } else {
            return new MysqlDataSource(); // Default
        }
    }
}

/**
 * DataSource interface
 */
interface DataSource {

    void connect();

    String getType();
}

/**
 * MySQL DataSource implementation
 */
class MysqlDataSource implements DataSource {

    @Override
    public void connect() {
        System.out.println("Connected to MySQL database");
    }

    @Override
    public String getType() {
        return "MySQL";
    }
}

/**
 * PostgreSQL DataSource implementation
 */
class PostgresDataSource implements DataSource {

    @Override
    public void connect() {
        System.out.println("Connected to PostgreSQL database");
    }

    @Override
    public String getType() {
        return "PostgreSQL";
    }
}
