package kotlinx.coroutines.selects;

import d10.l;
import d10.q;
import kotlin.Unit;
import kotlinx.coroutines.internal.c0;
import kotlinx.coroutines.k;

public final class SelectKt {

    /* renamed from: a  reason: collision with root package name */
    public static final q<Object, Object, Object, Object> f57518a = SelectKt$DUMMY_PROCESS_RESULT_FUNCTION$1.INSTANCE;

    /* renamed from: b  reason: collision with root package name */
    public static final c0 f57519b = new c0("STATE_REG");

    /* renamed from: c  reason: collision with root package name */
    public static final c0 f57520c = new c0("STATE_COMPLETED");

    /* renamed from: d  reason: collision with root package name */
    public static final c0 f57521d = new c0("STATE_CANCELLED");

    /* renamed from: e  reason: collision with root package name */
    public static final c0 f57522e = new c0("NO_RESULT");

    /* renamed from: f  reason: collision with root package name */
    public static final c0 f57523f = new c0("PARAM_CLAUSE_0");

    public static final TrySelectDetailedResult a(int i11) {
        if (i11 == 0) {
            return TrySelectDetailedResult.SUCCESSFUL;
        }
        if (i11 == 1) {
            return TrySelectDetailedResult.REREGISTER;
        }
        if (i11 == 2) {
            return TrySelectDetailedResult.CANCELLED;
        }
        if (i11 == 3) {
            return TrySelectDetailedResult.ALREADY_SELECTED;
        }
        throw new IllegalStateException(("Unexpected internal result: " + i11).toString());
    }

    public static final c0 i() {
        return f57523f;
    }

    public static final boolean j(k<? super Unit> kVar, l<? super Throwable, Unit> lVar) {
        Object D = kVar.D(Unit.f56620a, (Object) null, lVar);
        if (D == null) {
            return false;
        }
        kVar.w(D);
        return true;
    }
}
