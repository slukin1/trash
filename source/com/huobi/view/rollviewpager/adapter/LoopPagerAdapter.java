package com.huobi.view.rollviewpager.adapter;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.huobi.view.rollviewpager.RollPagerView;
import com.huobi.view.rollviewpager.hintview.HintView;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class LoopPagerAdapter extends PagerAdapter {
    private ArrayList<View> mViewList = new ArrayList<>();
    private RollPagerView mViewPager;
    private int posDelta;

    public class LoopHintViewDelegate implements RollPagerView.HintViewDelegate {
        private LoopHintViewDelegate() {
        }

        public void initView(int i11, int i12, HintView hintView) {
            if (hintView != null) {
                hintView.initView(LoopPagerAdapter.this.getRealCount(), i12);
            }
        }

        public void setCurrentPosition(int i11, HintView hintView) {
            if (hintView != null && LoopPagerAdapter.this.getRealCount() > 0) {
                hintView.setCurrent(i11 % LoopPagerAdapter.this.getRealCount());
            }
        }
    }

    public LoopPagerAdapter(RollPagerView rollPagerView) {
        this.mViewPager = rollPagerView;
        rollPagerView.setHintViewDelegate(new LoopHintViewDelegate());
    }

    private View findViewByPosition(ViewGroup viewGroup, int i11) {
        Iterator<View> it2 = this.mViewList.iterator();
        while (it2.hasNext()) {
            View next = it2.next();
            if (((Integer) next.getTag()).intValue() == i11 && next.getParent() == null) {
                return next;
            }
        }
        View view = getView(viewGroup, i11);
        view.setTag(Integer.valueOf(i11));
        this.mViewList.add(view);
        return view;
    }

    public void destroyItem(ViewGroup viewGroup, int i11, Object obj) {
        viewGroup.removeView((View) obj);
    }

    @Deprecated
    public final int getCount() {
        if (getRealCount() <= 0) {
            return getRealCount();
        }
        return Integer.MAX_VALUE;
    }

    public int getItemPosition(Object obj) {
        return -2;
    }

    public int getPosDelta() {
        return this.posDelta;
    }

    public abstract int getRealCount();

    public abstract View getView(ViewGroup viewGroup, int i11);

    public Object instantiateItem(ViewGroup viewGroup, int i11) {
        View findViewByPosition = findViewByPosition(viewGroup, i11 % getRealCount());
        viewGroup.addView(findViewByPosition, new ViewGroup.LayoutParams(-1, -1));
        return findViewByPosition;
    }

    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void notifyDataSetChanged() {
        this.mViewList.clear();
        super.notifyDataSetChanged();
    }

    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        super.registerDataSetObserver(dataSetObserver);
    }

    public void setPosDelta(int i11) {
        this.posDelta = i11;
    }
}
