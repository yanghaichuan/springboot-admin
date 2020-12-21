package com.yhc.example.utils;

/**
 * Created with IDEA2018.3
 * author:杨海传
 * Date:2020-07-06 17:18
 */
public class SequenceUtils {
    static final int DEFAULT_LENGTH = 4;
    public static String getSequence(long seq) {
        String str = String.valueOf(seq);
        int len = str.length();
        if (len >= DEFAULT_LENGTH) {// 取决于业务规模,应该不会到达4
            return str;
        }
        int rest = DEFAULT_LENGTH - len;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rest; i++) {
            sb.append('0');
        }
        sb.append(str);
        return sb.toString();
    }
}
