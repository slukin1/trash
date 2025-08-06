package com.facebook.stetho.dumpapp;

import com.facebook.stetho.common.LogUtil;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.charset.Charset;

class Framer {
    public static final byte ENTER_FRAME_PREFIX = 33;
    public static final byte EXIT_FRAME_PREFIX = 120;
    public static final byte STDERR_FRAME_PREFIX = 50;
    public static final byte STDIN_FRAME_PREFIX = 45;
    public static final byte STDIN_REQUEST_FRAME_PREFIX = 95;
    public static final byte STDOUT_FRAME_PREFIX = 49;
    private static final String TAG = "FramingSocket";
    /* access modifiers changed from: private */
    public final DataInputStream mInput;
    /* access modifiers changed from: private */
    public final DataOutputStream mMultiplexedOutputStream;
    private final PrintStream mStderr = new PrintStream(new FramingOutputStream((byte) 50));
    private final InputStream mStdin = new FramingInputStream();
    private final PrintStream mStdout = new PrintStream(new BufferedOutputStream(new FramingOutputStream(STDOUT_FRAME_PREFIX)));

    public static class ClosedHelper {
        private volatile boolean mClosed;

        private ClosedHelper() {
        }

        public void close() {
            this.mClosed = true;
        }

        public void throwIfClosed() throws IOException {
            if (this.mClosed) {
                throw new IOException("Stream is closed");
            }
        }
    }

    public Framer(InputStream inputStream, OutputStream outputStream) throws IOException {
        this.mInput = new DataInputStream(inputStream);
        this.mMultiplexedOutputStream = new DataOutputStream(outputStream);
    }

    private static <T extends Throwable> T handleSuppression(T t11, T t12) {
        if (t11 == null) {
            return t12;
        }
        LogUtil.i(TAG, t12, "Suppressed while handling " + t11);
        return t11;
    }

    public PrintStream getStderr() {
        return this.mStderr;
    }

    public InputStream getStdin() {
        return this.mStdin;
    }

    public PrintStream getStdout() {
        return this.mStdout;
    }

    public byte readFrameType() throws IOException {
        return this.mInput.readByte();
    }

    public int readInt() throws IOException {
        return this.mInput.readInt();
    }

    public String readString() throws IOException {
        byte[] bArr = new byte[this.mInput.readUnsignedShort()];
        this.mInput.readFully(bArr);
        return new String(bArr, Charset.forName("UTF-8"));
    }

    public void writeBlob(byte[] bArr, int i11, int i12) throws IOException {
        this.mMultiplexedOutputStream.write(bArr, i11, i12);
    }

    public void writeExitCode(int i11) throws IOException {
        this.mStdout.flush();
        this.mStderr.flush();
        writeIntFrame(EXIT_FRAME_PREFIX, i11);
    }

    public void writeIntFrame(byte b11, int i11) throws IOException {
        this.mMultiplexedOutputStream.write(b11);
        this.mMultiplexedOutputStream.writeInt(i11);
    }

    public class FramingInputStream extends InputStream {
        private final ClosedHelper mClosedHelper;

        private FramingInputStream() {
            this.mClosedHelper = new ClosedHelper();
        }

        public void close() throws IOException {
            this.mClosedHelper.close();
        }

        public int read() throws IOException {
            byte[] bArr = new byte[1];
            if (read(bArr) == 0) {
                return -1;
            }
            return bArr[0];
        }

        public long skip(long j11) throws IOException {
            long j12;
            byte[] bArr = new byte[((int) Math.min(j11, 2048))];
            synchronized (Framer.this) {
                j12 = 0;
                while (true) {
                    if (j12 >= j11) {
                        break;
                    }
                    int read = read(bArr);
                    if (read < 0) {
                        break;
                    }
                    j12 += (long) read;
                }
            }
            return j12;
        }

        public int read(byte[] bArr) throws IOException {
            return read(bArr, 0, bArr.length);
        }

        public int read(byte[] bArr, int i11, int i12) throws IOException {
            int readInt;
            this.mClosedHelper.throwIfClosed();
            synchronized (Framer.this) {
                Framer.this.writeIntFrame((byte) 95, i12);
                byte readFrameType = Framer.this.readFrameType();
                if (readFrameType == 45) {
                    readInt = Framer.this.readInt();
                    if (readInt > 0) {
                        if (readInt <= i12) {
                            Framer.this.mInput.readFully(bArr, i11, readInt);
                        } else {
                            throw new DumpappFramingException("Expected at most " + i12 + " bytes, got: " + readInt);
                        }
                    }
                } else {
                    throw new UnexpectedFrameException(Framer.STDIN_FRAME_PREFIX, readFrameType);
                }
            }
            return readInt;
        }
    }

    public class FramingOutputStream extends OutputStream {
        private final ClosedHelper mClosedHelper = new ClosedHelper();
        private final byte mPrefix;

        public FramingOutputStream(byte b11) {
            this.mPrefix = b11;
        }

        public void close() throws IOException {
            this.mClosedHelper.close();
        }

        public void write(byte[] bArr, int i11, int i12) throws IOException {
            this.mClosedHelper.throwIfClosed();
            if (i12 > 0) {
                try {
                    synchronized (Framer.this) {
                        Framer.this.writeIntFrame(this.mPrefix, i12);
                        Framer.this.writeBlob(bArr, i11, i12);
                        Framer.this.mMultiplexedOutputStream.flush();
                    }
                } catch (IOException e11) {
                    throw new DumpappOutputBrokenException((Throwable) e11);
                }
            }
        }

        public void write(int i11) throws IOException {
            write(new byte[]{(byte) i11}, 0, 1);
        }

        public void write(byte[] bArr) throws IOException {
            write(bArr, 0, bArr.length);
        }
    }
}
