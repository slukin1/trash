package androidx.fragment.app.strictmode;

import androidx.fragment.app.Fragment;

public final class SetUserVisibleHintViolation extends Violation {
    private final boolean isVisibleToUser;

    public SetUserVisibleHintViolation(Fragment fragment, boolean z11) {
        super(fragment, "Attempting to set user visible hint to " + z11 + " for fragment " + fragment);
        this.isVisibleToUser = z11;
    }

    public final boolean isVisibleToUser() {
        return this.isVisibleToUser;
    }
}
