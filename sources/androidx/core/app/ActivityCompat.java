package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.Display;
import android.view.DragEvent;
import android.view.View;
import androidx.core.content.ContextCompat;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class ActivityCompat extends ContextCompat {
    private static k sDelegate;

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String[] f8137b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Activity f8138c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f8139d;

        public a(String[] strArr, Activity activity, int i11) {
            this.f8137b = strArr;
            this.f8138c = activity;
            this.f8139d = i11;
        }

        public void run() {
            int[] iArr = new int[this.f8137b.length];
            PackageManager packageManager = this.f8138c.getPackageManager();
            String packageName = this.f8138c.getPackageName();
            int length = this.f8137b.length;
            for (int i11 = 0; i11 < length; i11++) {
                iArr[i11] = packageManager.checkPermission(this.f8137b[i11], packageName);
            }
            ((j) this.f8138c).onRequestPermissionsResult(this.f8139d, this.f8137b, iArr);
        }
    }

    public static class b {
        public static void a(Activity activity) {
            activity.finishAffinity();
        }

        public static void b(Activity activity, Intent intent, int i11, Bundle bundle) {
            activity.startActivityForResult(intent, i11, bundle);
        }

        public static void c(Activity activity, IntentSender intentSender, int i11, Intent intent, int i12, int i13, int i14, Bundle bundle) throws IntentSender.SendIntentException {
            activity.startIntentSenderForResult(intentSender, i11, intent, i12, i13, i14, bundle);
        }
    }

    public static class c {
        public static void a(Activity activity) {
            activity.finishAfterTransition();
        }

        public static void b(Activity activity) {
            activity.postponeEnterTransition();
        }

        public static void c(Activity activity, SharedElementCallback sharedElementCallback) {
            activity.setEnterSharedElementCallback(sharedElementCallback);
        }

        public static void d(Activity activity, SharedElementCallback sharedElementCallback) {
            activity.setExitSharedElementCallback(sharedElementCallback);
        }

        public static void e(Activity activity) {
            activity.startPostponedEnterTransition();
        }
    }

    public static class d {
        public static Uri a(Activity activity) {
            return activity.getReferrer();
        }
    }

    public static class e {
        public static void a(Object obj) {
            ((SharedElementCallback.OnSharedElementsReadyListener) obj).onSharedElementsReady();
        }

        public static void b(Activity activity, String[] strArr, int i11) {
            activity.requestPermissions(strArr, i11);
        }

        public static boolean c(Activity activity, String str) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
    }

    public static class f {
        public static <T> T a(Activity activity, int i11) {
            return activity.requireViewById(i11);
        }
    }

    public static class g {
        public static Display a(ContextWrapper contextWrapper) {
            return contextWrapper.getDisplay();
        }

        public static void b(Activity activity, q0.b bVar, Bundle bundle) {
            activity.setLocusContext(bVar == null ? null : bVar.b(), bundle);
        }
    }

    public static class h {
        public static boolean a(Activity activity) {
            return activity.isLaunchedFromBubble();
        }

        @SuppressLint({"BanUncheckedReflection"})
        public static boolean b(Activity activity, String str) {
            try {
                PackageManager packageManager = activity.getApplication().getPackageManager();
                return ((Boolean) PackageManager.class.getMethod("shouldShowRequestPermissionRationale", new Class[]{String.class}).invoke(packageManager, new Object[]{str})).booleanValue();
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                return activity.shouldShowRequestPermissionRationale(str);
            }
        }
    }

    public static class i {
        public static boolean a(Activity activity, String str) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
    }

    public interface j {
        void onRequestPermissionsResult(int i11, String[] strArr, int[] iArr);
    }

    public interface k {
        boolean a(Activity activity, String[] strArr, int i11);
    }

    public interface l {
        void validateRequestPermissionsRequestCode(int i11);
    }

    public static class m extends SharedElementCallback {

        /* renamed from: a  reason: collision with root package name */
        public final SharedElementCallback f8140a;

        public m(SharedElementCallback sharedElementCallback) {
            this.f8140a = sharedElementCallback;
        }

        public Parcelable onCaptureSharedElementSnapshot(View view, Matrix matrix, RectF rectF) {
            return this.f8140a.b(view, matrix, rectF);
        }

        public View onCreateSnapshotView(Context context, Parcelable parcelable) {
            return this.f8140a.c(context, parcelable);
        }

        public void onMapSharedElements(List<String> list, Map<String, View> map) {
            this.f8140a.d(list, map);
        }

        public void onRejectSharedElements(List<View> list) {
            this.f8140a.e(list);
        }

        public void onSharedElementEnd(List<String> list, List<View> list2, List<View> list3) {
            this.f8140a.f(list, list2, list3);
        }

        public void onSharedElementStart(List<String> list, List<View> list2, List<View> list3) {
            this.f8140a.g(list, list2, list3);
        }

        public void onSharedElementsArrived(List<String> list, List<View> list2, SharedElementCallback.OnSharedElementsReadyListener onSharedElementsReadyListener) {
            this.f8140a.h(list, list2, new p0.b(onSharedElementsReadyListener));
        }
    }

    public static void finishAffinity(Activity activity) {
        if (Build.VERSION.SDK_INT >= 16) {
            b.a(activity);
        } else {
            activity.finish();
        }
    }

    public static void finishAfterTransition(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            c.a(activity);
        } else {
            activity.finish();
        }
    }

    public static k getPermissionCompatDelegate() {
        return sDelegate;
    }

    public static Uri getReferrer(Activity activity) {
        if (Build.VERSION.SDK_INT >= 22) {
            return d.a(activity);
        }
        Intent intent = activity.getIntent();
        Uri uri = (Uri) intent.getParcelableExtra("android.intent.extra.REFERRER");
        if (uri != null) {
            return uri;
        }
        String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
        if (stringExtra != null) {
            return Uri.parse(stringExtra);
        }
        return null;
    }

    @Deprecated
    public static boolean invalidateOptionsMenu(Activity activity) {
        activity.invalidateOptionsMenu();
        return true;
    }

    public static boolean isLaunchedFromBubble(Activity activity) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 31) {
            return h.a(activity);
        }
        if (i11 == 30) {
            if (g.a(activity) == null || g.a(activity).getDisplayId() == 0) {
                return false;
            }
            return true;
        } else if (i11 != 29) {
            return false;
        } else {
            if (activity.getWindowManager().getDefaultDisplay() == null || activity.getWindowManager().getDefaultDisplay().getDisplayId() == 0) {
                return false;
            }
            return true;
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$recreate$0(Activity activity) {
        if (!activity.isFinishing() && !p0.d.i(activity)) {
            activity.recreate();
        }
    }

    public static void postponeEnterTransition(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            c.b(activity);
        }
    }

    public static void recreate(Activity activity) {
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
        } else {
            new Handler(activity.getMainLooper()).post(new p0.a(activity));
        }
    }

    public static androidx.core.view.d requestDragAndDropPermissions(Activity activity, DragEvent dragEvent) {
        return androidx.core.view.d.a(activity, dragEvent);
    }

    public static void requestPermissions(Activity activity, String[] strArr, int i11) {
        k kVar = sDelegate;
        if (kVar == null || !kVar.a(activity, strArr, i11)) {
            HashSet hashSet = new HashSet();
            int i12 = 0;
            while (i12 < strArr.length) {
                if (!TextUtils.isEmpty(strArr[i12])) {
                    if (Build.VERSION.SDK_INT < 33 && TextUtils.equals(strArr[i12], "android.permission.POST_NOTIFICATIONS")) {
                        hashSet.add(Integer.valueOf(i12));
                    }
                    i12++;
                } else {
                    throw new IllegalArgumentException("Permission request for permissions " + Arrays.toString(strArr) + " must not contain null or empty values");
                }
            }
            int size = hashSet.size();
            String[] strArr2 = size > 0 ? new String[(strArr.length - size)] : strArr;
            if (size > 0) {
                if (size != strArr.length) {
                    int i13 = 0;
                    for (int i14 = 0; i14 < strArr.length; i14++) {
                        if (!hashSet.contains(Integer.valueOf(i14))) {
                            strArr2[i13] = strArr[i14];
                            i13++;
                        }
                    }
                } else {
                    return;
                }
            }
            if (Build.VERSION.SDK_INT >= 23) {
                if (activity instanceof l) {
                    ((l) activity).validateRequestPermissionsRequestCode(i11);
                }
                e.b(activity, strArr, i11);
            } else if (activity instanceof j) {
                new Handler(Looper.getMainLooper()).post(new a(strArr2, activity, i11));
            }
        }
    }

    public static <T extends View> T requireViewById(Activity activity, int i11) {
        if (Build.VERSION.SDK_INT >= 28) {
            return (View) f.a(activity, i11);
        }
        T findViewById = activity.findViewById(i11);
        if (findViewById != null) {
            return findViewById;
        }
        throw new IllegalArgumentException("ID does not reference a View inside this Activity");
    }

    public static void setEnterSharedElementCallback(Activity activity, SharedElementCallback sharedElementCallback) {
        if (Build.VERSION.SDK_INT >= 21) {
            c.c(activity, sharedElementCallback != null ? new m(sharedElementCallback) : null);
        }
    }

    public static void setExitSharedElementCallback(Activity activity, SharedElementCallback sharedElementCallback) {
        if (Build.VERSION.SDK_INT >= 21) {
            c.d(activity, sharedElementCallback != null ? new m(sharedElementCallback) : null);
        }
    }

    public static void setLocusContext(Activity activity, q0.b bVar, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 30) {
            g.b(activity, bVar, bundle);
        }
    }

    public static void setPermissionCompatDelegate(k kVar) {
        sDelegate = kVar;
    }

    public static boolean shouldShowRequestPermissionRationale(Activity activity, String str) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 < 33 && TextUtils.equals("android.permission.POST_NOTIFICATIONS", str)) {
            return false;
        }
        if (i11 >= 32) {
            return i.a(activity, str);
        }
        if (i11 == 31) {
            return h.b(activity, str);
        }
        if (i11 >= 23) {
            return e.c(activity, str);
        }
        return false;
    }

    public static void startActivityForResult(Activity activity, Intent intent, int i11, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            b.b(activity, intent, i11, bundle);
        } else {
            activity.startActivityForResult(intent, i11);
        }
    }

    public static void startIntentSenderForResult(Activity activity, IntentSender intentSender, int i11, Intent intent, int i12, int i13, int i14, Bundle bundle) throws IntentSender.SendIntentException {
        if (Build.VERSION.SDK_INT >= 16) {
            b.c(activity, intentSender, i11, intent, i12, i13, i14, bundle);
        } else {
            activity.startIntentSenderForResult(intentSender, i11, intent, i12, i13, i14);
        }
    }

    public static void startPostponedEnterTransition(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            c.e(activity);
        }
    }
}
