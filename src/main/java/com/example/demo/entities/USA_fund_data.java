package com.example.demo.entities;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
@Data
@Document("USA_fund_data")
public class USA_fund_data implements Serializable {
    private static final long serialVersionUID = 127969661536221368L;

    private ObjectId _id;
    private String date;
    private String code;
    private String fundName;
    private String  company;
     private Double      closingPrice;
    private Double   growthRate;
    private Double  previousClose;
    private Double       change;
    private Double   OneYearChange;
    private Double   turnover;
    private Double   ROE;
    private Double   ROA;
    private Double  MorningstarRating;
    private Double         RiskRating;
    private Double  TTMYield;
    private Double  YTDFundReturn;
    private Double  ThreeMonthFundReturn;
    private Double  OneYearFundReturn;
    private Double  ThreeYearFundReturn;

    public USA_fund_data(String date, String code, String fundName, String company, Double closingPrice, Double growthRate, Double previousClose, Double change, Double oneYearChange, Double turnover, Double ROE, Double ROA, Double morningstarRating, Double riskRating, Double TTMYield, Double YTDFundReturn, Double threeMonthFundReturn, Double oneYearFundReturn, Double threeYearFundReturn, Double fiveYearFundReturn, Double totalAssets, Double totalMarketCapitalization) {
        this.date = date;
        this.code = code;
        this.fundName = fundName;
        this.company = company;
        this.closingPrice = closingPrice;
        this.growthRate = growthRate;
        this.previousClose = previousClose;
        this.change = change;
        OneYearChange = oneYearChange;
        this.turnover = turnover;
        this.ROE = ROE;
        this.ROA = ROA;
        MorningstarRating = morningstarRating;
        RiskRating = riskRating;
        this.TTMYield = TTMYield;
        this.YTDFundReturn = YTDFundReturn;
        ThreeMonthFundReturn = threeMonthFundReturn;
        OneYearFundReturn = oneYearFundReturn;
        ThreeYearFundReturn = threeYearFundReturn;
        FiveYearFundReturn = fiveYearFundReturn;
        TotalAssets = totalAssets;
        this.totalMarketCapitalization = totalMarketCapitalization;
    }

    private Double   FiveYearFundReturn;
    private Double   TotalAssets;
    private Double        totalMarketCapitalization;

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
}
