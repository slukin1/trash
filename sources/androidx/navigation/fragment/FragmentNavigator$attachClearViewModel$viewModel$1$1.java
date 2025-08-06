package androidx.navigation.fragment;

import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.fragment.FragmentNavigator;
import d10.l;
import kotlin.jvm.internal.Lambda;

public final class FragmentNavigator$attachClearViewModel$viewModel$1$1 extends Lambda implements l<CreationExtras, FragmentNavigator.ClearEntryStateViewModel> {
    public static final FragmentNavigator$attachClearViewModel$viewModel$1$1 INSTANCE = new FragmentNavigator$attachClearViewModel$viewModel$1$1();

    public FragmentNavigator$attachClearViewModel$viewModel$1$1() {
        super(1);
    }

    public final FragmentNavigator.ClearEntryStateViewModel invoke(CreationExtras creationExtras) {
        return new FragmentNavigator.ClearEntryStateViewModel();
    }
}
