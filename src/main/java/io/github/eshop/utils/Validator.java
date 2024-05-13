package io.github.eshop.utils;

import org.springframework.stereotype.Component;


@Component
public class Validator {

    public Boolean validateCategoryName(Object categoryName) {
        if (categoryName == null) {
            return false;
        } else if (categoryName.toString().equals("")) {
            return false;
        } else if ((categoryName instanceof Integer)) {
            return false;
        }
        return true;
    }
}
