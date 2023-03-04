package com.educate.skinsnake.applkcation.data.g2;

import com.educate.skinsnake.applkcation.data.GameProvider;
import com.educate.skinsnake.applkcation.data.SupportedPlatform;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class G2Provider implements GameProvider {
    private static final String RETURN_MESSAGE = "G2: OK";
    private final G2Property property;

    @Override
    public String update() {
        log.info("Updating: {}", SupportedPlatform.G2);
        System.out.println("TEST = " + property.getMainPath());
        return RETURN_MESSAGE;
    }

    @Override
    public SupportedPlatform supporting() {
        return SupportedPlatform.G2;
    }
}