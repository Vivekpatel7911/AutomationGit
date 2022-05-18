package com.Framework.core;

import org.testng.annotations.DataProvider;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface DataProviderArguments {

    String value();


}
