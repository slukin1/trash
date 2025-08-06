package okio;

import d10.l;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import kotlin.jvm.internal.r;
import okio.internal.ResourceFileSystem;
import okio.internal.ZipFilesKt;

final /* synthetic */ class Okio__JvmOkioKt {
    /* access modifiers changed from: private */
    public static final Logger logger = Logger.getLogger("okio.Okio");

    public static final Sink appendingSink(File file) throws FileNotFoundException {
        return Okio.sink((OutputStream) new FileOutputStream(file, true));
    }

    public static final FileSystem asResourceFileSystem(ClassLoader classLoader) {
        return new ResourceFileSystem(classLoader, true, (FileSystem) null, 4, (r) null);
    }

    public static final CipherSink cipherSink(Sink sink, Cipher cipher) {
        return new CipherSink(Okio.buffer(sink), cipher);
    }

    public static final CipherSource cipherSource(Source source, Cipher cipher) {
        return new CipherSource(Okio.buffer(source), cipher);
    }

    public static final HashingSink hashingSink(Sink sink, Mac mac) {
        return new HashingSink(sink, mac);
    }

    public static final HashingSource hashingSource(Source source, Mac mac) {
        return new HashingSource(source, mac);
    }

    public static final boolean isAndroidGetsocknameError(AssertionError assertionError) {
        if (assertionError.getCause() == null) {
            return false;
        }
        String message = assertionError.getMessage();
        return message != null ? StringsKt__StringsKt.R(message, "getsockname failed", false, 2, (Object) null) : false;
    }

    public static final FileSystem openZip(FileSystem fileSystem, Path path) throws IOException {
        return ZipFilesKt.openZip$default(path, fileSystem, (l) null, 4, (Object) null);
    }

    public static final Sink sink(File file) throws FileNotFoundException {
        return sink$default(file, false, 1, (Object) null);
    }

    public static final Sink sink(OutputStream outputStream) {
        return new OutputStreamSink(outputStream, new Timeout());
    }

    public static /* synthetic */ Sink sink$default(File file, boolean z11, int i11, Object obj) throws FileNotFoundException {
        if ((i11 & 1) != 0) {
            z11 = false;
        }
        return Okio.sink(file, z11);
    }

    public static final Source source(InputStream inputStream) {
        return new InputStreamSource(inputStream, new Timeout());
    }

    public static final HashingSink hashingSink(Sink sink, MessageDigest messageDigest) {
        return new HashingSink(sink, messageDigest);
    }

    public static final HashingSource hashingSource(Source source, MessageDigest messageDigest) {
        return new HashingSource(source, messageDigest);
    }

    public static final Sink sink(Socket socket) throws IOException {
        SocketAsyncTimeout socketAsyncTimeout = new SocketAsyncTimeout(socket);
        return socketAsyncTimeout.sink(new OutputStreamSink(socket.getOutputStream(), socketAsyncTimeout));
    }

    public static final Source source(Socket socket) throws IOException {
        SocketAsyncTimeout socketAsyncTimeout = new SocketAsyncTimeout(socket);
        return socketAsyncTimeout.source(new InputStreamSource(socket.getInputStream(), socketAsyncTimeout));
    }

    public static final Sink sink(File file, boolean z11) throws FileNotFoundException {
        return Okio.sink((OutputStream) new FileOutputStream(file, z11));
    }

    public static final Source source(File file) throws FileNotFoundException {
        return new InputStreamSource(new FileInputStream(file), Timeout.NONE);
    }

    public static final Sink sink(Path path, OpenOption... openOptionArr) throws IOException {
        return Okio.sink(Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length)));
    }

    public static final Source source(Path path, OpenOption... openOptionArr) throws IOException {
        return Okio.source(Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length)));
    }
}
