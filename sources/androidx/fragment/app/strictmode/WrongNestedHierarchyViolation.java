package androidx.fragment.app.strictmode;

import androidx.fragment.app.Fragment;

public final class WrongNestedHierarchyViolation extends Violation {
    private final int containerId;
    private final Fragment expectedParentFragment;

    public WrongNestedHierarchyViolation(Fragment fragment, Fragment fragment2, int i11) {
        super(fragment, "Attempting to nest fragment " + fragment + " within the view of parent fragment " + fragment2 + " via container with ID " + i11 + " without using parent's childFragmentManager");
        this.expectedParentFragment = fragment2;
        this.containerId = i11;
    }

    public final int getContainerId() {
        return this.containerId;
    }

    public final Fragment getExpectedParentFragment() {
        return this.expectedParentFragment;
    }
}
