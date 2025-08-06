package com.tencent.thumbplayer.tcmedia.adapter.a.b;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.thumbplayer.tcmedia.adapter.strategy.utils.TPNativeKeyMap;
import com.tencent.thumbplayer.tcmedia.adapter.strategy.utils.TPNativeKeyMapUtil;
import com.tencent.thumbplayer.tcmedia.api.TPCommonEnum;
import com.tencent.thumbplayer.tcmedia.core.common.TPNativeLibraryException;
import com.tencent.thumbplayer.tcmedia.core.common.TPThumbplayerCapabilityHelper;
import com.tencent.thumbplayer.tcmedia.utils.TPLogUtil;
import com.tencent.thumbplayer.tcmedia.utils.b;
import com.tencent.thumbplayer.tcmedia.utils.o;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static Set<String> f48818a = new HashSet();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static Set<String> f48819b = new HashSet();

    public static synchronized void a(Context context) {
        synchronized (a.class) {
            TPLogUtil.i("TPDrmCapability", "TPDrmCapability, init");
            TPLogUtil.i("TPDrmCapability", "TPDrmCapability, get shared preferences.");
            SharedPreferences sharedPreferences = context.getSharedPreferences("TP_DRM_CAPABILITY", 0);
            try {
                f48818a = sharedPreferences.getStringSet("DRM_CAPABILITY_LIST", f48818a);
            } catch (ClassCastException e11) {
                TPLogUtil.e("TPDrmCapability", (Throwable) e11);
            }
            f48818a.removeAll(f48819b);
            a(sharedPreferences);
        }
    }

    private static void a(final SharedPreferences sharedPreferences) {
        o.a().d().execute(new Runnable() {
            public final void run() {
                int[] iArr = new int[0];
                try {
                    iArr = TPThumbplayerCapabilityHelper.getDRMCapabilities();
                } catch (TPNativeLibraryException e11) {
                    TPLogUtil.e("TPDrmCapability", (Throwable) e11);
                }
                TPLogUtil.i("TPDrmCapability", "TPThumbPlayerCapabilityHelper, DRM capability:" + Arrays.toString(iArr));
                if (iArr.length != 0) {
                    HashSet hashSet = new HashSet();
                    for (int tPIntValue : iArr) {
                        hashSet.add(String.valueOf(TPNativeKeyMapUtil.toTPIntValue(TPNativeKeyMap.MapDrmType.class, tPIntValue)));
                    }
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putStringSet("DRM_CAPABILITY_LIST", hashSet);
                    edit.apply();
                    synchronized (a.class) {
                        Set unused = a.f48818a = hashSet;
                        a.f48818a.removeAll(a.f48819b);
                    }
                }
            }
        });
    }

    public static synchronized boolean a(@TPCommonEnum.TP_DRM_TYPE int i11) {
        synchronized (a.class) {
            if (i11 == -1) {
                return false;
            }
            for (String a11 : f48818a) {
                if (b.a(a11, -1) == i11) {
                    return true;
                }
            }
            return false;
        }
    }

    public static synchronized int[] a() {
        int[] iArr;
        synchronized (a.class) {
            iArr = new int[f48818a.size()];
            int i11 = 0;
            for (String a11 : f48818a) {
                int i12 = i11 + 1;
                iArr[i11] = b.a(a11, -1);
                i11 = i12;
            }
        }
        return iArr;
    }

    public static synchronized void b(@TPCommonEnum.TP_DRM_TYPE int i11) {
        synchronized (a.class) {
            if (i11 != -1) {
                f48819b.add(String.valueOf(i11));
                f48818a.removeAll(f48819b);
            }
        }
    }
}
