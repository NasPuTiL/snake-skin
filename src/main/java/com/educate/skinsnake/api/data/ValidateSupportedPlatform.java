package com.educate.skinsnake.api.data;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {SupportedPlatformValidator.class})
public @interface ValidateSupportedPlatform {
    String message() default "Supported field should belongs to list ";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}