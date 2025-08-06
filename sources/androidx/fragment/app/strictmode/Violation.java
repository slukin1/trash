package androidx.fragment.app.strictmode;

import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.r;

public abstract class Violation extends RuntimeException {
    private final Fragment fragment;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Violation(Fragment fragment2, String str, int i11, r rVar) {
        this(fragment2, (i11 & 2) != 0 ? null : str);
    }

    public final Fragment getFragment() {
        return this.fragment;
    }

    public Violation(Fragment fragment2, String str) {
        super(str);
        this.fragment = fragment2;
    }
}
