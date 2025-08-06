package com.huobi.kyc.presenter;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.annotation.Keep;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.network.response.StringStatusResponse;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.permissions.AfterPermissionGranted;
import com.hbg.lib.core.permissions.AppSettingsDialog;
import com.hbg.lib.core.permissions.EasyPermissions;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.kyc.service.KycService;
import com.huobi.kyc.ui.KycProBaseInformationActivity;
import com.huobi.utils.ImageUtils;
import com.huobi.utils.k0;
import com.luck.picture.lib.permissions.PermissionConfig;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k20.h;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import pa.d;
import pro.huobi.R;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import tq.p;
import u6.g;
import vm.f;

public class KycProBaseInformationUploadPhotoPresenter extends ActivityPresenter<b> implements EasyPermissions.PermissionCallbacks {

    /* renamed from: b  reason: collision with root package name */
    public File f74833b;

    public class a implements pa.a {

        /* renamed from: com.huobi.kyc.presenter.KycProBaseInformationUploadPhotoPresenter$a$a  reason: collision with other inner class name */
        public class C0801a implements f.b {

            /* renamed from: a  reason: collision with root package name */
            public int f74835a = -1;

            public C0801a() {
            }

            public void onProgressUpdate(int i11) {
                if (i11 > this.f74835a) {
                    ((b) KycProBaseInformationUploadPhotoPresenter.this.getUI()).r4(i11);
                    this.f74835a = i11;
                }
            }
        }

        public a() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ File m(Uri uri, Integer num) {
            KycProBaseInformationUploadPhotoPresenter kycProBaseInformationUploadPhotoPresenter = KycProBaseInformationUploadPhotoPresenter.this;
            File unused = kycProBaseInformationUploadPhotoPresenter.f74833b = ImageUtils.f(kycProBaseInformationUploadPhotoPresenter.getActivity(), uri.getPath(), 2.5d);
            return KycProBaseInformationUploadPhotoPresenter.this.f74833b;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void n(File file) {
            ((b) KycProBaseInformationUploadPhotoPresenter.this.getUI()).Xd(Uri.fromFile(file));
        }

        public static /* synthetic */ File o(File file, StringStatusResponse stringStatusResponse) {
            return file;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ Observable p(File file) {
            return ((KycService) p.V(KycService.class)).doUploadPic(RequestBody.create(MediaType.parse("text/plain"), "do_upload_pic"), RequestBody.create(MediaType.parse("text/plain"), "9"), RequestBody.create(MediaType.parse("text/plain"), "0"), MultipartBody.Part.createFormData("photo", file.getName(), new f(file, new C0801a()))).map(new q(file));
        }

        public static /* synthetic */ void q() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void r(File file) {
            ((b) KycProBaseInformationUploadPhotoPresenter.this.getUI()).Fd(Uri.fromFile(file));
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void s(APIStatusErrorException aPIStatusErrorException) {
            ((b) KycProBaseInformationUploadPhotoPresenter.this.getUI()).Ea();
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void t(Throwable th2) {
            ((b) KycProBaseInformationUploadPhotoPresenter.this.getUI()).Ea();
        }

        public static /* synthetic */ void u() {
        }

        public void a(Uri uri, String str, boolean z11) {
            Observable.just(0).map(new p(this, uri)).doOnNext(new l(this)).observeOn(Schedulers.io()).flatMap(new o(this)).observeOn(AndroidSchedulers.mainThread()).subscribe(EasySubscriber.create(i.f74846b, new m(this), new k(this), new n(this), j.f74847b));
        }

        public void b(String str) {
        }

        public void c(LinkedHashMap<String, Boolean> linkedHashMap, String[] strArr) {
        }

        public void onCancel() {
        }
    }

    public interface b extends g {
        void Ea();

        void Fd(Uri uri);

        void Xd(Uri uri);

        void q0();

        void r4(int i11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void V(String str) {
        Intent intent = getActivity().getIntent();
        intent.setClass(getActivity(), KycProBaseInformationActivity.class);
        intent.putExtra("FROM_STEP2_KEY", true);
        intent.setFlags(67108864);
        getActivity().startActivity(intent);
        getActivity().finish();
    }

    @AfterPermissionGranted(123)
    public void U() {
        String[] strArr;
        if (Build.VERSION.SDK_INT >= 33) {
            strArr = new String[]{"android.permission.CAMERA", PermissionConfig.READ_MEDIA_IMAGES};
        } else {
            strArr = new String[]{"android.permission.CAMERA", PermissionConfig.WRITE_EXTERNAL_STORAGE};
        }
        if (EasyPermissions.hasPermissions(getActivity(), strArr)) {
            d.o().B(false).q(getActivity());
            ((b) getUI()).q0();
            return;
        }
        EasyPermissions.requestPermissions(getActivity(), 123, strArr);
    }

    /* renamed from: W */
    public void onUIReady(BaseCoreActivity baseCoreActivity, b bVar) {
        super.onUIReady(baseCoreActivity, bVar);
        EventBus.d().p(this);
    }

    @AfterPermissionGranted(124)
    public void X() {
        String str = Build.VERSION.SDK_INT >= 33 ? PermissionConfig.READ_MEDIA_IMAGES : PermissionConfig.WRITE_EXTERNAL_STORAGE;
        if (EasyPermissions.hasPermissions(getActivity(), str)) {
            d.o().B(false).t(getActivity());
            ((b) getUI()).q0();
            return;
        }
        EasyPermissions.requestPermissions(getActivity(), 124, str);
    }

    public void Y(Map<String, Object> map) {
        ((KycService) p.V(KycService.class)).doAuthPro(map).compose(p.a0()).compose(RxJavaHelper.t((g) getUI())).subscribe(q6.d.c((g) getUI(), new h(this)));
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        if (i12 == -1) {
            if (i11 == 125) {
                ((b) getUI()).q0();
            }
            d.o().C(new a()).x(getActivity(), i11, i12, intent);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        EventBus.d().r(this);
    }

    public void onPermissionsDenied(int i11, List<String> list) {
        if (EasyPermissions.somePermissionPermanentlyDenied(getActivity(), list)) {
            ((b) getUI()).q0();
            new AppSettingsDialog.Builder((Activity) getActivity(), getString(R.string.permission_camera_write_external_storage_apply)).setTitle(getString(R.string.permission_apply)).setPositiveButton(getString(R.string.go_to_settings)).setNegativeButton(getString(R.string.global_string_cancel), (DialogInterface.OnClickListener) null).setRequestCode(125).build().show();
        }
    }

    public void onPermissionsGranted(int i11, List<String> list) {
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void tokenError(mo.a aVar) {
        getActivity().startActivity(k0.h(getActivity()));
        getActivity().finish();
    }
}
