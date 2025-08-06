package p0;

import android.app.Activity;
import android.app.ActivityOptions;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;

public class c {

    public static class a extends c {

        /* renamed from: a  reason: collision with root package name */
        public final ActivityOptions f16286a;

        public a(ActivityOptions activityOptions) {
            this.f16286a = activityOptions;
        }

        public Bundle b() {
            return this.f16286a.toBundle();
        }
    }

    public static class b {
        public static ActivityOptions a(Activity activity, View view, String str) {
            return ActivityOptions.makeSceneTransitionAnimation(activity, view, str);
        }

        @SafeVarargs
        public static ActivityOptions b(Activity activity, Pair<View, String>... pairArr) {
            return ActivityOptions.makeSceneTransitionAnimation(activity, pairArr);
        }

        public static ActivityOptions c() {
            return ActivityOptions.makeTaskLaunchBehind();
        }
    }

    public static c a(Activity activity, androidx.core.util.c<View, String>... cVarArr) {
        if (Build.VERSION.SDK_INT < 21) {
            return new c();
        }
        Pair[] pairArr = null;
        if (cVarArr != null) {
            pairArr = new Pair[cVarArr.length];
            for (int i11 = 0; i11 < cVarArr.length; i11++) {
                pairArr[i11] = Pair.create((View) cVarArr[i11].f8468a, (String) cVarArr[i11].f8469b);
            }
        }
        return new a(b.b(activity, pairArr));
    }

    public Bundle b() {
        return null;
    }
}
