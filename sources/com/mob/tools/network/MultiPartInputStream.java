package com.mob.tools.network;

import com.mob.tools.proguard.PublicMemberKeeper;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class MultiPartInputStream extends InputStream implements PublicMemberKeeper {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<InputStream> f27916a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private int f27917b;

    private boolean a() {
        ArrayList<InputStream> arrayList = this.f27916a;
        return arrayList == null || arrayList.size() <= 0;
    }

    public void addInputStream(InputStream inputStream) throws Throwable {
        this.f27916a.add(inputStream);
    }

    public int available() throws IOException {
        if (a()) {
            return 0;
        }
        return this.f27916a.get(this.f27917b).available();
    }

    public void close() throws IOException {
        Iterator<InputStream> it2 = this.f27916a.iterator();
        while (it2.hasNext()) {
            it2.next().close();
        }
    }

    public int read() throws IOException {
        if (a()) {
            return -1;
        }
        int read = this.f27916a.get(this.f27917b).read();
        while (read < 0) {
            int i11 = this.f27917b + 1;
            this.f27917b = i11;
            if (i11 >= this.f27916a.size()) {
                break;
            }
            read = this.f27916a.get(this.f27917b).read();
        }
        return read;
    }

    public long skip(long j11) throws IOException {
        throw new IOException();
    }

    public int read(byte[] bArr, int i11, int i12) throws IOException {
        if (a()) {
            return -1;
        }
        int read = this.f27916a.get(this.f27917b).read(bArr, i11, i12);
        while (read < 0) {
            int i13 = this.f27917b + 1;
            this.f27917b = i13;
            if (i13 >= this.f27916a.size()) {
                break;
            }
            read = this.f27916a.get(this.f27917b).read(bArr, i11, i12);
        }
        return read;
    }
}
