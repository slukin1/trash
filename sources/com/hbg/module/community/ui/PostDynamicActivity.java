package com.hbg.module.community.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.view.View;
import android.widget.Checkable;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.z;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.common.utils.SoftInputUtils;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo;
import com.hbg.lib.network.hbg.core.bean.TopicDetailInfo;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.community.data.TopicData;
import com.hbg.module.community.viewmodel.PostDynamicViewModel;
import com.hbg.module.community.widgets.rich.RichEditor;
import com.hbg.module.content.R$color;
import com.hbg.module.content.R$string;
import com.hbg.module.libkt.base.ext.VmState;
import com.hbg.module.libkt.base.ui.BaseActivity;
import com.hbg.module.libkt.helper.s3.S3UploadHelper;
import com.hbg.module.libkt.helper.s3.S3UploadInterface;
import com.hbg.module.libkt.provider.HbgBaseContentProvider;
import com.hbg.module.libkt.utils.b;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Pair;
import kotlin.coroutines.CoroutineContext;
import kotlin.f;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlin.l;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.v0;
import lc.u;
import rd.q;
import rd.s;

@Route(path = "/content/CommunityPublisher")
public final class PostDynamicActivity extends BaseActivity<u> {

    /* renamed from: s  reason: collision with root package name */
    public static final a f17490s = new a((r) null);

    /* renamed from: i  reason: collision with root package name */
    public PostDynamicViewModel f17491i;

    /* renamed from: j  reason: collision with root package name */
    public Uri f17492j;

    /* renamed from: k  reason: collision with root package name */
    public String f17493k = "";

    /* renamed from: l  reason: collision with root package name */
    public String f17494l;

    /* renamed from: m  reason: collision with root package name */
    public String f17495m = "";

    /* renamed from: n  reason: collision with root package name */
    public final List<TopicData> f17496n = new ArrayList();

    /* renamed from: o  reason: collision with root package name */
    public final StringBuilder f17497o = new StringBuilder();

    /* renamed from: p  reason: collision with root package name */
    public TopicDetailInfo.HeaderInfo f17498p;

    /* renamed from: q  reason: collision with root package name */
    public String f17499q;

    /* renamed from: r  reason: collision with root package name */
    public String f17500r;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public static final class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17501b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17502c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ PostDynamicActivity f17503d;

        public b(View view, long j11, PostDynamicActivity postDynamicActivity) {
            this.f17501b = view;
            this.f17502c = j11;
            this.f17503d = postDynamicActivity;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17501b) > this.f17502c || (this.f17501b instanceof Checkable)) {
                sVar.e(this.f17501b, currentTimeMillis);
                TextView textView = (TextView) this.f17501b;
                Pair[] pairArr = new Pair[2];
                String Ch = this.f17503d.f17499q;
                String str = "";
                if (Ch == null) {
                    Ch = str;
                }
                pairArr[0] = l.a("TransPair_current_id", Ch);
                String Hh = this.f17503d.f17500r;
                if (Hh != null) {
                    str = Hh;
                }
                pairArr[1] = l.a("markets_kline_class", str);
                q.a("app_community_fban", MapsKt__MapsKt.j(pairArr));
                textView.setEnabled(false);
                this.f17503d.Th();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class c implements hc.e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PostDynamicActivity f17504a;

        public static final class a implements S3UploadInterface {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ PostDynamicActivity f17505a;

            public a(PostDynamicActivity postDynamicActivity) {
                this.f17505a = postDynamicActivity;
            }

            public void upLoadCallback(int i11, String str, String str2) {
                if (i11 != 0 || com.hbg.module.libkt.base.ext.b.x(str2)) {
                    HuobiToastUtil.g(R$string.n_service_error);
                } else {
                    PostDynamicActivity.Ah(this.f17505a).E.p();
                    PostDynamicActivity.Ah(this.f17505a).E.q(str2, this.f17505a.f17493k);
                }
                this.f17505a.Df();
            }
        }

        public c(PostDynamicActivity postDynamicActivity) {
            this.f17504a = postDynamicActivity;
        }

        public static final void c(PostDynamicActivity postDynamicActivity) {
            postDynamicActivity.sh();
        }

        public void a(Uri uri, String str) {
            this.f17504a.f17492j = uri;
            this.f17504a.f17493k = str;
            Handler Bh = this.f17504a.Zf();
            if (Bh != null) {
                Bh.postDelayed(new p(this.f17504a), 500);
            }
            PostDynamicActivity postDynamicActivity = this.f17504a;
            S3UploadHelper.upLoad(postDynamicActivity, uri, str, new a(postDynamicActivity));
        }
    }

    public static final class d implements RichEditor.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PostDynamicActivity f17506a;

        public d(PostDynamicActivity postDynamicActivity) {
            this.f17506a = postDynamicActivity;
        }

        public void onTextChange(String str) {
            this.f17506a.f17494l = str;
        }
    }

    public static final class e implements z, kotlin.jvm.internal.u {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d10.l f17507b;

        public e(d10.l lVar) {
            this.f17507b = lVar;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof z) || !(obj instanceof kotlin.jvm.internal.u)) {
                return false;
            }
            return x.b(getFunctionDelegate(), ((kotlin.jvm.internal.u) obj).getFunctionDelegate());
        }

        public final f<?> getFunctionDelegate() {
            return this.f17507b;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f17507b.invoke(obj);
        }
    }

    public static final /* synthetic */ u Ah(PostDynamicActivity postDynamicActivity) {
        return (u) postDynamicActivity.Yf();
    }

    @SensorsDataInstrumented
    public static final void Rh(PostDynamicActivity postDynamicActivity, View view) {
        hc.d.f19133a.h(postDynamicActivity, new c(postDynamicActivity));
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static final void Sh(PostDynamicActivity postDynamicActivity) {
        if (!SoftInputUtils.i(postDynamicActivity, ((u) postDynamicActivity.Yf()).E)) {
            SoftInputUtils.m(postDynamicActivity, ((u) postDynamicActivity.Yf()).E);
            ((u) postDynamicActivity.Yf()).E.p();
        }
    }

    public final void Nh() {
        q.a("app_community_qxan", (HashMap<?, ?>) null);
        finish();
    }

    /* renamed from: Oh */
    public u Og() {
        return u.K(getLayoutInflater());
    }

    public final void Ph() {
        MutableLiveData<VmState<DynamicDetailInfo>> h02;
        PostDynamicViewModel postDynamicViewModel = this.f17491i;
        if (!(postDynamicViewModel == null || (h02 = postDynamicViewModel.h0()) == null)) {
            h02.observe(this, new e(new PostDynamicActivity$initObserve$1(this)));
        }
        we.b.m("topicSendData", (Class) null, 2, (Object) null).observe(this, new e(new PostDynamicActivity$initObserve$2(this)));
    }

    public final void Qh() {
        Serializable serializableExtra;
        Intent intent = getIntent();
        if (intent != null && (serializableExtra = intent.getSerializableExtra("topicInfo")) != null) {
            this.f17498p = (TopicDetailInfo.HeaderInfo) serializableExtra;
            n1 unused = i.d(i0.a(v0.b()), (CoroutineContext) null, (CoroutineStart) null, new PostDynamicActivity$initTopic$1$1$1(this, (kotlin.coroutines.c<? super PostDynamicActivity$initTopic$1$1$1>) null), 3, (Object) null);
        }
    }

    public final void Th() {
        String obj = ((u) Yf()).B.getText().toString();
        String str = this.f17494l;
        if (com.hbg.module.libkt.base.ext.b.x(str)) {
            HuobiToastUtil.i(getResources().getString(R$string.n_content_please_input_content));
            ((u) Yf()).G.setEnabled(true);
            return;
        }
        sh();
        PostDynamicViewModel postDynamicViewModel = this.f17491i;
        if (postDynamicViewModel != null) {
            PostDynamicViewModel.j0(postDynamicViewModel, obj, (String) null, (String) null, str, this.f17497o.toString(), this.f17499q, 6, (Object) null);
        }
    }

    public final void Uh() {
        try {
            ((HbgBaseContentProvider) b2.a.d().a("/provider/content/jump").navigation()).l(this, 1, this.f17495m);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public void finish() {
        if (!com.hbg.module.libkt.base.ext.b.x(this.f17494l)) {
            SP.s("rich_title", ((u) Yf()).B.getText().toString());
            SP.s("rich_content", this.f17494l);
        }
        super.finish();
    }

    public void initView() {
        super.initView();
        if (BaseModuleConfig.a().L()) {
            gc.b.d(gc.b.f19131a, (String) null, (TopicDetailInfo.HeaderInfo) null, (String) null, (String) null, 15, (Object) null);
            finish();
            return;
        }
        Qg(NightHelper.e().g());
        b.a.b(com.hbg.module.libkt.utils.b.f24864f, findViewById(16908290), 0, 2, (Object) null);
        ((u) Yf()).M(this);
        ((u) Yf()).B.setText(SP.i("rich_title", (String) null));
        this.f17491i = (PostDynamicViewModel) new ViewModelProvider(this).a(PostDynamicViewModel.class);
        Ph();
        ((u) Yf()).E.setBackgroundColor(getResources().getColor(R$color.baseColorContentBackground));
        ((u) Yf()).E.s(getResources().getString(R$string.n_content_please_input_content), NightHelper.e().g() ? "black" : "white");
        if (!com.hbg.module.libkt.base.ext.b.x(this.f17494l)) {
            ((u) Yf()).E.setHtml(this.f17494l);
        }
        ((u) Yf()).E.setEditorFontSize(15);
        ((u) Yf()).E.setEditorFontColor(getResources().getColor(R$color.community_black_font_color));
        ((u) Yf()).E.setPadding(15, 12, 15, 12);
        ((u) Yf()).D.setOnClickListener(new n(this));
        ((u) Yf()).E.setOnTextChangeListener(new d(this));
        s sVar = s.f23381a;
        TextView textView = ((u) Yf()).G;
        textView.setOnClickListener(new b(textView, 800, this));
        Qh();
        Handler Zf = Zf();
        if (Zf != null) {
            Zf.postDelayed(new o(this), 500);
        }
        Pair[] pairArr = new Pair[2];
        String str = this.f17499q;
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        pairArr[0] = l.a("TransPair_current_id", str);
        String str3 = this.f17500r;
        if (str3 != null) {
            str2 = str3;
        }
        pairArr[1] = l.a("markets_kline_class", str2);
        q.a("app_community_fbpage", MapsKt__MapsKt.j(pairArr));
    }

    public void oh() {
        super.oh();
        this.f17494l = SP.i("rich_content", (String) null);
        this.f17499q = getIntent().getStringExtra("symbol");
        this.f17500r = getIntent().getStringExtra("tradeType");
    }
}
