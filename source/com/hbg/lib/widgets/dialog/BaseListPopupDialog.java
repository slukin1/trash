package com.hbg.lib.widgets.dialog;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.badge.BadgeDrawable;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.widgets.R$id;
import com.hbg.lib.widgets.R$layout;
import com.hbg.lib.widgets.R$style;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.lib.widgets.dialog.animation.DefaultAnimationAdapter;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.n;
import i6.r;
import java.util.List;
import s9.a;
import z9.d;
import z9.e;
import z9.f;

public abstract class BaseListPopupDialog<T extends a> extends BaseDialogFragment {
    private boolean followViewWidth;
    private View mAnchorView;
    private aa.a mAnimatorAdapter;
    public FrameLayout mContentLayout;
    private int mLocationX;
    public int mLocationY;
    private FrameLayout mParent;
    public EasyRecyclerView<T> mRecyclerView;
    private int mShowGravity;
    private int mViewWidth = -1;

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$afterInit$1() {
        this.mRecyclerView.setVisibility(0);
        aa.a aVar = this.mAnimatorAdapter;
        if (aVar != null) {
            aVar.a(this, this.mRecyclerView);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$initView$0(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public void showPopupWindow() {
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        this.mAnchorView.getLocationOnScreen(iArr2);
        iArr2[1] = iArr2[1] - ViewUtil.g();
        this.mParent.measure(0, 0);
        this.mRecyclerView.measure(0, 0);
        int measuredHeight = this.mParent.getMeasuredHeight();
        boolean z11 = (BaseApplication.b().getResources().getDisplayMetrics().heightPixels - iArr2[1]) - n.d(BaseApplication.b()) < measuredHeight;
        iArr[0] = iArr2[0];
        if (z11) {
            iArr[1] = (iArr2[1] - measuredHeight) - this.mAnchorView.getHeight();
        } else {
            iArr[1] = iArr2[1];
        }
        int width = ViewUtil.j(this.mShowGravity) ? this.mAnchorView.getWidth() - this.mContentLayout.getWidth() : 0;
        int height = ViewUtil.i(this.mShowGravity) ? this.mAnchorView.getHeight() : 0;
        this.mContentLayout.setTranslationX((float) (iArr[0] + width));
        this.mContentLayout.setTranslationY((float) (iArr[1] + height));
    }

    public void addEvent(r rVar) {
    }

    public void afterInit() {
        ViewGroup.LayoutParams layoutParams;
        if (this.mAnimatorAdapter == null) {
            this.mAnimatorAdapter = new DefaultAnimationAdapter();
        }
        if (!(!this.followViewWidth || this.mViewWidth == -1 || (layoutParams = this.mRecyclerView.getLayoutParams()) == null)) {
            layoutParams.width = this.mViewWidth;
            this.mRecyclerView.setLayoutParams(layoutParams);
        }
        this.mRecyclerView.setVisibility(4);
        reloadDataList();
        this.mContentLayout.post(new e(this));
        this.mRecyclerView.post(new f(this));
    }

    public void dismiss() {
        aa.a aVar = this.mAnimatorAdapter;
        if (aVar == null || !aVar.b(this, this.mRecyclerView)) {
            super.dismiss();
        }
    }

    public boolean followScreenSize() {
        return true;
    }

    public int getAnimationStyle() {
        return R$style.DialogAlphaAnimation;
    }

    public int getContentViewResId() {
        return R$layout.layout_base_list_pop_dialog;
    }

    public abstract List<T> getDataList();

    public int getGravity() {
        return BadgeDrawable.TOP_START;
    }

    public int getItemCount() {
        EasyRecyclerView<T> easyRecyclerView = this.mRecyclerView;
        if (easyRecyclerView != null) {
            return easyRecyclerView.getItemCount();
        }
        return 0;
    }

    public FrameLayout getRootLayout() {
        return this.mParent;
    }

    public void initView(r rVar) {
        this.mParent = (FrameLayout) rVar.b(R$id.id_base_list_dialog_parent);
        this.mContentLayout = (FrameLayout) rVar.b(R$id.id_base_list_dialog_content_layout);
        this.mRecyclerView = (EasyRecyclerView) rVar.b(R$id.id_base_list_dialog_recyclerView);
        this.mParent.setOnClickListener(new d(this));
    }

    public boolean isFullScreen() {
        return true;
    }

    public boolean isTransparent() {
        return false;
    }

    public void reloadDataList() {
        setData(getDataList());
    }

    public void setAnimatorAdapter(aa.a aVar) {
        this.mAnimatorAdapter = aVar;
    }

    public void setData(List<T> list) {
        EasyRecyclerView<T> easyRecyclerView = this.mRecyclerView;
        if (easyRecyclerView != null) {
            easyRecyclerView.setData(list);
        }
    }

    public void setFollowViewWidth(boolean z11) {
        this.followViewWidth = z11;
    }

    public void showAsDropDown(FragmentManager fragmentManager, View view) {
        showAsDropDown(fragmentManager, view, 0, 0);
    }

    public void showAsDropDownWithShadow(FragmentManager fragmentManager, View view, int i11, int i12, int i13, int i14) {
        if (view != null) {
            this.mAnchorView = view;
            this.mShowGravity = i14;
            this.mViewWidth = view.getWidth() + (i11 * 2);
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            this.mLocationX = (iArr[0] + i12) - i11;
            this.mLocationY = (iArr[1] + i13) - ViewUtil.g();
        }
        show(fragmentManager, "BaseListPopupDialog");
    }

    public void showAsDropDown(FragmentManager fragmentManager, View view, int i11, int i12) {
        showAsDropDown(fragmentManager, view, i11, i12, 80);
    }

    public void showAsDropDown(FragmentManager fragmentManager, View view, int i11, int i12, int i13) {
        if (view != null) {
            this.mAnchorView = view;
            this.mShowGravity = i13;
            this.mViewWidth = view.getWidth();
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            this.mLocationX = iArr[0] + i11;
            this.mLocationY = (iArr[1] + i12) - ViewUtil.g();
        }
        show(fragmentManager, "BaseListPopupDialog");
    }

    public void showAsDropDown(FragmentManager fragmentManager, View view, boolean z11, int i11, int i12, int i13) {
        if (view != null) {
            this.mAnchorView = view;
            this.mShowGravity = i13;
            if (!z11) {
                this.mViewWidth = view.getWidth();
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            this.mLocationX = iArr[0] + i11;
            this.mLocationY = (iArr[1] + i12) - ViewUtil.g();
        }
        show(fragmentManager, "BaseListPopupDialog");
    }

    public void showAsDropDown(FragmentManager fragmentManager, View view, int i11, int i12, int i13, int i14) {
        if (view != null) {
            this.mAnchorView = view;
            this.mShowGravity = i14;
            this.mViewWidth = i11;
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            this.mLocationX = iArr[0] + i12;
            this.mLocationY = (iArr[1] + i13) - ViewUtil.g();
        }
        show(fragmentManager, "BaseListPopupDialog");
    }
}
