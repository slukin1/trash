package com.sumsub.sns.internal.core.data.source.applicant.remote.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import kotlin.jvm.internal.r;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;

public final class a extends RequestBody {

    /* renamed from: a  reason: collision with root package name */
    public final File f33219a;

    /* renamed from: b  reason: collision with root package name */
    public final String f33220b;

    /* renamed from: c  reason: collision with root package name */
    public final C0361a f33221c;

    /* renamed from: com.sumsub.sns.internal.core.data.source.applicant.remote.utils.a$a  reason: collision with other inner class name */
    public interface C0361a {
        void a();

        void a(int i11);
    }

    public a() {
        this((File) null, (String) null, (C0361a) null, 7, (r) null);
    }

    public long contentLength() throws IOException {
        return this.f33219a.length();
    }

    public MediaType contentType() {
        MediaType.Companion companion = MediaType.Companion;
        return companion.parse(this.f33220b + "/*");
    }

    public void writeTo(BufferedSink bufferedSink) throws IOException {
        C0361a aVar;
        long length = this.f33219a.length();
        byte[] bArr = new byte[b.f33222a];
        FileInputStream fileInputStream = new FileInputStream(this.f33219a);
        long j11 = 0;
        int i11 = 0;
        while (true) {
            try {
                int read = fileInputStream.read(bArr);
                if (read != -1) {
                    long j12 = ((long) 100) * j11;
                    int i12 = (int) (j12 / length);
                    if (i12 > i11 + 1) {
                        C0361a aVar2 = this.f33221c;
                        if (aVar2 != null) {
                            aVar2.a((int) (j12 / length));
                        }
                        i11 = i12;
                    }
                    j11 += (long) read;
                    if (j11 == length && (aVar = this.f33221c) != null) {
                        aVar.a();
                    }
                    bufferedSink.write(bArr, 0, read);
                } else {
                    return;
                }
            } finally {
                fileInputStream.close();
            }
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(File file, String str, C0361a aVar, int i11, r rVar) {
        this((i11 & 1) != 0 ? null : file, (i11 & 2) != 0 ? null : str, (i11 & 4) != 0 ? null : aVar);
    }

    public a(File file, String str, C0361a aVar) {
        this.f33219a = file;
        this.f33220b = str;
        this.f33221c = aVar;
    }
}
