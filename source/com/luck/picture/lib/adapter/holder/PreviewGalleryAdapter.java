package com.luck.picture.lib.adapter.holder;

import android.graphics.ColorFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.luck.picture.lib.R;
import com.luck.picture.lib.config.InjectResourceSource;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.engine.ImageEngine;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.style.SelectMainStyle;
import com.luck.picture.lib.utils.StyleUtils;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.ArrayList;
import java.util.List;

public class PreviewGalleryAdapter extends RecyclerView.Adapter<ViewHolder> {
    private final boolean isBottomPreview;
    /* access modifiers changed from: private */
    public OnItemClickListener listener;
    private final List<LocalMedia> mData;
    /* access modifiers changed from: private */
    public OnItemLongClickListener mItemLongClickListener;
    /* access modifiers changed from: private */
    public final SelectorConfig selectorConfig;

    public interface OnItemClickListener {
        void onItemClick(int i11, LocalMedia localMedia, View view);
    }

    public interface OnItemLongClickListener {
        void onItemLongClick(RecyclerView.ViewHolder viewHolder, int i11, View view);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView ivEditor;
        public ImageView ivImage;
        public ImageView ivPlay;
        public View viewBorder;

        public ViewHolder(View view) {
            super(view);
            this.ivImage = (ImageView) view.findViewById(R.id.ivImage);
            this.ivPlay = (ImageView) view.findViewById(R.id.ivPlay);
            this.ivEditor = (ImageView) view.findViewById(R.id.ivEditor);
            this.viewBorder = view.findViewById(R.id.viewBorder);
            SelectMainStyle selectMainStyle = PreviewGalleryAdapter.this.selectorConfig.selectorStyle.getSelectMainStyle();
            if (StyleUtils.checkStyleValidity(selectMainStyle.getAdapterImageEditorResources())) {
                this.ivEditor.setImageResource(selectMainStyle.getAdapterImageEditorResources());
            }
            if (StyleUtils.checkStyleValidity(selectMainStyle.getAdapterPreviewGalleryFrameResource())) {
                this.viewBorder.setBackgroundResource(selectMainStyle.getAdapterPreviewGalleryFrameResource());
            }
            int adapterPreviewGalleryItemSize = selectMainStyle.getAdapterPreviewGalleryItemSize();
            if (StyleUtils.checkSizeValidity(adapterPreviewGalleryItemSize)) {
                view.setLayoutParams(new RelativeLayout.LayoutParams(adapterPreviewGalleryItemSize, adapterPreviewGalleryItemSize));
            }
        }
    }

    public PreviewGalleryAdapter(SelectorConfig selectorConfig2, boolean z11) {
        this.selectorConfig = selectorConfig2;
        this.isBottomPreview = z11;
        this.mData = new ArrayList(selectorConfig2.getSelectedResult());
        for (int i11 = 0; i11 < this.mData.size(); i11++) {
            LocalMedia localMedia = this.mData.get(i11);
            localMedia.setGalleryEnabledMask(false);
            localMedia.setChecked(false);
        }
    }

    private int getCurrentPosition(LocalMedia localMedia) {
        for (int i11 = 0; i11 < this.mData.size(); i11++) {
            LocalMedia localMedia2 = this.mData.get(i11);
            if (TextUtils.equals(localMedia2.getPath(), localMedia.getPath()) || localMedia2.getId() == localMedia.getId()) {
                return i11;
            }
        }
        return -1;
    }

    public void addGalleryData(LocalMedia localMedia) {
        int lastCheckPosition = getLastCheckPosition();
        if (lastCheckPosition != -1) {
            this.mData.get(lastCheckPosition).setChecked(false);
            notifyItemChanged(lastCheckPosition);
        }
        if (!this.isBottomPreview || !this.mData.contains(localMedia)) {
            localMedia.setChecked(true);
            this.mData.add(localMedia);
            notifyItemChanged(this.mData.size() - 1);
            return;
        }
        int currentPosition = getCurrentPosition(localMedia);
        LocalMedia localMedia2 = this.mData.get(currentPosition);
        localMedia2.setGalleryEnabledMask(false);
        localMedia2.setChecked(true);
        notifyItemChanged(currentPosition);
    }

    public void clear() {
        this.mData.clear();
    }

    public List<LocalMedia> getData() {
        return this.mData;
    }

    public int getItemCount() {
        return this.mData.size();
    }

    public int getLastCheckPosition() {
        for (int i11 = 0; i11 < this.mData.size(); i11++) {
            if (this.mData.get(i11).isChecked()) {
                return i11;
            }
        }
        return -1;
    }

    public void isSelectMedia(LocalMedia localMedia) {
        int lastCheckPosition = getLastCheckPosition();
        if (lastCheckPosition != -1) {
            this.mData.get(lastCheckPosition).setChecked(false);
            notifyItemChanged(lastCheckPosition);
        }
        int currentPosition = getCurrentPosition(localMedia);
        if (currentPosition != -1) {
            this.mData.get(currentPosition).setChecked(true);
            notifyItemChanged(currentPosition);
        }
    }

    public void removeGalleryData(LocalMedia localMedia) {
        int currentPosition = getCurrentPosition(localMedia);
        if (currentPosition == -1) {
            return;
        }
        if (this.isBottomPreview) {
            this.mData.get(currentPosition).setGalleryEnabledMask(true);
            notifyItemChanged(currentPosition);
            return;
        }
        this.mData.remove(currentPosition);
        notifyItemRemoved(currentPosition);
    }

    public void setItemClickListener(OnItemClickListener onItemClickListener) {
        this.listener = onItemClickListener;
    }

    public void setItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        this.mItemLongClickListener = onItemLongClickListener;
    }

    public void onBindViewHolder(final ViewHolder viewHolder, int i11) {
        final LocalMedia localMedia = this.mData.get(i11);
        ColorFilter colorFilter = StyleUtils.getColorFilter(viewHolder.itemView.getContext(), localMedia.isGalleryEnabledMask() ? R.color.ps_color_half_white : R.color.ps_color_transparent);
        int i12 = 8;
        if (!localMedia.isChecked() || !localMedia.isGalleryEnabledMask()) {
            viewHolder.viewBorder.setVisibility(localMedia.isChecked() ? 0 : 8);
        } else {
            viewHolder.viewBorder.setVisibility(0);
        }
        String path = localMedia.getPath();
        if (!localMedia.isEditorImage() || TextUtils.isEmpty(localMedia.getCutPath())) {
            viewHolder.ivEditor.setVisibility(8);
        } else {
            path = localMedia.getCutPath();
            viewHolder.ivEditor.setVisibility(0);
        }
        viewHolder.ivImage.setColorFilter(colorFilter);
        ImageEngine imageEngine = this.selectorConfig.imageEngine;
        if (imageEngine != null) {
            imageEngine.loadGridImage(viewHolder.itemView.getContext(), path, viewHolder.ivImage);
        }
        ImageView imageView = viewHolder.ivPlay;
        if (PictureMimeType.isHasVideo(localMedia.getMimeType())) {
            i12 = 0;
        }
        imageView.setVisibility(i12);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                if (PreviewGalleryAdapter.this.listener != null) {
                    PreviewGalleryAdapter.this.listener.onItemClick(viewHolder.getAbsoluteAdapterPosition(), localMedia, view);
                }
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                if (PreviewGalleryAdapter.this.mItemLongClickListener == null) {
                    return true;
                }
                PreviewGalleryAdapter.this.mItemLongClickListener.onItemLongClick(viewHolder, viewHolder.getAbsoluteAdapterPosition(), view);
                return true;
            }
        });
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
        int layoutResource = InjectResourceSource.getLayoutResource(viewGroup.getContext(), 9, this.selectorConfig);
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        if (layoutResource == 0) {
            layoutResource = R.layout.ps_preview_gallery_item;
        }
        return new ViewHolder(from.inflate(layoutResource, viewGroup, false));
    }
}
