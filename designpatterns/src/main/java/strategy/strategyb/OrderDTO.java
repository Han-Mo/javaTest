package strategy.strategyb;

import java.math.BigDecimal;

/**
 * @author han
 * @Date 2019-09-20 15:00
 **/
public class OrderDTO {
    private String code;

    private BigDecimal price;

    /**
      * 订单类型
      * 1. 普通订单
      * 2. 团购订单
      * 3. 促销订单
    */
    private Integer type;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
