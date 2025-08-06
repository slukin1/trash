package oupson.apng.utils;

import d10.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import net.sf.scuba.smartcards.ISO7816;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0012\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 2})
public final class Utils$Companion$IEND$2 extends Lambda implements a<byte[]> {
    public static final Utils$Companion$IEND$2 INSTANCE = new Utils$Companion$IEND$2();

    public Utils$Companion$IEND$2() {
        super(0);
    }

    public final byte[] invoke() {
        return new byte[]{73, 69, 78, ISO7816.INS_REHABILITATE_CHV};
    }
}
