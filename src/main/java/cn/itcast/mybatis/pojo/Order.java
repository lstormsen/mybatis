package cn.itcast.mybatis.pojo;



/**
 * 订单表
 * 
 */
public class Order {
	
	//订单ID
    private Integer id;

    //用户ID
    private Long userId;

    //订单编号
    private String orderNumber;
    
    //订单所属用户
    private User user;

    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

}
