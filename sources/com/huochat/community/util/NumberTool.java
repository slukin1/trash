package com.huochat.community.util;

import android.text.TextUtils;
import com.amazonaws.services.s3.model.InstructionFileId;
import java.math.BigDecimal;

public class NumberTool {
    public static String getShorthandNumber(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        BigDecimal bigDecimal = new BigDecimal(str);
        if (bigDecimal.compareTo(new BigDecimal("1000000000")) >= 0) {
            BigDecimal divide = bigDecimal.divide(new BigDecimal(1000000000));
            String plainString = divide.toPlainString();
            if (plainString.length() <= 4) {
                return divide.toPlainString() + "B";
            } else if (plainString.substring(0, 4).endsWith(InstructionFileId.DOT)) {
                return plainString.substring(0, 3) + "B";
            } else {
                return plainString.substring(0, 4) + "B";
            }
        } else if (bigDecimal.compareTo(new BigDecimal("1000000")) >= 0 && bigDecimal.compareTo(new BigDecimal("1000000000")) < 0) {
            BigDecimal divide2 = bigDecimal.divide(new BigDecimal(1000000));
            String plainString2 = divide2.toPlainString();
            if (plainString2.length() <= 4) {
                return divide2.toPlainString() + "M";
            } else if (plainString2.substring(0, 4).endsWith(InstructionFileId.DOT)) {
                return plainString2.substring(0, 3) + "M";
            } else {
                return plainString2.substring(0, 4) + "M";
            }
        } else if (bigDecimal.compareTo(new BigDecimal("1000")) >= 0 && bigDecimal.compareTo(new BigDecimal("1000000")) < 0) {
            BigDecimal divide3 = bigDecimal.divide(new BigDecimal(1000));
            String plainString3 = divide3.toPlainString();
            if (plainString3.length() <= 4) {
                return divide3.toPlainString() + "K";
            } else if (plainString3.substring(0, 4).endsWith(InstructionFileId.DOT)) {
                return plainString3.substring(0, 3) + "K";
            } else {
                return plainString3.substring(0, 4) + "K";
            }
        } else if (bigDecimal.compareTo(new BigDecimal("1000")) >= 0 || bigDecimal.compareTo(BigDecimal.ONE) < 0) {
            String plainString4 = bigDecimal.toPlainString();
            if (plainString4.length() > 5) {
                return new BigDecimal(plainString4.substring(0, 5)).compareTo(BigDecimal.ZERO) > 0 ? plainString4.substring(0, 5) : "0";
            }
            return plainString4;
        } else {
            String plainString5 = bigDecimal.toPlainString();
            if (plainString5.length() > 5) {
                return plainString5.substring(0, 5);
            }
            return plainString5;
        }
    }

    public static String getSimpleShorthandNumber(int i11) {
        if (i11 < 1000) {
            return String.valueOf(i11);
        }
        return (i11 / 1000) + InstructionFileId.DOT + ((i11 % 1000) / 100) + "K";
    }
}
