package com.myapp.hanfu;

import java.util.List;

public class Car {
    private String reason;
    private List<mCar> result;
    public static class mCar{
        private String id;
        private String brand_name;
        private String brand_logo;
        private String first_letter;

        public  String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getBrand_name() {
            return brand_name;
        }

        public void setBrand_name(String brand_name) {
            this.brand_name = brand_name;
        }

        public String getBrand_logo() {
            return brand_logo;
        }

        public void setBrand_logo(String brand_logo) {
            this.brand_logo = brand_logo;
        }

        public String getFirst_letter() {
            return first_letter;
        }

        public void setFirst_letter(String first_letter) {
            this.first_letter = first_letter;
        }
    }
    //无参构造
    public Car(){}

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public List<mCar> getResult() {
        return result;
    }

    public void setResult(List<mCar> result) {
        this.result = result;
    }
}
