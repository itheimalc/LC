package com.itheima.domain;

import java.io.Serializable;
import java.util.Date;

public class Items implements Serializable {

    private Integer I_id;
    private String I_name;
    private Float I_price;
    private String I_pic;
    private Date I_createTime;
    private String I_detail;

    @Override
    public String toString() {
        return "Items{" +
                "I_id=" + I_id +
                ", I_name='" + I_name + '\'' +
                ", I_price=" + I_price +
                ", I_pic='" + I_pic + '\'' +
                ", I_createTime=" + I_createTime +
                ", I_detail='" + I_detail + '\'' +
                '}';
    }

    public Integer getI_id() {
        return I_id;
    }

    public void setI_id(Integer i_id) {
        I_id = i_id;
    }

    public String getI_name() {
        return I_name;
    }

    public void setI_name(String i_name) {
        I_name = i_name;
    }

    public Float getI_price() {
        return I_price;
    }

    public void setI_price(Float i_price) {
        I_price = i_price;
    }

    public String getI_pic() {
        return I_pic;
    }

    public void setI_pic(String i_pic) {
        I_pic = i_pic;
    }

    public Date getI_createTime() {
        return I_createTime;
    }

    public void setI_createTime(Date i_createTime) {
        I_createTime = i_createTime;
    }

    public String getI_detail() {
        return I_detail;
    }

    public void setI_detail(String i_detail) {
        I_detail = i_detail;
    }
}
