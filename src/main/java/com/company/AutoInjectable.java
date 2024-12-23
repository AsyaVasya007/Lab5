package com.company;
import java.lang.annotation.*;
/**
 * Аннотация для указания, что поле должно иметь внедренную зависимость.
 */
@Target(value = ElementType.FIELD)
@Retention(value = RetentionPolicy.RUNTIME)

public @interface AutoInjectable {}
