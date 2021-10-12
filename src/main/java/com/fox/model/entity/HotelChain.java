package com.fox.model.entity;

import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
public class HotelChain {

    private Integer id;
    private String name;
    private String type;
    private String parentCompany;

    public HotelChain(Integer id, String name, String type, String parentCompany) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.parentCompany = parentCompany;
    }

    public HotelChain(String name, String type, String parentCompany) {
        this(null, name, type, parentCompany);
    }

    @Override
    public String toString() {
        return "\n\nHotel chain: id: " + id + ", name: " + name + ", type: " + type + ", parent_company: " + parentCompany
                + "]";
    }


}
