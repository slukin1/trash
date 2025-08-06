package androidx.transition;

import android.content.Context;
import android.util.AttributeSet;

public class AutoTransition extends TransitionSet {
    public AutoTransition() {
        w();
    }

    public final void w() {
        s(1);
        g(new Fade(2)).g(new ChangeBounds()).g(new Fade(1));
    }

    public AutoTransition(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        w();
    }
}
