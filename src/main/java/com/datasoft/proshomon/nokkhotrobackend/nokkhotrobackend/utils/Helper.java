package com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.utils;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.TimeZone;

public class Helper {
    public Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    public static ZoneId defaultZoneId = TimeZone.getDefault().toZoneId();
    public static LocalDateTime timeStampToLocalDateTime(Timestamp timestamp) {
        return LocalDateTime.ofInstant(timestamp.toInstant(), defaultZoneId);
    }
}
