package diamons.DAO;

import diamons.entity.MapperSlide;
import diamons.entity.Slide;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SlideDAO extends BaseDAO{
    public List<Slide> getDataSlide(){
        List<Slide> slides = new ArrayList<Slide>();
        String sql = "SELECT * FROM `slides`";
        slides = _jdbcTemplate.query(sql,new MapperSlide());
        return slides;
    }
}
