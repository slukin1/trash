package kotlin.jvm.internal;

import kotlin.reflect.c;
import kotlin.reflect.f;

public class FunctionReferenceImpl extends FunctionReference {
    public FunctionReferenceImpl(int i11, f fVar, String str, String str2) {
        super(i11, CallableReference.NO_RECEIVER, ((o) fVar).e(), str, str2, (fVar instanceof c) ^ true ? 1 : 0);
    }

    public FunctionReferenceImpl(int i11, Class cls, String str, String str2, int i12) {
        super(i11, CallableReference.NO_RECEIVER, cls, str, str2, i12);
    }

    public FunctionReferenceImpl(int i11, Object obj, Class cls, String str, String str2, int i12) {
        super(i11, obj, cls, str, str2, i12);
    }
}
