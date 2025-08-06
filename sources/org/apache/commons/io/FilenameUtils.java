package org.apache.commons.io;

import java.io.File;
import java.util.ArrayList;
import java.util.Stack;

public class FilenameUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final String f58937a = Character.toString('.');

    /* renamed from: b  reason: collision with root package name */
    public static final char f58938b = File.separatorChar;

    /* renamed from: c  reason: collision with root package name */
    public static final char f58939c;

    static {
        if (d()) {
            f58939c = '/';
        } else {
            f58939c = '\\';
        }
    }

    public static String a(String str) {
        if (str == null) {
            return null;
        }
        int b11 = b(str);
        if (b11 == -1) {
            return "";
        }
        return str.substring(b11 + 1);
    }

    public static int b(String str) {
        int lastIndexOf;
        if (str != null && c(str) <= (lastIndexOf = str.lastIndexOf(46))) {
            return lastIndexOf;
        }
        return -1;
    }

    public static int c(String str) {
        if (str == null) {
            return -1;
        }
        return Math.max(str.lastIndexOf(47), str.lastIndexOf(92));
    }

    public static boolean d() {
        return f58938b == '\\';
    }

    public static String[] e(String str) {
        if (str.indexOf(63) == -1 && str.indexOf(42) == -1) {
            return new String[]{str};
        }
        char[] charArray = str.toCharArray();
        ArrayList arrayList = new ArrayList();
        StringBuilder sb2 = new StringBuilder();
        int length = charArray.length;
        int i11 = 0;
        char c11 = 0;
        while (i11 < length) {
            char c12 = charArray[i11];
            if (c12 == '?' || c12 == '*') {
                if (sb2.length() != 0) {
                    arrayList.add(sb2.toString());
                    sb2.setLength(0);
                }
                if (c12 == '?') {
                    arrayList.add("?");
                } else if (c11 != '*') {
                    arrayList.add("*");
                }
            } else {
                sb2.append(c12);
            }
            i11++;
            c11 = c12;
        }
        if (sb2.length() != 0) {
            arrayList.add(sb2.toString());
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static boolean f(String str, String str2) {
        return g(str, str2, IOCase.SENSITIVE);
    }

    public static boolean g(String str, String str2, IOCase iOCase) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null || str2 == null) {
            return false;
        }
        if (iOCase == null) {
            iOCase = IOCase.SENSITIVE;
        }
        String[] e11 = e(str2);
        Stack stack = new Stack();
        boolean z11 = false;
        int i11 = 0;
        int i12 = 0;
        do {
            if (stack.size() > 0) {
                int[] iArr = (int[]) stack.pop();
                i12 = iArr[0];
                i11 = iArr[1];
                z11 = true;
            }
            while (i12 < e11.length) {
                if (e11[i12].equals("?")) {
                    i11++;
                    if (i11 > str.length()) {
                        break;
                    }
                } else if (e11[i12].equals("*")) {
                    if (i12 == e11.length - 1) {
                        i11 = str.length();
                    }
                    z11 = true;
                    i12++;
                } else {
                    if (!z11) {
                        if (!iOCase.checkRegionMatches(str, i11, e11[i12])) {
                            break;
                        }
                    } else {
                        i11 = iOCase.checkIndexOf(str, i11, e11[i12]);
                        if (i11 == -1) {
                            break;
                        }
                        int checkIndexOf = iOCase.checkIndexOf(str, i11 + 1, e11[i12]);
                        if (checkIndexOf >= 0) {
                            stack.push(new int[]{i12, checkIndexOf});
                        }
                    }
                    i11 += e11[i12].length();
                }
                z11 = false;
                i12++;
            }
            if (i12 == e11.length && i11 == str.length()) {
                return true;
            }
        } while (stack.size() > 0);
        return false;
    }
}
