package cn.itcast.mybatis.pojo;

/**
 * 商品表
 */
public class Item {

	//商品ID
    private Integer id;

    //商品名称
    private String itemName;

    //商品价格
    private Float itemPrice;
    
    //商品详情
    private String itemDetail;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Float getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Float itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemDetail() {
        return itemDetail;
    }

    public void setItemDetail(String itemDetail) {
        this.itemDetail = itemDetail;
    }

}
