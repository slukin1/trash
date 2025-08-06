package com.hbg.module.community.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.android.arouter.facade.Postcard;
import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import com.hbg.lib.widgets.photoviewer.PhotoViewerUtils;
import com.hbg.lib.widgets.photoviewer.data.ImageData;
import com.hbg.module.community.adapter.CommunityBaseCommonBinder;
import com.hbg.module.community.view.VideoCoverImageView;
import com.hbg.module.content.R$id;
import com.hbg.module.libkt.custom.PicView;
import com.hbg.module.libkt.provider.HbgBaseProvider;
import com.huobi.view.roundview.RoundConstraintLayout;
import com.huochat.community.CommunityModuleCallback;
import com.huochat.community.CommunityModuleConfig;
import com.huochat.community.base.CommunityConstants;
import com.huochat.community.widget.expandable.ExpandableTextView;
import com.huochat.community.widget.expandable.LinkType;
import com.huochat.community.widget.expandable.StatusType;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.jvm.internal.Ref$BooleanRef;
import lc.c3;
import rd.s;
import se.e;

public final class CommunityReplyArticleCommonBinder extends CommunityBaseCommonBinder<CommunityFeedInfo.ListBean, a> {

    public static final class a extends l {

        /* renamed from: c  reason: collision with root package name */
        public final c3 f17097c;

        /* renamed from: com.hbg.module.community.adapter.CommunityReplyArticleCommonBinder$a$a  reason: collision with other inner class name */
        public static final class C0122a implements View.OnClickListener {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ View f17098b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ long f17099c;

            public C0122a(View view, long j11) {
                this.f17098b = view;
                this.f17099c = j11;
            }

            @SensorsDataInstrumented
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                s sVar = s.f23381a;
                if (currentTimeMillis - sVar.b(this.f17098b) > this.f17099c || (this.f17098b instanceof Checkable)) {
                    sVar.e(this.f17098b, currentTimeMillis);
                }
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        }

        public a(c3 c3Var) {
            super(c3Var.getRoot());
            this.f17097c = c3Var;
            s sVar = s.f23381a;
            View root = c3Var.getRoot();
            root.setOnClickListener(new C0122a(root, 800));
        }

        public final c3 c() {
            return this.f17097c;
        }
    }

    public static final class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17100b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17101c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CommunityFeedInfo.ListBean f17102d;

        public b(View view, long j11, CommunityFeedInfo.ListBean listBean) {
            this.f17100b = view;
            this.f17101c = j11;
            this.f17102d = listBean;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17100b) > this.f17101c || (this.f17100b instanceof Checkable)) {
                sVar.e(this.f17100b, currentTimeMillis);
                RoundConstraintLayout roundConstraintLayout = (RoundConstraintLayout) this.f17100b;
                b2.a.d().a("/content/DynamicDetail").withString("dynamicId", String.valueOf(this.f17102d.getId())).navigation();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17103b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17104c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f17105d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CommunityFeedInfo.ListBean f17106e;

        public c(View view, long j11, a aVar, CommunityFeedInfo.ListBean listBean) {
            this.f17103b = view;
            this.f17104c = j11;
            this.f17105d = aVar;
            this.f17106e = listBean;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17103b) > this.f17104c || (this.f17103b instanceof Checkable)) {
                sVar.e(this.f17103b, currentTimeMillis);
                VideoCoverImageView videoCoverImageView = (VideoCoverImageView) this.f17103b;
                se.d.m(this.f17105d.c().B, this.f17106e.getParentDynamic().getVideoUrl(), this.f17106e.getParentDynamic().getSeek(), true, new g(this.f17106e), this.f17106e.getParentDynamic().getVideoWidth(), this.f17106e.getParentDynamic().getVideoHeight());
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class d implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17107b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17108c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d10.a f17109d;

        public d(View view, long j11, d10.a aVar) {
            this.f17107b = view;
            this.f17108c = j11;
            this.f17109d = aVar;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17107b) > this.f17108c || (this.f17107b instanceof Checkable)) {
                sVar.e(this.f17107b, currentTimeMillis);
                ExpandableTextView expandableTextView = (ExpandableTextView) this.f17107b;
                this.f17109d.invoke();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class e implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17110b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17111c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d10.a f17112d;

        public e(View view, long j11, d10.a aVar) {
            this.f17110b = view;
            this.f17111c = j11;
            this.f17112d = aVar;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17110b) > this.f17111c || (this.f17110b instanceof Checkable)) {
                sVar.e(this.f17110b, currentTimeMillis);
                this.f17112d.invoke();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class f implements PicView.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Ref$BooleanRef f17113a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CommunityFeedInfo.ListBean f17114b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CommunityReplyArticleCommonBinder f17115c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Context f17116d;

        public f(Ref$BooleanRef ref$BooleanRef, CommunityFeedInfo.ListBean listBean, CommunityReplyArticleCommonBinder communityReplyArticleCommonBinder, Context context) {
            this.f17113a = ref$BooleanRef;
            this.f17114b = listBean;
            this.f17115c = communityReplyArticleCommonBinder;
            this.f17116d = context;
        }

        public void a(int i11, ArrayList<CommunityFeedInfo.imgListBean> arrayList) {
            PicView.a.C0216a.a(this, i11, arrayList);
        }

        public void b(int i11, ArrayList<CommunityFeedInfo.imgListBean> arrayList) {
            if (this.f17113a.element) {
                b2.a.d().a("/live/room").withString("liveId", String.valueOf(this.f17114b.getParentDynamic().getId())).withInt("liveStatus", this.f17114b.getParentDynamic().getStatus()).navigation();
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            if (arrayList != null) {
                for (CommunityFeedInfo.imgListBean imglistbean : arrayList) {
                    arrayList2.add(new ImageData(imglistbean.getImage(), imglistbean.getThumbImage()));
                }
            }
            nc.c.a("app_community_picdj", this.f17115c.G(this.f17114b));
            PhotoViewerUtils.a((FragmentActivity) this.f17116d, arrayList2, i11);
        }
    }

    public static final class g implements se.e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CommunityFeedInfo.ListBean f17117a;

        public g(CommunityFeedInfo.ListBean listBean) {
            this.f17117a = listBean;
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
            this.f17117a.getParentDynamic().setSeek(i12);
        }

        public void e() {
            e.a.a(this);
        }

        public void onError() {
            e.a.d(this);
        }
    }

    public static final void u0(CommunityReplyArticleCommonBinder communityReplyArticleCommonBinder, LinkType linkType, String str, String str2) {
        if (linkType == LinkType.MENTION_TYPE) {
            i6.d.b("link click, url = " + str);
            try {
                HbgBaseProvider E = communityReplyArticleCommonBinder.E();
                if (E != null) {
                    E.g(str);
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public static final void v0(CommunityReplyArticleCommonBinder communityReplyArticleCommonBinder, CommunityFeedInfo.ListBean listBean, CommunityFeedInfo.ListBean.ParentDynamic parentDynamic, LinkType linkType, String str, String str2) {
        if (linkType == LinkType.MENTION_TYPE) {
            HashMap<Object, Object> G = communityReplyArticleCommonBinder.G(listBean);
            CommunityFeedInfo.TopicTag topicTag = parentDynamic.getTopic().get(0);
            int i11 = -1;
            G.put(CommunityConstants.TOPIC_ID, Integer.valueOf(topicTag != null ? topicTag.getTopicId() : -1));
            CommunityFeedInfo.TopicTag topicTag2 = parentDynamic.getTopic().get(0);
            Integer num = null;
            String title = topicTag2 != null ? topicTag2.getTitle() : null;
            if (title == null) {
                title = "";
            }
            G.put("title", title);
            CommunityFeedInfo.TopicTag topicTag3 = parentDynamic.getTopic().get(0);
            if (topicTag3 != null) {
                i11 = topicTag3.getIdentification();
            }
            G.put("identification", Integer.valueOf(i11));
            nc.c.a("app_community_nrkpht", G);
            Postcard a11 = b2.a.d().a("/content/topicDetail");
            CommunityFeedInfo.TopicTag topicTag4 = parentDynamic.getTopic().get(0);
            if (topicTag4 != null) {
                num = Integer.valueOf(topicTag4.getTopicId());
            }
            a11.withString(CommunityConstants.TOPIC_ID, String.valueOf(num)).withString("tradeType", k.a(communityReplyArticleCommonBinder.k(), communityReplyArticleCommonBinder.l())).navigation();
        }
    }

    public static final void w0(CommunityReplyArticleCommonBinder communityReplyArticleCommonBinder, CommunityFeedInfo.ListBean listBean, Ref$BooleanRef ref$BooleanRef, StatusType statusType) {
        CommunityModuleCallback moduleCallback = CommunityModuleConfig.Companion.getModuleCallback();
        if (moduleCallback != null) {
            moduleCallback.newTrack("app_community_feed", communityReplyArticleCommonBinder.G(listBean));
        }
        b2.a d11 = b2.a.d();
        if (ref$BooleanRef.element) {
            d11.a("/live/room").withString("liveId", String.valueOf(listBean.getParentDynamic().getId())).withInt("liveStatus", listBean.getParentDynamic().getStatus()).navigation();
        } else {
            d11.a("/content/DynamicDetail").withString("dynamicId", String.valueOf(listBean.getParentDynamic().getId())).navigation();
        }
    }

    public l Y(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return new a(c3.K(layoutInflater, viewGroup, false));
    }

    /* renamed from: b0 */
    public void g(CommunityBaseCommonBinder.a aVar) {
        super.g(aVar);
        if (((ConstraintLayout) aVar.itemView.findViewById(R$id.clCommunityVideo)) != null) {
            se.d.w();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:158:0x034f, code lost:
        if (r3 == null) goto L_0x0351;
     */
    /* renamed from: t0 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void N(com.hbg.module.community.adapter.CommunityReplyArticleCommonBinder.a r26, com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo.ListBean r27) {
        /*
            r25 = this;
            r0 = r25
            r7 = r27
            android.view.View r1 = r26.a()
            r2 = 0
            if (r1 == 0) goto L_0x0011
            android.content.Context r1 = r1.getContext()
            r9 = r1
            goto L_0x0012
        L_0x0011:
            r9 = r2
        L_0x0012:
            kotlin.jvm.internal.Ref$BooleanRef r1 = new kotlin.jvm.internal.Ref$BooleanRef
            r1.<init>()
            lc.c3 r3 = r26.c()
            android.widget.LinearLayout r3 = r3.H
            r4 = 8
            r3.setVisibility(r4)
            int r3 = r27.getType()
            java.lang.String r5 = ""
            r6 = 1
            r14 = 0
            if (r3 != r4) goto L_0x01ca
            java.lang.String r3 = r7.extend
            boolean r3 = com.hbg.module.libkt.base.ext.b.x(r3)
            if (r3 != 0) goto L_0x01ca
            java.lang.String r3 = r7.extend
            com.hbg.module.community.adapter.CommunityReplyArticleCommonBinder$onBindContentViewHolder$$inlined$gsonToBean$1 r8 = new com.hbg.module.community.adapter.CommunityReplyArticleCommonBinder$onBindContentViewHolder$$inlined$gsonToBean$1
            r8.<init>()
            java.lang.reflect.Type r8 = r8.getType()
            com.google.gson.Gson r10 = com.hbg.module.libkt.base.ext.f.e()
            java.lang.Object r3 = r10.fromJson((java.lang.String) r3, (java.lang.reflect.Type) r8)
            com.hbg.lib.network.hbg.core.bean.LiveDetailBean r3 = (com.hbg.lib.network.hbg.core.bean.LiveDetailBean) r3
            com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo$ListBean$ParentDynamic r8 = new com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo$ListBean$ParentDynamic
            r8.<init>()
            r7.setParentDynamic(r8)
            if (r3 == 0) goto L_0x0056
            java.util.List<com.hbg.lib.network.hbg.core.bean.LiveSpeaker> r8 = r3.speakerList
            goto L_0x0057
        L_0x0056:
            r8 = r2
        L_0x0057:
            boolean r8 = com.hbg.module.libkt.base.ext.b.w(r8)
            if (r8 != 0) goto L_0x008f
            com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo$ListBean$ParentDynamic r8 = r27.getParentDynamic()
            if (r3 == 0) goto L_0x0072
            java.util.List<com.hbg.lib.network.hbg.core.bean.LiveSpeaker> r10 = r3.speakerList
            if (r10 == 0) goto L_0x0072
            java.lang.Object r10 = r10.get(r14)
            com.hbg.lib.network.hbg.core.bean.LiveSpeaker r10 = (com.hbg.lib.network.hbg.core.bean.LiveSpeaker) r10
            if (r10 == 0) goto L_0x0072
            java.lang.String r10 = r10.avatar
            goto L_0x0073
        L_0x0072:
            r10 = r2
        L_0x0073:
            r8.setUserAvatar(r10)
            com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo$ListBean$ParentDynamic r8 = r27.getParentDynamic()
            if (r3 == 0) goto L_0x008b
            java.util.List<com.hbg.lib.network.hbg.core.bean.LiveSpeaker> r10 = r3.speakerList
            if (r10 == 0) goto L_0x008b
            java.lang.Object r10 = r10.get(r14)
            com.hbg.lib.network.hbg.core.bean.LiveSpeaker r10 = (com.hbg.lib.network.hbg.core.bean.LiveSpeaker) r10
            if (r10 == 0) goto L_0x008b
            java.lang.String r10 = r10.nickname
            goto L_0x008c
        L_0x008b:
            r10 = r2
        L_0x008c:
            r8.setUserNickname(r10)
        L_0x008f:
            com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo$ListBean$ParentDynamic r8 = r27.getParentDynamic()
            if (r3 == 0) goto L_0x0098
            java.lang.String r10 = r3.title
            goto L_0x0099
        L_0x0098:
            r10 = r2
        L_0x0099:
            r8.setTitle(r10)
            com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo$ListBean$ParentDynamic r8 = r27.getParentDynamic()
            if (r3 == 0) goto L_0x00a5
            java.lang.String r10 = r3.introduction
            goto L_0x00a6
        L_0x00a5:
            r10 = r2
        L_0x00a6:
            r8.setContent(r10)
            com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo$imgListBean r8 = new com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo$imgListBean
            r8.<init>()
            if (r3 == 0) goto L_0x00b3
            java.lang.String r10 = r3.coverImageUrl
            goto L_0x00b4
        L_0x00b3:
            r10 = r2
        L_0x00b4:
            r8.setImage(r10)
            r10 = 2
            r8.setWidth(r10)
            r8.setHeight(r6)
            com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo$ListBean$ParentDynamic r11 = r27.getParentDynamic()
            com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo$imgListBean[] r12 = new com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo.imgListBean[r6]
            r12[r14] = r8
            java.util.ArrayList r8 = kotlin.collections.CollectionsKt__CollectionsKt.g(r12)
            r11.setImgList(r8)
            com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo$ListBean$ParentDynamic r8 = r27.getParentDynamic()
            if (r3 == 0) goto L_0x00dc
            java.lang.String r11 = r3.f70249id
            if (r11 == 0) goto L_0x00dc
            int r11 = java.lang.Integer.parseInt(r11)
            goto L_0x00dd
        L_0x00dc:
            r11 = r14
        L_0x00dd:
            r8.setId(r11)
            com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo$ListBean$ParentDynamic r8 = r27.getParentDynamic()
            if (r3 == 0) goto L_0x00e9
            int r11 = r3.status
            goto L_0x00ea
        L_0x00e9:
            r11 = r6
        L_0x00ea:
            r8.setStatus(r11)
            if (r3 == 0) goto L_0x00f5
            int r8 = r3.status
            if (r8 != r10) goto L_0x00f5
            r8 = r6
            goto L_0x00f6
        L_0x00f5:
            r8 = r14
        L_0x00f6:
            if (r8 == 0) goto L_0x0117
            lc.c3 r3 = r26.c()
            android.widget.LinearLayout r3 = r3.H
            int r8 = com.hbg.module.content.R$drawable.bg_live_broadcast_lb_tips
            r3.setBackgroundResource(r8)
            lc.c3 r3 = r26.c()
            android.widget.ImageView r3 = r3.F
            r3.setVisibility(r4)
            lc.c3 r3 = r26.c()
            com.hbg.lib.widgets.SafeLottieView r3 = r3.I
            r3.setVisibility(r14)
            goto L_0x01bf
        L_0x0117:
            lc.c3 r8 = r26.c()
            android.widget.LinearLayout r8 = r8.H
            int r11 = com.hbg.module.content.R$drawable.bg_live_playback_lb_tips
            r8.setBackgroundResource(r11)
            if (r3 == 0) goto L_0x012a
            int r8 = r3.status
            if (r8 != r6) goto L_0x012a
            r8 = r6
            goto L_0x012b
        L_0x012a:
            r8 = r14
        L_0x012b:
            if (r8 == 0) goto L_0x0175
            lc.c3 r8 = r26.c()
            android.widget.ImageView r8 = r8.F
            int r11 = com.hbg.module.content.R$drawable.ic_live_appointment
            r8.setImageResource(r11)
            if (r9 == 0) goto L_0x0148
            android.content.res.Resources r8 = r9.getResources()
            if (r8 == 0) goto L_0x0148
            int r11 = com.hbg.module.content.R$string.n_content_live_play_time
            java.lang.String r8 = r8.getString(r11)
            if (r8 != 0) goto L_0x0149
        L_0x0148:
            r8 = r5
        L_0x0149:
            long r11 = r3.startTime
            java.lang.String r13 = "MM-dd HH:mm"
            java.lang.String r11 = com.hbg.lib.common.utils.DateTimeUtils.h(r11, r13)
            int r3 = r3.appointedNum
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r3 = he.b.e(r3)
            kotlin.jvm.internal.d0 r12 = kotlin.jvm.internal.d0.f56774a
            java.lang.Object[] r12 = new java.lang.Object[r10]
            r12[r14] = r11
            r12[r6] = r3
            java.lang.Object[] r3 = java.util.Arrays.copyOf(r12, r10)
            java.lang.String r3 = java.lang.String.format(r8, r3)
            lc.c3 r8 = r26.c()
            android.widget.TextView r8 = r8.K
            r8.setText(r3)
            goto L_0x01ad
        L_0x0175:
            lc.c3 r8 = r26.c()
            android.widget.ImageView r8 = r8.F
            int r10 = com.hbg.module.content.R$drawable.ic_live_playback
            r8.setImageResource(r10)
            lc.c3 r8 = r26.c()
            android.widget.TextView r8 = r8.K
            kotlin.jvm.internal.d0 r10 = kotlin.jvm.internal.d0.f56774a
            if (r9 == 0) goto L_0x0192
            int r10 = com.hbg.module.content.R$string.n_content_live_watched
            java.lang.String r10 = r9.getString(r10)
            if (r10 != 0) goto L_0x0194
        L_0x0192:
            java.lang.String r10 = "%s"
        L_0x0194:
            java.lang.Object[] r11 = new java.lang.Object[r6]
            if (r3 == 0) goto L_0x019b
            java.lang.String r3 = r3.onlineNum
            goto L_0x019c
        L_0x019b:
            r3 = r2
        L_0x019c:
            java.lang.String r3 = he.b.e(r3)
            r11[r14] = r3
            java.lang.Object[] r3 = java.util.Arrays.copyOf(r11, r6)
            java.lang.String r3 = java.lang.String.format(r10, r3)
            r8.setText(r3)
        L_0x01ad:
            lc.c3 r3 = r26.c()
            android.widget.ImageView r3 = r3.F
            r3.setVisibility(r14)
            lc.c3 r3 = r26.c()
            com.hbg.lib.widgets.SafeLottieView r3 = r3.I
            r3.setVisibility(r4)
        L_0x01bf:
            lc.c3 r3 = r26.c()
            android.widget.LinearLayout r3 = r3.H
            r3.setVisibility(r14)
            r1.element = r6
        L_0x01ca:
            com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo$ListBean$ParentDynamic r15 = r27.getParentDynamic()
            java.lang.String r3 = r15.getUserAvatar()
            boolean r3 = com.hbg.module.libkt.base.ext.b.x(r3)
            java.lang.String r8 = "BIG_V"
            if (r3 == 0) goto L_0x0216
            lc.c3 r3 = r26.c()
            com.hbg.module.huobi.im.view.AvatarView r3 = r3.E
            java.lang.String r10 = r15.getUidUnique()
            com.hbg.module.huobi.im.view.AvatarView r3 = r3.z(r10, r2)
            int r10 = com.hbg.module.content.R$drawable.account_user_image
            r3.y(r10, r14)
            lc.c3 r3 = r26.c()
            com.hbg.module.huobi.im.view.AvatarView r3 = r3.E
            int r10 = r15.getIsAlive()
            if (r10 != 0) goto L_0x01fb
            r10 = r6
            goto L_0x01fc
        L_0x01fb:
            r10 = r14
        L_0x01fc:
            if (r10 == 0) goto L_0x0210
            com.hbg.lib.network.hbg.core.bean.PersonalCenterInfo$UcExtInfo r10 = r15.getUcExtInfo()
            if (r10 == 0) goto L_0x0207
            java.lang.String r10 = r10.showExtBusinessTag
            goto L_0x0208
        L_0x0207:
            r10 = r2
        L_0x0208:
            boolean r8 = kotlin.jvm.internal.x.b(r8, r10)
            if (r8 == 0) goto L_0x0210
            r8 = r6
            goto L_0x0211
        L_0x0210:
            r8 = r14
        L_0x0211:
            r3.A(r8)
            goto L_0x027a
        L_0x0216:
            lc.c3 r3 = r26.c()
            com.hbg.module.huobi.im.view.AvatarView r3 = r3.E
            java.lang.String r10 = r15.getUserAvatar()
            com.hbg.lib.network.hbg.core.bean.PersonalCenterInfo$UcExtInfo r11 = r15.getUcExtInfo()
            if (r11 == 0) goto L_0x0229
            java.lang.String r11 = r11.headImageType
            goto L_0x022a
        L_0x0229:
            r11 = r2
        L_0x022a:
            java.lang.String r12 = "NFT"
            boolean r11 = kotlin.jvm.internal.x.b(r11, r12)
            com.hbg.lib.network.hbg.core.bean.PersonalCenterInfo$UcExtInfo r12 = r15.getUcExtInfo()
            if (r12 == 0) goto L_0x0239
            java.lang.String r12 = r12.frameUrl
            goto L_0x023a
        L_0x0239:
            r12 = r2
        L_0x023a:
            com.hbg.module.huobi.im.view.AvatarView r16 = r3.u(r10, r11, r12)
            r17 = 0
            r18 = -1
            java.lang.String r19 = r15.getUidUnique()
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 48
            r24 = 0
            com.hbg.module.huobi.im.view.AvatarView.t(r16, r17, r18, r19, r20, r21, r22, r23, r24)
            lc.c3 r3 = r26.c()
            com.hbg.module.huobi.im.view.AvatarView r3 = r3.E
            int r10 = r15.getIsAlive()
            if (r10 != 0) goto L_0x0261
            r10 = r6
            goto L_0x0262
        L_0x0261:
            r10 = r14
        L_0x0262:
            if (r10 == 0) goto L_0x0276
            com.hbg.lib.network.hbg.core.bean.PersonalCenterInfo$UcExtInfo r10 = r15.getUcExtInfo()
            if (r10 == 0) goto L_0x026d
            java.lang.String r10 = r10.showExtBusinessTag
            goto L_0x026e
        L_0x026d:
            r10 = r2
        L_0x026e:
            boolean r8 = kotlin.jvm.internal.x.b(r8, r10)
            if (r8 == 0) goto L_0x0276
            r8 = r6
            goto L_0x0277
        L_0x0276:
            r8 = r14
        L_0x0277:
            r3.A(r8)
        L_0x027a:
            com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo$ListBean$ParentDynamic r3 = r27.getParentDynamic()
            java.lang.String r3 = r3.getUserNickname()
            if (r3 == 0) goto L_0x028d
            int r3 = r3.length()
            if (r3 != 0) goto L_0x028b
            goto L_0x028d
        L_0x028b:
            r3 = r14
            goto L_0x028e
        L_0x028d:
            r3 = r6
        L_0x028e:
            if (r3 != 0) goto L_0x02a7
            lc.c3 r3 = r26.c()
            androidx.appcompat.widget.AppCompatTextView r3 = r3.L
            r3.setVisibility(r14)
            lc.c3 r3 = r26.c()
            androidx.appcompat.widget.AppCompatTextView r3 = r3.L
            java.lang.String r8 = r15.getUserNickname()
            r3.setText(r8)
            goto L_0x02b0
        L_0x02a7:
            lc.c3 r3 = r26.c()
            androidx.appcompat.widget.AppCompatTextView r3 = r3.L
            r3.setVisibility(r4)
        L_0x02b0:
            com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo$ListBean$ParentDynamic r3 = r27.getParentDynamic()
            java.lang.String r3 = r3.getTitle()
            if (r3 == 0) goto L_0x02c3
            int r3 = r3.length()
            if (r3 != 0) goto L_0x02c1
            goto L_0x02c3
        L_0x02c1:
            r3 = r14
            goto L_0x02c4
        L_0x02c3:
            r3 = r6
        L_0x02c4:
            if (r3 == 0) goto L_0x02d0
            lc.c3 r3 = r26.c()
            androidx.appcompat.widget.AppCompatTextView r3 = r3.M
            r3.setVisibility(r4)
            goto L_0x032d
        L_0x02d0:
            lc.c3 r3 = r26.c()
            androidx.appcompat.widget.AppCompatTextView r3 = r3.M
            r3.setVisibility(r14)
            int r3 = r15.getTop()
            if (r3 != r6) goto L_0x0320
            android.text.SpannableString r3 = new android.text.SpannableString
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r10 = "  "
            r8.append(r10)
            java.lang.String r10 = r15.getTitle()
            r8.append(r10)
            java.lang.String r8 = r8.toString()
            r3.<init>(r8)
            int r8 = com.hbg.module.content.R$attr.icon_market_news_top
            android.graphics.drawable.Drawable r8 = com.hbg.module.libkt.base.ext.b.p(r9, r8)
            if (r8 == 0) goto L_0x030c
            int r10 = r8.getIntrinsicWidth()
            int r11 = r8.getIntrinsicHeight()
            r8.setBounds(r14, r14, r10, r11)
        L_0x030c:
            com.huochat.community.widget.expandable.ExpandableTextView$SelfImageSpan r10 = new com.huochat.community.widget.expandable.ExpandableTextView$SelfImageSpan
            r10.<init>(r8, r6)
            r8 = 33
            r3.setSpan(r10, r14, r6, r8)
            lc.c3 r8 = r26.c()
            androidx.appcompat.widget.AppCompatTextView r8 = r8.M
            r8.setText(r3)
            goto L_0x032d
        L_0x0320:
            lc.c3 r3 = r26.c()
            androidx.appcompat.widget.AppCompatTextView r3 = r3.M
            java.lang.String r8 = r15.getTitle()
            r3.setText(r8)
        L_0x032d:
            java.util.List r3 = r15.getTopic()
            if (r3 == 0) goto L_0x0351
            java.util.List r3 = r15.getTopic()
            int r3 = r3.size()
            if (r3 <= 0) goto L_0x0351
            java.util.List r3 = r15.getTopic()
            java.lang.Object r3 = r3.get(r14)
            com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo$TopicTag r3 = (com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo.TopicTag) r3
            if (r3 == 0) goto L_0x034e
            java.lang.String r3 = r3.getTitle()
            goto L_0x034f
        L_0x034e:
            r3 = r2
        L_0x034f:
            if (r3 != 0) goto L_0x0352
        L_0x0351:
            r3 = r5
        L_0x0352:
            lc.c3 r8 = r26.c()
            com.huochat.community.widget.expandable.ExpandableTextView r8 = r8.J
            r8.setNeedShowPrefixMarkIcon(r14)
            java.util.List r8 = r15.getSpecialContent()
            if (r8 == 0) goto L_0x03c1
            java.util.List r8 = r15.getSpecialContent()
            int r8 = r8.size()
            if (r8 <= 0) goto L_0x03c1
            lc.c3 r2 = r26.c()
            com.huochat.community.widget.expandable.ExpandableTextView r2 = r2.J
            r2.setVisibility(r14)
            int r2 = r15.getTop()
            if (r2 != r6) goto L_0x03a4
            java.lang.String r2 = r15.getTitle()
            if (r2 == 0) goto L_0x0389
            int r2 = r2.length()
            if (r2 != 0) goto L_0x0387
            goto L_0x0389
        L_0x0387:
            r2 = r14
            goto L_0x038a
        L_0x0389:
            r2 = r6
        L_0x038a:
            if (r2 == 0) goto L_0x03a4
            lc.c3 r2 = r26.c()
            com.huochat.community.widget.expandable.ExpandableTextView r2 = r2.J
            r2.setNeedShowPrefixMarkIcon(r6)
            lc.c3 r2 = r26.c()
            com.huochat.community.widget.expandable.ExpandableTextView r2 = r2.J
            int r3 = com.hbg.module.content.R$attr.icon_market_news_top
            android.graphics.drawable.Drawable r3 = com.hbg.module.libkt.base.ext.b.p(r9, r3)
            r2.setPrefixMarkDrawable(r3)
        L_0x03a4:
            lc.c3 r2 = r26.c()
            com.huochat.community.widget.expandable.ExpandableTextView r2 = r2.J
            java.util.List r3 = r15.getSpecialContent()
            r2.setContent(r3)
            lc.c3 r2 = r26.c()
            com.huochat.community.widget.expandable.ExpandableTextView r2 = r2.J
            com.hbg.module.community.adapter.p r3 = new com.hbg.module.community.adapter.p
            r3.<init>(r0)
            r2.setLinkClickListener(r3)
            goto L_0x0445
        L_0x03c1:
            int r8 = r3.length()
            if (r8 != 0) goto L_0x03c9
            r8 = r6
            goto L_0x03ca
        L_0x03c9:
            r8 = r14
        L_0x03ca:
            if (r8 == 0) goto L_0x03f1
            java.lang.String r8 = r15.getContent()
            if (r8 == 0) goto L_0x03db
            int r8 = r8.length()
            if (r8 != 0) goto L_0x03d9
            goto L_0x03db
        L_0x03d9:
            r8 = r14
            goto L_0x03dc
        L_0x03db:
            r8 = r6
        L_0x03dc:
            if (r8 == 0) goto L_0x03f1
            lc.c3 r3 = r26.c()
            com.huochat.community.widget.expandable.ExpandableTextView r3 = r3.J
            r3.setContentWithHeadTopic(r5, r5, r2)
            lc.c3 r2 = r26.c()
            com.huochat.community.widget.expandable.ExpandableTextView r2 = r2.J
            r2.setVisibility(r4)
            goto L_0x0445
        L_0x03f1:
            lc.c3 r5 = r26.c()
            com.huochat.community.widget.expandable.ExpandableTextView r5 = r5.J
            r5.setVisibility(r14)
            int r5 = r15.getTop()
            if (r5 != r6) goto L_0x042a
            java.lang.String r5 = r15.getTitle()
            if (r5 == 0) goto L_0x040f
            int r5 = r5.length()
            if (r5 != 0) goto L_0x040d
            goto L_0x040f
        L_0x040d:
            r5 = r14
            goto L_0x0410
        L_0x040f:
            r5 = r6
        L_0x0410:
            if (r5 == 0) goto L_0x042a
            lc.c3 r5 = r26.c()
            com.huochat.community.widget.expandable.ExpandableTextView r5 = r5.J
            r5.setNeedShowPrefixMarkIcon(r6)
            lc.c3 r5 = r26.c()
            com.huochat.community.widget.expandable.ExpandableTextView r5 = r5.J
            int r8 = com.hbg.module.content.R$attr.icon_market_news_top
            android.graphics.drawable.Drawable r8 = com.hbg.module.libkt.base.ext.b.p(r9, r8)
            r5.setPrefixMarkDrawable(r8)
        L_0x042a:
            lc.c3 r5 = r26.c()
            com.huochat.community.widget.expandable.ExpandableTextView r5 = r5.J
            java.lang.String r8 = r15.getContent()
            r5.setContentWithHeadTopic(r8, r3, r2)
            lc.c3 r2 = r26.c()
            com.huochat.community.widget.expandable.ExpandableTextView r2 = r2.J
            com.hbg.module.community.adapter.q r3 = new com.hbg.module.community.adapter.q
            r3.<init>(r0, r7, r15)
            r2.setLinkClickListener(r3)
        L_0x0445:
            lc.c3 r2 = r26.c()
            com.huochat.community.widget.expandable.ExpandableTextView r2 = r2.J
            com.hbg.module.community.adapter.o r3 = new com.hbg.module.community.adapter.o
            r3.<init>(r0, r7, r1)
            r18 = 0
            r19 = 0
            r21 = 6
            r22 = 0
            r16 = r2
            r17 = r3
            gc.d.e(r16, r17, r18, r19, r21, r22)
            rd.s r2 = rd.s.f23381a
            lc.c3 r2 = r26.c()
            com.huobi.view.roundview.RoundConstraintLayout r2 = r2.C
            com.hbg.module.community.adapter.CommunityReplyArticleCommonBinder$b r3 = new com.hbg.module.community.adapter.CommunityReplyArticleCommonBinder$b
            r12 = 800(0x320, double:3.953E-321)
            r3.<init>(r2, r12, r7)
            r2.setOnClickListener(r3)
            java.util.ArrayList r2 = r15.getImgList()
            if (r2 == 0) goto L_0x04af
            java.util.ArrayList r2 = r15.getImgList()
            int r2 = r2.size()
            if (r2 <= 0) goto L_0x04af
            lc.c3 r2 = r26.c()
            com.hbg.module.libkt.custom.DynamicPicCardView r2 = r2.D
            r2.setShowType(r6)
            lc.c3 r2 = r26.c()
            com.hbg.module.libkt.custom.DynamicPicCardView r2 = r2.D
            java.util.ArrayList r3 = r15.getImgList()
            r2.setImageResList(r3)
            lc.c3 r2 = r26.c()
            com.hbg.module.libkt.custom.DynamicPicCardView r2 = r2.D
            com.hbg.module.community.adapter.CommunityReplyArticleCommonBinder$f r3 = new com.hbg.module.community.adapter.CommunityReplyArticleCommonBinder$f
            r3.<init>(r1, r7, r0, r9)
            r2.setImageClickListener(r3)
            lc.c3 r1 = r26.c()
            com.hbg.module.libkt.custom.DynamicPicCardView r1 = r1.D
            r1.setVisibility(r14)
            goto L_0x04b8
        L_0x04af:
            lc.c3 r1 = r26.c()
            com.hbg.module.libkt.custom.DynamicPicCardView r1 = r1.D
            r1.setVisibility(r4)
        L_0x04b8:
            com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo$ListBean$ParentDynamic r1 = r27.getParentDynamic()
            java.lang.String r1 = r1.getVideoUrl()
            boolean r1 = com.hbg.module.libkt.base.ext.b.x(r1)
            if (r1 != 0) goto L_0x0558
            if (r9 == 0) goto L_0x0558
            lc.c3 r1 = r26.c()
            android.widget.FrameLayout r1 = r1.B
            r1.setVisibility(r14)
            androidx.constraintlayout.widget.ConstraintLayout r1 = new androidx.constraintlayout.widget.ConstraintLayout
            r1.<init>(r9)
            android.view.ViewGroup$LayoutParams r2 = new android.view.ViewGroup$LayoutParams
            r3 = -1
            r4 = -2
            r2.<init>(r3, r4)
            r1.setLayoutParams(r2)
            int r2 = android.view.View.generateViewId()
            r1.setId(r2)
            com.hbg.module.community.view.VideoCoverImageView r6 = new com.hbg.module.community.view.VideoCoverImageView
            r10 = 0
            r11 = 0
            r2 = 6
            r3 = 0
            r8 = r6
            r4 = r12
            r12 = r2
            r13 = r3
            r8.<init>(r9, r10, r11, r12, r13)
            androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r2 = new androidx.constraintlayout.widget.ConstraintLayout$LayoutParams
            r2.<init>((int) r14, (int) r14)
            int r3 = r1.getId()
            r2.f7942h = r3
            int r3 = r1.getId()
            r2.f7948k = r3
            int r3 = r1.getId()
            r2.f7934d = r3
            int r3 = r1.getId()
            r2.f7940g = r3
            com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo$ListBean$ParentDynamic r3 = r27.getParentDynamic()
            int r3 = r3.getVideoWidth()
            com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo$ListBean$ParentDynamic r8 = r27.getParentDynamic()
            int r8 = r8.getVideoHeight()
            if (r3 <= r8) goto L_0x0526
            java.lang.String r3 = "W,343:220"
            goto L_0x0528
        L_0x0526:
            java.lang.String r3 = "W,343:430"
        L_0x0528:
            r2.H = r3
            r6.setLayoutParams(r2)
            com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo$ListBean$ParentDynamic r2 = r27.getParentDynamic()
            java.lang.String r2 = r2.getVideoImage()
            com.hbg.module.libkt.base.ext.b.B(r6, r2)
            r1.addView(r6)
            lc.c3 r2 = r26.c()
            android.widget.FrameLayout r2 = r2.B
            r2.addView(r1)
            r8 = 800(0x320, double:3.953E-321)
            com.hbg.module.community.adapter.CommunityReplyArticleCommonBinder$c r10 = new com.hbg.module.community.adapter.CommunityReplyArticleCommonBinder$c
            r1 = r10
            r2 = r6
            r11 = r4
            r3 = r8
            r5 = r26
            r8 = r6
            r6 = r27
            r1.<init>(r2, r3, r5, r6)
            r8.setOnClickListener(r10)
            goto L_0x0562
        L_0x0558:
            r11 = r12
            lc.c3 r1 = r26.c()
            android.widget.FrameLayout r1 = r1.B
            r1.setVisibility(r4)
        L_0x0562:
            com.hbg.module.community.adapter.CommunityReplyArticleCommonBinder$onBindContentViewHolder$jumpDetailDynamicPage$1 r1 = new com.hbg.module.community.adapter.CommunityReplyArticleCommonBinder$onBindContentViewHolder$jumpDetailDynamicPage$1
            r1.<init>(r0, r7, r15)
            lc.c3 r2 = r26.c()
            com.huochat.community.widget.expandable.ExpandableTextView r2 = r2.J
            com.hbg.module.community.adapter.CommunityReplyArticleCommonBinder$d r3 = new com.hbg.module.community.adapter.CommunityReplyArticleCommonBinder$d
            r3.<init>(r2, r11, r1)
            r2.setOnClickListener(r3)
            android.view.View r2 = r26.a()
            if (r2 == 0) goto L_0x0583
            com.hbg.module.community.adapter.CommunityReplyArticleCommonBinder$e r3 = new com.hbg.module.community.adapter.CommunityReplyArticleCommonBinder$e
            r3.<init>(r2, r11, r1)
            r2.setOnClickListener(r3)
        L_0x0583:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.community.adapter.CommunityReplyArticleCommonBinder.N(com.hbg.module.community.adapter.CommunityReplyArticleCommonBinder$a, com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo$ListBean):void");
    }
}
