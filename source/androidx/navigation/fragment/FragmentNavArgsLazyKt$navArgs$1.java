package androidx.navigation.fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import d10.a;
import kotlin.jvm.internal.Lambda;

public final class FragmentNavArgsLazyKt$navArgs$1 extends Lambda implements a<Bundle> {
    public final /* synthetic */ Fragment $this_navArgs;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FragmentNavArgsLazyKt$navArgs$1(Fragment fragment) {
        super(0);
        this.$this_navArgs = fragment;
    }

    public final Bundle invoke() {
        Bundle arguments = this.$this_navArgs.getArguments();
        if (arguments != null) {
            return arguments;
        }
        throw new IllegalStateException("Fragment " + this.$this_navArgs + " has null arguments");
    }
}
