package com.luck.picture.lib.adapter.holder;

import android.content.Context;
import android.graphics.ColorFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.luck.picture.lib.R;
import com.luck.picture.lib.adapter.PictureImageGridAdapter;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.engine.ImageEngine;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.interfaces.OnGridItemSelectAnimListener;
import com.luck.picture.lib.style.SelectMainStyle;
import com.luck.picture.lib.utils.AnimUtils;
import com.luck.picture.lib.utils.StyleUtils;
import com.luck.picture.lib.utils.ValueOf;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;

public class BaseRecyclerMediaHolder extends RecyclerView.ViewHolder {
    public View btnCheck;
    private ColorFilter defaultColorFilter;
    public boolean isHandleMask;
    public boolean isSelectNumberStyle;
    public ImageView ivPicture;
    /* access modifiers changed from: private */
    public PictureImageGridAdapter.OnItemClickListener listener;
    public Context mContext;
    private ColorFilter maskWhiteColorFilter;
    private ColorFilter selectColorFilter;
    public SelectorConfig selectorConfig;
    public TextView tvCheck;

    public BaseRecyclerMediaHolder(View view) {
        super(view);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005d, code lost:
        if (com.luck.picture.lib.config.PictureMimeType.isHasImage(r6.getMimeType()) == false) goto L_0x007a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0077, code lost:
        if (com.luck.picture.lib.config.PictureMimeType.isHasVideo(r6.getMimeType()) == false) goto L_0x007a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0088  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void dispatchHandleMask(com.luck.picture.lib.entity.LocalMedia r6) {
        /*
            r5 = this;
            com.luck.picture.lib.config.SelectorConfig r0 = r5.selectorConfig
            int r0 = r0.getSelectCount()
            r1 = 0
            r2 = 1
            if (r0 <= 0) goto L_0x007a
            com.luck.picture.lib.config.SelectorConfig r0 = r5.selectorConfig
            java.util.ArrayList r0 = r0.getSelectedResult()
            boolean r0 = r0.contains(r6)
            if (r0 != 0) goto L_0x007a
            com.luck.picture.lib.config.SelectorConfig r0 = r5.selectorConfig
            boolean r3 = r0.isWithVideoImage
            r4 = 2147483647(0x7fffffff, float:NaN)
            if (r3 == 0) goto L_0x0036
            int r3 = r0.selectionMode
            if (r3 != r2) goto L_0x002b
            int r0 = r0.getSelectCount()
            if (r0 != r4) goto L_0x007a
        L_0x0029:
            r0 = r2
            goto L_0x007b
        L_0x002b:
            int r0 = r0.getSelectCount()
            com.luck.picture.lib.config.SelectorConfig r3 = r5.selectorConfig
            int r3 = r3.maxSelectNum
            if (r0 != r3) goto L_0x007a
            goto L_0x0029
        L_0x0036:
            java.lang.String r0 = r0.getResultFirstMimeType()
            boolean r0 = com.luck.picture.lib.config.PictureMimeType.isHasVideo(r0)
            if (r0 == 0) goto L_0x0060
            com.luck.picture.lib.config.SelectorConfig r0 = r5.selectorConfig
            int r3 = r0.selectionMode
            if (r3 != r2) goto L_0x0047
            goto L_0x004f
        L_0x0047:
            int r3 = r0.maxVideoSelectNum
            if (r3 <= 0) goto L_0x004c
            goto L_0x004e
        L_0x004c:
            int r3 = r0.maxSelectNum
        L_0x004e:
            r4 = r3
        L_0x004f:
            int r0 = r0.getSelectCount()
            if (r0 == r4) goto L_0x0029
            java.lang.String r0 = r6.getMimeType()
            boolean r0 = com.luck.picture.lib.config.PictureMimeType.isHasImage(r0)
            if (r0 == 0) goto L_0x007a
            goto L_0x0029
        L_0x0060:
            com.luck.picture.lib.config.SelectorConfig r0 = r5.selectorConfig
            int r3 = r0.selectionMode
            if (r3 != r2) goto L_0x0067
            goto L_0x0069
        L_0x0067:
            int r4 = r0.maxSelectNum
        L_0x0069:
            int r0 = r0.getSelectCount()
            if (r0 == r4) goto L_0x0029
            java.lang.String r0 = r6.getMimeType()
            boolean r0 = com.luck.picture.lib.config.PictureMimeType.isHasVideo(r0)
            if (r0 == 0) goto L_0x007a
            goto L_0x0029
        L_0x007a:
            r0 = r1
        L_0x007b:
            if (r0 == 0) goto L_0x0088
            android.widget.ImageView r0 = r5.ivPicture
            android.graphics.ColorFilter r1 = r5.maskWhiteColorFilter
            r0.setColorFilter(r1)
            r6.setMaxSelectEnabledMask(r2)
            goto L_0x008b
        L_0x0088:
            r6.setMaxSelectEnabledMask(r1)
        L_0x008b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luck.picture.lib.adapter.holder.BaseRecyclerMediaHolder.dispatchHandleMask(com.luck.picture.lib.entity.LocalMedia):void");
    }

    public static BaseRecyclerMediaHolder generate(ViewGroup viewGroup, int i11, int i12, SelectorConfig selectorConfig2) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i12, viewGroup, false);
        if (i11 == 1) {
            return new CameraViewHolder(inflate);
        }
        if (i11 == 3) {
            return new VideoViewHolder(inflate, selectorConfig2);
        }
        if (i11 != 4) {
            return new ImageViewHolder(inflate, selectorConfig2);
        }
        return new AudioViewHolder(inflate, selectorConfig2);
    }

    /* access modifiers changed from: private */
    public boolean isSelected(LocalMedia localMedia) {
        LocalMedia compareLocalMedia;
        boolean contains = this.selectorConfig.getSelectedResult().contains(localMedia);
        if (contains && (compareLocalMedia = localMedia.getCompareLocalMedia()) != null && compareLocalMedia.isEditorImage()) {
            localMedia.setCutPath(compareLocalMedia.getCutPath());
            localMedia.setCut(!TextUtils.isEmpty(compareLocalMedia.getCutPath()));
            localMedia.setEditorImage(compareLocalMedia.isEditorImage());
        }
        return contains;
    }

    private void notifySelectNumberStyle(LocalMedia localMedia) {
        this.tvCheck.setText("");
        for (int i11 = 0; i11 < this.selectorConfig.getSelectCount(); i11++) {
            LocalMedia localMedia2 = this.selectorConfig.getSelectedResult().get(i11);
            if (TextUtils.equals(localMedia2.getPath(), localMedia.getPath()) || localMedia2.getId() == localMedia.getId()) {
                localMedia.setNum(localMedia2.getNum());
                localMedia2.setPosition(localMedia.getPosition());
                this.tvCheck.setText(ValueOf.toString(Integer.valueOf(localMedia.getNum())));
            }
        }
    }

    /* access modifiers changed from: private */
    public void selectedMedia(boolean z11) {
        if (this.tvCheck.isSelected() != z11) {
            this.tvCheck.setSelected(z11);
        }
        if (this.selectorConfig.isDirectReturnSingle) {
            this.ivPicture.setColorFilter(this.defaultColorFilter);
        } else {
            this.ivPicture.setColorFilter(z11 ? this.selectColorFilter : this.defaultColorFilter);
        }
    }

    public void bindData(final LocalMedia localMedia, final int i11) {
        localMedia.position = getAbsoluteAdapterPosition();
        selectedMedia(isSelected(localMedia));
        if (this.isSelectNumberStyle) {
            notifySelectNumberStyle(localMedia);
        }
        if (this.isHandleMask && this.selectorConfig.isMaxSelectEnabledMask) {
            dispatchHandleMask(localMedia);
        }
        String path = localMedia.getPath();
        if (localMedia.isEditorImage()) {
            path = localMedia.getCutPath();
        }
        loadCover(path);
        this.tvCheck.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                BaseRecyclerMediaHolder.this.btnCheck.performClick();
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        this.btnCheck.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                OnGridItemSelectAnimListener onGridItemSelectAnimListener;
                if (localMedia.isMaxSelectEnabledMask() || BaseRecyclerMediaHolder.this.listener == null) {
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    return;
                }
                int onSelected = BaseRecyclerMediaHolder.this.listener.onSelected(BaseRecyclerMediaHolder.this.tvCheck, i11, localMedia);
                if (onSelected == -1) {
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    return;
                }
                if (onSelected == 0) {
                    BaseRecyclerMediaHolder baseRecyclerMediaHolder = BaseRecyclerMediaHolder.this;
                    SelectorConfig selectorConfig = baseRecyclerMediaHolder.selectorConfig;
                    if (selectorConfig.isSelectZoomAnim) {
                        OnGridItemSelectAnimListener onGridItemSelectAnimListener2 = selectorConfig.onItemSelectAnimListener;
                        if (onGridItemSelectAnimListener2 != null) {
                            onGridItemSelectAnimListener2.onSelectItemAnim(baseRecyclerMediaHolder.ivPicture, true);
                        } else {
                            AnimUtils.selectZoom(baseRecyclerMediaHolder.ivPicture);
                        }
                    }
                } else if (onSelected == 1) {
                    BaseRecyclerMediaHolder baseRecyclerMediaHolder2 = BaseRecyclerMediaHolder.this;
                    SelectorConfig selectorConfig2 = baseRecyclerMediaHolder2.selectorConfig;
                    if (selectorConfig2.isSelectZoomAnim && (onGridItemSelectAnimListener = selectorConfig2.onItemSelectAnimListener) != null) {
                        onGridItemSelectAnimListener.onSelectItemAnim(baseRecyclerMediaHolder2.ivPicture, false);
                    }
                }
                BaseRecyclerMediaHolder baseRecyclerMediaHolder3 = BaseRecyclerMediaHolder.this;
                baseRecyclerMediaHolder3.selectedMedia(baseRecyclerMediaHolder3.isSelected(localMedia));
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        this.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                if (BaseRecyclerMediaHolder.this.listener == null) {
                    return false;
                }
                BaseRecyclerMediaHolder.this.listener.onItemLongClick(view, i11);
                return false;
            }
        });
        this.itemView.setOnClickListener(new View.OnClickListener() {
            /* JADX WARNING: Code restructure failed: missing block: B:15:0x0044, code lost:
                if (r0.selectionMode != 1) goto L_0x0046;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:21:0x005c, code lost:
                if (r0.selectionMode != 1) goto L_0x005f;
             */
            @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onClick(android.view.View r5) {
                /*
                    r4 = this;
                    com.luck.picture.lib.entity.LocalMedia r0 = r3
                    boolean r0 = r0.isMaxSelectEnabledMask()
                    if (r0 != 0) goto L_0x007f
                    com.luck.picture.lib.adapter.holder.BaseRecyclerMediaHolder r0 = com.luck.picture.lib.adapter.holder.BaseRecyclerMediaHolder.this
                    com.luck.picture.lib.adapter.PictureImageGridAdapter$OnItemClickListener r0 = r0.listener
                    if (r0 != 0) goto L_0x0011
                    goto L_0x007f
                L_0x0011:
                    com.luck.picture.lib.entity.LocalMedia r0 = r3
                    java.lang.String r0 = r0.getMimeType()
                    boolean r0 = com.luck.picture.lib.config.PictureMimeType.isHasImage(r0)
                    r1 = 1
                    if (r0 == 0) goto L_0x0026
                    com.luck.picture.lib.adapter.holder.BaseRecyclerMediaHolder r0 = com.luck.picture.lib.adapter.holder.BaseRecyclerMediaHolder.this
                    com.luck.picture.lib.config.SelectorConfig r0 = r0.selectorConfig
                    boolean r0 = r0.isEnablePreviewImage
                    if (r0 != 0) goto L_0x0060
                L_0x0026:
                    com.luck.picture.lib.adapter.holder.BaseRecyclerMediaHolder r0 = com.luck.picture.lib.adapter.holder.BaseRecyclerMediaHolder.this
                    com.luck.picture.lib.config.SelectorConfig r0 = r0.selectorConfig
                    boolean r0 = r0.isDirectReturnSingle
                    if (r0 != 0) goto L_0x0060
                    com.luck.picture.lib.entity.LocalMedia r0 = r3
                    java.lang.String r0 = r0.getMimeType()
                    boolean r0 = com.luck.picture.lib.config.PictureMimeType.isHasVideo(r0)
                    if (r0 == 0) goto L_0x0046
                    com.luck.picture.lib.adapter.holder.BaseRecyclerMediaHolder r0 = com.luck.picture.lib.adapter.holder.BaseRecyclerMediaHolder.this
                    com.luck.picture.lib.config.SelectorConfig r0 = r0.selectorConfig
                    boolean r2 = r0.isEnablePreviewVideo
                    if (r2 != 0) goto L_0x0060
                    int r0 = r0.selectionMode
                    if (r0 == r1) goto L_0x0060
                L_0x0046:
                    com.luck.picture.lib.entity.LocalMedia r0 = r3
                    java.lang.String r0 = r0.getMimeType()
                    boolean r0 = com.luck.picture.lib.config.PictureMimeType.isHasAudio(r0)
                    if (r0 == 0) goto L_0x005f
                    com.luck.picture.lib.adapter.holder.BaseRecyclerMediaHolder r0 = com.luck.picture.lib.adapter.holder.BaseRecyclerMediaHolder.this
                    com.luck.picture.lib.config.SelectorConfig r0 = r0.selectorConfig
                    boolean r2 = r0.isEnablePreviewAudio
                    if (r2 != 0) goto L_0x0060
                    int r0 = r0.selectionMode
                    if (r0 != r1) goto L_0x005f
                    goto L_0x0060
                L_0x005f:
                    r1 = 0
                L_0x0060:
                    if (r1 == 0) goto L_0x0074
                    com.luck.picture.lib.adapter.holder.BaseRecyclerMediaHolder r0 = com.luck.picture.lib.adapter.holder.BaseRecyclerMediaHolder.this
                    com.luck.picture.lib.adapter.PictureImageGridAdapter$OnItemClickListener r0 = r0.listener
                    com.luck.picture.lib.adapter.holder.BaseRecyclerMediaHolder r1 = com.luck.picture.lib.adapter.holder.BaseRecyclerMediaHolder.this
                    android.widget.TextView r1 = r1.tvCheck
                    int r2 = r4
                    com.luck.picture.lib.entity.LocalMedia r3 = r3
                    r0.onItemClick(r1, r2, r3)
                    goto L_0x007b
                L_0x0074:
                    com.luck.picture.lib.adapter.holder.BaseRecyclerMediaHolder r0 = com.luck.picture.lib.adapter.holder.BaseRecyclerMediaHolder.this
                    android.view.View r0 = r0.btnCheck
                    r0.performClick()
                L_0x007b:
                    com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper.trackViewOnClick(r5)
                    return
                L_0x007f:
                    com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper.trackViewOnClick(r5)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.luck.picture.lib.adapter.holder.BaseRecyclerMediaHolder.AnonymousClass4.onClick(android.view.View):void");
            }
        });
    }

    public void loadCover(String str) {
        ImageEngine imageEngine = this.selectorConfig.imageEngine;
        if (imageEngine != null) {
            imageEngine.loadGridImage(this.ivPicture.getContext(), str, this.ivPicture);
        }
    }

    public void setOnItemClickListener(PictureImageGridAdapter.OnItemClickListener onItemClickListener) {
        this.listener = onItemClickListener;
    }

    public BaseRecyclerMediaHolder(View view, SelectorConfig selectorConfig2) {
        super(view);
        int i11;
        this.selectorConfig = selectorConfig2;
        Context context = view.getContext();
        this.mContext = context;
        this.defaultColorFilter = StyleUtils.getColorFilter(context, R.color.ps_color_20);
        this.selectColorFilter = StyleUtils.getColorFilter(this.mContext, R.color.ps_color_80);
        this.maskWhiteColorFilter = StyleUtils.getColorFilter(this.mContext, R.color.ps_color_half_white);
        SelectMainStyle selectMainStyle = this.selectorConfig.selectorStyle.getSelectMainStyle();
        this.isSelectNumberStyle = selectMainStyle.isSelectNumberStyle();
        this.ivPicture = (ImageView) view.findViewById(R.id.ivPicture);
        this.tvCheck = (TextView) view.findViewById(R.id.tvCheck);
        this.btnCheck = view.findViewById(R.id.btnCheck);
        boolean z11 = true;
        if (selectorConfig2.selectionMode != 1 || !selectorConfig2.isDirectReturnSingle) {
            this.tvCheck.setVisibility(0);
            this.btnCheck.setVisibility(0);
        } else {
            this.tvCheck.setVisibility(8);
            this.btnCheck.setVisibility(8);
        }
        if (selectorConfig2.isDirectReturnSingle || !((i11 = selectorConfig2.selectionMode) == 1 || i11 == 2)) {
            z11 = false;
        }
        this.isHandleMask = z11;
        int adapterSelectTextSize = selectMainStyle.getAdapterSelectTextSize();
        if (StyleUtils.checkSizeValidity(adapterSelectTextSize)) {
            this.tvCheck.setTextSize((float) adapterSelectTextSize);
        }
        int adapterSelectTextColor = selectMainStyle.getAdapterSelectTextColor();
        if (StyleUtils.checkStyleValidity(adapterSelectTextColor)) {
            this.tvCheck.setTextColor(adapterSelectTextColor);
        }
        int selectBackground = selectMainStyle.getSelectBackground();
        if (StyleUtils.checkStyleValidity(selectBackground)) {
            this.tvCheck.setBackgroundResource(selectBackground);
        }
        int[] adapterSelectStyleGravity = selectMainStyle.getAdapterSelectStyleGravity();
        if (StyleUtils.checkArrayValidity(adapterSelectStyleGravity)) {
            if (this.tvCheck.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) this.tvCheck.getLayoutParams()).removeRule(21);
                for (int addRule : adapterSelectStyleGravity) {
                    ((RelativeLayout.LayoutParams) this.tvCheck.getLayoutParams()).addRule(addRule);
                }
            }
            if (this.btnCheck.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) this.btnCheck.getLayoutParams()).removeRule(21);
                for (int addRule2 : adapterSelectStyleGravity) {
                    ((RelativeLayout.LayoutParams) this.btnCheck.getLayoutParams()).addRule(addRule2);
                }
            }
            int adapterSelectClickArea = selectMainStyle.getAdapterSelectClickArea();
            if (StyleUtils.checkSizeValidity(adapterSelectClickArea)) {
                ViewGroup.LayoutParams layoutParams = this.btnCheck.getLayoutParams();
                layoutParams.width = adapterSelectClickArea;
                layoutParams.height = adapterSelectClickArea;
            }
        }
    }
}
