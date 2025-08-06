package okhttp3;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import kotlin.jvm.internal.r;
import kotlin.text.b;
import okhttp3.MediaType;
import okhttp3.internal.Util;
import okio.BufferedSink;
import okio.ByteString;

public abstract class RequestBody {
    public static final Companion Companion = new Companion((r) null);

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, String str, MediaType mediaType, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(str, mediaType);
        }

        public final RequestBody create(String str, MediaType mediaType) {
            Charset charset = b.f56908b;
            if (mediaType != null) {
                Charset charset$default = MediaType.charset$default(mediaType, (Charset) null, 1, (Object) null);
                if (charset$default == null) {
                    MediaType.Companion companion = MediaType.Companion;
                    mediaType = companion.parse(mediaType + "; charset=utf-8");
                } else {
                    charset = charset$default;
                }
            }
            byte[] bytes = str.getBytes(charset);
            return create(bytes, mediaType, 0, bytes.length);
        }

        public final RequestBody create(MediaType mediaType, byte[] bArr) {
            return create$default(this, mediaType, bArr, 0, 0, 12, (Object) null);
        }

        public final RequestBody create(MediaType mediaType, byte[] bArr, int i11) {
            return create$default(this, mediaType, bArr, i11, 0, 8, (Object) null);
        }

        public final RequestBody create(byte[] bArr) {
            return create$default(this, bArr, (MediaType) null, 0, 0, 7, (Object) null);
        }

        public final RequestBody create(byte[] bArr, MediaType mediaType) {
            return create$default(this, bArr, mediaType, 0, 0, 6, (Object) null);
        }

        public final RequestBody create(byte[] bArr, MediaType mediaType, int i11) {
            return create$default(this, bArr, mediaType, i11, 0, 4, (Object) null);
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, ByteString byteString, MediaType mediaType, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(byteString, mediaType);
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, byte[] bArr, MediaType mediaType, int i11, int i12, int i13, Object obj) {
            if ((i13 & 1) != 0) {
                mediaType = null;
            }
            if ((i13 & 2) != 0) {
                i11 = 0;
            }
            if ((i13 & 4) != 0) {
                i12 = bArr.length;
            }
            return companion.create(bArr, mediaType, i11, i12);
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, File file, MediaType mediaType, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(file, mediaType);
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, MediaType mediaType, byte[] bArr, int i11, int i12, int i13, Object obj) {
            if ((i13 & 4) != 0) {
                i11 = 0;
            }
            if ((i13 & 8) != 0) {
                i12 = bArr.length;
            }
            return companion.create(mediaType, bArr, i11, i12);
        }

        public final RequestBody create(ByteString byteString, MediaType mediaType) {
            return new RequestBody$Companion$toRequestBody$1(mediaType, byteString);
        }

        public final RequestBody create(byte[] bArr, MediaType mediaType, int i11, int i12) {
            Util.checkOffsetAndCount((long) bArr.length, (long) i11, (long) i12);
            return new RequestBody$Companion$toRequestBody$2(mediaType, i12, bArr, i11);
        }

        public final RequestBody create(File file, MediaType mediaType) {
            return new RequestBody$Companion$asRequestBody$1(mediaType, file);
        }

        public final RequestBody create(MediaType mediaType, String str) {
            return create(str, mediaType);
        }

        public final RequestBody create(MediaType mediaType, ByteString byteString) {
            return create(byteString, mediaType);
        }

        public final RequestBody create(MediaType mediaType, byte[] bArr, int i11, int i12) {
            return create(bArr, mediaType, i11, i12);
        }

        public final RequestBody create(MediaType mediaType, File file) {
            return create(file, mediaType);
        }
    }

    public static final RequestBody create(File file, MediaType mediaType) {
        return Companion.create(file, mediaType);
    }

    public static final RequestBody create(String str, MediaType mediaType) {
        return Companion.create(str, mediaType);
    }

    public static final RequestBody create(MediaType mediaType, File file) {
        return Companion.create(mediaType, file);
    }

    public static final RequestBody create(MediaType mediaType, String str) {
        return Companion.create(mediaType, str);
    }

    public static final RequestBody create(MediaType mediaType, ByteString byteString) {
        return Companion.create(mediaType, byteString);
    }

    public static final RequestBody create(MediaType mediaType, byte[] bArr) {
        return Companion.create(mediaType, bArr);
    }

    public static final RequestBody create(MediaType mediaType, byte[] bArr, int i11) {
        return Companion.create(mediaType, bArr, i11);
    }

    public static final RequestBody create(MediaType mediaType, byte[] bArr, int i11, int i12) {
        return Companion.create(mediaType, bArr, i11, i12);
    }

    public static final RequestBody create(ByteString byteString, MediaType mediaType) {
        return Companion.create(byteString, mediaType);
    }

    public static final RequestBody create(byte[] bArr) {
        return Companion.create(bArr);
    }

    public static final RequestBody create(byte[] bArr, MediaType mediaType) {
        return Companion.create(bArr, mediaType);
    }

    public static final RequestBody create(byte[] bArr, MediaType mediaType, int i11) {
        return Companion.create(bArr, mediaType, i11);
    }

    public static final RequestBody create(byte[] bArr, MediaType mediaType, int i11, int i12) {
        return Companion.create(bArr, mediaType, i11, i12);
    }

    public long contentLength() throws IOException {
        return -1;
    }

    public abstract MediaType contentType();

    public boolean isDuplex() {
        return false;
    }

    public boolean isOneShot() {
        return false;
    }

    public abstract void writeTo(BufferedSink bufferedSink) throws IOException;
}
