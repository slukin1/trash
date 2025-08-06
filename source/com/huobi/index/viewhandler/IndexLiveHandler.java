package com.huobi.index.viewhandler;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.hbg.lib.network.hbg.core.bean.LiveDetailBean;
import com.hbg.lib.network.hbg.core.bean.LiveSpeaker;
import com.hbg.lib.network.hbg.core.bean.LiveSquareBaseData;
import com.hbg.lib.widgets.SafeLottieView;
import com.hbg.module.livesquare.utils.LiveTrackUtils;
import com.huobi.index.bean.IndexLiveItem;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import ef.b;
import i6.r;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import pro.huobi.R;

public class IndexLiveHandler extends IndexLiveBaseHandler {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f74125b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f74126c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f74127d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f74128e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f74129f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f74130g;

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f74131h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f74132i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f74133j;

    /* renamed from: k  reason: collision with root package name */
    public ImageView f74134k;

    /* renamed from: l  reason: collision with root package name */
    public SafeLottieView f74135l;

    /* renamed from: m  reason: collision with root package name */
    public LinearLayout f74136m;

    /* renamed from: n  reason: collision with root package name */
    public SimpleDateFormat f74137n;

    /* renamed from: o  reason: collision with root package name */
    public Context f74138o;

    /* renamed from: p  reason: collision with root package name */
    public b.a f74139p;

    /* renamed from: q  reason: collision with root package name */
    public View f74140q;

    /* renamed from: r  reason: collision with root package name */
    public int f74141r = 4;

    public class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.a f74142b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ LiveSquareBaseData f74143c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f74144d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LiveDetailBean f74145e;

        public a(b.a aVar, LiveSquareBaseData liveSquareBaseData, int i11, LiveDetailBean liveDetailBean) {
            this.f74142b = aVar;
            this.f74143c = liveSquareBaseData;
            this.f74144d = i11;
            this.f74145e = liveDetailBean;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            b.a aVar = this.f74142b;
            if (aVar != null) {
                aVar.a(this.f74143c, 100, this.f74144d);
            }
            LiveTrackUtils.a("homelive_button_click", 2, this.f74145e.f70249id, Integer.valueOf(this.f74144d + 1), (Object) null);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.a f74147b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ LiveSquareBaseData f74148c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f74149d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LiveDetailBean f74150e;

        public b(b.a aVar, LiveSquareBaseData liveSquareBaseData, int i11, LiveDetailBean liveDetailBean) {
            this.f74147b = aVar;
            this.f74148c = liveSquareBaseData;
            this.f74149d = i11;
            this.f74150e = liveDetailBean;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            b.a aVar = this.f74147b;
            if (aVar != null) {
                aVar.a(this.f74148c, 100, this.f74149d);
            }
            LiveTrackUtils.a("homelive_item_click", 2, this.f74150e.f70249id, Integer.valueOf(this.f74149d + 1), (Object) null);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LiveDetailBean f74152b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b.a f74153c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ LiveSquareBaseData f74154d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f74155e;

        public c(LiveDetailBean liveDetailBean, b.a aVar, LiveSquareBaseData liveSquareBaseData, int i11) {
            this.f74152b = liveDetailBean;
            this.f74153c = aVar;
            this.f74154d = liveSquareBaseData;
            this.f74155e = i11;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            if (!(this.f74152b.appointed == 1)) {
                b.a aVar = this.f74153c;
                if (aVar != null) {
                    aVar.a(this.f74154d, 103, this.f74155e);
                    LiveTrackUtils.a("homelive_button_click", 1, this.f74152b.f70249id, Integer.valueOf(this.f74155e + 1), (Object) null);
                }
            } else {
                b.a aVar2 = this.f74153c;
                if (aVar2 != null) {
                    aVar2.a(this.f74154d, 104, this.f74155e);
                    LiveTrackUtils.a("homelive_button_click", 0, this.f74152b.f70249id, Integer.valueOf(this.f74155e + 1), (Object) null);
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class d implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.a f74157b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ LiveSquareBaseData f74158c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f74159d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LiveDetailBean f74160e;

        public d(b.a aVar, LiveSquareBaseData liveSquareBaseData, int i11, LiveDetailBean liveDetailBean) {
            this.f74157b = aVar;
            this.f74158c = liveSquareBaseData;
            this.f74159d = i11;
            this.f74160e = liveDetailBean;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            b.a aVar = this.f74157b;
            if (aVar != null) {
                aVar.a(this.f74158c, 101, this.f74159d);
            }
            if (!(this.f74160e.appointed == 1)) {
                LiveTrackUtils.a("homelive_item_click", 1, this.f74160e.f70249id, Integer.valueOf(this.f74159d + 1), (Object) null);
            } else {
                LiveTrackUtils.a("homelive_item_click", 0, this.f74160e.f70249id, Integer.valueOf(this.f74159d + 1), (Object) null);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class e implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.a f74162b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ LiveSquareBaseData f74163c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f74164d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LiveDetailBean f74165e;

        public e(b.a aVar, LiveSquareBaseData liveSquareBaseData, int i11, LiveDetailBean liveDetailBean) {
            this.f74162b = aVar;
            this.f74163c = liveSquareBaseData;
            this.f74164d = i11;
            this.f74165e = liveDetailBean;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            b.a aVar = this.f74162b;
            if (aVar != null) {
                aVar.a(this.f74163c, 102, this.f74164d);
            }
            LiveTrackUtils.a("homelive_button_click", 3, this.f74165e.f70249id, Integer.valueOf(this.f74164d + 1), (Object) null);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class f implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.a f74167b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ LiveSquareBaseData f74168c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f74169d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LiveDetailBean f74170e;

        public f(b.a aVar, LiveSquareBaseData liveSquareBaseData, int i11, LiveDetailBean liveDetailBean) {
            this.f74167b = aVar;
            this.f74168c = liveSquareBaseData;
            this.f74169d = i11;
            this.f74170e = liveDetailBean;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            b.a aVar = this.f74167b;
            if (aVar != null) {
                aVar.a(this.f74168c, 102, this.f74169d);
            }
            LiveTrackUtils.a("homelive_item_click", 3, this.f74170e.f70249id, Integer.valueOf(this.f74169d + 1), (Object) null);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public final void e(LiveSquareBaseData liveSquareBaseData, int i11, b.a aVar) {
        LiveSpeaker liveSpeaker;
        if (liveSquareBaseData instanceof LiveDetailBean) {
            LiveDetailBean liveDetailBean = (LiveDetailBean) liveSquareBaseData;
            if (liveSquareBaseData.getViewType() == 3) {
                com.hbg.module.libkt.base.ext.b.C(this.f74125b, liveDetailBean.coverImageUrl, c());
            } else if (liveSquareBaseData.getViewType() == 4) {
                com.hbg.module.libkt.base.ext.b.C(this.f74125b, liveDetailBean.coverImageUrl, b());
            }
            this.f74126c.setText(this.f74138o.getString(R.string.n_live_playback));
            this.f74135l.setVisibility(8);
            this.f74128e.setText(liveDetailBean.title);
            k(this.f74136m, R.color.color_0066ED);
            j();
            this.f74127d.setVisibility(8);
            this.f74132i.setText(this.f74138o.getString(R.string.n_live_look_playback));
            List<LiveSpeaker> list = liveDetailBean.speakerList;
            if (!(list == null || list.size() <= 0 || (liveSpeaker = list.get(0)) == null)) {
                this.f74129f.setText(liveSpeaker.nickname);
                com.hbg.module.libkt.base.ext.b.K(this.f74134k, liveSpeaker.avatar, d());
            }
            b.a aVar2 = aVar;
            LiveSquareBaseData liveSquareBaseData2 = liveSquareBaseData;
            int i12 = i11;
            LiveDetailBean liveDetailBean2 = liveDetailBean;
            this.f74132i.setOnClickListener(new e(aVar2, liveSquareBaseData2, i12, liveDetailBean2));
            this.f74140q.setOnClickListener(new f(aVar2, liveSquareBaseData2, i12, liveDetailBean2));
        }
    }

    public final void f(LiveSquareBaseData liveSquareBaseData, int i11, b.a aVar) {
        LiveSpeaker liveSpeaker;
        if (liveSquareBaseData instanceof LiveDetailBean) {
            LiveDetailBean liveDetailBean = (LiveDetailBean) liveSquareBaseData;
            if (liveSquareBaseData.getViewType() == 3) {
                com.hbg.module.libkt.base.ext.b.M(this.f74125b, liveDetailBean.coverImageUrl, 8.0f, c());
            } else if (liveSquareBaseData.getViewType() == 4) {
                com.hbg.module.libkt.base.ext.b.M(this.f74125b, liveDetailBean.coverImageUrl, 8.0f, b());
            }
            this.f74126c.setText(this.f74138o.getString(R.string.n_live_broadcasting));
            this.f74135l.setVisibility(0);
            this.f74128e.setText(liveDetailBean.title);
            k(this.f74136m, R.color.color_FF7600);
            j();
            this.f74132i.setText(this.f74138o.getString(R.string.n_live_look_live));
            this.f74127d.setVisibility(8);
            List<LiveSpeaker> list = liveDetailBean.speakerList;
            if (!(list == null || list.size() <= 0 || (liveSpeaker = list.get(0)) == null)) {
                this.f74129f.setText(liveSpeaker.nickname);
                com.hbg.module.libkt.base.ext.b.K(this.f74134k, liveSpeaker.avatar, d());
            }
            b.a aVar2 = aVar;
            LiveSquareBaseData liveSquareBaseData2 = liveSquareBaseData;
            int i12 = i11;
            LiveDetailBean liveDetailBean2 = liveDetailBean;
            this.f74132i.setOnClickListener(new a(aVar2, liveSquareBaseData2, i12, liveDetailBean2));
            this.f74140q.setOnClickListener(new b(aVar2, liveSquareBaseData2, i12, liveDetailBean2));
        }
    }

    public final void g(LiveSquareBaseData liveSquareBaseData, int i11, b.a aVar) {
        LiveSpeaker liveSpeaker;
        if (liveSquareBaseData instanceof LiveDetailBean) {
            LiveDetailBean liveDetailBean = (LiveDetailBean) liveSquareBaseData;
            if (liveSquareBaseData.getViewType() == 3) {
                com.hbg.module.libkt.base.ext.b.C(this.f74125b, liveDetailBean.coverImageUrl, c());
            } else if (liveSquareBaseData.getViewType() == 4) {
                com.hbg.module.libkt.base.ext.b.C(this.f74125b, liveDetailBean.coverImageUrl, b());
            }
            this.f74135l.setVisibility(8);
            this.f74128e.setText(liveDetailBean.title);
            GradientDrawable gradientDrawable = (GradientDrawable) ContextCompat.getDrawable(this.f74138o, R.drawable.bg_live_corner_type);
            gradientDrawable.setColor(ContextCompat.getColor(this.f74138o, R.color.color_E603AD8F));
            this.f74136m.setBackground(gradientDrawable);
            List<LiveSpeaker> list = liveDetailBean.speakerList;
            boolean z11 = false;
            if (!(list == null || list.size() <= 0 || (liveSpeaker = list.get(0)) == null)) {
                this.f74129f.setText(liveSpeaker.nickname);
                com.hbg.module.libkt.base.ext.b.K(this.f74134k, liveSpeaker.avatar, d());
            }
            this.f74132i.setVisibility(0);
            Date date = new Date(liveDetailBean.startTime);
            this.f74126c.setText(this.f74137n.format(date) + this.f74138o.getString(R.string.n_live_start_playing));
            if (liveDetailBean.appointed == 1) {
                z11 = true;
            }
            h(z11);
            this.f74132i.setOnClickListener(new c(liveDetailBean, aVar, liveSquareBaseData, i11));
            this.f74140q.setOnClickListener(new d(aVar, liveSquareBaseData, i11, liveDetailBean));
        }
    }

    public int getResId() {
        return R.layout.item_index_live_content_one_cell;
    }

    public final void h(boolean z11) {
        if (z11) {
            GradientDrawable gradientDrawable = (GradientDrawable) ContextCompat.getDrawable(this.f74138o, R.drawable.bg_blue_btn);
            gradientDrawable.setColor(ContextCompat.getColor(this.f74138o, R.color.color_33F3F3F3));
            this.f74130g.setBackground(gradientDrawable);
            this.f74132i.setText(this.f74138o.getString(R.string.n_live_already_appointment));
            this.f74132i.setTextColor(ContextCompat.getColor(this.f74138o, R.color.white));
        } else {
            GradientDrawable gradientDrawable2 = (GradientDrawable) ContextCompat.getDrawable(this.f74138o, R.drawable.bg_blue_btn);
            gradientDrawable2.setColor(ContextCompat.getColor(this.f74138o, R.color.color_E603AD8F));
            this.f74130g.setBackground(gradientDrawable2);
            this.f74132i.setText(this.f74138o.getString(R.string.n_live_make_appointment));
            this.f74132i.setTextColor(ContextCompat.getColor(this.f74138o, R.color.white));
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f74132i.getLayoutParams();
        layoutParams.addRule(14);
        this.f74132i.setLayoutParams(layoutParams);
        this.f74133j.setVisibility(8);
    }

    /* renamed from: i */
    public void handleView(v9.c cVar, int i11, IndexLiveItem indexLiveItem, ViewGroup viewGroup) {
        r e11 = cVar.e();
        View view = cVar.itemView;
        this.f74140q = view;
        this.f74138o = view.getContext();
        this.f74125b = (ImageView) e11.b(R.id.iv_cover);
        this.f74126c = (TextView) e11.b(R.id.tv_live_type);
        this.f74127d = (TextView) e11.b(R.id.tv_play_time);
        this.f74128e = (TextView) e11.b(R.id.tv_live_title);
        this.f74131h = (RelativeLayout) e11.b(R.id.rl_title);
        this.f74129f = (TextView) e11.b(R.id.tv_name);
        this.f74134k = (ImageView) e11.b(R.id.iv_icon);
        this.f74135l = (SafeLottieView) e11.b(R.id.iv_live_playing);
        this.f74136m = (LinearLayout) e11.b(R.id.ll_live_hint);
        this.f74130g = (RelativeLayout) e11.b(R.id.rl_bottom_button);
        this.f74132i = (TextView) e11.b(R.id.tv_prepare);
        this.f74133j = (ImageView) e11.b(R.id.iv_arrow);
        this.f74137n = new SimpleDateFormat("MM-dd HH:mm ");
        this.f74139p = indexLiveItem.e();
        int i12 = indexLiveItem.d().status;
        if (i12 == 1) {
            g(indexLiveItem.d(), i11, this.f74139p);
        } else if (i12 == 2) {
            f(indexLiveItem.d(), i11, this.f74139p);
        } else if (i12 == 3) {
            e(indexLiveItem.d(), i11, this.f74139p);
        }
    }

    public final void j() {
        ((GradientDrawable) ContextCompat.getDrawable(this.f74138o, R.drawable.bg_blue_btn)).setColor(ContextCompat.getColor(this.f74138o, R.color.color_0066ED));
        this.f74130g.setBackgroundColor(ContextCompat.getColor(this.f74138o, R.color.color_0066ED));
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f74132i.getLayoutParams();
        layoutParams.removeRule(14);
        this.f74132i.setLayoutParams(layoutParams);
        this.f74132i.setTextColor(ContextCompat.getColor(this.f74138o, R.color.white));
        this.f74133j.setVisibility(0);
    }

    public final void k(View view, int i11) {
        GradientDrawable gradientDrawable = (GradientDrawable) ContextCompat.getDrawable(this.f74138o, R.drawable.bg_live_corner_type);
        gradientDrawable.setColor(ContextCompat.getColor(this.f74138o, i11));
        view.setBackground(gradientDrawable);
    }
}
