package com.youth.banner.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.youth.banner.R;
import com.youth.banner.holder.IViewHolder;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.util.BannerUtils;
import fz.a;
import fz.b;
import java.util.ArrayList;
import java.util.List;

public abstract class BannerAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> implements IViewHolder<T, VH> {
    public List<T> mDatas = new ArrayList();
    private int mIncreaseCount = 2;
    private OnBannerListener<T> mOnBannerListener;
    private VH mViewHolder;

    public BannerAdapter(List<T> list) {
        setDatas(list);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$onBindViewHolder$0(Object obj, int i11, View view) {
        this.mOnBannerListener.OnBannerClick(obj, i11);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$onCreateViewHolder$1(RecyclerView.ViewHolder viewHolder, View view) {
        if (this.mOnBannerListener != null) {
            this.mOnBannerListener.OnBannerClick(viewHolder.itemView.getTag(R.id.banner_data_key), ((Integer) viewHolder.itemView.getTag(R.id.banner_pos_key)).intValue());
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public T getData(int i11) {
        return this.mDatas.get(i11);
    }

    public int getItemCount() {
        return getRealCount() > 1 ? getRealCount() + this.mIncreaseCount : getRealCount();
    }

    public int getRealCount() {
        List<T> list = this.mDatas;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public T getRealData(int i11) {
        return this.mDatas.get(getRealPosition(i11));
    }

    public int getRealPosition(int i11) {
        return BannerUtils.getRealPosition(this.mIncreaseCount == 2, i11, getRealCount());
    }

    public VH getViewHolder() {
        return this.mViewHolder;
    }

    public final void onBindViewHolder(VH vh2, int i11) {
        this.mViewHolder = vh2;
        int realPosition = getRealPosition(i11);
        T t11 = this.mDatas.get(realPosition);
        vh2.itemView.setTag(R.id.banner_data_key, t11);
        vh2.itemView.setTag(R.id.banner_pos_key, Integer.valueOf(realPosition));
        onBindView(vh2, this.mDatas.get(realPosition), realPosition, getRealCount());
        if (this.mOnBannerListener != null) {
            vh2.itemView.setOnClickListener(new b(this, t11, realPosition));
        }
    }

    public VH onCreateViewHolder(ViewGroup viewGroup, int i11) {
        VH vh2 = (RecyclerView.ViewHolder) onCreateHolder(viewGroup, i11);
        vh2.itemView.setOnClickListener(new a(this, vh2));
        return vh2;
    }

    public void setDatas(List<T> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.mDatas = list;
        notifyDataSetChanged();
    }

    public void setIncreaseCount(int i11) {
        this.mIncreaseCount = i11;
    }

    public void setOnBannerListener(OnBannerListener<T> onBannerListener) {
        this.mOnBannerListener = onBannerListener;
    }
}
