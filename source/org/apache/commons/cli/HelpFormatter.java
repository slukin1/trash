package org.apache.commons.cli;

import com.xiaomi.mipush.sdk.Constants;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class HelpFormatter {

    /* renamed from: a  reason: collision with root package name */
    public int f58880a = 74;

    /* renamed from: b  reason: collision with root package name */
    public int f58881b = 1;

    /* renamed from: c  reason: collision with root package name */
    public int f58882c = 3;

    /* renamed from: d  reason: collision with root package name */
    public String f58883d = "usage: ";

    /* renamed from: e  reason: collision with root package name */
    public String f58884e = System.getProperty("line.separator");

    /* renamed from: f  reason: collision with root package name */
    public String f58885f = Constants.ACCEPT_TIME_SEPARATOR_SERVER;

    /* renamed from: g  reason: collision with root package name */
    public String f58886g = "--";

    /* renamed from: h  reason: collision with root package name */
    public String f58887h = "arg";

    /* renamed from: i  reason: collision with root package name */
    public Comparator f58888i = new a();

    public static class a implements Comparator {
        public a() {
        }

        public int compare(Object obj, Object obj2) {
            return ((Option) obj).getKey().compareToIgnoreCase(((Option) obj2).getKey());
        }
    }

    public String a(int i11) {
        StringBuffer stringBuffer = new StringBuffer(i11);
        for (int i12 = 0; i12 < i11; i12++) {
            stringBuffer.append(' ');
        }
        return stringBuffer.toString();
    }

    public int b(String str, int i11, int i12) {
        int indexOf = str.indexOf(10, i12);
        if ((indexOf != -1 && indexOf <= i11) || ((indexOf = str.indexOf(9, i12)) != -1 && indexOf <= i11)) {
            return indexOf + 1;
        }
        int i13 = i11 + i12;
        if (i13 >= str.length()) {
            return -1;
        }
        int i14 = i13;
        while (i14 >= i12 && (r5 = str.charAt(i14)) != ' ' && r5 != 10 && r5 != 13) {
            i14--;
        }
        if (i14 > i12) {
            return i14;
        }
        while (i13 <= str.length() && (r9 = str.charAt(i13)) != ' ' && r9 != 10 && r9 != 13) {
            i13++;
        }
        if (i13 == str.length()) {
            return -1;
        }
        return i13;
    }

    public int c() {
        return this.f58882c;
    }

    public int d() {
        return this.f58881b;
    }

    public Comparator e() {
        return this.f58888i;
    }

    public int f() {
        return this.f58880a;
    }

    public void g(PrintWriter printWriter, int i11, Options options, int i12, int i13) {
        StringBuffer stringBuffer = new StringBuffer();
        h(stringBuffer, i11, options, i12, i13);
        printWriter.println(stringBuffer.toString());
    }

    public StringBuffer h(StringBuffer stringBuffer, int i11, Options options, int i12, int i13) {
        String a11 = a(i12);
        String a12 = a(i13);
        ArrayList arrayList = new ArrayList();
        List<Option> helpOptions = options.helpOptions();
        Collections.sort(helpOptions, e());
        int i14 = 0;
        int i15 = 0;
        for (Option option : helpOptions) {
            StringBuffer stringBuffer2 = new StringBuffer(8);
            if (option.getOpt() == null) {
                stringBuffer2.append(a11);
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("   ");
                stringBuffer3.append(this.f58886g);
                stringBuffer2.append(stringBuffer3.toString());
                stringBuffer2.append(option.getLongOpt());
            } else {
                stringBuffer2.append(a11);
                stringBuffer2.append(this.f58885f);
                stringBuffer2.append(option.getOpt());
                if (option.hasLongOpt()) {
                    stringBuffer2.append(',');
                    stringBuffer2.append(this.f58886g);
                    stringBuffer2.append(option.getLongOpt());
                }
            }
            if (option.hasArg()) {
                if (option.hasArgName()) {
                    stringBuffer2.append(" <");
                    stringBuffer2.append(option.getArgName());
                    stringBuffer2.append(">");
                } else {
                    stringBuffer2.append(' ');
                }
            }
            arrayList.add(stringBuffer2);
            if (stringBuffer2.length() > i15) {
                i15 = stringBuffer2.length();
            }
        }
        Iterator it2 = helpOptions.iterator();
        while (it2.hasNext()) {
            Option option2 = (Option) it2.next();
            int i16 = i14 + 1;
            StringBuffer stringBuffer4 = new StringBuffer(arrayList.get(i14).toString());
            if (stringBuffer4.length() < i15) {
                stringBuffer4.append(a(i15 - stringBuffer4.length()));
            }
            stringBuffer4.append(a12);
            int i17 = i15 + i13;
            if (option2.getDescription() != null) {
                stringBuffer4.append(option2.getDescription());
            }
            i(stringBuffer, i11, i17, stringBuffer4.toString());
            if (it2.hasNext()) {
                stringBuffer.append(this.f58884e);
            }
            i14 = i16;
        }
        return stringBuffer;
    }

    public StringBuffer i(StringBuffer stringBuffer, int i11, int i12, String str) {
        int b11 = b(str, i11, 0);
        if (b11 == -1) {
            stringBuffer.append(j(str));
            return stringBuffer;
        }
        stringBuffer.append(j(str.substring(0, b11)));
        stringBuffer.append(this.f58884e);
        if (i12 >= i11) {
            i12 = 1;
        }
        String a11 = a(i12);
        while (true) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(a11);
            stringBuffer2.append(str.substring(b11).trim());
            str = stringBuffer2.toString();
            b11 = b(str, i11, 0);
            if (b11 == -1) {
                stringBuffer.append(str);
                return stringBuffer;
            }
            if (str.length() > i11 && b11 == i12 - 1) {
                b11 = i11;
            }
            stringBuffer.append(j(str.substring(0, b11)));
            stringBuffer.append(this.f58884e);
        }
    }

    public String j(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        int length = str.length();
        while (length > 0 && Character.isWhitespace(str.charAt(length - 1))) {
            length--;
        }
        return str.substring(0, length);
    }
}
