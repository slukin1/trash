package zendesk.support.guide;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Html;
import android.util.TypedValue;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.huobi.view.roundimg.RoundedDrawable;
import com.zendesk.logger.Logger;
import java.util.Locale;
import u0.a;

public class UiUtils {
    private static final String LOG_TAG = "UiUtils";

    public enum ScreenSize {
        UNKNOWN,
        UNDEFINED,
        X_LARGE,
        LARGE,
        NORMAL,
        SMALL
    }

    private UiUtils() {
    }

    public static CharSequence decodeHtmlEntities(String str) {
        if (Build.VERSION.SDK_INT >= 24) {
            return Html.fromHtml(str, 0);
        }
        return Html.fromHtml(str);
    }

    public static int resolveColor(int i11, Context context) {
        return ContextCompat.getColor(context, i11);
    }

    public static void setTint(int i11, Drawable drawable, View view) {
        if (drawable == null) {
            Logger.d(LOG_TAG, "Drawable is null, cannot apply a tint", new Object[0]);
            return;
        }
        a.n(a.r(drawable).mutate(), i11);
        if (view != null) {
            view.invalidate();
        }
    }

    public static void setVisibility(View view, int i11) {
        if (view == null) {
            Logger.l(LOG_TAG, "View is null and can't change visibility", new Object[0]);
        } else {
            view.setVisibility(i11);
        }
    }

    public static int themeAttributeToColor(int i11, Context context, int i12) {
        if (i11 == 0 || context == null || i12 == 0) {
            Logger.b(LOG_TAG, "themeAttributeId, context, and fallbackColorId are required.", new Object[0]);
            return RoundedDrawable.DEFAULT_BORDER_COLOR;
        }
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(i11, typedValue, true)) {
            Logger.d(LOG_TAG, String.format(Locale.US, "Resource %d not found. Resource is either missing or you are using a non-ui context.", new Object[]{Integer.valueOf(i11)}), new Object[0]);
            return resolveColor(i12, context);
        }
        int i13 = typedValue.resourceId;
        if (i13 == 0) {
            return typedValue.data;
        }
        return resolveColor(i13, context);
    }

    public int themeAttributeToPixels(int i11, Context context, int i12, float f11) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i11, typedValue, true)) {
            return Math.round(typedValue.getDimension(context.getResources().getDisplayMetrics()));
        }
        Logger.d(LOG_TAG, String.format(Locale.US, "Resource %d not found. Resource is either missing or you are using a non-ui context.", new Object[]{Integer.valueOf(i11)}), new Object[0]);
        return Math.round(TypedValue.applyDimension(i12, f11, context.getResources().getDisplayMetrics()));
    }
}
