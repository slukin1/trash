package com.huobi.otc.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import cn.sharesdk.framework.InnerShareParams;
import com.bumptech.glide.a;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.core.permissions.EasyPermissions;
import com.hbg.lib.core.ui.EmptyMVPActivity;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.hbg.module.otc.R$string;
import com.huobi.utils.ImageUtils;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.permissions.PermissionConfig;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.io.File;
import java.io.FileNotFoundException;
import sp.j2;
import sp.k2;
import sp.l2;
import up.b;

public class OtcScaleImageActivity extends EmptyMVPActivity {

    /* renamed from: b  reason: collision with root package name */
    public String f79528b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f79529c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f79530d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f79531e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f79532f;

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Og(View view) {
        gg();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        finish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        finish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void addEvent() {
        this.f79531e.setClickable(true);
        this.f79531e.setOnClickListener(new k2(this));
        this.f79530d.setOnClickListener(new l2(this));
        this.f79529c.setOnClickListener(new j2(this));
    }

    public final String fg() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(BaseApplication.b().getExternalCacheDir());
        String str = File.separator;
        sb2.append(str);
        sb2.append("chat_image");
        String sb3 = sb2.toString();
        File file = new File(sb3);
        if (!file.exists()) {
            file.mkdirs();
        }
        return sb3 + str + "chat_" + System.currentTimeMillis() + PictureMimeType.JPG;
    }

    public int getContentView() {
        return R$layout.activity_otc_scale_image;
    }

    public final void gg() {
        String str = Build.VERSION.SDK_INT >= 33 ? PermissionConfig.READ_MEDIA_IMAGES : PermissionConfig.WRITE_EXTERNAL_STORAGE;
        if (EasyPermissions.hasPermissions(this, str)) {
            Bitmap j11 = ImageUtils.j(this.f79529c.getDrawable());
            Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
            File file = new File(fg());
            String h11 = ImageUtils.h(j11, compressFormat, file);
            if (h11 != null) {
                try {
                    MediaStore.Images.Media.insertImage(getContentResolver(), file.getAbsolutePath(), file.getName(), (String) null);
                    MediaScannerConnection.scanFile(this, new String[]{file.getAbsolutePath()}, (String[]) null, (MediaScannerConnection.OnScanCompletedListener) null);
                } catch (FileNotFoundException e11) {
                    e11.printStackTrace();
                }
                Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                intent.setData(Uri.fromFile(file));
                sendBroadcast(intent);
                HuobiToastUtil.v(getString(R$string.otc_saveimage_path_text) + h11);
                return;
            }
            HuobiToastUtil.m(getString(R$string.otc_saveimage_path_faild_text));
            return;
        }
        EasyPermissions.requestPermissions(this, 126, str);
    }

    public void initView() {
        this.f79529c = (ImageView) this.viewFinder.b(R$id.otc_scale_imageshow_iv);
        this.f79530d = (ImageView) this.viewFinder.b(R$id.otc_scale_downimage_iv);
        this.f79531e = (ImageView) this.viewFinder.b(R$id.otc_scale_back);
        Intent intent = getIntent();
        this.f79528b = intent.getStringExtra(InnerShareParams.IMAGE_URL);
        Uri uri = (Uri) intent.getParcelableExtra("imageURI");
        if (!TextUtils.isEmpty(this.f79528b)) {
            a.y(this).p(new b(this.f79528b)).D0(this.f79529c);
        } else if (uri != null) {
            this.f79529c.setImageURI(uri);
        }
        this.f79532f = (LinearLayout) this.viewFinder.b(R$id.otc_chat_img_root);
    }
}
