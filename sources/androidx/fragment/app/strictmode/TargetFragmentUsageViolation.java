package androidx.fragment.app.strictmode;

import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.r;

public abstract class TargetFragmentUsageViolation extends Violation {
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TargetFragmentUsageViolation(Fragment fragment, String str, int i11, r rVar) {
        this(fragment, (i11 & 2) != 0 ? null : str);
    }

    public TargetFragmentUsageViolation(Fragment fragment, String str) {
        super(fragment, str);
    }
}
