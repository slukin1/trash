package id;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.module.huobi.im.R$drawable;
import com.hbg.module.huobi.im.R$id;
import com.hbg.module.huobi.im.R$layout;
import com.hbg.module.huobi.im.R$string;
import com.hbg.module.huobi.im.gift.bean.JackpotBean;
import com.hbg.module.huobi.im.gift.bean.Property;
import i6.n;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.d0;
import kotlin.ranges.h;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;

public final class k extends RecyclerView.Adapter<a> {

    /* renamed from: a  reason: collision with root package name */
    public final Context f22814a;

    /* renamed from: b  reason: collision with root package name */
    public final List<JackpotBean> f22815b;

    public final class a extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public final ImageView f22816a;

        /* renamed from: b  reason: collision with root package name */
        public final TextView f22817b;

        /* renamed from: c  reason: collision with root package name */
        public final TextView f22818c;

        /* renamed from: d  reason: collision with root package name */
        public final TextView f22819d;

        public a(View view) {
            super(view);
            this.f22816a = (ImageView) view.findViewById(R$id.ivItemGiftOpen);
            this.f22817b = (TextView) view.findViewById(R$id.tvItemGiftOpenContent);
            this.f22818c = (TextView) view.findViewById(R$id.tvItemGiftOpenValue);
            this.f22819d = (TextView) view.findViewById(R$id.tvLiveGiftOpenCount);
        }

        public final ImageView e() {
            return this.f22816a;
        }

        public final TextView f() {
            return this.f22817b;
        }

        public final TextView g() {
            return this.f22819d;
        }

        public final TextView h() {
            return this.f22818c;
        }
    }

    public k(Context context, List<JackpotBean> list) {
        this.f22814a = context;
        this.f22815b = list;
    }

    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i11) {
        int i12;
        JackpotBean jackpotBean = this.f22815b.get(i11);
        Property property = jackpotBean.getProperty();
        String currency = jackpotBean.getProperty().getCurrency();
        Integer num = null;
        property.setCurrency(currency != null ? currency.toUpperCase(Locale.ROOT) : null);
        int i13 = 0;
        aVar.g().setVisibility(0);
        int type = jackpotBean.getType();
        if (type == 1) {
            i13 = R$drawable.im_icon_draw_succ_1;
            aVar.f().setText(jackpotBean.getProperty().getCurrency());
            aVar.h().setText(jackpotBean.getCount());
            aVar.g().setVisibility(8);
        } else if (type == 2) {
            i13 = R$drawable.im_icon_draw_succ_2;
            aVar.f().setText(jackpotBean.getProperty().getCurrency());
            aVar.h().setText(jackpotBean.getProperty().getValue() + Matrix.MATRIX_TYPE_RANDOM_UT);
        } else if (type == 3) {
            i13 = R$drawable.im_icon_draw_succ_3;
            Integer type2 = jackpotBean.getProperty().getType();
            if (type2 != null && type2.intValue() == 1) {
                aVar.f().setText(this.f22814a.getResources().getString(R$string.n_content_live_myGif_timePoint));
            } else {
                aVar.f().setText(this.f22814a.getResources().getString(R$string.n_content_live_myGif_forverPoint));
            }
            aVar.f().setText(jackpotBean.getProperty().getCurrency());
            aVar.h().setText(jackpotBean.getProperty().getValue() + Matrix.MATRIX_TYPE_RANDOM_UT);
        } else if (type == 4) {
            aVar.f().setText(jackpotBean.getProperty().getCurrency());
            aVar.h().setText(jackpotBean.getProperty().getRate() + '%');
            i13 = R$drawable.im_icon_draw_succ_4;
        } else if (type != 12) {
            switch (type) {
                case 14:
                    aVar.f().setText(jackpotBean.getProperty().getAmount() + "USDT" + this.f22814a.getResources().getString(R$string.n_contract_coupon_alert_title));
                    aVar.h().setText("");
                    i13 = R$drawable.im_icon_draw_succ_2;
                    break;
                case 15:
                    TextView f11 = aVar.f();
                    d0 d0Var = d0.f56774a;
                    f11.setText(String.format(this.f22814a.getResources().getString(R$string.n_live_drop_experience_card), Arrays.copyOf(new Object[]{jackpotBean.getProperty().getMembershipGrade()}, 1)));
                    aVar.h().setText("");
                    String membershipGrade = jackpotBean.getProperty().getMembershipGrade();
                    if (membershipGrade != null) {
                        num = Integer.valueOf(Integer.parseInt(membershipGrade));
                    }
                    if (num != null && new h(1, 3).h(num.intValue())) {
                        i12 = R$drawable.im_icon_draw_succ_15_1_3;
                    } else {
                        if (num != null && new h(4, 5).h(num.intValue())) {
                            i12 = R$drawable.im_icon_draw_succ_15_4_5;
                        } else {
                            h hVar = new h(6, 8);
                            if (num != null && hVar.h(num.intValue())) {
                                i13 = 1;
                            }
                            if (i13 != 0) {
                                i12 = R$drawable.im_icon_draw_succ_15_6_8;
                            } else {
                                i12 = R$drawable.im_icon_draw_succ_15_9_11;
                            }
                        }
                    }
                    i13 = i12;
                    break;
                case 16:
                    TextView f12 = aVar.f();
                    d0 d0Var2 = d0.f56774a;
                    f12.setText(String.format(this.f22814a.getResources().getString(R$string.n_live_drop_discount_coupon), Arrays.copyOf(new Object[]{jackpotBean.getProperty().getAmount()}, 1)));
                    aVar.h().setText("");
                    i13 = R$drawable.im_icon_draw_succ_16;
                    break;
            }
        } else {
            aVar.f().setText(jackpotBean.getProperty().getAmount() + "USDT" + this.f22814a.getResources().getString(R$string.n_coupon_return_item_title));
            aVar.h().setText("");
            i13 = R$drawable.im_icon_draw_succ_12;
        }
        aVar.e().setImageResource(i13);
        try {
            if (jackpotBean.getType() != 1) {
                if (Integer.parseInt(jackpotBean.getCount()) >= 1) {
                    aVar.g().setText('x' + jackpotBean.getCount());
                    return;
                }
            }
            aVar.g().setVisibility(8);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    /* renamed from: c */
    public a onCreateViewHolder(ViewGroup viewGroup, int i11) {
        View inflate = View.inflate(this.f22814a, R$layout.im_item_live_gift_box_open, (ViewGroup) null);
        inflate.setLayoutParams(new ConstraintLayout.LayoutParams(-1, n.a(this.f22814a, 50.0f)));
        return new a(inflate);
    }

    public int getItemCount() {
        return this.f22815b.size();
    }
}
