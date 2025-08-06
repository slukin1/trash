package androidx.fragment.app.strictmode;

import androidx.fragment.app.Fragment;

public final class SetRetainInstanceUsageViolation extends RetainInstanceUsageViolation {
    public SetRetainInstanceUsageViolation(Fragment fragment) {
        super(fragment, "Attempting to set retain instance for fragment " + fragment);
    }
}
