package io.github.eshop.utils;

import io.github.eshop.domain.entity.ProductDomain;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Component
public class Validator {
    String regex = "^-?\\d+(\\.\\d+)?$";
    Pattern pattern = Pattern.compile(regex);

    public Boolean validateCategoryName(Object categoryName) {

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

    public Boolean validateProduct(ProductDomain product) {

        Matcher matcher = pattern.matcher(product.getName().toString());

        if (
                product.getName() == null ||
                product.getName().equals("") ||
                product.getPrice() <= 0 ||
                product.getPrice().equals("") ||
                product.getStock() <= 0 ||
                product.getStock().equals("") ||
                product.getCategory().getId() == null ||
                product.getCategory().getId().equals("")
        ) {
            return false;
        } else if (matcher.matches()) {
            return false;
        }
        return true;
    }
}
