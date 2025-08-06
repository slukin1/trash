package com.luck.picture.lib.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.luck.picture.lib.R;
import com.luck.picture.lib.adapter.holder.BaseRecyclerMediaHolder;
import com.luck.picture.lib.config.InjectResourceSource;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.ArrayList;

public class PictureImageGridAdapter extends RecyclerView.Adapter<BaseRecyclerMediaHolder> {
    public static final int ADAPTER_TYPE_AUDIO = 4;
    public static final int ADAPTER_TYPE_CAMERA = 1;
    public static final int ADAPTER_TYPE_IMAGE = 2;
    public static final int ADAPTER_TYPE_VIDEO = 3;
    private boolean isDisplayCamera;
    /* access modifiers changed from: private */
    public OnItemClickListener listener;
    private final SelectorConfig mConfig;
    private final Context mContext;
    private ArrayList<LocalMedia> mData = new ArrayList<>();

    public interface OnItemClickListener {
        void onItemClick(View view, int i11, LocalMedia localMedia);

        void onItemLongClick(View view, int i11);

        int onSelected(View view, int i11, LocalMedia localMedia);

        void openCameraClick();
    }

    public PictureImageGridAdapter(Context context, SelectorConfig selectorConfig) {
        this.mConfig = selectorConfig;
        this.mContext = context;
    }

    private int getItemResourceId(int i11) {
        if (i11 == 1) {
            return R.layout.ps_item_grid_camera;
        }
        if (i11 == 3) {
            int layoutResource = InjectResourceSource.getLayoutResource(this.mContext, 4, this.mConfig);
            return layoutResource != 0 ? layoutResource : R.layout.ps_item_grid_video;
        } else if (i11 != 4) {
            int layoutResource2 = InjectResourceSource.getLayoutResource(this.mContext, 3, this.mConfig);
            return layoutResource2 != 0 ? layoutResource2 : R.layout.ps_item_grid_image;
        } else {
            int layoutResource3 = InjectResourceSource.getLayoutResource(this.mContext, 5, this.mConfig);
            return layoutResource3 != 0 ? layoutResource3 : R.layout.ps_item_grid_audio;
        }
    }

    public ArrayList<LocalMedia> getData() {
        return this.mData;
    }

    public int getItemCount() {
        return this.isDisplayCamera ? this.mData.size() + 1 : this.mData.size();
    }

    public int getItemViewType(int i11) {
        boolean z11 = this.isDisplayCamera;
        if (z11 && i11 == 0) {
            return 1;
        }
        if (z11) {
            i11--;
        }
        String mimeType = this.mData.get(i11).getMimeType();
        if (PictureMimeType.isHasVideo(mimeType)) {
            return 3;
        }
        return PictureMimeType.isHasAudio(mimeType) ? 4 : 2;
    }

    public boolean isDataEmpty() {
        return this.mData.size() == 0;
    }

    public boolean isDisplayCamera() {
        return this.isDisplayCamera;
    }

    public void notifyItemPositionChanged(int i11) {
        notifyItemChanged(i11);
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public void setDataAndDataSetChanged(ArrayList<LocalMedia> arrayList) {
        if (arrayList != null) {
            this.mData = arrayList;
            notifyDataSetChanged();
        }
    }

    public void setDisplayCamera(boolean z11) {
        this.isDisplayCamera = z11;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.listener = onItemClickListener;
    }

    public void onBindViewHolder(BaseRecyclerMediaHolder baseRecyclerMediaHolder, int i11) {
        if (getItemViewType(i11) == 1) {
            baseRecyclerMediaHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @SensorsDataInstrumented
                public void onClick(View view) {
                    if (PictureImageGridAdapter.this.listener != null) {
                        PictureImageGridAdapter.this.listener.openCameraClick();
                    }
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                }
            });
            return;
        }
        if (this.isDisplayCamera) {
            i11--;
        }
        baseRecyclerMediaHolder.bindData(this.mData.get(i11), i11);
        baseRecyclerMediaHolder.setOnItemClickListener(this.listener);
    }

    public BaseRecyclerMediaHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
        return BaseRecyclerMediaHolder.generate(viewGroup, i11, getItemResourceId(i11), this.mConfig);
    }
}
