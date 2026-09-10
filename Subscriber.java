package com.hrushikesh.telecom.module;

import java.util.Scanner;

public class Subscriber {

    private int subscriberID;
    private String subscriberName;
    private String subscriberMobileNumber;
    private boolean isSubscriberActive;
    static Subscriber[] subscriber = null;



    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n, id;
        String name, mobileNumber;
        Boolean active;
        while(true) {
            System.out.println("Enter number of subscriber : ");
            n = sc.nextInt();
            if (n >= 2)
                break;
            System.out.println("The given number is Invalid, please give a number more than 2");
        }

        subscriber = new Subscriber[n];

        for (int i=0; i < n ; i++){
            System.out.println("Enter details of subscriber " + (i+1));
            System.out.println("=========================");
            System.out.println("Enter subscriber id : ");
            id = sc.nextInt();
            System.out.println("Enter subscriber name : ");
            name = sc.next();
            System.out.println("Enter subscriber mobile number : ");
            mobileNumber = sc.next();
            System.out.println("Enter subscriber active status : ");
            active = sc.nextBoolean();
            if(Subscriber.isSubscriberValid(i, id, name, mobileNumber, active)){
                subscriber[i] = new Subscriber();
                subscriber[i].setId(id);
                subscriber[i].setName(name);
                subscriber[i].setMobileNumber(mobileNumber);
                subscriber[i].setActive(active);
            }
            else {
                System.err.println("Subscriber details validation failed and details are not stored, " +
                        "provide proper details");
            }
        }
        Subscriber.displaySubscriberDetails();
    }

    public static boolean isSubscriberValid(int i, int id, String name, String mobileNumber, Boolean active) {
        if (id < 0){
            System.out.println("Id validation is failed, because it is lesser than 0 for Subscriber" + (i+1));
            return false;
        }
        else if(name.isEmpty()) {
            System.out.println("Name validation is failed, because it is empty for Subscriber" + (i+1));
            return false;
        }
        else if(mobileNumber.length() != 10) {
            System.out.println("Mobile number validation is failed because it does not contains 10 digits for" +
                    " Subscriber" + (i+1));
            return false;
        }
        else if(active == true || active == false)
            return true;
        else {
            System.out.println("All details validation is failed for" +
                    " Subscriber" + (i+1));
            return false;
        }

    }

    public static void displaySubscriberDetails(){
        for(Subscriber subs : subscriber){
            System.out.println("\n"+"Subscriber ID :"+subs.getId());
            System.out.println("Name :"+subs.getName());
            System.out.println("Mobile Number :"+subs.getMobileNumber());
            System.out.println("Active :"+subs.isActive()+"\n");
        }
    }

    public int getId() {
        return subscriberID;
    }

    public void setId(int id) {
        subscriberID = id;
    }

    public String getName() {
        return subscriberName;
    }

    public void setName(String name) {
        subscriberName = name;
    }

    public String getMobileNumber() {
        return subscriberMobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        subscriberMobileNumber = mobileNumber;
    }

    public boolean isActive() {
        return isSubscriberActive;
    }

    public void setActive(boolean active) {
        isSubscriberActive = active;
    }

}
