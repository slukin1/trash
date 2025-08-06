package com.mob.guard;

import android.content.Context;
import com.mob.mcl.MobMCL;
import com.mob.mgs.MobMGS;
import com.mob.mgs.OnAppActiveListener;
import com.mob.mgs.OnIdChangeListener;
import com.mob.mgs.impl.e;
import com.mob.tools.proguard.PublicMemberKeeper;

@Deprecated
public class MobGuard implements PublicMemberKeeper {
    public static String getGuardId() {
        try {
            return MobMCL.getSuid();
        } catch (Throwable th2) {
            e.a().a(th2);
            return null;
        }
    }

    public static void setOnAppActiveListener(final OnAppActiveListener onAppActiveListener) {
        if (onAppActiveListener != null) {
            MobMGS.setOnAppActiveListener(new OnAppActiveListener() {
                public void onAppActive(Context context, int i11) {
                    OnAppActiveListener onAppActiveListener = OnAppActiveListener.this;
                    if (onAppActiveListener != null) {
                        onAppActiveListener.onAppActive(context, i11);
                    }
                }
            });
        }
    }

    public static void getGuardId(final OnIdChangeListener onIdChangeListener) {
        if (onIdChangeListener != null) {
            MobMCL.getSuid(new OnIdChangeListener() {
                public void onChanged(String str, String str2) {
                    OnIdChangeListener onIdChangeListener = OnIdChangeListener.this;
                    if (onIdChangeListener != null) {
                        onIdChangeListener.onChanged(str, str2);
                    }
                }
            });
        }
    }
}
