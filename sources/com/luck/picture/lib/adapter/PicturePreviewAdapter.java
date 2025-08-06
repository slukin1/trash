package com.luck.picture.lib.adapter;

import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.luck.picture.lib.R;
import com.luck.picture.lib.adapter.holder.BasePreviewHolder;
import com.luck.picture.lib.adapter.holder.PreviewVideoHolder;
import com.luck.picture.lib.config.InjectResourceSource;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.config.SelectorProviders;
import com.luck.picture.lib.entity.LocalMedia;
import java.util.LinkedHashMap;
import java.util.List;

public class PicturePreviewAdapter extends RecyclerView.Adapter<BasePreviewHolder> {
    private List<LocalMedia> mData;
    private final LinkedHashMap<Integer, BasePreviewHolder> mHolderCache;
    private BasePreviewHolder.OnPreviewEventListener onPreviewEventListener;
    private final SelectorConfig selectorConfig;

    public PicturePreviewAdapter() {
        this(SelectorProviders.getInstance().getSelectorConfig());
    }

    public void destroy() {
        for (Integer num : this.mHolderCache.keySet()) {
            BasePreviewHolder basePreviewHolder = this.mHolderCache.get(num);
            if (basePreviewHolder != null) {
                basePreviewHolder.release();
            }
        }
    }

    public BasePreviewHolder getCurrentHolder(int i11) {
        return this.mHolderCache.get(Integer.valueOf(i11));
    }

    public LocalMedia getItem(int i11) {
        if (i11 > this.mData.size()) {
            return null;
        }
        return this.mData.get(i11);
    }

    public int getItemCount() {
        List<LocalMedia> list = this.mData;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public int getItemViewType(int i11) {
        if (PictureMimeType.isHasVideo(this.mData.get(i11).getMimeType())) {
            return 2;
        }
        return PictureMimeType.isHasAudio(this.mData.get(i11).getMimeType()) ? 3 : 1;
    }

    public boolean isPlaying(int i11) {
        BasePreviewHolder currentHolder = getCurrentHolder(i11);
        return currentHolder != null && currentHolder.isPlaying();
    }

    public void setCoverScaleType(int i11) {
        BasePreviewHolder currentHolder = getCurrentHolder(i11);
        if (currentHolder != null) {
            LocalMedia item = getItem(i11);
            if (item.getWidth() == 0 && item.getHeight() == 0) {
                currentHolder.coverImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            } else {
                currentHolder.coverImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            }
        }
    }

    public void setData(List<LocalMedia> list) {
        this.mData = list;
    }

    public void setOnPreviewEventListener(BasePreviewHolder.OnPreviewEventListener onPreviewEventListener2) {
        this.onPreviewEventListener = onPreviewEventListener2;
    }

    public void setVideoPlayButtonUI(int i11) {
        BasePreviewHolder currentHolder = getCurrentHolder(i11);
        if (currentHolder instanceof PreviewVideoHolder) {
            PreviewVideoHolder previewVideoHolder = (PreviewVideoHolder) currentHolder;
            if (!previewVideoHolder.isPlaying()) {
                previewVideoHolder.ivPlayButton.setVisibility(0);
            }
        }
    }

    public void startAutoVideoPlay(int i11) {
        BasePreviewHolder currentHolder = getCurrentHolder(i11);
        if (currentHolder instanceof PreviewVideoHolder) {
            ((PreviewVideoHolder) currentHolder).startPlay();
        }
    }

    public PicturePreviewAdapter(SelectorConfig selectorConfig2) {
        this.mHolderCache = new LinkedHashMap<>();
        this.selectorConfig = selectorConfig2;
    }

    public void onBindViewHolder(BasePreviewHolder basePreviewHolder, int i11) {
        basePreviewHolder.setOnPreviewEventListener(this.onPreviewEventListener);
        LocalMedia item = getItem(i11);
        this.mHolderCache.put(Integer.valueOf(i11), basePreviewHolder);
        basePreviewHolder.bindData(item, i11);
    }

    public BasePreviewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
        if (i11 == 2) {
            int layoutResource = InjectResourceSource.getLayoutResource(viewGroup.getContext(), 8, this.selectorConfig);
            if (layoutResource == 0) {
                layoutResource = R.layout.ps_preview_video;
            }
            return BasePreviewHolder.generate(viewGroup, i11, layoutResource);
        } else if (i11 == 3) {
            int layoutResource2 = InjectResourceSource.getLayoutResource(viewGroup.getContext(), 10, this.selectorConfig);
            if (layoutResource2 == 0) {
                layoutResource2 = R.layout.ps_preview_audio;
            }
            return BasePreviewHolder.generate(viewGroup, i11, layoutResource2);
        } else {
            int layoutResource3 = InjectResourceSource.getLayoutResource(viewGroup.getContext(), 7, this.selectorConfig);
            if (layoutResource3 == 0) {
                layoutResource3 = R.layout.ps_preview_image;
            }
            return BasePreviewHolder.generate(viewGroup, i11, layoutResource3);
        }
    }

    public void onViewAttachedToWindow(BasePreviewHolder basePreviewHolder) {
        super.onViewAttachedToWindow(basePreviewHolder);
        basePreviewHolder.onViewAttachedToWindow();
    }

    public void onViewDetachedFromWindow(BasePreviewHolder basePreviewHolder) {
        super.onViewDetachedFromWindow(basePreviewHolder);
        basePreviewHolder.onViewDetachedFromWindow();
    }
}
