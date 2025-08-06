package com.yalantis.ucrop;

import android.graphics.ColorFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.BlendModeCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.List;
import t0.a;

public class UCropGalleryAdapter extends RecyclerView.Adapter<ViewHolder> {
    private int currentSelectPosition;
    private final List<String> list;
    /* access modifiers changed from: private */
    public OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(int i11, View view);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView mIvPhoto;
        public View mViewCurrentSelect;

        public ViewHolder(View view) {
            super(view);
            this.mIvPhoto = (ImageView) view.findViewById(R.id.iv_photo);
            this.mViewCurrentSelect = view.findViewById(R.id.view_current_select);
        }
    }

    public UCropGalleryAdapter(List<String> list2) {
        this.list = list2;
    }

    public int getCurrentSelectPosition() {
        return this.currentSelectPosition;
    }

    public int getItemCount() {
        List<String> list2 = this.list;
        if (list2 != null) {
            return list2.size();
        }
        return 0;
    }

    public void setCurrentSelectPosition(int i11) {
        this.currentSelectPosition = i11;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.listener = onItemClickListener;
    }

    public void onBindViewHolder(final ViewHolder viewHolder, int i11) {
        ColorFilter colorFilter;
        String str = this.list.get(i11);
        UCropImageEngine uCropImageEngine = UCropDevelopConfig.imageEngine;
        if (uCropImageEngine != null) {
            uCropImageEngine.loadImage(viewHolder.itemView.getContext(), str, viewHolder.mIvPhoto);
        }
        if (this.currentSelectPosition == i11) {
            viewHolder.mViewCurrentSelect.setVisibility(0);
            colorFilter = a.a(ContextCompat.getColor(viewHolder.itemView.getContext(), R.color.ucrop_color_80), BlendModeCompat.SRC_ATOP);
        } else {
            colorFilter = a.a(ContextCompat.getColor(viewHolder.itemView.getContext(), R.color.ucrop_color_20), BlendModeCompat.SRC_ATOP);
            viewHolder.mViewCurrentSelect.setVisibility(8);
        }
        viewHolder.mIvPhoto.setColorFilter(colorFilter);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                if (UCropGalleryAdapter.this.listener != null) {
                    UCropGalleryAdapter.this.listener.onItemClick(viewHolder.getAbsoluteAdapterPosition(), view);
                }
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ucrop_gallery_adapter_item, viewGroup, false));
    }
}
