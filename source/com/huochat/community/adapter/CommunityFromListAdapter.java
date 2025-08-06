package com.huochat.community.adapter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.huochat.community.CommunityManager;
import com.huochat.community.CommunityThemeColor;
import com.huochat.community.R;
import com.huochat.community.base.CommunityConstants;
import com.huochat.community.model.CommunitySymbolBean;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import qv.b;

public class CommunityFromListAdapter extends RecyclerView.Adapter<MyViewHolder> implements Serializable {
    /* access modifiers changed from: private */
    public CommunityThemeColor communityThemeColor = CommunityManager.Companion.getInstance().getCommunityThemeColor();
    private Activity mActivity;
    private List<CommunitySymbolBean> mDataList;

    public final class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(Context context, View view) {
            super(view);
        }

        /* access modifiers changed from: private */
        @SensorsDataInstrumented
        public static final void bindData$lambda$0(CommunitySymbolBean communitySymbolBean, View view) {
            String str;
            String symbol = communitySymbolBean.getSymbol();
            if (symbol == null || (str = StringsKt__StringsJVMKt.G(symbol, "/", "", false, 4, (Object) null)) == null) {
                str = "";
            }
            if (!TextUtils.isEmpty(str)) {
                Bundle bundle = new Bundle();
                bundle.putString("symbolId", str);
                bundle.putInt("fromCommunity", 2);
            } else {
                Bundle bundle2 = new Bundle();
                bundle2.putString("communityId", communitySymbolBean.getCommunityId());
                bundle2.putString("communityName", communitySymbolBean.getCommunityName());
                bundle2.putString(CommunityConstants.COMMUNITY_SYMBOL, "" + str);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        public final void bindData(Activity activity, CommunitySymbolBean communitySymbolBean) {
            if (communitySymbolBean == null) {
                this.itemView.setOnClickListener((View.OnClickListener) null);
                return;
            }
            View view = this.itemView;
            int i11 = R.id.tvCommunityFrom;
            ((TextView) view.findViewById(i11)).setText(communitySymbolBean.getCommunityName() + "社区");
            this.itemView.setOnClickListener(new b(communitySymbolBean));
            ImageView imageView = (ImageView) this.itemView.findViewById(R.id.ivFromCoinIcon);
            if (imageView != null) {
                imageView.setColorFilter(CommunityFromListAdapter.this.communityThemeColor.getCommunityFromIconTextColor());
            }
            TextView textView = (TextView) this.itemView.findViewById(i11);
            if (textView != null) {
                textView.setTextColor(CommunityFromListAdapter.this.communityThemeColor.getCommunityFromIconTextColor());
            }
            LinearLayout linearLayout = (LinearLayout) this.itemView.findViewById(R.id.llCommunityFrom);
            if (linearLayout != null) {
                linearLayout.setBackgroundResource(CommunityFromListAdapter.this.communityThemeColor.getCommunityFromBgDrawable());
            }
        }
    }

    public CommunityFromListAdapter(Activity activity, List<CommunitySymbolBean> list) {
        this.mActivity = activity;
        this.mDataList = list == null ? new LinkedList<>() : list;
    }

    public int getItemCount() {
        List<CommunitySymbolBean> list = this.mDataList;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public final void resetData(List<CommunitySymbolBean> list) {
        this.mDataList.clear();
        if (list != null) {
            this.mDataList.addAll(list);
        }
        notifyDataSetChanged();
    }

    public final void setColorTheme(CommunityThemeColor communityThemeColor2) {
        this.communityThemeColor = communityThemeColor2;
        notifyDataSetChanged();
    }

    public void onBindViewHolder(MyViewHolder myViewHolder, int i11) {
        Activity activity = this.mActivity;
        List<CommunitySymbolBean> list = this.mDataList;
        myViewHolder.bindData(activity, list != null ? list.get(i11) : null);
    }

    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
        return new MyViewHolder(viewGroup.getContext(), LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_communit_from_list, (ViewGroup) null, false));
    }
}
