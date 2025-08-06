package ef;

import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.network.hbg.core.bean.LiveDetailBean;
import com.hbg.lib.network.hbg.core.bean.LivePlayingData;
import com.hbg.lib.network.hbg.core.bean.LiveSpeaker;
import com.hbg.lib.network.hbg.core.bean.LiveSquareBaseData;
import com.hbg.lib.network.hbg.core.bean.LiveStream;
import com.hbg.lib.widgets.SafeLottieView;
import com.hbg.module.content.R$color;
import com.hbg.module.content.R$drawable;
import com.hbg.module.content.R$id;
import com.hbg.module.content.R$string;
import com.hbg.module.livesquare.adapter.e;
import com.hbg.module.livesquare.custom.FloatMsgView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.live2.V2TXLiveDef;
import com.tencent.live2.V2TXLivePlayer;
import com.tencent.live2.impl.V2TXLivePlayerImpl;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.wtree.helper.Utils;
import ef.b;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class g extends b {
    public int A = 4;
    public int B = 3;
    public int C = 9;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f28907b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f28908c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f28909d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f28910e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f28911f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f28912g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f28913h;

    /* renamed from: i  reason: collision with root package name */
    public SafeLottieView f28914i;

    /* renamed from: j  reason: collision with root package name */
    public LinearLayout f28915j;

    /* renamed from: k  reason: collision with root package name */
    public LinearLayout f28916k;

    /* renamed from: l  reason: collision with root package name */
    public ImageView f28917l;

    /* renamed from: m  reason: collision with root package name */
    public SafeLottieView f28918m;

    /* renamed from: n  reason: collision with root package name */
    public FloatMsgView f28919n;

    /* renamed from: o  reason: collision with root package name */
    public TXCloudVideoView f28920o;

    /* renamed from: p  reason: collision with root package name */
    public LinearLayout f28921p;

    /* renamed from: q  reason: collision with root package name */
    public TextView f28922q;

    /* renamed from: r  reason: collision with root package name */
    public TextView f28923r;

    /* renamed from: s  reason: collision with root package name */
    public TextView f28924s;

    /* renamed from: t  reason: collision with root package name */
    public TextView f28925t;

    /* renamed from: u  reason: collision with root package name */
    public SimpleDateFormat f28926u;

    /* renamed from: v  reason: collision with root package name */
    public V2TXLivePlayer f28927v = null;

    /* renamed from: w  reason: collision with root package name */
    public e.a f28928w;

    /* renamed from: x  reason: collision with root package name */
    public CountDownTimer f28929x;

    /* renamed from: y  reason: collision with root package name */
    public int f28930y = 0;

    /* renamed from: z  reason: collision with root package name */
    public int f28931z;

    public class a implements com.hbg.module.content.utls.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LiveDetailBean f28932a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f28933b;

        public a(LiveDetailBean liveDetailBean, long j11) {
            this.f28932a = liveDetailBean;
            this.f28933b = j11;
        }

        public void a() {
            g.this.f28921p.setVisibility(8);
        }

        public void b(long j11) {
            LiveDetailBean liveDetailBean = this.f28932a;
            liveDetailBean.currentTime = (liveDetailBean.currentTime - this.f28933b) + j11;
        }
    }

    public class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LiveDetailBean f28935b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b.a f28936c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ LiveSquareBaseData f28937d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f28938e;

        public b(LiveDetailBean liveDetailBean, b.a aVar, LiveSquareBaseData liveSquareBaseData, int i11) {
            this.f28935b = liveDetailBean;
            this.f28936c = aVar;
            this.f28937d = liveSquareBaseData;
            this.f28938e = i11;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            boolean z11 = true;
            if (this.f28935b.appointed != 1) {
                z11 = false;
            }
            if (!z11) {
                b.a aVar = this.f28936c;
                if (aVar != null) {
                    aVar.a(this.f28937d, 103, this.f28938e);
                }
            } else {
                b.a aVar2 = this.f28936c;
                if (aVar2 != null) {
                    aVar2.a(this.f28937d, 104, this.f28938e);
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.a f28940b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ LiveSquareBaseData f28941c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f28942d;

        public c(b.a aVar, LiveSquareBaseData liveSquareBaseData, int i11) {
            this.f28940b = aVar;
            this.f28941c = liveSquareBaseData;
            this.f28942d = i11;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            b.a aVar = this.f28940b;
            if (aVar != null) {
                aVar.a(this.f28941c, 101, this.f28942d);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class d implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.a f28944b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ LiveSquareBaseData f28945c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f28946d;

        public d(b.a aVar, LiveSquareBaseData liveSquareBaseData, int i11) {
            this.f28944b = aVar;
            this.f28945c = liveSquareBaseData;
            this.f28946d = i11;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            b.a aVar = this.f28944b;
            if (aVar != null) {
                aVar.a(this.f28945c, 102, this.f28946d);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class e implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.a f28948b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ LiveSquareBaseData f28949c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f28950d;

        public e(b.a aVar, LiveSquareBaseData liveSquareBaseData, int i11) {
            this.f28948b = aVar;
            this.f28949c = liveSquareBaseData;
            this.f28950d = i11;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            b.a aVar = this.f28948b;
            if (aVar != null) {
                aVar.a(this.f28949c, 102, this.f28950d);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public g(View view) {
        super(view);
        this.f28907b = (ImageView) view.findViewById(R$id.iv_cover);
        this.f28908c = (TextView) view.findViewById(R$id.tv_live_type);
        this.f28909d = (TextView) view.findViewById(R$id.tv_play_time);
        this.f28910e = (TextView) view.findViewById(R$id.tv_live_title);
        this.f28911f = (TextView) view.findViewById(R$id.tv_name);
        this.f28913h = (ImageView) view.findViewById(R$id.iv_icon);
        this.f28914i = (SafeLottieView) view.findViewById(R$id.iv_live_playing);
        this.f28915j = (LinearLayout) view.findViewById(R$id.ll_live_hint);
        this.f28912g = (TextView) view.findViewById(R$id.tv_prepare);
        this.f28916k = (LinearLayout) view.findViewById(R$id.ll_into);
        this.f28917l = (ImageView) view.findViewById(R$id.iv_into);
        this.f28918m = (SafeLottieView) view.findViewById(R$id.slvRise);
        this.f28919n = (FloatMsgView) view.findViewById(R$id.fmView);
        this.f28920o = (TXCloudVideoView) view.findViewById(R$id.txCloudView);
        this.f28921p = (LinearLayout) view.findViewById(R$id.llCountDown);
        this.f28922q = (TextView) view.findViewById(R$id.tvDay);
        this.f28923r = (TextView) view.findViewById(R$id.tvHour);
        this.f28924s = (TextView) view.findViewById(R$id.tvMinute);
        this.f28925t = (TextView) view.findViewById(R$id.tvSecond);
        this.f28926u = new SimpleDateFormat("MM-dd HH:mm ");
        this.f28931z = Utils.a(this.f28903a, 0.5f);
        this.B = Utils.a(this.f28903a, 3.0f);
        this.A = Utils.a(this.f28903a, 4.0f);
        this.C = Utils.a(this.f28903a, 9.0f);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void o(b.a aVar, LiveSquareBaseData liveSquareBaseData, int i11, View view) {
        if (aVar != null) {
            aVar.a(liveSquareBaseData, 100, i11);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void p(b.a aVar, LiveSquareBaseData liveSquareBaseData, int i11, View view) {
        if (aVar != null) {
            aVar.a(liveSquareBaseData, 100, i11);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void b(LiveSquareBaseData liveSquareBaseData, int i11, b.a aVar) {
        int moduleType = liveSquareBaseData.getModuleType();
        if (moduleType == 2) {
            l(liveSquareBaseData, i11, aVar);
        } else if (moduleType == 4) {
            m(liveSquareBaseData, i11, aVar);
        } else if (moduleType == 5) {
            k(liveSquareBaseData, i11, aVar);
        }
    }

    public final void k(LiveSquareBaseData liveSquareBaseData, int i11, b.a aVar) {
        LiveSpeaker liveSpeaker;
        if (liveSquareBaseData instanceof LiveDetailBean) {
            LiveDetailBean liveDetailBean = (LiveDetailBean) liveSquareBaseData;
            if (liveSquareBaseData.getViewType() == 3) {
                com.hbg.module.libkt.base.ext.b.M(this.f28907b, liveDetailBean.coverImageUrl, 8.0f, f());
                this.f28919n.f();
                this.f28919n.setVisibility(8);
            } else if (liveSquareBaseData.getViewType() == 4) {
                com.hbg.module.libkt.base.ext.b.M(this.f28907b, liveDetailBean.coverImageUrl, 8.0f, e());
            }
            this.f28917l.setVisibility(0);
            r(this.f28908c, this.f28903a.getString(R$string.n_content_live_watched), he.b.e(liveDetailBean.onlineNum));
            this.f28914i.setVisibility(8);
            this.f28910e.setText(liveDetailBean.title);
            this.f28915j.setBackgroundResource(R$drawable.bg_live_playback_tips);
            int color = ContextCompat.getColor(this.f28903a, R$color.color_12B298);
            this.f28916k.setBackgroundResource(R$drawable.bg_live_into_btn);
            if (liveSquareBaseData.getViewType() == 3) {
                this.f28909d.setVisibility(8);
                this.f28920o.setVisibility(8);
                this.f28921p.setVisibility(8);
            } else {
                this.f28918m.setVisibility(8);
                this.f28912g.setTextColor(color);
                this.f28909d.setVisibility(0);
                Date date = new Date(liveDetailBean.startTime);
                TextView textView = this.f28909d;
                textView.setText(this.f28926u.format(date) + this.f28903a.getString(R$string.n_live_start_playing));
                this.f28910e.setTextColor(ContextCompat.getColor(this.f28903a, R$color.baseColorPrimaryText));
                this.f28911f.setTextColor(ContextCompat.getColor(this.f28903a, R$color.baseColorSecondaryText));
            }
            this.f28912g.setText(this.f28903a.getString(R$string.n_live_look_playback));
            List<LiveSpeaker> list = liveDetailBean.speakerList;
            if (!(list == null || list.size() <= 0 || (liveSpeaker = list.get(0)) == null)) {
                this.f28911f.setText(liveSpeaker.nickname);
                com.hbg.module.libkt.base.ext.b.K(this.f28913h, liveSpeaker.avatar, g());
            }
            this.f28912g.setOnClickListener(new d(aVar, liveSquareBaseData, i11));
            this.itemView.setOnClickListener(new e(aVar, liveSquareBaseData, i11));
        }
    }

    public final void l(LiveSquareBaseData liveSquareBaseData, int i11, b.a aVar) {
        LiveSpeaker liveSpeaker;
        if (liveSquareBaseData instanceof LiveDetailBean) {
            LiveDetailBean liveDetailBean = (LiveDetailBean) liveSquareBaseData;
            if (liveSquareBaseData.getViewType() == 3) {
                com.hbg.module.libkt.base.ext.b.M(this.f28907b, liveDetailBean.coverImageUrl, 8.0f, f());
            } else if (liveSquareBaseData.getViewType() == 4) {
                com.hbg.module.libkt.base.ext.b.M(this.f28907b, liveDetailBean.coverImageUrl, 8.0f, e());
            }
            r(this.f28908c, this.f28903a.getString(R$string.n_content_live_watch), he.b.e(liveDetailBean.onlineNum));
            this.f28914i.setVisibility(0);
            this.f28910e.setText(liveDetailBean.title);
            this.f28915j.setBackgroundResource(R$drawable.bg_live_broadcast_tips);
            int color = ContextCompat.getColor(this.f28903a, R$color.color_12B298);
            this.f28916k.setBackgroundResource(R$drawable.bg_live_into_btn);
            if (liveSquareBaseData.getViewType() == 3) {
                this.f28921p.setVisibility(8);
                ArrayList<LivePlayingData.FloatMsg> arrayList = ((LiveDetailBean) liveSquareBaseData).msgList;
                if (arrayList == null || arrayList.size() <= 0) {
                    this.f28919n.f();
                    this.f28919n.setVisibility(8);
                } else {
                    this.f28919n.setVisibility(0);
                    this.f28919n.setFloatMsgs(arrayList);
                }
                LiveStream liveStream = liveDetailBean.downStreamAddr;
                if (liveStream != null) {
                    if (com.hbg.module.libkt.base.ext.b.x(liveStream.f70257sd)) {
                        this.f28920o.onDestroy();
                        this.f28920o.setVisibility(8);
                        this.f28927v.stopPlay();
                        this.f28927v = null;
                    } else {
                        this.f28920o.setVisibility(0);
                        se.d.x(this.f28920o, (float) com.hbg.module.libkt.base.ext.c.a(8.0f));
                        V2TXLivePlayer v2TXLivePlayer = this.f28927v;
                        if (v2TXLivePlayer != null) {
                            v2TXLivePlayer.stopPlay();
                            this.f28927v = null;
                        }
                        V2TXLivePlayerImpl v2TXLivePlayerImpl = new V2TXLivePlayerImpl(this.f28903a);
                        this.f28927v = v2TXLivePlayerImpl;
                        v2TXLivePlayerImpl.setRenderView(this.f28920o);
                        this.f28927v.setRenderFillMode(V2TXLiveDef.V2TXLiveFillMode.V2TXLiveFillModeFit);
                        this.f28927v.pauseAudio();
                        e.a aVar2 = this.f28928w;
                        if (aVar2 != null) {
                            aVar2.a(i11, this.f28927v);
                        }
                        this.f28927v.startLivePlay(liveDetailBean.downStreamAddr.f70257sd);
                    }
                }
            } else {
                if (liveSquareBaseData.getRealPos() == 1) {
                    this.f28918m.setVisibility(0);
                } else {
                    this.f28918m.setVisibility(8);
                }
                this.f28917l.setImageResource(R$drawable.icon_arrow_green_right);
                this.f28912g.setTextColor(color);
                this.f28910e.setTextColor(ContextCompat.getColor(this.f28903a, R$color.baseColorPrimaryText));
                this.f28911f.setTextColor(ContextCompat.getColor(this.f28903a, R$color.baseColorSecondaryText));
            }
            this.f28912g.setOnClickListener(new f(aVar, liveSquareBaseData, i11));
            this.f28917l.setVisibility(0);
            this.f28912g.setText(this.f28903a.getString(R$string.n_live_look_live));
            this.f28909d.setVisibility(8);
            List<LiveSpeaker> list = liveDetailBean.speakerList;
            if (!(list == null || list.size() <= 0 || (liveSpeaker = list.get(0)) == null)) {
                this.f28911f.setText(liveSpeaker.nickname);
                com.hbg.module.libkt.base.ext.b.K(this.f28913h, liveSpeaker.avatar, g());
            }
            this.itemView.setOnClickListener(new e(aVar, liveSquareBaseData, i11));
        }
    }

    public final void m(LiveSquareBaseData liveSquareBaseData, int i11, b.a aVar) {
        LiveSpeaker liveSpeaker;
        LiveSquareBaseData liveSquareBaseData2 = liveSquareBaseData;
        if (liveSquareBaseData2 instanceof LiveDetailBean) {
            LiveDetailBean liveDetailBean = (LiveDetailBean) liveSquareBaseData2;
            if (liveSquareBaseData.getViewType() == 3) {
                com.hbg.module.libkt.base.ext.b.M(this.f28907b, liveDetailBean.coverImageUrl, 8.0f, f());
                this.f28919n.f();
                this.f28919n.setVisibility(8);
            } else if (liveSquareBaseData.getViewType() == 4) {
                com.hbg.module.libkt.base.ext.b.M(this.f28907b, liveDetailBean.coverImageUrl, 8.0f, e());
            }
            this.f28914i.setVisibility(8);
            this.f28910e.setText(liveDetailBean.title);
            this.f28915j.setBackgroundResource(R$drawable.bg_live_playback_tips);
            List<LiveSpeaker> list = liveDetailBean.speakerList;
            boolean z11 = false;
            if (!(list == null || list.size() <= 0 || (liveSpeaker = list.get(0)) == null)) {
                this.f28911f.setText(liveSpeaker.nickname);
                com.hbg.module.libkt.base.ext.b.K(this.f28913h, liveSpeaker.avatar, g());
            }
            this.f28912g.setVisibility(0);
            Date date = new Date(liveDetailBean.startTime);
            if (liveSquareBaseData.getViewType() == 3) {
                r(this.f28908c, this.f28903a.getString(R$string.n_content_live_play_time), this.f28926u.format(date), he.b.e(((LiveDetailBean) liveSquareBaseData2).appointedNum + ""));
                this.f28909d.setVisibility(8);
                this.f28920o.setVisibility(8);
                long j11 = liveDetailBean.startTime - liveDetailBean.currentTime;
                if (j11 <= 1000) {
                    this.f28921p.setVisibility(8);
                } else {
                    this.f28921p.setVisibility(0);
                    CountDownTimer countDownTimer = this.f28929x;
                    if (countDownTimer != null) {
                        countDownTimer.cancel();
                        this.f28929x = null;
                    }
                    this.f28929x = com.hbg.module.content.utls.b.a((FragmentActivity) this.f28903a, j11, this.f28922q, this.f28923r, this.f28924s, this.f28925t, new a(liveDetailBean, j11));
                }
            } else {
                this.f28918m.setVisibility(8);
                r(this.f28908c, this.f28903a.getString(R$string.n_content_live_appointment), he.b.e(((LiveDetailBean) liveSquareBaseData2).appointedNum + ""));
                this.f28909d.setVisibility(0);
                this.f28909d.setText(this.f28926u.format(date) + this.f28903a.getString(R$string.n_live_start_playing));
                this.f28910e.setTextColor(ContextCompat.getColor(this.f28903a, R$color.baseColorPrimaryText));
                this.f28911f.setTextColor(ContextCompat.getColor(this.f28903a, R$color.baseColorSecondaryText));
            }
            boolean z12 = liveDetailBean.appointed == 1;
            if (liveDetailBean.getViewType() == 3) {
                z11 = true;
            }
            n(z12, z11);
            b.a aVar2 = aVar;
            this.f28912g.setOnClickListener(new b(liveDetailBean, aVar2, liveSquareBaseData, i11));
            this.itemView.setOnClickListener(new c(aVar2, liveSquareBaseData2, i11));
        }
    }

    public final void n(boolean z11, boolean z12) {
        this.f28917l.setVisibility(8);
        if (z12) {
            if (z11) {
                this.f28912g.setText(this.f28903a.getString(R$string.n_live_already_appointment));
            } else {
                this.f28912g.setText(this.f28903a.getString(R$string.n_live_make_appointment));
            }
        } else if (z11) {
            this.f28916k.setBackgroundResource(R$color.baseColorDeepestBackground);
            this.f28912g.setText(this.f28903a.getString(R$string.n_live_already_appointment));
            this.f28912g.setTextColor(ContextCompat.getColor(this.f28903a, R$color.color_live_square_two_base));
        } else {
            this.f28916k.setBackgroundResource(R$drawable.bg_live_into_btn);
            this.f28912g.setText(this.f28903a.getString(R$string.n_live_make_appointment));
            this.f28912g.setTextColor(ContextCompat.getColor(this.f28903a, R$color.color_12B298));
        }
    }

    public void q(e.a aVar) {
        this.f28928w = aVar;
    }

    public final void r(TextView textView, String str, Object... objArr) {
        textView.setText(String.format(str, objArr));
    }
}
