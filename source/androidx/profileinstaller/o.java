package androidx.profileinstaller;

import java.util.Arrays;
import net.sf.scuba.smartcards.ISO7816;

public class o {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f10520a = {ISO7816.INS_DECREASE, Framer.STDOUT_FRAME_PREFIX, 53, 0};

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f10521b = {ISO7816.INS_DECREASE, Framer.STDOUT_FRAME_PREFIX, ISO7816.INS_DECREASE, 0};

    /* renamed from: c  reason: collision with root package name */
    public static final byte[] f10522c = {ISO7816.INS_DECREASE, ISO7816.INS_DECREASE, 57, 0};

    /* renamed from: d  reason: collision with root package name */
    public static final byte[] f10523d = {ISO7816.INS_DECREASE, ISO7816.INS_DECREASE, 53, 0};

    /* renamed from: e  reason: collision with root package name */
    public static final byte[] f10524e = {ISO7816.INS_DECREASE, ISO7816.INS_DECREASE, Framer.STDOUT_FRAME_PREFIX, 0};

    /* renamed from: f  reason: collision with root package name */
    public static final byte[] f10525f = {ISO7816.INS_DECREASE, ISO7816.INS_DECREASE, Framer.STDOUT_FRAME_PREFIX, 0};

    /* renamed from: g  reason: collision with root package name */
    public static final byte[] f10526g = {ISO7816.INS_DECREASE, ISO7816.INS_DECREASE, 50, 0};

    public static String a(byte[] bArr) {
        if (!Arrays.equals(bArr, f10524e) && !Arrays.equals(bArr, f10523d)) {
            return TopicOperation.OPERATION_PAIR_DIVIDER;
        }
        return ":";
    }
}
