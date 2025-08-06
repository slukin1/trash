package com.huobi.index.viewhandler;

import android.animation.Animator;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.airbnb.lottie.LottieAnimationView;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.core.util.m0;
import com.hbg.lib.core.util.w;
import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import com.hbg.lib.network.hbg.core.bean.NewFlashInformation;
import com.hbg.lib.network.hbg.core.bean.NewFlashInformationShare;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.module.community.ui.DynamicDetailActivity;
import com.hbg.module.community.view.HotCommentView;
import com.hbg.module.huobi.im.utils.DateUtils;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import com.hbg.module.libkt.provider.HbgBaseProvider;
import com.huobi.index.bean.HomeFeedInfoItem;
import com.huobi.share.bean.PreviewItem;
import com.huobi.utils.HomeSensorsHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sumsub.sns.internal.fingerprint.infoproviders.l;
import i6.r;
import java.util.HashMap;
import kotlin.Unit;
import pro.huobi.R;
import rd.s;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public final class NewsFlashHandler implements s9.c {

    /* renamed from: b  reason: collision with root package name */
    public HbgBaseProvider f74363b = ((HbgBaseProvider) b2.a.d().a("/provider/content").navigation());

    public static final class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f74364b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f74365c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ NewsFlashHandler f74366d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TextView f74367e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ HomeFeedInfoItem f74368f;

        public a(View view, long j11, NewsFlashHandler newsFlashHandler, TextView textView, HomeFeedInfoItem homeFeedInfoItem) {
            this.f74364b = view;
            this.f74365c = j11;
            this.f74366d = newsFlashHandler;
            this.f74367e = textView;
            this.f74368f = homeFeedInfoItem;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f74364b) > this.f74365c || (this.f74364b instanceof Checkable)) {
                sVar.e(this.f74364b, currentTimeMillis);
                ConstraintLayout constraintLayout = (ConstraintLayout) this.f74364b;
                this.f74366d.j(this.f74367e, this.f74368f);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f74369b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f74370c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ NewsFlashHandler f74371d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NewFlashInformation f74372e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ HomeFeedInfoItem f74373f;

        public b(View view, long j11, NewsFlashHandler newsFlashHandler, NewFlashInformation newFlashInformation, HomeFeedInfoItem homeFeedInfoItem) {
            this.f74369b = view;
            this.f74370c = j11;
            this.f74371d = newsFlashHandler;
            this.f74372e = newFlashInformation;
            this.f74373f = homeFeedInfoItem;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f74369b) > this.f74370c || (this.f74369b instanceof Checkable)) {
                sVar.e(this.f74369b, currentTimeMillis);
                NewsFlashHandler.l(this.f74371d, this.f74369b.getContext(), this.f74372e, false, 4, (Object) null);
                gs.g.g("app_recome_content_click", HomeSensorsHelper.d(this.f74372e.getId(), this.f74373f.f73152c, this.f74372e.getTitle(), "huobiNews", this.f74373f.f73165p, (String) null, 1));
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f74374b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f74375c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ NewFlashInformation f74376d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HomeFeedInfoItem f74377e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ NewsFlashHandler f74378f;

        public c(View view, long j11, NewFlashInformation newFlashInformation, HomeFeedInfoItem homeFeedInfoItem, NewsFlashHandler newsFlashHandler) {
            this.f74374b = view;
            this.f74375c = j11;
            this.f74376d = newFlashInformation;
            this.f74377e = homeFeedInfoItem;
            this.f74378f = newsFlashHandler;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f74374b) > this.f74375c || (this.f74374b instanceof Checkable)) {
                sVar.e(this.f74374b, currentTimeMillis);
                gs.g.i("app_comment_click", HomeSensorsHelper.d(this.f74376d.getId(), this.f74377e.f73152c, this.f74376d.getTitle(), "huobiNews", this.f74377e.f73165p, (String) null, 1));
                this.f74378f.k(((ConstraintLayout) this.f74374b).getContext(), this.f74376d, true);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class d implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f74379b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f74380c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ NewFlashInformation f74381d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HomeFeedInfoItem f74382e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ NewsFlashHandler f74383f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ImageView f74384g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ TextView f74385h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ ImageView f74386i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ TextView f74387j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ LottieAnimationView f74388k;

        /* renamed from: l  reason: collision with root package name */
        public final /* synthetic */ LottieAnimationView f74389l;

        public d(View view, long j11, NewFlashInformation newFlashInformation, HomeFeedInfoItem homeFeedInfoItem, NewsFlashHandler newsFlashHandler, ImageView imageView, TextView textView, ImageView imageView2, TextView textView2, LottieAnimationView lottieAnimationView, LottieAnimationView lottieAnimationView2) {
            this.f74379b = view;
            this.f74380c = j11;
            this.f74381d = newFlashInformation;
            this.f74382e = homeFeedInfoItem;
            this.f74383f = newsFlashHandler;
            this.f74384g = imageView;
            this.f74385h = textView;
            this.f74386i = imageView2;
            this.f74387j = textView2;
            this.f74388k = lottieAnimationView;
            this.f74389l = lottieAnimationView2;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f74379b) > this.f74380c || (this.f74379b instanceof Checkable)) {
                sVar.e(this.f74379b, currentTimeMillis);
                gs.g.i("app_bullish_click", HomeSensorsHelper.d(this.f74381d.getId(), this.f74382e.f73152c, this.f74381d.getTitle(), "huobiNews", this.f74382e.f73165p, (String) null, 1));
                this.f74383f.m(this.f74381d, (ConstraintLayout) this.f74379b, Long.valueOf(this.f74381d.getId()), 1, new NewsFlashHandler$handleView$4$1(this.f74383f, this.f74384g, this.f74385h, this.f74386i, this.f74387j, this.f74388k, this.f74389l));
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class e implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f74390b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f74391c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ NewFlashInformation f74392d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HomeFeedInfoItem f74393e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ NewsFlashHandler f74394f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ImageView f74395g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ TextView f74396h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ ImageView f74397i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ TextView f74398j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ LottieAnimationView f74399k;

        /* renamed from: l  reason: collision with root package name */
        public final /* synthetic */ LottieAnimationView f74400l;

        public e(View view, long j11, NewFlashInformation newFlashInformation, HomeFeedInfoItem homeFeedInfoItem, NewsFlashHandler newsFlashHandler, ImageView imageView, TextView textView, ImageView imageView2, TextView textView2, LottieAnimationView lottieAnimationView, LottieAnimationView lottieAnimationView2) {
            this.f74390b = view;
            this.f74391c = j11;
            this.f74392d = newFlashInformation;
            this.f74393e = homeFeedInfoItem;
            this.f74394f = newsFlashHandler;
            this.f74395g = imageView;
            this.f74396h = textView;
            this.f74397i = imageView2;
            this.f74398j = textView2;
            this.f74399k = lottieAnimationView;
            this.f74400l = lottieAnimationView2;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f74390b) > this.f74391c || (this.f74390b instanceof Checkable)) {
                sVar.e(this.f74390b, currentTimeMillis);
                gs.g.i("app_bearish_click", HomeSensorsHelper.d(this.f74392d.getId(), this.f74393e.f73152c, this.f74392d.getTitle(), "huobiNews", this.f74393e.f73165p, (String) null, 1));
                this.f74394f.m(this.f74392d, (ConstraintLayout) this.f74390b, Long.valueOf(this.f74392d.getId()), 2, new NewsFlashHandler$handleView$5$1(this.f74394f, this.f74395g, this.f74396h, this.f74397i, this.f74398j, this.f74399k, this.f74400l));
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class f implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f74401b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f74402c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ NewFlashInformation f74403d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HomeFeedInfoItem f74404e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ NewsFlashHandler f74405f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f74406g;

        public f(View view, long j11, NewFlashInformation newFlashInformation, HomeFeedInfoItem homeFeedInfoItem, NewsFlashHandler newsFlashHandler, Context context) {
            this.f74401b = view;
            this.f74402c = j11;
            this.f74403d = newFlashInformation;
            this.f74404e = homeFeedInfoItem;
            this.f74405f = newsFlashHandler;
            this.f74406g = context;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f74401b) > this.f74402c || (this.f74401b instanceof Checkable)) {
                sVar.e(this.f74401b, currentTimeMillis);
                HotCommentView hotCommentView = (HotCommentView) this.f74401b;
                gs.g.i("app_comment_click", HomeSensorsHelper.d(this.f74403d.getId(), this.f74404e.f73152c, this.f74403d.getTitle(), "huobiNews", this.f74404e.f73165p, (String) null, 1));
                this.f74405f.k(this.f74406g, this.f74403d, true);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class g extends ClickableSpan {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CommunityFeedInfo.HotComment f74407b;

        public g(CommunityFeedInfo.HotComment hotComment) {
            this.f74407b = hotComment;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            b2.a.d().a("/content/PersonalCenter").withString("uidUnique", this.f74407b.hotComUid).navigation();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
        }
    }

    public static final class h implements Animator.AnimatorListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ImageView f74408b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ LottieAnimationView f74409c;

        public h(ImageView imageView, LottieAnimationView lottieAnimationView) {
            this.f74408b = imageView;
            this.f74409c = lottieAnimationView;
        }

        public void onAnimationCancel(Animator animator) {
            this.f74409c.setVisibility(8);
            this.f74408b.setVisibility(0);
        }

        public void onAnimationEnd(Animator animator) {
            this.f74409c.setVisibility(8);
            this.f74408b.setVisibility(0);
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
            this.f74408b.setVisibility(4);
            this.f74409c.setVisibility(0);
        }
    }

    public static final class i implements Animator.AnimatorListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ImageView f74410b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ LottieAnimationView f74411c;

        public i(ImageView imageView, LottieAnimationView lottieAnimationView) {
            this.f74410b = imageView;
            this.f74411c = lottieAnimationView;
        }

        public void onAnimationCancel(Animator animator) {
            this.f74411c.setVisibility(8);
            this.f74410b.setVisibility(0);
        }

        public void onAnimationEnd(Animator animator) {
            this.f74411c.setVisibility(8);
            this.f74410b.setVisibility(0);
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
            this.f74410b.setVisibility(4);
            this.f74411c.setVisibility(0);
        }
    }

    public static final class j extends BaseSubscriber<NewFlashInformationShare> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TextView f74412b;

        public j(TextView textView) {
            this.f74412b = textView;
        }

        /* renamed from: a */
        public void onNext(NewFlashInformationShare newFlashInformationShare) {
            super.onNext(newFlashInformationShare);
            this.f74412b.setText(String.valueOf(newFlashInformationShare.getShared()));
        }
    }

    public static /* synthetic */ void l(NewsFlashHandler newsFlashHandler, Context context, NewFlashInformation newFlashInformation, boolean z11, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            z11 = false;
        }
        newsFlashHandler.k(context, newFlashInformation, z11);
    }

    /* renamed from: g */
    public void handleView(v9.c cVar, int i11, HomeFeedInfoItem homeFeedInfoItem, ViewGroup viewGroup) {
        TextView textView;
        NewFlashInformation newFlashInformation;
        r e11 = cVar.e();
        TextView textView2 = (TextView) e11.b(R.id.tvTitle);
        TextView textView3 = (TextView) e11.b(R.id.tvDsc);
        TextView textView4 = (TextView) e11.b(R.id.tvDate);
        TextView textView5 = (TextView) e11.b(R.id.tvComment);
        TextView textView6 = (TextView) e11.b(R.id.tvRead);
        View b11 = e11.b(R.id.line);
        ConstraintLayout constraintLayout = (ConstraintLayout) e11.b(R.id.consShare);
        TextView textView7 = (TextView) e11.b(R.id.tvShare);
        ConstraintLayout constraintLayout2 = (ConstraintLayout) e11.b(R.id.consComment);
        LinearLayout linearLayout = (LinearLayout) e11.b(R.id.llHotComment);
        ConstraintLayout constraintLayout3 = (ConstraintLayout) e11.b(R.id.consRise);
        ImageView imageView = (ImageView) e11.b(R.id.imageRise);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) e11.b(R.id.lottieRise);
        TextView textView8 = (TextView) e11.b(R.id.tvRise);
        ImageView imageView2 = (ImageView) e11.b(R.id.imagePut);
        LottieAnimationView lottieAnimationView2 = (LottieAnimationView) e11.b(R.id.lottiePut);
        TextView textView9 = (TextView) e11.b(R.id.tvPut);
        ConstraintLayout constraintLayout4 = (ConstraintLayout) e11.b(R.id.consPut);
        NewFlashInformation newFlashInformation2 = homeFeedInfoItem.f73151b;
        if (newFlashInformation2 != null) {
            TextView textView10 = textView8;
            Context context = textView2.getContext();
            String str = "";
            textView2.setText(TextUtils.isEmpty(newFlashInformation2.getTitle()) ? str : newFlashInformation2.getTitle());
            textView3.setText(TextUtils.isEmpty(newFlashInformation2.getContent()) ? str : newFlashInformation2.getContent());
            if (newFlashInformation2.getIssueTime() > 0) {
                textView = textView9;
                str = DateUtils.e(textView4.getContext(), newFlashInformation2.getIssueTime());
            } else {
                textView = textView9;
            }
            textView4.setText(str);
            if (newFlashInformation2.getVisit() <= 0) {
                textView6.setVisibility(8);
            }
            if (newFlashInformation2.getVisit() <= 0) {
                b11.setVisibility(8);
            }
            he.b.k(textView5, String.valueOf(newFlashInformation2.getComments()), context.getResources().getString(R.string.n_content_comment));
            he.b.k(textView7, String.valueOf(newFlashInformation2.getShared()), context.getResources().getString(R.string.n_share_sys_share));
            s sVar = s.f23381a;
            TextView textView11 = textView;
            ConstraintLayout constraintLayout5 = constraintLayout4;
            TextView textView12 = textView10;
            NewFlashInformation newFlashInformation3 = newFlashInformation2;
            Context context2 = context;
            ConstraintLayout constraintLayout6 = constraintLayout3;
            LinearLayout linearLayout2 = linearLayout;
            constraintLayout.setOnClickListener(new a(constraintLayout, 800, this, textView7, homeFeedInfoItem));
            View b12 = e11.b(R.id.item_root);
            b12.setOnClickListener(new b(b12, 800, this, newFlashInformation3, homeFeedInfoItem));
            constraintLayout2.setOnClickListener(new c(constraintLayout2, 800, newFlashInformation3, homeFeedInfoItem, this));
            textView12.setText(String.valueOf(newFlashInformation3.getBullVote()));
            textView11.setText(String.valueOf(newFlashInformation3.getBadVote()));
            he.b.k(textView12, String.valueOf(newFlashInformation3.getBullVote()), context2.getResources().getString(R.string.n_home_news_fresh_rise));
            he.b.k(textView11, String.valueOf(newFlashInformation3.getBadVote()), context2.getResources().getString(R.string.n_home_news_fresh_lower));
            if (newFlashInformation3.getBullVote() == 0 && newFlashInformation3.getBadVote() == 0) {
                newFlashInformation = newFlashInformation3;
                newFlashInformation.setVotedType(0);
            } else {
                newFlashInformation = newFlashInformation3;
            }
            h(newFlashInformation.getVotedType(), imageView, textView12, imageView2, textView11);
            NewFlashInformation newFlashInformation4 = newFlashInformation;
            HomeFeedInfoItem homeFeedInfoItem2 = homeFeedInfoItem;
            ImageView imageView3 = imageView;
            TextView textView13 = textView12;
            ImageView imageView4 = imageView2;
            TextView textView14 = textView11;
            LottieAnimationView lottieAnimationView3 = lottieAnimationView;
            LottieAnimationView lottieAnimationView4 = lottieAnimationView2;
            constraintLayout6.setOnClickListener(new d(constraintLayout6, 800, newFlashInformation4, homeFeedInfoItem2, this, imageView3, textView13, imageView4, textView14, lottieAnimationView3, lottieAnimationView4));
            constraintLayout5.setOnClickListener(new e(constraintLayout5, 800, newFlashInformation4, homeFeedInfoItem2, this, imageView3, textView13, imageView4, textView14, lottieAnimationView3, lottieAnimationView4));
            if (com.hbg.module.libkt.base.ext.b.w(newFlashInformation.getHotCommentList())) {
                linearLayout2.setVisibility(8);
                return;
            }
            linearLayout2.setVisibility(0);
            linearLayout2.removeAllViews();
            for (CommunityFeedInfo.HotComment next : newFlashInformation.getHotCommentList()) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(next.hotComAuditor + l.f34627b + next.hotComment);
                spannableStringBuilder.setSpan(new g(next), 0, next.hotComAuditor.length() + 1, 17);
                Context context3 = context2;
                spannableStringBuilder.setSpan(new ForegroundColorSpan(com.hbg.module.libkt.base.ext.b.o(context3, R.attr.base_color_primary_text)), 0, next.hotComAuditor.length() + 1, 17);
                HotCommentView hotCommentView = new HotCommentView(context3, (AttributeSet) null, 0, 6, (kotlin.jvm.internal.r) null);
                hotCommentView.setTextSize(15.0f);
                hotCommentView.setLineHeight(com.hbg.module.libkt.base.ext.c.d(Float.valueOf(20.0f)));
                hotCommentView.setPadding(0, 0, 0, 5);
                hotCommentView.setTextColor(com.hbg.module.libkt.base.ext.b.o(context3, R.attr.base_color_secondary_textNew));
                hotCommentView.setMaxLines(2);
                hotCommentView.setEllipsize(TextUtils.TruncateAt.END);
                hotCommentView.setText(spannableStringBuilder);
                hotCommentView.setMovementMethod(new LinkMovementMethod());
                s sVar2 = s.f23381a;
                hotCommentView.setOnClickListener(new f(hotCommentView, 800, newFlashInformation, homeFeedInfoItem, this, context3));
                linearLayout2.addView(hotCommentView);
            }
        }
    }

    public int getResId() {
        return R.layout.item_home_news_flash;
    }

    public final void h(int i11, ImageView imageView, TextView textView, ImageView imageView2, TextView textView2) {
        if (i11 != 1) {
            imageView.setImageDrawable(com.hbg.module.libkt.base.ext.b.p(imageView.getContext(), R.attr.information_up_normal));
            textView.setTextColor(com.hbg.module.libkt.base.ext.b.o(imageView.getContext(), R.attr.base_color_secondary_textNew));
        } else if (w.l()) {
            imageView.setImageDrawable(com.hbg.module.libkt.base.ext.b.p(imageView.getContext(), R.attr.information_up_red));
            textView.setTextColor(imageView.getContext().getResources().getColor(R.color.color_rise_fall_red));
        } else {
            imageView.setImageDrawable(com.hbg.module.libkt.base.ext.b.p(imageView.getContext(), R.attr.information_up_green));
            textView.setTextColor(imageView.getContext().getResources().getColor(R.color.color_rise_fall_green));
        }
        if (i11 != 2) {
            imageView2.setImageDrawable(com.hbg.module.libkt.base.ext.b.p(imageView2.getContext(), R.attr.information_down_normal));
            textView2.setTextColor(com.hbg.module.libkt.base.ext.b.o(imageView2.getContext(), R.attr.base_color_secondary_textNew));
        } else if (w.l()) {
            imageView2.setImageDrawable(com.hbg.module.libkt.base.ext.b.p(imageView2.getContext(), R.attr.information_down_green));
            textView2.setTextColor(imageView2.getContext().getResources().getColor(R.color.color_rise_fall_green));
        } else {
            imageView2.setImageDrawable(com.hbg.module.libkt.base.ext.b.p(imageView2.getContext(), R.attr.information_down_red));
            textView2.setTextColor(imageView2.getContext().getResources().getColor(R.color.color_rise_fall_red));
        }
    }

    public final void i(int i11, ImageView imageView, LottieAnimationView lottieAnimationView, ImageView imageView2, LottieAnimationView lottieAnimationView2) {
        if (i11 == 1) {
            lottieAnimationView.setVisibility(0);
            lottieAnimationView.removeAllAnimatorListeners();
            lottieAnimationView.cancelAnimation();
            if (w.l()) {
                if (NightHelper.e().g()) {
                    lottieAnimationView.setAnimation((int) R.raw.newflash_red_rise_night);
                } else {
                    lottieAnimationView.setAnimation((int) R.raw.newflash_red_rise_day);
                }
            } else if (NightHelper.e().g()) {
                lottieAnimationView.setAnimation((int) R.raw.newflash_green_rise_night);
            } else {
                lottieAnimationView.setAnimation((int) R.raw.newflash_green_rise_day);
            }
            lottieAnimationView.addAnimatorListener(new h(imageView, lottieAnimationView));
            lottieAnimationView.playAnimation();
        } else if (i11 == 2) {
            lottieAnimationView2.setVisibility(0);
            lottieAnimationView2.removeAllAnimatorListeners();
            lottieAnimationView2.cancelAnimation();
            if (w.l()) {
                if (NightHelper.e().g()) {
                    lottieAnimationView2.setAnimation((int) R.raw.newflash_green_fall_night);
                } else {
                    lottieAnimationView2.setAnimation((int) R.raw.newflash_green_fall_day);
                }
            } else if (NightHelper.e().g()) {
                lottieAnimationView2.setAnimation((int) R.raw.newflash_red_fall_night);
            } else {
                lottieAnimationView2.setAnimation((int) R.raw.newflash_red_fall_day);
            }
            lottieAnimationView2.addAnimatorListener(new i(imageView2, lottieAnimationView2));
            lottieAnimationView2.playAnimation();
        }
    }

    public final void j(TextView textView, HomeFeedInfoItem homeFeedInfoItem) {
        String str = null;
        if ((homeFeedInfoItem != null ? homeFeedInfoItem.f73151b : null) != null) {
            NewFlashInformation newFlashInformation = homeFeedInfoItem.f73151b;
            gs.g.i("app_share_click", HomeSensorsHelper.d(newFlashInformation.getId(), homeFeedInfoItem.f73152c, newFlashInformation.getTitle(), "huobiNews", homeFeedInfoItem.f73165p, (String) null, 1));
            try {
                if (!com.hbg.module.libkt.base.ext.b.w(newFlashInformation.getImages())) {
                    str = newFlashInformation.getImages().get(0).getImage();
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            PreviewItem previewItem = new PreviewItem();
            if (newFlashInformation.getTitle() != null) {
                previewItem.title = newFlashInformation.getTitle();
            }
            if (newFlashInformation.getContent() != null) {
                previewItem.content = newFlashInformation.getContent();
            }
            previewItem.issueTime = newFlashInformation.getIssueTime();
            previewItem.raiseNumber = newFlashInformation.getBullVote();
            previewItem.downNumber = newFlashInformation.getBadVote();
            if (str != null) {
                previewItem.shareImg = str;
            }
            previewItem.f80866id = newFlashInformation.getId();
            yl.a.i((FragmentActivity) textView.getContext(), previewItem);
            newFlashInformation.setShared(newFlashInformation.getShared() + 1);
            v7.b.a().S0(newFlashInformation.getId(), m0.a()).b().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new j(textView));
        }
    }

    public final void k(Context context, NewFlashInformation newFlashInformation, boolean z11) {
        DynamicDetailActivity.a.d(DynamicDetailActivity.H, newFlashInformation.getDynamicId(), newFlashInformation.getId(), context, z11, false, 16, (Object) null);
    }

    public final void m(NewFlashInformation newFlashInformation, View view, Long l11, int i11, d10.l<? super NewFlashInformation, Unit> lVar) {
        HbgBaseProvider hbgBaseProvider = this.f74363b;
        boolean z11 = false;
        if (hbgBaseProvider != null && hbgBaseProvider.j(view.getContext())) {
            z11 = true;
        }
        if (z11 && l11 != null) {
            l11.longValue();
            nc.c.b(i11 == 1 ? "MT_TCP_bullish_hits" : "MT_TCP_Bearish_hits", (HashMap) null, 2, (Object) null);
            RequestExtKt.d(v7.b.a().R0(l11.longValue(), i11), new NewsFlashHandler$vote$1$1(newFlashInformation, lVar), NewsFlashHandler$vote$1$2.INSTANCE, (MutableLiveData) null, 4, (Object) null);
        }
    }
}
