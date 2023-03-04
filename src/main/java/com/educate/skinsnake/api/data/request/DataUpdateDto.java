package com.educate.skinsnake.api.data.request;

import com.educate.skinsnake.applkcation.data.SupportedPlatform;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter
public class DataUpdateDto {
    @NotEmpty
    private List<SupportedPlatform> platformList;
}