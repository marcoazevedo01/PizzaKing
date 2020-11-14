package br.com.syspizza.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class manipulaData {
    public static Date convertToDate(String data) throws Exception {
        if(data != null || !data.equals("")){
            SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
            Date newData = fmt.parse(data);
            return newData;
        }else{
            return null;
        }
    }
    
}


