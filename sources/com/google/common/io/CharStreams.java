package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;

@GwtIncompatible
public final class CharStreams {
    private static final int DEFAULT_BUF_SIZE = 2048;

    public static final class NullWriter extends Writer {
        /* access modifiers changed from: private */
        public static final NullWriter INSTANCE = new NullWriter();

        private NullWriter() {
        }

        public Writer append(char c11) {
            return this;
        }

        public void close() {
        }

        public void flush() {
        }

        public String toString() {
            return "CharStreams.nullWriter()";
        }

        public void write(int i11) {
        }

        public void write(char[] cArr) {
            Preconditions.checkNotNull(cArr);
        }

        public void write(char[] cArr, int i11, int i12) {
            Preconditions.checkPositionIndexes(i11, i12 + i11, cArr.length);
        }

        public void write(String str) {
            Preconditions.checkNotNull(str);
        }

        public Writer append(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            return this;
        }

        public void write(String str, int i11, int i12) {
            Preconditions.checkPositionIndexes(i11, i12 + i11, str.length());
        }

        public Writer append(CharSequence charSequence, int i11, int i12) {
            Preconditions.checkPositionIndexes(i11, i12, charSequence.length());
            return this;
        }
    }

    private CharStreams() {
    }

    @Beta
    public static Writer asWriter(Appendable appendable) {
        if (appendable instanceof Writer) {
            return (Writer) appendable;
        }
        return new AppendableWriter(appendable);
    }

    @CanIgnoreReturnValue
    public static long copy(Readable readable, Appendable appendable) throws IOException {
        if (!(readable instanceof Reader)) {
            Preconditions.checkNotNull(readable);
            Preconditions.checkNotNull(appendable);
            long j11 = 0;
            CharBuffer createBuffer = createBuffer();
            while (readable.read(createBuffer) != -1) {
                createBuffer.flip();
                appendable.append(createBuffer);
                j11 += (long) createBuffer.remaining();
                createBuffer.clear();
            }
            return j11;
        } else if (appendable instanceof StringBuilder) {
            return copyReaderToBuilder((Reader) readable, (StringBuilder) appendable);
        } else {
            return copyReaderToWriter((Reader) readable, asWriter(appendable));
        }
    }

    @CanIgnoreReturnValue
    public static long copyReaderToBuilder(Reader reader, StringBuilder sb2) throws IOException {
        Preconditions.checkNotNull(reader);
        Preconditions.checkNotNull(sb2);
        char[] cArr = new char[2048];
        long j11 = 0;
        while (true) {
            int read = reader.read(cArr);
            if (read == -1) {
                return j11;
            }
            sb2.append(cArr, 0, read);
            j11 += (long) read;
        }
    }

    @CanIgnoreReturnValue
    public static long copyReaderToWriter(Reader reader, Writer writer) throws IOException {
        Preconditions.checkNotNull(reader);
        Preconditions.checkNotNull(writer);
        char[] cArr = new char[2048];
        long j11 = 0;
        while (true) {
            int read = reader.read(cArr);
            if (read == -1) {
                return j11;
            }
            writer.write(cArr, 0, read);
            j11 += (long) read;
        }
    }

    public static CharBuffer createBuffer() {
        return CharBuffer.allocate(2048);
    }

    @CanIgnoreReturnValue
    @Beta
    public static long exhaust(Readable readable) throws IOException {
        CharBuffer createBuffer = createBuffer();
        long j11 = 0;
        while (true) {
            long read = (long) readable.read(createBuffer);
            if (read == -1) {
                return j11;
            }
            j11 += read;
            createBuffer.clear();
        }
    }

    @Beta
    public static Writer nullWriter() {
        return NullWriter.INSTANCE;
    }

    @Beta
    public static List<String> readLines(Readable readable) throws IOException {
        ArrayList arrayList = new ArrayList();
        LineReader lineReader = new LineReader(readable);
        while (true) {
            String readLine = lineReader.readLine();
            if (readLine == null) {
                return arrayList;
            }
            arrayList.add(readLine);
        }
    }

    @Beta
    public static void skipFully(Reader reader, long j11) throws IOException {
        Preconditions.checkNotNull(reader);
        while (j11 > 0) {
            long skip = reader.skip(j11);
            if (skip != 0) {
                j11 -= skip;
            } else {
                throw new EOFException();
            }
        }
    }

    public static String toString(Readable readable) throws IOException {
        return toStringBuilder(readable).toString();
    }

    private static StringBuilder toStringBuilder(Readable readable) throws IOException {
        StringBuilder sb2 = new StringBuilder();
        if (readable instanceof Reader) {
            copyReaderToBuilder((Reader) readable, sb2);
        } else {
            copy(readable, sb2);
        }
        return sb2;
    }

    @CanIgnoreReturnValue
    @Beta
    public static <T> T readLines(Readable readable, LineProcessor<T> lineProcessor) throws IOException {
        String readLine;
        Preconditions.checkNotNull(readable);
        Preconditions.checkNotNull(lineProcessor);
        LineReader lineReader = new LineReader(readable);
        do {
            readLine = lineReader.readLine();
            if (readLine == null || !lineProcessor.processLine(readLine)) {
            }
            readLine = lineReader.readLine();
            break;
        } while (!lineProcessor.processLine(readLine));
        return lineProcessor.getResult();
    }
}
