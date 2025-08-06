package com.luck.picture.lib.adapter.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.luck.picture.lib.R;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.style.SelectMainStyle;
import com.luck.picture.lib.utils.MediaUtils;
import com.luck.picture.lib.utils.StyleUtils;

public class ImageViewHolder extends BaseRecyclerMediaHolder {
    private final ImageView ivEditor;
    private final TextView tvMediaTag;

    public ImageViewHolder(View view, SelectorConfig selectorConfig) {
        super(view, selectorConfig);
        this.tvMediaTag = (TextView) view.findViewById(R.id.tv_media_tag);
        ImageView imageView = (ImageView) view.findViewById(R.id.ivEditor);
        this.ivEditor = imageView;
        SelectMainStyle selectMainStyle = this.selectorConfig.selectorStyle.getSelectMainStyle();
        int adapterImageEditorResources = selectMainStyle.getAdapterImageEditorResources();
        if (StyleUtils.checkStyleValidity(adapterImageEditorResources)) {
            imageView.setImageResource(adapterImageEditorResources);
        }
        int[] adapterImageEditorGravity = selectMainStyle.getAdapterImageEditorGravity();
        if (StyleUtils.checkArrayValidity(adapterImageEditorGravity) && (imageView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            ((RelativeLayout.LayoutParams) imageView.getLayoutParams()).removeRule(12);
            for (int addRule : adapterImageEditorGravity) {
                ((RelativeLayout.LayoutParams) this.ivEditor.getLayoutParams()).addRule(addRule);
            }
        }
        int[] adapterTagGravity = selectMainStyle.getAdapterTagGravity();
        if (StyleUtils.checkArrayValidity(adapterTagGravity) && (this.tvMediaTag.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            ((RelativeLayout.LayoutParams) this.tvMediaTag.getLayoutParams()).removeRule(21);
            ((RelativeLayout.LayoutParams) this.tvMediaTag.getLayoutParams()).removeRule(12);
            for (int addRule2 : adapterTagGravity) {
                ((RelativeLayout.LayoutParams) this.tvMediaTag.getLayoutParams()).addRule(addRule2);
            }
        }
        int adapterTagBackgroundResources = selectMainStyle.getAdapterTagBackgroundResources();
        if (StyleUtils.checkStyleValidity(adapterTagBackgroundResources)) {
            this.tvMediaTag.setBackgroundResource(adapterTagBackgroundResources);
        }
        int adapterTagTextSize = selectMainStyle.getAdapterTagTextSize();
        if (StyleUtils.checkSizeValidity(adapterTagTextSize)) {
            this.tvMediaTag.setTextSize((float) adapterTagTextSize);
        }
        int adapterTagTextColor = selectMainStyle.getAdapterTagTextColor();
        if (StyleUtils.checkStyleValidity(adapterTagTextColor)) {
            this.tvMediaTag.setTextColor(adapterTagTextColor);
        }
    }

    public void bindData(LocalMedia localMedia, int i11) {
        super.bindData(localMedia, i11);
        if (!localMedia.isEditorImage() || !localMedia.isCut()) {
            this.ivEditor.setVisibility(8);
        } else {
            this.ivEditor.setVisibility(0);
        }
        this.tvMediaTag.setVisibility(0);
        if (PictureMimeType.isHasGif(localMedia.getMimeType())) {
            this.tvMediaTag.setText(this.mContext.getString(R.string.ps_gif_tag));
        } else if (PictureMimeType.isHasWebp(localMedia.getMimeType())) {
            this.tvMediaTag.setText(this.mContext.getString(R.string.ps_webp_tag));
        } else if (MediaUtils.isLongImage(localMedia.getWidth(), localMedia.getHeight())) {
            this.tvMediaTag.setText(this.mContext.getString(R.string.ps_long_chart));
        } else {
            this.tvMediaTag.setVisibility(8);
        }
    }
}
