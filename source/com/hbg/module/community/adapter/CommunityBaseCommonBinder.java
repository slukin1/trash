package com.hbg.module.community.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.arouter.facade.Postcard;
import com.bumptech.glide.request.target.CustomTarget;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo.ListBean;
import com.hbg.lib.network.hbg.core.bean.LiveDetailBean;
import com.hbg.lib.network.hbg.core.bean.RichTextBean;
import com.hbg.lib.widgets.photoviewer.PhotoViewerUtils;
import com.hbg.lib.widgets.photoviewer.data.ImageData;
import com.hbg.module.community.adapter.l;
import com.hbg.module.community.multiadapter.ItemViewBinder;
import com.hbg.module.community.view.HotCommentView;
import com.hbg.module.community.view.VideoCoverImageView;
import com.hbg.module.content.R$attr;
import com.hbg.module.content.R$color;
import com.hbg.module.content.R$id;
import com.hbg.module.content.utls.TipsPopDialog;
import com.hbg.module.huobi.im.view.AvatarView;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import com.hbg.module.libkt.custom.DynamicPicCardView;
import com.hbg.module.libkt.custom.EllipsizeTextView;
import com.hbg.module.libkt.custom.PicView;
import com.hbg.module.libkt.helper.s3.S3UploadHelper;
import com.hbg.module.libkt.provider.HbgBaseProvider;
import com.hbg.module.libkt.provider.HbgBaseShareProvider;
import com.huochat.community.CommunityModuleCallback;
import com.huochat.community.CommunityModuleConfig;
import com.huochat.community.base.CommunityConstants;
import com.huochat.community.widget.expandable.ExpandableTextView;
import com.huochat.community.widget.expandable.LinkType;
import com.huochat.community.widget.expandable.StatusType;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sumsub.sns.internal.core.common.n0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.Reflection;
import lc.y2;
import se.e;

public abstract class CommunityBaseCommonBinder<ItemData extends CommunityFeedInfo.ListBean, SubViewHolder extends l> extends ItemViewBinder<CommunityFeedInfo.ListBean, a> {

    /* renamed from: q  reason: collision with root package name */
    public static final b f16961q = new b((kotlin.jvm.internal.r) null);

    /* renamed from: r  reason: collision with root package name */
    public static final String f16962r = Reflection.b(CommunityBaseCommonBinder.class).f();

    /* renamed from: e  reason: collision with root package name */
    public int f16963e = -1;

    /* renamed from: f  reason: collision with root package name */
    public int f16964f = 1;

    /* renamed from: g  reason: collision with root package name */
    public boolean f16965g;

    /* renamed from: h  reason: collision with root package name */
    public HbgBaseProvider f16966h;

    /* renamed from: i  reason: collision with root package name */
    public HbgBaseShareProvider f16967i;

    /* renamed from: j  reason: collision with root package name */
    public d10.a<Unit> f16968j;

    /* renamed from: k  reason: collision with root package name */
    public d10.a<Unit> f16969k;

    /* renamed from: l  reason: collision with root package name */
    public int f16970l;

    /* renamed from: m  reason: collision with root package name */
    public int f16971m;

    /* renamed from: n  reason: collision with root package name */
    public CommunityFeedInfo.ListBean f16972n;

    /* renamed from: o  reason: collision with root package name */
    public SpannableStringBuilder f16973o;

    /* renamed from: p  reason: collision with root package name */
    public EllipsizeTextView f16974p;

    public static final class a extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public final l f16975a;

        /* renamed from: b  reason: collision with root package name */
        public final y2 f16976b;

        /* renamed from: com.hbg.module.community.adapter.CommunityBaseCommonBinder$a$a  reason: collision with other inner class name */
        public static final class C0121a implements View.OnClickListener {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ View f16977b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ long f16978c;

            public C0121a(View view, long j11) {
                this.f16977b = view;
                this.f16978c = j11;
            }

            @SensorsDataInstrumented
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                rd.s sVar = rd.s.f23381a;
                if (currentTimeMillis - sVar.b(this.f16977b) > this.f16978c || (this.f16977b instanceof Checkable)) {
                    sVar.e(this.f16977b, currentTimeMillis);
                }
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        }

        public a(y2 y2Var, l lVar, CommunityBaseCommonBinder<?, ?> communityBaseCommonBinder) {
            super(y2Var.getRoot());
            View a11;
            this.f16975a = lVar;
            this.f16976b = y2Var;
            if (!(lVar == null || (a11 = lVar.a()) == null)) {
                y2Var.E.addView(a11);
                lVar.b(this);
            }
            rd.s sVar = rd.s.f23381a;
            View root = y2Var.getRoot();
            root.setOnClickListener(new C0121a(root, 800));
        }

        public final y2 e() {
            return this.f16976b;
        }

        public final l f() {
            return this.f16975a;
        }
    }

    public static final class b {
        public b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.r rVar) {
            this();
        }

        public final String a() {
            return CommunityBaseCommonBinder.f16962r;
        }
    }

    public static final class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f16979b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f16980c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d10.a f16981d;

        public c(View view, long j11, d10.a aVar) {
            this.f16979b = view;
            this.f16980c = j11;
            this.f16981d = aVar;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f16979b) > this.f16980c || (this.f16979b instanceof Checkable)) {
                sVar.e(this.f16979b, currentTimeMillis);
                LinearLayout linearLayout = (LinearLayout) this.f16979b;
                this.f16981d.invoke();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class d implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f16982b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f16983c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CommunityFeedInfo.ListBean f16984d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f16985e;

        public d(View view, long j11, CommunityFeedInfo.ListBean listBean, a aVar) {
            this.f16982b = view;
            this.f16983c = j11;
            this.f16984d = listBean;
            this.f16985e = aVar;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f16982b) > this.f16983c || (this.f16982b instanceof Checkable)) {
                sVar.e(this.f16982b, currentTimeMillis);
                VideoCoverImageView videoCoverImageView = (VideoCoverImageView) this.f16982b;
                String y11 = CommunityBaseCommonBinder.f16962r;
                i6.d.c(y11, "start play, id = " + this.f16984d.getId() + ", seek = " + this.f16984d.getSeek());
                se.d.m(this.f16985e.e().B, this.f16984d.getVideoUrl(), this.f16984d.getSeek(), true, new p(this.f16984d), this.f16984d.getVideoWidth(), this.f16984d.getVideoHeight());
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class e implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f16986b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f16987c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CommunityBaseCommonBinder f16988d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CommunityFeedInfo.ListBean f16989e;

        public e(View view, long j11, CommunityBaseCommonBinder communityBaseCommonBinder, CommunityFeedInfo.ListBean listBean) {
            this.f16986b = view;
            this.f16987c = j11;
            this.f16988d = communityBaseCommonBinder;
            this.f16989e = listBean;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f16986b) > this.f16987c || (this.f16986b instanceof Checkable)) {
                sVar.e(this.f16986b, currentTimeMillis);
                HotCommentView hotCommentView = (HotCommentView) this.f16986b;
                CommunityModuleCallback moduleCallback = CommunityModuleConfig.Companion.getModuleCallback();
                if (moduleCallback != null) {
                    moduleCallback.newTrack("app_community_feed", this.f16988d.G(this.f16989e));
                }
                b2.a.d().a("/content/DynamicDetail").withString("dynamicId", String.valueOf(this.f16989e.getId())).withBoolean("feedCommentClick", true).navigation();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class f implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f16990b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f16991c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CommunityBaseCommonBinder f16992d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CommunityFeedInfo.ListBean f16993e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f16994f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f16995g;

        public f(View view, long j11, CommunityBaseCommonBinder communityBaseCommonBinder, CommunityFeedInfo.ListBean listBean, a aVar, Context context) {
            this.f16990b = view;
            this.f16991c = j11;
            this.f16992d = communityBaseCommonBinder;
            this.f16993e = listBean;
            this.f16994f = aVar;
            this.f16995g = context;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f16990b) > this.f16991c || (this.f16990b instanceof Checkable)) {
                sVar.e(this.f16990b, currentTimeMillis);
                RelativeLayout relativeLayout = (RelativeLayout) this.f16990b;
                nc.c.a("app_community_fx", this.f16992d.G(this.f16993e));
                this.f16992d.O(this.f16994f, this.f16995g, this.f16993e);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class g implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f16996b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f16997c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CommunityBaseCommonBinder f16998d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CommunityFeedInfo.ListBean f16999e;

        public g(View view, long j11, CommunityBaseCommonBinder communityBaseCommonBinder, CommunityFeedInfo.ListBean listBean) {
            this.f16996b = view;
            this.f16997c = j11;
            this.f16998d = communityBaseCommonBinder;
            this.f16999e = listBean;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f16996b) > this.f16997c || (this.f16996b instanceof Checkable)) {
                sVar.e(this.f16996b, currentTimeMillis);
                RelativeLayout relativeLayout = (RelativeLayout) this.f16996b;
                CommunityModuleCallback moduleCallback = CommunityModuleConfig.Companion.getModuleCallback();
                if (moduleCallback != null) {
                    moduleCallback.newTrack("app_community_comment_click", this.f16998d.G(this.f16999e));
                }
                b2.a.d().a("/content/DynamicDetail").withString("dynamicId", String.valueOf(this.f16999e.getId())).withBoolean("feedCommentClick", true).navigation();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class h implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17000b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17001c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CommunityBaseCommonBinder f17002d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CommunityFeedInfo.ListBean f17003e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f17004f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f17005g;

        public h(View view, long j11, CommunityBaseCommonBinder communityBaseCommonBinder, CommunityFeedInfo.ListBean listBean, Context context, a aVar) {
            this.f17000b = view;
            this.f17001c = j11;
            this.f17002d = communityBaseCommonBinder;
            this.f17003e = listBean;
            this.f17004f = context;
            this.f17005g = aVar;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17000b) > this.f17001c || (this.f17000b instanceof Checkable)) {
                sVar.e(this.f17000b, currentTimeMillis);
                LinearLayout linearLayout = (LinearLayout) this.f17000b;
                nc.c.a("app_community_dz", this.f17002d.G(this.f17003e));
                HbgBaseProvider E = this.f17002d.E();
                if (E != null && E.j((Activity) this.f17004f)) {
                    RequestExtKt.d(v7.b.a().D0(String.valueOf(this.f17003e.getId()), 4), new CommunityBaseCommonBinder$onBindViewHolder$14$1$1(this.f17003e, this.f17002d, this.f17005g), CommunityBaseCommonBinder$onBindViewHolder$14$1$2.INSTANCE, (MutableLiveData) null, 4, (Object) null);
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class i implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17006b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17007c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CommunityBaseCommonBinder f17008d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CommunityFeedInfo.ListBean f17009e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f17010f;

        public i(View view, long j11, CommunityBaseCommonBinder communityBaseCommonBinder, CommunityFeedInfo.ListBean listBean, Context context) {
            this.f17006b = view;
            this.f17007c = j11;
            this.f17008d = communityBaseCommonBinder;
            this.f17009e = listBean;
            this.f17010f = context;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17006b) > this.f17007c || (this.f17006b instanceof Checkable)) {
                sVar.e(this.f17006b, currentTimeMillis);
                ImageView imageView = (ImageView) this.f17006b;
                nc.c.a("app_community_gd", this.f17008d.G(this.f17009e));
                com.hbg.module.content.utls.o.f(com.hbg.module.content.utls.o.f18923a, (FragmentActivity) this.f17010f, imageView, new CommunityBaseCommonBinder$onBindViewHolder$15$1(this.f17009e, this.f17008d, this.f17010f), false, BaseModuleConfig.a().s() == 1 || this.f17009e.getIsSelf() == 1, this.f17009e.getIsSelf() != 1, BaseModuleConfig.a().s() == 1 && this.f17009e.getIsSelf() != 1, 8, (Object) null);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class j implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17011b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17012c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d10.a f17013d;

        public j(View view, long j11, d10.a aVar) {
            this.f17011b = view;
            this.f17012c = j11;
            this.f17013d = aVar;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17011b) > this.f17012c || (this.f17011b instanceof Checkable)) {
                sVar.e(this.f17011b, currentTimeMillis);
                this.f17013d.invoke();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class k implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17014b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17015c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d10.a f17016d;

        public k(View view, long j11, d10.a aVar) {
            this.f17014b = view;
            this.f17015c = j11;
            this.f17016d = aVar;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17014b) > this.f17015c || (this.f17014b instanceof Checkable)) {
                sVar.e(this.f17014b, currentTimeMillis);
                AppCompatTextView appCompatTextView = (AppCompatTextView) this.f17014b;
                this.f17016d.invoke();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class l implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17017b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17018c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d10.a f17019d;

        public l(View view, long j11, d10.a aVar) {
            this.f17017b = view;
            this.f17018c = j11;
            this.f17019d = aVar;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17017b) > this.f17018c || (this.f17017b instanceof Checkable)) {
                sVar.e(this.f17017b, currentTimeMillis);
                ExpandableTextView expandableTextView = (ExpandableTextView) this.f17017b;
                this.f17019d.invoke();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class m extends ClickableSpan {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CommunityFeedInfo.HotComment f17020b;

        public m(CommunityFeedInfo.HotComment hotComment) {
            this.f17020b = hotComment;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            b2.a.d().a("/content/PersonalCenter").withString("uidUnique", this.f17020b.hotComUid).navigation();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
        }
    }

    public static final class n implements AvatarView.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CommunityBaseCommonBinder<ItemData, SubViewHolder> f17021a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CommunityFeedInfo.ListBean f17022b;

        public n(CommunityBaseCommonBinder<ItemData, SubViewHolder> communityBaseCommonBinder, CommunityFeedInfo.ListBean listBean) {
            this.f17021a = communityBaseCommonBinder;
            this.f17022b = listBean;
        }

        public void a() {
            AvatarView.a.C0156a.b(this);
            nc.c.a("app_community_tx", this.f17021a.G(this.f17022b));
        }

        public void b(int i11, int i12) {
            AvatarView.a.C0156a.a(this, i11, i12);
        }
    }

    public static final class o extends CustomTarget<Drawable> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CommunityFeedInfo.ListBean f17023b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SpannableString f17024c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f17025d;

        public o(CommunityFeedInfo.ListBean listBean, SpannableString spannableString, a aVar) {
            this.f17023b = listBean;
            this.f17024c = spannableString;
            this.f17025d = aVar;
        }

        /* renamed from: a */
        public void onResourceReady(Drawable drawable, com.bumptech.glide.request.transition.a<? super Drawable> aVar) {
            drawable.setBounds(0, 0, com.hbg.module.libkt.utils.m.a(22), com.hbg.module.libkt.utils.m.a(22));
            ExpandableTextView.SelfImageSpan selfImageSpan = new ExpandableTextView.SelfImageSpan(drawable, 1);
            if (this.f17023b.getTop() == 1) {
                this.f17024c.setSpan(selfImageSpan, 1, 2, 33);
            } else {
                this.f17024c.setSpan(selfImageSpan, 0, 1, 33);
            }
            this.f17025d.e().f19335f0.setText(this.f17024c);
        }

        public void onLoadCleared(Drawable drawable) {
        }
    }

    public static final class p implements se.e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CommunityFeedInfo.ListBean f17035a;

        public p(CommunityFeedInfo.ListBean listBean) {
            this.f17035a = listBean;
        }

        public void a() {
            e.a.c(this);
        }

        public void b() {
            e.a.e(this);
        }

        public void c() {
            e.a.b(this);
        }

        public void d(int i11, int i12) {
            e.a.f(this, i11, i12);
            this.f17035a.setSeek(i12);
        }

        public void e() {
            e.a.a(this);
        }

        public void onError() {
            e.a.d(this);
        }
    }

    public static final class q implements PicView.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CommunityFeedInfo.ListBean f17036a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Ref$ObjectRef<LiveDetailBean> f17037b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CommunityBaseCommonBinder<ItemData, SubViewHolder> f17038c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Context f17039d;

        public q(CommunityFeedInfo.ListBean listBean, Ref$ObjectRef<LiveDetailBean> ref$ObjectRef, CommunityBaseCommonBinder<ItemData, SubViewHolder> communityBaseCommonBinder, Context context) {
            this.f17036a = listBean;
            this.f17037b = ref$ObjectRef;
            this.f17038c = communityBaseCommonBinder;
            this.f17039d = context;
        }

        public void a(int i11, ArrayList<CommunityFeedInfo.imgListBean> arrayList) {
            PicView.a.C0216a.a(this, i11, arrayList);
        }

        public void b(int i11, ArrayList<CommunityFeedInfo.imgListBean> arrayList) {
            HbgBaseProvider E;
            if (this.f17036a.getType() != 8) {
                ArrayList arrayList2 = new ArrayList();
                if (arrayList != null) {
                    for (CommunityFeedInfo.imgListBean imglistbean : arrayList) {
                        arrayList2.add(new ImageData(imglistbean.getImage(), imglistbean.getThumbImage()));
                    }
                }
                nc.c.a("app_community_picdj", this.f17038c.G(this.f17036a));
                PhotoViewerUtils.a((FragmentActivity) this.f17039d, arrayList2, i11);
            } else if (this.f17037b.element != null) {
                b2.a.d().a("/live/room").withString("liveId", ((LiveDetailBean) this.f17037b.element).f70249id).withInt("liveStatus", ((LiveDetailBean) this.f17037b.element).status).navigation();
            } else {
                String shareImage = this.f17036a.getShareImage();
                if (shareImage != null && (E = this.f17038c.E()) != null) {
                    E.g(shareImage);
                }
            }
        }
    }

    public static final class r implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17040b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17041c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CommunityBaseCommonBinder f17042d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CommunityFeedInfo.ListBean f17043e;

        public r(View view, long j11, CommunityBaseCommonBinder communityBaseCommonBinder, CommunityFeedInfo.ListBean listBean) {
            this.f17040b = view;
            this.f17041c = j11;
            this.f17042d = communityBaseCommonBinder;
            this.f17043e = listBean;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17040b) > this.f17041c || (this.f17040b instanceof Checkable)) {
                sVar.e(this.f17040b, currentTimeMillis);
                EllipsizeTextView ellipsizeTextView = (EllipsizeTextView) this.f17040b;
                CommunityModuleCallback moduleCallback = CommunityModuleConfig.Companion.getModuleCallback();
                if (moduleCallback != null) {
                    moduleCallback.newTrack("app_community_feed", this.f17042d.G(this.f17043e));
                }
                b2.a.d().a("/content/DynamicDetail").withString("dynamicId", String.valueOf(this.f17043e.getId())).navigation();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class s extends ClickableSpan {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ RichTextBean f17044b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f17045c;

        public s(RichTextBean richTextBean, Context context) {
            this.f17044b = richTextBean;
            this.f17045c = context;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            b2.a.d().a("/webView/index").withString("url", this.f17044b.data.url).navigation(this.f17045c);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            int color = this.f17045c.getResources().getColor(R$color.baseColorMajorTheme100);
            textPaint.setUnderlineText(false);
            textPaint.setColor(color);
        }
    }

    public CommunityBaseCommonBinder() {
        int a11 = ((Resources.getSystem().getDisplayMetrics().widthPixels - (com.hbg.module.libkt.utils.m.a(16) * 2)) - com.hbg.module.libkt.utils.m.a(44)) - com.hbg.module.libkt.utils.m.a(8);
        this.f16970l = a11;
        this.f16971m = (int) (((float) a11) * 0.5625f);
    }

    public static /* synthetic */ void J(CommunityBaseCommonBinder communityBaseCommonBinder, LinearLayout linearLayout, RichTextBean richTextBean, SpannableStringBuilder spannableStringBuilder, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 4) != 0) {
                spannableStringBuilder = null;
            }
            communityBaseCommonBinder.I(linearLayout, richTextBean, spannableStringBuilder);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: initRich");
    }

    public static /* synthetic */ void L(CommunityBaseCommonBinder communityBaseCommonBinder, a aVar, CommunityFeedInfo.ListBean listBean, boolean z11, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 4) != 0) {
                z11 = false;
            }
            communityBaseCommonBinder.K(aVar, listBean, z11);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: initTrans");
    }

    public static final void R(d10.a aVar, StatusType statusType) {
        aVar.invoke();
    }

    public static final boolean S(CommunityBaseCommonBinder communityBaseCommonBinder, CommunityFeedInfo.ListBean listBean, Context context, a aVar, View view) {
        nc.c.a("app_community_gckpfy", communityBaseCommonBinder.G(listBean));
        communityBaseCommonBinder.n0(context, aVar, listBean, view);
        return true;
    }

    public static final boolean T(CommunityBaseCommonBinder communityBaseCommonBinder, CommunityFeedInfo.ListBean listBean, Context context, a aVar, View view) {
        nc.c.a("app_community_gckpfy", communityBaseCommonBinder.G(listBean));
        communityBaseCommonBinder.n0(context, aVar, listBean, view);
        return true;
    }

    public static final boolean U(CommunityBaseCommonBinder communityBaseCommonBinder, CommunityFeedInfo.ListBean listBean, Context context, a aVar, View view) {
        nc.c.a("app_community_gckpfy", communityBaseCommonBinder.G(listBean));
        communityBaseCommonBinder.n0(context, aVar, listBean, view);
        return true;
    }

    public static final void V(CommunityBaseCommonBinder communityBaseCommonBinder, LinkType linkType, String str, String str2) {
        if (linkType == LinkType.MENTION_TYPE) {
            i6.d.b("link click, url = " + str);
            try {
                HbgBaseProvider hbgBaseProvider = communityBaseCommonBinder.f16966h;
                if (hbgBaseProvider != null) {
                    hbgBaseProvider.g(str);
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public static final void W(CommunityBaseCommonBinder communityBaseCommonBinder, CommunityFeedInfo.ListBean listBean, LinkType linkType, String str, String str2) {
        if (linkType == LinkType.MENTION_TYPE) {
            HashMap<Object, Object> G = communityBaseCommonBinder.G(listBean);
            CommunityFeedInfo.TopicTag topicTag = listBean.getTopic().get(0);
            int i11 = -1;
            G.put(CommunityConstants.TOPIC_ID, Integer.valueOf(topicTag != null ? topicTag.getTopicId() : -1));
            CommunityFeedInfo.TopicTag topicTag2 = listBean.getTopic().get(0);
            Integer num = null;
            String title = topicTag2 != null ? topicTag2.getTitle() : null;
            if (title == null) {
                title = "";
            }
            G.put("title", title);
            CommunityFeedInfo.TopicTag topicTag3 = listBean.getTopic().get(0);
            if (topicTag3 != null) {
                i11 = topicTag3.getIdentification();
            }
            G.put("identification", Integer.valueOf(i11));
            nc.c.a("app_community_nrkpht", G);
            Postcard a11 = b2.a.d().a("/content/topicDetail");
            CommunityFeedInfo.TopicTag topicTag4 = listBean.getTopic().get(0);
            if (topicTag4 != null) {
                num = Integer.valueOf(topicTag4.getTopicId());
            }
            a11.withString(CommunityConstants.TOPIC_ID, String.valueOf(num)).withString("tradeType", k.a(communityBaseCommonBinder.k(), communityBaseCommonBinder.l())).navigation();
        }
    }

    public static final void X(DynamicPicCardView dynamicPicCardView, a aVar) {
        System.out.println("image-->> " + dynamicPicCardView.getWidth() + ':' + dynamicPicCardView.getHeight() + ", parentheight = " + aVar.e().B.getWidth() + ':' + aVar.e().B.getHeight());
    }

    public static final boolean d0(CommunityBaseCommonBinder communityBaseCommonBinder, CommunityFeedInfo.ListBean listBean, a aVar, View view) {
        nc.c.a("app_community_gckpfy", communityBaseCommonBinder.G(listBean));
        communityBaseCommonBinder.n0(view.getContext(), aVar, listBean, view);
        return true;
    }

    public final d10.a<Unit> D() {
        return this.f16969k;
    }

    public final HbgBaseProvider E() {
        return this.f16966h;
    }

    public final HbgBaseShareProvider F() {
        return this.f16967i;
    }

    public final HashMap<Object, Object> G(CommunityFeedInfo.ListBean listBean) {
        Pair[] pairArr = new Pair[11];
        pairArr[0] = kotlin.l.a("communityId", Integer.valueOf(listBean.getId()));
        pairArr[1] = kotlin.l.a("uid", listBean.getUidUnique());
        pairArr[2] = kotlin.l.a("title", listBean.getTitle());
        pairArr[3] = kotlin.l.a("type", Integer.valueOf(listBean.getType()));
        pairArr[4] = kotlin.l.a("praiseNum", Integer.valueOf(listBean.getPraiseNum()));
        pairArr[5] = kotlin.l.a("commentNum", Integer.valueOf(listBean.getCommentNum()));
        pairArr[6] = kotlin.l.a("recom_base_info", listBean.getRecom_base_info());
        pairArr[7] = kotlin.l.a("topicType", Integer.valueOf(listBean.getShareType()));
        pairArr[8] = kotlin.l.a("sharetype", Integer.valueOf(listBean.getShareType()));
        String j11 = j();
        if (j11 == null) {
            j11 = "";
        }
        pairArr[9] = kotlin.l.a("TransPair_current_id", j11);
        pairArr[10] = kotlin.l.a("markets_kline_class", k.a(k(), l()));
        return MapsKt__MapsKt.j(pairArr);
    }

    public Bitmap H(SubViewHolder subviewholder, CommunityFeedInfo.ListBean listBean) {
        return null;
    }

    public final void I(LinearLayout linearLayout, RichTextBean richTextBean, SpannableStringBuilder spannableStringBuilder) {
        EllipsizeTextView ellipsizeTextView;
        Context context = linearLayout.getContext();
        String str = richTextBean.type;
        if (str != null) {
            switch (str.hashCode()) {
                case -2143265644:
                    if (str.equals("mention-currency") && spannableStringBuilder != null) {
                        f0(context, spannableStringBuilder, richTextBean, " $");
                        return;
                    }
                    return;
                case 100313435:
                    str.equals("image");
                    return;
                case 712568052:
                    if (str.equals("mention-follow") && spannableStringBuilder != null) {
                        f0(context, spannableStringBuilder, richTextBean, " @");
                        return;
                    }
                    return;
                case 1949288814:
                    if (str.equals("paragraph")) {
                        if (this.f16973o == null) {
                            this.f16973o = new SpannableStringBuilder();
                            this.f16974p = new EllipsizeTextView(context, (AttributeSet) null, 0, 6, (kotlin.jvm.internal.r) null);
                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                            if (linearLayout.getChildCount() > 0) {
                                layoutParams.topMargin = sd.a.b(Float.valueOf(10.0f));
                            }
                            EllipsizeTextView ellipsizeTextView2 = this.f16974p;
                            if (ellipsizeTextView2 != null) {
                                ellipsizeTextView2.setMaxLines(4);
                            }
                            EllipsizeTextView ellipsizeTextView3 = this.f16974p;
                            if (ellipsizeTextView3 != null) {
                                ellipsizeTextView3.setEllipsize(TextUtils.TruncateAt.END);
                            }
                            EllipsizeTextView ellipsizeTextView4 = this.f16974p;
                            if (ellipsizeTextView4 != null) {
                                ellipsizeTextView4.setLayoutParams(layoutParams);
                            }
                            EllipsizeTextView ellipsizeTextView5 = this.f16974p;
                            if (ellipsizeTextView5 != null) {
                                ellipsizeTextView5.setTextColor(context.getResources().getColor(R$color.baseColorSecondaryTextNew));
                            }
                            EllipsizeTextView ellipsizeTextView6 = this.f16974p;
                            if (ellipsizeTextView6 != null) {
                                ellipsizeTextView6.setTextSize(2, 16.0f);
                            }
                            if (Build.VERSION.SDK_INT >= 28 && (ellipsizeTextView = this.f16974p) != null) {
                                ellipsizeTextView.setLineHeight(sd.a.b(Float.valueOf(24.0f)));
                            }
                            EllipsizeTextView ellipsizeTextView7 = this.f16974p;
                            if (ellipsizeTextView7 != null) {
                                ellipsizeTextView7.setMovementMethod(new LinkMovementMethod());
                            }
                        }
                        if (!com.hbg.module.libkt.base.ext.b.w(richTextBean.children)) {
                            Iterator<RichTextBean> it2 = richTextBean.children.iterator();
                            while (it2.hasNext()) {
                                I(linearLayout, it2.next(), this.f16973o);
                            }
                            return;
                        }
                        return;
                    }
                    return;
                case 1963154312:
                    if (str.equals("mention-task") && spannableStringBuilder != null) {
                        richTextBean.character += n0.h.f32179b;
                        f0(context, spannableStringBuilder, richTextBean, " #");
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (!TextUtils.isEmpty(richTextBean.text) && spannableStringBuilder != null) {
            spannableStringBuilder.append(richTextBean.text);
        }
    }

    public final void K(a aVar, CommunityFeedInfo.ListBean listBean, boolean z11) {
        String str;
        String title = listBean.getTitle();
        if (listBean.getTextType() == 2) {
            str = listBean.getContentText();
        } else {
            str = listBean.getContent();
        }
        listBean.setTitle(listBean.getOldTitle());
        listBean.setOldTitle(title);
        if (listBean.getTextType() == 2) {
            listBean.setContentText(listBean.getOldContent());
        } else {
            listBean.setContent(listBean.getOldContent());
        }
        listBean.setOldContent(str);
        listBean.setTrans(z11);
        aVar.e().f19335f0.setText(listBean.getTitle());
        if (listBean.getTextType() == 2) {
            c0(listBean, aVar);
        } else {
            aVar.e().Y.setContent((CharSequence) listBean.getContent(), (StatusType) null);
        }
    }

    public final boolean M(CommunityFeedInfo.ListBean listBean) {
        return listBean.getShareType() == 20 || listBean.getShareType() == 21;
    }

    public abstract void N(SubViewHolder subviewholder, ItemData itemdata);

    public final void O(a aVar, Context context, CommunityFeedInfo.ListBean listBean) {
        String str;
        CommunityFeedInfo.imgListBean imglistbean;
        Uri bitmapToUri;
        ArrayList<CommunityFeedInfo.imgListBean> imgList;
        if (com.hbg.module.libkt.base.ext.b.x(listBean.getTitle())) {
            str = listBean.getContent();
        } else {
            str = listBean.getTitle();
        }
        if (!com.hbg.module.libkt.base.ext.b.w(listBean.getImgList()) && (imgList = listBean.getImgList()) != null) {
            imglistbean = imgList.get(0);
        } else {
            imglistbean = null;
        }
        int shareType = M(listBean) ? listBean.getShareType() : 4;
        if (M(listBean)) {
            Bitmap H = H(aVar.f(), listBean);
            if (H != null && (bitmapToUri = S3UploadHelper.INSTANCE.bitmapToUri(H)) != null) {
                S3UploadHelper.upLoad(context, bitmapToUri, (String) null, new CommunityBaseCommonBinder$onBindShareAction$1$1(this, context, str, listBean, shareType, aVar));
                return;
            }
            return;
        }
        HbgBaseShareProvider hbgBaseShareProvider = this.f16967i;
        if (hbgBaseShareProvider != null) {
            hbgBaseShareProvider.b((FragmentActivity) context, str, "", BaseModuleConfig.a().k("views/feed/details/community-details/" + listBean.getId()), "community", imglistbean != null ? imglistbean.getImage() : null, String.valueOf(listBean.getId()), shareType, new CommunityBaseCommonBinder$onBindShareAction$2(listBean, aVar));
        }
    }

    /* renamed from: P */
    public void b(a aVar, CommunityFeedInfo.ListBean listBean, List<? extends Object> list, boolean z11, int i11) {
        int i12;
        super.b(aVar, listBean, list, z11, i11);
        Context context = aVar.itemView.getContext();
        aVar.e().X.setText(he.b.a(listBean.getCommentNum()));
        int praiseNum = listBean.getPraiseNum();
        CommunityFeedInfo.ListBean.AttitudeInfo attitudeInfo = listBean.getAttitudeInfo();
        int i13 = 0;
        aVar.e().f19330a0.setText(he.b.a(praiseNum + (attitudeInfo != null ? attitudeInfo.attitudeCount : 0)));
        TextView textView = aVar.e().f19330a0;
        if (listBean.getPraiseStatus() != 1) {
            CommunityFeedInfo.ListBean.AttitudeInfo attitudeInfo2 = listBean.getAttitudeInfo();
            if (attitudeInfo2 != null) {
                i13 = attitudeInfo2.userAttitudeType;
            }
            if (i13 == 0) {
                i12 = com.hbg.module.libkt.base.ext.b.o(context, R$attr.kline_four_level_text_color);
                textView.setTextColor(i12);
                aVar.e().f19334e0.setText(he.b.a(listBean.getShareNum()));
            }
        }
        i12 = com.hbg.module.libkt.base.ext.b.o(context, R$attr.color_news_light_title);
        textView.setTextColor(i12);
        aVar.e().f19334e0.setText(he.b.a(listBean.getShareNum()));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0312, code lost:
        if (r0 != null) goto L_0x0316;
     */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x030c  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0311  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x0464  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x04dc  */
    /* JADX WARNING: Removed duplicated region for block: B:242:0x0760  */
    /* JADX WARNING: Removed duplicated region for block: B:243:0x076b  */
    /* JADX WARNING: Removed duplicated region for block: B:246:0x078e  */
    /* JADX WARNING: Removed duplicated region for block: B:247:0x0799  */
    /* JADX WARNING: Removed duplicated region for block: B:250:0x07ac  */
    /* JADX WARNING: Removed duplicated region for block: B:251:0x07b7  */
    /* JADX WARNING: Removed duplicated region for block: B:257:0x0883  */
    /* JADX WARNING: Removed duplicated region for block: B:258:0x08b2  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x019f  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x01d7  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x020c  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x020e  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0213  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0227  */
    @android.annotation.SuppressLint({"SetTextI18n"})
    /* renamed from: Q */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c(com.hbg.module.community.adapter.CommunityBaseCommonBinder.a r25, com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo.ListBean r26, boolean r27, int r28) {
        /*
            r24 = this;
            r8 = r24
            r9 = r25
            r10 = r26
            android.view.View r0 = r9.itemView
            android.content.Context r11 = r0.getContext()
            r8.f16972n = r10
            java.lang.String r0 = r26.getRecommendWord()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r12 = 8
            r13 = 0
            if (r0 == 0) goto L_0x0025
            lc.y2 r0 = r25.e()
            androidx.appcompat.widget.AppCompatTextView r0 = r0.C
            r0.setVisibility(r12)
            goto L_0x003b
        L_0x0025:
            lc.y2 r0 = r25.e()
            androidx.appcompat.widget.AppCompatTextView r0 = r0.C
            java.lang.String r1 = r26.getRecommendWord()
            r0.setText(r1)
            lc.y2 r0 = r25.e()
            androidx.appcompat.widget.AppCompatTextView r0 = r0.C
            r0.setVisibility(r13)
        L_0x003b:
            int r0 = r10.visit
            if (r0 <= 0) goto L_0x004f
            lc.y2 r0 = r25.e()
            android.widget.TextView r0 = r0.f19333d0
            int r1 = r10.visit
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r0.setText(r1)
            goto L_0x0061
        L_0x004f:
            lc.y2 r0 = r25.e()
            android.widget.TextView r0 = r0.f19333d0
            r0.setVisibility(r12)
            lc.y2 r0 = r25.e()
            android.view.View r0 = r0.N
            r0.setVisibility(r12)
        L_0x0061:
            java.lang.String r0 = r10.imageUrl
            r14 = 1
            if (r0 == 0) goto L_0x006f
            int r0 = r0.length()
            if (r0 != 0) goto L_0x006d
            goto L_0x006f
        L_0x006d:
            r0 = r13
            goto L_0x0070
        L_0x006f:
            r0 = r14
        L_0x0070:
            if (r0 == 0) goto L_0x007c
            lc.y2 r0 = r25.e()
            android.widget.ImageView r0 = r0.G
            r0.setVisibility(r12)
            goto L_0x0090
        L_0x007c:
            lc.y2 r0 = r25.e()
            android.widget.ImageView r0 = r0.G
            r0.setVisibility(r13)
            lc.y2 r0 = r25.e()
            android.widget.ImageView r0 = r0.G
            java.lang.String r1 = r10.imageUrl
            com.hbg.module.libkt.base.ext.b.B(r0, r1)
        L_0x0090:
            java.lang.String r0 = r26.getUserAvatar()
            boolean r0 = com.hbg.module.libkt.base.ext.b.x(r0)
            java.lang.String r1 = "BIG_V"
            r2 = 0
            if (r0 == 0) goto L_0x00d7
            lc.y2 r0 = r25.e()
            com.hbg.module.huobi.im.view.AvatarView r0 = r0.I
            java.lang.String r3 = r26.getUidUnique()
            com.hbg.module.huobi.im.view.AvatarView r0 = r0.z(r3, r2)
            int r3 = com.hbg.module.content.R$drawable.account_user_image
            int r4 = r26.getIsAlive()
            r0.y(r3, r4)
            lc.y2 r0 = r25.e()
            com.hbg.module.huobi.im.view.AvatarView r0 = r0.I
            int r3 = r26.getIsAlive()
            if (r3 != 0) goto L_0x00d2
            com.hbg.lib.network.hbg.core.bean.PersonalCenterInfo$UcExtInfo r3 = r26.getUcExtInfo()
            if (r3 == 0) goto L_0x00c9
            java.lang.String r3 = r3.showExtBusinessTag
            goto L_0x00ca
        L_0x00c9:
            r3 = r2
        L_0x00ca:
            boolean r1 = kotlin.jvm.internal.x.b(r1, r3)
            if (r1 == 0) goto L_0x00d2
            r1 = r14
            goto L_0x00d3
        L_0x00d2:
            r1 = r13
        L_0x00d3:
            r0.A(r1)
            goto L_0x0138
        L_0x00d7:
            lc.y2 r0 = r25.e()
            com.hbg.module.huobi.im.view.AvatarView r0 = r0.I
            java.lang.String r3 = r26.getUserAvatar()
            com.hbg.lib.network.hbg.core.bean.PersonalCenterInfo$UcExtInfo r4 = r26.getUcExtInfo()
            if (r4 == 0) goto L_0x00ea
            java.lang.String r4 = r4.headImageType
            goto L_0x00eb
        L_0x00ea:
            r4 = r2
        L_0x00eb:
            java.lang.String r5 = "NFT"
            boolean r4 = kotlin.jvm.internal.x.b(r4, r5)
            com.hbg.lib.network.hbg.core.bean.PersonalCenterInfo$UcExtInfo r5 = r26.getUcExtInfo()
            if (r5 == 0) goto L_0x00fa
            java.lang.String r5 = r5.frameUrl
            goto L_0x00fb
        L_0x00fa:
            r5 = r2
        L_0x00fb:
            com.hbg.module.huobi.im.view.AvatarView r15 = r0.u(r3, r4, r5)
            int r16 = r26.getIsAlive()
            r17 = -1
            java.lang.String r18 = r26.getUidUnique()
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 48
            r23 = 0
            com.hbg.module.huobi.im.view.AvatarView.t(r15, r16, r17, r18, r19, r20, r21, r22, r23)
            lc.y2 r0 = r25.e()
            com.hbg.module.huobi.im.view.AvatarView r0 = r0.I
            int r3 = r26.getIsAlive()
            if (r3 != 0) goto L_0x0134
            com.hbg.lib.network.hbg.core.bean.PersonalCenterInfo$UcExtInfo r3 = r26.getUcExtInfo()
            if (r3 == 0) goto L_0x012b
            java.lang.String r3 = r3.showExtBusinessTag
            goto L_0x012c
        L_0x012b:
            r3 = r2
        L_0x012c:
            boolean r1 = kotlin.jvm.internal.x.b(r1, r3)
            if (r1 == 0) goto L_0x0134
            r1 = r14
            goto L_0x0135
        L_0x0134:
            r1 = r13
        L_0x0135:
            r0.A(r1)
        L_0x0138:
            lc.y2 r0 = r25.e()
            com.hbg.module.huobi.im.view.AvatarView r0 = r0.I
            com.hbg.module.community.adapter.CommunityBaseCommonBinder$n r1 = new com.hbg.module.community.adapter.CommunityBaseCommonBinder$n
            r1.<init>(r8, r10)
            r0.setAvatarClickListener(r1)
            boolean r0 = r8.f16965g
            if (r0 == 0) goto L_0x0153
            lc.y2 r0 = r25.e()
            com.hbg.module.huobi.im.view.AvatarView r0 = r0.I
            r0.setOnClickListener(r2)
        L_0x0153:
            lc.y2 r0 = r25.e()
            android.widget.TextView r0 = r0.f19332c0
            java.lang.String r1 = r26.getUserNickname()
            r0.setText(r1)
            int r0 = r26.getIsShowEventTag()
            r1 = 3
            java.lang.String r3 = ""
            if (r0 != r14) goto L_0x018b
            int r0 = r26.getType()
            if (r0 != r14) goto L_0x017a
            android.content.res.Resources r0 = r11.getResources()
            int r4 = com.hbg.module.content.R$string.n_content_communityList_publishAticle
            java.lang.String r0 = r0.getString(r4)
            goto L_0x018c
        L_0x017a:
            int r0 = r26.getType()
            if (r0 != r1) goto L_0x018b
            android.content.res.Resources r0 = r11.getResources()
            int r4 = com.hbg.module.content.R$string.n_content_communityList_commentAticle
            java.lang.String r0 = r0.getString(r4)
            goto L_0x018c
        L_0x018b:
            r0 = r3
        L_0x018c:
            lc.y2 r4 = r25.e()
            android.widget.TextView r4 = r4.Z
            long r5 = r26.getInteractiveTime()
            r15 = 0
            int r5 = (r5 > r15 ? 1 : (r5 == r15 ? 0 : -1))
            java.lang.String r6 = "%s"
            r15 = 2
            if (r5 <= 0) goto L_0x01d7
            int r0 = r26.getInteractiveType()
            if (r0 == r14) goto L_0x01b4
            if (r0 == r15) goto L_0x01a9
            r0 = r6
            goto L_0x01be
        L_0x01a9:
            android.content.res.Resources r0 = r11.getResources()
            int r5 = com.hbg.module.content.R$string.n_content_liked_at
            java.lang.String r0 = r0.getString(r5)
            goto L_0x01be
        L_0x01b4:
            android.content.res.Resources r0 = r11.getResources()
            int r5 = com.hbg.module.content.R$string.n_content_commented_at
            java.lang.String r0 = r0.getString(r5)
        L_0x01be:
            kotlin.jvm.internal.d0 r5 = kotlin.jvm.internal.d0.f56774a
            java.lang.Object[] r5 = new java.lang.Object[r14]
            r28 = r3
            long r2 = r26.getInteractiveTime()
            java.lang.String r2 = com.hbg.module.huobi.im.utils.DateUtils.f(r11, r2)
            r5[r13] = r2
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r5, r14)
            java.lang.String r0 = java.lang.String.format(r0, r2)
            goto L_0x01fc
        L_0x01d7:
            r28 = r3
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.Long r3 = r26.getCreatedTime()
            long r13 = r3.longValue()
            java.lang.String r3 = com.hbg.module.huobi.im.utils.DateUtils.f(r11, r13)
            r2.append(r3)
            r3 = 32
            r2.append(r3)
            r2.append(r0)
            r2.append(r3)
            java.lang.String r0 = r2.toString()
        L_0x01fc:
            r4.setText(r0)
            java.lang.String r0 = r26.getTitle()
            if (r0 == 0) goto L_0x020e
            int r0 = r0.length()
            if (r0 != 0) goto L_0x020c
            goto L_0x020e
        L_0x020c:
            r0 = 0
            goto L_0x020f
        L_0x020e:
            r0 = 1
        L_0x020f:
            r13 = 5
            r14 = 4
            if (r0 == 0) goto L_0x0227
            lc.y2 r0 = r25.e()
            androidx.appcompat.widget.AppCompatTextView r0 = r0.f19335f0
            r0.setVisibility(r12)
            lc.y2 r0 = r25.e()
            com.huochat.community.widget.expandable.ExpandableTextView r0 = r0.Y
            r0.reSetMaxLines(r13)
            goto L_0x02ef
        L_0x0227:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            int r2 = r26.getTop()
            r3 = 1
            if (r2 != r3) goto L_0x0238
            java.lang.String r2 = " "
            r0.append(r2)
        L_0x0238:
            java.lang.String r2 = r10.airdropIcon
            if (r2 == 0) goto L_0x0245
            int r2 = r2.length()
            if (r2 != 0) goto L_0x0243
            goto L_0x0245
        L_0x0243:
            r2 = 0
            goto L_0x0246
        L_0x0245:
            r2 = 1
        L_0x0246:
            if (r2 != 0) goto L_0x024d
            java.lang.String r2 = "  "
            r0.append(r2)
        L_0x024d:
            java.lang.String r2 = r26.getTitle()
            r0.append(r2)
            android.text.SpannableString r2 = new android.text.SpannableString
            r2.<init>(r0)
            int r0 = r26.getTop()
            r3 = 1
            if (r0 != r3) goto L_0x0280
            int r0 = com.hbg.module.content.R$attr.icon_market_news_top
            android.graphics.drawable.Drawable r0 = com.hbg.module.libkt.base.ext.b.p(r11, r0)
            if (r0 == 0) goto L_0x0280
            int r4 = r0.getIntrinsicWidth()
            int r5 = r0.getIntrinsicHeight()
            r7 = 0
            r0.setBounds(r7, r7, r4, r5)
            com.huochat.community.widget.expandable.ExpandableTextView$SelfImageSpan r4 = new com.huochat.community.widget.expandable.ExpandableTextView$SelfImageSpan
            r4.<init>(r0, r3)
            r0 = 33
            r2.setSpan(r4, r7, r3, r0)
            kotlin.Unit r0 = kotlin.Unit.f56620a
        L_0x0280:
            java.lang.String r0 = r10.airdropIcon
            if (r0 == 0) goto L_0x028d
            int r0 = r0.length()
            if (r0 != 0) goto L_0x028b
            goto L_0x028d
        L_0x028b:
            r0 = 0
            goto L_0x028e
        L_0x028d:
            r0 = 1
        L_0x028e:
            if (r0 != 0) goto L_0x02a2
            com.bumptech.glide.d r0 = com.bumptech.glide.a.v(r11)
            java.lang.String r3 = r10.airdropIcon
            com.bumptech.glide.c r0 = r0.q(r3)
            com.hbg.module.community.adapter.CommunityBaseCommonBinder$o r3 = new com.hbg.module.community.adapter.CommunityBaseCommonBinder$o
            r3.<init>(r10, r2, r9)
            r0.A0(r3)
        L_0x02a2:
            lc.y2 r0 = r25.e()
            androidx.appcompat.widget.AppCompatTextView r0 = r0.f19335f0
            r0.setText(r2)
            lc.y2 r0 = r25.e()
            androidx.appcompat.widget.AppCompatTextView r0 = r0.f19335f0
            r2 = 0
            r0.setVisibility(r2)
            lc.y2 r0 = r25.e()
            androidx.appcompat.widget.AppCompatTextView r0 = r0.f19335f0
            com.hbg.module.community.adapter.d r2 = new com.hbg.module.community.adapter.d
            r2.<init>(r8, r10, r11, r9)
            r0.setOnLongClickListener(r2)
            lc.y2 r0 = r25.e()
            androidx.appcompat.widget.AppCompatTextView r0 = r0.f19335f0
            int r0 = r0.getLineCount()
            r2 = 1
            if (r0 != r2) goto L_0x02da
            lc.y2 r0 = r25.e()
            com.huochat.community.widget.expandable.ExpandableTextView r0 = r0.Y
            r0.reSetMaxLines(r14)
            goto L_0x02ef
        L_0x02da:
            lc.y2 r0 = r25.e()
            androidx.appcompat.widget.AppCompatTextView r0 = r0.f19335f0
            int r0 = r0.getLineCount()
            if (r0 != r15) goto L_0x02ef
            lc.y2 r0 = r25.e()
            com.huochat.community.widget.expandable.ExpandableTextView r0 = r0.Y
            r0.reSetMaxLines(r1)
        L_0x02ef:
            java.util.List r0 = r26.getTopic()
            if (r0 == 0) goto L_0x0314
            java.util.List r0 = r26.getTopic()
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x0314
            java.util.List r0 = r26.getTopic()
            r2 = 0
            java.lang.Object r0 = r0.get(r2)
            com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo$TopicTag r0 = (com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo.TopicTag) r0
            if (r0 == 0) goto L_0x0311
            java.lang.String r0 = r0.getTitle()
            goto L_0x0312
        L_0x0311:
            r0 = 0
        L_0x0312:
            if (r0 != 0) goto L_0x0316
        L_0x0314:
            r0 = r28
        L_0x0316:
            int r2 = r26.getTextType()
            if (r2 != r15) goto L_0x0337
            lc.y2 r0 = r25.e()
            com.huochat.community.widget.expandable.ExpandableTextView r0 = r0.Y
            r0.setVisibility(r12)
            lc.y2 r0 = r25.e()
            android.widget.LinearLayout r0 = r0.Q
            r2 = 0
            r0.setVisibility(r2)
            r8.c0(r10, r9)
        L_0x0332:
            r2 = r28
        L_0x0334:
            r5 = 0
            goto L_0x0449
        L_0x0337:
            r2 = 0
            lc.y2 r3 = r25.e()
            com.huochat.community.widget.expandable.ExpandableTextView r3 = r3.Y
            r3.setVisibility(r2)
            lc.y2 r3 = r25.e()
            android.widget.LinearLayout r3 = r3.Q
            r3.setVisibility(r12)
            lc.y2 r3 = r25.e()
            com.huochat.community.widget.expandable.ExpandableTextView r3 = r3.Y
            r3.setNeedShowPrefixMarkIcon(r2)
            java.util.List r3 = r26.getSpecialContent()
            if (r3 == 0) goto L_0x03bb
            java.util.List r3 = r26.getSpecialContent()
            int r3 = r3.size()
            if (r3 <= 0) goto L_0x03bb
            lc.y2 r0 = r25.e()
            com.huochat.community.widget.expandable.ExpandableTextView r0 = r0.Y
            r0.setVisibility(r2)
            int r0 = r26.getTop()
            r2 = 1
            if (r0 != r2) goto L_0x039e
            java.lang.String r0 = r26.getTitle()
            if (r0 == 0) goto L_0x0382
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0380
            goto L_0x0382
        L_0x0380:
            r0 = 0
            goto L_0x0383
        L_0x0382:
            r0 = 1
        L_0x0383:
            if (r0 == 0) goto L_0x039e
            lc.y2 r0 = r25.e()
            com.huochat.community.widget.expandable.ExpandableTextView r0 = r0.Y
            r2 = 1
            r0.setNeedShowPrefixMarkIcon(r2)
            lc.y2 r0 = r25.e()
            com.huochat.community.widget.expandable.ExpandableTextView r0 = r0.Y
            int r2 = com.hbg.module.content.R$attr.icon_market_news_top
            android.graphics.drawable.Drawable r2 = com.hbg.module.libkt.base.ext.b.p(r11, r2)
            r0.setPrefixMarkDrawable(r2)
        L_0x039e:
            lc.y2 r0 = r25.e()
            com.huochat.community.widget.expandable.ExpandableTextView r0 = r0.Y
            java.util.List r2 = r26.getSpecialContent()
            r0.setContent(r2)
            lc.y2 r0 = r25.e()
            com.huochat.community.widget.expandable.ExpandableTextView r0 = r0.Y
            com.hbg.module.community.adapter.h r2 = new com.hbg.module.community.adapter.h
            r2.<init>(r8)
            r0.setLinkClickListener(r2)
            goto L_0x0332
        L_0x03bb:
            int r2 = r0.length()
            if (r2 != 0) goto L_0x03c3
            r2 = 1
            goto L_0x03c4
        L_0x03c3:
            r2 = 0
        L_0x03c4:
            if (r2 == 0) goto L_0x03ef
            java.lang.String r2 = r26.getContent()
            if (r2 == 0) goto L_0x03d5
            int r2 = r2.length()
            if (r2 != 0) goto L_0x03d3
            goto L_0x03d5
        L_0x03d3:
            r2 = 0
            goto L_0x03d6
        L_0x03d5:
            r2 = 1
        L_0x03d6:
            if (r2 == 0) goto L_0x03ef
            lc.y2 r0 = r25.e()
            com.huochat.community.widget.expandable.ExpandableTextView r0 = r0.Y
            r2 = r28
            r3 = 0
            r0.setContentWithHeadTopic(r2, r2, r3)
            lc.y2 r0 = r25.e()
            com.huochat.community.widget.expandable.ExpandableTextView r0 = r0.Y
            r0.setVisibility(r12)
            goto L_0x0334
        L_0x03ef:
            r2 = r28
            lc.y2 r3 = r25.e()
            com.huochat.community.widget.expandable.ExpandableTextView r3 = r3.Y
            r4 = 0
            r3.setVisibility(r4)
            int r3 = r26.getTop()
            r4 = 1
            if (r3 != r4) goto L_0x042d
            java.lang.String r3 = r26.getTitle()
            if (r3 == 0) goto L_0x0411
            int r3 = r3.length()
            if (r3 != 0) goto L_0x040f
            goto L_0x0411
        L_0x040f:
            r3 = 0
            goto L_0x0412
        L_0x0411:
            r3 = 1
        L_0x0412:
            if (r3 == 0) goto L_0x042d
            lc.y2 r3 = r25.e()
            com.huochat.community.widget.expandable.ExpandableTextView r3 = r3.Y
            r4 = 1
            r3.setNeedShowPrefixMarkIcon(r4)
            lc.y2 r3 = r25.e()
            com.huochat.community.widget.expandable.ExpandableTextView r3 = r3.Y
            int r4 = com.hbg.module.content.R$attr.icon_market_news_top
            android.graphics.drawable.Drawable r4 = com.hbg.module.libkt.base.ext.b.p(r11, r4)
            r3.setPrefixMarkDrawable(r4)
        L_0x042d:
            lc.y2 r3 = r25.e()
            com.huochat.community.widget.expandable.ExpandableTextView r3 = r3.Y
            java.lang.String r4 = r26.getContent()
            r5 = 0
            r3.setContentWithHeadTopic(r4, r0, r5)
            lc.y2 r0 = r25.e()
            com.huochat.community.widget.expandable.ExpandableTextView r0 = r0.Y
            com.hbg.module.community.adapter.i r3 = new com.hbg.module.community.adapter.i
            r3.<init>(r8, r10)
            r0.setLinkClickListener(r3)
        L_0x0449:
            lc.y2 r0 = r25.e()
            android.widget.LinearLayout r0 = r0.P
            r0.setVisibility(r12)
            lc.y2 r0 = r25.e()
            android.widget.FrameLayout r0 = r0.B
            r0.removeAllViews()
            int r0 = r26.getShowTag()
            r7 = -2
            r4 = -1
            r3 = 1
            if (r0 != r3) goto L_0x04dc
            com.hbg.module.libkt.common.PkCommonView r0 = new com.hbg.module.libkt.common.PkCommonView
            r3 = 0
            r5 = 0
            r6 = 0
            r18 = 14
            r19 = 0
            r1 = r0
            r2 = r11
            r13 = r4
            r4 = r5
            r5 = r6
            r6 = r18
            r14 = r7
            r7 = r19
            r1.<init>(r2, r3, r4, r5, r6, r7)
            int r1 = com.hbg.module.content.R$id.pkv_vote
            r0.setId(r1)
            com.hbg.lib.network.hbg.core.bean.CommonPkData r1 = r26.getVote()
            r0.setView(r1)
            com.huobi.view.roundview.RoundLinearLayout r1 = new com.huobi.view.roundview.RoundLinearLayout
            r1.<init>(r11)
            android.widget.FrameLayout$LayoutParams r2 = new android.widget.FrameLayout$LayoutParams
            r2.<init>(r13, r14)
            r1.setLayoutParams(r2)
            r2 = 1094713344(0x41400000, float:12.0)
            java.lang.Float r3 = java.lang.Float.valueOf(r2)
            int r3 = sd.a.b(r3)
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            int r2 = sd.a.b(r2)
            r4 = 0
            r1.setPadding(r3, r4, r2, r4)
            com.huobi.view.roundview.RoundViewDelegate r2 = r1.getDelegate()
            r2.setCornerRadius(r12)
            com.huobi.view.roundview.RoundViewDelegate r2 = r1.getDelegate()
            android.content.res.Resources r3 = r11.getResources()
            int r4 = com.hbg.module.content.R$color.baseColorSecondarySeparator
            int r3 = r3.getColor(r4)
            r2.setStrokeColor(r3)
            com.huobi.view.roundview.RoundViewDelegate r2 = r1.getDelegate()
            r3 = 1
            r2.setStrokeWidth(r3)
            android.widget.LinearLayout$LayoutParams r2 = new android.widget.LinearLayout$LayoutParams
            r2.<init>(r13, r14)
            r1.addView(r0, r2)
            lc.y2 r0 = r25.e()
            android.widget.FrameLayout r0 = r0.B
            r0.addView(r1)
            goto L_0x0754
        L_0x04dc:
            r13 = r4
            r14 = r7
            int r0 = r26.getShowTag()
            if (r0 != r15) goto L_0x055c
            androidx.constraintlayout.widget.ConstraintLayout r0 = new androidx.constraintlayout.widget.ConstraintLayout
            r0.<init>(r11)
            android.view.ViewGroup$LayoutParams r1 = new android.view.ViewGroup$LayoutParams
            r1.<init>(r13, r14)
            r0.setLayoutParams(r1)
            int r1 = android.view.View.generateViewId()
            r0.setId(r1)
            com.hbg.module.community.view.VideoCoverImageView r7 = new com.hbg.module.community.view.VideoCoverImageView
            r3 = 0
            r4 = 0
            r5 = 6
            r6 = 0
            r1 = r7
            r2 = r11
            r1.<init>(r2, r3, r4, r5, r6)
            androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r1 = new androidx.constraintlayout.widget.ConstraintLayout$LayoutParams
            r2 = 0
            r1.<init>((int) r2, (int) r2)
            int r2 = r0.getId()
            r1.f7942h = r2
            int r2 = r0.getId()
            r1.f7948k = r2
            int r2 = r0.getId()
            r1.f7934d = r2
            int r2 = r0.getId()
            r1.f7940g = r2
            int r2 = r26.getVideoWidth()
            int r3 = r26.getVideoHeight()
            if (r2 <= r3) goto L_0x052e
            java.lang.String r2 = "W,343:220"
            goto L_0x0530
        L_0x052e:
            java.lang.String r2 = "W,343:430"
        L_0x0530:
            r1.H = r2
            r7.setLayoutParams(r1)
            java.lang.String r1 = r26.getVideoImage()
            com.hbg.module.libkt.base.ext.b.B(r7, r1)
            r0.addView(r7)
            lc.y2 r1 = r25.e()
            android.widget.FrameLayout r1 = r1.B
            r1.addView(r0)
            rd.s r0 = rd.s.f23381a
            r2 = 800(0x320, double:3.953E-321)
            com.hbg.module.community.adapter.CommunityBaseCommonBinder$d r6 = new com.hbg.module.community.adapter.CommunityBaseCommonBinder$d
            r0 = r6
            r1 = r7
            r4 = r26
            r5 = r25
            r0.<init>(r1, r2, r4, r5)
            r7.setOnClickListener(r6)
            goto L_0x0754
        L_0x055c:
            int r0 = r26.getShowTag()
            if (r0 != r1) goto L_0x0573
            int r0 = r26.getType()
            if (r0 == r12) goto L_0x0573
            lc.y2 r0 = r25.e()
            androidx.appcompat.widget.AppCompatTextView r0 = r0.f19335f0
            r0.setVisibility(r12)
            goto L_0x0754
        L_0x0573:
            int r0 = r26.getShowTag()
            r1 = 4
            if (r0 == r1) goto L_0x0580
            int r0 = r26.getType()
            if (r0 != r12) goto L_0x0754
        L_0x0580:
            kotlin.jvm.internal.Ref$ObjectRef r0 = new kotlin.jvm.internal.Ref$ObjectRef
            r0.<init>()
            int r1 = r26.getType()
            if (r1 != r12) goto L_0x070d
            com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo$imgListBean r1 = new com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo$imgListBean
            r1.<init>()
            java.lang.String r3 = r10.extend
            boolean r3 = com.hbg.module.libkt.base.ext.b.x(r3)
            if (r3 != 0) goto L_0x06ec
            java.lang.String r3 = r10.extend
            com.hbg.module.community.adapter.CommunityBaseCommonBinder$onBindViewHolder$$inlined$gsonToBean$1 r4 = new com.hbg.module.community.adapter.CommunityBaseCommonBinder$onBindViewHolder$$inlined$gsonToBean$1
            r4.<init>()
            java.lang.reflect.Type r4 = r4.getType()
            com.google.gson.Gson r7 = com.hbg.module.libkt.base.ext.f.e()
            java.lang.Object r3 = r7.fromJson((java.lang.String) r3, (java.lang.reflect.Type) r4)
            r0.element = r3
            com.hbg.lib.network.hbg.core.bean.LiveDetailBean r3 = (com.hbg.lib.network.hbg.core.bean.LiveDetailBean) r3
            if (r3 == 0) goto L_0x05b4
            java.lang.String r3 = r3.coverImageUrl
            goto L_0x05b5
        L_0x05b4:
            r3 = r5
        L_0x05b5:
            r1.setImage(r3)
            T r3 = r0.element
            com.hbg.lib.network.hbg.core.bean.LiveDetailBean r3 = (com.hbg.lib.network.hbg.core.bean.LiveDetailBean) r3
            if (r3 == 0) goto L_0x05c1
            java.lang.String r3 = r3.coverImageUrl
            goto L_0x05c2
        L_0x05c1:
            r3 = r5
        L_0x05c2:
            r1.setThumbImage(r3)
            r1.setWidth(r15)
            r3 = 1
            r1.setHeight(r3)
            T r3 = r0.element
            com.hbg.lib.network.hbg.core.bean.LiveDetailBean r3 = (com.hbg.lib.network.hbg.core.bean.LiveDetailBean) r3
            if (r3 == 0) goto L_0x05d8
            int r3 = r3.status
            if (r3 != r15) goto L_0x05d8
            r3 = 1
            goto L_0x05d9
        L_0x05d8:
            r3 = 0
        L_0x05d9:
            if (r3 == 0) goto L_0x0625
            lc.y2 r2 = r25.e()
            android.widget.TextView r2 = r2.f19331b0
            kotlin.jvm.internal.d0 r3 = kotlin.jvm.internal.d0.f56774a
            int r3 = com.hbg.module.content.R$string.n_content_live_watch
            java.lang.String r3 = r11.getString(r3)
            r4 = 1
            java.lang.Object[] r5 = new java.lang.Object[r4]
            T r6 = r0.element
            com.hbg.lib.network.hbg.core.bean.LiveDetailBean r6 = (com.hbg.lib.network.hbg.core.bean.LiveDetailBean) r6
            java.lang.String r6 = r6.onlineNum
            java.lang.String r6 = he.b.e(r6)
            r7 = 0
            r5[r7] = r6
            java.lang.Object[] r5 = java.util.Arrays.copyOf(r5, r4)
            java.lang.String r3 = java.lang.String.format(r3, r5)
            r2.setText(r3)
            lc.y2 r2 = r25.e()
            android.widget.LinearLayout r2 = r2.P
            int r3 = com.hbg.module.content.R$drawable.bg_live_broadcast_tips
            r2.setBackgroundResource(r3)
            lc.y2 r2 = r25.e()
            android.widget.ImageView r2 = r2.M
            r2.setVisibility(r12)
            lc.y2 r2 = r25.e()
            com.hbg.lib.widgets.SafeLottieView r2 = r2.W
            r3 = 0
            r2.setVisibility(r3)
            r7 = r3
            goto L_0x06e1
        L_0x0625:
            lc.y2 r3 = r25.e()
            android.widget.LinearLayout r3 = r3.P
            int r4 = com.hbg.module.content.R$drawable.bg_live_playback_tips
            r3.setBackgroundResource(r4)
            T r3 = r0.element
            com.hbg.lib.network.hbg.core.bean.LiveDetailBean r3 = (com.hbg.lib.network.hbg.core.bean.LiveDetailBean) r3
            if (r3 == 0) goto L_0x063d
            int r3 = r3.status
            r4 = 1
            if (r3 != r4) goto L_0x063d
            r3 = 1
            goto L_0x063e
        L_0x063d:
            r3 = 0
        L_0x063e:
            if (r3 == 0) goto L_0x0693
            lc.y2 r3 = r25.e()
            android.widget.ImageView r3 = r3.M
            int r4 = com.hbg.module.content.R$drawable.ic_live_appointment
            r3.setImageResource(r4)
            if (r11 == 0) goto L_0x065b
            android.content.res.Resources r3 = r11.getResources()
            if (r3 == 0) goto L_0x065b
            int r4 = com.hbg.module.content.R$string.n_content_live_play_time2
            java.lang.String r3 = r3.getString(r4)
            if (r3 != 0) goto L_0x065c
        L_0x065b:
            r3 = r2
        L_0x065c:
            T r2 = r0.element
            com.hbg.lib.network.hbg.core.bean.LiveDetailBean r2 = (com.hbg.lib.network.hbg.core.bean.LiveDetailBean) r2
            long r4 = r2.startTime
            java.lang.String r2 = "MM-dd HH:mm"
            java.lang.String r2 = com.hbg.lib.common.utils.DateTimeUtils.h(r4, r2)
            T r4 = r0.element
            com.hbg.lib.network.hbg.core.bean.LiveDetailBean r4 = (com.hbg.lib.network.hbg.core.bean.LiveDetailBean) r4
            int r4 = r4.appointedNum
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.lang.String r4 = he.b.e(r4)
            kotlin.jvm.internal.d0 r5 = kotlin.jvm.internal.d0.f56774a
            java.lang.Object[] r5 = new java.lang.Object[r15]
            r6 = 0
            r5[r6] = r2
            r2 = 1
            r5[r2] = r4
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r5, r15)
            java.lang.String r2 = java.lang.String.format(r3, r2)
            lc.y2 r3 = r25.e()
            android.widget.TextView r3 = r3.f19331b0
            r3.setText(r2)
            r7 = 0
            goto L_0x06cf
        L_0x0693:
            lc.y2 r2 = r25.e()
            android.widget.ImageView r2 = r2.M
            int r3 = com.hbg.module.content.R$drawable.ic_live_playback
            r2.setImageResource(r3)
            lc.y2 r2 = r25.e()
            android.widget.TextView r2 = r2.f19331b0
            kotlin.jvm.internal.d0 r3 = kotlin.jvm.internal.d0.f56774a
            if (r11 == 0) goto L_0x06b2
            int r3 = com.hbg.module.content.R$string.n_content_live_watched
            java.lang.String r3 = r11.getString(r3)
            if (r3 != 0) goto L_0x06b1
            goto L_0x06b2
        L_0x06b1:
            r6 = r3
        L_0x06b2:
            r3 = 1
            java.lang.Object[] r4 = new java.lang.Object[r3]
            T r7 = r0.element
            com.hbg.lib.network.hbg.core.bean.LiveDetailBean r7 = (com.hbg.lib.network.hbg.core.bean.LiveDetailBean) r7
            if (r7 == 0) goto L_0x06bd
            java.lang.String r5 = r7.onlineNum
        L_0x06bd:
            java.lang.String r5 = he.b.e(r5)
            r7 = 0
            r4[r7] = r5
            java.lang.Object[] r4 = java.util.Arrays.copyOf(r4, r3)
            java.lang.String r3 = java.lang.String.format(r6, r4)
            r2.setText(r3)
        L_0x06cf:
            lc.y2 r2 = r25.e()
            android.widget.ImageView r2 = r2.M
            r2.setVisibility(r7)
            lc.y2 r2 = r25.e()
            com.hbg.lib.widgets.SafeLottieView r2 = r2.W
            r2.setVisibility(r12)
        L_0x06e1:
            lc.y2 r2 = r25.e()
            android.widget.LinearLayout r2 = r2.P
            r2.setVisibility(r7)
            r2 = 1
            goto L_0x0702
        L_0x06ec:
            r7 = 0
            java.lang.String r2 = r26.getShareImage()
            r1.setImage(r2)
            java.lang.String r2 = r26.getShareImage()
            r1.setThumbImage(r2)
            r1.setWidth(r15)
            r2 = 1
            r1.setHeight(r2)
        L_0x0702:
            com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo$imgListBean[] r3 = new com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo.imgListBean[r2]
            r3[r7] = r1
            java.util.ArrayList r1 = kotlin.collections.CollectionsKt__CollectionsKt.g(r3)
            r10.setImgList(r1)
        L_0x070d:
            java.util.ArrayList r1 = r26.getImgList()
            if (r1 == 0) goto L_0x0754
            java.util.ArrayList r1 = r26.getImgList()
            int r1 = r1.size()
            if (r1 <= 0) goto L_0x0754
            com.hbg.module.libkt.custom.DynamicPicCardView r1 = new com.hbg.module.libkt.custom.DynamicPicCardView
            r1.<init>(r11)
            int r2 = r26.getType()
            if (r2 != r12) goto L_0x072a
            r2 = r15
            goto L_0x072b
        L_0x072a:
            r2 = 0
        L_0x072b:
            r1.setShowType(r2)
            java.util.ArrayList r2 = r26.getImgList()
            r1.setImageResList(r2)
            com.hbg.module.community.adapter.CommunityBaseCommonBinder$q r2 = new com.hbg.module.community.adapter.CommunityBaseCommonBinder$q
            r2.<init>(r10, r0, r8, r11)
            r1.setImageClickListener(r2)
            lc.y2 r0 = r25.e()
            android.widget.FrameLayout r0 = r0.B
            r0.addView(r1)
            lc.y2 r0 = r25.e()
            android.widget.FrameLayout r0 = r0.B
            com.hbg.module.community.adapter.j r2 = new com.hbg.module.community.adapter.j
            r2.<init>(r1, r9)
            r0.post(r2)
        L_0x0754:
            lc.y2 r0 = r25.e()
            android.widget.FrameLayout r0 = r0.B
            int r0 = r0.getChildCount()
            if (r0 <= 0) goto L_0x076b
            lc.y2 r0 = r25.e()
            android.widget.FrameLayout r0 = r0.B
            r1 = 0
            r0.setVisibility(r1)
            goto L_0x0774
        L_0x076b:
            lc.y2 r0 = r25.e()
            android.widget.FrameLayout r0 = r0.B
            r0.setVisibility(r12)
        L_0x0774:
            lc.y2 r0 = r25.e()
            android.widget.TextView r0 = r0.X
            int r1 = r26.getCommentNum()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            he.b.l(r0, r1)
            r24.e0(r25, r26)
            int r0 = r26.getIsSelf()
            if (r0 != 0) goto L_0x0799
            lc.y2 r0 = r25.e()
            android.widget.ImageView r0 = r0.K
            r1 = 0
            r0.setVisibility(r1)
            goto L_0x07a2
        L_0x0799:
            lc.y2 r0 = r25.e()
            android.widget.ImageView r0 = r0.K
            r0.setVisibility(r12)
        L_0x07a2:
            java.util.List r0 = r26.getHotCommentList()
            boolean r0 = com.hbg.module.libkt.base.ext.b.w(r0)
            if (r0 == 0) goto L_0x07b7
            lc.y2 r0 = r25.e()
            com.huobi.view.roundview.RoundLinearLayout r0 = r0.O
            r0.setVisibility(r12)
            goto L_0x087d
        L_0x07b7:
            lc.y2 r0 = r25.e()
            com.huobi.view.roundview.RoundLinearLayout r0 = r0.O
            r1 = 0
            r0.setVisibility(r1)
            lc.y2 r0 = r25.e()
            com.huobi.view.roundview.RoundLinearLayout r0 = r0.O
            r0.removeAllViews()
            java.util.List r0 = r26.getHotCommentList()
            java.util.Iterator r7 = r0.iterator()
        L_0x07d2:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L_0x087d
            java.lang.Object r0 = r7.next()
            com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo$HotComment r0 = (com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo.HotComment) r0
            android.text.SpannableStringBuilder r13 = new android.text.SpannableStringBuilder
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = r0.hotComAuditor
            r1.append(r2)
            java.lang.String r2 = ": "
            r1.append(r2)
            java.lang.String r2 = r0.hotComment
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r13.<init>(r1)
            com.hbg.module.community.adapter.CommunityBaseCommonBinder$m r1 = new com.hbg.module.community.adapter.CommunityBaseCommonBinder$m
            r1.<init>(r0)
            java.lang.String r2 = r0.hotComAuditor
            int r2 = r2.length()
            r3 = 1
            int r2 = r2 + r3
            r4 = 17
            r5 = 0
            r13.setSpan(r1, r5, r2, r4)
            android.text.style.ForegroundColorSpan r1 = new android.text.style.ForegroundColorSpan
            int r2 = com.hbg.module.content.R$attr.base_color_primary_text
            int r2 = com.hbg.module.libkt.base.ext.b.o(r11, r2)
            r1.<init>(r2)
            java.lang.String r0 = r0.hotComAuditor
            int r0 = r0.length()
            int r0 = r0 + r3
            r13.setSpan(r1, r5, r0, r4)
            com.hbg.module.community.view.HotCommentView r14 = new com.hbg.module.community.view.HotCommentView
            r3 = 0
            r4 = 0
            r5 = 6
            r6 = 0
            r1 = r14
            r2 = r11
            r1.<init>(r2, r3, r4, r5, r6)
            r0 = 1097859072(0x41700000, float:15.0)
            r14.setTextSize(r0)
            r0 = 1101004800(0x41a00000, float:20.0)
            java.lang.Float r0 = java.lang.Float.valueOf(r0)
            int r0 = sd.a.b(r0)
            r14.setLineHeight(r0)
            r0 = 0
            r6 = 5
            r14.setPadding(r0, r0, r0, r6)
            int r0 = com.hbg.module.content.R$attr.base_color_secondary_textNew
            int r0 = com.hbg.module.libkt.base.ext.b.o(r11, r0)
            r14.setTextColor(r0)
            r14.setMaxLines(r15)
            android.text.TextUtils$TruncateAt r0 = android.text.TextUtils.TruncateAt.END
            r14.setEllipsize(r0)
            r14.setText(r13)
            android.text.method.LinkMovementMethod r0 = new android.text.method.LinkMovementMethod
            r0.<init>()
            r14.setMovementMethod(r0)
            rd.s r0 = rd.s.f23381a
            r2 = 800(0x320, double:3.953E-321)
            com.hbg.module.community.adapter.CommunityBaseCommonBinder$e r13 = new com.hbg.module.community.adapter.CommunityBaseCommonBinder$e
            r0 = r13
            r4 = r24
            r5 = r26
            r0.<init>(r1, r2, r4, r5)
            r14.setOnClickListener(r13)
            lc.y2 r0 = r25.e()
            com.huobi.view.roundview.RoundLinearLayout r0 = r0.O
            r0.addView(r14)
            goto L_0x07d2
        L_0x087d:
            com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo$ListBean$ParentDynamic r0 = r26.getParentDynamic()
            if (r0 == 0) goto L_0x08b2
            lc.y2 r0 = r25.e()
            android.widget.FrameLayout r0 = r0.E
            r1 = 0
            r0.setVisibility(r1)
            lc.y2 r0 = r25.e()
            android.widget.ImageView r0 = r0.K
            r0.setVisibility(r12)
            lc.y2 r0 = r25.e()
            android.widget.LinearLayout r0 = r0.T
            r0.setVisibility(r12)
            lc.y2 r0 = r25.e()
            android.widget.RelativeLayout r0 = r0.R
            r0.setVisibility(r12)
            lc.y2 r0 = r25.e()
            android.widget.RelativeLayout r0 = r0.U
            r0.setVisibility(r12)
            goto L_0x091d
        L_0x08b2:
            int r0 = r26.getType()
            r1 = 4
            if (r0 != r1) goto L_0x08ef
            int r0 = r26.getShowTag()
            r1 = 1
            if (r0 == r1) goto L_0x08ef
            lc.y2 r0 = r25.e()
            android.widget.FrameLayout r0 = r0.E
            r1 = 0
            r0.setVisibility(r1)
            lc.y2 r0 = r25.e()
            android.widget.ImageView r0 = r0.K
            r0.setVisibility(r1)
            lc.y2 r0 = r25.e()
            android.widget.LinearLayout r0 = r0.T
            r0.setVisibility(r1)
            lc.y2 r0 = r25.e()
            android.widget.RelativeLayout r0 = r0.R
            r0.setVisibility(r1)
            lc.y2 r0 = r25.e()
            android.widget.RelativeLayout r0 = r0.U
            r0.setVisibility(r1)
            goto L_0x091d
        L_0x08ef:
            r1 = 0
            lc.y2 r0 = r25.e()
            android.widget.FrameLayout r0 = r0.E
            r0.setVisibility(r12)
            lc.y2 r0 = r25.e()
            android.widget.ImageView r0 = r0.K
            r0.setVisibility(r1)
            lc.y2 r0 = r25.e()
            android.widget.LinearLayout r0 = r0.T
            r0.setVisibility(r1)
            lc.y2 r0 = r25.e()
            android.widget.RelativeLayout r0 = r0.R
            r0.setVisibility(r1)
            lc.y2 r0 = r25.e()
            android.widget.RelativeLayout r0 = r0.U
            r0.setVisibility(r1)
        L_0x091d:
            rd.s r0 = rd.s.f23381a
            lc.y2 r0 = r25.e()
            android.widget.RelativeLayout r12 = r0.U
            r2 = 800(0x320, double:3.953E-321)
            com.hbg.module.community.adapter.CommunityBaseCommonBinder$f r13 = new com.hbg.module.community.adapter.CommunityBaseCommonBinder$f
            r0 = r13
            r1 = r12
            r4 = r24
            r5 = r26
            r6 = r25
            r7 = r11
            r0.<init>(r1, r2, r4, r5, r6, r7)
            r12.setOnClickListener(r13)
            lc.y2 r0 = r25.e()
            android.widget.RelativeLayout r6 = r0.R
            com.hbg.module.community.adapter.CommunityBaseCommonBinder$g r7 = new com.hbg.module.community.adapter.CommunityBaseCommonBinder$g
            r0 = r7
            r1 = r6
            r0.<init>(r1, r2, r4, r5)
            r6.setOnClickListener(r7)
            lc.y2 r0 = r25.e()
            android.widget.LinearLayout r12 = r0.T
            com.hbg.module.community.adapter.CommunityBaseCommonBinder$h r13 = new com.hbg.module.community.adapter.CommunityBaseCommonBinder$h
            r0 = r13
            r1 = r12
            r6 = r11
            r7 = r25
            r0.<init>(r1, r2, r4, r5, r6, r7)
            r12.setOnClickListener(r13)
            lc.y2 r0 = r25.e()
            android.widget.ImageView r7 = r0.K
            com.hbg.module.community.adapter.CommunityBaseCommonBinder$i r12 = new com.hbg.module.community.adapter.CommunityBaseCommonBinder$i
            r0 = r12
            r1 = r7
            r0.<init>(r1, r2, r4, r5, r6)
            r7.setOnClickListener(r12)
            com.hbg.module.community.adapter.CommunityBaseCommonBinder$onBindViewHolder$jumpDetailDynamicPage$1 r0 = new com.hbg.module.community.adapter.CommunityBaseCommonBinder$onBindViewHolder$jumpDetailDynamicPage$1
            r0.<init>(r8, r10)
            lc.y2 r1 = r25.e()
            android.view.View r1 = r1.getRoot()
            com.hbg.module.community.adapter.CommunityBaseCommonBinder$j r2 = new com.hbg.module.community.adapter.CommunityBaseCommonBinder$j
            r3 = 800(0x320, double:3.953E-321)
            r2.<init>(r1, r3, r0)
            r1.setOnClickListener(r2)
            lc.y2 r1 = r25.e()
            androidx.appcompat.widget.AppCompatTextView r1 = r1.f19335f0
            com.hbg.module.community.adapter.CommunityBaseCommonBinder$k r2 = new com.hbg.module.community.adapter.CommunityBaseCommonBinder$k
            r2.<init>(r1, r3, r0)
            r1.setOnClickListener(r2)
            lc.y2 r1 = r25.e()
            com.huochat.community.widget.expandable.ExpandableTextView r12 = r1.Y
            com.hbg.module.community.adapter.g r13 = new com.hbg.module.community.adapter.g
            r13.<init>(r0)
            r14 = 0
            r15 = 0
            r17 = 6
            r18 = 0
            gc.d.e(r12, r13, r14, r15, r17, r18)
            lc.y2 r1 = r25.e()
            com.huochat.community.widget.expandable.ExpandableTextView r1 = r1.Y
            com.hbg.module.community.adapter.CommunityBaseCommonBinder$l r2 = new com.hbg.module.community.adapter.CommunityBaseCommonBinder$l
            r2.<init>(r1, r3, r0)
            r1.setOnClickListener(r2)
            lc.y2 r1 = r25.e()
            android.widget.LinearLayout r1 = r1.Q
            com.hbg.module.community.adapter.CommunityBaseCommonBinder$c r2 = new com.hbg.module.community.adapter.CommunityBaseCommonBinder$c
            r2.<init>(r1, r3, r0)
            r1.setOnClickListener(r2)
            lc.y2 r0 = r25.e()
            com.huochat.community.widget.expandable.ExpandableTextView r0 = r0.Y
            com.hbg.module.community.adapter.c r1 = new com.hbg.module.community.adapter.c
            r1.<init>(r8, r10, r11, r9)
            r0.setOnLongClickListener(r1)
            lc.y2 r0 = r25.e()
            android.widget.LinearLayout r0 = r0.Q
            com.hbg.module.community.adapter.e r1 = new com.hbg.module.community.adapter.e
            r1.<init>(r8, r10, r11, r9)
            r0.setOnLongClickListener(r1)
            com.hbg.module.community.adapter.l r0 = r25.f()
            r8.N(r0, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.community.adapter.CommunityBaseCommonBinder.c(com.hbg.module.community.adapter.CommunityBaseCommonBinder$a, com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo$ListBean, boolean, int):void");
    }

    public abstract l Y(LayoutInflater layoutInflater, ViewGroup viewGroup);

    /* renamed from: Z */
    public a m(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return new a(y2.K(layoutInflater, viewGroup, false), Y(layoutInflater, viewGroup), this);
    }

    /* renamed from: a0 */
    public void f(a aVar) {
        CommunityModuleCallback moduleCallback;
        super.f(aVar);
        CommunityFeedInfo.ListBean listBean = this.f16972n;
        if (listBean != null && (moduleCallback = CommunityModuleConfig.Companion.getModuleCallback()) != null) {
            moduleCallback.newTrack("app_community_feedbg", G(listBean));
        }
    }

    /* renamed from: b0 */
    public void g(a aVar) {
        super.g(aVar);
        if (((ConstraintLayout) aVar.itemView.findViewById(R$id.clCommunityVideo)) != null) {
            se.d.w();
        }
    }

    public final void c0(CommunityFeedInfo.ListBean listBean, a aVar) {
        EllipsizeTextView ellipsizeTextView;
        List<RichTextBean> c11 = rd.d.f23353a.c(listBean.getContentText(), RichTextBean.class);
        if (!com.hbg.module.libkt.base.ext.b.w(c11)) {
            aVar.e().Q.removeAllViews();
            for (RichTextBean J : c11) {
                J(this, aVar.e().Q, J, (SpannableStringBuilder) null, 4, (Object) null);
            }
            SpannableStringBuilder spannableStringBuilder = this.f16973o;
            if (spannableStringBuilder != null && (ellipsizeTextView = this.f16974p) != null) {
                if (ellipsizeTextView != null) {
                    ellipsizeTextView.setText(spannableStringBuilder);
                }
                EllipsizeTextView ellipsizeTextView2 = this.f16974p;
                if (ellipsizeTextView2 != null) {
                    rd.s sVar = rd.s.f23381a;
                    ellipsizeTextView2.setOnClickListener(new r(ellipsizeTextView2, 800, this, listBean));
                }
                EllipsizeTextView ellipsizeTextView3 = this.f16974p;
                if (ellipsizeTextView3 != null) {
                    ellipsizeTextView3.setOnLongClickListener(new f(this, listBean, aVar));
                }
                aVar.e().Q.addView(this.f16974p);
                this.f16973o = null;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0079  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void e0(com.hbg.module.community.adapter.CommunityBaseCommonBinder.a r5, com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo.ListBean r6) {
        /*
            r4 = this;
            lc.y2 r0 = r5.e()
            android.widget.TextView r0 = r0.f19330a0
            int r1 = r6.getPraiseNum()
            com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo$ListBean$AttitudeInfo r2 = r6.getAttitudeInfo()
            r3 = 0
            if (r2 == 0) goto L_0x0014
            int r2 = r2.attitudeCount
            goto L_0x0015
        L_0x0014:
            r2 = r3
        L_0x0015:
            int r1 = r1 + r2
            java.lang.String r1 = java.lang.String.valueOf(r1)
            he.b.l(r0, r1)
            lc.y2 r0 = r5.e()
            android.widget.TextView r0 = r0.f19330a0
            int r1 = r6.getPraiseStatus()
            r2 = 1
            if (r1 == r2) goto L_0x0046
            com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo$ListBean$AttitudeInfo r1 = r6.getAttitudeInfo()
            if (r1 == 0) goto L_0x0032
            int r3 = r1.userAttitudeType
        L_0x0032:
            if (r3 == 0) goto L_0x0035
            goto L_0x0046
        L_0x0035:
            lc.y2 r1 = r5.e()
            android.widget.TextView r1 = r1.f19330a0
            android.content.Context r1 = r1.getContext()
            int r2 = com.hbg.module.content.R$attr.kline_four_level_text_color
            int r1 = com.hbg.module.libkt.base.ext.b.o(r1, r2)
            goto L_0x0056
        L_0x0046:
            lc.y2 r1 = r5.e()
            android.widget.TextView r1 = r1.f19330a0
            android.content.Context r1 = r1.getContext()
            int r2 = com.hbg.module.content.R$attr.color_news_light_title
            int r1 = com.hbg.module.libkt.base.ext.b.o(r1, r2)
        L_0x0056:
            r0.setTextColor(r1)
            int r6 = r6.getPraiseStatus()
            if (r6 != 0) goto L_0x0079
            lc.y2 r6 = r5.e()
            android.widget.ImageView r6 = r6.J
            lc.y2 r5 = r5.e()
            android.widget.TextView r5 = r5.f19330a0
            android.content.Context r5 = r5.getContext()
            int r0 = com.hbg.module.content.R$attr.information_like
            int r5 = com.hbg.module.libkt.base.ext.b.q(r5, r0)
            com.hbg.module.libkt.base.ext.b.A(r6, r5)
            goto L_0x0092
        L_0x0079:
            lc.y2 r6 = r5.e()
            android.widget.ImageView r6 = r6.J
            lc.y2 r5 = r5.e()
            android.widget.TextView r5 = r5.f19330a0
            android.content.Context r5 = r5.getContext()
            int r0 = com.hbg.module.content.R$attr.information_like_focus
            int r5 = com.hbg.module.libkt.base.ext.b.q(r5, r0)
            com.hbg.module.libkt.base.ext.b.A(r6, r5)
        L_0x0092:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.community.adapter.CommunityBaseCommonBinder.e0(com.hbg.module.community.adapter.CommunityBaseCommonBinder$a, com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo$ListBean):void");
    }

    public final void f0(Context context, SpannableStringBuilder spannableStringBuilder, RichTextBean richTextBean, String str) {
        int length = spannableStringBuilder.length();
        int length2 = richTextBean.character.length() + length + str.length();
        spannableStringBuilder.append(str + richTextBean.character + ' ');
        spannableStringBuilder.setSpan(new s(richTextBean, context), length, length2, 33);
    }

    public final void g0(int i11) {
        this.f16964f = i11;
    }

    public final void h0(HbgBaseProvider hbgBaseProvider) {
        this.f16966h = hbgBaseProvider;
    }

    public final void i0(HbgBaseShareProvider hbgBaseShareProvider) {
        this.f16967i = hbgBaseShareProvider;
    }

    public final void j0(d10.a<Unit> aVar) {
        this.f16969k = aVar;
    }

    public final void k0(boolean z11) {
        this.f16965g = z11;
    }

    public final void l0(d10.a<Unit> aVar) {
        this.f16968j = aVar;
    }

    public final void m0(int i11) {
        this.f16963e = i11;
    }

    public final void n0(Context context, a aVar, CommunityFeedInfo.ListBean listBean, View view) {
        new TipsPopDialog(context, new CommunityBaseCommonBinder$showTransPop$1(listBean, this, aVar), (String) null, (String) null, true, listBean.isTrans() ^ true ? 1 : 0, 12, (kotlin.jvm.internal.r) null).g(view);
    }

    public final void o0(Context context, int i11, String str) {
        RequestExtKt.d(v7.b.a().t(i11, str), CommunityBaseCommonBinder$userMute$1.INSTANCE, new CommunityBaseCommonBinder$userMute$2(this, context), (MutableLiveData) null, 4, (Object) null);
    }

    public final void p0(Context context, String str) {
        RequestExtKt.d(v7.b.a().v(str), CommunityBaseCommonBinder$userUnMute$1.INSTANCE, new CommunityBaseCommonBinder$userUnMute$2(this, context), (MutableLiveData) null, 4, (Object) null);
    }
}
