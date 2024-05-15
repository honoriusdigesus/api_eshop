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

    public Boolean validateProduct(ProductDomain productDomain) {
        System.out.println(productDomain.getName() + "xxxxxxxxxxxx");
        Matcher matcher = pattern.matcher(productDomain.getName());

        if (
                productDomain.getName() == null ||
                productDomain.getName().length() ==0 ||
                productDomain.getPrice() <= 0 ||
                productDomain.getPrice()== null ||
                productDomain.getStock() <= 0 ||
                productDomain.getStock().equals("") ||
                productDomain.getCategory().getId() == null ||
                productDomain.getCategory().getId().equals("")
        ) {
            return false;
        } else if (matcher.matches()) {
            return false;
        }
        return true;
    }

    public Boolean validateNameProduct(String name) {
        Matcher matcher = pattern.matcher(name);
        if (name == null || name.equals("")) {
            return false;
        } else if (matcher.matches()) {
            return false;
        }
        return true;
    }
}
