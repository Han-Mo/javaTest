package strategy.strategya;

import java.math.BigDecimal;

/**
 * @author han
 * @Date 2019-09-20 15:00
 **/
public class OrderDTO {
    private String code;
    private BigDecimal price;

    private String type;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
