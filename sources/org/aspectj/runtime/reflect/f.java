package org.aspectj.runtime.reflect;

import com.amazonaws.services.s3.model.InstructionFileId;
import w10.b;

public class f extends a implements b {

    /* renamed from: n  reason: collision with root package name */
    public Class f59017n;

    public f(int i11, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2, Class cls2) {
        super(i11, str, cls, clsArr, strArr, clsArr2);
        this.f59017n = cls2;
    }

    public String a(h hVar) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(hVar.e(i()));
        if (hVar.f59025b) {
            stringBuffer.append(hVar.g(o()));
        }
        if (hVar.f59025b) {
            stringBuffer.append(" ");
        }
        stringBuffer.append(hVar.f(f(), g()));
        stringBuffer.append(InstructionFileId.DOT);
        stringBuffer.append(j());
        hVar.a(stringBuffer, n());
        hVar.b(stringBuffer, m());
        return stringBuffer.toString();
    }

    public Class o() {
        if (this.f59017n == null) {
            this.f59017n = d(6);
        }
        return this.f59017n;
    }
}
