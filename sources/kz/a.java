package kz;

import java.util.ArrayList;
import java.util.List;
import mz.f;

public class a {
    public static String a(String str) {
        if (f.e(str)) {
            return "Zendesk";
        }
        return str.length() > 23 ? str.substring(0, 23) : str;
    }

    public static char b(int i11) {
        if (i11 == 2) {
            return 'V';
        }
        if (i11 == 3) {
            return 'D';
        }
        if (i11 == 5) {
            return 'W';
        }
        if (i11 != 6) {
            return i11 != 7 ? 'I' : 'A';
        }
        return 'E';
    }

    public static List<String> c(String str, int i11) {
        int min;
        ArrayList arrayList = new ArrayList();
        if (i11 < 1) {
            if (!f.c(str)) {
                arrayList.add("");
                return arrayList;
            }
            arrayList.add(str);
            return arrayList;
        } else if (!f.c(str)) {
            arrayList.add("");
            return arrayList;
        } else if (str.length() < i11) {
            arrayList.add(str);
            return arrayList;
        } else {
            int i12 = 0;
            int length = str.length();
            while (i12 < length) {
                int indexOf = str.indexOf(f.f58291b, i12);
                if (indexOf == -1) {
                    indexOf = length;
                }
                while (true) {
                    min = Math.min(indexOf, i12 + i11);
                    arrayList.add(str.substring(i12, min));
                    if (min >= indexOf) {
                        break;
                    }
                    i12 = min;
                }
                i12 = min + 1;
            }
            return arrayList;
        }
    }
}
