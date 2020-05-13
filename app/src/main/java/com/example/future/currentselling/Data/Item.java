package com.example.future.currentselling.Data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

@Entity(tableName = "sell")
public class Item  {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "product_Name")
    private String productName;
    @ColumnInfo(name = "original_price")
    private Double originalPrice;
    @ColumnInfo(name = "sell_price")
    private Double sellPrice;
    @ColumnInfo(name = "profit")
    private Double profit;
    @ColumnInfo(name = "date")
    private String date;
    @ColumnInfo(name = "total")
    private String  total;

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getProfit() {
        return profit;
    }

    public void setProfit(Double profit) {
        this.profit = profit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Double sellPrice) {
        this.sellPrice = sellPrice;
    }

}
