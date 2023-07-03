package com.Bander.inventory.customer;

public enum CustomerGender {
    MALE("Male"),
    FEMALE("Female"),
    OTHER("Other");
    private final String customerGender;

    CustomerGender(String customerGender) {
        this.customerGender = customerGender;
    }


    public String getCustomerGender(){
        return customerGender;
    }
}
