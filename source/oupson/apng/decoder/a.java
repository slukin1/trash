package oupson.apng.decoder;

import kotlin.Metadata;
import oupson.apng.utils.Utils;

@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
public final /* synthetic */ class a {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f52963a;

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ int[] f52964b;

    static {
        int[] iArr = new int[Utils.Companion.DisposeOp.values().length];
        f52963a = iArr;
        Utils.Companion.DisposeOp disposeOp = Utils.Companion.DisposeOp.APNG_DISPOSE_OP_PREVIOUS;
        iArr[disposeOp.ordinal()] = 1;
        Utils.Companion.DisposeOp disposeOp2 = Utils.Companion.DisposeOp.APNG_DISPOSE_OP_BACKGROUND;
        iArr[disposeOp2.ordinal()] = 2;
        int[] iArr2 = new int[Utils.Companion.DisposeOp.values().length];
        f52964b = iArr2;
        iArr2[disposeOp.ordinal()] = 1;
        iArr2[disposeOp2.ordinal()] = 2;
    }
}
