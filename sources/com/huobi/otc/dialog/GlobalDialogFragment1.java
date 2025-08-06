package com.huobi.otc.dialog;

import ad.b;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.core.permissions.EasyPermissions;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.hbg.module.otc.R$string;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import dp.h;
import dp.i;
import dp.j;
import i6.r;
import java.util.List;
import u6.g;

public class GlobalDialogFragment1 extends BaseDialogFragment implements EasyPermissions.PermissionCallbacks {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f78290b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f78291c;

    /* renamed from: d  reason: collision with root package name */
    public String f78292d;

    /* renamed from: e  reason: collision with root package name */
    public Bitmap f78293e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f78294f;

    /* renamed from: g  reason: collision with root package name */
    public g f78295g;

    /* renamed from: h  reason: collision with root package name */
    public float f78296h;

    /* renamed from: i  reason: collision with root package name */
    public a f78297i;

    public interface a {
        void a();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        Ah();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$1(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void xh() {
        ViewGroup.LayoutParams layoutParams = this.f78290b.getLayoutParams();
        layoutParams.height = (int) (this.f78296h * ((float) this.f78290b.getWidth()));
        this.f78290b.setLayoutParams(layoutParams);
    }

    public static /* synthetic */ void yh(String str, Uri uri) {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void zh(HBDialogFragment hBDialogFragment) {
        if (!isAdded()) {
            hBDialogFragment.dismiss();
            return;
        }
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", BaseApplication.b().getPackageName(), (String) null));
        startActivity(intent);
        hBDialogFragment.dismiss();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0022, code lost:
        if (r2 == null) goto L_0x002e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0024, code lost:
        r2.recycle();
        r7.f78293e = null;
        r7.f78290b.setImageBitmap((android.graphics.Bitmap) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0032, code lost:
        if (android.os.Build.VERSION.SDK_INT < 33) goto L_0x003b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0034, code lost:
        r2 = new java.lang.String[]{com.luck.picture.lib.permissions.PermissionConfig.READ_MEDIA_IMAGES};
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003b, code lost:
        r2 = new java.lang.String[]{com.luck.picture.lib.permissions.PermissionConfig.READ_EXTERNAL_STORAGE, com.luck.picture.lib.permissions.PermissionConfig.WRITE_EXTERNAL_STORAGE};
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004c, code lost:
        if (com.hbg.lib.core.permissions.EasyPermissions.hasPermissions(getActivity(), r2) == false) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004e, code lost:
        android.media.MediaScannerConnection.scanFile(getActivity(), new java.lang.String[]{r7.f78292d}, (java.lang.String[]) null, dp.f.f53873a);
        com.hbg.lib.widgets.utils.HuobiToastUtil.s(com.hbg.module.otc.R$string.save_success);
        dismiss();
        r0 = r7.f78297i;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0067, code lost:
        if (r0 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0069, code lost:
        r0.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006d, code lost:
        r1 = r2.length;
        r3 = 0;
        r5 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0070, code lost:
        if (r3 >= r1) goto L_0x0083;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0072, code lost:
        r6 = r2[r3];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0074, code lost:
        if (r5 != false) goto L_0x007f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007a, code lost:
        if (com.hbg.lib.core.permissions.EasyPermissions.shouldShowRequestPermissionRationale(r7, r6) == false) goto L_0x007d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x007d, code lost:
        r5 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x007f, code lost:
        r5 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0080, code lost:
        r3 = r3 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0083, code lost:
        if (r5 != false) goto L_0x0089;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0085, code lost:
        Bh();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0089, code lost:
        com.hbg.lib.core.permissions.EasyPermissions.requestPermissions(r7, 126, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0016, code lost:
        if (r2 != null) goto L_0x0024;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Ah() {
        /*
            r7 = this;
            r0 = 1
            r1 = 0
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ Exception -> 0x001c }
            java.lang.String r3 = r2.name()     // Catch:{ Exception -> 0x001c }
            java.io.File r3 = com.hbg.lib.common.utils.FileUtil.f(r3, r0)     // Catch:{ Exception -> 0x001c }
            android.graphics.Bitmap r4 = r7.f78293e     // Catch:{ Exception -> 0x001c }
            java.lang.String r2 = com.huobi.utils.ImageUtils.h(r4, r2, r3)     // Catch:{ Exception -> 0x001c }
            r7.f78292d = r2     // Catch:{ Exception -> 0x001c }
            android.graphics.Bitmap r2 = r7.f78293e
            if (r2 == 0) goto L_0x002e
            goto L_0x0024
        L_0x0019:
            r0 = move-exception
            goto L_0x008f
        L_0x001c:
            r2 = move-exception
            i6.d.g(r2)     // Catch:{ all -> 0x0019 }
            android.graphics.Bitmap r2 = r7.f78293e
            if (r2 == 0) goto L_0x002e
        L_0x0024:
            r2.recycle()
            r7.f78293e = r1
            android.widget.ImageView r2 = r7.f78290b
            r2.setImageBitmap(r1)
        L_0x002e:
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 33
            if (r2 < r3) goto L_0x003b
            java.lang.String r2 = "android.permission.READ_MEDIA_IMAGES"
            java.lang.String[] r2 = new java.lang.String[]{r2}
            goto L_0x0043
        L_0x003b:
            java.lang.String r2 = "android.permission.READ_EXTERNAL_STORAGE"
            java.lang.String r3 = "android.permission.WRITE_EXTERNAL_STORAGE"
            java.lang.String[] r2 = new java.lang.String[]{r2, r3}
        L_0x0043:
            androidx.fragment.app.FragmentActivity r3 = r7.getActivity()
            boolean r3 = com.hbg.lib.core.permissions.EasyPermissions.hasPermissions(r3, r2)
            r4 = 0
            if (r3 == 0) goto L_0x006d
            androidx.fragment.app.FragmentActivity r2 = r7.getActivity()
            java.lang.String[] r0 = new java.lang.String[r0]
            java.lang.String r3 = r7.f78292d
            r0[r4] = r3
            dp.f r3 = dp.f.f53873a
            android.media.MediaScannerConnection.scanFile(r2, r0, r1, r3)
            int r0 = com.hbg.module.otc.R$string.save_success
            com.hbg.lib.widgets.utils.HuobiToastUtil.s(r0)
            r7.dismiss()
            com.huobi.otc.dialog.GlobalDialogFragment1$a r0 = r7.f78297i
            if (r0 == 0) goto L_0x008e
            r0.a()
            goto L_0x008e
        L_0x006d:
            int r1 = r2.length
            r3 = r4
            r5 = r3
        L_0x0070:
            if (r3 >= r1) goto L_0x0083
            r6 = r2[r3]
            if (r5 != 0) goto L_0x007f
            boolean r5 = com.hbg.lib.core.permissions.EasyPermissions.shouldShowRequestPermissionRationale(r7, r6)
            if (r5 == 0) goto L_0x007d
            goto L_0x007f
        L_0x007d:
            r5 = r4
            goto L_0x0080
        L_0x007f:
            r5 = r0
        L_0x0080:
            int r3 = r3 + 1
            goto L_0x0070
        L_0x0083:
            if (r5 != 0) goto L_0x0089
            r7.Bh()
            goto L_0x008e
        L_0x0089:
            r0 = 126(0x7e, float:1.77E-43)
            com.hbg.lib.core.permissions.EasyPermissions.requestPermissions(r7, r0, r2)
        L_0x008e:
            return
        L_0x008f:
            android.graphics.Bitmap r2 = r7.f78293e
            if (r2 == 0) goto L_0x009d
            r2.recycle()
            r7.f78293e = r1
            android.widget.ImageView r2 = r7.f78290b
            r2.setImageBitmap(r1)
        L_0x009d:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.otc.dialog.GlobalDialogFragment1.Ah():void");
    }

    public void Bh() {
        DialogUtils.c0(getActivity(), getResources().getString(R$string.share_content_tip), (String) null, getResources().getString(R$string.share_cancel), getResources().getString(R$string.share_ok), b.f3517a, new i(this));
    }

    public final void Ch() {
        TextView textView = this.f78291c;
        if (textView != null) {
            textView.setEnabled(this.f78294f);
        }
    }

    public void addEvent(r rVar) {
        this.f78291c.setOnClickListener(new h(this));
        rVar.b(R$id.id_global_dialog_close_btn).setOnClickListener(new dp.g(this));
    }

    public void afterInit() {
        Ch();
        Bitmap bitmap = this.f78293e;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f78290b.setImageBitmap(this.f78293e);
        }
        this.f78290b.post(new j(this));
    }

    public final void dismissProgressDialog() {
        g gVar = this.f78295g;
        if (gVar != null) {
            gVar.dismissProgressDialog();
        }
    }

    public int getContentViewResId() {
        return R$layout.global_dialog_1;
    }

    public int getGravity() {
        return 17;
    }

    public void initView(r rVar) {
        this.f78290b = (ImageView) rVar.b(R$id.id_global_dialog_image);
        this.f78291c = (TextView) rVar.b(R$id.id_global_dialog_btn);
    }

    public boolean isTransparent() {
        return false;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        dismissProgressDialog();
    }

    public void onPermissionsDenied(int i11, List<String> list) {
    }

    public void onPermissionsGranted(int i11, List<String> list) {
        Ah();
    }

    @Deprecated
    public void show(FragmentManager fragmentManager, String str) {
    }
}
