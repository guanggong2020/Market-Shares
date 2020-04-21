package com.example.demo.entities;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document("zstd")
public class Zstd implements Serializable {

    private static final long serialVersionUID = -1085990317548389872L;
    @Id
    private ObjectId _id;
    private String date;
    private String code;
    private String name;
    private Double closingPrice;
    private Double openingPrice;
    private Double maxPrice;
    private Double minPrice;
    private Double previousClose;
    private Double change;
    private Double quoteChange;
    private Double volume;
    private Double turnover;
    private Double amplitude;
    private Double QRR;
    private Double type;

    public Zstd(ObjectId _id, String date, String code, String name, Double closingPrice, Double openingPrice, Double maxPrice, Double minPrice, Double previousClose, Double change, Double quoteChange, Double volume, Double turnover, Double amplitude, Double QRR, Double type) {
        this._id = _id;
        this.date = date;
        this.code = code;
        this.name = name;
        this.closingPrice = closingPrice;
        this.openingPrice = openingPrice;
        this.maxPrice = maxPrice;
        this.minPrice = minPrice;
        this.previousClose = previousClose;
        this.change = change;
        this.quoteChange = quoteChange;
        this.volume = volume;
        this.turnover = turnover;
        this.amplitude = amplitude;
        this.QRR = QRR;
        this.type = type;
    }
}
