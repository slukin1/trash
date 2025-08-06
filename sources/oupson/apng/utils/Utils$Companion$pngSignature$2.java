package oupson.apng.utils;

import com.google.common.base.Ascii;
import d10.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0012\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 2})
public final class Utils$Companion$pngSignature$2 extends Lambda implements a<byte[]> {
    public static final Utils$Companion$pngSignature$2 INSTANCE = new Utils$Companion$pngSignature$2();

    public Utils$Companion$pngSignature$2() {
        super(0);
    }

    public final byte[] invoke() {
        return new byte[]{(byte) 137, 80, 78, 71, 13, 10, Ascii.SUB, 10};
    }
}
