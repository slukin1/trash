package com.amazonaws.util;

import com.amazonaws.internal.SdkFilterInputStream;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

class NamespaceRemovingInputStream extends SdkFilterInputStream {

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f15556b = new byte[200];

    /* renamed from: c  reason: collision with root package name */
    public boolean f15557c = false;

    public static final class StringPrefixSlicer {

        /* renamed from: a  reason: collision with root package name */
        public String f15558a;

        public StringPrefixSlicer(String str) {
            this.f15558a = str;
        }

        public String a() {
            return this.f15558a;
        }

        public boolean b(String str) {
            if (!this.f15558a.startsWith(str)) {
                return false;
            }
            this.f15558a = this.f15558a.substring(str.length());
            return true;
        }

        public boolean c(String str) {
            int indexOf = this.f15558a.indexOf(str);
            if (indexOf < 0) {
                return false;
            }
            this.f15558a = this.f15558a.substring(indexOf + str.length());
            return true;
        }

        public boolean d(String str) {
            if (!this.f15558a.startsWith(str)) {
                return false;
            }
            while (this.f15558a.startsWith(str)) {
                this.f15558a = this.f15558a.substring(str.length());
            }
            return true;
        }
    }

    public NamespaceRemovingInputStream(InputStream inputStream) {
        super(new BufferedInputStream(inputStream));
    }

    public final int f(String str) {
        StringPrefixSlicer stringPrefixSlicer = new StringPrefixSlicer(str);
        if (!stringPrefixSlicer.b("xmlns")) {
            return -1;
        }
        stringPrefixSlicer.d(" ");
        if (!stringPrefixSlicer.b(ContainerUtils.KEY_VALUE_DELIMITER)) {
            return -1;
        }
        stringPrefixSlicer.d(" ");
        if (stringPrefixSlicer.b("\"") && stringPrefixSlicer.c("\"")) {
            return str.length() - stringPrefixSlicer.a().length();
        }
        return -1;
    }

    public int read() throws IOException {
        e();
        int read = this.in.read();
        if (read != 120 || this.f15557c) {
            return read;
        }
        this.f15556b[0] = (byte) read;
        this.in.mark(this.f15556b.length);
        InputStream inputStream = this.in;
        byte[] bArr = this.f15556b;
        int read2 = inputStream.read(bArr, 1, bArr.length - 1);
        this.in.reset();
        int f11 = f(new String(this.f15556b, 0, read2 + 1, StringUtils.f15560a));
        if (f11 <= 0) {
            return read;
        }
        for (int i11 = 0; i11 < f11 - 1; i11++) {
            this.in.read();
        }
        int read3 = this.in.read();
        this.f15557c = true;
        return read3;
    }

    public int read(byte[] bArr, int i11, int i12) throws IOException {
        int i13 = 0;
        while (i13 < i12) {
            int read = read();
            if (read != -1) {
                bArr[i13 + i11] = (byte) read;
                i13++;
            } else if (i13 == 0) {
                return -1;
            } else {
                return i13;
            }
        }
        return i12;
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }
}
