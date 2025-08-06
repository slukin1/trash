package com.hbg.lite.index.ui;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import bb.k;
import bb.l;
import bb.m;
import com.hbg.lite.R$dimen;
import com.hbg.lite.R$id;
import com.hbg.lite.R$layout;
import com.hbg.lite.index.bean.LiteIndexChatTutorialModel;
import com.hbg.lite.view.OverFlowedTextView;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import za.a;

public class LiteIndexTutorialView extends BaseHeaderItemView<LiteIndexChatTutorialModel> {

    /* renamed from: f  reason: collision with root package name */
    public OverFlowedTextView f77171f;

    /* renamed from: g  reason: collision with root package name */
    public OverFlowedTextView f77172g;

    public LiteIndexTutorialView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g(Void voidR) {
        T t11;
        if (this.f77110d != null && (t11 = this.f77109c) != null && ((LiteIndexChatTutorialModel) t11).b() != null && ((LiteIndexChatTutorialModel) this.f77109c).b().getVideoUrl() != null) {
            this.f77110d.c(((LiteIndexChatTutorialModel) this.f77109c).b());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h(Void voidR) {
        a aVar = this.f77110d;
        if (aVar != null) {
            aVar.b();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void i() {
        if (this.f77171f.d()) {
            j(this.f77171f.getResources(), this.f77171f);
        }
        if (this.f77172g.d()) {
            j(this.f77172g.getResources(), this.f77172g);
        }
    }

    public void a() {
        View b11 = this.f77111e.b(R$id.id_index_chat_fl);
        View b12 = this.f77111e.b(R$id.id_index_tutorial_fl);
        this.f77171f = (OverFlowedTextView) this.f77111e.b(R$id.lite_chat_item_title);
        this.f77172g = (OverFlowedTextView) this.f77111e.b(R$id.lite_tutorial_item_title);
        Observable<Void> a11 = dw.a.a(b12);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        a11.throttleFirst(1, timeUnit).subscribe(new m(this));
        dw.a.a(b11).throttleFirst(1, timeUnit).subscribe(new l(this));
    }

    public int getResId() {
        return R$layout.lite_index_tutorial_item;
    }

    public final void j(Resources resources, OverFlowedTextView overFlowedTextView) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) overFlowedTextView.getLayoutParams();
        layoutParams.setMarginStart(resources.getDimensionPixelOffset(R$dimen.dimen_15));
        overFlowedTextView.setLayoutParams(layoutParams);
    }

    /* renamed from: k */
    public void c(LiteIndexChatTutorialModel liteIndexChatTutorialModel) {
        if (!(liteIndexChatTutorialModel.b() == null || liteIndexChatTutorialModel.b().getCode() != 1 || liteIndexChatTutorialModel.b().getVideoTitle() == null)) {
            this.f77172g.setText(liteIndexChatTutorialModel.b().getVideoTitle());
        }
        this.f77171f.post(new k(this));
        if (liteIndexChatTutorialModel.c()) {
            liteIndexChatTutorialModel.d(false);
            ObjectAnimator.ofFloat(this, View.ALPHA, new float[]{0.0f, 1.0f}).setDuration(200).start();
        }
    }

    public LiteIndexTutorialView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
