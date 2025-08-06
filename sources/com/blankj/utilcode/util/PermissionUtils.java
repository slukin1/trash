package com.blankj.utilcode.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.util.Pair;
import android.view.MotionEvent;
import androidx.core.content.ContextCompat;
import com.blankj.utilcode.constant.PermissionConstants;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.UtilsTransActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public final class PermissionUtils {

    /* renamed from: m  reason: collision with root package name */
    public static PermissionUtils f63360m;

    /* renamed from: n  reason: collision with root package name */
    public static e f63361n;

    /* renamed from: o  reason: collision with root package name */
    public static e f63362o;

    /* renamed from: a  reason: collision with root package name */
    public String[] f63363a;

    /* renamed from: b  reason: collision with root package name */
    public c f63364b;

    /* renamed from: c  reason: collision with root package name */
    public d f63365c;

    /* renamed from: d  reason: collision with root package name */
    public f f63366d;

    /* renamed from: e  reason: collision with root package name */
    public e f63367e;

    /* renamed from: f  reason: collision with root package name */
    public b f63368f;

    /* renamed from: g  reason: collision with root package name */
    public g f63369g;

    /* renamed from: h  reason: collision with root package name */
    public Set<String> f63370h;

    /* renamed from: i  reason: collision with root package name */
    public List<String> f63371i;

    /* renamed from: j  reason: collision with root package name */
    public List<String> f63372j;

    /* renamed from: k  reason: collision with root package name */
    public List<String> f63373k;

    /* renamed from: l  reason: collision with root package name */
    public List<String> f63374l;

    public static final class PermissionActivityImpl extends UtilsTransActivity.TransActivityDelegate {
        private static PermissionActivityImpl INSTANCE = new PermissionActivityImpl();
        private static final String TYPE = "TYPE";
        private static final int TYPE_DRAW_OVERLAYS = 3;
        private static final int TYPE_RUNTIME = 1;
        private static final int TYPE_WRITE_SETTINGS = 2;
        private static int currentRequestCode = -1;

        public static class a implements Utils.a<Intent> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ int f63375a;

            public a(int i11) {
                this.f63375a = i11;
            }

            /* renamed from: a */
            public void accept(Intent intent) {
                intent.putExtra("TYPE", this.f63375a);
            }
        }

        public class b implements c.a {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ UtilsTransActivity f63376a;

            public b(UtilsTransActivity utilsTransActivity) {
                this.f63376a = utilsTransActivity;
            }
        }

        public class c implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ UtilsTransActivity f63378b;

            public c(UtilsTransActivity utilsTransActivity) {
                this.f63378b = utilsTransActivity;
            }

            public void run() {
                this.f63378b.requestPermissions((String[]) PermissionUtils.f63360m.f63371i.toArray(new String[0]), 1);
            }
        }

        private void checkRequestCallback(int i11) {
            if (i11 == 2) {
                if (PermissionUtils.f63361n != null) {
                    if (PermissionUtils.w()) {
                        PermissionUtils.f63361n.onGranted();
                    } else {
                        PermissionUtils.f63361n.onDenied();
                    }
                    e unused = PermissionUtils.f63361n = null;
                }
            } else if (i11 == 3 && PermissionUtils.f63362o != null) {
                if (PermissionUtils.v()) {
                    PermissionUtils.f63362o.onGranted();
                } else {
                    PermissionUtils.f63362o.onDenied();
                }
                e unused2 = PermissionUtils.f63362o = null;
            }
        }

        /* access modifiers changed from: private */
        public void requestPermissions(UtilsTransActivity utilsTransActivity) {
            if (!PermissionUtils.f63360m.D(utilsTransActivity, new c(utilsTransActivity))) {
                utilsTransActivity.requestPermissions((String[]) PermissionUtils.f63360m.f63371i.toArray(new String[0]), 1);
            }
        }

        public static void start(int i11) {
            UtilsTransActivity.Af(new a(i11), INSTANCE);
        }

        public boolean dispatchTouchEvent(UtilsTransActivity utilsTransActivity, MotionEvent motionEvent) {
            Objects.requireNonNull(utilsTransActivity, "Argument 'activity' of type UtilsTransActivity (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            utilsTransActivity.finish();
            return true;
        }

        public void onActivityResult(UtilsTransActivity utilsTransActivity, int i11, int i12, Intent intent) {
            Objects.requireNonNull(utilsTransActivity, "Argument 'activity' of type UtilsTransActivity (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            utilsTransActivity.finish();
        }

        public void onCreated(UtilsTransActivity utilsTransActivity, Bundle bundle) {
            Objects.requireNonNull(utilsTransActivity, "Argument 'activity' of type UtilsTransActivity (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            utilsTransActivity.getWindow().addFlags(262160);
            int intExtra = utilsTransActivity.getIntent().getIntExtra("TYPE", -1);
            if (intExtra == 1) {
                if (PermissionUtils.f63360m == null) {
                    Log.e("PermissionUtils", "sInstance is null.");
                    utilsTransActivity.finish();
                } else if (PermissionUtils.f63360m.f63371i == null) {
                    Log.e("PermissionUtils", "mPermissionsRequest is null.");
                    utilsTransActivity.finish();
                } else if (PermissionUtils.f63360m.f63371i.size() <= 0) {
                    Log.e("PermissionUtils", "mPermissionsRequest's size is no more than 0.");
                    utilsTransActivity.finish();
                } else {
                    if (PermissionUtils.f63360m.f63369g != null) {
                        PermissionUtils.f63360m.f63369g.a(utilsTransActivity);
                    }
                    if (PermissionUtils.f63360m.f63364b != null) {
                        PermissionUtils.f63360m.f63364b.a(utilsTransActivity, PermissionUtils.f63360m.f63371i, new b(utilsTransActivity));
                        c unused = PermissionUtils.f63360m.f63364b = null;
                        return;
                    }
                    requestPermissions(utilsTransActivity);
                }
            } else if (intExtra == 2) {
                currentRequestCode = 2;
                PermissionUtils.G(utilsTransActivity, 2);
            } else if (intExtra == 3) {
                currentRequestCode = 3;
                PermissionUtils.E(utilsTransActivity, 3);
            } else {
                utilsTransActivity.finish();
                Log.e("PermissionUtils", "type is wrong.");
            }
        }

        public void onDestroy(UtilsTransActivity utilsTransActivity) {
            Objects.requireNonNull(utilsTransActivity, "Argument 'activity' of type UtilsTransActivity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            int i11 = currentRequestCode;
            if (i11 != -1) {
                checkRequestCallback(i11);
                currentRequestCode = -1;
            }
            super.onDestroy(utilsTransActivity);
        }

        public void onRequestPermissionsResult(UtilsTransActivity utilsTransActivity, int i11, String[] strArr, int[] iArr) {
            Objects.requireNonNull(utilsTransActivity, "Argument 'activity' of type UtilsTransActivity (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            Objects.requireNonNull(strArr, "Argument 'permissions' of type String[] (#2 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            Objects.requireNonNull(iArr, "Argument 'grantResults' of type int[] (#3 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            utilsTransActivity.finish();
            if (PermissionUtils.f63360m != null && PermissionUtils.f63360m.f63371i != null) {
                PermissionUtils.f63360m.y(utilsTransActivity);
            }
        }
    }

    public class a implements d.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Runnable f63380a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UtilsTransActivity f63381b;

        public a(Runnable runnable, UtilsTransActivity utilsTransActivity) {
            this.f63380a = runnable;
            this.f63381b = utilsTransActivity;
        }
    }

    public interface b {
        void a(List<String> list, List<String> list2);

        void onGranted(List<String> list);
    }

    public interface c {

        public interface a {
        }

        void a(UtilsTransActivity utilsTransActivity, List<String> list, a aVar);
    }

    public interface d {

        public interface a {
        }

        void a(UtilsTransActivity utilsTransActivity, a aVar);
    }

    public interface e {
        void onDenied();

        void onGranted();
    }

    public interface f {
        void a(boolean z11, List<String> list, List<String> list2, List<String> list3);
    }

    public interface g {
        void a(Activity activity);
    }

    public PermissionUtils(String... strArr) {
        this.f63363a = strArr;
        f63360m = this;
    }

    @TargetApi(23)
    public static void E(Activity activity, int i11) {
        Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
        intent.setData(Uri.parse("package:" + Utils.a().getPackageName()));
        if (!a0.z(intent)) {
            x();
        } else {
            activity.startActivityForResult(intent, i11);
        }
    }

    @TargetApi(23)
    public static void G(Activity activity, int i11) {
        Intent intent = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
        intent.setData(Uri.parse("package:" + Utils.a().getPackageName()));
        if (!a0.z(intent)) {
            x();
        } else {
            activity.startActivityForResult(intent, i11);
        }
    }

    public static List<String> p() {
        return q(Utils.a().getPackageName());
    }

    public static List<String> q(String str) {
        try {
            String[] strArr = Utils.a().getPackageManager().getPackageInfo(str, 4096).requestedPermissions;
            if (strArr == null) {
                return Collections.emptyList();
            }
            return Arrays.asList(strArr);
        } catch (PackageManager.NameNotFoundException e11) {
            e11.printStackTrace();
            return Collections.emptyList();
        }
    }

    public static Pair<List<String>, List<String>> s(String... strArr) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        List<String> p11 = p();
        for (String str : strArr) {
            boolean z11 = false;
            for (String str2 : PermissionConstants.a(str)) {
                if (p11.contains(str2)) {
                    arrayList.add(str2);
                    z11 = true;
                }
            }
            if (!z11) {
                arrayList2.add(str);
                Log.e("PermissionUtils", "U should add the permission of " + str + " in manifest.");
            }
        }
        return Pair.create(arrayList, arrayList2);
    }

    public static boolean t(String str) {
        return Build.VERSION.SDK_INT < 23 || ContextCompat.checkSelfPermission(Utils.a(), str) == 0;
    }

    public static boolean u(String... strArr) {
        Pair<List<String>, List<String>> s11 = s(strArr);
        if (!((List) s11.second).isEmpty()) {
            return false;
        }
        for (String t11 : (List) s11.first) {
            if (!t(t11)) {
                return false;
            }
        }
        return true;
    }

    public static boolean v() {
        return Settings.canDrawOverlays(Utils.a());
    }

    public static boolean w() {
        return Settings.System.canWrite(Utils.a());
    }

    public static void x() {
        Intent n11 = a0.n(Utils.a().getPackageName(), true);
        if (a0.z(n11)) {
            Utils.a().startActivity(n11);
        }
    }

    public static PermissionUtils z(String... strArr) {
        return new PermissionUtils(strArr);
    }

    public final void A(UtilsTransActivity utilsTransActivity, Runnable runnable) {
        r(utilsTransActivity);
        this.f63365c.a(utilsTransActivity, new a(runnable, utilsTransActivity));
    }

    public void B() {
        String[] strArr = this.f63363a;
        if (strArr == null || strArr.length <= 0) {
            Log.w("PermissionUtils", "No permissions to request.");
            return;
        }
        this.f63370h = new LinkedHashSet();
        this.f63371i = new ArrayList();
        this.f63372j = new ArrayList();
        this.f63373k = new ArrayList();
        this.f63374l = new ArrayList();
        Pair<List<String>, List<String>> s11 = s(this.f63363a);
        this.f63370h.addAll((Collection) s11.first);
        this.f63373k.addAll((Collection) s11.second);
        if (Build.VERSION.SDK_INT < 23) {
            this.f63372j.addAll(this.f63370h);
            C();
            return;
        }
        for (String next : this.f63370h) {
            if (t(next)) {
                this.f63372j.add(next);
            } else {
                this.f63371i.add(next);
            }
        }
        if (this.f63371i.isEmpty()) {
            C();
        } else {
            F();
        }
    }

    public final void C() {
        f fVar = this.f63366d;
        if (fVar != null) {
            fVar.a(this.f63373k.isEmpty(), this.f63372j, this.f63374l, this.f63373k);
            this.f63366d = null;
        }
        if (this.f63367e != null) {
            if (this.f63373k.isEmpty()) {
                this.f63367e.onGranted();
            } else {
                this.f63367e.onDenied();
            }
            this.f63367e = null;
        }
        if (this.f63368f != null) {
            if (this.f63371i.size() == 0 || this.f63372j.size() > 0) {
                this.f63368f.onGranted(this.f63372j);
            }
            if (!this.f63373k.isEmpty()) {
                this.f63368f.a(this.f63374l, this.f63373k);
            }
            this.f63368f = null;
        }
        this.f63365c = null;
        this.f63369g = null;
    }

    public final boolean D(UtilsTransActivity utilsTransActivity, Runnable runnable) {
        boolean z11 = false;
        if (this.f63365c != null) {
            Iterator<String> it2 = this.f63371i.iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (utilsTransActivity.shouldShowRequestPermissionRationale(it2.next())) {
                        A(utilsTransActivity, runnable);
                        z11 = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            this.f63365c = null;
        }
        return z11;
    }

    public final void F() {
        PermissionActivityImpl.start(1);
    }

    public PermissionUtils n(b bVar) {
        this.f63368f = bVar;
        return this;
    }

    public PermissionUtils o(e eVar) {
        this.f63367e = eVar;
        return this;
    }

    public final void r(Activity activity) {
        for (String next : this.f63371i) {
            if (t(next)) {
                this.f63372j.add(next);
            } else {
                this.f63373k.add(next);
                if (!activity.shouldShowRequestPermissionRationale(next)) {
                    this.f63374l.add(next);
                }
            }
        }
    }

    public final void y(Activity activity) {
        r(activity);
        C();
    }
}
