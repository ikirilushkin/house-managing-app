package ru.kirilushkin.housemanaging.encoder;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class ApplicationPasswordEncoder extends BCryptPasswordEncoder {
}
