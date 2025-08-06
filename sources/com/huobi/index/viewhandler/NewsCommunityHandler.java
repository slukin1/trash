package com.huobi.index.viewhandler;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
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
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.alibaba.android.arouter.facade.Postcard;
import com.bumptech.glide.request.target.CustomTarget;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import com.hbg.lib.network.hbg.core.bean.LiveDetailBean;
import com.hbg.lib.network.hbg.core.bean.LiveSpeaker;
import com.hbg.lib.network.hbg.core.bean.RichTextBean;
import com.hbg.lib.widgets.photoviewer.PhotoViewerUtils;
import com.hbg.lib.widgets.photoviewer.data.ImageData;
import com.hbg.module.community.adapter.CommunityBaseCommonBinder;
import com.hbg.module.community.view.HotCommentView;
import com.hbg.module.community.view.VideoCoverImageView;
import com.hbg.module.content.utls.TipsPopDialog;
import com.hbg.module.huobi.im.view.AvatarView;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import com.hbg.module.libkt.custom.EllipsizeTextView;
import com.hbg.module.libkt.custom.PicView;
import com.hbg.module.libkt.provider.HbgBaseProvider;
import com.hbg.module.libkt.provider.HbgBaseShareProvider;
import com.huobi.index.bean.HomeFeedInfoItem;
import com.huobi.utils.HomeSensorsHelper;
import com.huobi.view.roundimg.RoundedImageView;
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
import pro.huobi.R;
import se.e;

public final class NewsCommunityHandler implements s9.c {

    /* renamed from: b  reason: collision with root package name */
    public HbgBaseProvider f74259b = ((HbgBaseProvider) b2.a.d().a("/provider/content").navigation());

    /* renamed from: c  reason: collision with root package name */
    public HbgBaseShareProvider f74260c = ((HbgBaseShareProvider) b2.a.d().a("/provider/share/h5").navigation());

    /* renamed from: d  reason: collision with root package name */
    public int f74261d;

    /* renamed from: e  reason: collision with root package name */
    public int f74262e;

    /* renamed from: f  reason: collision with root package name */
    public SpannableStringBuilder f74263f;

    /* renamed from: g  reason: collision with root package name */
    public EllipsizeTextView f74264g;

    public static final class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f74265b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f74266c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ NewsCommunityHandler f74267d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CommunityFeedInfo.ListBean f74268e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ HomeFeedInfoItem f74269f;

        public a(View view, long j11, NewsCommunityHandler newsCommunityHandler, CommunityFeedInfo.ListBean listBean, HomeFeedInfoItem homeFeedInfoItem) {
            this.f74265b = view;
            this.f74266c = j11;
            this.f74267d = newsCommunityHandler;
            this.f74268e = listBean;
            this.f74269f = homeFeedInfoItem;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f74265b) > this.f74266c || (this.f74265b instanceof Checkable)) {
                sVar.e(this.f74265b, currentTimeMillis);
                LinearLayout linearLayout = (LinearLayout) this.f74265b;
                NewsCommunityHandler newsCommunityHandler = this.f74267d;
                CommunityFeedInfo.ListBean listBean = this.f74268e;
                HomeFeedInfoItem homeFeedInfoItem = this.f74269f;
                newsCommunityHandler.y(listBean, homeFeedInfoItem.f73152c, Integer.valueOf(homeFeedInfoItem.f73165p));
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f74270b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f74271c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CommunityFeedInfo.ListBean f74272d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrameLayout f74273e;

        public b(View view, long j11, CommunityFeedInfo.ListBean listBean, FrameLayout frameLayout) {
            this.f74270b = view;
            this.f74271c = j11;
            this.f74272d = listBean;
            this.f74273e = frameLayout;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f74270b) > this.f74271c || (this.f74270b instanceof Checkable)) {
                sVar.e(this.f74270b, currentTimeMillis);
                VideoCoverImageView videoCoverImageView = (VideoCoverImageView) this.f74270b;
                String a11 = CommunityBaseCommonBinder.f16961q.a();
                i6.d.c(a11, "start play, id = " + this.f74272d.getId() + ", seek = " + this.f74272d.getSeek());
                se.d.n(this.f74273e, this.f74272d.getVideoUrl(), this.f74272d.getSeek(), true, new m(this.f74272d), 0, 0, 96, (Object) null);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f74274b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f74275c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CommunityFeedInfo.ListBean f74276d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HomeFeedInfoItem f74277e;

        public c(View view, long j11, CommunityFeedInfo.ListBean listBean, HomeFeedInfoItem homeFeedInfoItem) {
            this.f74274b = view;
            this.f74275c = j11;
            this.f74276d = listBean;
            this.f74277e = homeFeedInfoItem;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f74274b) > this.f74275c || (this.f74274b instanceof Checkable)) {
                sVar.e(this.f74274b, currentTimeMillis);
                HotCommentView hotCommentView = (HotCommentView) this.f74274b;
                CommunityFeedInfo.ListBean listBean = this.f74276d;
                long id2 = (long) (listBean != null ? listBean.getId() : 0);
                String str = this.f74277e.f73152c;
                CommunityFeedInfo.ListBean listBean2 = this.f74276d;
                gs.g.g("app_recome_content_click", HomeSensorsHelper.e(id2, str, listBean2 != null ? listBean2.getTitle() : null, "community", this.f74277e.f73165p, (String) null, this.f74276d.getShareType(), 4));
                b2.a.d().a("/content/DynamicDetail").withString("dynamicId", String.valueOf(this.f74276d.getId())).withBoolean("feedCommentClick", true).navigation();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class d implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f74278b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f74279c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ NewsCommunityHandler f74280d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CommunityFeedInfo.ListBean f74281e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f74282f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ TextView f74283g;

        public d(View view, long j11, NewsCommunityHandler newsCommunityHandler, CommunityFeedInfo.ListBean listBean, Context context, TextView textView) {
            this.f74278b = view;
            this.f74279c = j11;
            this.f74280d = newsCommunityHandler;
            this.f74281e = listBean;
            this.f74282f = context;
            this.f74283g = textView;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            CommunityFeedInfo.imgListBean imglistbean;
            ArrayList<CommunityFeedInfo.imgListBean> imgList;
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f74278b) > this.f74279c || (this.f74278b instanceof Checkable)) {
                sVar.e(this.f74278b, currentTimeMillis);
                RelativeLayout relativeLayout = (RelativeLayout) this.f74278b;
                gs.g.i("app_community_fx", this.f74280d.m(this.f74281e));
                String a11 = gc.a.f19130a.a(20, this.f74281e.getTitle(), this.f74281e.getContent());
                if (!com.hbg.module.libkt.base.ext.b.w(this.f74281e.getImgList()) && (imgList = this.f74281e.getImgList()) != null) {
                    imglistbean = imgList.get(0);
                } else {
                    imglistbean = null;
                }
                HbgBaseShareProvider h11 = this.f74280d.f74260c;
                if (h11 != null) {
                    h11.b((FragmentActivity) this.f74282f, a11, "", BaseModuleConfig.a().k("views/feed/details/community-details/" + this.f74281e.getId()), "community", imglistbean != null ? imglistbean.getImage() : null, String.valueOf(this.f74281e.getId()), (this.f74281e.getShareType() == 20 || this.f74281e.getShareType() == 21) ? this.f74281e.getShareType() : 4, new NewsCommunityHandler$handleView$11$1(this.f74281e, this.f74283g));
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class e implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f74284b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f74285c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CommunityFeedInfo.ListBean f74286d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HomeFeedInfoItem f74287e;

        public e(View view, long j11, CommunityFeedInfo.ListBean listBean, HomeFeedInfoItem homeFeedInfoItem) {
            this.f74284b = view;
            this.f74285c = j11;
            this.f74286d = listBean;
            this.f74287e = homeFeedInfoItem;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f74284b) > this.f74285c || (this.f74284b instanceof Checkable)) {
                sVar.e(this.f74284b, currentTimeMillis);
                RelativeLayout relativeLayout = (RelativeLayout) this.f74284b;
                CommunityFeedInfo.ListBean listBean = this.f74286d;
                long id2 = (long) (listBean != null ? listBean.getId() : 0);
                String str = this.f74287e.f73152c;
                CommunityFeedInfo.ListBean listBean2 = this.f74286d;
                gs.g.g("app_community_comment_click", HomeSensorsHelper.e(id2, str, listBean2 != null ? listBean2.getTitle() : null, "community", this.f74287e.f73165p, (String) null, this.f74286d.getShareType(), 4));
                b2.a.d().a("/content/DynamicDetail").withString("dynamicId", String.valueOf(this.f74286d.getId())).withBoolean("feedCommentClick", true).navigation();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class f implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f74288b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f74289c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ NewsCommunityHandler f74290d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CommunityFeedInfo.ListBean f74291e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f74292f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ TextView f74293g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ ImageView f74294h;

        public f(View view, long j11, NewsCommunityHandler newsCommunityHandler, CommunityFeedInfo.ListBean listBean, Context context, TextView textView, ImageView imageView) {
            this.f74288b = view;
            this.f74289c = j11;
            this.f74290d = newsCommunityHandler;
            this.f74291e = listBean;
            this.f74292f = context;
            this.f74293g = textView;
            this.f74294h = imageView;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f74288b) > this.f74289c || (this.f74288b instanceof Checkable)) {
                sVar.e(this.f74288b, currentTimeMillis);
                LinearLayout linearLayout = (LinearLayout) this.f74288b;
                gs.g.i("app_community_dz", this.f74290d.m(this.f74291e));
                HbgBaseProvider g11 = this.f74290d.f74259b;
                if (g11 != null && g11.j((Activity) this.f74292f)) {
                    RequestExtKt.d(v7.b.a().D0(String.valueOf(this.f74291e.getId()), 4), new NewsCommunityHandler$handleView$13$1$1(this.f74291e, this.f74290d, this.f74293g, this.f74294h), NewsCommunityHandler$handleView$13$1$2.INSTANCE, (MutableLiveData) null, 4, (Object) null);
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class g implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f74295b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f74296c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ NewsCommunityHandler f74297d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CommunityFeedInfo.ListBean f74298e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f74299f;

        public g(View view, long j11, NewsCommunityHandler newsCommunityHandler, CommunityFeedInfo.ListBean listBean, Context context) {
            this.f74295b = view;
            this.f74296c = j11;
            this.f74297d = newsCommunityHandler;
            this.f74298e = listBean;
            this.f74299f = context;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f74295b) > this.f74296c || (this.f74295b instanceof Checkable)) {
                sVar.e(this.f74295b, currentTimeMillis);
                ImageView imageView = (ImageView) this.f74295b;
                gs.g.i("app_community_gd", this.f74297d.m(this.f74298e));
                com.hbg.module.content.utls.o.f(com.hbg.module.content.utls.o.f18923a, (FragmentActivity) this.f74299f, imageView, new NewsCommunityHandler$handleView$14$1(this.f74298e, this.f74297d, this.f74299f), false, BaseModuleConfig.a().s() == 1 || this.f74298e.getIsSelf() == 1, this.f74298e.getIsSelf() != 1, BaseModuleConfig.a().s() == 1 && this.f74298e.getIsSelf() != 1, 8, (Object) null);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class h implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f74300b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f74301c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ NewsCommunityHandler f74302d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CommunityFeedInfo.ListBean f74303e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ HomeFeedInfoItem f74304f;

        public h(View view, long j11, NewsCommunityHandler newsCommunityHandler, CommunityFeedInfo.ListBean listBean, HomeFeedInfoItem homeFeedInfoItem) {
            this.f74300b = view;
            this.f74301c = j11;
            this.f74302d = newsCommunityHandler;
            this.f74303e = listBean;
            this.f74304f = homeFeedInfoItem;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f74300b) > this.f74301c || (this.f74300b instanceof Checkable)) {
                sVar.e(this.f74300b, currentTimeMillis);
                ConstraintLayout constraintLayout = (ConstraintLayout) this.f74300b;
                NewsCommunityHandler newsCommunityHandler = this.f74302d;
                CommunityFeedInfo.ListBean listBean = this.f74303e;
                HomeFeedInfoItem homeFeedInfoItem = this.f74304f;
                newsCommunityHandler.y(listBean, homeFeedInfoItem.f73152c, Integer.valueOf(homeFeedInfoItem.f73165p));
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class i implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f74308b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f74309c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ NewsCommunityHandler f74310d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CommunityFeedInfo.ListBean f74311e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ HomeFeedInfoItem f74312f;

        public i(View view, long j11, NewsCommunityHandler newsCommunityHandler, CommunityFeedInfo.ListBean listBean, HomeFeedInfoItem homeFeedInfoItem) {
            this.f74308b = view;
            this.f74309c = j11;
            this.f74310d = newsCommunityHandler;
            this.f74311e = listBean;
            this.f74312f = homeFeedInfoItem;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f74308b) > this.f74309c || (this.f74308b instanceof Checkable)) {
                sVar.e(this.f74308b, currentTimeMillis);
                TextView textView = (TextView) this.f74308b;
                NewsCommunityHandler newsCommunityHandler = this.f74310d;
                CommunityFeedInfo.ListBean listBean = this.f74311e;
                HomeFeedInfoItem homeFeedInfoItem = this.f74312f;
                newsCommunityHandler.y(listBean, homeFeedInfoItem.f73152c, Integer.valueOf(homeFeedInfoItem.f73165p));
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class j implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f74313b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f74314c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ NewsCommunityHandler f74315d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CommunityFeedInfo.ListBean f74316e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ HomeFeedInfoItem f74317f;

        public j(View view, long j11, NewsCommunityHandler newsCommunityHandler, CommunityFeedInfo.ListBean listBean, HomeFeedInfoItem homeFeedInfoItem) {
            this.f74313b = view;
            this.f74314c = j11;
            this.f74315d = newsCommunityHandler;
            this.f74316e = listBean;
            this.f74317f = homeFeedInfoItem;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f74313b) > this.f74314c || (this.f74313b instanceof Checkable)) {
                sVar.e(this.f74313b, currentTimeMillis);
                ExpandableTextView expandableTextView = (ExpandableTextView) this.f74313b;
                NewsCommunityHandler newsCommunityHandler = this.f74315d;
                CommunityFeedInfo.ListBean listBean = this.f74316e;
                HomeFeedInfoItem homeFeedInfoItem = this.f74317f;
                newsCommunityHandler.y(listBean, homeFeedInfoItem.f73152c, Integer.valueOf(homeFeedInfoItem.f73165p));
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class k implements AvatarView.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewsCommunityHandler f74318a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CommunityFeedInfo.ListBean f74319b;

        public k(NewsCommunityHandler newsCommunityHandler, CommunityFeedInfo.ListBean listBean) {
            this.f74318a = newsCommunityHandler;
            this.f74319b = listBean;
        }

        public void a() {
            AvatarView.a.C0156a.b(this);
            gs.g.i("app_community_tx", this.f74318a.l(this.f74319b));
        }

        public void b(int i11, int i12) {
            AvatarView.a.C0156a.a(this, i11, i12);
        }
    }

    public static final class l extends CustomTarget<Drawable> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CommunityFeedInfo.ListBean f74320b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SpannableString f74321c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ TextView f74322d;

        public l(CommunityFeedInfo.ListBean listBean, SpannableString spannableString, TextView textView) {
            this.f74320b = listBean;
            this.f74321c = spannableString;
            this.f74322d = textView;
        }

        /* renamed from: a */
        public void onResourceReady(Drawable drawable, com.bumptech.glide.request.transition.a<? super Drawable> aVar) {
            drawable.setBounds(0, 0, com.hbg.module.libkt.utils.m.a(22), com.hbg.module.libkt.utils.m.a(22));
            ExpandableTextView.SelfImageSpan selfImageSpan = new ExpandableTextView.SelfImageSpan(drawable, 1);
            if (this.f74320b.getTop() == 1) {
                this.f74321c.setSpan(selfImageSpan, 1, 2, 33);
            } else {
                this.f74321c.setSpan(selfImageSpan, 0, 1, 33);
            }
            this.f74322d.setText(this.f74321c);
        }

        public void onLoadCleared(Drawable drawable) {
        }
    }

    public static final class m implements se.e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CommunityFeedInfo.ListBean f74323a;

        public m(CommunityFeedInfo.ListBean listBean) {
            this.f74323a = listBean;
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
            this.f74323a.setSeek(i12);
        }

        public void e() {
            e.a.a(this);
        }

        public void onError() {
            e.a.d(this);
        }
    }

    public static final class n implements PicView.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewsCommunityHandler f74324a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CommunityFeedInfo.ListBean f74325b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f74326c;

        public n(NewsCommunityHandler newsCommunityHandler, CommunityFeedInfo.ListBean listBean, Context context) {
            this.f74324a = newsCommunityHandler;
            this.f74325b = listBean;
            this.f74326c = context;
        }

        public void a(int i11, ArrayList<CommunityFeedInfo.imgListBean> arrayList) {
            PicView.a.C0216a.a(this, i11, arrayList);
        }

        public void b(int i11, ArrayList<CommunityFeedInfo.imgListBean> arrayList) {
            ArrayList arrayList2 = new ArrayList();
            if (arrayList != null) {
                for (CommunityFeedInfo.imgListBean imglistbean : arrayList) {
                    arrayList2.add(new ImageData(imglistbean.getImage(), imglistbean.getThumbImage()));
                }
            }
            gs.g.i("app_community_picdj", this.f74324a.l(this.f74325b));
            PhotoViewerUtils.a((FragmentActivity) this.f74326c, arrayList2, i11);
        }
    }

    public static final class o extends ClickableSpan {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CommunityFeedInfo.HotComment f74327b;

        public o(CommunityFeedInfo.HotComment hotComment) {
            this.f74327b = hotComment;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            b2.a.d().a("/content/PersonalCenter").withString("uidUnique", this.f74327b.hotComUid).navigation();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
        }
    }

    public static final class p implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f74328b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f74329c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ NewsCommunityHandler f74330d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CommunityFeedInfo.ListBean f74331e;

        public p(View view, long j11, NewsCommunityHandler newsCommunityHandler, CommunityFeedInfo.ListBean listBean) {
            this.f74328b = view;
            this.f74329c = j11;
            this.f74330d = newsCommunityHandler;
            this.f74331e = listBean;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f74328b) > this.f74329c || (this.f74328b instanceof Checkable)) {
                sVar.e(this.f74328b, currentTimeMillis);
                TextView textView = (TextView) this.f74328b;
                HbgBaseProvider g11 = this.f74330d.f74259b;
                if (g11 != null) {
                    g11.g(this.f74331e.getShareLink());
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class q implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f74332b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f74333c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ NewsCommunityHandler f74334d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CommunityFeedInfo.ListBean f74335e;

        public q(View view, long j11, NewsCommunityHandler newsCommunityHandler, CommunityFeedInfo.ListBean listBean) {
            this.f74332b = view;
            this.f74333c = j11;
            this.f74334d = newsCommunityHandler;
            this.f74335e = listBean;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f74332b) > this.f74333c || (this.f74332b instanceof Checkable)) {
                sVar.e(this.f74332b, currentTimeMillis);
                TextView textView = (TextView) this.f74332b;
                HbgBaseProvider g11 = this.f74334d.f74259b;
                if (g11 != null) {
                    g11.g(this.f74335e.getShareLink());
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class r implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f74336b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f74337c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ NewsCommunityHandler f74338d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CommunityFeedInfo.ListBean f74339e;

        public r(View view, long j11, NewsCommunityHandler newsCommunityHandler, CommunityFeedInfo.ListBean listBean) {
            this.f74336b = view;
            this.f74337c = j11;
            this.f74338d = newsCommunityHandler;
            this.f74339e = listBean;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f74336b) > this.f74337c || (this.f74336b instanceof Checkable)) {
                sVar.e(this.f74336b, currentTimeMillis);
                TextView textView = (TextView) this.f74336b;
                HbgBaseProvider g11 = this.f74338d.f74259b;
                if (g11 != null) {
                    g11.g(this.f74339e.getShareLink());
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class s implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f74340b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f74341c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ NewsCommunityHandler f74342d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CommunityFeedInfo.ListBean f74343e;

        public s(View view, long j11, NewsCommunityHandler newsCommunityHandler, CommunityFeedInfo.ListBean listBean) {
            this.f74340b = view;
            this.f74341c = j11;
            this.f74342d = newsCommunityHandler;
            this.f74343e = listBean;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f74340b) > this.f74341c || (this.f74340b instanceof Checkable)) {
                sVar.e(this.f74340b, currentTimeMillis);
                TextView textView = (TextView) this.f74340b;
                HbgBaseProvider g11 = this.f74342d.f74259b;
                if (g11 != null) {
                    g11.g(this.f74343e.getShareFromLink());
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class t implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f74348b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f74349c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ NewsCommunityHandler f74350d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CommunityFeedInfo.ListBean f74351e;

        public t(View view, long j11, NewsCommunityHandler newsCommunityHandler, CommunityFeedInfo.ListBean listBean) {
            this.f74348b = view;
            this.f74349c = j11;
            this.f74350d = newsCommunityHandler;
            this.f74351e = listBean;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f74348b) > this.f74349c || (this.f74348b instanceof Checkable)) {
                sVar.e(this.f74348b, currentTimeMillis);
                TextView textView = (TextView) this.f74348b;
                HbgBaseProvider g11 = this.f74350d.f74259b;
                if (g11 != null) {
                    g11.g(this.f74351e.getShareFromLink());
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class u implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f74352b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f74353c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ NewsCommunityHandler f74354d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CommunityFeedInfo.ListBean f74355e;

        public u(View view, long j11, NewsCommunityHandler newsCommunityHandler, CommunityFeedInfo.ListBean listBean) {
            this.f74352b = view;
            this.f74353c = j11;
            this.f74354d = newsCommunityHandler;
            this.f74355e = listBean;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f74352b) > this.f74353c || (this.f74352b instanceof Checkable)) {
                sVar.e(this.f74352b, currentTimeMillis);
                HbgBaseProvider g11 = this.f74354d.f74259b;
                if (g11 != null) {
                    g11.g(this.f74355e.getShareLink());
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class v implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f74356b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f74357c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CommunityFeedInfo.ListBean f74358d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f74359e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Integer f74360f;

        public v(View view, long j11, CommunityFeedInfo.ListBean listBean, String str, Integer num) {
            this.f74356b = view;
            this.f74357c = j11;
            this.f74358d = listBean;
            this.f74359e = str;
            this.f74360f = num;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f74356b) > this.f74357c || (this.f74356b instanceof Checkable)) {
                sVar.e(this.f74356b, currentTimeMillis);
                EllipsizeTextView ellipsizeTextView = (EllipsizeTextView) this.f74356b;
                CommunityFeedInfo.ListBean listBean = this.f74358d;
                int i11 = 0;
                long id2 = (long) (listBean != null ? listBean.getId() : 0);
                String str = this.f74359e;
                CommunityFeedInfo.ListBean listBean2 = this.f74358d;
                Integer num = null;
                String title = listBean2 != null ? listBean2.getTitle() : null;
                Integer num2 = this.f74360f;
                int intValue = num2 != null ? num2.intValue() : 1;
                CommunityFeedInfo.ListBean listBean3 = this.f74358d;
                if (listBean3 != null) {
                    i11 = listBean3.getShareType();
                }
                gs.g.g("app_recome_content_click", HomeSensorsHelper.e(id2, str, title, "community", intValue, (String) null, i11, 4));
                Postcard a11 = b2.a.d().a("/content/DynamicDetail");
                CommunityFeedInfo.ListBean listBean4 = this.f74358d;
                if (listBean4 != null) {
                    num = Integer.valueOf(listBean4.getId());
                }
                a11.withString("dynamicId", String.valueOf(num)).navigation();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class w extends ClickableSpan {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ RichTextBean f74361b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f74362c;

        public w(RichTextBean richTextBean, Context context) {
            this.f74361b = richTextBean;
            this.f74362c = context;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            b2.a.d().a("/webView/index").withString("url", this.f74361b.data.url).navigation(this.f74362c);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            int color = this.f74362c.getResources().getColor(R.color.baseColorMajorTheme100);
            textPaint.setUnderlineText(false);
            textPaint.setColor(color);
        }
    }

    public NewsCommunityHandler() {
        int a11 = Resources.getSystem().getDisplayMetrics().widthPixels - (com.hbg.module.libkt.utils.m.a(16) * 2);
        this.f74261d = a11;
        this.f74262e = (int) (((float) a11) * 0.5625f);
    }

    public static final boolean o(NewsCommunityHandler newsCommunityHandler, CommunityFeedInfo.ListBean listBean, Context context, TextView textView, ExpandableTextView expandableTextView, View view) {
        gs.g.i("app_community_gckpfy", newsCommunityHandler.l(listBean));
        newsCommunityHandler.C(context, textView, expandableTextView, listBean, view);
        return true;
    }

    public static final void p(NewsCommunityHandler newsCommunityHandler, CommunityFeedInfo.ListBean listBean, HomeFeedInfoItem homeFeedInfoItem, StatusType statusType) {
        newsCommunityHandler.y(listBean, homeFeedInfoItem.f73152c, Integer.valueOf(homeFeedInfoItem.f73165p));
    }

    public static final boolean q(NewsCommunityHandler newsCommunityHandler, CommunityFeedInfo.ListBean listBean, Context context, TextView textView, ExpandableTextView expandableTextView, View view) {
        gs.g.i("app_community_gckpfy", newsCommunityHandler.l(listBean));
        newsCommunityHandler.C(context, textView, expandableTextView, listBean, view);
        return true;
    }

    public static final void r(NewsCommunityHandler newsCommunityHandler, LinkType linkType, String str, String str2) {
        if (linkType == LinkType.MENTION_TYPE) {
            i6.d.b("link click, url = " + str);
            try {
                HbgBaseProvider hbgBaseProvider = newsCommunityHandler.f74259b;
                if (hbgBaseProvider != null) {
                    hbgBaseProvider.g(str);
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public static final void s(NewsCommunityHandler newsCommunityHandler, CommunityFeedInfo.ListBean listBean, LinkType linkType, String str, String str2) {
        if (linkType == LinkType.MENTION_TYPE) {
            HashMap<Object, Object> l11 = newsCommunityHandler.l(listBean);
            CommunityFeedInfo.TopicTag topicTag = listBean.getTopic().get(0);
            int i11 = -1;
            l11.put(CommunityConstants.TOPIC_ID, Integer.valueOf(topicTag != null ? topicTag.getTopicId() : -1));
            CommunityFeedInfo.TopicTag topicTag2 = listBean.getTopic().get(0);
            Integer num = null;
            String title = topicTag2 != null ? topicTag2.getTitle() : null;
            if (title == null) {
                title = "";
            }
            l11.put("title", title);
            CommunityFeedInfo.TopicTag topicTag3 = listBean.getTopic().get(0);
            if (topicTag3 != null) {
                i11 = topicTag3.getIdentification();
            }
            l11.put("identification", Integer.valueOf(i11));
            gs.g.i("app_community_nrkpht", l11);
            Postcard a11 = b2.a.d().a("/content/topicDetail");
            CommunityFeedInfo.TopicTag topicTag4 = listBean.getTopic().get(0);
            if (topicTag4 != null) {
                num = Integer.valueOf(topicTag4.getTopicId());
            }
            a11.withString(CommunityConstants.TOPIC_ID, String.valueOf(num)).navigation();
        }
    }

    public static /* synthetic */ void u(NewsCommunityHandler newsCommunityHandler, LinearLayout linearLayout, RichTextBean richTextBean, SpannableStringBuilder spannableStringBuilder, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            spannableStringBuilder = null;
        }
        newsCommunityHandler.t(linearLayout, richTextBean, spannableStringBuilder);
    }

    public static /* synthetic */ void x(NewsCommunityHandler newsCommunityHandler, TextView textView, ExpandableTextView expandableTextView, CommunityFeedInfo.ListBean listBean, boolean z11, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            z11 = false;
        }
        newsCommunityHandler.w(textView, expandableTextView, listBean, z11);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0058  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void A(android.widget.TextView r4, android.widget.ImageView r5, com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo.ListBean r6) {
        /*
            r3 = this;
            int r0 = r6.getPraiseNum()
            com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo$ListBean$AttitudeInfo r1 = r6.getAttitudeInfo()
            r2 = 0
            if (r1 == 0) goto L_0x000e
            int r1 = r1.attitudeCount
            goto L_0x000f
        L_0x000e:
            r1 = r2
        L_0x000f:
            int r0 = r0 + r1
            java.lang.String r0 = he.b.a(r0)
            r4.setText(r0)
            int r0 = r6.getPraiseStatus()
            r1 = 1
            if (r0 == r1) goto L_0x0035
            com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo$ListBean$AttitudeInfo r0 = r6.getAttitudeInfo()
            if (r0 == 0) goto L_0x0026
            int r2 = r0.userAttitudeType
        L_0x0026:
            if (r2 == 0) goto L_0x0029
            goto L_0x0035
        L_0x0029:
            android.content.Context r0 = r4.getContext()
            r1 = 2130969952(0x7f040560, float:1.75486E38)
            int r0 = com.hbg.module.libkt.base.ext.b.o(r0, r1)
            goto L_0x0040
        L_0x0035:
            android.content.Context r0 = r4.getContext()
            r1 = 2130969058(0x7f0401e2, float:1.7546787E38)
            int r0 = com.hbg.module.libkt.base.ext.b.o(r0, r1)
        L_0x0040:
            r4.setTextColor(r0)
            int r6 = r6.getPraiseStatus()
            if (r6 != 0) goto L_0x0058
            android.content.Context r4 = r4.getContext()
            r6 = 2130969749(0x7f040495, float:1.7548189E38)
            int r4 = com.hbg.module.libkt.base.ext.b.q(r4, r6)
            com.hbg.module.libkt.base.ext.b.A(r5, r4)
            goto L_0x0066
        L_0x0058:
            android.content.Context r4 = r4.getContext()
            r6 = 2130969750(0x7f040496, float:1.754819E38)
            int r4 = com.hbg.module.libkt.base.ext.b.q(r4, r6)
            com.hbg.module.libkt.base.ext.b.A(r5, r4)
        L_0x0066:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.index.viewhandler.NewsCommunityHandler.A(android.widget.TextView, android.widget.ImageView, com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo$ListBean):void");
    }

    public final void B(Context context, SpannableStringBuilder spannableStringBuilder, RichTextBean richTextBean, String str) {
        int length = spannableStringBuilder.length();
        int length2 = richTextBean.character.length() + length + str.length();
        spannableStringBuilder.append(str + richTextBean.character + ' ');
        spannableStringBuilder.setSpan(new w(richTextBean, context), length, length2, 33);
    }

    public final void C(Context context, TextView textView, ExpandableTextView expandableTextView, CommunityFeedInfo.ListBean listBean, View view) {
        new TipsPopDialog(context, new NewsCommunityHandler$showTransPop$1(listBean, this, textView, expandableTextView), (String) null, (String) null, true, listBean.isTrans() ^ true ? 1 : 0, 12, (kotlin.jvm.internal.r) null).g(view);
    }

    public final void D(Context context, int i11, String str) {
        RequestExtKt.d(v7.b.a().t(i11, str), NewsCommunityHandler$userMute$1.INSTANCE, new NewsCommunityHandler$userMute$2(this, context), (MutableLiveData) null, 4, (Object) null);
    }

    public final void E(Context context, String str) {
        RequestExtKt.d(v7.b.a().v(str), NewsCommunityHandler$userUnMute$1.INSTANCE, new NewsCommunityHandler$userUnMute$2(this, context), (MutableLiveData) null, 4, (Object) null);
    }

    public int getResId() {
        return R.layout.item_community_base;
    }

    public final HashMap<Object, Object> l(CommunityFeedInfo.ListBean listBean) {
        return MapsKt__MapsKt.j(kotlin.l.a("communityId", Integer.valueOf(listBean.getId())), kotlin.l.a("uid", listBean.getUidUnique()), kotlin.l.a("title", listBean.getTitle()), kotlin.l.a("type", Integer.valueOf(listBean.getType())), kotlin.l.a("praiseNum", Integer.valueOf(listBean.getPraiseNum())), kotlin.l.a("commentNum", Integer.valueOf(listBean.getCommentNum())), kotlin.l.a("recom_base_info", listBean.getRecom_base_info()));
    }

    public final HashMap<String, Object> m(CommunityFeedInfo.ListBean listBean) {
        return new NewsCommunityHandler$getTrackData$1(listBean);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:128:0x037d, code lost:
        if (r0 == null) goto L_0x037f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0377  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x037c  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0231  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x026a  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x029d  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x029f  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x02a7  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x02b5  */
    @android.annotation.SuppressLint({"SetTextI18n"})
    /* renamed from: n */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleView(v9.c r52, int r53, com.huobi.index.bean.HomeFeedInfoItem r54, android.view.ViewGroup r55) {
        /*
            r51 = this;
            r9 = r51
            r10 = r54
            i6.r r0 = r52.e()
            r1 = 2131428557(0x7f0b04cd, float:1.8478762E38)
            android.view.View r1 = r0.b(r1)
            r11 = r1
            androidx.constraintlayout.widget.ConstraintLayout r11 = (androidx.constraintlayout.widget.ConstraintLayout) r11
            r1 = 2131427780(0x7f0b01c4, float:1.8477186E38)
            android.view.View r1 = r0.b(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r2 = 2131435812(0x7f0b2124, float:1.8493477E38)
            android.view.View r2 = r0.b(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r3 = 2131435769(0x7f0b20f9, float:1.849339E38)
            android.view.View r3 = r0.b(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            r4 = 2131435662(0x7f0b208e, float:1.8493173E38)
            android.view.View r4 = r0.b(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r5 = 2131435880(0x7f0b2168, float:1.8493615E38)
            android.view.View r5 = r0.b(r5)
            r12 = r5
            android.widget.TextView r12 = (android.widget.TextView) r12
            r5 = 2131432039(0x7f0b1267, float:1.8485824E38)
            android.view.View r5 = r0.b(r5)
            r6 = 2131429847(0x7f0b09d7, float:1.8481378E38)
            android.view.View r6 = r0.b(r6)
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            r7 = 2131430891(0x7f0b0deb, float:1.8483496E38)
            android.view.View r7 = r0.b(r7)
            com.hbg.module.huobi.im.view.AvatarView r7 = (com.hbg.module.huobi.im.view.AvatarView) r7
            r8 = 2131435648(0x7f0b2080, float:1.8493144E38)
            android.view.View r8 = r0.b(r8)
            r15 = r8
            com.huochat.community.widget.expandable.ExpandableTextView r15 = (com.huochat.community.widget.expandable.ExpandableTextView) r15
            r8 = 2131427764(0x7f0b01b4, float:1.8477153E38)
            android.view.View r8 = r0.b(r8)
            android.widget.FrameLayout r8 = (android.widget.FrameLayout) r8
            r13 = 2131435642(0x7f0b207a, float:1.8493132E38)
            android.view.View r13 = r0.b(r13)
            android.widget.TextView r13 = (android.widget.TextView) r13
            r14 = 2131435721(0x7f0b20c9, float:1.8493292E38)
            android.view.View r14 = r0.b(r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            r52 = r14
            r14 = 2131435851(0x7f0b214b, float:1.8493556E38)
            android.view.View r14 = r0.b(r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            r53 = r14
            r14 = 2131430894(0x7f0b0dee, float:1.8483502E38)
            android.view.View r14 = r0.b(r14)
            android.widget.ImageView r14 = (android.widget.ImageView) r14
            r55 = r14
            r14 = 2131432195(0x7f0b1303, float:1.848614E38)
            android.view.View r14 = r0.b(r14)
            android.widget.LinearLayout r14 = (android.widget.LinearLayout) r14
            r22 = r14
            r14 = 2131428572(0x7f0b04dc, float:1.8478792E38)
            android.view.View r14 = r0.b(r14)
            android.widget.FrameLayout r14 = (android.widget.FrameLayout) r14
            r23 = r13
            r13 = 2131434093(0x7f0b1a6d, float:1.848999E38)
            android.view.View r13 = r0.b(r13)
            android.widget.LinearLayout r13 = (android.widget.LinearLayout) r13
            r24 = r13
            r13 = 2131434083(0x7f0b1a63, float:1.848997E38)
            android.view.View r13 = r0.b(r13)
            android.widget.RelativeLayout r13 = (android.widget.RelativeLayout) r13
            r25 = r13
            r13 = 2131434100(0x7f0b1a74, float:1.8490004E38)
            android.view.View r13 = r0.b(r13)
            android.widget.RelativeLayout r13 = (android.widget.RelativeLayout) r13
            r26 = r13
            r13 = 2131430893(0x7f0b0ded, float:1.84835E38)
            android.view.View r13 = r0.b(r13)
            android.widget.ImageView r13 = (android.widget.ImageView) r13
            r27 = r13
            r13 = 2131432223(0x7f0b131f, float:1.8486197E38)
            android.view.View r0 = r0.b(r13)
            r13 = r0
            android.widget.LinearLayout r13 = (android.widget.LinearLayout) r13
            android.content.Context r0 = r11.getContext()
            r35 = r8
            r8 = 2131099868(0x7f0600dc, float:1.7812101E38)
            r11.setBackgroundResource(r8)
            if (r10 == 0) goto L_0x00f3
            com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo$ListBean r8 = r10.f73160k
            goto L_0x00f4
        L_0x00f3:
            r8 = 0
        L_0x00f4:
            if (r8 != 0) goto L_0x00f7
            return
        L_0x00f7:
            com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo$ListBean r8 = r10.f73160k
            r9.v(r0, r8, r14)
            java.lang.String r17 = r8.getRecommendWord()
            boolean r17 = android.text.TextUtils.isEmpty(r17)
            r36 = r11
            r11 = 8
            r37 = r14
            r14 = 0
            if (r17 == 0) goto L_0x0111
            r1.setVisibility(r11)
            goto L_0x011b
        L_0x0111:
            java.lang.String r11 = r8.getRecommendWord()
            r1.setText(r11)
            r1.setVisibility(r14)
        L_0x011b:
            int r1 = r8.visit
            if (r1 <= 0) goto L_0x0127
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r2.setText(r1)
            goto L_0x012f
        L_0x0127:
            r1 = 8
            r2.setVisibility(r1)
            r5.setVisibility(r1)
        L_0x012f:
            java.lang.String r1 = r8.imageUrl
            r11 = 1
            if (r1 == 0) goto L_0x013d
            int r1 = r1.length()
            if (r1 != 0) goto L_0x013b
            goto L_0x013d
        L_0x013b:
            r1 = r14
            goto L_0x013e
        L_0x013d:
            r1 = r11
        L_0x013e:
            if (r1 == 0) goto L_0x0146
            r1 = 8
            r6.setVisibility(r1)
            goto L_0x014e
        L_0x0146:
            r6.setVisibility(r14)
            java.lang.String r1 = r8.imageUrl
            com.hbg.module.libkt.base.ext.b.B(r6, r1)
        L_0x014e:
            java.lang.String r1 = r8.getUserAvatar()
            boolean r1 = com.hbg.module.libkt.base.ext.b.x(r1)
            java.lang.String r2 = "BIG_V"
            if (r1 == 0) goto L_0x018f
            java.lang.String r1 = r8.getUidUnique()
            r5 = 0
            com.hbg.module.huobi.im.view.AvatarView r1 = r7.z(r1, r5)
            r5 = 2131230995(0x7f080113, float:1.8078059E38)
            int r6 = r8.getIsAlive()
            r1.y(r5, r6)
            int r1 = r8.getIsAlive()
            if (r1 != 0) goto L_0x0175
            r1 = r11
            goto L_0x0176
        L_0x0175:
            r1 = r14
        L_0x0176:
            if (r1 == 0) goto L_0x018a
            com.hbg.lib.network.hbg.core.bean.PersonalCenterInfo$UcExtInfo r1 = r8.getUcExtInfo()
            if (r1 == 0) goto L_0x0181
            java.lang.String r1 = r1.showExtBusinessTag
            goto L_0x0182
        L_0x0181:
            r1 = 0
        L_0x0182:
            boolean r1 = kotlin.jvm.internal.x.b(r2, r1)
            if (r1 == 0) goto L_0x018a
            r1 = r11
            goto L_0x018b
        L_0x018a:
            r1 = r14
        L_0x018b:
            r7.A(r1)
            goto L_0x01e9
        L_0x018f:
            java.lang.String r1 = r8.getUserAvatar()
            com.hbg.lib.network.hbg.core.bean.PersonalCenterInfo$UcExtInfo r5 = r8.getUcExtInfo()
            if (r5 == 0) goto L_0x019c
            java.lang.String r5 = r5.headImageType
            goto L_0x019d
        L_0x019c:
            r5 = 0
        L_0x019d:
            java.lang.String r6 = "NFT"
            boolean r5 = kotlin.jvm.internal.x.b(r5, r6)
            com.hbg.lib.network.hbg.core.bean.PersonalCenterInfo$UcExtInfo r6 = r8.getUcExtInfo()
            if (r6 == 0) goto L_0x01ac
            java.lang.String r6 = r6.frameUrl
            goto L_0x01ad
        L_0x01ac:
            r6 = 0
        L_0x01ad:
            com.hbg.module.huobi.im.view.AvatarView r38 = r7.u(r1, r5, r6)
            int r39 = r8.getIsAlive()
            r40 = -1
            java.lang.String r41 = r8.getUidUnique()
            r42 = 0
            r43 = 0
            r44 = 0
            r45 = 48
            r46 = 0
            com.hbg.module.huobi.im.view.AvatarView.t(r38, r39, r40, r41, r42, r43, r44, r45, r46)
            int r1 = r8.getIsAlive()
            if (r1 != 0) goto L_0x01d0
            r1 = r11
            goto L_0x01d1
        L_0x01d0:
            r1 = r14
        L_0x01d1:
            if (r1 == 0) goto L_0x01e5
            com.hbg.lib.network.hbg.core.bean.PersonalCenterInfo$UcExtInfo r1 = r8.getUcExtInfo()
            if (r1 == 0) goto L_0x01dc
            java.lang.String r1 = r1.showExtBusinessTag
            goto L_0x01dd
        L_0x01dc:
            r1 = 0
        L_0x01dd:
            boolean r1 = kotlin.jvm.internal.x.b(r2, r1)
            if (r1 == 0) goto L_0x01e5
            r1 = r11
            goto L_0x01e6
        L_0x01e5:
            r1 = r14
        L_0x01e6:
            r7.A(r1)
        L_0x01e9:
            com.huobi.index.viewhandler.NewsCommunityHandler$k r1 = new com.huobi.index.viewhandler.NewsCommunityHandler$k
            r1.<init>(r9, r8)
            r7.setAvatarClickListener(r1)
            java.lang.String r1 = r8.getUserNickname()
            r3.setText(r1)
            int r1 = r8.getIsShowEventTag()
            r6 = 3
            java.lang.String r7 = ""
            if (r1 != r11) goto L_0x0225
            int r1 = r8.getType()
            if (r1 != r11) goto L_0x0213
            android.content.res.Resources r1 = r0.getResources()
            r2 = 2132020587(0x7f140d6b, float:1.9679541E38)
            java.lang.String r1 = r1.getString(r2)
            goto L_0x0226
        L_0x0213:
            int r1 = r8.getType()
            if (r1 != r6) goto L_0x0225
            android.content.res.Resources r1 = r0.getResources()
            r2 = 2132020584(0x7f140d68, float:1.9679535E38)
            java.lang.String r1 = r1.getString(r2)
            goto L_0x0226
        L_0x0225:
            r1 = r7
        L_0x0226:
            long r2 = r8.getInteractiveTime()
            r17 = 0
            int r2 = (r2 > r17 ? 1 : (r2 == r17 ? 0 : -1))
            r5 = 2
            if (r2 <= 0) goto L_0x026a
            int r1 = r8.getInteractiveType()
            if (r1 == r11) goto L_0x0248
            if (r1 == r5) goto L_0x023c
            java.lang.String r1 = "%s"
            goto L_0x0253
        L_0x023c:
            android.content.res.Resources r1 = r0.getResources()
            r2 = 2132020621(0x7f140d8d, float:1.967961E38)
            java.lang.String r1 = r1.getString(r2)
            goto L_0x0253
        L_0x0248:
            android.content.res.Resources r1 = r0.getResources()
            r2 = 2132020572(0x7f140d5c, float:1.967951E38)
            java.lang.String r1 = r1.getString(r2)
        L_0x0253:
            kotlin.jvm.internal.d0 r2 = kotlin.jvm.internal.d0.f56774a
            java.lang.Object[] r2 = new java.lang.Object[r11]
            long r5 = r8.getInteractiveTime()
            java.lang.String r3 = com.hbg.module.huobi.im.utils.DateUtils.f(r0, r5)
            r2[r14] = r3
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r2, r11)
            java.lang.String r1 = java.lang.String.format(r1, r2)
            goto L_0x028d
        L_0x026a:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.Long r3 = r8.getCreatedTime()
            long r5 = r3.longValue()
            java.lang.String r3 = com.hbg.module.huobi.im.utils.DateUtils.f(r0, r5)
            r2.append(r3)
            r3 = 32
            r2.append(r3)
            r2.append(r1)
            r2.append(r3)
            java.lang.String r1 = r2.toString()
        L_0x028d:
            r4.setText(r1)
            java.lang.String r1 = r8.getTitle()
            if (r1 == 0) goto L_0x029f
            int r1 = r1.length()
            if (r1 != 0) goto L_0x029d
            goto L_0x029f
        L_0x029d:
            r1 = r14
            goto L_0x02a0
        L_0x029f:
            r1 = r11
        L_0x02a0:
            r6 = 5
            r5 = 4
            r4 = 2130969695(0x7f04045f, float:1.754808E38)
            if (r1 == 0) goto L_0x02b5
            r1 = 8
            r12.setVisibility(r1)
            r15.reSetMaxLines(r6)
            r38 = r0
            r14 = r5
        L_0x02b2:
            r6 = 2
            goto L_0x035a
        L_0x02b5:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            int r2 = r8.getTop()
            if (r2 != r11) goto L_0x02c5
            java.lang.String r2 = " "
            r1.append(r2)
        L_0x02c5:
            java.lang.String r2 = r8.airdropIcon
            if (r2 == 0) goto L_0x02d2
            int r2 = r2.length()
            if (r2 != 0) goto L_0x02d0
            goto L_0x02d2
        L_0x02d0:
            r2 = r14
            goto L_0x02d3
        L_0x02d2:
            r2 = r11
        L_0x02d3:
            if (r2 != 0) goto L_0x02da
            java.lang.String r2 = "  "
            r1.append(r2)
        L_0x02da:
            java.lang.String r2 = r8.getTitle()
            r1.append(r2)
            android.text.SpannableString r2 = new android.text.SpannableString
            r2.<init>(r1)
            int r1 = r8.getTop()
            if (r1 != r11) goto L_0x0309
            android.graphics.drawable.Drawable r1 = com.hbg.module.libkt.base.ext.b.p(r0, r4)
            if (r1 == 0) goto L_0x0309
            int r3 = r1.getIntrinsicWidth()
            int r4 = r1.getIntrinsicHeight()
            r1.setBounds(r14, r14, r3, r4)
            com.huochat.community.widget.expandable.ExpandableTextView$SelfImageSpan r3 = new com.huochat.community.widget.expandable.ExpandableTextView$SelfImageSpan
            r3.<init>(r1, r11)
            r1 = 33
            r2.setSpan(r3, r14, r11, r1)
            kotlin.Unit r1 = kotlin.Unit.f56620a
        L_0x0309:
            java.lang.String r1 = r8.airdropIcon
            if (r1 == 0) goto L_0x0316
            int r1 = r1.length()
            if (r1 != 0) goto L_0x0314
            goto L_0x0316
        L_0x0314:
            r1 = r14
            goto L_0x0317
        L_0x0316:
            r1 = r11
        L_0x0317:
            if (r1 != 0) goto L_0x032b
            com.bumptech.glide.d r1 = com.bumptech.glide.a.v(r0)
            java.lang.String r3 = r8.airdropIcon
            com.bumptech.glide.c r1 = r1.q(r3)
            com.huobi.index.viewhandler.NewsCommunityHandler$l r3 = new com.huobi.index.viewhandler.NewsCommunityHandler$l
            r3.<init>(r8, r2, r12)
            r1.A0(r3)
        L_0x032b:
            r12.setText(r2)
            r12.setVisibility(r14)
            com.huobi.index.viewhandler.u r4 = new com.huobi.index.viewhandler.u
            r3 = r0
            r0 = r4
            r1 = r51
            r2 = r8
            r38 = r3
            r6 = r4
            r4 = r12
            r14 = r5
            r5 = r15
            r0.<init>(r1, r2, r3, r4, r5)
            r12.setOnLongClickListener(r6)
            int r0 = r12.getLineCount()
            if (r0 != r11) goto L_0x034f
            r15.reSetMaxLines(r14)
            goto L_0x02b2
        L_0x034f:
            int r0 = r12.getLineCount()
            r6 = 2
            if (r0 != r6) goto L_0x035a
            r0 = 3
            r15.reSetMaxLines(r0)
        L_0x035a:
            java.util.List r0 = r8.getTopic()
            if (r0 == 0) goto L_0x037f
            java.util.List r0 = r8.getTopic()
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x037f
            java.util.List r0 = r8.getTopic()
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo$TopicTag r0 = (com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo.TopicTag) r0
            if (r0 == 0) goto L_0x037c
            java.lang.String r0 = r0.getTitle()
            goto L_0x037d
        L_0x037c:
            r0 = 0
        L_0x037d:
            if (r0 != 0) goto L_0x0380
        L_0x037f:
            r0 = r7
        L_0x0380:
            int r1 = r8.getTextType()
            if (r1 != r6) goto L_0x039e
            r1 = 8
            r15.setVisibility(r1)
            r2 = 0
            r13.setVisibility(r2)
            java.lang.String r0 = r10.f73152c
            int r3 = r10.f73165p
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r9.z(r8, r13, r0, r3)
            r5 = r38
            goto L_0x045a
        L_0x039e:
            r1 = 8
            r2 = 0
            r15.setVisibility(r2)
            r13.setVisibility(r1)
            r15.setNeedShowPrefixMarkIcon(r2)
            java.util.List r1 = r8.getSpecialContent()
            if (r1 == 0) goto L_0x03f8
            java.util.List r1 = r8.getSpecialContent()
            int r1 = r1.size()
            if (r1 <= 0) goto L_0x03f8
            r15.setVisibility(r2)
            int r0 = r8.getTop()
            if (r0 != r11) goto L_0x03e5
            java.lang.String r0 = r8.getTitle()
            if (r0 == 0) goto L_0x03d2
            int r0 = r0.length()
            if (r0 != 0) goto L_0x03d0
            goto L_0x03d2
        L_0x03d0:
            r0 = 0
            goto L_0x03d3
        L_0x03d2:
            r0 = r11
        L_0x03d3:
            if (r0 == 0) goto L_0x03e5
            r15.setNeedShowPrefixMarkIcon(r11)
            r5 = r38
            r1 = 2130969695(0x7f04045f, float:1.754808E38)
            android.graphics.drawable.Drawable r0 = com.hbg.module.libkt.base.ext.b.p(r5, r1)
            r15.setPrefixMarkDrawable(r0)
            goto L_0x03e7
        L_0x03e5:
            r5 = r38
        L_0x03e7:
            java.util.List r0 = r8.getSpecialContent()
            r15.setContent(r0)
            com.huobi.index.viewhandler.x r0 = new com.huobi.index.viewhandler.x
            r0.<init>(r9)
            r15.setLinkClickListener(r0)
            goto L_0x045a
        L_0x03f8:
            r5 = r38
            r1 = 2130969695(0x7f04045f, float:1.754808E38)
            int r2 = r0.length()
            if (r2 != 0) goto L_0x0405
            r2 = r11
            goto L_0x0406
        L_0x0405:
            r2 = 0
        L_0x0406:
            if (r2 == 0) goto L_0x0424
            java.lang.String r2 = r8.getContent()
            if (r2 == 0) goto L_0x0417
            int r2 = r2.length()
            if (r2 != 0) goto L_0x0415
            goto L_0x0417
        L_0x0415:
            r2 = 0
            goto L_0x0418
        L_0x0417:
            r2 = r11
        L_0x0418:
            if (r2 == 0) goto L_0x0424
            r2 = 0
            r15.setContentWithHeadTopic(r7, r7, r2)
            r0 = 8
            r15.setVisibility(r0)
            goto L_0x045a
        L_0x0424:
            r2 = 0
            r15.setVisibility(r2)
            int r2 = r8.getTop()
            if (r2 != r11) goto L_0x044a
            java.lang.String r2 = r8.getTitle()
            if (r2 == 0) goto L_0x043d
            int r2 = r2.length()
            if (r2 != 0) goto L_0x043b
            goto L_0x043d
        L_0x043b:
            r2 = 0
            goto L_0x043e
        L_0x043d:
            r2 = r11
        L_0x043e:
            if (r2 == 0) goto L_0x044a
            r15.setNeedShowPrefixMarkIcon(r11)
            android.graphics.drawable.Drawable r1 = com.hbg.module.libkt.base.ext.b.p(r5, r1)
            r15.setPrefixMarkDrawable(r1)
        L_0x044a:
            java.lang.String r1 = r8.getContent()
            r2 = 0
            r15.setContentWithHeadTopic(r1, r0, r2)
            com.huobi.index.viewhandler.y r0 = new com.huobi.index.viewhandler.y
            r0.<init>(r9, r8)
            r15.setLinkClickListener(r0)
        L_0x045a:
            r35.removeAllViews()
            int r0 = r8.getShowTag()
            if (r0 != r11) goto L_0x04d9
            com.hbg.module.libkt.common.PkCommonView r0 = new com.hbg.module.libkt.common.PkCommonView
            r30 = 0
            r31 = 0
            r32 = 0
            r33 = 14
            r34 = 0
            r28 = r0
            r29 = r5
            r28.<init>(r29, r30, r31, r32, r33, r34)
            r1 = 2131433575(0x7f0b1867, float:1.848894E38)
            r0.setId(r1)
            com.hbg.lib.network.hbg.core.bean.CommonPkData r1 = r8.getVote()
            r0.setView(r1)
            com.huobi.view.roundview.RoundLinearLayout r1 = new com.huobi.view.roundview.RoundLinearLayout
            r1.<init>(r5)
            android.widget.FrameLayout$LayoutParams r2 = new android.widget.FrameLayout$LayoutParams
            r3 = -1
            r4 = -2
            r2.<init>(r3, r4)
            r1.setLayoutParams(r2)
            r2 = 1094713344(0x41400000, float:12.0)
            java.lang.Float r7 = java.lang.Float.valueOf(r2)
            int r7 = sd.a.b(r7)
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            int r2 = sd.a.b(r2)
            r14 = 0
            r1.setPadding(r7, r14, r2, r14)
            com.huobi.view.roundview.RoundViewDelegate r2 = r1.getDelegate()
            r7 = 8
            r2.setCornerRadius(r7)
            com.huobi.view.roundview.RoundViewDelegate r2 = r1.getDelegate()
            android.content.res.Resources r7 = r5.getResources()
            r14 = 2131099915(0x7f06010b, float:1.7812197E38)
            int r7 = r7.getColor(r14)
            r2.setStrokeColor(r7)
            com.huobi.view.roundview.RoundViewDelegate r2 = r1.getDelegate()
            r2.setStrokeWidth(r11)
            android.widget.LinearLayout$LayoutParams r2 = new android.widget.LinearLayout$LayoutParams
            r2.<init>(r3, r4)
            r1.addView(r0, r2)
            r0 = r35
            r0.addView(r1)
            goto L_0x054f
        L_0x04d9:
            r0 = r35
            int r1 = r8.getShowTag()
            if (r1 != r6) goto L_0x051a
            com.hbg.module.community.view.VideoCoverImageView r1 = new com.hbg.module.community.view.VideoCoverImageView
            r18 = 0
            r19 = 0
            r20 = 6
            r21 = 0
            r16 = r1
            r17 = r5
            r16.<init>(r17, r18, r19, r20, r21)
            android.view.ViewGroup$LayoutParams r2 = new android.view.ViewGroup$LayoutParams
            int r3 = r9.f74261d
            int r4 = r9.f74262e
            r2.<init>(r3, r4)
            java.lang.String r3 = r8.getVideoImage()
            com.hbg.module.libkt.base.ext.b.B(r1, r3)
            r0.addView(r1, r2)
            rd.s r2 = rd.s.f23381a
            r18 = 800(0x320, double:3.953E-321)
            com.huobi.index.viewhandler.NewsCommunityHandler$b r2 = new com.huobi.index.viewhandler.NewsCommunityHandler$b
            r16 = r2
            r17 = r1
            r20 = r8
            r21 = r0
            r16.<init>(r17, r18, r20, r21)
            r1.setOnClickListener(r2)
            goto L_0x054f
        L_0x051a:
            int r1 = r8.getShowTag()
            r2 = 3
            if (r1 == r2) goto L_0x054f
            int r1 = r8.getShowTag()
            r2 = 4
            if (r1 != r2) goto L_0x054f
            java.util.ArrayList r1 = r8.getImgList()
            if (r1 == 0) goto L_0x054f
            java.util.ArrayList r1 = r8.getImgList()
            int r1 = r1.size()
            if (r1 <= 0) goto L_0x054f
            com.hbg.module.libkt.custom.DynamicPicCardView r1 = new com.hbg.module.libkt.custom.DynamicPicCardView
            r1.<init>(r5)
            java.util.ArrayList r2 = r8.getImgList()
            r1.setImageResList(r2)
            com.huobi.index.viewhandler.NewsCommunityHandler$n r2 = new com.huobi.index.viewhandler.NewsCommunityHandler$n
            r2.<init>(r9, r8, r5)
            r1.setImageClickListener(r2)
            r0.addView(r1)
        L_0x054f:
            int r1 = r0.getChildCount()
            if (r1 <= 0) goto L_0x055a
            r1 = 0
            r0.setVisibility(r1)
            goto L_0x055f
        L_0x055a:
            r1 = 8
            r0.setVisibility(r1)
        L_0x055f:
            int r0 = r8.getCommentNum()
            java.lang.String r0 = he.b.a(r0)
            r1 = r23
            r1.setText(r0)
            r14 = r52
            r7 = r27
            r9.A(r14, r7, r8)
            int r0 = r8.getShareNum()
            java.lang.String r0 = he.b.a(r0)
            r4 = r53
            r4.setText(r0)
            int r0 = r8.getIsSelf()
            if (r0 != 0) goto L_0x058f
            r2 = r55
            r0 = 0
            r2.setVisibility(r0)
            r1 = 8
            goto L_0x0597
        L_0x058f:
            r2 = r55
            r0 = 0
            r1 = 8
            r2.setVisibility(r1)
        L_0x0597:
            java.util.List r3 = r8.getHotCommentList()
            boolean r3 = com.hbg.module.libkt.base.ext.b.w(r3)
            if (r3 == 0) goto L_0x05b1
            r3 = r22
            r3.setVisibility(r1)
        L_0x05a6:
            r11 = r2
            r16 = r4
            r20 = r5
            r27 = r7
            r52 = r13
            goto L_0x0697
        L_0x05b1:
            r3 = r22
            r3.setVisibility(r0)
            r3.removeAllViews()
            java.util.List r0 = r8.getHotCommentList()
            java.util.Iterator r22 = r0.iterator()
        L_0x05c1:
            boolean r0 = r22.hasNext()
            if (r0 == 0) goto L_0x05a6
            java.lang.Object r0 = r22.next()
            com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo$HotComment r0 = (com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo.HotComment) r0
            android.text.SpannableStringBuilder r1 = new android.text.SpannableStringBuilder
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r11 = r0.hotComAuditor
            r6.append(r11)
            java.lang.String r11 = ": "
            r6.append(r11)
            java.lang.String r11 = r0.hotComment
            r6.append(r11)
            java.lang.String r6 = r6.toString()
            r1.<init>(r6)
            com.huobi.index.viewhandler.NewsCommunityHandler$o r6 = new com.huobi.index.viewhandler.NewsCommunityHandler$o
            r6.<init>(r0)
            java.lang.String r11 = r0.hotComAuditor
            int r11 = r11.length()
            r23 = 1
            int r11 = r11 + 1
            r55 = r2
            r2 = 17
            r27 = r3
            r3 = 0
            r1.setSpan(r6, r3, r11, r2)
            android.text.style.ForegroundColorSpan r6 = new android.text.style.ForegroundColorSpan
            r11 = 2130968751(0x7f0400af, float:1.7546164E38)
            int r11 = com.hbg.module.libkt.base.ext.b.o(r5, r11)
            r6.<init>(r11)
            java.lang.String r0 = r0.hotComAuditor
            int r0 = r0.length()
            int r0 = r0 + 1
            r1.setSpan(r6, r3, r0, r2)
            com.hbg.module.community.view.HotCommentView r6 = new com.hbg.module.community.view.HotCommentView
            r18 = 0
            r19 = 0
            r20 = 6
            r21 = 0
            r16 = r6
            r17 = r5
            r16.<init>(r17, r18, r19, r20, r21)
            r0 = 1097859072(0x41700000, float:15.0)
            r6.setTextSize(r0)
            r0 = 1101004800(0x41a00000, float:20.0)
            java.lang.Float r0 = java.lang.Float.valueOf(r0)
            int r0 = sd.a.b(r0)
            r6.setLineHeight(r0)
            r0 = 0
            r11 = 5
            r6.setPadding(r0, r0, r0, r11)
            r0 = 2130968752(0x7f0400b0, float:1.7546167E38)
            int r0 = com.hbg.module.libkt.base.ext.b.o(r5, r0)
            r6.setTextColor(r0)
            r2 = 2
            r6.setMaxLines(r2)
            android.text.TextUtils$TruncateAt r0 = android.text.TextUtils.TruncateAt.END
            r6.setEllipsize(r0)
            r6.setText(r1)
            android.text.method.LinkMovementMethod r0 = new android.text.method.LinkMovementMethod
            r0.<init>()
            r6.setMovementMethod(r0)
            rd.s r0 = rd.s.f23381a
            r16 = 800(0x320, double:3.953E-321)
            com.huobi.index.viewhandler.NewsCommunityHandler$c r3 = new com.huobi.index.viewhandler.NewsCommunityHandler$c
            r0 = r3
            r1 = r6
            r11 = r55
            r18 = r2
            r52 = r13
            r13 = r3
            r50 = r27
            r27 = r7
            r7 = r50
            r2 = r16
            r16 = r4
            r4 = r8
            r20 = r5
            r5 = r54
            r0.<init>(r1, r2, r4, r5)
            r6.setOnClickListener(r13)
            r7.addView(r6)
            r13 = r52
            r3 = r7
            r2 = r11
            r4 = r16
            r6 = r18
            r5 = r20
            r11 = r23
            r7 = r27
            goto L_0x05c1
        L_0x0697:
            com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo$ListBean$ParentDynamic r0 = r8.getParentDynamic()
            if (r0 == 0) goto L_0x06b8
            r0 = r37
            r1 = 0
            r0.setVisibility(r1)
            r2 = 8
            r11.setVisibility(r2)
            r13 = r24
            r13.setVisibility(r2)
            r7 = r25
            r7.setVisibility(r2)
            r6 = r26
            r6.setVisibility(r2)
            goto L_0x06e9
        L_0x06b8:
            r13 = r24
            r7 = r25
            r6 = r26
            r0 = r37
            r1 = 0
            r2 = 8
            int r3 = r8.getType()
            r4 = 4
            if (r3 != r4) goto L_0x06da
            r0.setVisibility(r1)
            r11.setVisibility(r1)
            r13.setVisibility(r1)
            r7.setVisibility(r1)
            r6.setVisibility(r1)
            goto L_0x06e9
        L_0x06da:
            r0.setVisibility(r2)
            r11.setVisibility(r1)
            r13.setVisibility(r1)
            r7.setVisibility(r1)
            r6.setVisibility(r1)
        L_0x06e9:
            rd.s r0 = rd.s.f23381a
            r2 = 800(0x320, double:3.953E-321)
            com.huobi.index.viewhandler.NewsCommunityHandler$d r5 = new com.huobi.index.viewhandler.NewsCommunityHandler$d
            r0 = r5
            r1 = r6
            r4 = r51
            r47 = r5
            r5 = r8
            r48 = r6
            r6 = r20
            r25 = r7
            r17 = r27
            r7 = r16
            r0.<init>(r1, r2, r4, r5, r6, r7)
            r1 = r47
            r0 = r48
            r0.setOnClickListener(r1)
            com.huobi.index.viewhandler.NewsCommunityHandler$e r6 = new com.huobi.index.viewhandler.NewsCommunityHandler$e
            r0 = r6
            r1 = r25
            r4 = r8
            r5 = r54
            r0.<init>(r1, r2, r4, r5)
            r0 = r25
            r0.setOnClickListener(r6)
            com.huobi.index.viewhandler.NewsCommunityHandler$f r7 = new com.huobi.index.viewhandler.NewsCommunityHandler$f
            r0 = r7
            r1 = r13
            r4 = r51
            r5 = r8
            r6 = r20
            r49 = r7
            r7 = r14
            r14 = r8
            r8 = r17
            r0.<init>(r1, r2, r4, r5, r6, r7, r8)
            r0 = r49
            r13.setOnClickListener(r0)
            com.huobi.index.viewhandler.NewsCommunityHandler$g r7 = new com.huobi.index.viewhandler.NewsCommunityHandler$g
            r0 = r7
            r1 = r11
            r5 = r14
            r0.<init>(r1, r2, r4, r5, r6)
            r11.setOnClickListener(r7)
            com.huobi.index.viewhandler.NewsCommunityHandler$h r7 = new com.huobi.index.viewhandler.NewsCommunityHandler$h
            r0 = r7
            r1 = r36
            r6 = r54
            r0.<init>(r1, r2, r4, r5, r6)
            r1.setOnClickListener(r7)
            com.huobi.index.viewhandler.NewsCommunityHandler$i r7 = new com.huobi.index.viewhandler.NewsCommunityHandler$i
            r0 = r7
            r1 = r12
            r0.<init>(r1, r2, r4, r5, r6)
            r12.setOnClickListener(r7)
            com.huobi.index.viewhandler.w r0 = new com.huobi.index.viewhandler.w
            r0.<init>(r9, r14, r10)
            r1 = 0
            r16 = 0
            r18 = 6
            r19 = 0
            r7 = r52
            r13 = r15
            r8 = r14
            r14 = r0
            r11 = r15
            r15 = r1
            gc.d.e(r13, r14, r15, r16, r18, r19)
            com.huobi.index.viewhandler.NewsCommunityHandler$j r13 = new com.huobi.index.viewhandler.NewsCommunityHandler$j
            r0 = r13
            r1 = r11
            r5 = r8
            r0.<init>(r1, r2, r4, r5, r6)
            r11.setOnClickListener(r13)
            com.huobi.index.viewhandler.NewsCommunityHandler$a r13 = new com.huobi.index.viewhandler.NewsCommunityHandler$a
            r0 = r13
            r1 = r7
            r0.<init>(r1, r2, r4, r5, r6)
            r7.setOnClickListener(r13)
            com.huobi.index.viewhandler.v r6 = new com.huobi.index.viewhandler.v
            r0 = r6
            r1 = r51
            r2 = r8
            r3 = r20
            r4 = r12
            r5 = r11
            r0.<init>(r1, r2, r3, r4, r5)
            r11.setOnLongClickListener(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.index.viewhandler.NewsCommunityHandler.handleView(v9.c, int, com.huobi.index.bean.HomeFeedInfoItem, android.view.ViewGroup):void");
    }

    public final void t(LinearLayout linearLayout, RichTextBean richTextBean, SpannableStringBuilder spannableStringBuilder) {
        EllipsizeTextView ellipsizeTextView;
        Context context = linearLayout.getContext();
        String str = richTextBean.type;
        if (str != null) {
            switch (str.hashCode()) {
                case -2143265644:
                    if (str.equals("mention-currency") && spannableStringBuilder != null) {
                        B(context, spannableStringBuilder, richTextBean, " $");
                        return;
                    }
                    return;
                case 100313435:
                    str.equals("image");
                    return;
                case 712568052:
                    if (str.equals("mention-follow") && spannableStringBuilder != null) {
                        B(context, spannableStringBuilder, richTextBean, " @");
                        return;
                    }
                    return;
                case 1949288814:
                    if (str.equals("paragraph")) {
                        if (this.f74263f == null) {
                            this.f74263f = new SpannableStringBuilder();
                            this.f74264g = new EllipsizeTextView(context, (AttributeSet) null, 0, 6, (kotlin.jvm.internal.r) null);
                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                            if (linearLayout.getChildCount() > 0) {
                                layoutParams.topMargin = sd.a.b(Float.valueOf(10.0f));
                            }
                            EllipsizeTextView ellipsizeTextView2 = this.f74264g;
                            if (ellipsizeTextView2 != null) {
                                ellipsizeTextView2.setMaxLines(4);
                            }
                            EllipsizeTextView ellipsizeTextView3 = this.f74264g;
                            if (ellipsizeTextView3 != null) {
                                ellipsizeTextView3.setEllipsize(TextUtils.TruncateAt.END);
                            }
                            EllipsizeTextView ellipsizeTextView4 = this.f74264g;
                            if (ellipsizeTextView4 != null) {
                                ellipsizeTextView4.setLayoutParams(layoutParams);
                            }
                            EllipsizeTextView ellipsizeTextView5 = this.f74264g;
                            if (ellipsizeTextView5 != null) {
                                ellipsizeTextView5.setTextColor(context.getResources().getColor(R.color.baseColorPrimaryText));
                            }
                            EllipsizeTextView ellipsizeTextView6 = this.f74264g;
                            if (ellipsizeTextView6 != null) {
                                ellipsizeTextView6.setTextSize(2, 16.0f);
                            }
                            if (Build.VERSION.SDK_INT >= 28 && (ellipsizeTextView = this.f74264g) != null) {
                                ellipsizeTextView.setLineHeight(sd.a.b(Float.valueOf(24.0f)));
                            }
                            EllipsizeTextView ellipsizeTextView7 = this.f74264g;
                            if (ellipsizeTextView7 != null) {
                                ellipsizeTextView7.setMovementMethod(new LinkMovementMethod());
                            }
                        }
                        if (!com.hbg.module.libkt.base.ext.b.w(richTextBean.children)) {
                            Iterator<RichTextBean> it2 = richTextBean.children.iterator();
                            while (it2.hasNext()) {
                                t(linearLayout, it2.next(), this.f74263f);
                            }
                            return;
                        }
                        return;
                    }
                    return;
                case 1963154312:
                    if (str.equals("mention-task") && spannableStringBuilder != null) {
                        richTextBean.character += n0.h.f32179b;
                        B(context, spannableStringBuilder, richTextBean, " #");
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

    public final void v(Context context, CommunityFeedInfo.ListBean listBean, FrameLayout frameLayout) {
        boolean z11;
        int i11;
        List<LiveSpeaker> list;
        LiveSpeaker liveSpeaker;
        Context context2 = context;
        CommunityFeedInfo.ListBean listBean2 = listBean;
        if (listBean2 != null && listBean.getShowTag() != 4) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.item_community_feed_share, (ViewGroup) null, false);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.ivShareAvatar);
            TextView textView = (TextView) inflate.findViewById(R.id.atvSource);
            TextView textView2 = (TextView) inflate.findViewById(R.id.atvShareTitle);
            TextView textView3 = (TextView) inflate.findViewById(R.id.atvShareContent);
            RoundedImageView roundedImageView = (RoundedImageView) inflate.findViewById(R.id.ivPic);
            textView.setText("");
            textView.setCompoundDrawables((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.llDefaultContent);
            LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.llEngineContent);
            linearLayout.setVisibility(0);
            linearLayout2.setVisibility(8);
            int shareType = listBean.getShareType();
            if (shareType == 1) {
                i11 = 6;
                z11 = true;
                if (listBean.getShareFromAvatar() != null) {
                    com.hbg.module.libkt.base.ext.b.J(imageView, listBean.getShareFromAvatar());
                }
                textView.setText(listBean.getShareFrom());
                rd.s sVar = rd.s.f23381a;
                textView.setOnClickListener(new p(textView, 800, this, listBean));
            } else if (shareType == 2) {
                i11 = 6;
                z11 = true;
                if (!com.hbg.module.libkt.base.ext.b.x(listBean.getShareFromAvatar())) {
                    com.hbg.module.libkt.base.ext.b.J(imageView, listBean.getShareFromAvatar());
                }
                textView.setText(listBean.getShareFrom());
                rd.s sVar2 = rd.s.f23381a;
                textView.setOnClickListener(new q(textView, 800, this, listBean));
            } else if (shareType == 4 || shareType == 6) {
                i11 = 6;
                z11 = true;
                if (listBean.getShareType() != 6 || com.hbg.module.libkt.base.ext.b.x(listBean2.extend)) {
                    com.hbg.module.libkt.base.ext.b.J(imageView, listBean.getShareFromAvatar());
                    rd.s sVar3 = rd.s.f23381a;
                    textView.setOnClickListener(new s(textView, 800, this, listBean));
                } else {
                    LiveDetailBean liveDetailBean = (LiveDetailBean) com.hbg.module.libkt.base.ext.f.e().fromJson(listBean2.extend, new NewsCommunityHandler$initShareContent$$inlined$gsonToBean$1().getType());
                    if (!com.hbg.module.libkt.base.ext.b.w(liveDetailBean != null ? liveDetailBean.speakerList : null)) {
                        com.hbg.module.libkt.base.ext.b.J(imageView, (liveDetailBean == null || (list = liveDetailBean.speakerList) == null || (liveSpeaker = list.get(0)) == null) ? null : liveSpeaker.avatar);
                        rd.s sVar4 = rd.s.f23381a;
                        textView.setOnClickListener(new r(textView, 800, this, listBean));
                    }
                }
                textView.setText(listBean.getShareFrom());
            } else if (shareType != 18) {
                if (shareType == 20) {
                    linearLayout.setVisibility(8);
                    linearLayout2.setVisibility(0);
                    linearLayout2.removeAllViews();
                    rj.b a11 = nc.a.f19345a.a();
                    if (listBean.getShowTag() == 5) {
                        linearLayout2.addView(a11.D("copytrading_trader_card.xml", context2));
                        a11.I("traderCard.initTraderCardItem('" + listBean2.extend + "')");
                    } else {
                        linearLayout2.addView(a11.D("copytrading_trader_share_card.xml", context2));
                        a11.I("traderShareCard.initTraderShareCardItem('" + listBean2.extend + "')");
                    }
                } else if (shareType == 21) {
                    linearLayout.setVisibility(8);
                    linearLayout2.setVisibility(0);
                    linearLayout2.removeAllViews();
                    rj.b a12 = nc.a.f19345a.a();
                    if (listBean.getShowTag() == 5) {
                        linearLayout2.addView(a12.D("copytrading_follower_card.xml", context2));
                        a12.I("followerCard.initFollowerCardItem('" + listBean2.extend + "')");
                    } else {
                        linearLayout2.addView(a12.D("copytrading_follower_share_card.xml", context2));
                        a12.I("followerShareCard.initFollowerShareCardItem('" + listBean2.extend + "')");
                    }
                }
                i11 = 6;
                z11 = true;
            } else {
                if (listBean.getShareFromAvatar() != null) {
                    com.hbg.module.libkt.base.ext.b.J(imageView, listBean.getShareFromAvatar());
                }
                textView.setText(listBean.getShareFrom());
                textView3.setTextColor(ResourcesCompat.d(context.getResources(), R.color.baseColorSecondaryText, (Resources.Theme) null));
                textView3.setTextSize(1, 12.0f);
                rd.s sVar5 = rd.s.f23381a;
                t tVar = r1;
                z11 = true;
                i11 = 6;
                t tVar2 = new t(textView, 800, this, listBean);
                textView.setOnClickListener(tVar);
            }
            if (!com.hbg.module.libkt.base.ext.b.x(listBean.getShareLinkTitle())) {
                if (listBean.getShareType() != i11 || com.hbg.module.libkt.base.ext.b.x(listBean2.extend)) {
                    textView2.setVisibility(8);
                    textView3.setText(listBean.getShareLinkTitle());
                } else {
                    LiveDetailBean liveDetailBean2 = (LiveDetailBean) com.hbg.module.libkt.base.ext.f.e().fromJson(listBean2.extend, new NewsCommunityHandler$initShareContent$$inlined$gsonToBean$2().getType());
                    textView2.setText(liveDetailBean2 != null ? liveDetailBean2.title : null);
                    textView3.setText(liveDetailBean2 != null ? liveDetailBean2.introduction : null);
                    textView2.setVisibility(0);
                }
            }
            String shareImage = listBean.getShareImage();
            if ((shareImage == null || shareImage.length() == 0) ? z11 : false) {
                roundedImageView.setVisibility(8);
            } else {
                com.hbg.module.libkt.base.ext.b.H(roundedImageView, listBean.getShareImage(), com.hbg.module.libkt.base.ext.b.p(context2, R.attr.ic_community_feed_placeholder), 0, 0, 0, 28, (Object) null);
                roundedImageView.setVisibility(0);
            }
            rd.s sVar6 = rd.s.f23381a;
            inflate.setOnClickListener(new u(inflate, 800, this, listBean));
            frameLayout.removeAllViews();
            frameLayout.addView(inflate);
        }
    }

    public final void w(TextView textView, ExpandableTextView expandableTextView, CommunityFeedInfo.ListBean listBean, boolean z11) {
        String title = listBean.getTitle();
        String content = listBean.getContent();
        listBean.setTitle(listBean.getOldTitle());
        listBean.setOldTitle(title);
        listBean.setContent(listBean.getOldContent());
        listBean.setOldContent(content);
        listBean.setTrans(z11);
        textView.setText(listBean.getTitle());
        expandableTextView.setContent((CharSequence) listBean.getContent(), (StatusType) null);
    }

    public final void y(CommunityFeedInfo.ListBean listBean, String str, Integer num) {
        Integer num2 = null;
        gs.g.g("app_recome_content_click", HomeSensorsHelper.e((long) (listBean != null ? listBean.getId() : 0), str, listBean != null ? listBean.getTitle() : null, "community", num != null ? num.intValue() : 1, (String) null, listBean != null ? listBean.getShareType() : 0, 4));
        Postcard a11 = b2.a.d().a("/content/DynamicDetail");
        if (listBean != null) {
            num2 = Integer.valueOf(listBean.getId());
        }
        a11.withString("dynamicId", String.valueOf(num2)).withBoolean("feedCommentClick", false).navigation();
    }

    public final void z(CommunityFeedInfo.ListBean listBean, LinearLayout linearLayout, String str, Integer num) {
        EllipsizeTextView ellipsizeTextView;
        List<RichTextBean> c11 = rd.d.f23353a.c(listBean != null ? listBean.getContentText() : null, RichTextBean.class);
        if (!com.hbg.module.libkt.base.ext.b.w(c11)) {
            linearLayout.removeAllViews();
            for (RichTextBean u11 : c11) {
                u(this, linearLayout, u11, (SpannableStringBuilder) null, 4, (Object) null);
            }
            SpannableStringBuilder spannableStringBuilder = this.f74263f;
            if (spannableStringBuilder != null && (ellipsizeTextView = this.f74264g) != null) {
                if (ellipsizeTextView != null) {
                    ellipsizeTextView.setText(spannableStringBuilder);
                }
                EllipsizeTextView ellipsizeTextView2 = this.f74264g;
                if (ellipsizeTextView2 != null) {
                    rd.s sVar = rd.s.f23381a;
                    ellipsizeTextView2.setOnClickListener(new v(ellipsizeTextView2, 800, listBean, str, num));
                }
                linearLayout.addView(this.f74264g);
                this.f74263f = null;
            }
        }
    }
}
