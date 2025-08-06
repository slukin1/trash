package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Ascii;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.hash.Funnels;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hasher;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

@GwtIncompatible
public abstract class ByteSource {

    public class AsCharSource extends CharSource {
        public final Charset charset;

        public AsCharSource(Charset charset2) {
            this.charset = (Charset) Preconditions.checkNotNull(charset2);
        }

        public ByteSource asByteSource(Charset charset2) {
            if (charset2.equals(this.charset)) {
                return ByteSource.this;
            }
            return super.asByteSource(charset2);
        }

        public Reader openStream() throws IOException {
            return new InputStreamReader(ByteSource.this.openStream(), this.charset);
        }

        public String read() throws IOException {
            return new String(ByteSource.this.read(), this.charset);
        }

        public String toString() {
            return ByteSource.this.toString() + ".asCharSource(" + this.charset + ")";
        }
    }

    public static class ByteArrayByteSource extends ByteSource {
        public final byte[] bytes;
        public final int length;
        public final int offset;

        public ByteArrayByteSource(byte[] bArr) {
            this(bArr, 0, bArr.length);
        }

        public long copyTo(OutputStream outputStream) throws IOException {
            outputStream.write(this.bytes, this.offset, this.length);
            return (long) this.length;
        }

        public HashCode hash(HashFunction hashFunction) throws IOException {
            return hashFunction.hashBytes(this.bytes, this.offset, this.length);
        }

        public boolean isEmpty() {
            return this.length == 0;
        }

        public InputStream openBufferedStream() throws IOException {
            return openStream();
        }

        public InputStream openStream() {
            return new ByteArrayInputStream(this.bytes, this.offset, this.length);
        }

        public byte[] read() {
            byte[] bArr = this.bytes;
            int i11 = this.offset;
            return Arrays.copyOfRange(bArr, i11, this.length + i11);
        }

        public long size() {
            return (long) this.length;
        }

        public Optional<Long> sizeIfKnown() {
            return Optional.of(Long.valueOf((long) this.length));
        }

        public ByteSource slice(long j11, long j12) {
            boolean z11 = true;
            Preconditions.checkArgument(j11 >= 0, "offset (%s) may not be negative", j11);
            if (j12 < 0) {
                z11 = false;
            }
            Preconditions.checkArgument(z11, "length (%s) may not be negative", j12);
            long min = Math.min(j11, (long) this.length);
            return new ByteArrayByteSource(this.bytes, this.offset + ((int) min), (int) Math.min(j12, ((long) this.length) - min));
        }

        public String toString() {
            return "ByteSource.wrap(" + Ascii.truncate(BaseEncoding.base16().encode(this.bytes, this.offset, this.length), 30, "...") + ")";
        }

        public ByteArrayByteSource(byte[] bArr, int i11, int i12) {
            this.bytes = bArr;
            this.offset = i11;
            this.length = i12;
        }

        public <T> T read(ByteProcessor<T> byteProcessor) throws IOException {
            byteProcessor.processBytes(this.bytes, this.offset, this.length);
            return byteProcessor.getResult();
        }
    }

    public static final class ConcatenatedByteSource extends ByteSource {
        public final Iterable<? extends ByteSource> sources;

        public ConcatenatedByteSource(Iterable<? extends ByteSource> iterable) {
            this.sources = (Iterable) Preconditions.checkNotNull(iterable);
        }

        public boolean isEmpty() throws IOException {
            for (ByteSource isEmpty : this.sources) {
                if (!isEmpty.isEmpty()) {
                    return false;
                }
            }
            return true;
        }

        public InputStream openStream() throws IOException {
            return new MultiInputStream(this.sources.iterator());
        }

        public long size() throws IOException {
            long j11 = 0;
            for (ByteSource size : this.sources) {
                j11 += size.size();
                if (j11 < 0) {
                    return Long.MAX_VALUE;
                }
            }
            return j11;
        }

        public Optional<Long> sizeIfKnown() {
            Iterable<? extends ByteSource> iterable = this.sources;
            if (!(iterable instanceof Collection)) {
                return Optional.absent();
            }
            long j11 = 0;
            for (ByteSource sizeIfKnown : iterable) {
                Optional<Long> sizeIfKnown2 = sizeIfKnown.sizeIfKnown();
                if (!sizeIfKnown2.isPresent()) {
                    return Optional.absent();
                }
                j11 += sizeIfKnown2.get().longValue();
                if (j11 < 0) {
                    return Optional.of(Long.MAX_VALUE);
                }
            }
            return Optional.of(Long.valueOf(j11));
        }

        public String toString() {
            return "ByteSource.concat(" + this.sources + ")";
        }
    }

    public static final class EmptyByteSource extends ByteArrayByteSource {
        public static final EmptyByteSource INSTANCE = new EmptyByteSource();

        public EmptyByteSource() {
            super(new byte[0]);
        }

        public CharSource asCharSource(Charset charset) {
            Preconditions.checkNotNull(charset);
            return CharSource.empty();
        }

        public byte[] read() {
            return this.bytes;
        }

        public String toString() {
            return "ByteSource.empty()";
        }
    }

    public final class SlicedByteSource extends ByteSource {
        public final long length;
        public final long offset;

        public SlicedByteSource(long j11, long j12) {
            boolean z11 = true;
            Preconditions.checkArgument(j11 >= 0, "offset (%s) may not be negative", j11);
            Preconditions.checkArgument(j12 < 0 ? false : z11, "length (%s) may not be negative", j12);
            this.offset = j11;
            this.length = j12;
        }

        private InputStream sliceStream(InputStream inputStream) throws IOException {
            Closer create;
            long j11 = this.offset;
            if (j11 > 0) {
                try {
                    if (ByteStreams.skipUpTo(inputStream, j11) < this.offset) {
                        inputStream.close();
                        return new ByteArrayInputStream(new byte[0]);
                    }
                } catch (Throwable th2) {
                    create.close();
                    throw th2;
                }
            }
            return ByteStreams.limit(inputStream, this.length);
        }

        public boolean isEmpty() throws IOException {
            return this.length == 0 || ByteSource.super.isEmpty();
        }

        public InputStream openBufferedStream() throws IOException {
            return sliceStream(ByteSource.this.openBufferedStream());
        }

        public InputStream openStream() throws IOException {
            return sliceStream(ByteSource.this.openStream());
        }

        public Optional<Long> sizeIfKnown() {
            Optional<Long> sizeIfKnown = ByteSource.this.sizeIfKnown();
            if (!sizeIfKnown.isPresent()) {
                return Optional.absent();
            }
            long longValue = sizeIfKnown.get().longValue();
            return Optional.of(Long.valueOf(Math.min(this.length, longValue - Math.min(this.offset, longValue))));
        }

        public ByteSource slice(long j11, long j12) {
            boolean z11 = true;
            Preconditions.checkArgument(j11 >= 0, "offset (%s) may not be negative", j11);
            if (j12 < 0) {
                z11 = false;
            }
            Preconditions.checkArgument(z11, "length (%s) may not be negative", j12);
            return ByteSource.this.slice(this.offset + j11, Math.min(j12, this.length - j11));
        }

        public String toString() {
            return ByteSource.this.toString() + ".slice(" + this.offset + ", " + this.length + ")";
        }
    }

    public static ByteSource concat(Iterable<? extends ByteSource> iterable) {
        return new ConcatenatedByteSource(iterable);
    }

    private long countBySkipping(InputStream inputStream) throws IOException {
        long j11 = 0;
        while (true) {
            long skipUpTo = ByteStreams.skipUpTo(inputStream, 2147483647L);
            if (skipUpTo <= 0) {
                return j11;
            }
            j11 += skipUpTo;
        }
    }

    public static ByteSource empty() {
        return EmptyByteSource.INSTANCE;
    }

    public static ByteSource wrap(byte[] bArr) {
        return new ByteArrayByteSource(bArr);
    }

    public CharSource asCharSource(Charset charset) {
        return new AsCharSource(charset);
    }

    public boolean contentEquals(ByteSource byteSource) throws IOException {
        int read;
        Preconditions.checkNotNull(byteSource);
        byte[] createBuffer = ByteStreams.createBuffer();
        byte[] createBuffer2 = ByteStreams.createBuffer();
        Closer create = Closer.create();
        try {
            InputStream inputStream = (InputStream) create.register(openStream());
            InputStream inputStream2 = (InputStream) create.register(byteSource.openStream());
            do {
                read = ByteStreams.read(inputStream, createBuffer, 0, createBuffer.length);
                if (read == ByteStreams.read(inputStream2, createBuffer2, 0, createBuffer2.length)) {
                    if (!Arrays.equals(createBuffer, createBuffer2)) {
                    }
                }
                create.close();
                return false;
            } while (read == createBuffer.length);
            create.close();
            return true;
        } catch (Throwable th2) {
            create.close();
            throw th2;
        }
    }

    @CanIgnoreReturnValue
    public long copyTo(OutputStream outputStream) throws IOException {
        Preconditions.checkNotNull(outputStream);
        Closer create = Closer.create();
        try {
            long copy = ByteStreams.copy((InputStream) create.register(openStream()), outputStream);
            create.close();
            return copy;
        } catch (Throwable th2) {
            create.close();
            throw th2;
        }
    }

    public HashCode hash(HashFunction hashFunction) throws IOException {
        Hasher newHasher = hashFunction.newHasher();
        copyTo(Funnels.asOutputStream(newHasher));
        return newHasher.hash();
    }

    public boolean isEmpty() throws IOException {
        Optional<Long> sizeIfKnown = sizeIfKnown();
        boolean z11 = true;
        if (!sizeIfKnown.isPresent()) {
            Closer create = Closer.create();
            try {
                if (((InputStream) create.register(openStream())).read() != -1) {
                    z11 = false;
                }
                create.close();
                return z11;
            } catch (Throwable th2) {
                create.close();
                throw th2;
            }
        } else if (sizeIfKnown.get().longValue() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public InputStream openBufferedStream() throws IOException {
        InputStream openStream = openStream();
        return openStream instanceof BufferedInputStream ? (BufferedInputStream) openStream : new BufferedInputStream(openStream);
    }

    public abstract InputStream openStream() throws IOException;

    public byte[] read() throws IOException {
        byte[] bArr;
        Closer create = Closer.create();
        try {
            InputStream inputStream = (InputStream) create.register(openStream());
            Optional<Long> sizeIfKnown = sizeIfKnown();
            if (sizeIfKnown.isPresent()) {
                bArr = ByteStreams.toByteArray(inputStream, sizeIfKnown.get().longValue());
            } else {
                bArr = ByteStreams.toByteArray(inputStream);
            }
            create.close();
            return bArr;
        } catch (Throwable th2) {
            create.close();
            throw th2;
        }
    }

    public long size() throws IOException {
        Closer create;
        Optional<Long> sizeIfKnown = sizeIfKnown();
        if (sizeIfKnown.isPresent()) {
            return sizeIfKnown.get().longValue();
        }
        Closer create2 = Closer.create();
        try {
            long countBySkipping = countBySkipping((InputStream) create2.register(openStream()));
            create2.close();
            return countBySkipping;
        } catch (IOException unused) {
            create2.close();
            create = Closer.create();
            long exhaust = ByteStreams.exhaust((InputStream) create.register(openStream()));
            create.close();
            return exhaust;
        } catch (Throwable th2) {
            try {
                throw create.rethrow(th2);
            } catch (Throwable th3) {
                create.close();
                throw th3;
            }
        }
    }

    @Beta
    public Optional<Long> sizeIfKnown() {
        return Optional.absent();
    }

    public ByteSource slice(long j11, long j12) {
        return new SlicedByteSource(j11, j12);
    }

    public static ByteSource concat(Iterator<? extends ByteSource> it2) {
        return concat((Iterable<? extends ByteSource>) ImmutableList.copyOf(it2));
    }

    public static ByteSource concat(ByteSource... byteSourceArr) {
        return concat((Iterable<? extends ByteSource>) ImmutableList.copyOf((E[]) byteSourceArr));
    }

    @CanIgnoreReturnValue
    public long copyTo(ByteSink byteSink) throws IOException {
        Preconditions.checkNotNull(byteSink);
        Closer create = Closer.create();
        try {
            long copy = ByteStreams.copy((InputStream) create.register(openStream()), (OutputStream) create.register(byteSink.openStream()));
            create.close();
            return copy;
        } catch (Throwable th2) {
            create.close();
            throw th2;
        }
    }

    @CanIgnoreReturnValue
    @Beta
    public <T> T read(ByteProcessor<T> byteProcessor) throws IOException {
        Preconditions.checkNotNull(byteProcessor);
        Closer create = Closer.create();
        try {
            T readBytes = ByteStreams.readBytes((InputStream) create.register(openStream()), byteProcessor);
            create.close();
            return readBytes;
        } catch (Throwable th2) {
            create.close();
            throw th2;
        }
    }
}
