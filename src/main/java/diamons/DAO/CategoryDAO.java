package diamons.DAO;

import diamons.entity.Category;
import diamons.entity.MapperCategory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryDAO extends BaseDAO{
    public List<Category> getDataCategory(){
        List<Category> slides = new ArrayList<Category>();
        String sql = "SELECT * FROM `categorys`";
        slides = _jdbcTemplate.query(sql,new MapperCategory());
        return slides;
    }
}
