package com.huobi.sharev2.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import bh.j;
import com.hbg.lib.core.permissions.EasyPermissions;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.luck.picture.lib.permissions.PermissionConfig;
import io.flutter.Log;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.util.ArrayList;
import java.util.List;
import pro.huobi.R;
import rr.a;
import ur.b;
import xr.i;

public abstract class NewBaseShareFragment extends BaseDialogFragment implements b, EasyPermissions.PermissionCallbacks {

    /* renamed from: b  reason: collision with root package name */
    public List<String> f81070b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public String[] f81071c;

    public NewBaseShareFragment() {
        String[] strArr;
        if (Build.VERSION.SDK_INT >= 33) {
            strArr = new String[]{PermissionConfig.READ_MEDIA_IMAGES};
        } else {
            strArr = new String[]{PermissionConfig.READ_EXTERNAL_STORAGE, PermissionConfig.WRITE_EXTERNAL_STORAGE};
        }
        this.f81071c = strArr;
    }

    public static /* synthetic */ void uh(HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        HuobiToastUtil.s(R.string.otc_saveimage_path_faild_text);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void vh(HBDialogFragment hBDialogFragment) {
        if (!isAdded()) {
            hBDialogFragment.dismiss();
            return;
        }
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", j.c().getPackageName(), (String) null));
        startActivity(intent);
        hBDialogFragment.dismiss();
    }

    public boolean contentViewIsFullScreen() {
        return true;
    }

    public boolean isFullScreen() {
        return true;
    }

    public boolean useWindowBg() {
        return false;
    }

    public void wh(Bitmap bitmap) {
        if (getActivity() == null || !EasyPermissions.hasPermissions(getActivity(), this.f81071c)) {
            boolean z11 = false;
            for (String shouldShowRequestPermissionRationale : this.f81071c) {
                z11 = z11 || EasyPermissions.shouldShowRequestPermissionRationale(this, shouldShowRequestPermissionRationale);
            }
            if (!z11) {
                Log.d("NewBaseShareFragment", "shouldShowRequestPermissionRationale");
                yh();
                return;
            }
            Log.d("NewBaseShareFragment", "requestPermissions");
            EasyPermissions.requestPermissions(this, 126, this.f81071c);
            return;
        }
        Log.d("NewBaseShareFragment", "hasPermissions");
        i.r().I(requireContext(), bitmap, true);
    }

    public void xh() {
        this.f81070b.add("fb");
        this.f81070b.add("tw");
        this.f81070b.add("ins");
        this.f81070b.add("tel");
        this.f81070b.add("kakao");
        this.f81070b.add(Constants.LINE);
        this.f81070b.add("whatsapp");
    }

    public void yh() {
        if (getActivity() != null) {
            DialogUtils.c0(getActivity(), getResources().getString(R.string.share_content_tip), (String) null, getResources().getString(R.string.share_cancel), getResources().getString(R.string.share_ok), rr.b.f25791a, new a(this));
        }
    }
}
