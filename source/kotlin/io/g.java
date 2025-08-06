package kotlin.io;

import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

public final class g {
    public static final long a(Reader reader, Writer writer, int i11) {
        char[] cArr = new char[i11];
        int read = reader.read(cArr);
        long j11 = 0;
        while (read >= 0) {
            writer.write(cArr, 0, read);
            j11 += (long) read;
            read = reader.read(cArr);
        }
        return j11;
    }

    public static /* synthetic */ long b(Reader reader, Writer writer, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = 8192;
        }
        return a(reader, writer, i11);
    }

    public static final String c(Reader reader) {
        StringWriter stringWriter = new StringWriter();
        b(reader, stringWriter, 0, 2, (Object) null);
        return stringWriter.toString();
    }
}
