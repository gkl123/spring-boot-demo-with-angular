package org.demo.goods.model;

import java.io.Serializable;

public class DemoGoods implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String id;

    private Integer num;

    private String type;

    private Integer price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}