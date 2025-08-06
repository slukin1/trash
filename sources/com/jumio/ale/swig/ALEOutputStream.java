package com.jumio.ale.swig;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ALEOutputStream extends FilterOutputStream {

    /* renamed from: a  reason: collision with root package name */
    public final ALERequest f38902a;

    /* renamed from: b  reason: collision with root package name */
    public final OutputStream f38903b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f38904c;

    /* renamed from: d  reason: collision with root package name */
    public int f38905d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f38906e;

    public ALEOutputStream(OutputStream outputStream, ALERequest aLERequest, int i11) throws Exception {
        this(outputStream, aLERequest, (ALEHeader) null, i11);
    }

    public void close() throws IOException {
        if (!this.f38906e) {
            this.f38906e = true;
            try {
                byte[] bArr = new byte[this.f38902a.calculateRequestFinish()];
                this.f38904c = bArr;
                this.f38905d = this.f38902a.finishRequest(bArr);
            } catch (Exception unused) {
                this.f38904c = null;
                this.f38905d = 0;
            }
            try {
                flush();
            } catch (IOException unused2) {
            }
            this.f38903b.close();
        }
    }

    public void flush() throws IOException {
        byte[] bArr = this.f38904c;
        if (bArr != null) {
            this.f38903b.write(bArr, 0, this.f38905d);
            this.f38904c = null;
        }
        this.f38903b.flush();
    }

    public void write(byte[] bArr, int i11, int i12) throws IOException {
        if (i11 == 0 && i12 == bArr.length) {
            write(bArr);
            return;
        }
        byte[] bArr2 = new byte[i12];
        System.arraycopy(bArr, i11, bArr2, 0, i12);
        write(bArr2);
    }

    public ALEOutputStream(OutputStream outputStream, ALERequest aLERequest, ALEHeader aLEHeader, int i11) throws Exception {
        super(outputStream);
        this.f38902a = null;
        this.f38905d = 0;
        this.f38906e = false;
        this.f38903b = outputStream;
        this.f38902a = aLERequest;
        byte[] bArr = new byte[aLERequest.calculateRequestInit(aLEHeader, i11)];
        this.f38904c = bArr;
        int initRequest = aLERequest.initRequest(aLEHeader, i11, bArr);
        this.f38905d = initRequest;
        outputStream.write(this.f38904c, 0, initRequest);
    }

    public void write(byte[] bArr) throws IOException {
        byte[] bArr2 = new byte[this.f38902a.calculateRequestUpdate(bArr.length)];
        this.f38904c = bArr2;
        try {
            int updateRequest = this.f38902a.updateRequest(bArr, bArr2);
            this.f38905d = updateRequest;
            byte[] bArr3 = this.f38904c;
            if (bArr3 != null) {
                this.f38903b.write(bArr3, 0, updateRequest);
                this.f38904c = null;
                this.f38905d = 0;
            }
        } catch (Exception e11) {
            throw new IOException(e11);
        }
    }
}
