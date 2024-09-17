package com.sermaluc.reto.utils.services.impl;

import com.sermaluc.reto.utils.services.UtilService;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.sermaluc.reto.utils.config.RegEx.REGEX_EMAIL;
import static com.sermaluc.reto.utils.config.RegEx.REGEX_PWD;

@Service
public class UtilServiceImpl implements UtilService {
    @Override
    public Boolean isValidEmail(String email) {

        Pattern pattern = Pattern.compile(REGEX_EMAIL);

        if (email == null) {
            return false;
        }
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    @Override
    public Boolean isValidPassword(String password) {

        Pattern pattern = Pattern.compile(REGEX_PWD);

        if (password == null) {
            return false;
        }
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
