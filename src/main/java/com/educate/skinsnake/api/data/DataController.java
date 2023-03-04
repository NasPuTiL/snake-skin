package com.educate.skinsnake.api.data;

import com.educate.skinsnake.api.data.request.DataUpdateDto;
import com.educate.skinsnake.applkcation.data.DataService;
import com.educate.skinsnake.applkcation.data.SupportedPlatform;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("api/data")
@Api("Data controller")
public class DataController {
    private final DataService dataService;

    @ApiOperation(value = "User login endpoint")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved"),
            @ApiResponse(code = 404, message = "Not found - The product was not found"),
            @ApiResponse(code = 500, message = "Server error")
    })
    @PutMapping("update")
    public List<String> generateToken(
            @ApiParam(value = "dataUpdateDto") @Valid @ValidateSupportedPlatform @RequestBody(required = false) DataUpdateDto dataUpdateDto) {
        List<SupportedPlatform> supportedPlatforms = (null == dataUpdateDto) ? Arrays.asList(SupportedPlatform.values()) : dataUpdateDto.getPlatformList();
        return dataService.updateData(supportedPlatforms);
    }
}