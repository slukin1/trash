package com.hbg.module.community.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import com.hbg.lib.network.hbg.core.bean.LiveDetailBean;
import com.hbg.module.community.adapter.CommunityBaseCommonBinder;
import com.hbg.module.content.R$attr;
import com.hbg.module.content.R$color;
import com.hbg.module.content.R$drawable;
import com.hbg.module.content.R$string;
import com.hbg.module.libkt.provider.HbgBaseProvider;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.Arrays;
import kotlin.Pair;
import kotlin.jvm.internal.d0;
import kotlin.l;
import lc.i3;
import rd.s;

public final class CommunityShareCommonBinder extends CommunityBaseCommonBinder<CommunityFeedInfo.ListBean, a> {

    public static final class a extends l {

        /* renamed from: c  reason: collision with root package name */
        public final i3 f17124c;

        /* renamed from: d  reason: collision with root package name */
        public rj.b f17125d;

        /* renamed from: com.hbg.module.community.adapter.CommunityShareCommonBinder$a$a  reason: collision with other inner class name */
        public static final class C0124a implements View.OnClickListener {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ View f17126b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ long f17127c;

            public C0124a(View view, long j11) {
                this.f17126b = view;
                this.f17127c = j11;
            }

            @SensorsDataInstrumented
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                s sVar = s.f23381a;
                if (currentTimeMillis - sVar.b(this.f17126b) > this.f17127c || (this.f17126b instanceof Checkable)) {
                    sVar.e(this.f17126b, currentTimeMillis);
                }
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        }

        public a(i3 i3Var) {
            super(i3Var.getRoot());
            this.f17124c = i3Var;
            s sVar = s.f23381a;
            View root = i3Var.getRoot();
            root.setOnClickListener(new C0124a(root, 800));
        }

        public final rj.b c() {
            return this.f17125d;
        }

        public final i3 d() {
            return this.f17124c;
        }

        public final void e(rj.b bVar) {
            this.f17125d = bVar;
        }
    }

    public static final class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17128b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17129c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CommunityShareCommonBinder f17130d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CommunityFeedInfo.ListBean f17131e;

        public b(View view, long j11, CommunityShareCommonBinder communityShareCommonBinder, CommunityFeedInfo.ListBean listBean) {
            this.f17128b = view;
            this.f17129c = j11;
            this.f17130d = communityShareCommonBinder;
            this.f17131e = listBean;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17128b) > this.f17129c || (this.f17128b instanceof Checkable)) {
                sVar.e(this.f17128b, currentTimeMillis);
                AppCompatTextView appCompatTextView = (AppCompatTextView) this.f17128b;
                this.f17130d.q0(this.f17131e);
                HbgBaseProvider E = this.f17130d.E();
                if (E != null) {
                    E.g(this.f17131e.getShareLink());
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17132b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17133c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CommunityShareCommonBinder f17134d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CommunityFeedInfo.ListBean f17135e;

        public c(View view, long j11, CommunityShareCommonBinder communityShareCommonBinder, CommunityFeedInfo.ListBean listBean) {
            this.f17132b = view;
            this.f17133c = j11;
            this.f17134d = communityShareCommonBinder;
            this.f17135e = listBean;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17132b) > this.f17133c || (this.f17132b instanceof Checkable)) {
                sVar.e(this.f17132b, currentTimeMillis);
                AppCompatTextView appCompatTextView = (AppCompatTextView) this.f17132b;
                this.f17134d.q0(this.f17135e);
                HbgBaseProvider E = this.f17134d.E();
                if (E != null) {
                    E.g(this.f17135e.getShareLink());
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class d implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17136b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17137c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CommunityShareCommonBinder f17138d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CommunityFeedInfo.ListBean f17139e;

        public d(View view, long j11, CommunityShareCommonBinder communityShareCommonBinder, CommunityFeedInfo.ListBean listBean) {
            this.f17136b = view;
            this.f17137c = j11;
            this.f17138d = communityShareCommonBinder;
            this.f17139e = listBean;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17136b) > this.f17137c || (this.f17136b instanceof Checkable)) {
                sVar.e(this.f17136b, currentTimeMillis);
                AppCompatTextView appCompatTextView = (AppCompatTextView) this.f17136b;
                HbgBaseProvider E = this.f17138d.E();
                if (E != null) {
                    E.g(this.f17139e.getShareLink());
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class e implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17140b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17141c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CommunityShareCommonBinder f17142d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CommunityFeedInfo.ListBean f17143e;

        public e(View view, long j11, CommunityShareCommonBinder communityShareCommonBinder, CommunityFeedInfo.ListBean listBean) {
            this.f17140b = view;
            this.f17141c = j11;
            this.f17142d = communityShareCommonBinder;
            this.f17143e = listBean;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17140b) > this.f17141c || (this.f17140b instanceof Checkable)) {
                sVar.e(this.f17140b, currentTimeMillis);
                AppCompatTextView appCompatTextView = (AppCompatTextView) this.f17140b;
                HbgBaseProvider E = this.f17142d.E();
                if (E != null) {
                    E.g(this.f17143e.getShareFromLink());
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class f implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17144b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17145c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CommunityShareCommonBinder f17146d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CommunityFeedInfo.ListBean f17147e;

        public f(View view, long j11, CommunityShareCommonBinder communityShareCommonBinder, CommunityFeedInfo.ListBean listBean) {
            this.f17144b = view;
            this.f17145c = j11;
            this.f17146d = communityShareCommonBinder;
            this.f17147e = listBean;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17144b) > this.f17145c || (this.f17144b instanceof Checkable)) {
                sVar.e(this.f17144b, currentTimeMillis);
                AppCompatTextView appCompatTextView = (AppCompatTextView) this.f17144b;
                HbgBaseProvider E = this.f17146d.E();
                if (E != null) {
                    E.g(this.f17147e.getShareFromLink());
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class g implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17148b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17149c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CommunityShareCommonBinder f17150d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CommunityFeedInfo.ListBean f17151e;

        public g(View view, long j11, CommunityShareCommonBinder communityShareCommonBinder, CommunityFeedInfo.ListBean listBean) {
            this.f17148b = view;
            this.f17149c = j11;
            this.f17150d = communityShareCommonBinder;
            this.f17151e = listBean;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17148b) > this.f17149c || (this.f17148b instanceof Checkable)) {
                sVar.e(this.f17148b, currentTimeMillis);
                this.f17150d.q0(this.f17151e);
                HbgBaseProvider E = this.f17150d.E();
                if (E != null) {
                    E.g(this.f17151e.getShareLink());
                }
                nc.c.a("app_community_picdj", this.f17150d.G(this.f17151e));
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public l Y(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return new a(i3.K(layoutInflater, viewGroup, false));
    }

    public final void q0(CommunityFeedInfo.ListBean listBean) {
        Pair[] pairArr = new Pair[11];
        pairArr[0] = l.a("communityId", Integer.valueOf(listBean.getId()));
        pairArr[1] = l.a("uid", listBean.getUidUnique());
        pairArr[2] = l.a("title", listBean.getTitle());
        pairArr[3] = l.a("type", Integer.valueOf(listBean.getType()));
        pairArr[4] = l.a("praiseNum", Integer.valueOf(listBean.getPraiseNum()));
        pairArr[5] = l.a("commentNum", Integer.valueOf(listBean.getCommentNum()));
        pairArr[6] = l.a("recom_base_info", listBean.getRecom_base_info());
        pairArr[7] = l.a("topicType", Integer.valueOf(listBean.getShareType()));
        pairArr[8] = l.a("sharetype", Integer.valueOf(listBean.getShareType()));
        String j11 = j();
        if (j11 == null) {
            j11 = "";
        }
        pairArr[9] = l.a("TransPair_current_id", j11);
        pairArr[10] = l.a("markets_kline_class", k.a(k(), l()));
        nc.c.a("app_community_picclick", MapsKt__MapsKt.j(pairArr));
    }

    public final Bitmap r0(View view) {
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    /* renamed from: s0 */
    public Bitmap H(a aVar, CommunityFeedInfo.ListBean listBean) {
        if (listBean.getShareType() == 20 || listBean.getShareType() == 21) {
            return r0(aVar.d().J);
        }
        return null;
    }

    @SuppressLint({"SetTextI18n"})
    /* renamed from: t0 */
    public void N(a aVar, CommunityFeedInfo.ListBean listBean) {
        String str;
        Resources resources;
        String string;
        a aVar2 = aVar;
        CommunityFeedInfo.ListBean listBean2 = listBean;
        Context context = aVar.a().getContext();
        if (listBean.getShowTag() == 4) {
            aVar.a().setVisibility(8);
            return;
        }
        aVar.a().setVisibility(0);
        String str2 = "";
        aVar.d().D.setText(str2);
        aVar.d().I.setVisibility(0);
        aVar.d().J.setVisibility(8);
        int shareType = listBean.getShareType();
        if (shareType == 1) {
            if (listBean.getShareFromAvatar() != null) {
                com.hbg.module.libkt.base.ext.b.J(aVar.d().H, listBean.getShareFromAvatar());
            }
            aVar.d().D.setText(listBean.getShareFrom());
            s sVar = s.f23381a;
            AppCompatTextView appCompatTextView = aVar.d().D;
            appCompatTextView.setOnClickListener(new b(appCompatTextView, 800, this, listBean));
        } else if (shareType == 2) {
            if (!com.hbg.module.libkt.base.ext.b.x(listBean.getShareFromAvatar())) {
                com.hbg.module.libkt.base.ext.b.J(aVar.d().H, listBean.getShareFromAvatar());
            }
            aVar.d().D.setText(listBean.getShareFrom());
            s sVar2 = s.f23381a;
            AppCompatTextView appCompatTextView2 = aVar.d().D;
            appCompatTextView2.setOnClickListener(new c(appCompatTextView2, 800, this, listBean));
        } else if (shareType == 4 || shareType == 6) {
            if (listBean.getShareType() == 6) {
                s sVar3 = s.f23381a;
                AppCompatTextView appCompatTextView3 = aVar.d().D;
                appCompatTextView3.setOnClickListener(new d(appCompatTextView3, 800, this, listBean));
            } else {
                s sVar4 = s.f23381a;
                AppCompatTextView appCompatTextView4 = aVar.d().D;
                appCompatTextView4.setOnClickListener(new e(appCompatTextView4, 800, this, listBean));
            }
            com.hbg.module.libkt.base.ext.b.J(aVar.d().H, listBean.getShareFromAvatar());
            aVar.d().D.setText(listBean.getShareFrom());
        } else if (shareType == 18) {
            if (listBean.getShareFromAvatar() != null) {
                com.hbg.module.libkt.base.ext.b.J(aVar.d().H, listBean.getShareFromAvatar());
            }
            aVar.d().D.setText(listBean.getShareFrom());
            aVar.d().B.setTextColor(ResourcesCompat.d(context.getResources(), R$color.baseColorSecondaryText, (Resources.Theme) null));
            aVar.d().B.setTextSize(1, 12.0f);
            s sVar5 = s.f23381a;
            AppCompatTextView appCompatTextView5 = aVar.d().D;
            f fVar = r2;
            f fVar2 = new f(appCompatTextView5, 800, this, listBean);
            appCompatTextView5.setOnClickListener(fVar);
        } else if (shareType == 20) {
            aVar.d().I.setVisibility(8);
            aVar.d().J.setVisibility(0);
            aVar.d().J.removeAllViews();
            nc.a aVar3 = nc.a.f19345a;
            aVar2.e(aVar3.a());
            if (listBean.getShowTag() == 5) {
                rj.b c11 = aVar.c();
                aVar.d().J.addView(c11 != null ? c11.D("copytrading_trader_card.xml", context) : null);
                rj.b c12 = aVar.c();
                if (c12 != null) {
                    c12.I("traderCard.initTraderCardItem('" + listBean2.extend + "')");
                }
                aVar.d().J.setTag(aVar3.a());
            } else {
                rj.b c13 = aVar.c();
                aVar.d().J.addView(c13 != null ? c13.D("copytrading_trader_share_card.xml", context) : null);
                rj.b c14 = aVar.c();
                if (c14 != null) {
                    c14.I("traderShareCard.initTraderShareCardItem('" + listBean2.extend + "')");
                }
            }
        } else if (shareType == 21) {
            aVar.d().I.setVisibility(8);
            aVar.d().J.setVisibility(0);
            aVar.d().J.removeAllViews();
            aVar2.e(nc.a.f19345a.a());
            if (listBean.getShowTag() == 5) {
                rj.b c15 = aVar.c();
                aVar.d().J.addView(c15 != null ? c15.D("copytrading_follower_card.xml", context) : null);
                rj.b c16 = aVar.c();
                if (c16 != null) {
                    c16.I("followerCard.initFollowerCardItem('" + listBean2.extend + "')");
                }
            } else {
                rj.b c17 = aVar.c();
                aVar.d().J.addView(c17 != null ? c17.D("copytrading_follower_share_card.xml", context) : null);
                rj.b c18 = aVar.c();
                if (c18 != null) {
                    c18.I("followerShareCard.initFollowerShareCardItem('" + listBean2.extend + "')");
                }
            }
        }
        if (!com.hbg.module.libkt.base.ext.b.x(listBean.getShareLinkTitle())) {
            if (listBean.getShareType() != 6 || com.hbg.module.libkt.base.ext.b.x(listBean2.extend)) {
                aVar.d().C.setVisibility(8);
                aVar.d().B.setText(listBean.getShareLinkTitle());
            } else {
                LiveDetailBean liveDetailBean = (LiveDetailBean) com.hbg.module.libkt.base.ext.f.e().fromJson(listBean2.extend, new CommunityShareCommonBinder$onBindContentViewHolder$$inlined$gsonToBean$1().getType());
                aVar.d().C.setText(liveDetailBean != null ? liveDetailBean.title : null);
                aVar.d().B.setText(liveDetailBean != null ? liveDetailBean.introduction : null);
                aVar.d().C.setVisibility(0);
            }
        }
        String shareImage = listBean.getShareImage();
        if (shareImage == null || shareImage.length() == 0) {
            aVar.d().B.setPadding(0, 0, 0, sd.a.b(Float.valueOf(2.0f)));
            aVar.d().E.setVisibility(8);
            aVar.d().G.setVisibility(8);
        } else {
            aVar.d().B.setPadding(0, 0, 0, 0);
            if (listBean.getShareType() == 6) {
                try {
                    ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) aVar.d().G.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.H = "W,16:9";
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
                if (!com.hbg.module.libkt.base.ext.b.x(listBean2.extend)) {
                    LiveDetailBean liveDetailBean2 = (LiveDetailBean) com.hbg.module.libkt.base.ext.f.e().fromJson(listBean2.extend, new CommunityShareCommonBinder$onBindContentViewHolder$$inlined$gsonToBean$2().getType());
                    if (liveDetailBean2 != null && liveDetailBean2.status == 2) {
                        TextView textView = aVar.d().M;
                        d0 d0Var = d0.f56774a;
                        textView.setText(String.format(context.getString(R$string.n_content_live_watch), Arrays.copyOf(new Object[]{he.b.e(liveDetailBean2.onlineNum)}, 1)));
                        aVar.d().K.setBackgroundResource(R$drawable.bg_live_broadcast_lb_tips);
                        aVar.d().F.setVisibility(8);
                        aVar.d().L.setVisibility(0);
                    } else {
                        aVar.d().K.setBackgroundResource(R$drawable.bg_live_playback_lb_tips);
                        if (liveDetailBean2 != null && liveDetailBean2.status == 1) {
                            aVar.d().F.setImageResource(R$drawable.ic_live_appointment);
                            if (!(context == null || (resources = context.getResources()) == null || (string = resources.getString(R$string.n_content_live_play_time2)) == null)) {
                                str2 = string;
                            }
                            String h11 = DateTimeUtils.h(liveDetailBean2.startTime, "MM-dd HH:mm");
                            String e11 = he.b.e(String.valueOf(liveDetailBean2.appointedNum));
                            d0 d0Var2 = d0.f56774a;
                            aVar.d().M.setText(String.format(str2, Arrays.copyOf(new Object[]{h11, e11}, 2)));
                        } else {
                            aVar.d().F.setImageResource(R$drawable.ic_live_playback);
                            TextView textView2 = aVar.d().M;
                            d0 d0Var3 = d0.f56774a;
                            if (context == null || (str = context.getString(R$string.n_content_live_watched)) == null) {
                                str = "%s";
                            }
                            Object[] objArr = new Object[1];
                            objArr[0] = he.b.e(liveDetailBean2 != null ? liveDetailBean2.onlineNum : null);
                            textView2.setText(String.format(str, Arrays.copyOf(objArr, 1)));
                        }
                        aVar.d().F.setVisibility(0);
                        aVar.d().L.setVisibility(8);
                    }
                    aVar.d().K.setVisibility(0);
                }
            } else {
                try {
                    ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) aVar.d().G.getLayoutParams();
                    if (layoutParams2 != null) {
                        layoutParams2.H = "W,343:220";
                    }
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
                aVar.d().K.setVisibility(8);
            }
            com.hbg.module.libkt.base.ext.b.H(aVar.d().G, listBean.getShareImage(), com.hbg.module.libkt.base.ext.b.p(context, R$attr.ic_community_feed_placeholder), 0, 0, 0, 28, (Object) null);
            aVar.d().E.setVisibility(0);
            aVar.d().G.setVisibility(0);
        }
        s sVar6 = s.f23381a;
        View a11 = aVar.a();
        a11.setOnClickListener(new g(a11, 800, this, listBean));
    }

    /* renamed from: u0 */
    public void h(CommunityBaseCommonBinder.a aVar) {
        super.h(aVar);
        rj.b c11 = ((a) aVar.f()).c();
        if (c11 != null) {
            c11.B();
        }
    }
}
