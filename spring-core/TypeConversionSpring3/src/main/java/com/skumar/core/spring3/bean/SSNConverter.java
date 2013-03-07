package com.skumar.core.spring3.bean;

import org.springframework.core.convert.converter.Converter;

public class SSNConverter implements Converter<String, CustomerSSN> {
    public CustomerSSN convert(String source) {
        int area = Integer.parseInt(source.substring(0, 3));
        int group = Integer.parseInt(source.substring(4, 6));
        int serial = Integer.parseInt(source.substring(7, 11));
        return new CustomerSSN(area, group, serial);
    }
}


