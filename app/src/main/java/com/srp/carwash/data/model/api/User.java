package com.srp.carwash.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class User extends SugarRecord {

    @Expose
    @SerializedName("uid")
    private int uid;

    @Expose
    @SerializedName("name")
    private String name;

    @Expose
    @SerializedName("mobile")
    private String mobile;

    @Expose
    @SerializedName("credit")
    private int credit;

    @Expose
    @SerializedName("gender")
    private int gender;

    @Expose
    @SerializedName("expiredAt")
    private String expiredAt;

    @Expose
    @SerializedName("registeredAt")
    private String registeredAt;

    @Expose
    @SerializedName("token")
    private String token;

    public User() {

    }

    public static long getDaysBetweenDates(String start, String end) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date startDate, endDate;
        long numberOfDays = 0;
        try {
            startDate = dateFormat.parse(start);
            endDate = dateFormat.parse(end);
            numberOfDays = getUnitBetweenDates(startDate, endDate, TimeUnit.DAYS);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return numberOfDays;
    }

    private static long getUnitBetweenDates(Date startDate, Date endDate, TimeUnit unit) {
        long timeDiff = endDate.getTime() - startDate.getTime();
        return unit.convert(timeDiff, TimeUnit.MILLISECONDS);
    }

    public int getCredit() {
        return credit;
    }

    public int getGender() {
        return gender;
    }

    public int getUid() {
        return uid;
    }

    public String getMobile() {
        return mobile;
    }

    public String getName() {
        return name;
    }

    public String getRegisteredAt() {
        return registeredAt;
    }

    public String getExpiredAt() {
        return expiredAt;
    }

    public String getToken() {
        return token;
    }

    public String getExpireJalali() {
        String[] split = expiredAt.split("\\s+");
//        JalaliCalendar jalaliDate = new JalaliCalendar(new GregorianCalendar(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2])));
//        return jalaliDate.getYear()
//                +"-"
//                +(jalaliDate.getMonth() < 10 ? "0"+jalaliDate.getMonth() : jalaliDate.getMonth())
//                +"-"
        //+(jalaliDate.getDay() < 10 ? "0"+jalaliDate.getDay() : jalaliDate.getDay());
        Date c = Calendar.getInstance().getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = simpleDateFormat.format(c);

        if (getDaysBetweenDates(formattedDate, split[0]) >= 0)
            return getDaysBetweenDates(formattedDate, split[0]) + " روز باقی مانده";
        else
            return "اشتراک ندارید.";
    }
}
