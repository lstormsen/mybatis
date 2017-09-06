package cn.itcast.mybatis.pojo;

public class OrderDetail {
    
	//订单详情编号
    private Integer id;
    
    //总价格
    private Double totalPrice;
    
    //订单状态
    private Integer status;
    
    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
