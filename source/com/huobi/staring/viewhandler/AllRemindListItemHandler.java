package com.huobi.staring.viewhandler;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.widgets.CommonCheckBox;
import com.hbg.lib.widgets.recycler.holder.BaseViewHolder;
import com.huobi.staring.ui.PriceArrowView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import es.c;
import es.d;
import es.e;
import es.f;
import es.g;
import es.h;
import i6.m;
import pro.huobi.R;

public class AllRemindListItemHandler extends BaseViewHolder<bs.a> {
    private static int translateX;
    private View btn;
    private View cancelBtn;
    private View contentLayout;
    private TextView descTv;
    private CommonCheckBox mCheckbox;
    private int mHeight;
    private PriceArrowView mIconIv;
    private Interpolator mInterpolator = new DecelerateInterpolator();
    /* access modifiers changed from: private */
    public bs.a mItem;
    private TextView mLegalTv;
    private int mPadding;
    private View parentLayout;
    private TextView titleTv;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        public void onAnimationEnd(Animator animator) {
            if (AllRemindListItemHandler.this.mItem.c() != null) {
                AllRemindListItemHandler.this.mItem.c().b(false);
            }
        }

        public void onAnimationStart(Animator animator) {
            if (AllRemindListItemHandler.this.mItem.c() != null) {
                AllRemindListItemHandler.this.mItem.c().b(true);
            }
        }
    }

    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        public void onAnimationEnd(Animator animator) {
            if (AllRemindListItemHandler.this.mItem.c() != null) {
                AllRemindListItemHandler.this.mItem.c().b(false);
            }
        }

        public void onAnimationStart(Animator animator) {
            if (AllRemindListItemHandler.this.mItem.c() != null) {
                AllRemindListItemHandler.this.mItem.c().b(true);
            }
        }
    }

    public AllRemindListItemHandler(Context context, View view) {
        super(context, view);
        this.parentLayout = view.findViewById(R.id.id_all_remind_list_item_parent);
        this.titleTv = (TextView) view.findViewById(R.id.id_all_remind_list_item_title);
        this.descTv = (TextView) view.findViewById(R.id.id_all_remind_list_item_desc);
        this.btn = view.findViewById(R.id.id_all_remind_list_item_btn);
        this.cancelBtn = view.findViewById(R.id.id_all_remind_list_item_cancel_btn);
        this.contentLayout = view.findViewById(R.id.id_all_remind_list_item_layout);
        this.mCheckbox = (CommonCheckBox) view.findViewById(R.id.id_all_remind_list_item_checkbox);
        this.mIconIv = (PriceArrowView) view.findViewById(R.id.id_all_remind_list_item_icon);
        this.mLegalTv = (TextView) view.findViewById(R.id.id_all_remind_list_item_desc_legal);
        this.mHeight = context.getResources().getDimensionPixelOffset(R.dimen.dimen_60);
        this.mPadding = context.getResources().getDimensionPixelOffset(R.dimen.dimen_15);
        if (translateX == 0) {
            this.cancelBtn.post(new h(this));
        }
    }

    private void doBind() {
        ViewGroup.LayoutParams layoutParams = this.parentLayout.getLayoutParams();
        layoutParams.height = this.mHeight;
        this.parentLayout.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.cancelBtn.getLayoutParams();
        layoutParams2.width = translateX;
        this.cancelBtn.setLayoutParams(layoutParams2);
        int d11 = this.mItem.d();
        if (d11 == 0) {
            this.cancelBtn.setTranslationX((float) translateX);
            this.contentLayout.setTranslationX(0.0f);
            this.btn.setAlpha(1.0f);
        } else if (d11 == 1) {
            this.cancelBtn.setTranslationX(0.0f);
            this.contentLayout.setTranslationX((float) (-translateX));
            this.btn.setAlpha(0.0f);
            this.btn.setOnClickListener(new c(this));
        } else if (d11 == 2) {
            this.mItem.j(1);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.cancelBtn, View.TRANSLATION_X, new float[]{(float) translateX, 0.0f});
            ofFloat.addListener(new a());
            ofFloat.setDuration(270);
            ofFloat.setInterpolator(this.mInterpolator);
            ofFloat.start();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.contentLayout, View.TRANSLATION_X, new float[]{0.0f, (float) (-translateX)});
            ofFloat2.setDuration(270);
            ofFloat2.setInterpolator(this.mInterpolator);
            ofFloat2.start();
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.btn, View.ALPHA, new float[]{1.0f, 0.0f});
            ofFloat3.setDuration(200);
            ofFloat3.setInterpolator(this.mInterpolator);
            ofFloat3.start();
            this.btn.setOnClickListener(new es.b(this));
        } else if (d11 == 3) {
            this.mItem.j(0);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.cancelBtn, View.TRANSLATION_X, new float[]{0.0f, (float) translateX});
            ofFloat4.addListener(new b());
            ofFloat4.setDuration(270);
            ofFloat4.setInterpolator(this.mInterpolator);
            ofFloat4.start();
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.contentLayout, View.TRANSLATION_X, new float[]{(float) (-translateX), 0.0f});
            ofFloat5.setDuration(270);
            ofFloat5.setInterpolator(this.mInterpolator);
            ofFloat5.start();
            ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.btn, View.ALPHA, new float[]{0.0f, 1.0f});
            ofFloat6.setDuration(200);
            ofFloat6.setInterpolator(this.mInterpolator);
            ofFloat6.start();
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$bind$1(View view) {
        if (this.mItem.c() != null) {
            this.mItem.c().d(this.mCheckbox.isChecked(), this.mItem);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$bind$2(View view) {
        if (this.mItem.c() != null) {
            this.mItem.c().i(this.mItem);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$bind$3(View view) {
        if (this.mItem.c() != null) {
            this.mItem.c().j(this.mItem);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$bind$4(View view) {
        if (this.mItem.c() != null) {
            this.mItem.c().h(this.mItem, this.parentLayout, view);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$bind$5() {
        translateX = this.cancelBtn.getWidth();
        doBind();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$doBind$6(View view) {
        if (this.mItem.c() != null) {
            this.mItem.c().i((bs.a) null);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$doBind$7(View view) {
        if (this.mItem.c() != null) {
            this.mItem.c().i((bs.a) null);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
        translateX = this.cancelBtn.getWidth();
    }

    public void bind(bs.a aVar, int i11) {
        int i12;
        if (aVar != null) {
            this.mItem = aVar;
            boolean z11 = true;
            if (aVar.c() == null || !this.mItem.c().a()) {
                ViewUtil.m(this.mCheckbox, false);
                ViewUtil.m(this.btn, true);
                i12 = this.mPadding;
            } else {
                ViewUtil.m(this.mCheckbox, true);
                ViewUtil.m(this.btn, false);
                i12 = 0;
            }
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.titleTv.getLayoutParams();
            layoutParams.leftMargin = i12;
            this.titleTv.setLayoutParams(layoutParams);
            this.mCheckbox.setChecked(this.mItem.c() != null && this.mItem.c().c(this.mItem));
            this.mCheckbox.setOnClickListener(new f(this));
            String i13 = this.mItem.i();
            this.titleTv.setText(this.mItem.c().g(this.mItem.e(), this.mItem.b(), i13));
            String m11 = this.mItem.f() != null ? m.m(this.mItem.f(), this.mItem.c().e(this.mItem.e(), this.mItem.b(), i13)) : "--";
            this.descTv.setText(m11);
            this.mLegalTv.setText(this.mItem.c().k(this.mItem.e(), this.mItem.b(), m11, i13));
            PriceArrowView priceArrowView = this.mIconIv;
            if (1 != this.mItem.g()) {
                z11 = false;
            }
            priceArrowView.c(z11);
            this.parentLayout.setOnClickListener(new d(this));
            this.btn.setOnClickListener(new e(this));
            this.cancelBtn.setOnClickListener(new es.a(this));
            if (translateX == 0) {
                this.cancelBtn.post(new g(this));
            } else {
                doBind();
            }
        }
    }
}
