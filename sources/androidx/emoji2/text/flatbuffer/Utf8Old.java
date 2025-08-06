package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;

public class Utf8Old extends Utf8 {

    /* renamed from: b  reason: collision with root package name */
    public static final ThreadLocal<a> f9474b = ThreadLocal.withInitial(c.f9479a);

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final CharsetEncoder f9475a = StandardCharsets.UTF_8.newEncoder();

        /* renamed from: b  reason: collision with root package name */
        public final CharsetDecoder f9476b = StandardCharsets.UTF_8.newDecoder();

        /* renamed from: c  reason: collision with root package name */
        public CharSequence f9477c = null;

        /* renamed from: d  reason: collision with root package name */
        public ByteBuffer f9478d = null;
    }

    public static /* synthetic */ a c() {
        return new a();
    }
}
