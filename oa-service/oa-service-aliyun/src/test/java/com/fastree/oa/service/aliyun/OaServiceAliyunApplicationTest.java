package com.fastree.oa.service.aliyun;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class OaServiceAliyunApplicationTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
//        LocalDateTime start = LocalDateTime.of(2020, 12, 7, 9, 7, 0);
//        System.out.println(start.plusHours(7).plusMinutes(40));


//

        System.out.println(Integer.toBinaryString(Float.floatToIntBits(1.0f)));
        System.out.println(Integer.toBinaryString(Float.floatToIntBits(-0.9f)));
        System.out.println(Long.toBinaryString(Double.doubleToLongBits(-22.25)));

        System.out.println(test(Integer.toBinaryString(Float.floatToIntBits(1.0f - 0.9f)), 32, "0"));

        System.out.println(1.0f - 0.9f);
        System.out.println(1.0d - 0.9d);

        String ch = "佑";
        byte[] bytes = ch.getBytes(StandardCharsets.UTF_8);
        for (int i = 0; i < bytes.length; i++) {
            System.out.println(bytes[i]);
            System.out.println(Integer.toBinaryString(bytes[i]));
        }

        String decode = new String(bytes, StandardCharsets.UTF_8);

        System.out.println(decode);

        

    }


    public static String test(String str, int len, String ch) {
        StringBuilder sb = new StringBuilder();
        int loop = len - str.length();
        if (loop > 0) {
            for (int i = 0; i < loop; i++) {
                sb.append(ch);
            }
        }
        sb.append(str);

        return sb.toString();

    }


}
