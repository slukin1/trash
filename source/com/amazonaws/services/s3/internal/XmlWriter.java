package com.amazonaws.services.s3.internal;

import com.amazonaws.util.StringUtils;
import java.util.ArrayList;
import java.util.List;

public class XmlWriter {

    /* renamed from: a  reason: collision with root package name */
    public List<String> f15192a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public StringBuilder f15193b = new StringBuilder();

    public final void a(String str, StringBuilder sb2) {
        if (str == null) {
            str = "";
        }
        int length = str.length();
        int i11 = 0;
        int i12 = 0;
        while (i11 < length) {
            char charAt = str.charAt(i11);
            String str2 = charAt != 9 ? charAt != 10 ? charAt != 13 ? charAt != '\"' ? charAt != '&' ? charAt != '<' ? charAt != '>' ? null : "&gt;" : "&lt;" : "&amp;" : "&quot;" : "&#13;" : "&#10;" : "&#9;";
            if (str2 != null) {
                if (i12 < i11) {
                    sb2.append(str, i12, i11);
                }
                this.f15193b.append(str2);
                i12 = i11 + 1;
            }
            i11++;
        }
        if (i12 < i11) {
            this.f15193b.append(str, i12, i11);
        }
    }

    public XmlWriter b() {
        List<String> list = this.f15192a;
        StringBuilder sb2 = this.f15193b;
        sb2.append("</");
        sb2.append(list.remove(list.size() - 1));
        sb2.append(">");
        return this;
    }

    public byte[] c() {
        return toString().getBytes(StringUtils.f15560a);
    }

    public XmlWriter d(String str) {
        StringBuilder sb2 = this.f15193b;
        sb2.append("<");
        sb2.append(str);
        sb2.append(">");
        this.f15192a.add(str);
        return this;
    }

    public XmlWriter e(String str) {
        a(str, this.f15193b);
        return this;
    }

    public String toString() {
        return this.f15193b.toString();
    }
}
