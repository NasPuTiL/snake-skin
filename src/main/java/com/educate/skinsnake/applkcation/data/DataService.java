package com.educate.skinsnake.applkcation.data;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class DataService {
    private final List<GameProvider> providers;

    public List<String> updateData(@NotNull List<SupportedPlatform> platforms) {
        log.info("Update data process started");
        return providers.stream()
                .filter(gameProvider -> platforms.contains(gameProvider.supporting()))
                .map(GameProvider::update)
                .collect(Collectors.toList());
    }
}