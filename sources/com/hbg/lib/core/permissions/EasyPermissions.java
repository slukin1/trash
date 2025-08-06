package com.hbg.lib.core.permissions;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.util.Log;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EasyPermissions {
    private static final String TAG = "EasyPermissions";

    public interface PermissionCallbacks extends ActivityCompat.j {
        void onPermissionsDenied(int i11, List<String> list);

        void onPermissionsGranted(int i11, List<String> list);

        /* synthetic */ void onRequestPermissionsResult(int i11, String[] strArr, int[] iArr);
    }

    private static void checkCallingObjectSuitability(Object obj) {
        boolean z11 = obj instanceof Activity;
        boolean z12 = obj instanceof Fragment;
        boolean z13 = obj instanceof android.app.Fragment;
        boolean z14 = Build.VERSION.SDK_INT >= 23;
        if (!z12 && !z11) {
            if (z13 && z14) {
                return;
            }
            if (z13) {
                throw new IllegalArgumentException("Target SDK needs to be greater than 23 if caller is android.app.Fragment");
            }
            throw new IllegalArgumentException("Caller must be an Activity or a Fragment.");
        }
    }

    /* access modifiers changed from: private */
    @TargetApi(23)
    public static void executePermissionsRequest(Object obj, String[] strArr, int i11) {
        checkCallingObjectSuitability(obj);
        if (obj instanceof Activity) {
            ActivityCompat.requestPermissions((Activity) obj, strArr, i11);
        } else if (obj instanceof Fragment) {
            ((Fragment) obj).requestPermissions(strArr, i11);
        } else if (obj instanceof android.app.Fragment) {
            ((android.app.Fragment) obj).requestPermissions(strArr, i11);
        }
    }

    @TargetApi(11)
    private static Activity getActivity(Object obj) {
        if (obj instanceof Activity) {
            return (Activity) obj;
        }
        if (obj instanceof Fragment) {
            return ((Fragment) obj).getActivity();
        }
        if (obj instanceof android.app.Fragment) {
            return ((android.app.Fragment) obj).getActivity();
        }
        return null;
    }

    public static boolean hasPermissions(Context context, String... strArr) {
        if (Build.VERSION.SDK_INT < 23) {
            Log.w(TAG, "hasPermissions: API version < M, returning true by default");
            return true;
        }
        int length = strArr.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (!(ContextCompat.checkSelfPermission(context, strArr[i11]) == 0)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isUsingAndroidAnnotations(Object obj) {
        if (!obj.getClass().getSimpleName().endsWith("_")) {
            return false;
        }
        try {
            return Class.forName("org.androidannotations.api.view.HasViews").isInstance(obj);
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static void onRequestPermissionsResult(int i11, String[] strArr, int[] iArr, Object... objArr) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i12 = 0; i12 < strArr.length; i12++) {
            String str = strArr[i12];
            if (iArr[i12] == 0) {
                arrayList.add(str);
            } else {
                arrayList2.add(str);
            }
        }
        for (PermissionCallbacks permissionCallbacks : objArr) {
            if (!arrayList.isEmpty() && (permissionCallbacks instanceof PermissionCallbacks)) {
                permissionCallbacks.onPermissionsGranted(i11, arrayList);
            }
            if (!arrayList2.isEmpty() && (permissionCallbacks instanceof PermissionCallbacks)) {
                permissionCallbacks.onPermissionsDenied(i11, arrayList2);
            }
            if (!arrayList.isEmpty() && arrayList2.isEmpty()) {
                runAnnotatedMethods(permissionCallbacks, i11);
            }
        }
    }

    public static boolean permissionPermanentlyDenied(Object obj, String str) {
        return !shouldShowRequestPermissionRationale(obj, str);
    }

    public static void requestPermissions(Object obj, String str, int i11, String... strArr) {
        requestPermissions(obj, str, 17039370, 17039360, i11, strArr);
    }

    private static void runAnnotatedMethods(Object obj, int i11) {
        Class cls = obj.getClass();
        if (isUsingAndroidAnnotations(obj)) {
            cls = cls.getSuperclass();
        }
        for (Method method : cls.getDeclaredMethods()) {
            if (method.isAnnotationPresent(AfterPermissionGranted.class) && ((AfterPermissionGranted) method.getAnnotation(AfterPermissionGranted.class)).value() == i11) {
                if (method.getParameterTypes().length <= 0) {
                    try {
                        if (!method.isAccessible()) {
                            method.setAccessible(true);
                        }
                        method.invoke(obj, new Object[0]);
                    } catch (IllegalAccessException e11) {
                        Log.e(TAG, "runDefaultMethod:IllegalAccessException", e11);
                    } catch (InvocationTargetException e12) {
                        Log.e(TAG, "runDefaultMethod:InvocationTargetException", e12);
                    }
                } else {
                    throw new RuntimeException("Cannot execute non-void method " + method.getName());
                }
            }
        }
    }

    @TargetApi(23)
    public static boolean shouldShowRequestPermissionRationale(Object obj, String str) {
        if (obj instanceof Activity) {
            return ActivityCompat.shouldShowRequestPermissionRationale((Activity) obj, str);
        }
        if (obj instanceof Fragment) {
            return ((Fragment) obj).shouldShowRequestPermissionRationale(str);
        }
        if (obj instanceof android.app.Fragment) {
            return ((android.app.Fragment) obj).shouldShowRequestPermissionRationale(str);
        }
        return false;
    }

    public static boolean somePermissionPermanentlyDenied(Object obj, List<String> list) {
        for (String permissionPermanentlyDenied : list) {
            if (permissionPermanentlyDenied(obj, permissionPermanentlyDenied)) {
                return true;
            }
        }
        return false;
    }

    public static void requestPermissions(Object obj, int i11, String... strArr) {
        checkCallingObjectSuitability(obj);
        boolean z11 = false;
        for (String shouldShowRequestPermissionRationale : strArr) {
            z11 = z11 || shouldShowRequestPermissionRationale(obj, shouldShowRequestPermissionRationale);
        }
        if (!z11) {
            executePermissionsRequest(obj, strArr, i11);
        } else if (getActivity(obj) != null) {
            executePermissionsRequest(obj, strArr, i11);
        }
    }

    public static void requestPermissions(final Object obj, String str, int i11, int i12, final int i13, final String... strArr) {
        checkCallingObjectSuitability(obj);
        boolean z11 = false;
        for (String shouldShowRequestPermissionRationale : strArr) {
            z11 = z11 || shouldShowRequestPermissionRationale(obj, shouldShowRequestPermissionRationale);
        }
        if (z11) {
            Activity activity = getActivity(obj);
            if (activity != null) {
                new AlertDialog.a(activity).setMessage((CharSequence) str).setPositiveButton(i11, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    @SensorsDataInstrumented
                    public void onClick(DialogInterface dialogInterface, int i11) {
                        EasyPermissions.executePermissionsRequest(obj, strArr, i13);
                        SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i11);
                    }
                }).setNegativeButton(i12, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    @SensorsDataInstrumented
                    public void onClick(DialogInterface dialogInterface, int i11) {
                        Object obj = obj;
                        if (obj instanceof PermissionCallbacks) {
                            ((PermissionCallbacks) obj).onPermissionsDenied(i13, Arrays.asList(strArr));
                        }
                        SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i11);
                    }
                }).create().show();
                return;
            }
            return;
        }
        executePermissionsRequest(obj, strArr, i13);
    }
}
