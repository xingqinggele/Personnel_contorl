package com.zhhl.personnel_contorl.data;

/**
 * Created by miao on 2018/12/24.
 */
public class SimpleCarInfo {
    private String carCode;
    private String company;
    private String carName;
    private String belongTo;

    public SimpleCarInfo() {
    }

    public SimpleCarInfo(String carCode, String company, String carName, String belongTo) {

        this.carCode = carCode;
        this.company = company;
        this.carName = carName;
        this.belongTo = belongTo;
    }

    public String getBelongTo() {
        return belongTo;
    }

    public void setBelongTo(String belongTo) {
        this.belongTo = belongTo;
    }

    public String getCarCode() {
        return carCode;
    }

    public void setCarCode(String carCode) {
        this.carCode = carCode;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }
}
