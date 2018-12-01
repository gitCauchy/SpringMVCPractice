package com.cauchy.ssm.po;

import java.util.Date;

import javax.validation.constraints.Size;

import com.cauchy.ssm.controller.validation.ValidGroup1;

public class Item {
    private Integer id;
    @Size(min = 1,max = 30,message="{item.name.length.error}",groups= {ValidGroup1.class})
    private String name;

    private Float price;

    private String pic;

    private Date creattime;

    private String detail;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Date getCreattime() {
        return creattime;
    }

    public void setCreattime(Date creattime) {
        this.creattime = creattime;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}