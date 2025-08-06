package androidx.fragment.app.strictmode;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;

public final class WrongFragmentContainerViolation extends Violation {
    private final ViewGroup container;

    public WrongFragmentContainerViolation(Fragment fragment, ViewGroup viewGroup) {
        super(fragment, "Attempting to add fragment " + fragment + " to container " + viewGroup + " which is not a FragmentContainerView");
        this.container = viewGroup;
    }

    public final ViewGroup getContainer() {
        return this.container;
    }
}
