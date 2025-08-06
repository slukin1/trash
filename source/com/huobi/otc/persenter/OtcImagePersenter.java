package com.huobi.otc.persenter;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.permissions.EasyPermissions;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.otc.OtcModuleConfig;
import com.hbg.module.otc.R$string;
import com.huobi.utils.ImageUtils;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.permissions.PermissionConfig;
import java.io.File;
import java.io.FileNotFoundException;
import u6.g;

public class OtcImagePersenter extends ActivityPresenter<a> {

    public interface a extends g {
        void X7();
    }

    public final String Q() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(BaseApplication.b().getExternalCacheDir());
        String str = File.separator;
        sb2.append(str);
        sb2.append("down_image");
        String sb3 = sb2.toString();
        File file = new File(sb3);
        if (!file.exists()) {
            file.mkdirs();
        }
        return sb3 + str + "down_" + System.currentTimeMillis() + PictureMimeType.JPG;
    }

    public void R(Drawable drawable, boolean z11) {
        String str = Build.VERSION.SDK_INT >= 33 ? PermissionConfig.READ_MEDIA_IMAGES : PermissionConfig.WRITE_EXTERNAL_STORAGE;
        if (EasyPermissions.hasPermissions(getActivity(), str)) {
            Bitmap j11 = ImageUtils.j(drawable);
            Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
            File file = new File(Q());
            String h11 = ImageUtils.h(j11, compressFormat, file);
            if (h11 != null) {
                try {
                    MediaStore.Images.Media.insertImage(getActivity().getContentResolver(), file.getAbsolutePath(), file.getName(), (String) null);
                    MediaScannerConnection.scanFile(getActivity(), new String[]{file.getAbsolutePath()}, (String[]) null, (MediaScannerConnection.OnScanCompletedListener) null);
                } catch (FileNotFoundException e11) {
                    e11.printStackTrace();
                }
                Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                intent.setData(Uri.fromFile(file));
                getActivity().sendBroadcast(intent);
                if (!z11 || !OtcModuleConfig.a().H(getActivity())) {
                    HuobiToastUtil.r(getString(R$string.otc_saveimage_path_text) + h11);
                    return;
                }
                ((a) getUI()).X7();
                return;
            }
            HuobiToastUtil.m(getString(R$string.otc_saveimage_path_faild_text));
            return;
        }
        EasyPermissions.requestPermissions(getActivity(), 126, str);
    }

    /* renamed from: S */
    public void onUIReady(BaseCoreActivity baseCoreActivity, a aVar) {
        super.onUIReady(baseCoreActivity, aVar);
    }
}
