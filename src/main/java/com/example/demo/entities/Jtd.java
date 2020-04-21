package com.example.demo.entities;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
@Data
@Document( "jtd")
public class Jtd implements Serializable {

    private static final long serialVersionUID = 127969661536221368L;

    private ObjectId _id;
    private String date;
    private String code;
    private String fundName;
    private Double unitNetWorth;
    private Double cumulativeNetWorth;
    private Double growthRate;

    public Jtd(ObjectId _id, String date, String code, String fundName, Double unitNetWorth, Double cumulativeNetWorth, Double growthRate) {
        this._id = _id;
        this.date = date;
        this.code = code;
        this.fundName = fundName;
        this.unitNetWorth = unitNetWorth;
        this.cumulativeNetWorth = cumulativeNetWorth;
        this.growthRate = growthRate;
    }
}
