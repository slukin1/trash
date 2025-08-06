package com.mob.tools.network;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class MultiPart extends HTTPPart {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<HTTPPart> f27915a = new ArrayList<>();

    public InputStream a() throws Throwable {
        MultiPartInputStream multiPartInputStream = new MultiPartInputStream();
        Iterator<HTTPPart> it2 = this.f27915a.iterator();
        while (it2.hasNext()) {
            multiPartInputStream.addInputStream(it2.next().a());
        }
        return multiPartInputStream;
    }

    public MultiPart append(HTTPPart hTTPPart) throws Throwable {
        this.f27915a.add(hTTPPart);
        return this;
    }

    public long b() throws Throwable {
        Iterator<HTTPPart> it2 = this.f27915a.iterator();
        long j11 = 0;
        while (it2.hasNext()) {
            j11 += it2.next().b();
        }
        return j11;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        Iterator<HTTPPart> it2 = this.f27915a.iterator();
        while (it2.hasNext()) {
            sb2.append(it2.next().toString());
        }
        return sb2.toString();
    }
}
