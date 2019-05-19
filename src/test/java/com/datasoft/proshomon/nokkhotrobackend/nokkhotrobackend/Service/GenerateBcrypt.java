package com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.Service;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Slf4j
public class GenerateBcrypt {

    @Test
    public void readWriteFromExcel() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String pass = encoder.encode("open1234");
        log.info("Password: {}", pass);
    }
}
