package com.srp.carwash.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.GregorianCalendar;

import ir.huri.jcal.JalaliCalendar;

public class VoucherModel {

    @Expose
    @SerializedName("voucher")
    private String voucher;

    @Expose
    @SerializedName("price")
    private String price;

    @Expose
    @SerializedName("status")
    private int status;

    @Expose
    @SerializedName("createdAt")
    private String createdAt;

    public VoucherModel() {

    }

    public String getCreatedAt() {
        String[] split = createdAt.split("\\s+")[0].split("-");
        JalaliCalendar jalaliDate = new JalaliCalendar(new GregorianCalendar(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2])));
        return jalaliDate.getDayOfWeekDayMonthString();
    }

    public String getPrice() {
        return price;
    }

    public int getStatus() {
        return status;
    }

    public String getVoucher() {
        return voucher;
    }

}
