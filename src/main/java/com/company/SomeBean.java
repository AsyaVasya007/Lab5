package com.company;
import reflection.SInterface;
import reflection.SOInterface;
/**
 * Класс, представляющий объект с внедряемыми зависимостями.
 */
public class SomeBean {

    /**
     * Внедряемое поле, реализующее SInterface.
     */
    @AutoInjectable
    private SInterface someField;

    /**
     * Внедряемое поле, реализующее SOInterface.
     */
    @AutoInjectable
    private SOInterface otherField;

    /**
     * Конструктор по умолчанию для SomeBean.
     */
    public SomeBean() {}

    /**
     * Метод для вызова функциональности внедренных зависимостей.
     */
    public void go(){
        someField.doSome();
        otherField.doSome();
    }
}