package pojo;

public class bill {
    private Integer id;
    private String productName;
    private String productUnit;
    private Integer proId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductUnit() {
        return productUnit;
    }

    public void setProductUnit(String productUnit) {
        this.productUnit = productUnit;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    @Override
    public String toString() {
        return "bill{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productUnit='" + productUnit + '\'' +
                ", proId=" + proId +
                '}';
    }
}
