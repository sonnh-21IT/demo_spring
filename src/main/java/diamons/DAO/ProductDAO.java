package diamons.DAO;

import diamons.DTO.MapperProductDTO;
import diamons.DTO.ProductDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDAO extends BaseDAO {
    private StringBuffer sqlString() {
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT ");
        sql.append("p.id AS id_product ");
        sql.append(",p.id_category ");
        sql.append(",p.sizes ");
        sql.append(",p.name ");
        sql.append(",p.price ");
        sql.append(",p.sale ");
        sql.append(",p.title ");
        sql.append(",p.highlight ");
        sql.append(",p.new_product ");
        sql.append(",p.details ");
        sql.append(",c.id AS id_color ");
        sql.append(",c.img AS name_color ");
        sql.append(",c.code AS code_color ");
        sql.append(",c.img ");
        sql.append(",p.created_at ");
        sql.append(",p.updated_at ");
        sql.append("FROM ");
        sql.append("products AS p ");
        sql.append("INNER JOIN ");
        sql.append("colors AS c ");
        sql.append("ON p.id = c.id_product ");
        return sql;
    }

    private String sqlProduct(boolean newProduct, boolean highLight) {
        StringBuffer sql = sqlString();

        sql.append("WHERE 1 = 1 ");

        if (highLight) {
            sql.append("AND p.highlight = true ");
        }
        if (newProduct) {
            sql.append("AND p.new_product = true ");
        }

        sql.append("GROUP BY p.id,c.id_product ");
        sql.append("ORDER BY RAND() ");

        if (highLight) {
            sql.append("LIMIT 9;");
        }
        if (newProduct) {
            sql.append("LIMIT 12;");
        }

        return sql.toString();
    }

    private StringBuffer sqlProductByIDCategory(int id) {
        StringBuffer sql = sqlString();

        sql.append("WHERE 1 = 1 ");
        sql.append("AND id_category = " + id + " ");

        return sql;
    }

    public String sqlProductDTOPaginate(int id, int start, int totalPage) {
        StringBuffer sql = sqlProductByIDCategory(id);
        sql.append("LIMIT " + start + ", " + totalPage);
        return sql.toString();
    }

    public List<ProductDTO> getDataProductDTO(boolean newProducts, boolean highLight) {
        return _jdbcTemplate.query(sqlProduct(newProducts, highLight), new MapperProductDTO());
    }

    public List<ProductDTO> getAllProductDTOByID(int id) {
        return _jdbcTemplate.query(sqlProductByIDCategory(id).toString(), new MapperProductDTO());
    }

    public List<ProductDTO> getDataProductDTOByPaginate(int id, int start, int totalPage) {
        StringBuffer sqlGetDataByID = sqlProductByIDCategory(id);
        List<ProductDTO> productDTOListByID = _jdbcTemplate.query(sqlGetDataByID.toString(), new MapperProductDTO());
        List<ProductDTO> productDTOList = new ArrayList<ProductDTO>();
        if (productDTOListByID.size() > 0) {
            String sql = sqlProductDTOPaginate(id, start, totalPage);
            productDTOList = _jdbcTemplate.query(sql, new MapperProductDTO());
        }
        return productDTOList;
    }

    private String sqlProductByID(long id) {
        StringBuffer sql = sqlString();
        sql.append("WHERE 1 = 1 ");
        sql.append("AND p.id = " + id + " ");
        sql.append("LIMIT 1;");
        return sql.toString();
    }

    public List<ProductDTO> getProductByID(long id) {
        return _jdbcTemplate.query(sqlProductByID(id), new MapperProductDTO());
    }
    public ProductDTO findProductByID(long id) {
        return _jdbcTemplate.queryForObject(sqlProductByID(id), new MapperProductDTO());
    }
}
