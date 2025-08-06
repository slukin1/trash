package com.mob.tools.network;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class FilePart extends HTTPPart {

    /* renamed from: a  reason: collision with root package name */
    private File f27910a;

    public InputStream a() throws Throwable {
        return new FileInputStream(this.f27910a);
    }

    public long b() throws Throwable {
        return this.f27910a.length();
    }

    public void setFile(File file) {
        this.f27910a = file;
    }

    public String toString() {
        return this.f27910a.toString();
    }

    public void setFile(String str) {
        this.f27910a = new File(str);
    }
}
