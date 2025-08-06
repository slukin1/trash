package butterknife.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import androidx.core.content.ContextCompat;
import java.lang.reflect.Array;
import java.util.List;
import u0.a;

public final class Utils {
    private static final TypedValue VALUE = new TypedValue();

    private Utils() {
        throw new AssertionError("No instances.");
    }

    @SafeVarargs
    public static <T> T[] arrayFilteringNull(T... tArr) {
        int i11 = 0;
        for (T t11 : tArr) {
            if (t11 != null) {
                tArr[i11] = t11;
                i11++;
            }
        }
        if (i11 == r0) {
            return tArr;
        }
        T[] tArr2 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), i11);
        System.arraycopy(tArr, 0, tArr2, 0, i11);
        return tArr2;
    }

    public static <T> T castParam(Object obj, String str, int i11, String str2, int i12, Class<T> cls) {
        try {
            return cls.cast(obj);
        } catch (ClassCastException e11) {
            throw new IllegalStateException("Parameter #" + (i11 + 1) + " of method '" + str + "' was of the wrong type for parameter #" + (i12 + 1) + " of method '" + str2 + "'. See cause for more info.", e11);
        }
    }

    public static <T> T castView(View view, int i11, String str, Class<T> cls) {
        try {
            return cls.cast(view);
        } catch (ClassCastException e11) {
            String resourceEntryName = getResourceEntryName(view, i11);
            throw new IllegalStateException("View '" + resourceEntryName + "' with ID " + i11 + " for " + str + " was of the wrong type. See cause for more info.", e11);
        }
    }

    public static <T> T findOptionalViewAsType(View view, int i11, String str, Class<T> cls) {
        return castView(view.findViewById(i11), i11, str, cls);
    }

    public static View findRequiredView(View view, int i11, String str) {
        View findViewById = view.findViewById(i11);
        if (findViewById != null) {
            return findViewById;
        }
        String resourceEntryName = getResourceEntryName(view, i11);
        throw new IllegalStateException("Required view '" + resourceEntryName + "' with ID " + i11 + " for " + str + " was not found. If this view is optional add '@Nullable' (fields) or '@Optional' (methods) annotation.");
    }

    public static <T> T findRequiredViewAsType(View view, int i11, String str, Class<T> cls) {
        return castView(findRequiredView(view, i11, str), i11, str, cls);
    }

    public static float getFloat(Context context, int i11) {
        TypedValue typedValue = VALUE;
        context.getResources().getValue(i11, typedValue, true);
        if (typedValue.type == 4) {
            return typedValue.getFloat();
        }
        throw new Resources.NotFoundException("Resource ID #0x" + Integer.toHexString(i11) + " type #0x" + Integer.toHexString(typedValue.type) + " is not valid");
    }

    private static String getResourceEntryName(View view, int i11) {
        if (view.isInEditMode()) {
            return "<unavailable while editing>";
        }
        return view.getContext().getResources().getResourceEntryName(i11);
    }

    public static Drawable getTintedDrawable(Context context, int i11, int i12) {
        Resources.Theme theme = context.getTheme();
        TypedValue typedValue = VALUE;
        if (theme.resolveAttribute(i12, typedValue, true)) {
            Drawable r11 = a.r(ContextCompat.getDrawable(context, i11).mutate());
            a.n(r11, ContextCompat.getColor(context, typedValue.resourceId));
            return r11;
        }
        throw new Resources.NotFoundException("Required tint color attribute with name " + context.getResources().getResourceEntryName(i12) + " and attribute ID " + i12 + " was not found.");
    }

    @SafeVarargs
    public static <T> List<T> listFilteringNull(T... tArr) {
        return new ImmutableList(arrayFilteringNull(tArr));
    }
}
