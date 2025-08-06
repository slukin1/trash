package com.huobi.otc.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.util.CollectionsUtils;
import com.hbg.lite.view.OtcFloatLayout;
import com.hbg.module.otc.R$color;
import com.hbg.module.otc.R$dimen;
import com.hbg.module.otc.R$drawable;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.huobi.otc.bean.Ads;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import vp.p0;

public class PaymentGroupView extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public OtcFloatLayout f80120b;

    /* renamed from: c  reason: collision with root package name */
    public int f80121c = -1;

    /* renamed from: d  reason: collision with root package name */
    public a f80122d;

    public interface a {
        void a(Ads.PaymentInfo paymentInfo);
    }

    public PaymentGroupView(Context context) {
        super(context);
        b(context);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(Ads.PaymentInfo paymentInfo, Void voidR) {
        a aVar = this.f80122d;
        if (aVar != null) {
            aVar.a(paymentInfo);
        }
    }

    public final void b(Context context) {
        FrameLayout.inflate(context, R$layout.payment_group_view_layout, this);
        this.f80120b = (OtcFloatLayout) findViewById(R$id.id_payment_group_view);
    }

    public final void d(int i11, String str, int i12) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.f80120b.addView(linearLayout, new ViewGroup.LayoutParams(-2, -2));
        linearLayout.setGravity(21);
        linearLayout.setOrientation(0);
        View view = new View(getContext());
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(PixelUtils.a(4.0f), PixelUtils.a(4.0f));
        view.setBackgroundResource(R$drawable.shape_payment_circle_bg);
        linearLayout.addView(view, layoutParams);
        TextView textView = new TextView(getContext());
        textView.setTextSize(0, (float) i12);
        textView.setTextColor(ContextCompat.getColor(getContext(), R$color.baseColorSecondaryText));
        textView.setPadding(PixelUtils.a(4.0f), 0, 0, 0);
        linearLayout.addView(textView, new ViewGroup.LayoutParams(-2, -2));
        ((GradientDrawable) view.getBackground()).setColor(i11);
        textView.setText(str);
    }

    public final void e(Ads.PaymentInfo paymentInfo, int i11, String str, boolean z11) {
        int i12;
        int i13;
        LinearLayout linearLayout = (LinearLayout) View.inflate(getContext(), R$layout.item_order_payment, (ViewGroup) null);
        this.f80120b.addView(linearLayout);
        linearLayout.findViewById(R$id.view_divide).setBackgroundColor(i11);
        TextView textView = (TextView) linearLayout.findViewById(R$id.tv_order_payment_name);
        if (z11) {
            i12 = ContextCompat.getColor(getContext(), R$color.baseColorMajorTheme100);
        } else {
            i12 = ContextCompat.getColor(getContext(), R$color.baseColorPrimaryText);
        }
        textView.setTextColor(i12);
        textView.setText(str);
        ImageView imageView = (ImageView) linearLayout.findViewById(R$id.iv_selected);
        if (z11) {
            i13 = R$drawable.otc_payment_icon_selected;
        } else {
            i13 = R$drawable.otc_payment_icon_unselected;
        }
        imageView.setImageResource(i13);
        dw.a.a(linearLayout).throttleFirst(200, TimeUnit.MILLISECONDS).subscribe(new p0(this, paymentInfo));
    }

    public void f(List<Ads.PaymentInfo> list, boolean z11, Ads.PaymentInfo paymentInfo) {
        int i11;
        this.f80120b.removeAllViews();
        int i12 = this.f80121c;
        if (i12 != -1) {
            this.f80120b.setGravity(i12);
        }
        if (CollectionsUtils.b(list)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        Iterator<Ads.PaymentInfo> it2 = list.iterator();
        while (it2.hasNext()) {
            Ads.PaymentInfo next = it2.next();
            try {
                i11 = Color.parseColor(next.getColor());
            } catch (Exception unused) {
                i11 = getResources().getColor(R$color.baseColorMajorTheme100);
            }
            if (z11) {
                e(next, i11, next.getName(), paymentInfo == next);
            } else {
                d(i11, next.getName(), getContext().getResources().getDimensionPixelSize(R$dimen.global_text_size_11));
            }
        }
    }

    public void setChildGravity(int i11) {
        this.f80121c = i11;
    }

    public void setPaymentClickCallBack(a aVar) {
        this.f80122d = aVar;
    }

    public void setPaymentInfos(List<Ads.PaymentInfo> list) {
        f(list, false, (Ads.PaymentInfo) null);
    }

    public PaymentGroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context);
    }

    public PaymentGroupView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        b(context);
    }
}
