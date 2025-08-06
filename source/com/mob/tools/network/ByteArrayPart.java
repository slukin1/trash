package com.mob.tools.network;

import com.mob.tools.utils.Data;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

@Deprecated
public class ByteArrayPart extends HTTPPart {

    /* renamed from: a  reason: collision with root package name */
    private ByteArrayOutputStream f27906a;

    public InputStream a() throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream = this.f27906a;
        if (byteArrayOutputStream == null) {
            return new ByteArrayInputStream(new byte[0]);
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (byteArray == null || this.f27906a.size() <= 0) {
            return new ByteArrayInputStream(new byte[0]);
        }
        return new ByteArrayInputStream(byteArray, 0, this.f27906a.size());
    }

    public ByteArrayPart append(byte[] bArr) throws Throwable {
        if (this.f27906a == null) {
            this.f27906a = new ByteArrayOutputStream(bArr.length);
        }
        this.f27906a.write(bArr);
        this.f27906a.flush();
        return this;
    }

    public long b() throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream = this.f27906a;
        if (byteArrayOutputStream == null) {
            return 0;
        }
        return (long) byteArrayOutputStream.size();
    }

    public String toString() {
        byte[] byteArray;
        ByteArrayOutputStream byteArrayOutputStream = this.f27906a;
        if (byteArrayOutputStream == null || (byteArray = byteArrayOutputStream.toByteArray()) == null) {
            return null;
        }
        return Data.byteToHex(byteArray, 0, this.f27906a.size());
    }
}
