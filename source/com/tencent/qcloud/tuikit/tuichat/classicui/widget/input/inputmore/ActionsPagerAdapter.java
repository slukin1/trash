package com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.inputmore;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.InputMoreActionUnit;
import java.util.ArrayList;
import java.util.List;

public class ActionsPagerAdapter extends PagerAdapter {
    private final int COLUMN_COUNT = 4;
    private final int ITEM_COUNT_PER_GRID_VIEW = 8;
    /* access modifiers changed from: private */
    public int actionHeight;
    private int actionWidth;
    private final Context mContext;
    private final int mGridViewCount;
    /* access modifiers changed from: private */
    public final List<InputMoreActionUnit> mInputMoreList;
    /* access modifiers changed from: private */
    public final ViewPager mViewPager;

    public ActionsPagerAdapter(ViewPager viewPager, List<InputMoreActionUnit> list) {
        this.mContext = viewPager.getContext();
        this.mInputMoreList = new ArrayList(list);
        this.mViewPager = viewPager;
        this.mGridViewCount = ((list.size() + 8) - 1) / 8;
    }

    public void destroyItem(ViewGroup viewGroup, int i11, Object obj) {
    }

    public int getCount() {
        return this.mGridViewCount;
    }

    public int getItemPosition(Object obj) {
        return -2;
    }

    public Object instantiateItem(ViewGroup viewGroup, int i11) {
        int i12 = (i11 + 1) * 8;
        if (i12 > this.mInputMoreList.size()) {
            i12 = this.mInputMoreList.size();
        }
        List<InputMoreActionUnit> subList = this.mInputMoreList.subList(i11 * 8, i12);
        GridView gridView = new GridView(this.mContext);
        gridView.setAdapter(new ActionsGridViewAdapter(this.mContext, subList));
        if (this.mInputMoreList.size() >= 4) {
            gridView.setNumColumns(4);
            viewGroup.post(new Runnable() {
                public void run() {
                    ViewGroup.LayoutParams layoutParams = ActionsPagerAdapter.this.mViewPager.getLayoutParams();
                    layoutParams.height = ActionsPagerAdapter.this.actionHeight;
                    ActionsPagerAdapter.this.mViewPager.setLayoutParams(layoutParams);
                }
            });
        } else {
            gridView.setNumColumns(this.mInputMoreList.size());
            viewGroup.post(new Runnable() {
                public void run() {
                    ViewGroup.LayoutParams layoutParams = ActionsPagerAdapter.this.mViewPager.getLayoutParams();
                    layoutParams.height = ActionsPagerAdapter.this.actionHeight;
                    ActionsPagerAdapter.this.mViewPager.setLayoutParams(layoutParams);
                }
            });
        }
        gridView.setSelector(R.color.transparent);
        gridView.setHorizontalSpacing(60);
        gridView.setVerticalSpacing(60);
        gridView.setGravity(17);
        gridView.setTag(Integer.valueOf(i11));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @SensorsDataInstrumented
            public void onItemClick(AdapterView<?> adapterView, View view, int i11, long j11) {
                ((InputMoreActionUnit) ActionsPagerAdapter.this.mInputMoreList.get((((Integer) adapterView.getTag()).intValue() * 8) + i11)).getOnClickListener().onClick();
                SensorsDataAutoTrackHelper.trackListView(adapterView, view, i11);
            }
        });
        viewGroup.addView(gridView);
        return gridView;
    }

    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
