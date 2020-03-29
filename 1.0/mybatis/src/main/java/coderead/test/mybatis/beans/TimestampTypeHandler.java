package coderead.test.mybatis.beans;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.*;
// 时间 转 整形
public class TimestampTypeHandler implements TypeHandler {

    @Override
    public void setParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException {
        ps.setLong(i, ((Date) parameter).getTime());
    }

    @Override
    public Object getResult(ResultSet rs, String columnName) throws SQLException {
        long time = rs.getLong(columnName);
        return new Date(time);
    }

    @Override
    public Object getResult(ResultSet rs, int columnIndex) throws SQLException {
        long time = rs.getLong(columnIndex);
        return new Date(time);
    }

    @Override
    public Object getResult(CallableStatement cs, int columnIndex) throws SQLException {
        long time = cs.getLong(columnIndex);
        return new Date(time);
    }
}
