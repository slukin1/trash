package androidx.activity;

import android.content.res.Resources;
import d10.l;
import kotlin.jvm.internal.Lambda;

final class SystemBarStyle$Companion$auto$1 extends Lambda implements l<Resources, Boolean> {
    public static final SystemBarStyle$Companion$auto$1 INSTANCE = new SystemBarStyle$Companion$auto$1();

    public SystemBarStyle$Companion$auto$1() {
        super(1);
    }

    public final Boolean invoke(Resources resources) {
        return Boolean.valueOf((resources.getConfiguration().uiMode & 48) == 32);
    }
}
