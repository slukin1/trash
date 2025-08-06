package androidx.fragment.app.strictmode;

import androidx.fragment.app.Fragment;

public final class GetRetainInstanceUsageViolation extends RetainInstanceUsageViolation {
    public GetRetainInstanceUsageViolation(Fragment fragment) {
        super(fragment, "Attempting to get retain instance for fragment " + fragment);
    }
}
