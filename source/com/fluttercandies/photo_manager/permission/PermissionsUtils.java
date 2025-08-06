package com.fluttercandies.photo_manager.permission;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.core.app.ActivityCompat;
import io.flutter.plugin.common.MethodCall;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import x4.a;

public final class PermissionsUtils {

    /* renamed from: a  reason: collision with root package name */
    public Activity f65126a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f65127b;

    /* renamed from: c  reason: collision with root package name */
    public final List<String> f65128c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public final List<String> f65129d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public final List<String> f65130e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public int f65131f;

    /* renamed from: g  reason: collision with root package name */
    public a f65132g;

    public final boolean a(String... strArr) {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        i();
        int length = strArr.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (this.f65126a.checkSelfPermission(strArr[i11]) == -1) {
                this.f65128c.add(strArr[i11]);
            }
        }
        return this.f65128c.isEmpty();
    }

    public final PermissionsUtils b(int i11, String[] strArr, int[] iArr) {
        if (i11 == this.f65131f) {
            int length = strArr.length;
            for (int i12 = 0; i12 < length; i12++) {
                z4.a.d("Returned permissions: " + strArr[i12]);
                if (iArr[i12] == -1) {
                    this.f65129d.add(strArr[i12]);
                } else if (iArr[i12] == 0) {
                    this.f65130e.add(strArr[i12]);
                }
            }
            if (!this.f65129d.isEmpty()) {
                this.f65132g.a(this.f65129d, this.f65130e);
            } else {
                this.f65132g.onGranted();
            }
        }
        this.f65127b = false;
        return this;
    }

    public final void c(Context context) {
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.addFlags(1073741824);
        intent.addFlags(8388608);
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", context.getPackageName(), (String) null));
        context.startActivity(intent);
    }

    public final PermissionsUtils d(int i11, List<String> list) {
        String[] strArr = (String[]) list.toArray(new String[0]);
        return e(i11, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    @TargetApi(23)
    public final PermissionsUtils e(int i11, String... strArr) {
        Objects.requireNonNull(this.f65126a, "Activity for the permission request is not exist.");
        if (!this.f65127b) {
            this.f65127b = true;
            this.f65131f = i11;
            if (!a((String[]) Arrays.copyOf(strArr, strArr.length))) {
                ActivityCompat.requestPermissions(this.f65126a, (String[]) this.f65128c.toArray(new String[0]), i11);
                int size = this.f65128c.size();
                for (int i12 = 0; i12 < size; i12++) {
                    z4.a.d("Permissions: " + this.f65128c.get(i12));
                }
            } else {
                a aVar = this.f65132g;
                if (aVar != null) {
                    this.f65127b = false;
                    aVar.onGranted();
                }
            }
            return this;
        }
        throw new IllegalStateException("Another permission request is ongoing.".toString());
    }

    public final boolean f() {
        return this.f65127b;
    }

    public final boolean g(MethodCall methodCall) {
        String str = methodCall.method;
        if (str != null) {
            switch (str.hashCode()) {
                case -1283288098:
                    if (str.equals("getLatLngAndroidQ")) {
                        return true;
                    }
                    break;
                case -886445535:
                    if (str.equals("getFullFile") && ((Boolean) methodCall.argument("isOrigin")).booleanValue() && Build.VERSION.SDK_INT >= 29) {
                        return true;
                    }
                case 1063055279:
                    if (str.equals("getOriginBytes")) {
                        return true;
                    }
                    break;
                case 1477946491:
                    if (str.equals("copyAsset")) {
                        return true;
                    }
                    break;
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x004d A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean h(io.flutter.plugin.common.MethodCall r2) {
        /*
            r1 = this;
            java.lang.String r2 = r2.method
            if (r2 == 0) goto L_0x004d
            int r0 = r2.hashCode()
            switch(r0) {
                case -2060338679: goto L_0x0042;
                case -1793329916: goto L_0x0039;
                case -626940993: goto L_0x0030;
                case 163601886: goto L_0x0027;
                case 175491326: goto L_0x001e;
                case 1150344167: goto L_0x0015;
                case 1477946491: goto L_0x000c;
                default: goto L_0x000b;
            }
        L_0x000b:
            goto L_0x004d
        L_0x000c:
            java.lang.String r0 = "copyAsset"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L_0x004b
            goto L_0x004d
        L_0x0015:
            java.lang.String r0 = "deleteWithIds"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L_0x004b
            goto L_0x004d
        L_0x001e:
            java.lang.String r0 = "saveVideo"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L_0x004b
            goto L_0x004d
        L_0x0027:
            java.lang.String r0 = "saveImage"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L_0x004b
            goto L_0x004d
        L_0x0030:
            java.lang.String r0 = "moveAssetToPath"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L_0x004b
            goto L_0x004d
        L_0x0039:
            java.lang.String r0 = "removeNoExistsAssets"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x004d
            goto L_0x004b
        L_0x0042:
            java.lang.String r0 = "saveImageWithPath"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L_0x004b
            goto L_0x004d
        L_0x004b:
            r2 = 1
            goto L_0x004e
        L_0x004d:
            r2 = 0
        L_0x004e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fluttercandies.photo_manager.permission.PermissionsUtils.h(io.flutter.plugin.common.MethodCall):boolean");
    }

    public final void i() {
        if (!this.f65129d.isEmpty()) {
            this.f65129d.clear();
        }
        if (!this.f65128c.isEmpty()) {
            this.f65128c.clear();
        }
    }

    public final void j(a aVar) {
        this.f65132g = aVar;
    }

    public final PermissionsUtils k(Activity activity) {
        this.f65126a = activity;
        return this;
    }
}
