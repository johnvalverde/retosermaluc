package com.sermaluc.reto.utils.services.impl;

import com.sermaluc.reto.utils.services.UtilService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UtilServiceImpl implements UtilService {

    @Value("${regex.email}")
    private String regexEmail;
    @Value("${regex.password}")
    private String regexPassword;

    @Override
    public Boolean isValidEmail(String email) {

        Pattern pattern = Pattern.compile(regexEmail);

        if (email == null) {
            return false;
        }
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    @Override
    public Boolean isValidPassword(String password) {

        Pattern pattern = Pattern.compile(regexPassword);

        if (password == null) {
            return false;
        }
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
