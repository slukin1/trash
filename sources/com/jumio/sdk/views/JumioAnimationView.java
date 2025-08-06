package com.jumio.sdk.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import javax.security.auth.Destroyable;

public class JumioAnimationView extends RelativeLayout {
    public JumioAnimationView(Context context) {
        super(context);
    }

    public void destroy() {
        if (getTag() instanceof Destroyable) {
            try {
                ((Destroyable) getTag()).destroy();
                removeAllViews();
            } catch (Exception unused) {
            }
        }
    }

    public JumioAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public JumioAnimationView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
