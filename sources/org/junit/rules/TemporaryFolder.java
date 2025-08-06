package org.junit.rules;

import java.io.File;
import java.io.IOException;

public class TemporaryFolder extends ExternalResource {

    /* renamed from: a  reason: collision with root package name */
    public final File f25449a;

    /* renamed from: b  reason: collision with root package name */
    public File f25450b;

    public TemporaryFolder() {
        this((File) null);
    }

    public void b() {
        g();
    }

    public void c() throws Throwable {
        e();
    }

    public void e() throws IOException {
        this.f25450b = f(this.f25449a);
    }

    public final File f(File file) throws IOException {
        File createTempFile = File.createTempFile("junit", "", file);
        createTempFile.delete();
        createTempFile.mkdir();
        return createTempFile;
    }

    public void g() {
        File file = this.f25450b;
        if (file != null) {
            h(file);
        }
    }

    public final void h(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File h11 : listFiles) {
                h(h11);
            }
        }
        file.delete();
    }

    public TemporaryFolder(File file) {
        this.f25449a = file;
    }
}
