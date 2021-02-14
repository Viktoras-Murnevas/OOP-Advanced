package com.enorkus.academy.entity;


public class Customer {

    private String id;

    //Mandatory
    private String firstName;
    private String lastName;
    private String personalNumber;

    //Optional
    private String middleName;
    private int age;
    private String countryCode;
    private String city;
    private int monthlyIncome;
    private String employer;
    private String gender;
    private String maritalStatus;

    public Customer() {
    }

    public String getId() {
        return id;
    }

    public String getFirstName() { return firstName; }

    public String getLastName() {
        return lastName;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public String getMiddleName() {
        return middleName;
    }

    public int getAge() {
        return age;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getCity() {
        return city;
    }

    public int getMonthlyIncome() {
        return monthlyIncome;
    }

    public String getGender() {
        return gender;
    }

    public String getEmployer() {
        return employer;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setId(String id) {
        this.id = id;
    }

//Task 3
    private Customer(Builder builder) {

        this.id = builder.id;

        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.personalNumber = builder.personalNumber;

        this.middleName = builder.middleName;
        this.age = builder.age;
        this.countryCode = builder.countryCode;
        this.city = builder.city;
        this.monthlyIncome = builder.monthlyIncome;
        this.employer = builder.employer;
        this.gender = builder.gender;
        this.maritalStatus = builder.maritalStatus;
    }

    public static class Builder {
        private String id;

        private String firstName;
        private String lastName;
        private String personalNumber;

        //Optional
        private String middleName;
        private int age;
        private String countryCode;
        private String city;
        private int monthlyIncome;
        private String employer;
        private String gender;
        private String maritalStatus;

        public Builder(String id) {
            this.id = id;
//            return this;
        }

        public Builder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder withPersonalNumber(String personalNumber) {
            this.personalNumber = personalNumber;
            return this;
        }

        public Builder withMiddleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public Builder withAge(int age) {
            this.age = age;
            return this;
        }

        public Builder withCountryCode(String countryCode) {
            this.countryCode = countryCode;
            return this;
        }

        public Builder withCity(String city) {
            this.city = city;
            return this;
        }

        public Builder withMonthlyIncome(int monthlyIncome) {
            this.monthlyIncome = monthlyIncome;
            return this;
        }

        public Builder withEmployer(String employer) {
            this.employer = employer;
            return this;
        }

        public Builder withGender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder withMaritalStatus(String maritalStatus) {
            this.maritalStatus = maritalStatus;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }
}
