package io.github.eshop.utils;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Component
public class Validator {

    public Boolean validateCategoryName(Object categoryName) {
        String regex = "^-?\\d+(\\.\\d+)?$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(categoryName.toString());

        if (categoryName == null) {
            return false;
        } else if (categoryName.toString().equals("")) {
            return false;
        } else if (matcher.matches()) {
            return false;
        }
        return true;
    }
}
