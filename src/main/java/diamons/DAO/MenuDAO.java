package diamons.DAO;

import diamons.entity.MapperMenu;
import diamons.entity.Menu;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MenuDAO extends BaseDAO{
    public List<Menu> getDataMenu(){
        List<Menu> menus = new ArrayList<Menu>();
        String sql = "SELECT * FROM `menus`";
        menus = _jdbcTemplate.query(sql,new MapperMenu());
        return menus;
    }
}
