package com.huobi.activity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.LinearLayout;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.fastjson.JSONObject;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.permissions.AfterPermissionGranted;
import com.hbg.lib.core.permissions.EasyPermissions;
import com.hbg.lib.core.ui.EmptyMVPActivity;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.utils.AutoUploadLogHelper;
import com.huobi.view.title.HbTitleBar;
import com.iproov.sdk.bridge.OptionsBridge;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.permissions.PermissionConfig;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.io.OutputStream;
import pro.huobi.R;
import rj.b;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;
import t6.c;
import xg.t;
import xg.u;

@Route(path = "/network/detection")
public class NetworkDetectionActivity extends EmptyMVPActivity implements c {

    /* renamed from: b  reason: collision with root package name */
    public b f42075b;

    /* renamed from: c  reason: collision with root package name */
    public View f42076c;

    /* renamed from: d  reason: collision with root package name */
    public View f42077d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f42078e = false;

    public class a implements Func1<Bitmap, Bitmap> {
        public a() {
        }

        /* renamed from: a */
        public Bitmap call(Bitmap bitmap) {
            NetworkDetectionActivity.this.Pg(bitmap);
            bitmap.recycle();
            return bitmap;
        }
    }

    public static void Og(Context context) {
        context.startActivity(new Intent(context, NetworkDetectionActivity.class));
    }

    public static /* synthetic */ void Zf(Bitmap bitmap) {
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$initView$0(View view) {
        finish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @AfterPermissionGranted(126)
    public void Pg(Bitmap bitmap) {
        String[] strArr = Build.VERSION.SDK_INT >= 33 ? new String[]{PermissionConfig.READ_MEDIA_AUDIO, PermissionConfig.READ_MEDIA_VIDEO, PermissionConfig.READ_MEDIA_IMAGES} : new String[]{PermissionConfig.WRITE_EXTERNAL_STORAGE};
        if (!EasyPermissions.hasPermissions(this, strArr)) {
            EasyPermissions.requestPermissions(this, 126, strArr);
        } else if (fg(this, bitmap, "hb_network_detection.png") != null) {
            HuobiToastUtil.t(this, R.string.currency_deposit_saved);
        }
    }

    public void Ua() {
        if (!this.f42078e) {
            this.f42078e = true;
            AutoUploadLogHelper.M(this);
        }
    }

    public Uri fg(Context context, Bitmap bitmap, String str) {
        OutputStream openOutputStream;
        ContentValues contentValues = new ContentValues();
        contentValues.put("_display_name", str);
        contentValues.put("mime_type", PictureMimeType.PNG_Q);
        contentValues.put("relative_path", Environment.DIRECTORY_PICTURES);
        Uri insert = context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
        if (insert != null) {
            try {
                openOutputStream = context.getContentResolver().openOutputStream(insert);
                if (openOutputStream != null) {
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, openOutputStream);
                    openOutputStream.close();
                } else {
                    if (openOutputStream != null) {
                        openOutputStream.close();
                    }
                    return null;
                }
            } catch (Exception e11) {
                e11.printStackTrace();
                return null;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
        }
        return insert;
        throw th;
    }

    public int getContentView() {
        return R.layout.activity_network_detection_layout;
    }

    public void gg() {
        if (this.f42076c != null) {
            Ua();
            this.f42076c.buildDrawingCache();
            Bitmap createBitmap = Bitmap.createBitmap(this.f42076c.getWidth(), this.f42076c.getHeight(), Bitmap.Config.ARGB_8888);
            this.f42076c.draw(new Canvas(createBitmap));
            if (createBitmap != null) {
                Observable.just(createBitmap).map(new a()).compose(RxJavaHelper.t(this)).subscribe(EasySubscriber.create(u.f61586b, (Action1<APIStatusErrorException>) null, (Action1<Throwable>) null));
            }
        }
    }

    public void initView() {
        super.initView();
        ((HbTitleBar) this.viewFinder.b(R.id.title_bar)).setOnClickBackListener(new t(this));
        b bVar = new b(this, "networkdetection");
        this.f42075b = bVar;
        bVar.t("onEvent", NetworkDetectionAbility.class);
        this.f42075b.t("pingRequest", PingAbility.class);
        this.f42075b.t(OptionsBridge.CAPTURE_KEY, CaptureAbility.class);
        this.f42075b.H();
        this.f42076c = this.f42075b.E("network_detection.xml", this, false, (JSONObject) null);
        this.f42077d = this.f42075b.E("network_detection_save.xml", this, false, (JSONObject) null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.weight = 1.0f;
        ((LinearLayout) this.viewFinder.b(R.id.network_detection_container)).addView(this.f42076c, layoutParams);
        ((LinearLayout) this.viewFinder.b(R.id.network_detection_container)).addView(this.f42077d);
    }

    public void onDestroy() {
        super.onDestroy();
        this.f42075b.B();
        this.f42075b = null;
    }

    public boolean useNewStatusBarFunc() {
        return true;
    }
}
