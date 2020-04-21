package com.example.demo.entities;


import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document("gupiao_data")
public class Gupiao_data implements Serializable {
    private static final long serialVersionUID = -1084645073757625821L;

    @Id
    private ObjectId _id;

    private String date;
    private String code;
    private String name;
    private Double closingPrice;
    private Double maxPrice;
    private Double minPrice;
    private Double openingPrice;
    private Double previousClose;
    private Double change;
    private Double quoteChange;
    private Double turnoverRate;
    private Double volume;
    private Double turnover;
    private Double totalMarketCapitalization;
    private Double marketCapitalization;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getClosingPrice() {
        return closingPrice;
    }

    public void setClosingPrice(Double closingPrice) {
        this.closingPrice = closingPrice;
    }

    public Double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Double minPrice) {
        this.minPrice = minPrice;
    }

    public Double getOpeningPrice() {
        return openingPrice;
    }

    public void setOpeningPrice(Double openingPrice) {
        this.openingPrice = openingPrice;
    }

    public Double getPreviousClose() {
        return previousClose;
    }

    public void setPreviousClose(Double previousClose) {
        this.previousClose = previousClose;
    }

    public Double getChange() {
        return change;
    }

    public void setChange(Double change) {
        this.change = change;
    }

    public Double getQuoteChange() {
        return quoteChange;
    }

    public void setQuoteChange(Double quoteChange) {
        this.quoteChange = quoteChange;
    }

    public Double getTurnoverRate() {
        return turnoverRate;
    }

    public void setTurnoverRate(Double turnoverRate) {
        this.turnoverRate = turnoverRate;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Double getTurnover() {
        return turnover;
    }

    public void setTurnover(Double turnover) {
        this.turnover = turnover;
    }

    public Double getTotalMarketCapitalization() {
        return totalMarketCapitalization;
    }

    public void setTotalMarketCapitalization(Double totalMarketCapitalization) {
        this.totalMarketCapitalization = totalMarketCapitalization;
    }

    public Double getMarketCapitalization() {
        return marketCapitalization;
    }

    public void setMarketCapitalization(Double marketCapitalization) {
        this.marketCapitalization = marketCapitalization;
    }

    public Gupiao_data(ObjectId _id, String date, String code, String name, Double closingPrice, Double maxPrice, Double minPrice, Double openingPrice, Double previousClose, Double change, Double quoteChange, Double turnoverRate, Double volume, Double turnover, Double totalMarketCapitalization, Double marketCapitalization) {
        this._id = _id;
        this.date = date;
        this.code = code;
        this.name = name;
        this.closingPrice = closingPrice;
        this.maxPrice = maxPrice;
        this.minPrice = minPrice;
        this.openingPrice = openingPrice;
        this.previousClose = previousClose;
        this.change = change;
        this.quoteChange = quoteChange;
        this.turnoverRate = turnoverRate;
        this.volume = volume;
        this.turnover = turnover;
        this.totalMarketCapitalization = totalMarketCapitalization;
        this.marketCapitalization = marketCapitalization;
    }
}
