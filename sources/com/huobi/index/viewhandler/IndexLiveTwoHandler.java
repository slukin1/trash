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
import com.hbg.lib.common.utils.PixelUtils;
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

public class IndexLiveTwoHandler extends IndexLiveBaseHandler {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f74172b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f74173c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f74174d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f74175e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f74176f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f74177g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f74178h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f74179i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f74180j;

    /* renamed from: k  reason: collision with root package name */
    public SafeLottieView f74181k;

    /* renamed from: l  reason: collision with root package name */
    public LinearLayout f74182l;

    /* renamed from: m  reason: collision with root package name */
    public Context f74183m;

    /* renamed from: n  reason: collision with root package name */
    public SimpleDateFormat f74184n;

    /* renamed from: o  reason: collision with root package name */
    public b.a f74185o;

    /* renamed from: p  reason: collision with root package name */
    public View f74186p;

    /* renamed from: q  reason: collision with root package name */
    public int f74187q = 0;

    public class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.a f74188b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ LiveSquareBaseData f74189c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f74190d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LiveDetailBean f74191e;

        public a(b.a aVar, LiveSquareBaseData liveSquareBaseData, int i11, LiveDetailBean liveDetailBean) {
            this.f74188b = aVar;
            this.f74189c = liveSquareBaseData;
            this.f74190d = i11;
            this.f74191e = liveDetailBean;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            b.a aVar = this.f74188b;
            if (aVar != null) {
                aVar.a(this.f74189c, 100, this.f74190d);
            }
            LiveTrackUtils.a("homelive_button_click", 2, this.f74191e.f70249id, Integer.valueOf(this.f74190d + 1), (Object) null);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.a f74193b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ LiveSquareBaseData f74194c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f74195d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LiveDetailBean f74196e;

        public b(b.a aVar, LiveSquareBaseData liveSquareBaseData, int i11, LiveDetailBean liveDetailBean) {
            this.f74193b = aVar;
            this.f74194c = liveSquareBaseData;
            this.f74195d = i11;
            this.f74196e = liveDetailBean;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            b.a aVar = this.f74193b;
            if (aVar != null) {
                aVar.a(this.f74194c, 100, this.f74195d);
            }
            LiveTrackUtils.a("homelive_item_click", 2, this.f74196e.f70249id, Integer.valueOf(this.f74195d + 1), (Object) null);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LiveDetailBean f74198b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b.a f74199c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ LiveSquareBaseData f74200d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f74201e;

        public c(LiveDetailBean liveDetailBean, b.a aVar, LiveSquareBaseData liveSquareBaseData, int i11) {
            this.f74198b = liveDetailBean;
            this.f74199c = aVar;
            this.f74200d = liveSquareBaseData;
            this.f74201e = i11;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            if (!(this.f74198b.appointed == 1)) {
                b.a aVar = this.f74199c;
                if (aVar != null) {
                    aVar.a(this.f74200d, 103, this.f74201e);
                    LiveTrackUtils.a("homelive_button_click", 1, this.f74198b.f70249id, Integer.valueOf(this.f74201e + 1), (Object) null);
                }
            } else {
                b.a aVar2 = this.f74199c;
                if (aVar2 != null) {
                    aVar2.a(this.f74200d, 104, this.f74201e);
                    LiveTrackUtils.a("homelive_button_click", 0, this.f74198b.f70249id, Integer.valueOf(this.f74201e + 1), (Object) null);
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class d implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.a f74203b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ LiveSquareBaseData f74204c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f74205d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LiveDetailBean f74206e;

        public d(b.a aVar, LiveSquareBaseData liveSquareBaseData, int i11, LiveDetailBean liveDetailBean) {
            this.f74203b = aVar;
            this.f74204c = liveSquareBaseData;
            this.f74205d = i11;
            this.f74206e = liveDetailBean;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            b.a aVar = this.f74203b;
            if (aVar != null) {
                aVar.a(this.f74204c, 101, this.f74205d);
            }
            if (!(this.f74206e.appointed == 1)) {
                LiveTrackUtils.a("homelive_item_click", 1, this.f74206e.f70249id, Integer.valueOf(this.f74205d + 1), (Object) null);
            } else {
                LiveTrackUtils.a("homelive_item_click", 0, this.f74206e.f70249id, Integer.valueOf(this.f74205d + 1), (Object) null);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class e implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.a f74208b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ LiveSquareBaseData f74209c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f74210d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LiveDetailBean f74211e;

        public e(b.a aVar, LiveSquareBaseData liveSquareBaseData, int i11, LiveDetailBean liveDetailBean) {
            this.f74208b = aVar;
            this.f74209c = liveSquareBaseData;
            this.f74210d = i11;
            this.f74211e = liveDetailBean;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            b.a aVar = this.f74208b;
            if (aVar != null) {
                aVar.a(this.f74209c, 102, this.f74210d);
            }
            LiveTrackUtils.a("homelive_button_click", 3, this.f74211e.f70249id, Integer.valueOf(this.f74210d + 1), (Object) null);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class f implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.a f74213b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ LiveSquareBaseData f74214c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f74215d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LiveDetailBean f74216e;

        public f(b.a aVar, LiveSquareBaseData liveSquareBaseData, int i11, LiveDetailBean liveDetailBean) {
            this.f74213b = aVar;
            this.f74214c = liveSquareBaseData;
            this.f74215d = i11;
            this.f74216e = liveDetailBean;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            b.a aVar = this.f74213b;
            if (aVar != null) {
                aVar.a(this.f74214c, 102, this.f74215d);
            }
            LiveTrackUtils.a("homelive_item_click", 3, this.f74216e.f70249id, Integer.valueOf(this.f74215d + 1), (Object) null);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public final void e(LiveSquareBaseData liveSquareBaseData, int i11, b.a aVar) {
        LiveSpeaker liveSpeaker;
        if (liveSquareBaseData instanceof LiveDetailBean) {
            LiveDetailBean liveDetailBean = (LiveDetailBean) liveSquareBaseData;
            if (liveSquareBaseData.getViewType() == 3) {
                com.hbg.module.libkt.base.ext.b.C(this.f74172b, liveDetailBean.coverImageUrl, c());
            } else if (liveSquareBaseData.getViewType() == 4) {
                com.hbg.module.libkt.base.ext.b.C(this.f74172b, liveDetailBean.coverImageUrl, b());
            }
            this.f74173c.setText(this.f74183m.getString(R.string.n_live_playback));
            this.f74181k.setVisibility(8);
            this.f74175e.setText(liveDetailBean.title);
            k(this.f74182l, R.color.color_0066ED);
            j();
            this.f74174d.setVisibility(8);
            this.f74178h.setText(this.f74183m.getString(R.string.n_live_look_playback));
            List<LiveSpeaker> list = liveDetailBean.speakerList;
            if (!(list == null || list.size() <= 0 || (liveSpeaker = list.get(0)) == null)) {
                this.f74176f.setText(liveSpeaker.nickname);
                com.hbg.module.libkt.base.ext.b.K(this.f74180j, liveSpeaker.avatar, d());
            }
            b.a aVar2 = aVar;
            LiveSquareBaseData liveSquareBaseData2 = liveSquareBaseData;
            int i12 = i11;
            LiveDetailBean liveDetailBean2 = liveDetailBean;
            this.f74178h.setOnClickListener(new e(aVar2, liveSquareBaseData2, i12, liveDetailBean2));
            this.f74186p.setOnClickListener(new f(aVar2, liveSquareBaseData2, i12, liveDetailBean2));
        }
    }

    public final void f(LiveSquareBaseData liveSquareBaseData, int i11, b.a aVar) {
        LiveSpeaker liveSpeaker;
        if (liveSquareBaseData instanceof LiveDetailBean) {
            LiveDetailBean liveDetailBean = (LiveDetailBean) liveSquareBaseData;
            if (liveSquareBaseData.getViewType() == 3) {
                com.hbg.module.libkt.base.ext.b.M(this.f74172b, liveDetailBean.coverImageUrl, 8.0f, c());
            } else if (liveSquareBaseData.getViewType() == 4) {
                com.hbg.module.libkt.base.ext.b.M(this.f74172b, liveDetailBean.coverImageUrl, 8.0f, b());
            }
            this.f74173c.setText(this.f74183m.getString(R.string.n_live_broadcasting));
            this.f74181k.setVisibility(0);
            this.f74175e.setText(liveDetailBean.title);
            k(this.f74182l, R.color.color_FF7600);
            j();
            this.f74178h.setText(this.f74183m.getString(R.string.n_live_look_live));
            this.f74174d.setVisibility(8);
            List<LiveSpeaker> list = liveDetailBean.speakerList;
            if (!(list == null || list.size() <= 0 || (liveSpeaker = list.get(0)) == null)) {
                this.f74176f.setText(liveSpeaker.nickname);
                com.hbg.module.libkt.base.ext.b.K(this.f74180j, liveSpeaker.avatar, d());
            }
            b.a aVar2 = aVar;
            LiveSquareBaseData liveSquareBaseData2 = liveSquareBaseData;
            int i12 = i11;
            LiveDetailBean liveDetailBean2 = liveDetailBean;
            this.f74178h.setOnClickListener(new a(aVar2, liveSquareBaseData2, i12, liveDetailBean2));
            this.f74186p.setOnClickListener(new b(aVar2, liveSquareBaseData2, i12, liveDetailBean2));
        }
    }

    public final void g(LiveSquareBaseData liveSquareBaseData, int i11, b.a aVar) {
        LiveSpeaker liveSpeaker;
        if (liveSquareBaseData instanceof LiveDetailBean) {
            LiveDetailBean liveDetailBean = (LiveDetailBean) liveSquareBaseData;
            if (liveSquareBaseData.getViewType() == 3) {
                com.hbg.module.libkt.base.ext.b.C(this.f74172b, liveDetailBean.coverImageUrl, c());
            } else if (liveSquareBaseData.getViewType() == 4) {
                com.hbg.module.libkt.base.ext.b.C(this.f74172b, liveDetailBean.coverImageUrl, b());
            }
            this.f74173c.setText(this.f74183m.getString(R.string.n_live_appointment));
            this.f74181k.setVisibility(8);
            this.f74175e.setText(liveDetailBean.title);
            GradientDrawable gradientDrawable = (GradientDrawable) ContextCompat.getDrawable(this.f74183m, R.drawable.bg_live_corner_type);
            gradientDrawable.setColor(ContextCompat.getColor(this.f74183m, R.color.color_E603AD8F));
            this.f74182l.setBackground(gradientDrawable);
            List<LiveSpeaker> list = liveDetailBean.speakerList;
            boolean z11 = false;
            if (!(list == null || list.size() <= 0 || (liveSpeaker = list.get(0)) == null)) {
                this.f74176f.setText(liveSpeaker.nickname);
                com.hbg.module.libkt.base.ext.b.K(this.f74180j, liveSpeaker.avatar, d());
            }
            this.f74178h.setVisibility(0);
            Date date = new Date(liveDetailBean.startTime);
            this.f74174d.setVisibility(0);
            this.f74174d.setText(this.f74184n.format(date) + this.f74183m.getString(R.string.n_live_start_playing));
            if (liveDetailBean.appointed == 1) {
                z11 = true;
            }
            h(z11);
            this.f74178h.setOnClickListener(new c(liveDetailBean, aVar, liveSquareBaseData, i11));
            this.f74186p.setOnClickListener(new d(aVar, liveSquareBaseData, i11, liveDetailBean));
        }
    }

    public int getResId() {
        return R.layout.item_index_live_content_two_cell;
    }

    public final void h(boolean z11) {
        if (z11) {
            GradientDrawable gradientDrawable = (GradientDrawable) ContextCompat.getDrawable(this.f74183m, R.drawable.bg_blue_btn);
            gradientDrawable.setColor(ContextCompat.getColor(this.f74183m, R.color.home_live_subscribed_button_color));
            this.f74177g.setBackground(gradientDrawable);
            this.f74178h.setText(this.f74183m.getString(R.string.n_live_already_appointment));
            this.f74178h.setTextColor(ContextCompat.getColor(this.f74183m, R.color.baseColorPrimaryText));
        } else {
            GradientDrawable gradientDrawable2 = (GradientDrawable) ContextCompat.getDrawable(this.f74183m, R.drawable.bg_blue_stroke_btn);
            gradientDrawable2.setStroke(PixelUtils.a(0.5f), ContextCompat.getColor(this.f74183m, R.color.color_E603AD8F));
            this.f74177g.setBackground(gradientDrawable2);
            this.f74178h.setText(this.f74183m.getString(R.string.n_live_make_appointment));
            this.f74178h.setTextColor(ContextCompat.getColor(this.f74183m, R.color.baseColorMajorTheme100));
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f74178h.getLayoutParams();
        layoutParams.addRule(14);
        this.f74178h.setLayoutParams(layoutParams);
        this.f74179i.setVisibility(8);
    }

    /* renamed from: i */
    public void handleView(v9.c cVar, int i11, IndexLiveItem indexLiveItem, ViewGroup viewGroup) {
        r e11 = cVar.e();
        View view = cVar.itemView;
        this.f74186p = view;
        this.f74183m = view.getContext();
        this.f74172b = (ImageView) e11.b(R.id.iv_cover);
        this.f74173c = (TextView) e11.b(R.id.tv_live_type);
        this.f74174d = (TextView) e11.b(R.id.tv_play_time);
        this.f74175e = (TextView) e11.b(R.id.tv_live_title);
        this.f74176f = (TextView) e11.b(R.id.tv_name);
        this.f74180j = (ImageView) e11.b(R.id.iv_icon);
        this.f74181k = (SafeLottieView) e11.b(R.id.iv_live_playing);
        this.f74182l = (LinearLayout) e11.b(R.id.ll_live_hint);
        this.f74177g = (RelativeLayout) e11.b(R.id.rl_bottom_button);
        this.f74178h = (TextView) e11.b(R.id.tv_prepare);
        this.f74179i = (ImageView) e11.b(R.id.iv_arrow);
        this.f74184n = new SimpleDateFormat("MM-dd HH:mm ");
        this.f74185o = indexLiveItem.e();
        int i12 = indexLiveItem.d().status;
        if (i12 == 1) {
            g(indexLiveItem.d(), i11, this.f74185o);
        } else if (i12 == 2) {
            f(indexLiveItem.d(), i11, this.f74185o);
        } else if (i12 == 3) {
            e(indexLiveItem.d(), i11, this.f74185o);
        }
    }

    public final void j() {
        GradientDrawable gradientDrawable = (GradientDrawable) ContextCompat.getDrawable(this.f74183m, R.drawable.bg_blue_stroke_btn);
        gradientDrawable.setStroke(PixelUtils.a(0.5f), ContextCompat.getColor(this.f74183m, R.color.baseColorMajorTheme100));
        this.f74177g.setBackground(gradientDrawable);
        this.f74178h.setTextColor(ContextCompat.getColor(this.f74183m, R.color.baseColorMajorTheme100));
        this.f74179i.setVisibility(0);
        this.f74179i.setImageResource(R.drawable.icon_arrow_blue_right);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f74178h.getLayoutParams();
        layoutParams.removeRule(14);
        this.f74178h.setLayoutParams(layoutParams);
    }

    public final void k(View view, int i11) {
        GradientDrawable gradientDrawable = (GradientDrawable) ContextCompat.getDrawable(this.f74183m, R.drawable.bg_live_corner_type);
        gradientDrawable.setColor(ContextCompat.getColor(this.f74183m, i11));
        view.setBackground(gradientDrawable);
    }
}
