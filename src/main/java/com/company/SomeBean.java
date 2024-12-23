package com.company;
import reflection.SInterface;
import reflection.SOInterface;

public class SomeBean {

    @AutoInjectable
    private SInterface someField;
    @AutoInjectable
    private SOInterface otherField;

    public SomeBean() {}

    public void go(){
        someField.doSome();
        otherField.doSome();
    }
}