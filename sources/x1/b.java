package x1;

import android.view.View;
import android.view.ViewGroup;

public class b {
    public static <T extends View> T a(View view, int i11) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i12 = 0; i12 < childCount; i12++) {
            T findViewById = viewGroup.getChildAt(i12).findViewById(i11);
            if (findViewById != null) {
                return findViewById;
            }
        }
        return null;
    }
}
