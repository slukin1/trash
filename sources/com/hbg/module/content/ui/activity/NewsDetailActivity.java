package com.hbg.module.content.ui.activity;

import android.animation.Animator;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.z;
import com.airbnb.lottie.LottieAnimationView;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.page.SmartRefreshFooter;
import com.hbg.lib.core.page.SmartRefreshHeader;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.core.util.w;
import com.hbg.lib.network.hbg.IHbgApi;
import com.hbg.lib.network.hbg.core.bean.CommentInfo;
import com.hbg.lib.network.hbg.core.bean.NewFlashInformation;
import com.hbg.lib.network.hbg.core.bean.NewFlashInformationImage;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.photoviewer.PhotoViewerUtils;
import com.hbg.lib.widgets.photoviewer.data.ImageData;
import com.hbg.module.content.R$color;
import com.hbg.module.content.R$drawable;
import com.hbg.module.content.R$font;
import com.hbg.module.content.R$id;
import com.hbg.module.content.R$raw;
import com.hbg.module.content.adapter.CommentListAdapter;
import com.hbg.module.content.interfaces.NoDoubleClickListener;
import com.hbg.module.content.utls.comment.CommentExtKt;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import com.hbg.module.libkt.base.ui.BaseActivity;
import com.hbg.module.libkt.provider.HbgBaseProvider;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.wtree.helper.Utils;
import d10.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.u;
import kotlin.jvm.internal.x;
import lc.q;
import nc.b;
import rd.s;

public final class NewsDetailActivity extends BaseActivity<q> {

    /* renamed from: i  reason: collision with root package name */
    public String f18294i;

    /* renamed from: j  reason: collision with root package name */
    public int f18295j;

    /* renamed from: k  reason: collision with root package name */
    public NewFlashInformation f18296k;

    /* renamed from: l  reason: collision with root package name */
    public String f18297l = "0";

    /* renamed from: m  reason: collision with root package name */
    public int f18298m = 1;

    /* renamed from: n  reason: collision with root package name */
    public CommentListAdapter f18299n;

    /* renamed from: o  reason: collision with root package name */
    public com.hbg.module.content.adapter.g f18300o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f18301p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f18302q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f18303r = true;

    public static final class a implements rc.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewsDetailActivity f18304a;

        public a(NewsDetailActivity newsDetailActivity) {
            this.f18304a = newsDetailActivity;
        }

        public void a(CommentInfo commentInfo, int i11) {
            CommentInfo commentInfo2 = commentInfo;
            if (commentInfo2 != null) {
                NewsDetailActivity newsDetailActivity = this.f18304a;
                CommentListAdapter Ch = newsDetailActivity.f18299n;
                if (Ch != null) {
                    Ch.H(0, commentInfo2);
                }
                NewsDetailActivity.Dh(newsDetailActivity).f19308m0.setVisibility(8);
                NewsDetailActivity.Dh(newsDetailActivity).f19309n0.setVisibility(8);
                String Fh = newsDetailActivity.f18294i;
                if (Fh == null) {
                    Fh = null;
                }
                we.c.o(1, Long.parseLong(Fh), (String) null, i11, 0, (CommentInfo) null, false, false, (String) null, 500, (Object) null);
            }
            this.f18304a.Df();
        }

        public void b() {
            this.f18304a.uh(false, true);
        }
    }

    public static final class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f18305b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f18306c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ NewsDetailActivity f18307d;

        public b(View view, long j11, NewsDetailActivity newsDetailActivity) {
            this.f18305b = view;
            this.f18306c = j11;
            this.f18307d = newsDetailActivity;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f18305b) > this.f18306c || (this.f18305b instanceof Checkable)) {
                sVar.e(this.f18305b, currentTimeMillis);
                ConstraintLayout constraintLayout = (ConstraintLayout) this.f18305b;
                this.f18307d.ki(1);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f18308b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f18309c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ NewsDetailActivity f18310d;

        public c(View view, long j11, NewsDetailActivity newsDetailActivity) {
            this.f18308b = view;
            this.f18309c = j11;
            this.f18310d = newsDetailActivity;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f18308b) > this.f18309c || (this.f18308b instanceof Checkable)) {
                sVar.e(this.f18308b, currentTimeMillis);
                ConstraintLayout constraintLayout = (ConstraintLayout) this.f18308b;
                this.f18310d.ki(2);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class d implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f18311b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f18312c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ NewsDetailActivity f18313d;

        public d(View view, long j11, NewsDetailActivity newsDetailActivity) {
            this.f18311b = view;
            this.f18312c = j11;
            this.f18313d = newsDetailActivity;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f18311b) > this.f18312c || (this.f18311b instanceof Checkable)) {
                sVar.e(this.f18311b, currentTimeMillis);
                ImageView imageView = (ImageView) this.f18311b;
                this.f18313d.ji(2);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class e implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f18314b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f18315c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ NewsDetailActivity f18316d;

        public e(View view, long j11, NewsDetailActivity newsDetailActivity) {
            this.f18314b = view;
            this.f18315c = j11;
            this.f18316d = newsDetailActivity;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f18314b) > this.f18315c || (this.f18314b instanceof Checkable)) {
                sVar.e(this.f18314b, currentTimeMillis);
                RelativeLayout relativeLayout = (RelativeLayout) this.f18314b;
                NewsDetailActivity newsDetailActivity = this.f18316d;
                NewFlashInformation Bh = newsDetailActivity.f18296k;
                newsDetailActivity.gi(Bh != null ? Bh.getId() : 0);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class f implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f18317b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f18318c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ NewsDetailActivity f18319d;

        public f(View view, long j11, NewsDetailActivity newsDetailActivity) {
            this.f18317b = view;
            this.f18318c = j11;
            this.f18319d = newsDetailActivity;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f18317b) > this.f18318c || (this.f18317b instanceof Checkable)) {
                sVar.e(this.f18317b, currentTimeMillis);
                ImageView imageView = (ImageView) this.f18317b;
                NewFlashInformation Bh = this.f18319d.f18296k;
                if (Bh != null) {
                    ArrayList arrayList = new ArrayList();
                    List<NewFlashInformationImage> images = Bh.getImages();
                    if (images != null) {
                        for (NewFlashInformationImage newFlashInformationImage : images) {
                            arrayList.add(new ImageData(newFlashInformationImage.getImage(), newFlashInformationImage.getThumbImage()));
                        }
                    }
                    PhotoViewerUtils.a(this.f18319d, arrayList, 0);
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class g implements View.OnLongClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f18320b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f18321c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ NewsDetailActivity f18322d;

        public g(View view, long j11, NewsDetailActivity newsDetailActivity) {
            this.f18320b = view;
            this.f18321c = j11;
            this.f18322d = newsDetailActivity;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0033, code lost:
            r7 = (com.hbg.lib.network.hbg.core.bean.NewFlashInformationImage) kotlin.collections.CollectionsKt___CollectionsKt.c0(r7);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean onLongClick(android.view.View r7) {
            /*
                r6 = this;
                long r0 = java.lang.System.currentTimeMillis()
                rd.s r7 = rd.s.f23381a
                android.view.View r2 = r6.f18320b
                long r2 = r7.b(r2)
                long r2 = r0 - r2
                long r4 = r6.f18321c
                int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r2 > 0) goto L_0x001a
                android.view.View r2 = r6.f18320b
                boolean r2 = r2 instanceof android.widget.Checkable
                if (r2 == 0) goto L_0x0044
            L_0x001a:
                android.view.View r2 = r6.f18320b
                r7.e(r2, r0)
                android.view.View r7 = r6.f18320b
                android.widget.ImageView r7 = (android.widget.ImageView) r7
                com.hbg.module.content.ui.activity.NewsDetailActivity r7 = r6.f18322d
                com.hbg.lib.network.hbg.core.bean.NewFlashInformation r7 = r7.f18296k
                if (r7 == 0) goto L_0x0044
                com.hbg.module.content.ui.activity.NewsDetailActivity r0 = r6.f18322d
                java.util.List r7 = r7.getImages()
                if (r7 == 0) goto L_0x0040
                java.lang.Object r7 = kotlin.collections.CollectionsKt___CollectionsKt.c0(r7)
                com.hbg.lib.network.hbg.core.bean.NewFlashInformationImage r7 = (com.hbg.lib.network.hbg.core.bean.NewFlashInformationImage) r7
                if (r7 == 0) goto L_0x0040
                java.lang.String r7 = r7.getImage()
                goto L_0x0041
            L_0x0040:
                r7 = 0
            L_0x0041:
                com.hbg.lib.core.util.SaveImageUtils.h(r0, r7)
            L_0x0044:
                r7 = 1
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.content.ui.activity.NewsDetailActivity.g.onLongClick(android.view.View):boolean");
        }
    }

    public static final class h extends NoDoubleClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ NewsDetailActivity f18323b;

        public h(NewsDetailActivity newsDetailActivity) {
            this.f18323b = newsDetailActivity;
        }

        public void onViewClick(View view) {
            this.f18323b.Wh();
        }
    }

    public static final class i implements z, u {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ l f18324b;

        public i(l lVar) {
            this.f18324b = lVar;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof z) || !(obj instanceof u)) {
                return false;
            }
            return x.b(getFunctionDelegate(), ((u) obj).getFunctionDelegate());
        }

        public final kotlin.f<?> getFunctionDelegate() {
            return this.f18324b;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f18324b.invoke(obj);
        }
    }

    public static final class j implements Animator.AnimatorListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ NewsDetailActivity f18326b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ LottieAnimationView f18327c;

        public j(NewsDetailActivity newsDetailActivity, LottieAnimationView lottieAnimationView) {
            this.f18326b = newsDetailActivity;
            this.f18327c = lottieAnimationView;
        }

        public void onAnimationCancel(Animator animator) {
            this.f18327c.setVisibility(8);
            NewsDetailActivity.Dh(this.f18326b).L.setVisibility(0);
        }

        public void onAnimationEnd(Animator animator) {
            this.f18327c.setVisibility(8);
            NewsDetailActivity.Dh(this.f18326b).L.setVisibility(0);
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
            NewsDetailActivity.Dh(this.f18326b).L.setVisibility(4);
            this.f18327c.setVisibility(0);
        }
    }

    public static final class k implements Animator.AnimatorListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ NewsDetailActivity f18328b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ LottieAnimationView f18329c;

        public k(NewsDetailActivity newsDetailActivity, LottieAnimationView lottieAnimationView) {
            this.f18328b = newsDetailActivity;
            this.f18329c = lottieAnimationView;
        }

        public void onAnimationCancel(Animator animator) {
            this.f18329c.setVisibility(8);
            NewsDetailActivity.Dh(this.f18328b).K.setVisibility(0);
        }

        public void onAnimationEnd(Animator animator) {
            this.f18329c.setVisibility(8);
            NewsDetailActivity.Dh(this.f18328b).K.setVisibility(0);
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
            NewsDetailActivity.Dh(this.f18328b).K.setVisibility(4);
            this.f18329c.setVisibility(0);
        }
    }

    public static final /* synthetic */ q Dh(NewsDetailActivity newsDetailActivity) {
        return (q) newsDetailActivity.Yf();
    }

    public static final void Uh(NewsDetailActivity newsDetailActivity) {
        newsDetailActivity.ji(1);
    }

    public static /* synthetic */ void ai(NewsDetailActivity newsDetailActivity, NewFlashInformation newFlashInformation, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        newsDetailActivity.Zh(newFlashInformation, z11);
    }

    @SensorsDataInstrumented
    public static final void bi(NewsDetailActivity newsDetailActivity, View view) {
        newsDetailActivity.Xh();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void P8(ky.j jVar) {
        super.P8(jVar);
        Wh();
    }

    public final void Sh(int i11) {
        boolean z11 = false;
        ((q) Yf()).C.setExpanded(false, true);
        if (i11 == 1 || i11 == 2) {
            Pair[] pairArr = new Pair[4];
            NewFlashInformation newFlashInformation = this.f18296k;
            pairArr[0] = kotlin.l.a("contentid", newFlashInformation != null ? Long.valueOf(newFlashInformation.getId()) : null);
            NewFlashInformation newFlashInformation2 = this.f18296k;
            pairArr[1] = kotlin.l.a("title", newFlashInformation2 != null ? newFlashInformation2.getTitle() : null);
            pairArr[2] = kotlin.l.a("entrance_type", i11 == 1 ? "icon" : "bottom_comment");
            pairArr[3] = kotlin.l.a("comment_state", "app_huobiNews_details");
            nc.c.a("app_comment_click", MapsKt__MapsKt.j(pairArr));
        }
        HbgBaseProvider fg2 = fg();
        if (fg2 != null && fg2.j(this)) {
            z11 = true;
        }
        if (z11) {
            String str = this.f18294i;
            CommentExtKt.e(this, str == null ? null : str, "1", "", new a(this), (String) null, (String) null, (String) null, 112, (Object) null);
        }
    }

    public final void Th() {
        DialogUtils.U(1, this, new g(this));
    }

    public final void Vh() {
        RequestExtKt.d(v7.b.a().getNewsBanner(), new NewsDetailActivity$getAdBanner$1(this), NewsDetailActivity$getAdBanner$2.INSTANCE, (MutableLiveData) null, 4, (Object) null);
    }

    public final void Wh() {
        IHbgApi a11 = v7.b.a();
        String str = this.f18294i;
        if (str == null) {
            str = null;
        }
        RequestExtKt.d(a11.getCommentList(str, "1", (String) null, this.f18297l, 20, 1), new NewsDetailActivity$getCommentList$1(this), new NewsDetailActivity$getCommentList$2(this), (MutableLiveData) null, 4, (Object) null);
    }

    public final void Xh() {
        IHbgApi a11 = v7.b.a();
        String str = this.f18294i;
        if (str == null) {
            str = null;
        }
        RequestExtKt.d(a11.getNewsDetail(Long.parseLong(str)), new NewsDetailActivity$getNewsDetail$1(this), new NewsDetailActivity$getNewsDetail$2(this), (MutableLiveData) null, 4, (Object) null);
    }

    /* renamed from: Yh */
    public q Og() {
        return q.K(getLayoutInflater());
    }

    public final void Zh(NewFlashInformation newFlashInformation, boolean z11) {
        String title = newFlashInformation.getTitle();
        String content = newFlashInformation.getContent();
        newFlashInformation.setTitle(newFlashInformation.getOldTitle());
        newFlashInformation.setOldTitle(title);
        newFlashInformation.setContent(newFlashInformation.getOldContent());
        newFlashInformation.setOldContent(content);
        newFlashInformation.setTrans(z11);
        ((q) Yf()).O(newFlashInformation);
    }

    public void bf(ky.j jVar) {
        super.bf(jVar);
        this.f18298m = 1;
        this.f18297l = "0";
        ((q) Yf()).Z.setNoMoreData(false);
        Xh();
    }

    public final void ci() {
        HbgBaseProvider fg2 = fg();
        boolean z11 = true;
        if (fg2 == null || !fg2.n()) {
            z11 = false;
        }
        if (z11 && this.f18302q && this.f18303r) {
            Sh(-1);
        }
    }

    public final void di() {
        if (this.f18302q && this.f18303r) {
            ((q) Yf()).C.setExpanded(false, true);
        }
    }

    public final void ei() {
        we.c.a(this, new i(new NewsDetailActivity$registerBus$1(this)));
        we.b.m("praiseNum", (Class) null, 2, (Object) null).observe(this, new i(new NewsDetailActivity$registerBus$2(this)));
    }

    public final void fi(int i11, boolean z11) {
        if (i11 == 0) {
            ((q) Yf()).J.setImageResource(R$drawable.information_like_new);
        } else {
            ((q) Yf()).J.setImageResource(R$drawable.information_like_focus_new);
        }
    }

    public void finish() {
        try {
            if (this.f18295j == 1) {
                BaseModuleConfig.a().h0(this);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        super.finish();
    }

    public final void gi(long j11) {
        Pair[] pairArr = new Pair[4];
        boolean z11 = false;
        pairArr[0] = kotlin.l.a("contentid", String.valueOf(j11));
        NewFlashInformation newFlashInformation = this.f18296k;
        String title = newFlashInformation != null ? newFlashInformation.getTitle() : null;
        if (title == null) {
            title = "";
        }
        pairArr[1] = kotlin.l.a("title", title);
        pairArr[2] = kotlin.l.a("uid", BaseModuleConfig.a().getUid());
        pairArr[3] = kotlin.l.a("state", 1);
        nc.c.a("app_dz_click", MapsKt__MapsKt.j(pairArr));
        HbgBaseProvider fg2 = fg();
        if (fg2 != null && fg2.j(this)) {
            z11 = true;
        }
        if (z11) {
            RequestExtKt.d(v7.b.a().D0(String.valueOf(j11), 2), new NewsDetailActivity$requestLike$1(this), NewsDetailActivity$requestLike$2.INSTANCE, (MutableLiveData) null, 4, (Object) null);
        }
    }

    public final void hi(int i11, ImageView imageView, TextView textView, ImageView imageView2, TextView textView2) {
        if (i11 != 1) {
            imageView.setImageResource(R$drawable.information_up_normal);
            textView.setTextColor(imageView.getResources().getColor(R$color.baseColorSecondaryTextNew));
        } else if (w.l()) {
            imageView.setImageResource(R$drawable.information_up_red);
            textView.setTextColor(imageView.getResources().getColor(R$color.color_rise_fall_red));
        } else {
            imageView.setImageResource(R$drawable.information_up_green);
            textView.setTextColor(imageView.getResources().getColor(R$color.color_rise_fall_green));
        }
        if (i11 != 2) {
            imageView2.setImageResource(R$drawable.information_down_normal);
            textView2.setTextColor(imageView2.getResources().getColor(R$color.baseColorSecondaryTextNew));
        } else if (w.l()) {
            imageView2.setImageResource(R$drawable.information_down_green);
            textView2.setTextColor(imageView2.getResources().getColor(R$color.color_rise_fall_green));
        } else {
            imageView2.setImageResource(R$drawable.information_down_red);
            textView2.setTextColor(imageView2.getResources().getColor(R$color.color_rise_fall_red));
        }
    }

    public final void ii(int i11, LottieAnimationView lottieAnimationView, LottieAnimationView lottieAnimationView2) {
        if (i11 == 1) {
            lottieAnimationView.setVisibility(0);
            lottieAnimationView.removeAllAnimatorListeners();
            lottieAnimationView.cancelAnimation();
            if (w.l()) {
                if (NightHelper.e().g()) {
                    lottieAnimationView.setAnimation(R$raw.newflash_red_rise_night);
                } else {
                    lottieAnimationView.setAnimation(R$raw.newflash_red_rise_day);
                }
                ((q) Yf()).f19304i0.setTextColor(lottieAnimationView.getResources().getColor(R$color.color_rise_fall_red));
            } else {
                if (NightHelper.e().g()) {
                    lottieAnimationView.setAnimation(R$raw.newflash_green_rise_night);
                } else {
                    lottieAnimationView.setAnimation(R$raw.newflash_green_rise_day);
                }
                ((q) Yf()).f19304i0.setTextColor(lottieAnimationView.getResources().getColor(R$color.color_rise_fall_green));
            }
            lottieAnimationView.addAnimatorListener(new j(this, lottieAnimationView));
            lottieAnimationView.playAnimation();
        } else if (i11 == 2) {
            lottieAnimationView2.setVisibility(0);
            lottieAnimationView2.removeAllAnimatorListeners();
            lottieAnimationView2.cancelAnimation();
            if (w.l()) {
                if (NightHelper.e().g()) {
                    lottieAnimationView2.setAnimation(R$raw.newflash_green_fall_night);
                } else {
                    lottieAnimationView2.setAnimation(R$raw.newflash_green_fall_day);
                }
                ((q) Yf()).f19302g0.setTextColor(lottieAnimationView2.getResources().getColor(R$color.color_rise_fall_green));
            } else {
                if (NightHelper.e().g()) {
                    lottieAnimationView2.setAnimation(R$raw.newflash_red_fall_night);
                } else {
                    lottieAnimationView2.setAnimation(R$raw.newflash_red_fall_day);
                }
                ((q) Yf()).f19302g0.setTextColor(lottieAnimationView2.getResources().getColor(R$color.color_rise_fall_red));
            }
            lottieAnimationView2.addAnimatorListener(new k(this, lottieAnimationView2));
            lottieAnimationView2.playAnimation();
        }
    }

    public void initView() {
        super.initView();
        Qg(NightHelper.e().g());
        ((q) Yf()).N(this);
        nc.c.b("MT_TCP_pv", (HashMap) null, 2, (Object) null);
        HbgBaseProvider fg2 = fg();
        boolean z11 = true;
        if (fg2 == null || !fg2.n()) {
            z11 = false;
        }
        this.f18301p = z11;
        ei();
        ((q) Yf()).Z.j0(new SmartRefreshHeader(this));
        ((q) Yf()).Z.h0(new SmartRefreshFooter(this));
        ((q) Yf()).Z.e0(this);
        ((q) Yf()).R.setOnRetryClickListener(new f(this));
        ((q) Yf()).R.g();
        sh();
        Xh();
        ((q) Yf()).U.cancelAnimation();
        ((q) Yf()).T.cancelAnimation();
        ((q) Yf()).U.setVisibility(8);
        ((q) Yf()).T.setVisibility(8);
        ((q) Yf()).L.setVisibility(0);
        ((q) Yf()).K.setVisibility(0);
        ((q) Yf()).M.setVisibility(0);
        s sVar = s.f23381a;
        ConstraintLayout constraintLayout = ((q) Yf()).F;
        constraintLayout.setOnClickListener(new b(constraintLayout, 800, this));
        ConstraintLayout constraintLayout2 = ((q) Yf()).E;
        constraintLayout2.setOnClickListener(new c(constraintLayout2, 800, this));
        ImageView imageView = ((q) Yf()).M;
        imageView.setOnClickListener(new d(imageView, 800, this));
        RelativeLayout relativeLayout = ((q) Yf()).W;
        relativeLayout.setOnClickListener(new e(relativeLayout, 800, this));
        ImageView imageView2 = ((q) Yf()).P;
        imageView2.setOnClickListener(new f(imageView2, 800, this));
        ImageView imageView3 = ((q) Yf()).P;
        imageView3.setOnLongClickListener(new g(imageView3, 800, this));
        ((TextView) ((q) Yf()).f19309n0.findViewById(R$id.viewErrorRetry)).setOnClickListener(new h(this));
        if (AppLanguageHelper.getInstance().isEnglishLanguage()) {
            TextView textView = ((q) Yf()).f19306k0;
            int i11 = R$font.roboto_medium;
            textView.setTypeface(Utils.c(i11));
            ((q) Yf()).f19305j0.setTypeface(Utils.c(i11));
            ((q) Yf()).f19298c0.setTypeface(Utils.c(R$font.roboto_regular));
        }
        com.hbg.module.content.adapter.g gVar = new com.hbg.module.content.adapter.g(this);
        this.f18300o = gVar;
        String str = this.f18294i;
        if (str == null) {
            str = null;
        }
        gVar.o(str);
        ((q) Yf()).Y.setLayoutManager(com.hbg.module.libkt.base.ext.b.t(this));
        ((q) Yf()).Y.setAdapter(this.f18300o);
        String str2 = this.f18294i;
        this.f18299n = new CommentListAdapter(this, str2 == null ? null : str2, "1", (String) null, false, (String) null, 56, (r) null);
        ((q) Yf()).X.setLayoutManager(com.hbg.module.libkt.base.ext.b.t(this));
        ((q) Yf()).X.setAdapter(this.f18299n);
        com.hbg.module.libkt.base.ext.b.f(((q) Yf()).X);
        ((q) Yf()).f19307l0.setOnClickListener(new NewsDetailActivity$initView$9(this));
    }

    public final void ji(int i11) {
        NewFlashInformation newFlashInformation = this.f18296k;
        if (newFlashInformation != null) {
            Pair[] pairArr = new Pair[4];
            Integer num = null;
            int i12 = 0;
            pairArr[0] = kotlin.l.a("contentid", newFlashInformation != null ? Long.valueOf(newFlashInformation.getId()) : null);
            NewFlashInformation newFlashInformation2 = this.f18296k;
            pairArr[1] = kotlin.l.a("title", newFlashInformation2 != null ? newFlashInformation2.getTitle() : null);
            pairArr[2] = kotlin.l.a("entrance_type", i11 == 1 ? "more" : "icon");
            pairArr[3] = kotlin.l.a("comment_state", "app_huobiNews_details");
            nc.c.a("app_share_click", MapsKt__MapsKt.j(pairArr));
            b.a a11 = nc.b.a();
            if (a11 != null) {
                a11.a(this, this.f18296k);
            }
            NewFlashInformation newFlashInformation3 = this.f18296k;
            if (newFlashInformation3 != null) {
                if (newFlashInformation3 != null) {
                    i12 = newFlashInformation3.getShared();
                }
                newFlashInformation3.setShared(i12 + 1);
            }
            String str = this.f18294i;
            if (str == null) {
                str = null;
            }
            long parseLong = Long.parseLong(str);
            NewFlashInformation newFlashInformation4 = this.f18296k;
            if (newFlashInformation4 != null) {
                num = Integer.valueOf(newFlashInformation4.getShared());
            }
            we.c.E(parseLong, num.intValue());
            ((q) Yf()).O(this.f18296k);
        }
    }

    public final void ki(int i11) {
        NewFlashInformation newFlashInformation;
        HbgBaseProvider fg2 = fg();
        if ((fg2 != null && fg2.j(this)) && (newFlashInformation = this.f18296k) != null) {
            long id2 = newFlashInformation.getId();
            Pair[] pairArr = new Pair[2];
            NewFlashInformation newFlashInformation2 = this.f18296k;
            String str = null;
            pairArr[0] = kotlin.l.a("contentid", newFlashInformation2 != null ? Long.valueOf(newFlashInformation2.getId()) : null);
            NewFlashInformation newFlashInformation3 = this.f18296k;
            if (newFlashInformation3 != null) {
                str = newFlashInformation3.getTitle();
            }
            pairArr[1] = kotlin.l.a("title", str);
            HashMap j11 = MapsKt__MapsKt.j(pairArr);
            if (i11 == 1) {
                j11.put("bullish_state", "app_huobiNews_details");
                nc.c.a("app_bullish_click", j11);
            } else {
                j11.put("bearish_state", "app_huobiNews_details");
                nc.c.a("app_bearish_click", j11);
            }
            RequestExtKt.d(v7.b.a().R0(id2, i11), new NewsDetailActivity$vote$1$1(this, id2), NewsDetailActivity$vote$1$2.INSTANCE, (MutableLiveData) null, 4, (Object) null);
        }
    }

    public void oh() {
        super.oh();
        String stringExtra = getIntent().getStringExtra("newflashId");
        if (stringExtra == null) {
            stringExtra = "0";
        }
        this.f18294i = stringExtra;
        this.f18295j = getIntent().getIntExtra("from", 0);
        this.f18302q = getIntent().getBooleanExtra("feedCommentClick", false);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onPause() {
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        try {
            HbgBaseProvider fg2 = fg();
            boolean z11 = true;
            if (!(fg2 != null && fg2.n() == this.f18301p)) {
                HbgBaseProvider fg3 = fg();
                if (fg3 == null || !fg3.n()) {
                    z11 = false;
                }
                this.f18301p = z11;
                Vh();
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }
}
