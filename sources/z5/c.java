package z5;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class c extends d {

    /* renamed from: c  reason: collision with root package name */
    public final File f66732c;

    public c(File file) throws IOException {
        super(new e(new FileInputStream(file)));
        this.f66732c = file;
    }

    public void reset() throws IOException {
        this.f66733b.close();
        this.f66733b = new e(new FileInputStream(this.f66732c));
    }
}
