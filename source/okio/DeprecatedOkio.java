package okio;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.Arrays;

/* renamed from: okio.-DeprecatedOkio  reason: invalid class name */
public final class DeprecatedOkio {
    public static final DeprecatedOkio INSTANCE = new DeprecatedOkio();

    private DeprecatedOkio() {
    }

    public final Sink appendingSink(File file) {
        return Okio.appendingSink(file);
    }

    public final Sink blackhole() {
        return Okio.blackhole();
    }

    public final BufferedSink buffer(Sink sink) {
        return Okio.buffer(sink);
    }

    public final Sink sink(File file) {
        return Okio__JvmOkioKt.sink$default(file, false, 1, (Object) null);
    }

    public final Source source(File file) {
        return Okio.source(file);
    }

    public final BufferedSource buffer(Source source) {
        return Okio.buffer(source);
    }

    public final Sink sink(OutputStream outputStream) {
        return Okio.sink(outputStream);
    }

    public final Source source(InputStream inputStream) {
        return Okio.source(inputStream);
    }

    public final Sink sink(Path path, OpenOption... openOptionArr) {
        return Okio.sink(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
    }

    public final Source source(Path path, OpenOption... openOptionArr) {
        return Okio.source(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
    }

    public final Sink sink(Socket socket) {
        return Okio.sink(socket);
    }

    public final Source source(Socket socket) {
        return Okio.source(socket);
    }
}
