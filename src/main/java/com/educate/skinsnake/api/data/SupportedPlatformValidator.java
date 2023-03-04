package com.educate.skinsnake.api.data;

import com.educate.skinsnake.api.data.request.DataUpdateDto;
import com.educate.skinsnake.applkcation.data.SupportedPlatform;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
public class SupportedPlatformValidator implements ConstraintValidator<ValidateSupportedPlatform, DataUpdateDto> {
    private String message;

    @Override
    public void initialize(ValidateSupportedPlatform constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        message = String.format("%s %s", constraintAnnotation.message(), Arrays.asList(SupportedPlatform.values()));
    }

    @Override
    public boolean isValid(DataUpdateDto dataUpdateDto, ConstraintValidatorContext constraintValidatorContext) {
        if (Objects.isNull(dataUpdateDto)) {
            return Boolean.TRUE;
        }
        Boolean validationResult = validateSupportedTypes(dataUpdateDto.getPlatformList());

        if (!validationResult) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(message)
                    .addConstraintViolation();
        }
        return validationResult;
    }

    private Boolean validateSupportedTypes(List<SupportedPlatform> supportedOptions) {
        return Arrays.asList(SupportedPlatform.values()).containsAll(supportedOptions);
    }
}