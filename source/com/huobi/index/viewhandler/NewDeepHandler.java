package com.huobi.index.viewhandler;

import android.app.Activity;
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
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.util.SaveImageUtils;
import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import com.hbg.lib.widgets.o0;
import com.hbg.lib.widgets.photoviewer.PhotoViewerUtils;
import com.hbg.lib.widgets.photoviewer.data.ImageData;
import com.hbg.module.community.ui.DynamicDetailActivity;
import com.hbg.module.community.view.HotCommentView;
import com.hbg.module.content.utls.o;
import com.hbg.module.huobi.im.utils.DateUtils;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import com.hbg.module.libkt.provider.HbgBaseProvider;
import com.huobi.index.bean.HomeFeedInfoItem;
import com.huobi.index.bean.IndexDeep;
import com.huobi.sharev2.manager.ShareManager;
import com.huobi.utils.HomeHelper;
import com.huobi.utils.HomeSensorsHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d10.l;
import gs.g;
import i6.r;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import pro.huobi.R;
import rd.s;

public final class NewDeepHandler implements s9.c {

    /* renamed from: b  reason: collision with root package name */
    public HbgBaseProvider f74230b = ((HbgBaseProvider) b2.a.d().a("/provider/content").navigation());

    public static final class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f74231b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f74232c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Context f74233d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ IndexDeep f74234e;

        public a(View view, long j11, Context context, IndexDeep indexDeep) {
            this.f74231b = view;
            this.f74232c = j11;
            this.f74233d = context;
            this.f74234e = indexDeep;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f74231b) > this.f74232c || (this.f74231b instanceof Checkable)) {
                sVar.e(this.f74231b, currentTimeMillis);
                ImageView imageView = (ImageView) this.f74231b;
                o oVar = o.f18923a;
                FragmentActivity fragmentActivity = (FragmentActivity) this.f74233d;
                NewDeepHandler$handleView$2$1 newDeepHandler$handleView$2$1 = new NewDeepHandler$handleView$2$1(this.f74234e, this.f74233d);
                boolean z11 = true;
                if (BaseModuleConfig.a().s() != 1) {
                    z11 = false;
                }
                o.f(oVar, fragmentActivity, imageView, newDeepHandler$handleView$2$1, false, z11, true, false, 72, (Object) null);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f74235b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f74236c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ IndexDeep f74237d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HomeFeedInfoItem f74238e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f74239f;

        public b(View view, long j11, IndexDeep indexDeep, HomeFeedInfoItem homeFeedInfoItem, Context context) {
            this.f74235b = view;
            this.f74236c = j11;
            this.f74237d = indexDeep;
            this.f74238e = homeFeedInfoItem;
            this.f74239f = context;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f74235b) > this.f74236c || (this.f74235b instanceof Checkable)) {
                sVar.e(this.f74235b, currentTimeMillis);
                HotCommentView hotCommentView = (HotCommentView) this.f74235b;
                try {
                    g.g("app_recome_content_click", HomeSensorsHelper.d(this.f74237d.getId(), this.f74238e.f73152c, this.f74237d.getTitle(), "article", this.f74238e.f73165p, (String) null, 2));
                    DynamicDetailActivity.a.b(DynamicDetailActivity.H, this.f74237d.getDynamicId(), this.f74237d.getId(), this.f74239f, false, 8, (Object) null);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class c extends ClickableSpan {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CommunityFeedInfo.HotComment f74240b;

        public c(CommunityFeedInfo.HotComment hotComment) {
            this.f74240b = hotComment;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            b2.a.d().a("/content/PersonalCenter").withString("uidUnique", this.f74240b.hotComUid).navigation();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
        }
    }

    public static final class d implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f74241b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f74242c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ NewDeepHandler f74243d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ IndexDeep f74244e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TextView f74245f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ImageView f74246g;

        public d(View view, long j11, NewDeepHandler newDeepHandler, IndexDeep indexDeep, TextView textView, ImageView imageView) {
            this.f74241b = view;
            this.f74242c = j11;
            this.f74243d = newDeepHandler;
            this.f74244e = indexDeep;
            this.f74245f = textView;
            this.f74246g = imageView;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f74241b) > this.f74242c || (this.f74241b instanceof Checkable)) {
                sVar.e(this.f74241b, currentTimeMillis);
                LinearLayout linearLayout = (LinearLayout) this.f74241b;
                HbgBaseProvider e11 = this.f74243d.f74230b;
                if ((e11 != null ? Boolean.valueOf(e11.j((Activity) linearLayout.getContext())) : null).booleanValue()) {
                    RequestExtKt.d(v7.b.a().D0(String.valueOf(this.f74244e.getId()), 3), new NewDeepHandler$handleView$1$3$1(this.f74244e, this.f74243d, this.f74245f, this.f74246g), NewDeepHandler$handleView$1$3$2.INSTANCE, (MutableLiveData) null, 4, (Object) null);
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class e implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f74247b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f74248c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ IndexDeep f74249d;

        public e(View view, long j11, IndexDeep indexDeep) {
            this.f74247b = view;
            this.f74248c = j11;
            this.f74249d = indexDeep;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f74247b) > this.f74248c || (this.f74247b instanceof Checkable)) {
                sVar.e(this.f74247b, currentTimeMillis);
                RelativeLayout relativeLayout = (RelativeLayout) this.f74247b;
                BaseModuleConfig.a a11 = BaseModuleConfig.a();
                ShareManager.getInstance().newShareWithShareUrl(a11.k("views/feed/details/news-detail-long/" + this.f74249d.getId()), this.f74249d.getTitle(), "homeFeed", true, new NewDeepHandler$handleView$1$4$1(this.f74249d));
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class f implements View.OnLongClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f74250b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f74251c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ IndexDeep f74252d;

        public f(View view, long j11, IndexDeep indexDeep) {
            this.f74250b = view;
            this.f74251c = j11;
            this.f74252d = indexDeep;
        }

        public final boolean onLongClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f74250b) <= this.f74251c && !(this.f74250b instanceof Checkable)) {
                return true;
            }
            sVar.e(this.f74250b, currentTimeMillis);
            SaveImageUtils.h(((RelativeLayout) this.f74250b).getContext(), this.f74252d.getImgUrl());
            return true;
        }
    }

    @SensorsDataInstrumented
    public static final void h(IndexDeep indexDeep, View view) {
        ArrayList arrayList = new ArrayList();
        String imgUrl = indexDeep.getImgUrl();
        String str = "";
        if (imgUrl == null) {
            imgUrl = str;
        }
        String imgUrl2 = indexDeep.getImgUrl();
        if (imgUrl2 != null) {
            str = imgUrl2;
        }
        arrayList.add(new ImageData(imgUrl, str));
        PhotoViewerUtils.a((FragmentActivity) view.getContext(), arrayList, 0);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static final void i(IndexDeep indexDeep, Context context, View view) {
        DynamicDetailActivity.a.b(DynamicDetailActivity.H, indexDeep.getDynamicId(), indexDeep.getId(), context, false, 8, (Object) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static final void j(l lVar, Object obj) {
        lVar.invoke(obj);
    }

    /* renamed from: g */
    public void handleView(v9.c cVar, int i11, HomeFeedInfoItem homeFeedInfoItem, ViewGroup viewGroup) {
        LinearLayout linearLayout;
        ImageView imageView;
        HomeFeedInfoItem homeFeedInfoItem2 = homeFeedInfoItem;
        r e11 = cVar.e();
        if (homeFeedInfoItem2 != null) {
            IndexDeep indexDeep = homeFeedInfoItem2.f73157h;
            Context context = cVar.itemView.getContext();
            View b11 = e11.b(R.id.line);
            RelativeLayout relativeLayout = (RelativeLayout) e11.b(R.id.rlShare);
            LinearLayout linearLayout2 = (LinearLayout) e11.b(R.id.tvAgreeLayout);
            ImageView imageView2 = (ImageView) e11.b(R.id.ivLike);
            TextView textView = (TextView) e11.b(R.id.tvAgree);
            TextView textView2 = (TextView) e11.b(R.id.tvComment);
            TextView textView3 = (TextView) e11.b(R.id.tvDsc);
            LinearLayout linearLayout3 = (LinearLayout) e11.b(R.id.llComment);
            TextView textView4 = (TextView) e11.b(R.id.tvIndex);
            RelativeLayout relativeLayout2 = (RelativeLayout) e11.b(R.id.imageLayout);
            LinearLayout linearLayout4 = (LinearLayout) e11.b(R.id.llHotComment);
            ImageView imageView3 = (ImageView) e11.b(R.id.imageMore);
            if (indexDeep != null) {
                ((TextView) e11.b(R.id.tvTitle)).setText(indexDeep.getTitle());
                ((TextView) e11.b(R.id.tvSource)).setText(indexDeep.getSource());
                LinearLayout linearLayout5 = linearLayout4;
                ((TextView) e11.b(R.id.tvTime)).setText(indexDeep.getIssueTime() > 0 ? DateUtils.e(context, indexDeep.getIssueTime()) : "");
                TextView textView5 = (TextView) e11.b(R.id.tvRead);
                o0.b(textView5.getContext(), indexDeep.getImgUrl(), (ImageView) e11.b(R.id.ivImage), 8.0f, textView5.getContext().getResources().getColor(R.color.baseColorPrimarySeparator), 0.5f);
                textView4.setVisibility(8);
                String imgUrl = indexDeep.getImgUrl();
                if (imgUrl == null || imgUrl.length() == 0) {
                    relativeLayout2.setVisibility(8);
                } else {
                    relativeLayout2.setVisibility(0);
                }
                relativeLayout2.setOnClickListener(new q(indexDeep));
                s sVar = s.f23381a;
                relativeLayout2.setOnLongClickListener(new f(relativeLayout2, 800, indexDeep));
                if (indexDeep.getCommentNum() > 0) {
                    textView2.setText(HomeHelper.f(indexDeep.getCommentNum()));
                } else {
                    textView2.setText(context.getResources().getString(R.string.n_content_comment));
                }
                if (indexDeep.getVisit() <= 0) {
                    textView5.setVisibility(8);
                    b11.setVisibility(8);
                }
                k(textView, imageView2, indexDeep);
                imageView = imageView3;
                r rVar = e11;
                d dVar = r8;
                linearLayout = linearLayout5;
                d dVar2 = new d(linearLayout2, 800, this, indexDeep, textView, imageView2);
                linearLayout2.setOnClickListener(dVar);
                relativeLayout.setOnClickListener(new e(relativeLayout, 800, indexDeep));
                linearLayout3.setOnClickListener(new r(indexDeep, context));
                dw.a.a(rVar.b(R.id.llDeepNews)).throttleFirst(300, TimeUnit.MILLISECONDS).subscribe(new s(new NewDeepHandler$handleView$1$6(indexDeep, homeFeedInfoItem2, context)));
            } else {
                imageView = imageView3;
                linearLayout = linearLayout4;
            }
            s sVar2 = s.f23381a;
            Context context2 = context;
            IndexDeep indexDeep2 = indexDeep;
            imageView.setOnClickListener(new a(imageView, 800, context, indexDeep));
            if (com.hbg.module.libkt.base.ext.b.w(indexDeep2 != null ? indexDeep2.getHotCommentList() : null)) {
                linearLayout.setVisibility(8);
                return;
            }
            LinearLayout linearLayout6 = linearLayout;
            int i12 = 0;
            linearLayout6.setVisibility(0);
            linearLayout6.removeAllViews();
            for (CommunityFeedInfo.HotComment next : indexDeep2.getHotCommentList()) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(next.hotComAuditor + com.sumsub.sns.internal.fingerprint.infoproviders.l.f34627b + next.hotComment);
                spannableStringBuilder.setSpan(new c(next), i12, next.hotComAuditor.length() + 1, 17);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(com.hbg.module.libkt.base.ext.b.o(context2, R.attr.base_color_primary_text)), i12, next.hotComAuditor.length() + 1, 17);
                HotCommentView hotCommentView = new HotCommentView(context2, (AttributeSet) null, 0, 6, (kotlin.jvm.internal.r) null);
                hotCommentView.setTextSize(15.0f);
                hotCommentView.setLineHeight(com.hbg.module.libkt.base.ext.c.d(Float.valueOf(20.0f)));
                hotCommentView.setPadding(i12, i12, i12, 5);
                hotCommentView.setTextColor(com.hbg.module.libkt.base.ext.b.o(context2, R.attr.base_color_secondary_textNew));
                hotCommentView.setMaxLines(2);
                hotCommentView.setEllipsize(TextUtils.TruncateAt.END);
                hotCommentView.setText(spannableStringBuilder);
                hotCommentView.setMovementMethod(new LinkMovementMethod());
                s sVar3 = s.f23381a;
                HotCommentView hotCommentView2 = hotCommentView;
                LinearLayout linearLayout7 = linearLayout6;
                hotCommentView2.setOnClickListener(new b(hotCommentView, 800, indexDeep2, homeFeedInfoItem, context2));
                linearLayout7.addView(hotCommentView2);
                i12 = i12;
                linearLayout6 = linearLayout7;
            }
        }
    }

    public int getResId() {
        return R.layout.item_home_deep_news;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void k(android.widget.TextView r4, android.widget.ImageView r5, com.huobi.index.bean.IndexDeep r6) {
        /*
            r3 = this;
            int r0 = r6.praiseNum
            com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo$ListBean$AttitudeInfo r1 = r6.attitudeInfo
            r2 = 0
            if (r1 == 0) goto L_0x000a
            int r1 = r1.attitudeCount
            goto L_0x000b
        L_0x000a:
            r1 = r2
        L_0x000b:
            int r0 = r0 + r1
            java.lang.String r0 = java.lang.String.valueOf(r0)
            he.b.l(r4, r0)
            int r0 = r6.praiseStatus
            r1 = 1
            if (r0 == r1) goto L_0x002d
            com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo$ListBean$AttitudeInfo r0 = r6.attitudeInfo
            if (r0 == 0) goto L_0x001e
            int r2 = r0.userAttitudeType
        L_0x001e:
            if (r2 == 0) goto L_0x0021
            goto L_0x002d
        L_0x0021:
            android.content.Context r0 = r4.getContext()
            r1 = 2130968752(0x7f0400b0, float:1.7546167E38)
            int r0 = com.hbg.module.libkt.base.ext.b.o(r0, r1)
            goto L_0x0038
        L_0x002d:
            android.content.Context r0 = r4.getContext()
            r1 = 2130969058(0x7f0401e2, float:1.7546787E38)
            int r0 = com.hbg.module.libkt.base.ext.b.o(r0, r1)
        L_0x0038:
            r4.setTextColor(r0)
            int r6 = r6.praiseStatus
            if (r6 != 0) goto L_0x004e
            android.content.Context r4 = r4.getContext()
            r6 = 2130969749(0x7f040495, float:1.7548189E38)
            int r4 = com.hbg.module.libkt.base.ext.b.q(r4, r6)
            com.hbg.module.libkt.base.ext.b.A(r5, r4)
            goto L_0x005c
        L_0x004e:
            android.content.Context r4 = r4.getContext()
            r6 = 2130969750(0x7f040496, float:1.754819E38)
            int r4 = com.hbg.module.libkt.base.ext.b.q(r4, r6)
            com.hbg.module.libkt.base.ext.b.A(r5, r4)
        L_0x005c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.index.viewhandler.NewDeepHandler.k(android.widget.TextView, android.widget.ImageView, com.huobi.index.bean.IndexDeep):void");
    }
}
