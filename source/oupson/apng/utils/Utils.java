package oupson.apng.utils;

import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.i;
import kotlin.jvm.internal.r;

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u0000 \u00042\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Loupson/apng/utils/Utils;", "", "<init>", "()V", "j", "Companion", "apng_library_release"}, k = 1, mv = {1, 4, 2})
public final class Utils {

    /* renamed from: a  reason: collision with root package name */
    public static final i f52972a = LazyKt__LazyJVMKt.a(Utils$Companion$pngSignature$2.INSTANCE);

    /* renamed from: b  reason: collision with root package name */
    public static final i f52973b = LazyKt__LazyJVMKt.a(Utils$Companion$fcTL$2.INSTANCE);

    /* renamed from: c  reason: collision with root package name */
    public static final i f52974c = LazyKt__LazyJVMKt.a(Utils$Companion$IEND$2.INSTANCE);

    /* renamed from: d  reason: collision with root package name */
    public static final i f52975d = LazyKt__LazyJVMKt.a(Utils$Companion$IDAT$2.INSTANCE);

    /* renamed from: e  reason: collision with root package name */
    public static final i f52976e = LazyKt__LazyJVMKt.a(Utils$Companion$fdAT$2.INSTANCE);

    /* renamed from: f  reason: collision with root package name */
    public static final i f52977f = LazyKt__LazyJVMKt.a(Utils$Companion$plte$2.INSTANCE);

    /* renamed from: g  reason: collision with root package name */
    public static final i f52978g = LazyKt__LazyJVMKt.a(Utils$Companion$tnrs$2.INSTANCE);

    /* renamed from: h  reason: collision with root package name */
    public static final i f52979h = LazyKt__LazyJVMKt.a(Utils$Companion$IHDR$2.INSTANCE);

    /* renamed from: i  reason: collision with root package name */
    public static final i f52980i = LazyKt__LazyJVMKt.a(Utils$Companion$acTL$2.INSTANCE);

    /* renamed from: j  reason: collision with root package name */
    public static final Companion f52981j = new Companion((r) null);

    @Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b$\b\u0003\u0018\u00002\u00020\u0001:\u000212B\t\b\u0002¢\u0006\u0004\b/\u00100J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0007J\u0014\u0010\u0011\u001a\u00020\u00072\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u000fJ\u0014\u0010\u0012\u001a\u00020\u00072\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u000fR\u001b\u0010\u0017\u001a\u00020\u00028FX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001a\u001a\u00020\u00028FX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0019\u0010\u0016R\u001b\u0010\u001d\u001a\u00020\u00028FX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u001c\u0010\u0016R\u001b\u0010 \u001a\u00020\u00028FX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001f\u0010\u0016R\u001b\u0010#\u001a\u00020\u00028FX\u0002¢\u0006\f\n\u0004\b!\u0010\u0014\u001a\u0004\b\"\u0010\u0016R\u001b\u0010%\u001a\u00020\u00028FX\u0002¢\u0006\f\n\u0004\b$\u0010\u0014\u001a\u0004\b\r\u0010\u0016R\u001b\u0010(\u001a\u00020\u00028FX\u0002¢\u0006\f\n\u0004\b&\u0010\u0014\u001a\u0004\b'\u0010\u0016R\u001b\u0010+\u001a\u00020\u00028FX\u0002¢\u0006\f\n\u0004\b)\u0010\u0014\u001a\u0004\b*\u0010\u0016R\u001b\u0010.\u001a\u00020\u00028FX\u0002¢\u0006\f\n\u0004\b,\u0010\u0014\u001a\u0004\b-\u0010\u0016¨\u00063"}, d2 = {"Loupson/apng/utils/Utils$Companion;", "", "", "byteArray", "", "m", "l", "", "int", "Loupson/apng/utils/Utils$Companion$DisposeOp;", "b", "Loupson/apng/utils/Utils$Companion$BlendOp;", "a", "i", "o", "", "bytes", "n", "p", "pngSignature$delegate", "Lkotlin/i;", "j", "()[B", "pngSignature", "fcTL$delegate", "d", "fcTL", "IEND$delegate", "g", "IEND", "IDAT$delegate", "f", "IDAT", "fdAT$delegate", "e", "fdAT", "plte$delegate", "plte", "tnrs$delegate", "k", "tnrs", "IHDR$delegate", "h", "IHDR", "acTL$delegate", "c", "acTL", "<init>", "()V", "BlendOp", "DisposeOp", "apng_library_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Loupson/apng/utils/Utils$Companion$BlendOp;", "", "(Ljava/lang/String;I)V", "APNG_BLEND_OP_SOURCE", "APNG_BLEND_OP_OVER", "apng_library_release"}, k = 1, mv = {1, 4, 2})
        public enum BlendOp {
            APNG_BLEND_OP_SOURCE,
            APNG_BLEND_OP_OVER
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Loupson/apng/utils/Utils$Companion$DisposeOp;", "", "(Ljava/lang/String;I)V", "APNG_DISPOSE_OP_NONE", "APNG_DISPOSE_OP_BACKGROUND", "APNG_DISPOSE_OP_PREVIOUS", "apng_library_release"}, k = 1, mv = {1, 4, 2})
        public enum DisposeOp {
            APNG_DISPOSE_OP_NONE,
            APNG_DISPOSE_OP_BACKGROUND,
            APNG_DISPOSE_OP_PREVIOUS
        }

        public Companion() {
        }

        public final BlendOp a(int i11) {
            if (i11 == 0) {
                return BlendOp.APNG_BLEND_OP_SOURCE;
            }
            if (i11 != 1) {
                return BlendOp.APNG_BLEND_OP_SOURCE;
            }
            return BlendOp.APNG_BLEND_OP_OVER;
        }

        public final DisposeOp b(int i11) {
            if (i11 == 0) {
                return DisposeOp.APNG_DISPOSE_OP_NONE;
            }
            if (i11 == 1) {
                return DisposeOp.APNG_DISPOSE_OP_BACKGROUND;
            }
            if (i11 != 2) {
                return DisposeOp.APNG_DISPOSE_OP_NONE;
            }
            return DisposeOp.APNG_DISPOSE_OP_PREVIOUS;
        }

        public final byte[] c() {
            i a11 = Utils.f52980i;
            Companion companion = Utils.f52981j;
            return (byte[]) a11.getValue();
        }

        public final byte[] d() {
            i b11 = Utils.f52973b;
            Companion companion = Utils.f52981j;
            return (byte[]) b11.getValue();
        }

        public final byte[] e() {
            i c11 = Utils.f52976e;
            Companion companion = Utils.f52981j;
            return (byte[]) c11.getValue();
        }

        public final byte[] f() {
            i d11 = Utils.f52975d;
            Companion companion = Utils.f52981j;
            return (byte[]) d11.getValue();
        }

        public final byte[] g() {
            i e11 = Utils.f52974c;
            Companion companion = Utils.f52981j;
            return (byte[]) e11.getValue();
        }

        public final byte[] h() {
            i f11 = Utils.f52979h;
            Companion companion = Utils.f52981j;
            return (byte[]) f11.getValue();
        }

        public final byte[] i() {
            i g11 = Utils.f52977f;
            Companion companion = Utils.f52981j;
            return (byte[]) g11.getValue();
        }

        public final byte[] j() {
            i h11 = Utils.f52972a;
            Companion companion = Utils.f52981j;
            return (byte[]) h11.getValue();
        }

        public final byte[] k() {
            i i11 = Utils.f52978g;
            Companion companion = Utils.f52981j;
            return (byte[]) i11.getValue();
        }

        public final boolean l(byte[] bArr) {
            if (!m(bArr)) {
                return false;
            }
            try {
                int length = bArr.length;
                for (int i11 = 8; i11 < length; i11++) {
                    byte[] i12 = ArraysKt___ArraysJvmKt.i(bArr, i11, i11 + 4);
                    if (Arrays.equals(i12, c())) {
                        return true;
                    }
                    if (Arrays.equals(i12, f())) {
                        return false;
                    }
                }
            } catch (Exception unused) {
            }
            return false;
        }

        public final boolean m(byte[] bArr) {
            if (bArr.length == 8) {
                return Arrays.equals(bArr, j());
            }
            return Arrays.equals(ArraysKt___ArraysJvmKt.i(bArr, 0, 8), j());
        }

        public final int n(List<Integer> list) {
            return (list.get(3).intValue() & 255) | ((list.get(0).intValue() & 255) << 24) | ((list.get(1).intValue() & 255) << 16) | ((list.get(2).intValue() & 255) << 8);
        }

        public final byte[] o(int i11) {
            return new byte[]{(byte) (i11 >> 24), (byte) (i11 >> 16), (byte) (i11 >> 8), (byte) i11};
        }

        public final int p(List<Integer> list) {
            return (list.get(1).intValue() & 255) | ((list.get(0).intValue() & 255) << 8);
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }
    }
}
