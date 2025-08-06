package w3;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static volatile boolean f66658a = true;

    public static Drawable a(Context context, int i11, Resources.Theme theme) {
        return c(context, context, i11, theme);
    }

    public static Drawable b(Context context, Context context2, int i11) {
        return c(context, context2, i11, (Resources.Theme) null);
    }

    public static Drawable c(Context context, Context context2, int i11, Resources.Theme theme) {
        try {
            if (f66658a) {
                return e(context2, i11, theme);
            }
        } catch (NoClassDefFoundError unused) {
            f66658a = false;
        } catch (IllegalStateException e11) {
            if (!context.getPackageName().equals(context2.getPackageName())) {
                return ContextCompat.getDrawable(context2, i11);
            }
            throw e11;
        } catch (Resources.NotFoundException unused2) {
        }
        if (theme == null) {
            theme = context2.getTheme();
        }
        return d(context2, i11, theme);
    }

    public static Drawable d(Context context, int i11, Resources.Theme theme) {
        return ResourcesCompat.f(context.getResources(), i11, theme);
    }

    public static Drawable e(Context context, int i11, Resources.Theme theme) {
        if (theme != null) {
            context = new ContextThemeWrapper(context, theme);
        }
        return c.a.b(context, i11);
    }
}
