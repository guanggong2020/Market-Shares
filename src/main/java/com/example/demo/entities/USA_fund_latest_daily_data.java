package com.example.demo.entities;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document("USA_fund_latest_daily_data")
public class USA_fund_latest_daily_data implements Serializable {

     @Id
    private ObjectId _id;
    private String date;
    private String code;
    private String fundName;
    private String  company;
     private Double      closingPrice;
    private Double   growthRate;
    private Double  previousClose;
    private Double   change;
    private Double   ROE;
    private Double   ROA;
  private  Double OneYearChange;
    private Double   turnover;

    private Double  MorningstarRating;
    private Double         RiskRating;
    private Double  TTMYield;
    private Double  YTDFundReturn;
    private Double  ThreeMonthFundReturn;
    private Double  OneYearFundReturn;
    private Double  ThreeYearFundReturn;
    private Double   FiveYearFundReturn;
    private String   TotalAssets;
    private String        totalMarketCapitalization;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Double getChange() {
        return change;
    }

    public void setChange(Double change) {
        this.change = change;
    }

    public Double getROE() {
        return ROE;
    }

    public void setROE(Double rOE) {
        this.ROE = rOE;
    }

    public Double getROA() {
        return ROA;
    }

    public void setROA(Double rOA) {
        this.ROA = rOA;
    }

    public Double getOneYearChange() {
        return OneYearChange;
    }

    public void setOneYearChange(Double oneYearChange) {
        OneYearChange = oneYearChange;
    }

    public Double getTurnover() {
        return turnover;
    }

    public void setTurnover(Double turnover) {
        this.turnover = turnover;
    }

    public Double getMorningstarRating() {
        return MorningstarRating;
    }

    public void setMorningstarRating(Double morningstarRating) {
        MorningstarRating = morningstarRating;
    }

    public USA_fund_latest_daily_data(String date, String code, String fundName, String company, Double closingPrice, Double growthRate, Double previousClose, Double change, Double ROE, Double ROA, Double OneYearChange, Double turnover, Double MorningstarRating, Double RiskRating, Double TTMYield, Double YTDFundReturn, Double ThreeMonthFundReturn, Double OneYearFundReturn, Double ThreeYearFundReturn, Double FiveYearFundReturn, String TotalAssets, String totalMarketCapitalization) {
        this.date = date;
        this.code = code;
        this.fundName = fundName;
        this.company = company;
        this.closingPrice = closingPrice;
        this.growthRate = growthRate;
        this.previousClose = previousClose;
        this.change = change;
        this.ROE = ROE;
        this.ROA = ROA;
        this.OneYearChange = OneYearChange;
        this.turnover = turnover;
       this.MorningstarRating = MorningstarRating;
        this.RiskRating = RiskRating;
        this.TTMYield = TTMYield;
        this.YTDFundReturn = YTDFundReturn;
        this.ThreeMonthFundReturn = ThreeMonthFundReturn;
        this.OneYearFundReturn = OneYearFundReturn;
       this.ThreeYearFundReturn = ThreeYearFundReturn;
        this.FiveYearFundReturn = FiveYearFundReturn;
        this.TotalAssets = TotalAssets;
        this.totalMarketCapitalization = totalMarketCapitalization;
    }
}
