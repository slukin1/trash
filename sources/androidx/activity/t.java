package androidx.activity;

import android.graphics.Rect;
import android.view.View;

public final class t {
    public static final Rect b(View view) {
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        return rect;
    }
}
