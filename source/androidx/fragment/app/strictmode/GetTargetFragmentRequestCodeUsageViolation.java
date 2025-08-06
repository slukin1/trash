package androidx.fragment.app.strictmode;

import androidx.fragment.app.Fragment;

public final class GetTargetFragmentRequestCodeUsageViolation extends TargetFragmentUsageViolation {
    public GetTargetFragmentRequestCodeUsageViolation(Fragment fragment) {
        super(fragment, "Attempting to get target request code from fragment " + fragment);
    }
}
