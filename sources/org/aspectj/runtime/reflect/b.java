package org.aspectj.runtime.reflect;

import w10.a;

public class b extends a implements a {
    public b(int i11, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i11, "<init>", cls, clsArr, strArr, clsArr2);
    }

    public String a(h hVar) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(hVar.e(i()));
        stringBuffer.append(hVar.f(f(), g()));
        hVar.a(stringBuffer, n());
        hVar.b(stringBuffer, m());
        return stringBuffer.toString();
    }
}
