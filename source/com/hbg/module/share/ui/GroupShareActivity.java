package com.hbg.module.share.ui;

import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.widget.Checkable;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.google.gson.Gson;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import com.hbg.module.libkt.base.ui.BaseActivity;
import com.hbg.module.libkt.helper.s3.S3UploadHelper;
import com.hbg.module.libkt.helper.s3.S3UploadInterface;
import com.hbg.module.libkt.provider.HbgBaseProvider;
import com.hbg.module.libkt.utils.r;
import com.hbg.module.share.R$anim;
import com.hbg.module.share.R$string;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.HashMap;
import kotlin.Unit;
import org.json.JSONObject;
import yf.c;

@Route(path = "/share/shareGroup")
public final class GroupShareActivity extends BaseActivity<c> {

    /* renamed from: i  reason: collision with root package name */
    public xf.c f37451i;

    /* renamed from: j  reason: collision with root package name */
    public Uri f37452j;

    /* renamed from: k  reason: collision with root package name */
    public String f37453k;

    /* renamed from: l  reason: collision with root package name */
    public Bitmap f37454l;

    /* renamed from: m  reason: collision with root package name */
    public String f37455m;

    /* renamed from: n  reason: collision with root package name */
    public String f37456n;

    /* renamed from: o  reason: collision with root package name */
    public String f37457o;

    /* renamed from: p  reason: collision with root package name */
    public int f37458p = 2;

    public static final class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f37459b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f37460c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ GroupShareActivity f37461d;

        public a(View view, long j11, GroupShareActivity groupShareActivity) {
            this.f37459b = view;
            this.f37460c = j11;
            this.f37461d = groupShareActivity;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            r rVar = r.f24939a;
            if (currentTimeMillis - rVar.b(this.f37459b) > this.f37460c || (this.f37459b instanceof Checkable)) {
                rVar.e(this.f37459b, currentTimeMillis);
                TextView textView = (TextView) this.f37459b;
                HbgBaseProvider fg2 = this.f37461d.fg();
                boolean z11 = true;
                int i11 = 0;
                if (fg2 == null || !fg2.j(this.f37461d)) {
                    z11 = false;
                }
                if (z11) {
                    this.f37461d.sh();
                    try {
                        i11 = new JSONObject(this.f37461d.Ch()).getInt("shareChannel");
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                    if ((this.f37461d.Dh() == null && this.f37461d.Fh() == null) || i11 == 7) {
                        this.f37461d.Jh();
                    } else {
                        Uri Dh = this.f37461d.Dh();
                        if (Dh == null) {
                            Dh = S3UploadHelper.INSTANCE.bitmapToUri(this.f37461d.Fh());
                        }
                        Uri uri = Dh;
                        if (uri != null) {
                            GroupShareActivity groupShareActivity = this.f37461d;
                            S3UploadHelper.upLoad$default(groupShareActivity, uri, (String) null, new b(groupShareActivity), 4, (Object) null);
                        } else {
                            HuobiToastUtil.g(R$string.n_service_error);
                        }
                    }
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class b implements S3UploadInterface {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GroupShareActivity f37462a;

        public b(GroupShareActivity groupShareActivity) {
            this.f37462a = groupShareActivity;
        }

        public void upLoadCallback(int i11, String str, String str2) {
            if (i11 == 0) {
                this.f37462a.Ih(str2);
                this.f37462a.Jh();
                return;
            }
            HuobiToastUtil.g(R$string.n_service_error);
        }
    }

    public static final /* synthetic */ c yh(GroupShareActivity groupShareActivity) {
        return (c) groupShareActivity.Yf();
    }

    public final void Bh() {
        wf.b g11 = wf.a.f40622a.g();
        if (g11 != null) {
            g11.a(1, getResources().getString(R$string.n_cancel));
        }
        finish();
    }

    public final String Ch() {
        return this.f37457o;
    }

    public final Uri Dh() {
        return this.f37452j;
    }

    public final xf.c Eh() {
        return this.f37451i;
    }

    public final Bitmap Fh() {
        return this.f37454l;
    }

    /* renamed from: Gh */
    public c Og() {
        return c.K(getLayoutInflater());
    }

    public final void Hh(xf.c cVar) {
        this.f37451i = cVar;
    }

    public final void Ih(String str) {
        this.f37453k = str;
    }

    public final void Jh() {
        String obj = ((c) Yf()).C.getText().toString();
        xf.c cVar = this.f37451i;
        String m11 = cVar != null ? cVar.m() : null;
        Bitmap bitmap = this.f37454l;
        int[] imageSizeCompress = bitmap != null ? new int[]{bitmap.getWidth(), this.f37454l.getHeight()} : S3UploadHelper.INSTANCE.imageSizeCompress(this.f37452j);
        ag.a aVar = ag.a.f37362a;
        String str = this.f37453k;
        RequestExtKt.d(v7.b.a().p(m11, ag.a.e(aVar, str, obj, this.f37456n + 10 + this.f37455m, (String) null, imageSizeCompress[0], imageSizeCompress[1], this.f37457o, 8, (Object) null), 1, this.f37458p), new GroupShareActivity$share$1(this), new GroupShareActivity$share$2(this), (MutableLiveData) null, 4, (Object) null);
    }

    public void finish() {
        super.finish();
        overridePendingTransition(0, R$anim.bottom_out);
    }

    public void initView() {
        super.initView();
        setFinishOnTouchOutside(true);
        getWindow().setLayout(-1, (com.hbg.module.libkt.base.ext.c.b() * 9) / 10);
        getWindow().setGravity(80);
        com.hbg.module.libkt.utils.b.f24864f.a(findViewById(16908290), (com.hbg.module.libkt.base.ext.c.b() * 9) / 10);
        ((c) Yf()).M(this);
        com.hbg.module.libkt.base.ext.b.f(((c) Yf()).E);
        RequestExtKt.d(v7.b.a().getShareGroups(1), new GroupShareActivity$initView$1(this), new GroupShareActivity$initView$2(this), (MutableLiveData) null, 4, (Object) null);
        r rVar = r.f24939a;
        TextView textView = ((c) Yf()).F;
        textView.setOnClickListener(new a(textView, 800, this));
    }

    public void oh() {
        Unit unit;
        super.oh();
        this.f37452j = (Uri) getIntent().getParcelableExtra("shareImage");
        this.f37454l = (Bitmap) getIntent().getParcelableExtra("shareBitmap");
        this.f37455m = getIntent().getStringExtra("shareText");
        this.f37456n = getIntent().getStringExtra("shareUrl");
        HashMap hashMap = (HashMap) getIntent().getSerializableExtra("extendedParameterMap");
        if (hashMap != null) {
            this.f37457o = new Gson().toJson((Object) hashMap);
            unit = Unit.f56620a;
        } else {
            unit = null;
        }
        if (unit == null) {
            this.f37457o = getIntent().getStringExtra("extendedParameter");
        }
        if (!(this.f37452j == null && this.f37454l == null)) {
            this.f37458p = 1;
        }
        ((c) Yf()).D.setPadding(0, 0, 0, com.hbg.module.libkt.base.ext.b.s(this));
    }
}
