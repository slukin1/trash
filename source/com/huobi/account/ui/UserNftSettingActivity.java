package com.huobi.account.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.lifecycle.MutableLiveData;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicSessionCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.hbg.lib.core.util.p;
import com.hbg.lib.network.hbg.core.bean.S3TokenBean;
import com.hbg.lib.network.hbg.core.bean.UploadFile;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import com.hbg.module.libkt.helper.s3.S3UploadHelperKt;
import com.huobi.flutter.base.AbsGlobalFlutterActivity;
import com.huobi.index.bean.IndexFeatureItem;
import com.huobi.login.bean.JumpTarget;
import com.huobi.utils.GsonHelper;
import com.huobi.utils.ImageCompressor;
import com.huobi.utils.k0;
import com.huobi.utils.x;
import com.huobi.vulcan.model.VulcanInfo;
import com.huochat.community.network.domain.DomainTool;
import com.tencent.android.tpush.common.Constants;
import gj.d;
import gs.g;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import k20.h;
import kotlin.Unit;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import pro.huobi.R;
import rn.c;
import yl.o;

@Route(path = "/account/userInfoPage")
public class UserNftSettingActivity extends AbsGlobalFlutterActivity {

    /* renamed from: o  reason: collision with root package name */
    public static final String f41621o = "UserNftSettingActivity";

    /* renamed from: k  reason: collision with root package name */
    public MethodChannel f41622k;

    /* renamed from: l  reason: collision with root package name */
    public String f41623l = (d.n().y() + "");

    /* renamed from: m  reason: collision with root package name */
    public String f41624m;

    /* renamed from: n  reason: collision with root package name */
    public String f41625n;

    public class a extends Thread {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ S3TokenBean f41626b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Uri f41627c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f41628d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f41629e;

        public a(S3TokenBean s3TokenBean, Uri uri, String str, b bVar) {
            this.f41626b = s3TokenBean;
            this.f41627c = uri;
            this.f41628d = str;
            this.f41629e = bVar;
        }

        public static /* synthetic */ void b(b bVar, String str) {
            if (bVar != null) {
                bVar.onSuccess(str);
            }
        }

        public void run() {
            AmazonS3Client amazonS3Client = new AmazonS3Client((AWSCredentials) this.f41626b.getCredentials() != null ? new BasicSessionCredentials(this.f41626b.getCredentials().getAccessKeyId(), this.f41626b.getCredentials().getSecretAccessKey(), this.f41626b.getCredentials().getSessionToken()) : null, Region.e(Regions.fromName(this.f41626b.getRegionName())), new ClientConfiguration());
            amazonS3Client.w("https://s3." + this.f41626b.getRegionName() + ".amazonaws.com");
            try {
                InputStream openInputStream = UserNftSettingActivity.this.getContentResolver().openInputStream(this.f41627c);
                String str = this.f41626b.getPath() + "/" + this.f41628d;
                ObjectMetadata objectMetadata = new ObjectMetadata();
                objectMetadata.setContentLength((long) openInputStream.available());
                amazonS3Client.d0(this.f41626b.getBucketName(), str, openInputStream, objectMetadata);
                String str2 = DomainTool.DOMAIN_PREFIX + this.f41626b.getDomain() + "/" + str;
                UserNftSettingActivity.this.runOnUiThread(new m6(this.f41629e, str2));
                i6.d.c(UserNftSettingActivity.f41621o, "picUrl = " + str2);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public interface b {
        void onSuccess(String str);
    }

    public static /* synthetic */ Unit Mi(b bVar, UploadFile uploadFile) {
        if (bVar == null) {
            return null;
        }
        bVar.onSuccess(uploadFile.getUrlForDownload());
        return null;
    }

    public static /* synthetic */ Unit Ni(Throwable th2, APIStatusErrorException aPIStatusErrorException) {
        if (aPIStatusErrorException == null) {
            return null;
        }
        String str = f41621o;
        i6.d.c(str, "s3Token :onError : " + aPIStatusErrorException.getErrMsg());
        HuobiToastUtil.i(aPIStatusErrorException.getErrMsg());
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit Oi(Uri uri, b bVar, String str, S3TokenBean s3TokenBean) {
        if (s3TokenBean == null) {
            return null;
        }
        String str2 = f41621o;
        i6.d.c(str2, "s3Token: onSuccess, it = " + s3TokenBean);
        if (s3TokenBean.getUploadChannel() == 2) {
            File file = S3UploadHelperKt.toFile(uri, this);
            if (file == null) {
                return null;
            }
            try {
                RequestExtKt.c(v7.b.a().uploadFile(MultipartBody.Part.createFormData("file", file.getName(), RequestBody.create(MediaType.parse("image/jpeg"), ImageCompressor.b(this, file, s3TokenBean.getMaxUploadFileSize())))), new g6(bVar), i6.f41714b, (MutableLiveData) null);
            } catch (Exception e11) {
                e11.printStackTrace();
                return null;
            }
        } else {
            new a(s3TokenBean, uri, str, bVar).start();
        }
        return null;
    }

    public static /* synthetic */ Unit Pi(Throwable th2, APIStatusErrorException aPIStatusErrorException) {
        if (aPIStatusErrorException == null) {
            return null;
        }
        String str = f41621o;
        i6.d.c(str, "s3Token :onError : " + aPIStatusErrorException.getErrMsg());
        HuobiToastUtil.i(aPIStatusErrorException.getErrMsg());
        return null;
    }

    public static /* synthetic */ void Qi(MethodChannel.Result result, String str) {
        if (!TextUtils.isEmpty(str)) {
            result.success(str);
        }
    }

    public final void Ji(MethodCall methodCall, MethodChannel.Result result) {
    }

    /* renamed from: Ki */
    public final void Ri(Uri uri, String str, b bVar) {
        RequestExtKt.c(v7.b.a().getS3Token(), new h6(this, uri, bVar, str), j6.f41726b, (MutableLiveData) null);
    }

    public final void Li(MethodCall methodCall, MethodChannel.Result result) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("noNftAvaterType", "0");
            hashMap.put(Constants.FLAG_ACCOUNT_NAME, this.f41624m);
            hashMap.put("spingSportEnable", this.f41623l);
            result.success(GsonHelper.a().toJson((Object) hashMap));
        } catch (Exception e11) {
            e11.printStackTrace();
            result.error("flutterKycConfig", e11.getMessage(), e11.getMessage());
        }
    }

    public String Nh() {
        return "user_setting";
    }

    public void Si(MethodCall methodCall, MethodChannel.Result result) {
        try {
            String str = methodCall.method;
            if ("initUserSettingData".equals(str)) {
                Li(methodCall, result);
            } else if ("createCloudWallet".equals(str)) {
                Ji(methodCall, result);
            } else if ("jump_nft_page".equals(str)) {
                IndexFeatureItem indexFeatureItem = new IndexFeatureItem();
                indexFeatureItem.jumpMode = 1;
                indexFeatureItem.title = getString(R.string.n_nft_page_title);
                indexFeatureItem.needLogin = 1;
                if (x.d()) {
                    indexFeatureItem.jumpUrl = "https://nft.huobi.co.tz/";
                } else {
                    indexFeatureItem.jumpUrl = "https://nft.huobi.ug/";
                }
                if (p.h(this)) {
                    indexFeatureItem.jumpUrl += "zh-cn";
                } else {
                    indexFeatureItem.jumpUrl += "en-us";
                }
                o.p(this, indexFeatureItem);
                result.success((Object) null);
            } else if ("jump_nft_detail".equals(str)) {
                int intValue = ((Integer) methodCall.argument(VulcanInfo.AID)).intValue();
                int intValue2 = ((Integer) methodCall.argument("gid")).intValue();
                IndexFeatureItem indexFeatureItem2 = new IndexFeatureItem();
                indexFeatureItem2.jumpMode = 1;
                indexFeatureItem2.title = getString(R.string.n_nft_page_title);
                indexFeatureItem2.needLogin = 1;
                if (p.h(this)) {
                    indexFeatureItem2.jumpUrl = "https://nft.huobi.co.ma/zh-cn/item/?id=" + intValue + "&gid=" + intValue2;
                } else {
                    indexFeatureItem2.jumpUrl = "https://nft.huobi.co.ma/en-us/item/?id=" + intValue + "&gid=" + intValue2;
                }
                o.p(this, indexFeatureItem2);
                result.success((Object) null);
            } else if ("selectPhotoAndUpload".equals(str)) {
                Ti(new f6(result));
            } else if ("gotoGroupListPage".equals(str)) {
                UserGroupSettingActivity.Ei(this);
            } else {
                result.notImplemented();
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            result.notImplemented();
        }
    }

    public final void Ti(b bVar) {
        hc.d.f19133a.e("Album", this, new k6(this, bVar), Boolean.TRUE);
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), "user_setting_channel");
        this.f41622k = methodChannel;
        methodChannel.setMethodCallHandler(new l6(this));
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        if (i12 == -1 && i11 == 666) {
            String stringExtra = intent.getStringExtra("groupData");
            HashMap hashMap = new HashMap();
            hashMap.put("groupData", stringExtra);
            this.f41622k.invokeMethod("nativeCallSelectedGroup", hashMap);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f41624m = getIntent().getStringExtra(Constants.FLAG_ACCOUNT_NAME);
        this.f41625n = getIntent().getStringExtra("nftVerse");
        HashMap hashMap = new HashMap();
        hashMap.put("is_did", Boolean.valueOf(!TextUtils.isEmpty(this.f41625n)));
        g.i("Information_Me_expose", hashMap);
    }

    public void onStart() {
        super.onStart();
        if (!EventBus.d().i(this)) {
            EventBus.d().p(this);
        }
    }

    public void onStop() {
        super.onStop();
        if (EventBus.d().i(this)) {
            EventBus.d().r(this);
        }
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTokenError(mo.a aVar) {
        Intent h11 = k0.h(this);
        c.i().m(this, new JumpTarget(h11, h11));
    }
}
