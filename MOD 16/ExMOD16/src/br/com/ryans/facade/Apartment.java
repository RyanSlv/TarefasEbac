package br.com.ryans.facade;

public class Apartment {

    private Long code;
    private String address;

    public Apartment(int code, String address) {
        this.code = (long) code;
        this.address = address;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
