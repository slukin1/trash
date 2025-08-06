package com.google.zxing.client.android.encode;

import android.telephony.PhoneNumberUtils;
import java.util.HashSet;
import java.util.List;

abstract class ContactEncoder {
    public static void append(StringBuilder sb2, StringBuilder sb3, String str, String str2, Formatter formatter, char c11) {
        String trim = trim(str2);
        if (trim != null) {
            sb2.append(str);
            sb2.append(formatter.format(trim, 0));
            sb2.append(c11);
            sb3.append(trim);
            sb3.append(10);
        }
    }

    public static void appendUpToUnique(StringBuilder sb2, StringBuilder sb3, String str, List<String> list, int i11, Formatter formatter, Formatter formatter2, char c11) {
        CharSequence charSequence;
        if (list != null) {
            HashSet hashSet = new HashSet(2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                String trim = trim(list.get(i13));
                if (trim != null && !trim.isEmpty() && !hashSet.contains(trim)) {
                    sb2.append(str);
                    sb2.append(formatter2.format(trim, i13));
                    sb2.append(c11);
                    if (formatter == null) {
                        charSequence = trim;
                    } else {
                        charSequence = formatter.format(trim, i13);
                    }
                    sb3.append(charSequence);
                    sb3.append(10);
                    i12++;
                    if (i12 != i11) {
                        hashSet.add(trim);
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public static String formatPhone(String str) {
        return PhoneNumberUtils.formatNumber(str);
    }

    public static String trim(String str) {
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        if (trim.isEmpty()) {
            return null;
        }
        return trim;
    }

    public abstract String[] encode(List<String> list, String str, List<String> list2, List<String> list3, List<String> list4, List<String> list5, List<String> list6, String str2);
}
