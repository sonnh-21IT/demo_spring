package diamons.DAO;

import diamons.entity.MapperUser;
import diamons.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO extends BaseDAO{
    public int addAccount(User user){
        StringBuffer  sql = new StringBuffer();
        sql.append("INSERT ");
        sql.append("INTO `users` ");
        sql.append("( ");
        sql.append("    `user`, ");
        sql.append("    `password`, ");
        sql.append("    `display_name`, ");
        sql.append("    `address` ");
        sql.append(") ");
        sql.append("VALUES ");
        sql.append("( ");
        sql.append("    '"+user.getUser()+"', ");
        sql.append("    '"+user.getPassword()+"', ");
        sql.append("    '"+user.getDisplay_name()+"', ");
        sql.append("    '"+user.getAddress()+"' ");
        sql.append(")");

        int insert = _jdbcTemplate.update(sql.toString());
        return insert;
    }
    public User getUserByAcc(User user){
        String sql = "SELECT * FROM `users` WHERE user = '"+user.getUser()+"'";
        User result = _jdbcTemplate.queryForObject(sql,new MapperUser());
        return result;
    }
}
