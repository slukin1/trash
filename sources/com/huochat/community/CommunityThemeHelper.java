package com.huochat.community;

import android.content.Context;
import android.util.TypedValue;
import androidx.appcompat.view.ContextThemeWrapper;
import kotlin.jvm.internal.r;

public final class CommunityThemeHelper {
    public static final Companion Companion = new Companion((r) null);

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public final int getColor(Context context, int i11) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(i11, typedValue, true);
            return typedValue.data;
        }

        public final int getDrawableRes(Context context, int i11) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(i11, typedValue, true);
            return typedValue.resourceId;
        }

        public final ContextThemeWrapper getThemeContext(Context context) {
            if (CommunityManager.Companion.getInstance().isNightModel()) {
                return new ContextThemeWrapper(context, R.style.communityThemeNight);
            }
            return new ContextThemeWrapper(context, R.style.communityThemeLight);
        }
    }
}
