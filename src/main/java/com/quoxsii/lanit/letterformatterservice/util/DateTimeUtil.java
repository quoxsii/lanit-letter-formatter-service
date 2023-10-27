package com.quoxsii.lanit.letterformatterservice.util;

import jakarta.validation.ClockProvider;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DateTimeUtil {

    private static final ClockProvider UTC_CLOCK_PROVIDER = Clock::systemUTC;

    public static LocalDateTime getCurrentTimeInUTC() {
        return LocalDateTime.now(UTC_CLOCK_PROVIDER.getClock()).truncatedTo(ChronoUnit.MICROS);
    }

}