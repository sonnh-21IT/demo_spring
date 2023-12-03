package diamons.entity;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperUser implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setId(resultSet.getLong("id"));
        user.setUser(resultSet.getString("user"));
        user.setPassword(resultSet.getString("password"));
        user.setDisplay_name(resultSet.getString("display_name"));
        user.setAddress(resultSet.getString("address"));
        return user;
    }
}
