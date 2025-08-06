package androidx.navigation;

import android.content.Context;
import android.content.ContextWrapper;
import d10.l;
import kotlin.jvm.internal.Lambda;

public final class ActivityNavigator$hostActivity$1 extends Lambda implements l<Context, Context> {
    public static final ActivityNavigator$hostActivity$1 INSTANCE = new ActivityNavigator$hostActivity$1();

    public ActivityNavigator$hostActivity$1() {
        super(1);
    }

    public final Context invoke(Context context) {
        if (context instanceof ContextWrapper) {
            return ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }
}
