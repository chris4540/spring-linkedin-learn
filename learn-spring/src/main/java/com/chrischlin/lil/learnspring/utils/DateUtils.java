package com.chrischlin.lil.learnspring.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class DateUtils {

    public Date createDateFromDateString(String dateString){
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date ret;
        if (StringUtils.hasText(dateString)) {
            try {
                ret = format.parse(dateString);
            } catch (ParseException e) {
                ret = new Date();
            }
        } else {
            ret = new Date();
        }
        return ret;
    }
}
