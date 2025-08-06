package h4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.d;
import com.business.common.R$drawable;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.network.hbg.core.bean.AirdropDrawDetailBean;
import com.huochat.community.base.CommunityConstants;
import com.luck.picture.lib.config.PictureMimeType;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i4.g;
import i4.i;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.r;

public final class b extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: d  reason: collision with root package name */
    public static final c f66279d = new c((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final int f66280a;

    /* renamed from: b  reason: collision with root package name */
    public final String f66281b;

    /* renamed from: c  reason: collision with root package name */
    public final List<AirdropDrawDetailBean> f66282c;

    public static final class a extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public final g f66283a;

        public a(g gVar) {
            super(gVar.getRoot());
            this.f66283a = gVar;
        }

        public final g e() {
            return this.f66283a;
        }
    }

    /* renamed from: h4.b$b  reason: collision with other inner class name */
    public static final class C0719b extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public final i f66284a;

        public C0719b(i iVar) {
            super(iVar.getRoot());
            this.f66284a = iVar;
        }

        public final i e() {
            return this.f66284a;
        }
    }

    public static final class c {
        public c() {
        }

        public /* synthetic */ c(r rVar) {
            this();
        }
    }

    public b(int i11, String str, List<AirdropDrawDetailBean> list) {
        this.f66280a = i11;
        this.f66281b = str;
        this.f66282c = list;
    }

    @SensorsDataInstrumented
    public static final void c(b bVar, String str, String str2, View view) {
        HashMap hashMap = new HashMap();
        int i11 = bVar.f66280a;
        if (i11 == 4) {
            hashMap.put("location", "app_community_dynamic_details_sideways");
            hashMap.put(CommunityConstants.TOPIC_ID, bVar.f66281b);
        } else if (i11 == 20) {
            hashMap.put("location", "app_community_homepage_find_sideways");
        } else if (i11 == 24) {
            hashMap.put("location", "app_community_square_sideways");
        } else if (i11 == 28) {
            hashMap.put("location", "app_community_k_line_comment_sideways");
            hashMap.put(CommunityConstants.TOPIC_ID, bVar.f66281b);
        }
        hashMap.put("button_name", "trade");
        hashMap.put("coin_name", str);
        vf.a.a("app_community_award_open_pop_up_click", hashMap);
        BaseModuleConfig.a().k0("holigeit://open/v1?url=ihuobiglobal://m.hbg.com/trade/index?type=pro&symbol=" + str2 + "usdt");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public int getItemCount() {
        return this.f66282c.size();
    }

    public int getItemViewType(int i11) {
        Integer type = this.f66282c.get(i11).getType();
        return 1 == (type != null ? type.intValue() : 0) ? 1 : 2;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i11) {
        int itemViewType = getItemViewType(i11);
        AirdropDrawDetailBean airdropDrawDetailBean = this.f66282c.get(i11);
        String str = "--";
        if (itemViewType == 1) {
            if (viewHolder instanceof C0719b) {
                String property = airdropDrawDetailBean.getProperty(FirebaseAnalytics.Param.CURRENCY);
                String upperCase = property.toUpperCase(Locale.getDefault());
                String lowerCase = property.toLowerCase(Locale.getDefault());
                i e11 = ((C0719b) viewHolder).e();
                ((com.bumptech.glide.c) com.bumptech.glide.a.w(e11.B).q(BaseModuleConfig.a().j() + "/-/x/hb/p/api/contents/currency/icon/" + lowerCase + PictureMimeType.PNG).l(R$drawable.icon_airdrop_gift_default)).D0(e11.B);
                e11.C.setText(upperCase);
                AppCompatTextView appCompatTextView = e11.E;
                String count = airdropDrawDetailBean.getCount();
                if (count != null) {
                    str = count;
                }
                appCompatTextView.setText(str);
                e11.getRoot().setOnClickListener(new a(this, property, lowerCase));
            }
        } else if (viewHolder instanceof a) {
            g e12 = ((a) viewHolder).e();
            d w11 = com.bumptech.glide.a.w(e12.B);
            String awardPictureUrl = airdropDrawDetailBean.getAwardPictureUrl();
            if (awardPictureUrl == null) {
                awardPictureUrl = "";
            }
            ((com.bumptech.glide.c) w11.q(awardPictureUrl).l(R$drawable.icon_airdrop_gift_default)).D0(e12.B);
            AppCompatTextView appCompatTextView2 = e12.C;
            String title = airdropDrawDetailBean.getTitle();
            if (title == null) {
                title = str;
            }
            appCompatTextView2.setText(title);
            AppCompatTextView appCompatTextView3 = e12.D;
            String count2 = airdropDrawDetailBean.getCount();
            if (count2 != null) {
                str = count2;
            }
            appCompatTextView3.setText(str);
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
        if (i11 == 1) {
            return new C0719b(i.K(LayoutInflater.from(viewGroup.getContext()), viewGroup, false));
        }
        return new a(g.K(LayoutInflater.from(viewGroup.getContext()), viewGroup, false));
    }
}
