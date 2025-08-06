package com.hbg.lib.core.util;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.g;
import com.hbg.lib.core.R$string;
import com.hbg.lib.core.permissions.AppSettingsDialog;
import com.hbg.lib.core.permissions.EasyPermissions;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.permissions.PermissionConfig;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.d;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.observables.SyncOnSubscribe;
import rx.schedulers.Schedulers;
import v6.w;

public class SaveImageUtils {

    public class a implements PermissionUtils.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f68684a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f68685b;

        public a(String str, Activity activity) {
            this.f68684a = str;
            this.f68685b = activity;
        }

        public static /* synthetic */ Boolean h(Bitmap bitmap) {
            return Boolean.valueOf(bitmap != null);
        }

        public void a(List<String> list, List<String> list2) {
            SaveImageUtils.f(this.f68685b, list2);
        }

        public void onGranted(List<String> list) {
            Observable.just(this.f68684a).subscribeOn(Schedulers.io()).filter(l0.f68721b).map(new j0(this.f68685b)).filter(k0.f68718b).observeOn(AndroidSchedulers.mainThread()).subscribe(new i0(this.f68685b));
        }
    }

    public class b extends BaseSubscriber<File> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f68686b;

        public b(Context context) {
            this.f68686b = context;
        }

        /* renamed from: a */
        public void onNext(File file) {
            super.onNext(file);
            if (file != null) {
                HuobiToastUtil.v(this.f68686b.getString(R$string.n_photo_save_success));
                try {
                    MediaScannerConnection.scanFile(this.f68686b, new String[]{file.getParentFile().getAbsolutePath()}, (String[]) null, (MediaScannerConnection.OnScanCompletedListener) null);
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            }
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            HuobiToastUtil.v(this.f68686b.getResources().getString(R$string.n_photo_save_failure));
            d.b(th2.toString());
        }
    }

    public class c extends SyncOnSubscribe<String, File> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Bitmap f68687b;

        public c(Bitmap bitmap) {
            this.f68687b = bitmap;
        }

        /* renamed from: a */
        public String generateState() {
            return "generateState";
        }

        /* renamed from: b */
        public String next(String str, Observer<? super File> observer) {
            FileOutputStream fileOutputStream;
            Exception e11;
            String str2 = System.currentTimeMillis() + PictureMimeType.PNG;
            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "huobipro");
            if (file.exists() || file.mkdirs()) {
                File file2 = new File(file, str2);
                FileOutputStream fileOutputStream2 = null;
                try {
                    fileOutputStream = new FileOutputStream(file2);
                    try {
                        this.f68687b.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        g.a(fileOutputStream);
                    } catch (Exception e12) {
                        e11 = e12;
                        try {
                            e11.printStackTrace();
                            g.a(fileOutputStream);
                            observer.onNext(file2);
                            observer.onCompleted();
                            return str;
                        } catch (Throwable th2) {
                            th = th2;
                            fileOutputStream2 = fileOutputStream;
                            g.a(fileOutputStream2);
                            throw th;
                        }
                    }
                } catch (Exception e13) {
                    Exception exc = e13;
                    fileOutputStream = null;
                    e11 = exc;
                    e11.printStackTrace();
                    g.a(fileOutputStream);
                    observer.onNext(file2);
                    observer.onCompleted();
                    return str;
                } catch (Throwable th3) {
                    th = th3;
                    g.a(fileOutputStream2);
                    throw th;
                }
                observer.onNext(file2);
                observer.onCompleted();
            } else {
                observer.onError(new Exception());
            }
            return str;
        }
    }

    public static Bitmap c(Context context, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (str.startsWith("http")) {
                return (Bitmap) com.bumptech.glide.a.v(context).b().M0(str).R0().get();
            }
            if (str.startsWith("content://")) {
                return (Bitmap) com.bumptech.glide.a.v(context).b().I0(Uri.parse(str)).R0().get();
            }
            return null;
        } catch (Exception e11) {
            d.c("getBitmapFromUrl", e11.getMessage());
        }
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void d(Activity activity, DialogInterface dialogInterface, int i11) {
        HuobiToastUtil.v(activity.getResources().getString(R$string.n_photo_save_failure));
        SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i11);
    }

    public static void f(Activity activity, List<String> list) {
        if (EasyPermissions.somePermissionPermanentlyDenied(activity, list)) {
            new AppSettingsDialog.Builder(activity, String.format(activity.getString(R$string.permission_write_external_storage_apply), new Object[]{activity.getString(R$string.app_real_name)})).setTitle(activity.getString(R$string.permission_to_apply)).setPositiveButton(activity.getString(R$string.currency_deposit_go_to_settings)).setNegativeButton(activity.getString(R$string.string_cancel), new g0(activity)).setRequestCode(126).build().show();
        }
    }

    public static void g(String str, Activity activity, int i11) {
        PermissionUtils.z(Build.VERSION.SDK_INT >= 33 ? PermissionConfig.READ_MEDIA_IMAGES : PermissionConfig.WRITE_EXTERNAL_STORAGE).n(new a(str, activity)).B();
    }

    public static void h(Context context, String str) {
        if (context instanceof Activity) {
            j((Activity) context, str, 0);
        }
    }

    public static void i(Bitmap bitmap, Context context) {
        Observable.create(new c(bitmap)).compose(RxJavaHelper.t((u6.g) null)).subscribe(new b(context));
    }

    public static void j(Activity activity, String str, int i11) {
        w.e().l(activity, new h0(str, activity, i11));
    }
}
