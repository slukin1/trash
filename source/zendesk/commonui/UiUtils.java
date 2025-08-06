package zendesk.commonui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.huobi.view.roundimg.RoundedDrawable;
import com.zendesk.logger.Logger;
import java.util.Locale;
import u0.a;

public class UiUtils {

    public enum ScreenSize {
        UNKNOWN,
        UNDEFINED,
        X_LARGE,
        LARGE,
        NORMAL,
        SMALL
    }

    public static int a(int i11, Context context) {
        return ContextCompat.getColor(context, i11);
    }

    public static void b(int i11, Drawable drawable, View view) {
        if (drawable == null) {
            Logger.d("UiUtils", "Drawable is null, cannot apply a tint", new Object[0]);
            return;
        }
        a.n(a.r(drawable).mutate(), i11);
        if (view != null) {
            view.invalidate();
        }
    }

    public static int c(int i11, Context context, int i12) {
        if (i11 == 0 || context == null || i12 == 0) {
            Logger.b("UiUtils", "themeAttributeId, context, and fallbackColorId are required.", new Object[0]);
            return RoundedDrawable.DEFAULT_BORDER_COLOR;
        }
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(i11, typedValue, true)) {
            Logger.d("UiUtils", String.format(Locale.US, "Resource %d not found. Resource is either missing or you are using a non-ui context.", new Object[]{Integer.valueOf(i11)}), new Object[0]);
            return a(i12, context);
        }
        int i13 = typedValue.resourceId;
        if (i13 == 0) {
            return typedValue.data;
        }
        return a(i13, context);
    }
}
