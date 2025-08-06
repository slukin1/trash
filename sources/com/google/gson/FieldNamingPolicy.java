package com.google.gson;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.reflect.Field;
import java.util.Locale;

public enum FieldNamingPolicy implements FieldNamingStrategy {
    IDENTITY {
        public String translateName(Field field) {
            return field.getName();
        }
    },
    UPPER_CAMEL_CASE {
        public String translateName(Field field) {
            return FieldNamingPolicy.upperCaseFirstLetter(field.getName());
        }
    },
    UPPER_CAMEL_CASE_WITH_SPACES {
        public String translateName(Field field) {
            return FieldNamingPolicy.upperCaseFirstLetter(FieldNamingPolicy.separateCamelCase(field.getName(), " "));
        }
    },
    LOWER_CASE_WITH_UNDERSCORES {
        public String translateName(Field field) {
            return FieldNamingPolicy.separateCamelCase(field.getName(), "_").toLowerCase(Locale.ENGLISH);
        }
    },
    LOWER_CASE_WITH_DASHES {
        public String translateName(Field field) {
            return FieldNamingPolicy.separateCamelCase(field.getName(), Constants.ACCEPT_TIME_SEPARATOR_SERVER).toLowerCase(Locale.ENGLISH);
        }
    },
    LOWER_CASE_WITH_DOTS {
        public String translateName(Field field) {
            return FieldNamingPolicy.separateCamelCase(field.getName(), InstructionFileId.DOT).toLowerCase(Locale.ENGLISH);
        }
    };

    private static String modifyString(char c11, String str, int i11) {
        if (i11 >= str.length()) {
            return String.valueOf(c11);
        }
        return c11 + str.substring(i11);
    }

    public static String separateCamelCase(String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        int length = str.length();
        for (int i11 = 0; i11 < length; i11++) {
            char charAt = str.charAt(i11);
            if (Character.isUpperCase(charAt) && sb2.length() != 0) {
                sb2.append(str2);
            }
            sb2.append(charAt);
        }
        return sb2.toString();
    }

    public static String upperCaseFirstLetter(String str) {
        StringBuilder sb2 = new StringBuilder();
        int i11 = 0;
        char charAt = str.charAt(0);
        int length = str.length();
        while (i11 < length - 1 && !Character.isLetter(charAt)) {
            sb2.append(charAt);
            i11++;
            charAt = str.charAt(i11);
        }
        if (Character.isUpperCase(charAt)) {
            return str;
        }
        sb2.append(modifyString(Character.toUpperCase(charAt), str, i11 + 1));
        return sb2.toString();
    }
}
