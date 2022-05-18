package com.DataGenerator;

import com.Framework.core.BaseUtils;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterDataGenerator  {

    public static String getEmailAddress(){
        return new Faker().internet().emailAddress();
    }

    public static String getFirstName(){
        Faker faker = new Faker();
        String FirstName = faker.name().firstName();
        return FirstName;
    }
    public static String getLastName(){
        Faker faker = new Faker();
        String LastName = faker.name().lastName();
        return LastName;
    }
    public static String getCompanyName(){
        Faker faker = new Faker();
        String CompanyName = faker.company().name();
        return CompanyName;
    }
    public static String getPassword(){
        Faker faker = new Faker();
        String Password = faker.internet().password();
        return Password;
    }
    public static String getAddress1(){
        Faker faker = new Faker();
        String Address1 = faker.address().streetAddress();
        return Address1;

    }
    public static String getAddress2(){
        Faker faker = new Faker();
        String Address2 = faker.address().secondaryAddress();
        return Address2;
    }
    public static String getCity() {
        Faker faker = new Faker();
        String city = faker.address().city();
        return city;
    }


}
