package com.huobi.view;

import android.content.DialogInterface;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.widgets.BaseOrderFilterDialogFragment;
import com.hbg.lib.widgets.R$id;
import com.hbg.lib.widgets.R$layout;
import com.huobi.view.bean.SelectorBean;
import com.huobi.view.rv.GridDividerItemDecoration;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import java.util.ArrayList;
import java.util.List;
import v9.a;

public class SelectorDialogFragment extends BaseOrderFilterDialogFragment implements View.OnClickListener {
    private a<SelectorBean> adapter;
    private View[] extraClickViews;
    private OnSelectedListener onSelectedListener;
    private final List<SelectorBean> settingBeans = new ArrayList();
    private View topCover;
    private int topMargin;

    public interface OnSelectedListener {
        void onDismiss();

        void onSelected(SelectorBean selectorBean);
    }

    private boolean checkDownInView(View view, float f11, float f12) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return new Rect(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight()).contains((int) f11, (int) f12);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean lambda$addEvent$0(View view, MotionEvent motionEvent) {
        View[] viewArr;
        if (motionEvent.getAction() != 0 || (viewArr = this.extraClickViews) == null) {
            return false;
        }
        for (View view2 : viewArr) {
            if (checkDownInView(view2, motionEvent.getRawX(), motionEvent.getRawY())) {
                view2.performClick();
                return true;
            }
        }
        return false;
    }

    public void addEvent(r rVar) {
        super.addEvent(rVar);
        this.topCover.setOnTouchListener(new m1(this));
    }

    public void addExtraClickView(View... viewArr) {
        this.extraClickViews = viewArr;
    }

    public void afterInit() {
    }

    public void configCoverViewLayoutParams(View view, FrameLayout.LayoutParams layoutParams) {
        layoutParams.topMargin = this.topMargin;
    }

    public View getBackBtn() {
        return null;
    }

    public int getContentViewResId() {
        return R$layout.dialog_setting_filter;
    }

    public View getFilterLayout() {
        return this.viewFinder.b(R$id.option_filter_view);
    }

    public void initView(r rVar) {
        GridLayoutManager gridLayoutManager;
        this.topCover = rVar.b(R$id.top_cover);
        RecyclerView recyclerView = (RecyclerView) rVar.b(R$id.rcv);
        if (this.settingBeans.size() > 2) {
            gridLayoutManager = new GridLayoutManager(getContext(), 3);
        } else {
            gridLayoutManager = new GridLayoutManager(getContext(), 2);
        }
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.addItemDecoration(new GridDividerItemDecoration(new ColorDrawable(0), PixelUtils.a(10.0f)));
        a<SelectorBean> aVar = new a<>(this.settingBeans);
        this.adapter = aVar;
        recyclerView.setAdapter(aVar);
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        SelectorBean selectorBean = (SelectorBean) view.getTag();
        selectorBean.setSelected(true);
        for (SelectorBean next : this.settingBeans) {
            if (selectorBean != next) {
                next.setSelected(false);
            }
        }
        this.adapter.notifyDataSetChanged();
        dismiss();
        OnSelectedListener onSelectedListener2 = this.onSelectedListener;
        if (onSelectedListener2 != null) {
            onSelectedListener2.onSelected(selectorBean);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        OnSelectedListener onSelectedListener2 = this.onSelectedListener;
        if (onSelectedListener2 != null) {
            onSelectedListener2.onDismiss();
        }
    }

    public void onStart() {
        super.onStart();
        this.topCover.getLayoutParams().height = this.topMargin;
    }

    public void reset() {
    }

    public void setOnSelectedListener(OnSelectedListener onSelectedListener2) {
        this.onSelectedListener = onSelectedListener2;
    }

    public void setSettingBeans(List<SelectorBean> list) {
        this.settingBeans.clear();
        this.settingBeans.addAll(list);
        for (SelectorBean onClickListener : this.settingBeans) {
            onClickListener.setOnClickListener(this);
        }
    }

    public void setTopMargin(int i11) {
        this.topMargin = i11;
    }
}
