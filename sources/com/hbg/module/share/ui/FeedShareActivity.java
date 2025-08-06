package com.hbg.module.share.ui;

import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.widget.Checkable;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.MutableLiveData;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.network.hbg.IHbgApi;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import com.hbg.module.libkt.base.ui.BaseActivity;
import com.hbg.module.libkt.helper.s3.S3UploadHelper;
import com.hbg.module.libkt.helper.s3.S3UploadInterface;
import com.hbg.module.libkt.provider.HbgBaseProvider;
import com.hbg.module.libkt.utils.r;
import com.hbg.module.share.R$string;
import com.huochat.community.base.CommunityConstants;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import kotlin.Result;
import kotlin.Unit;
import kotlin.k;
import org.json.JSONObject;

@Route(path = "/share/shareFeed")
public final class FeedShareActivity extends BaseActivity<yf.a> {

    /* renamed from: i  reason: collision with root package name */
    public Uri f37430i;

    /* renamed from: j  reason: collision with root package name */
    public String f37431j;

    /* renamed from: k  reason: collision with root package name */
    public Bitmap f37432k;

    /* renamed from: l  reason: collision with root package name */
    public String f37433l;

    /* renamed from: m  reason: collision with root package name */
    public String f37434m;

    /* renamed from: n  reason: collision with root package name */
    public String f37435n;

    /* renamed from: o  reason: collision with root package name */
    public String f37436o;

    /* renamed from: p  reason: collision with root package name */
    public String f37437p;

    /* renamed from: q  reason: collision with root package name */
    public String f37438q;

    /* renamed from: r  reason: collision with root package name */
    public String f37439r;

    /* renamed from: s  reason: collision with root package name */
    public int f37440s = 1;

    /* renamed from: t  reason: collision with root package name */
    public int f37441t;

    /* renamed from: u  reason: collision with root package name */
    public int f37442u;

    /* renamed from: v  reason: collision with root package name */
    public int f37443v;

    public static final class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f37444b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f37445c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ FeedShareActivity f37446d;

        public a(View view, long j11, FeedShareActivity feedShareActivity) {
            this.f37444b = view;
            this.f37445c = j11;
            this.f37446d = feedShareActivity;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            r rVar = r.f24939a;
            if (currentTimeMillis - rVar.b(this.f37444b) > this.f37445c || (this.f37444b instanceof Checkable)) {
                rVar.e(this.f37444b, currentTimeMillis);
                TextView textView = (TextView) this.f37444b;
                wf.b g11 = wf.a.f40622a.g();
                if (g11 != null) {
                    g11.a(1, this.f37446d.getResources().getString(R$string.n_cancel));
                }
                this.f37446d.finish();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f37447b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f37448c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ FeedShareActivity f37449d;

        public b(View view, long j11, FeedShareActivity feedShareActivity) {
            this.f37447b = view;
            this.f37448c = j11;
            this.f37449d = feedShareActivity;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            r rVar = r.f24939a;
            if (currentTimeMillis - rVar.b(this.f37447b) > this.f37448c || (this.f37447b instanceof Checkable)) {
                rVar.e(this.f37447b, currentTimeMillis);
                TextView textView = (TextView) this.f37447b;
                HbgBaseProvider fg2 = this.f37449d.fg();
                boolean z11 = true;
                if (fg2 == null || !fg2.j(this.f37449d)) {
                    z11 = false;
                }
                if (z11) {
                    this.f37449d.sh();
                    if (this.f37449d.zh() == null && this.f37449d.Ah() == null) {
                        this.f37449d.Dh();
                    } else {
                        Uri zh2 = this.f37449d.zh();
                        if (zh2 == null) {
                            zh2 = S3UploadHelper.INSTANCE.bitmapToUri(this.f37449d.Ah());
                        }
                        Uri uri = zh2;
                        if (uri != null) {
                            FeedShareActivity feedShareActivity = this.f37449d;
                            S3UploadHelper.upLoad$default(feedShareActivity, uri, (String) null, new c(feedShareActivity), 4, (Object) null);
                        } else {
                            HuobiToastUtil.g(R$string.n_service_error);
                        }
                    }
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class c implements S3UploadInterface {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FeedShareActivity f37450a;

        public c(FeedShareActivity feedShareActivity) {
            this.f37450a = feedShareActivity;
        }

        public void upLoadCallback(int i11, String str, String str2) {
            if (i11 == 0) {
                this.f37450a.Ch(str2);
                this.f37450a.Dh();
                return;
            }
            HuobiToastUtil.g(R$string.n_service_error);
        }
    }

    public final Bitmap Ah() {
        return this.f37432k;
    }

    /* renamed from: Bh */
    public yf.a Og() {
        return yf.a.K(getLayoutInflater());
    }

    public final void Ch(String str) {
        this.f37431j = str;
    }

    public final void Dh() {
        String str;
        String str2;
        String obj = ((yf.a) Yf()).B.getText().toString();
        String str3 = null;
        if (this.f37443v == 0) {
            str2 = this.f37436o;
            str = this.f37437p;
        } else {
            if (!com.hbg.module.libkt.base.ext.b.x(this.f37431j)) {
                this.f37433l = null;
            }
            str2 = null;
            str = null;
        }
        IHbgApi a11 = v7.b.a();
        int i11 = this.f37440s;
        if (i11 == 22) {
            str3 = this.f37433l;
        }
        RequestExtKt.d(a11.z(str3, obj, this.f37431j, (String) null, this.f37439r, i11, str2, str), new FeedShareActivity$share$1(this), new FeedShareActivity$share$2(this), (MutableLiveData) null, 4, (Object) null);
    }

    public void initView() {
        super.initView();
        ((yf.a) Yf()).M(this);
        r rVar = r.f24939a;
        TextView textView = ((yf.a) Yf()).E;
        textView.setOnClickListener(new a(textView, 800, this));
        Uri uri = this.f37430i;
        if (uri != null) {
            int[] imageSizeCompress = S3UploadHelper.INSTANCE.imageSizeCompress(uri);
            ((yf.a) Yf()).D.setVisibility(8);
            if (this.f37437p != null && this.f37443v == 0) {
                ((yf.a) Yf()).D.setVisibility(0);
            }
            ((yf.a) Yf()).C.setImageURI(this.f37430i);
            ((ConstraintLayout.LayoutParams) ((yf.a) Yf()).C.getLayoutParams()).H = "H," + imageSizeCompress[0] + ':' + imageSizeCompress[1];
        } else if (this.f37432k != null) {
            ((yf.a) Yf()).D.setVisibility(8);
            ((yf.a) Yf()).C.setImageBitmap(this.f37432k);
            ((ConstraintLayout.LayoutParams) ((yf.a) Yf()).C.getLayoutParams()).H = "H," + this.f37432k.getWidth() + ':' + this.f37432k.getHeight();
        } else if (!com.hbg.module.libkt.base.ext.b.x(this.f37438q)) {
            ((yf.a) Yf()).D.setVisibility(0);
            com.hbg.module.libkt.base.ext.b.D(((yf.a) Yf()).C, this.f37438q);
        } else if (this.f37440s == 17) {
            ((yf.a) Yf()).D.setVisibility(8);
            ((yf.a) Yf()).C.setVisibility(8);
        } else {
            ((yf.a) Yf()).D.setVisibility(0);
            ((yf.a) Yf()).C.setVisibility(8);
        }
        if (com.hbg.module.libkt.base.ext.b.x(this.f37436o)) {
            ((yf.a) Yf()).I.setVisibility(8);
        } else {
            ((yf.a) Yf()).I.setText(this.f37436o);
        }
        if (com.hbg.module.libkt.base.ext.b.x(this.f37433l)) {
            ((yf.a) Yf()).F.setVisibility(8);
        } else {
            ((yf.a) Yf()).F.setText(this.f37433l);
        }
        TextView textView2 = ((yf.a) Yf()).H;
        textView2.setOnClickListener(new b(textView2, 800, this));
    }

    public void oh() {
        super.oh();
        Qg(NightHelper.e().g());
        this.f37430i = (Uri) getIntent().getParcelableExtra("shareImage");
        this.f37432k = (Bitmap) getIntent().getParcelableExtra("shareBitmap");
        this.f37433l = getIntent().getStringExtra("shareText");
        this.f37434m = getIntent().getStringExtra("shareUrl");
        String stringExtra = getIntent().getStringExtra("extendedParameter");
        this.f37435n = stringExtra;
        try {
            Result.a aVar = Result.Companion;
            if (!com.hbg.module.libkt.base.ext.b.x(stringExtra)) {
                JSONObject jSONObject = new JSONObject(this.f37435n);
                this.f37436o = jSONObject.optString("shareSource");
                this.f37437p = jSONObject.optString("sharePath");
                this.f37438q = jSONObject.optString("shareImageUrl");
                this.f37439r = jSONObject.optString(CommunityConstants.TOPIC_ID);
                this.f37440s = jSONObject.optInt("shareChannel", 1);
                this.f37441t = jSONObject.optInt("shareImageWidth");
                this.f37442u = jSONObject.optInt("shareImageHeight");
                this.f37443v = jSONObject.optInt("fromPoster");
                if (com.hbg.module.libkt.base.ext.b.x(this.f37433l)) {
                    String optString = jSONObject.optString("shareText");
                    if (com.hbg.module.libkt.base.ext.b.x(optString)) {
                        optString = jSONObject.optString("shareContent");
                    }
                    this.f37433l = optString;
                }
            }
            Result.m3072constructorimpl(Unit.f56620a);
        } catch (Throwable th2) {
            Result.a aVar2 = Result.Companion;
            Result.m3072constructorimpl(k.a(th2));
        }
    }

    public final Uri zh() {
        return this.f37430i;
    }
}
