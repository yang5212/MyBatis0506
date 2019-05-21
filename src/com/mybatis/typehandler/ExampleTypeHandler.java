package com.mybatis.typehandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import java.sql.*;
import java.sql.SQLException;

/**
 * 自定义的类型转换器
 */
public class ExampleTypeHandler implements TypeHandler{
    public void setParameter(PreparedStatement ps, int i, Object parameter,
                             JdbcType jdbcType) throws SQLException {
        ps.setString(i, (String) parameter);
    }
    public Object getResult(ResultSet rs, String columnName)
            throws SQLException {
        return rs.getString(columnName);
    }
    public Object getResult(CallableStatement cs, int columnIndex)
            throws SQLException {
        return cs.getString(columnIndex);
    }

    @Override
    public Object getResult(ResultSet resultSet, int i) throws SQLException {
        return  resultSet.getString(i);
    }
}
