package com.hbg.module.livesquare.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.network.hbg.core.bean.LiveWiningInfo;
import com.hbg.module.content.R$drawable;
import com.hbg.module.content.R$string;
import com.huobi.view.roundview.RoundTextView;
import he.c;
import java.util.Arrays;
import java.util.Map;
import kotlin.jvm.internal.d0;
import lc.o4;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;
import rd.d;

public final class c extends he.c<LiveWiningInfo.DrawDetailList, c.a<o4>> {

    /* renamed from: f  reason: collision with root package name */
    public LayoutInflater f26444f;

    public c(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        this.f26444f = LayoutInflater.from(fragmentActivity);
    }

    public long getItemId(int i11) {
        return (long) i11;
    }

    /* renamed from: k */
    public void onBindViewHolder(c.a<o4> aVar, int i11) {
        int i12;
        Object obj;
        String obj2;
        super.onBindViewHolder(aVar, i11);
        LiveWiningInfo.DrawDetailList drawDetailList = (LiveWiningInfo.DrawDetailList) g().get(i11);
        String count = drawDetailList.getCount();
        Object obj3 = null;
        boolean z11 = true;
        if ((count != null ? Float.valueOf(Float.parseFloat(count)) : null).floatValue() > 1.0f) {
            RoundTextView roundTextView = aVar.e().D;
            d0 d0Var = d0.f56774a;
            String string = f().getString(R$string.live_special_characters);
            Object[] objArr = new Object[1];
            String count2 = drawDetailList.getCount();
            objArr[0] = count2 != null ? Integer.valueOf((int) Float.parseFloat(count2)) : null;
            roundTextView.setText(String.format(string, Arrays.copyOf(objArr, 1)));
            aVar.e().D.setVisibility(0);
        } else {
            aVar.e().D.setVisibility(8);
        }
        String properties = drawDetailList.getProperties();
        if (properties != null) {
            Map<String, Object> d11 = d.f23353a.d(properties);
            int parseInt = (d11 == null || (obj = d11.get("amount")) == null || (obj2 = obj.toString()) == null) ? 0 : Integer.parseInt(obj2);
            Integer type = drawDetailList.getType();
            if (type != null && type.intValue() == 1) {
                if (d11 != null) {
                    obj3 = d11.get(FirebaseAnalytics.Param.CURRENCY);
                }
                aVar.e().C.setText(String.valueOf(obj3));
                aVar.e().B.setImageResource(R$drawable.im_icon_draw_succ_1);
            } else if (type != null && type.intValue() == 2) {
                Object obj4 = d11 != null ? d11.get(FirebaseAnalytics.Param.CURRENCY) : null;
                if (d11 != null) {
                    obj3 = d11.get("value");
                }
                if (obj4 == null) {
                    obj4 = "";
                }
                TextView textView = aVar.e().C;
                d0 d0Var2 = d0.f56774a;
                textView.setText(String.format(f().getString(R$string.n_content_live_myGif_experience), Arrays.copyOf(new Object[]{obj4, obj3}, 2)));
                aVar.e().B.setImageResource(R$drawable.im_icon_draw_succ_2);
            } else if (type != null && type.intValue() == 3) {
                Object obj5 = d11 != null ? d11.get("value") : null;
                if (d11 != null) {
                    obj3 = d11.get("type");
                }
                if (obj3 != null) {
                    if ((obj3 instanceof Integer) && 1 == ((Number) obj3).intValue()) {
                        aVar.e().C.setText(f().getString(R$string.n_content_live_myGif_timePoint) + obj5 + Matrix.MATRIX_TYPE_RANDOM_UT);
                    } else {
                        aVar.e().C.setText(f().getString(R$string.n_content_live_myGif_forverPoint) + obj5 + Matrix.MATRIX_TYPE_RANDOM_UT);
                    }
                }
                aVar.e().B.setImageResource(R$drawable.im_icon_draw_succ_3);
            } else if (type != null && type.intValue() == 4) {
                Object obj6 = d11 != null ? d11.get("rate") : null;
                if (d11 != null) {
                    obj3 = d11.get(FirebaseAnalytics.Param.CURRENCY);
                }
                TextView textView2 = aVar.e().C;
                d0 d0Var3 = d0.f56774a;
                textView2.setText(String.format(f().getString(R$string.n_content_live_muGif_couponDes) + '%', Arrays.copyOf(new Object[]{obj3, obj6}, 2)));
                aVar.e().B.setImageResource(R$drawable.im_icon_draw_succ_4);
            } else if (type != null && type.intValue() == 12) {
                TextView textView3 = aVar.e().C;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(f().getResources().getString(R$string.n_coupon_return_item_title));
                if (d11 != null) {
                    obj3 = d11.get("amount");
                }
                sb2.append(obj3);
                sb2.append(Matrix.MATRIX_TYPE_RANDOM_UT);
                textView3.setText(sb2.toString());
                aVar.e().B.setImageResource(R$drawable.im_icon_draw_succ_12);
            } else if (type != null && type.intValue() == 14) {
                aVar.e().C.setText(f().getResources().getString(R$string.n_contract_coupon_alert_title) + parseInt + Matrix.MATRIX_TYPE_RANDOM_UT);
                aVar.e().B.setImageResource(R$drawable.im_icon_draw_succ_2);
            } else if (type != null && type.intValue() == 15) {
                if (d11 != null) {
                    try {
                        obj3 = d11.get("membershipGrade");
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                        return;
                    }
                }
                Double d12 = (Double) obj3;
                int doubleValue = d12 != null ? (int) d12.doubleValue() : 1;
                TextView textView4 = aVar.e().C;
                d0 d0Var4 = d0.f56774a;
                textView4.setText(String.format(f().getResources().getString(R$string.n_live_drop_experience_card), Arrays.copyOf(new Object[]{String.valueOf(doubleValue)}, 1)));
                ImageView imageView = aVar.e().B;
                if (1 <= doubleValue && doubleValue < 4) {
                    i12 = R$drawable.im_icon_draw_succ_15_1_3;
                } else {
                    if (4 <= doubleValue && doubleValue < 6) {
                        i12 = R$drawable.im_icon_draw_succ_15_4_5;
                    } else {
                        if (6 > doubleValue || doubleValue >= 9) {
                            z11 = false;
                        }
                        if (z11) {
                            i12 = R$drawable.im_icon_draw_succ_15_6_8;
                        } else {
                            i12 = R$drawable.im_icon_draw_succ_15_9_11;
                        }
                    }
                }
                imageView.setImageResource(i12);
            } else if (type != null && type.intValue() == 16) {
                try {
                    TextView textView5 = aVar.e().C;
                    d0 d0Var5 = d0.f56774a;
                    textView5.setText(String.format(f().getResources().getString(R$string.n_live_drop_discount_coupon), Arrays.copyOf(new Object[]{Integer.valueOf(parseInt)}, 1)));
                    aVar.e().B.setImageResource(R$drawable.im_icon_draw_succ_16);
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
            }
        }
    }

    /* renamed from: l */
    public c.a<o4> onCreateViewHolder(ViewGroup viewGroup, int i11) {
        return new c.a<>(o4.K(this.f26444f, viewGroup, false));
    }
}
