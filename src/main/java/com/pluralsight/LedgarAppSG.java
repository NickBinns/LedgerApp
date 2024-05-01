package com.pluralsight;

public class LedgarAppSG {
    private String Date, Time, Description, Vendor;
    private Double Amount;

    public LedgarAppSG(String Date, String Time, String Description, String Vendor, double Amount) {
        this.Date = Date;
        this.Time = Time;
        this.Description = Description;
        this.Vendor = Vendor;
        this.Amount = Amount;
    }


    public void setDate(String date) { Date = date; }

    public void setTime(String time) {
        Time = time;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setVendor(String vendor) {
        Vendor = vendor;
    }

    public void setAmount(Double amount) {
        Amount = amount;
    }


    public String getDate() {
        return Date;
    }

    public String getTime() {
        return Time;
    }

    public String getDescription() {
        return Description;
    }

    public String getVendor() {
        return Vendor;
    }

    public Double getAmount() {
        return Amount;
    }
}
