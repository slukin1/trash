package com.amazonaws.services.s3.model.transform;

import java.util.Iterator;
import java.util.LinkedList;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

abstract class AbstractHandler extends DefaultHandler {

    /* renamed from: b  reason: collision with root package name */
    public final StringBuilder f15372b = new StringBuilder();

    /* renamed from: c  reason: collision with root package name */
    public final LinkedList<String> f15373c = new LinkedList<>();

    public final boolean a() {
        return this.f15373c.isEmpty();
    }

    public abstract void b(String str, String str2, String str3);

    public abstract void c(String str, String str2, String str3, Attributes attributes);

    public final void characters(char[] cArr, int i11, int i12) {
        this.f15372b.append(cArr, i11, i12);
    }

    public final String d() {
        return this.f15372b.toString();
    }

    public final boolean e(String... strArr) {
        if (strArr.length != this.f15373c.size()) {
            return false;
        }
        Iterator it2 = this.f15373c.iterator();
        int i11 = 0;
        while (it2.hasNext()) {
            String str = (String) it2.next();
            String str2 = strArr[i11];
            if (!str2.equals("*") && !str2.equals(str)) {
                return false;
            }
            i11++;
        }
        return true;
    }

    public final void endElement(String str, String str2, String str3) {
        this.f15373c.removeLast();
        b(str, str2, str3);
    }

    public final void startElement(String str, String str2, String str3, Attributes attributes) {
        this.f15372b.setLength(0);
        c(str, str2, str3, attributes);
        this.f15373c.add(str2);
    }
}
