package com.hbg.module.content.ui.activity;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.page.SmartRefreshFooter;
import com.hbg.lib.core.page.SmartRefreshHeader;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.network.hbg.core.bean.CommentImageInfo;
import com.hbg.lib.network.hbg.core.bean.CommentInfo;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.photoviewer.PhotoViewerUtils;
import com.hbg.lib.widgets.photoviewer.data.ImageData;
import com.hbg.module.content.R$string;
import com.hbg.module.content.adapter.CommentListAdapter;
import com.hbg.module.content.utls.comment.CommentExtKt;
import com.hbg.module.content.utls.m;
import com.hbg.module.content.utls.o;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import com.hbg.module.libkt.base.ui.BaseActivity;
import com.hbg.module.libkt.provider.HbgBaseProvider;
import com.huochat.community.base.CommunityConstants;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d10.l;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.u;
import kotlin.jvm.internal.x;
import ky.j;
import rd.s;

@Route(path = "/content/commentDetail")
public final class CommentDetailActivity extends BaseActivity<lc.a> {

    /* renamed from: i  reason: collision with root package name */
    public String f18255i;

    /* renamed from: j  reason: collision with root package name */
    public String f18256j = "1";

    /* renamed from: k  reason: collision with root package name */
    public String f18257k = "";

    /* renamed from: l  reason: collision with root package name */
    public String f18258l = "";

    /* renamed from: m  reason: collision with root package name */
    public CommentInfo f18259m;

    /* renamed from: n  reason: collision with root package name */
    public CommentListAdapter f18260n;

    /* renamed from: o  reason: collision with root package name */
    public String f18261o = "0";

    /* renamed from: p  reason: collision with root package name */
    public int f18262p = 1;

    public static final class a implements rc.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CommentDetailActivity f18263a;

        public a(CommentDetailActivity commentDetailActivity) {
            this.f18263a = commentDetailActivity;
        }

        public void a(CommentInfo commentInfo, int i11) {
            if (commentInfo != null) {
                CommentDetailActivity commentDetailActivity = this.f18263a;
                CommentListAdapter Dh = commentDetailActivity.f18260n;
                if (Dh != null) {
                    Dh.H(0, commentInfo);
                }
                if (!com.hbg.module.libkt.base.ext.b.x(commentDetailActivity.f18255i)) {
                    we.c cVar = we.c.f26319a;
                    int i12 = x.b(commentDetailActivity.f18256j, "1") ? 1 : 2;
                    String Gh = commentDetailActivity.f18255i;
                    we.c.o(i12, (Gh != null ? Long.valueOf(Long.parseLong(Gh)) : null).longValue(), commentDetailActivity.f18257k, i11, 0, commentInfo, true, false, (String) null, com.sumsub.sns.internal.ml.autocapture.b.f34945b, (Object) null);
                }
            }
            this.f18263a.Df();
        }

        public void b() {
            this.f18263a.uh(false, true);
        }
    }

    public static final class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f18264b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f18265c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CommentDetailActivity f18266d;

        public b(View view, long j11, CommentDetailActivity commentDetailActivity) {
            this.f18264b = view;
            this.f18265c = j11;
            this.f18266d = commentDetailActivity;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f18264b) > this.f18265c || (this.f18264b instanceof Checkable)) {
                sVar.e(this.f18264b, currentTimeMillis);
                LinearLayout linearLayout = (LinearLayout) this.f18264b;
                this.f18266d.Uh();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f18267b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f18268c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CommentDetailActivity f18269d;

        public c(View view, long j11, CommentDetailActivity commentDetailActivity) {
            this.f18267b = view;
            this.f18268c = j11;
            this.f18269d = commentDetailActivity;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f18267b) > this.f18268c || (this.f18267b instanceof Checkable)) {
                sVar.e(this.f18267b, currentTimeMillis);
                TextView textView = (TextView) this.f18267b;
                this.f18269d.Nh();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class d implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f18270b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f18271c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CommentDetailActivity f18272d;

        public d(View view, long j11, CommentDetailActivity commentDetailActivity) {
            this.f18270b = view;
            this.f18271c = j11;
            this.f18272d = commentDetailActivity;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            boolean z11;
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f18270b) > this.f18271c || (this.f18270b instanceof Checkable)) {
                sVar.e(this.f18270b, currentTimeMillis);
                ImageView imageView = (ImageView) this.f18270b;
                o oVar = o.f18923a;
                CommentDetailActivity commentDetailActivity = this.f18272d;
                e eVar = new e(this.f18272d);
                boolean z12 = false;
                if (BaseModuleConfig.a().s() != 1) {
                    CommentInfo Bh = this.f18272d.f18259m;
                    if (!(Bh != null && Bh.selfComment == 1)) {
                        z11 = false;
                        CommentInfo Bh2 = this.f18272d.f18259m;
                        if (Bh2 != null && Bh2.selfComment == 1) {
                            z12 = true;
                        }
                        o.f(oVar, commentDetailActivity, imageView, eVar, false, z11, true ^ z12, false, 72, (Object) null);
                    }
                }
                z11 = true;
                CommentInfo Bh22 = this.f18272d.f18259m;
                z12 = true;
                o.f(oVar, commentDetailActivity, imageView, eVar, false, z11, true ^ z12, false, 72, (Object) null);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class e implements m {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CommentDetailActivity f18273a;

        public e(CommentDetailActivity commentDetailActivity) {
            this.f18273a = commentDetailActivity;
        }

        public void a() {
            m.a.c(this);
            DialogUtils.S(this.f18273a);
        }

        public void b() {
            m.a.e(this);
        }

        public void c(int i11) {
            m.a.b(this, i11);
        }

        public void d() {
            m.a.d(this);
        }

        public void e() {
            m.a.a(this);
            this.f18273a.Oh();
        }
    }

    public static final class f implements z, u {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ l f18274b;

        public f(l lVar) {
            this.f18274b = lVar;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof z) || !(obj instanceof u)) {
                return false;
            }
            return x.b(getFunctionDelegate(), ((u) obj).getFunctionDelegate());
        }

        public final kotlin.f<?> getFunctionDelegate() {
            return this.f18274b;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f18274b.invoke(obj);
        }
    }

    public static final class g implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f18275b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f18276c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CommentDetailActivity f18277d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CommentImageInfo f18278e;

        public g(View view, long j11, CommentDetailActivity commentDetailActivity, CommentImageInfo commentImageInfo) {
            this.f18275b = view;
            this.f18276c = j11;
            this.f18277d = commentDetailActivity;
            this.f18278e = commentImageInfo;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f18275b) > this.f18276c || (this.f18275b instanceof Checkable)) {
                sVar.e(this.f18275b, currentTimeMillis);
                FrameLayout frameLayout = (FrameLayout) this.f18275b;
                CommentDetailActivity commentDetailActivity = this.f18277d;
                CommentImageInfo commentImageInfo = this.f18278e;
                PhotoViewerUtils.a(commentDetailActivity, CollectionsKt__CollectionsKt.p(new ImageData(commentImageInfo.image, commentImageInfo.thumbImage)), 0);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final /* synthetic */ lc.a Eh(CommentDetailActivity commentDetailActivity) {
        return (lc.a) commentDetailActivity.Yf();
    }

    public static final void Ph(HBDialogFragment hBDialogFragment) {
        if (hBDialogFragment != null) {
            hBDialogFragment.dismiss();
        }
    }

    public static final void Qh(CommentDetailActivity commentDetailActivity, HBDialogFragment hBDialogFragment) {
        if (hBDialogFragment != null) {
            hBDialogFragment.dismiss();
        }
        commentDetailActivity.Vh();
    }

    @SensorsDataInstrumented
    public static final void Th(CommentDetailActivity commentDetailActivity, View view) {
        commentDetailActivity.Rh();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void Nh() {
        HbgBaseProvider fg2 = fg();
        boolean z11 = true;
        if (fg2 == null || !fg2.j(this)) {
            z11 = false;
        }
        if (z11) {
            CommentExtKt.e(this, this.f18255i, this.f18256j, this.f18258l, new a(this), this.f18257k, (String) null, com.hbg.module.libkt.base.ext.b.j(R$string.n_community_add_reply), 32, (Object) null);
        }
    }

    public final void Oh() {
        HbgBaseProvider fg2 = fg();
        boolean z11 = true;
        if (fg2 == null || !fg2.j(this)) {
            z11 = false;
        }
        if (z11) {
            DialogUtils.c0(this, com.hbg.module.libkt.base.ext.b.j(R$string.n_comment_del_tips), (String) null, com.hbg.module.libkt.base.ext.b.j(R$string.n_cancel), com.hbg.module.libkt.base.ext.b.j(R$string.n_confirm), c.f18332a, new b(this));
        }
    }

    public void P8(j jVar) {
        super.P8(jVar);
        Rh();
    }

    public final void Rh() {
        RequestExtKt.d(v7.b.a().getCommentList(this.f18255i, this.f18256j, this.f18257k, this.f18261o, 20, 1), new CommentDetailActivity$getCommentList$1(this), new CommentDetailActivity$getCommentList$2(this), (MutableLiveData) null, 4, (Object) null);
    }

    /* renamed from: Sh */
    public lc.a Og() {
        return lc.a.K(getLayoutInflater());
    }

    public final void Uh() {
        HbgBaseProvider fg2 = fg();
        boolean z11 = false;
        if (fg2 != null && fg2.j(this)) {
            z11 = true;
        }
        if (z11) {
            RequestExtKt.d(v7.b.a().D0(this.f18257k, 1), new CommentDetailActivity$praise$1(this), CommentDetailActivity$praise$2.INSTANCE, (MutableLiveData) null, 4, (Object) null);
        }
    }

    public final void Vh() {
        RequestExtKt.d(v7.b.a().C(this.f18257k), new CommentDetailActivity$sendDelRequest$1(this), CommentDetailActivity$sendDelRequest$2.INSTANCE, (MutableLiveData) null, 4, (Object) null);
    }

    public final void Wh() {
        List<CommentImageInfo> list;
        CommentImageInfo commentImageInfo;
        TextView textView = ((lc.a) Yf()).M;
        CommentInfo commentInfo = this.f18259m;
        String str = null;
        textView.setVisibility(com.hbg.module.libkt.base.ext.b.x(commentInfo != null ? commentInfo.content : null) ? 8 : 0);
        CommentInfo commentInfo2 = this.f18259m;
        boolean z11 = true;
        if (commentInfo2 == null || commentInfo2.hasImg != 1) {
            z11 = false;
        }
        if (z11) {
            if ((commentInfo2 != null ? commentInfo2.imgList : null) != null) {
                if ((commentInfo2 != null ? commentInfo2.imgList : null).size() > 0) {
                    CommentImageInfo commentImageInfo2 = this.f18259m.imgList.get(0);
                    AppCompatImageView appCompatImageView = ((lc.a) Yf()).B;
                    ViewGroup.LayoutParams layoutParams = appCompatImageView.getLayoutParams();
                    Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                    layoutParams.height = CommentExtKt.j(Float.parseFloat(commentImageInfo2.width), Float.parseFloat(commentImageInfo2.height), com.hbg.module.libkt.base.ext.c.a(120.0f));
                    layoutParams.width = com.hbg.module.libkt.base.ext.c.a(120.0f);
                    appCompatImageView.setLayoutParams(layoutParams);
                    if ((Float.parseFloat(commentImageInfo2.height) / Float.parseFloat(commentImageInfo2.width)) * ((float) com.hbg.module.libkt.base.ext.c.a(120.0f)) >= 2000.0f) {
                        ((lc.a) Yf()).C.setVisibility(0);
                    } else {
                        ((lc.a) Yf()).C.setVisibility(8);
                    }
                    f6.c a11 = f6.c.a();
                    AppCompatImageView appCompatImageView2 = ((lc.a) Yf()).B;
                    CommentInfo commentInfo3 = this.f18259m;
                    if (!(commentInfo3 == null || (list = commentInfo3.imgList) == null || (commentImageInfo = list.get(0)) == null)) {
                        str = commentImageInfo.thumbImage;
                    }
                    a11.e(appCompatImageView2, str);
                    ((lc.a) Yf()).D.setVisibility(0);
                    s sVar = s.f23381a;
                    FrameLayout frameLayout = ((lc.a) Yf()).D;
                    frameLayout.setOnClickListener(new g(frameLayout, 800, this, commentImageInfo2));
                    return;
                }
            }
        }
        ((lc.a) Yf()).B.setVisibility(8);
    }

    public void bf(j jVar) {
        super.bf(jVar);
        this.f18262p = 1;
        this.f18261o = "0";
        ((lc.a) Yf()).J.setNoMoreData(false);
        Rh();
    }

    public void initView() {
        super.initView();
        Qg(NightHelper.e().g());
        ((lc.a) Yf()).N(this);
        ((lc.a) Yf()).M(this.f18259m);
        if (x.b(this.f18256j, "4")) {
            nc.c.a("app_community_tzxqpl", MapsKt__MapsKt.j(kotlin.l.a(CommunityConstants.TOPIC_ID, this.f18255i), kotlin.l.a("topicType", this.f18256j), kotlin.l.a("commentId", this.f18257k)));
        }
        this.f18260n = new CommentListAdapter(this, this.f18255i, this.f18256j, this.f18258l, true, this.f18257k);
        ((lc.a) Yf()).J.j0(new SmartRefreshHeader(this));
        ((lc.a) Yf()).J.h0(new SmartRefreshFooter(this));
        ((lc.a) Yf()).J.e0(this);
        ((lc.a) Yf()).K.setLayoutManager(com.hbg.module.libkt.base.ext.b.t(this));
        ((lc.a) Yf()).K.setAdapter(this.f18260n);
        ((lc.a) Yf()).K.setItemAnimator((RecyclerView.ItemAnimator) null);
        ((lc.a) Yf()).I.setOnRetryClickListener(new a(this));
        ((lc.a) Yf()).I.g();
        s sVar = s.f23381a;
        LinearLayout linearLayout = ((lc.a) Yf()).H;
        linearLayout.setOnClickListener(new b(linearLayout, 800, this));
        TextView textView = ((lc.a) Yf()).P;
        textView.setOnClickListener(new c(textView, 800, this));
        ImageView imageView = ((lc.a) Yf()).E;
        imageView.setOnClickListener(new d(imageView, 800, this));
        sh();
        Rh();
        we.c.a(this, new f(new CommentDetailActivity$initView$5(this)));
    }

    public void oh() {
        super.oh();
        String stringExtra = getIntent().getStringExtra(CommunityConstants.TOPIC_ID);
        if (stringExtra != null) {
            this.f18255i = stringExtra;
        }
        String stringExtra2 = getIntent().getStringExtra("topicType");
        if (stringExtra2 != null) {
            this.f18256j = stringExtra2;
        }
        String stringExtra3 = getIntent().getStringExtra("commentId");
        if (stringExtra3 != null) {
            this.f18257k = stringExtra3;
        }
        String stringExtra4 = getIntent().getStringExtra("symbols");
        if (stringExtra4 != null) {
            this.f18258l = stringExtra4;
        }
    }
}
