package com.blankj.utilcode.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class y {

    /* renamed from: a  reason: collision with root package name */
    public static final String f63545a = System.getProperty("line.separator");

    public static String a(Throwable th2) {
        List<String> list;
        ArrayList arrayList = new ArrayList();
        while (th2 != null && !arrayList.contains(th2)) {
            arrayList.add(th2);
            th2 = th2.getCause();
        }
        int size = arrayList.size();
        ArrayList<String> arrayList2 = new ArrayList<>();
        int i11 = size - 1;
        List<String> b11 = b((Throwable) arrayList.get(i11));
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (size != 0) {
                list = b((Throwable) arrayList.get(size - 1));
                c(b11, list);
            } else {
                list = b11;
            }
            if (size == i11) {
                arrayList2.add(((Throwable) arrayList.get(size)).toString());
            } else {
                arrayList2.add(" Caused by: " + ((Throwable) arrayList.get(size)).toString());
            }
            arrayList2.addAll(b11);
            b11 = list;
        }
        StringBuilder sb2 = new StringBuilder();
        for (String append : arrayList2) {
            sb2.append(append);
            sb2.append(f63545a);
        }
        return sb2.toString();
    }

    public static List<String> b(Throwable th2) {
        StringWriter stringWriter = new StringWriter();
        th2.printStackTrace(new PrintWriter(stringWriter, true));
        StringTokenizer stringTokenizer = new StringTokenizer(stringWriter.toString(), f63545a);
        ArrayList arrayList = new ArrayList();
        boolean z11 = false;
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            int indexOf = nextToken.indexOf("at");
            if (indexOf != -1 && nextToken.substring(0, indexOf).trim().isEmpty()) {
                arrayList.add(nextToken);
                z11 = true;
            } else if (z11) {
                break;
            }
        }
        return arrayList;
    }

    public static void c(List<String> list, List<String> list2) {
        int size = list.size() - 1;
        int size2 = list2.size() - 1;
        while (size >= 0 && size2 >= 0) {
            if (list.get(size).equals(list2.get(size2))) {
                list.remove(size);
            }
            size--;
            size2--;
        }
    }
}
