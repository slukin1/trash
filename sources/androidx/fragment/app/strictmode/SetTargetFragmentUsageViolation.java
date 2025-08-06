package androidx.fragment.app.strictmode;

import androidx.fragment.app.Fragment;

public final class SetTargetFragmentUsageViolation extends TargetFragmentUsageViolation {
    private final int requestCode;
    private final Fragment targetFragment;

    public SetTargetFragmentUsageViolation(Fragment fragment, Fragment fragment2, int i11) {
        super(fragment, "Attempting to set target fragment " + fragment2 + " with request code " + i11 + " for fragment " + fragment);
        this.targetFragment = fragment2;
        this.requestCode = i11;
    }

    public final int getRequestCode() {
        return this.requestCode;
    }

    public final Fragment getTargetFragment() {
        return this.targetFragment;
    }
}
