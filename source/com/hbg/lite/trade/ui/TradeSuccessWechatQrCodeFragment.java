package com.hbg.lite.trade.ui;

import ad.b;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import com.hbg.lib.common.utils.FileUtil;
import com.hbg.lib.core.permissions.EasyPermissions;
import com.hbg.lib.network.hbg.core.bean.WeChatGroupInfoBean;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.lite.R$id;
import com.hbg.lite.R$layout;
import com.hbg.lite.R$string;
import com.luck.picture.lib.permissions.PermissionConfig;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.d;
import i6.r;
import java.util.List;
import qb.e;
import qb.f;
import qb.h;
import qb.i;
import ra.c;
import u6.g;

public class TradeSuccessWechatQrCodeFragment extends BaseDialogFragment implements EasyPermissions.PermissionCallbacks {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f77542b;

    /* renamed from: c  reason: collision with root package name */
    public Button f77543c;

    /* renamed from: d  reason: collision with root package name */
    public Button f77544d;

    /* renamed from: e  reason: collision with root package name */
    public String f77545e;

    /* renamed from: f  reason: collision with root package name */
    public Bitmap f77546f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f77547g;

    /* renamed from: h  reason: collision with root package name */
    public g f77548h;

    /* renamed from: i  reason: collision with root package name */
    public float f77549i;

    /* renamed from: j  reason: collision with root package name */
    public WeChatGroupInfoBean f77550j;

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
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        WeChatGroupInfoBean weChatGroupInfoBean = this.f77550j;
        if (weChatGroupInfoBean == null || TextUtils.isEmpty(weChatGroupInfoBean.getWxCode())) {
            HuobiToastUtil.t(view.getContext(), R$string.n_otc_copy_failure);
        } else {
            ((ClipboardManager) view.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(this.f77550j.getWxCode(), this.f77550j.getWxCode()));
            HuobiToastUtil.t(view.getContext(), R$string.n_otc_copy_success);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$afterInit$4() {
        ViewGroup.LayoutParams layoutParams = this.f77542b.getLayoutParams();
        layoutParams.height = (int) (this.f77549i * ((float) this.f77542b.getWidth()));
        this.f77542b.setLayoutParams(layoutParams);
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
        intent.setData(Uri.fromParts("package", c.c().s().getPackageName(), (String) null));
        startActivity(intent);
        hBDialogFragment.dismiss();
    }

    public final void Ah() {
        String[] strArr;
        try {
            Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.PNG;
            this.f77545e = c.c().f(this.f77546f, compressFormat, FileUtil.f(compressFormat.name(), true));
        } catch (Exception e11) {
            d.g(e11);
        }
        if (Build.VERSION.SDK_INT >= 33) {
            strArr = new String[]{PermissionConfig.READ_MEDIA_IMAGES};
        } else {
            strArr = new String[]{PermissionConfig.READ_EXTERNAL_STORAGE, PermissionConfig.WRITE_EXTERNAL_STORAGE};
        }
        if (EasyPermissions.hasPermissions(getActivity(), strArr)) {
            MediaScannerConnection.scanFile(getActivity(), new String[]{this.f77545e}, (String[]) null, qb.d.f53320a);
            HuobiToastUtil.s(R$string.save_success);
            return;
        }
        boolean z11 = false;
        for (String shouldShowRequestPermissionRationale : strArr) {
            z11 = z11 || EasyPermissions.shouldShowRequestPermissionRationale(this, shouldShowRequestPermissionRationale);
        }
        if (!z11) {
            Bh();
        } else {
            EasyPermissions.requestPermissions(this, 126, strArr);
        }
    }

    public void Bh() {
        DialogUtils.c0(getActivity(), getResources().getString(R$string.share_content_tip), (String) null, getResources().getString(R$string.share_cancel), getResources().getString(R$string.share_ok), b.f3517a, new h(this));
    }

    public final void Ch() {
        Button button = this.f77543c;
        if (button != null) {
            button.setEnabled(this.f77547g);
        }
    }

    public void addEvent(r rVar) {
        this.f77543c.setOnClickListener(new e(this));
        rVar.b(R$id.close_btn_tv).setOnClickListener(new f(this));
        this.f77544d.setOnClickListener(new qb.g(this));
    }

    public void afterInit() {
        Ch();
        Bitmap bitmap = this.f77546f;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f77542b.setImageBitmap(this.f77546f);
        }
        this.f77542b.post(new i(this));
    }

    public final void dismissProgressDialog() {
        g gVar = this.f77548h;
        if (gVar != null) {
            gVar.dismissProgressDialog();
        }
    }

    public int getContentViewResId() {
        return R$layout.fragment_trade_success_wechat_qr_code;
    }

    public int getGravity() {
        return 17;
    }

    public void initView(r rVar) {
        this.f77542b = (ImageView) rVar.b(R$id.wechat_qr_code_iv);
        this.f77543c = (Button) rVar.b(R$id.dialog_save_qr_code_btn);
        this.f77544d = (Button) rVar.b(R$id.dialog_copy_wechat_code_btn);
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
}
