package diamons.DTO;

public class CartDTO {
    private int quantity;
    private double total;
    private ProductDTO productDTO;

    public CartDTO(int quantity, double total, ProductDTO productDTO) {
        this.quantity = quantity;
        this.total = total;
        this.productDTO = productDTO;
    }

    public CartDTO() {
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public ProductDTO getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(ProductDTO productDTO) {
        this.productDTO = productDTO;
    }
}
