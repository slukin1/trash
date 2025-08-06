package com.fluttercandies.photo_manager.core;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.fluttercandies.photo_manager.core.entity.FilterOption;
import com.fluttercandies.photo_manager.core.entity.PermissionResult;
import com.fluttercandies.photo_manager.permission.PermissionsUtils;
import com.tencent.qcloud.tuicore.TUIConstants;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import z4.e;

public final class PhotoManagerPlugin implements MethodChannel.MethodCallHandler {

    /* renamed from: i  reason: collision with root package name */
    public static final b f65019i = new b((r) null);

    /* renamed from: j  reason: collision with root package name */
    public static final ThreadPoolExecutor f65020j = new ThreadPoolExecutor(8, Integer.MAX_VALUE, 1, TimeUnit.MINUTES, new LinkedBlockingQueue());

    /* renamed from: b  reason: collision with root package name */
    public final Context f65021b;

    /* renamed from: c  reason: collision with root package name */
    public Activity f65022c;

    /* renamed from: d  reason: collision with root package name */
    public final PermissionsUtils f65023d;

    /* renamed from: e  reason: collision with root package name */
    public final PhotoManagerDeleteManager f65024e;

    /* renamed from: f  reason: collision with root package name */
    public final c f65025f;

    /* renamed from: g  reason: collision with root package name */
    public final b f65026g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f65027h;

    public static final class a implements x4.a {
        public void a(List<String> list, List<String> list2) {
        }

        public void onGranted() {
        }
    }

    public static final class b {
        public b() {
        }

        public /* synthetic */ b(r rVar) {
            this();
        }

        public static final void c(d10.a aVar) {
            aVar.invoke();
        }

        public final void b(d10.a<Unit> aVar) {
            PhotoManagerPlugin.f65020j.execute(new d(aVar));
        }
    }

    public static final class c implements x4.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MethodCall f65028a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PhotoManagerPlugin f65029b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f65030c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ ArrayList<String> f65031d;

        public c(MethodCall methodCall, PhotoManagerPlugin photoManagerPlugin, e eVar, ArrayList<String> arrayList) {
            this.f65028a = methodCall;
            this.f65029b = photoManagerPlugin;
            this.f65030c = eVar;
            this.f65031d = arrayList;
        }

        public void a(List<String> list, List<String> list2) {
            z4.a.d("onDenied call.method = " + this.f65028a.method);
            if (x.b(this.f65028a.method, "requestPermissionExtend")) {
                this.f65030c.h(Integer.valueOf(PermissionResult.Denied.getValue()));
            } else if (list2.containsAll(this.f65031d)) {
                z4.a.d("onGranted call.method = " + this.f65028a.method);
                this.f65029b.o(this.f65028a, this.f65030c, false);
            } else {
                this.f65029b.p(this.f65030c);
            }
        }

        public void onGranted() {
            z4.a.d("onGranted call.method = " + this.f65028a.method);
            this.f65029b.o(this.f65028a, this.f65030c, true);
        }
    }

    public PhotoManagerPlugin(Context context, BinaryMessenger binaryMessenger, Activity activity, PermissionsUtils permissionsUtils) {
        this.f65021b = context;
        this.f65022c = activity;
        this.f65023d = permissionsUtils;
        permissionsUtils.j(new a());
        this.f65024e = new PhotoManagerDeleteManager(context, this.f65022c);
        this.f65025f = new c(context, binaryMessenger, new Handler(Looper.getMainLooper()));
        this.f65026g = new b(context);
    }

    public final void i(Activity activity) {
        this.f65022c = activity;
        this.f65024e.a(activity);
    }

    public final PhotoManagerDeleteManager j() {
        return this.f65024e;
    }

    public final int k(MethodCall methodCall, String str) {
        return ((Number) methodCall.argument(str)).intValue();
    }

    public final FilterOption l(MethodCall methodCall) {
        return com.fluttercandies.photo_manager.core.utils.b.f65118a.a((Map) methodCall.argument(TUIConstants.TUIPoll.PLUGIN_POLL_OPTION_CONTENT));
    }

    public final String m(MethodCall methodCall, String str) {
        return (String) methodCall.argument(str);
    }

    public final boolean n(Context context, String str) {
        return ArraysKt___ArraysKt.C(context.getPackageManager().getPackageInfo(context.getApplicationInfo().packageName, 4096).requestedPermissions, str);
    }

    public final void o(MethodCall methodCall, e eVar, boolean z11) {
        String str = methodCall.method;
        if (str != null) {
            switch (str.hashCode()) {
                case -2060338679:
                    if (str.equals("saveImageWithPath")) {
                        f65019i.b(new PhotoManagerPlugin$onHandlePermissionResult$16(methodCall, this, eVar));
                        return;
                    }
                    break;
                case -1793329916:
                    if (str.equals("removeNoExistsAssets")) {
                        f65019i.b(new PhotoManagerPlugin$onHandlePermissionResult$21(this, eVar));
                        return;
                    }
                    break;
                case -1283288098:
                    if (str.equals("getLatLngAndroidQ")) {
                        f65019i.b(new PhotoManagerPlugin$onHandlePermissionResult$13(methodCall, this, eVar));
                        return;
                    }
                    break;
                case -1039689911:
                    if (str.equals(TUIConstants.TUIGroupNote.PLUGIN_GROUP_NOTE_ENABLE_NOTIFICATION)) {
                        f65019i.b(new PhotoManagerPlugin$onHandlePermissionResult$14(methodCall, this));
                        return;
                    }
                    break;
                case -948382752:
                    if (str.equals("requestCacheAssetsThumb")) {
                        f65019i.b(new PhotoManagerPlugin$onHandlePermissionResult$5(methodCall, this, eVar));
                        return;
                    }
                    break;
                case -886445535:
                    if (str.equals("getFullFile")) {
                        f65019i.b(new PhotoManagerPlugin$onHandlePermissionResult$8(methodCall, z11, this, eVar));
                        return;
                    }
                    break;
                case -626940993:
                    if (str.equals("moveAssetToPath")) {
                        f65019i.b(new PhotoManagerPlugin$onHandlePermissionResult$19(methodCall, this, eVar));
                        return;
                    }
                    break;
                case -151967598:
                    if (str.equals("fetchPathProperties")) {
                        f65019i.b(new PhotoManagerPlugin$onHandlePermissionResult$12(methodCall, this, eVar));
                        return;
                    }
                    break;
                case 163601886:
                    if (str.equals("saveImage")) {
                        f65019i.b(new PhotoManagerPlugin$onHandlePermissionResult$15(methodCall, this, eVar));
                        return;
                    }
                    break;
                case 175491326:
                    if (str.equals("saveVideo")) {
                        f65019i.b(new PhotoManagerPlugin$onHandlePermissionResult$17(methodCall, this, eVar));
                        return;
                    }
                    break;
                case 594039295:
                    if (str.equals("getAssetListWithRange")) {
                        f65019i.b(new PhotoManagerPlugin$onHandlePermissionResult$3(this, methodCall, eVar));
                        return;
                    }
                    break;
                case 857200492:
                    if (str.equals("assetExists")) {
                        f65019i.b(new PhotoManagerPlugin$onHandlePermissionResult$7(methodCall, this, eVar));
                        return;
                    }
                    break;
                case 972925196:
                    if (str.equals("cancelCacheRequests")) {
                        f65019i.b(new PhotoManagerPlugin$onHandlePermissionResult$6(this));
                        return;
                    }
                    break;
                case 1063055279:
                    if (str.equals("getOriginBytes")) {
                        f65019i.b(new PhotoManagerPlugin$onHandlePermissionResult$9(methodCall, this, eVar));
                        return;
                    }
                    break;
                case 1150344167:
                    if (str.equals("deleteWithIds")) {
                        f65019i.b(new PhotoManagerPlugin$onHandlePermissionResult$20(methodCall, this, eVar));
                        return;
                    }
                    break;
                case 1177116769:
                    if (str.equals("getMediaUrl")) {
                        f65019i.b(new PhotoManagerPlugin$onHandlePermissionResult$10(methodCall, this, eVar));
                        return;
                    }
                    break;
                case 1477946491:
                    if (str.equals("copyAsset")) {
                        f65019i.b(new PhotoManagerPlugin$onHandlePermissionResult$18(methodCall, this, eVar));
                        return;
                    }
                    break;
                case 1505159642:
                    if (str.equals("getGalleryList")) {
                        if (Build.VERSION.SDK_INT >= 29) {
                            this.f65025f.f(true);
                        }
                        f65019i.b(new PhotoManagerPlugin$onHandlePermissionResult$1(methodCall, this, eVar));
                        return;
                    }
                    break;
                case 1642188493:
                    if (str.equals("getAssetWithGalleryId")) {
                        f65019i.b(new PhotoManagerPlugin$onHandlePermissionResult$2(methodCall, this, eVar));
                        return;
                    }
                    break;
                case 1787503744:
                    if (str.equals("getPropertiesFromAssetEntity")) {
                        f65019i.b(new PhotoManagerPlugin$onHandlePermissionResult$11(methodCall, this, eVar));
                        return;
                    }
                    break;
                case 1966168096:
                    if (str.equals("getThumb")) {
                        f65019i.b(new PhotoManagerPlugin$onHandlePermissionResult$4(methodCall, this, eVar));
                        return;
                    }
                    break;
                case 1971966584:
                    if (str.equals("requestPermissionExtend")) {
                        eVar.h(Integer.valueOf(PermissionResult.Authorized.getValue()));
                        return;
                    }
                    break;
            }
        }
        eVar.f();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00e1, code lost:
        r4 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMethodCall(io.flutter.plugin.common.MethodCall r8, io.flutter.plugin.common.MethodChannel.Result r9) {
        /*
            r7 = this;
            z4.e r0 = new z4.e
            r0.<init>(r9, r8)
            int r9 = android.os.Build.VERSION.SDK_INT
            r1 = 0
            r2 = 29
            if (r9 != r2) goto L_0x001a
            boolean r3 = android.os.Environment.isExternalStorageLegacy()
            if (r3 != 0) goto L_0x001a
            java.lang.String r8 = "STORAGE_NOT_LEGACY"
            java.lang.String r9 = "Use `requestLegacyExternalStorage` when your project is targeting above Android Q."
            r0.j(r8, r9, r1)
            return
        L_0x001a:
            java.lang.String r3 = r8.method
            java.lang.String r4 = "ignorePermissionCheck"
            boolean r3 = kotlin.jvm.internal.x.b(r3, r4)
            if (r3 == 0) goto L_0x003a
            java.lang.String r9 = "ignore"
            java.lang.Object r8 = r8.argument(r9)
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            r7.f65027h = r8
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)
            r0.h(r8)
            return
        L_0x003a:
            java.lang.String r3 = r8.method
            r4 = 0
            r5 = 1
            if (r3 == 0) goto L_0x00e2
            int r6 = r3.hashCode()
            switch(r6) {
                case -1914421335: goto L_0x00d0;
                case -582375106: goto L_0x00ba;
                case 107332: goto L_0x0097;
                case 1252395988: goto L_0x0081;
                case 1541932953: goto L_0x0063;
                case 1789114534: goto L_0x0049;
                default: goto L_0x0047;
            }
        L_0x0047:
            goto L_0x00e2
        L_0x0049:
            java.lang.String r6 = "openSetting"
            boolean r3 = r3.equals(r6)
            if (r3 != 0) goto L_0x0053
            goto L_0x00e2
        L_0x0053:
            com.fluttercandies.photo_manager.permission.PermissionsUtils r3 = r7.f65023d
            android.app.Activity r4 = r7.f65022c
            r3.c(r4)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r5)
            r0.h(r3)
            goto L_0x00e1
        L_0x0063:
            java.lang.String r6 = "clearFileCache"
            boolean r3 = r3.equals(r6)
            if (r3 != 0) goto L_0x006d
            goto L_0x00e2
        L_0x006d:
            android.content.Context r3 = r7.f65021b
            com.bumptech.glide.a r3 = com.bumptech.glide.a.d(r3)
            r3.c()
            com.fluttercandies.photo_manager.core.PhotoManagerPlugin$b r3 = f65019i
            com.fluttercandies.photo_manager.core.PhotoManagerPlugin$onMethodCall$handleResult$1 r4 = new com.fluttercandies.photo_manager.core.PhotoManagerPlugin$onMethodCall$handleResult$1
            r4.<init>(r7, r0)
            r3.b(r4)
            goto L_0x00e1
        L_0x0081:
            java.lang.String r6 = "releaseMemCache"
            boolean r3 = r3.equals(r6)
            if (r3 != 0) goto L_0x008a
            goto L_0x00e2
        L_0x008a:
            com.fluttercandies.photo_manager.core.b r3 = r7.f65026g
            r3.d()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r5)
            r0.h(r3)
            goto L_0x00e1
        L_0x0097:
            java.lang.String r6 = "log"
            boolean r3 = r3.equals(r6)
            if (r3 != 0) goto L_0x00a0
            goto L_0x00e2
        L_0x00a0:
            z4.a r3 = z4.a.f66723a
            java.lang.Object r6 = r8.arguments()
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            if (r6 != 0) goto L_0x00ab
            goto L_0x00af
        L_0x00ab:
            boolean r4 = r6.booleanValue()
        L_0x00af:
            r3.g(r4)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r5)
            r0.h(r3)
            goto L_0x00e1
        L_0x00ba:
            java.lang.String r6 = "forceOldApi"
            boolean r3 = r3.equals(r6)
            if (r3 != 0) goto L_0x00c3
            goto L_0x00e2
        L_0x00c3:
            com.fluttercandies.photo_manager.core.b r3 = r7.f65026g
            r3.z(r5)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r5)
            r0.h(r3)
            goto L_0x00e1
        L_0x00d0:
            java.lang.String r6 = "systemVersion"
            boolean r3 = r3.equals(r6)
            if (r3 != 0) goto L_0x00da
            goto L_0x00e2
        L_0x00da:
            java.lang.String r3 = java.lang.String.valueOf(r9)
            r0.h(r3)
        L_0x00e1:
            r4 = r5
        L_0x00e2:
            if (r4 == 0) goto L_0x00e5
            return
        L_0x00e5:
            boolean r3 = r7.f65027h
            if (r3 == 0) goto L_0x00ed
            r7.o(r8, r0, r5)
            return
        L_0x00ed:
            com.fluttercandies.photo_manager.permission.PermissionsUtils r3 = r7.f65023d
            boolean r3 = r3.f()
            if (r3 == 0) goto L_0x00fd
            java.lang.String r8 = "PERMISSION_REQUESTING"
            java.lang.String r9 = "Another permission request is still ongoing. Please request after the existing one is done."
            r0.j(r8, r9, r1)
            return
        L_0x00fd:
            com.fluttercandies.photo_manager.permission.PermissionsUtils r1 = r7.f65023d
            boolean r1 = r1.h(r8)
            com.fluttercandies.photo_manager.permission.PermissionsUtils r3 = r7.f65023d
            boolean r3 = r3.g(r8)
            java.lang.String r4 = "android.permission.READ_EXTERNAL_STORAGE"
            java.lang.String[] r4 = new java.lang.String[]{r4}
            java.util.ArrayList r4 = kotlin.collections.CollectionsKt__CollectionsKt.g(r4)
            if (r1 == 0) goto L_0x0124
            if (r9 > r2) goto L_0x0124
            android.content.Context r1 = r7.f65021b
            java.lang.String r5 = "android.permission.WRITE_EXTERNAL_STORAGE"
            boolean r1 = r7.n(r1, r5)
            if (r1 == 0) goto L_0x0124
            r4.add(r5)
        L_0x0124:
            if (r3 == 0) goto L_0x0135
            if (r9 < r2) goto L_0x0135
            android.content.Context r9 = r7.f65021b
            java.lang.String r1 = "android.permission.ACCESS_MEDIA_LOCATION"
            boolean r9 = r7.n(r9, r1)
            if (r9 == 0) goto L_0x0135
            r4.add(r1)
        L_0x0135:
            com.fluttercandies.photo_manager.permission.PermissionsUtils r9 = r7.f65023d
            android.app.Activity r1 = r7.f65022c
            r9.k(r1)
            com.fluttercandies.photo_manager.core.PhotoManagerPlugin$c r1 = new com.fluttercandies.photo_manager.core.PhotoManagerPlugin$c
            r1.<init>(r8, r7, r0, r4)
            r9.j(r1)
            r8 = 3001(0xbb9, float:4.205E-42)
            r9.d(r8, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fluttercandies.photo_manager.core.PhotoManagerPlugin.onMethodCall(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
    }

    public final void p(e eVar) {
        eVar.j("Request for permission failed.", "User denied permission.", (Object) null);
    }
}
