package diamons.DTO;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperProductDTO implements RowMapper<ProductDTO> {
    @Override
    public ProductDTO mapRow(ResultSet resultSet, int i) throws SQLException {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId_product(resultSet.getLong("id_product"));
        productDTO.setId_category(resultSet.getInt("id_category"));
        productDTO.setSizes(resultSet.getString("sizes"));
        productDTO.setName(resultSet.getString("name"));
        productDTO.setPrice(resultSet.getDouble("price"));
        productDTO.setSale(resultSet.getInt("sale"));
        productDTO.setTitle(resultSet.getString("title"));
        productDTO.setHighlight(resultSet.getBoolean("highlight"));
        productDTO.setNew_product(resultSet.getBoolean("new_product"));
        productDTO.setDetails(resultSet.getString("details"));
        productDTO.setId_color(resultSet.getLong("id_color"));
        productDTO.setName_color(resultSet.getString("name_color"));
        productDTO.setCode_color(resultSet.getString("code_color"));
        productDTO.setImg(resultSet.getString("img"));
        productDTO.setUpdated_at(resultSet.getDate("updated_at"));
        productDTO.setCreated_at(resultSet.getDate("created_at"));
        return productDTO;
    }
}
