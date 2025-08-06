package androidx.activity;

import androidx.lifecycle.LifecycleOwner;

public interface q extends LifecycleOwner {
    OnBackPressedDispatcher getOnBackPressedDispatcher();
}
