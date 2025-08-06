package org.apache.commons.cli;

import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import s10.c;

public class GnuParser extends Parser {
    public String[] c(Options options, String[] strArr, boolean z11) {
        ArrayList arrayList = new ArrayList();
        int i11 = 0;
        boolean z12 = false;
        while (i11 < strArr.length) {
            String str = strArr[i11];
            if ("--".equals(str)) {
                arrayList.add("--");
                z12 = true;
            } else if (Constants.ACCEPT_TIME_SEPARATOR_SERVER.equals(str)) {
                arrayList.add(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            } else if (str.startsWith(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
                String b11 = c.b(str);
                if (options.hasOption(b11)) {
                    arrayList.add(str);
                } else if (b11.indexOf(61) != -1 && options.hasOption(b11.substring(0, b11.indexOf(61)))) {
                    arrayList.add(str.substring(0, str.indexOf(61)));
                    arrayList.add(str.substring(str.indexOf(61) + 1));
                } else if (options.hasOption(str.substring(0, 2))) {
                    arrayList.add(str.substring(0, 2));
                    arrayList.add(str.substring(2));
                } else {
                    arrayList.add(str);
                    z12 = z11;
                }
            } else {
                arrayList.add(str);
            }
            if (z12) {
                while (true) {
                    i11++;
                    if (i11 >= strArr.length) {
                        break;
                    }
                    arrayList.add(strArr[i11]);
                }
            }
            i11++;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}
