package com.huochat.community.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.m;
import com.huochat.community.CommunityManager;
import com.huochat.community.CommunityThemeHelper;
import com.huochat.community.R;
import com.huochat.community.listener.ICommunityShareImageLayout;
import com.huochat.community.model.Size;
import com.huochat.community.util.DisplayTool;
import com.huochat.community.util.ImageLoadedrManager;
import com.huochat.community.util.glideformation.LongImageFitStart;
import java.io.Serializable;
import java.util.List;
import n3.c;
import n3.g;

public final class CommunityShareImageAdapter extends RecyclerView.Adapter<ImageViewHolder> implements Serializable, ICommunityShareImageLayout {
    private Context mContext;
    private List<String> mDataList;
    private boolean mHasLinkMessage;
    private final float mImageMaxHeight = 180.0f;
    private final float mImageMinWidth = 115.0f;
    private final int mImageRadius = DisplayTool.dp2px(4.0f);
    private final float mLargeImageWidth = 140.0f;
    private LayoutInflater mLayoutInflater;
    private volatile int mLoadImageSuccessCount;
    private int mMaxViewWidth;
    private OnImageLoadFinishCallback mOnImageLoadFinishCallback;
    private List<Size> mSizeList;

    public final class ImageViewHolder extends RecyclerView.ViewHolder {
        private View itemRootView;
        private Context mContext;

        public ImageViewHolder(Context context, View view) {
            super(view);
            this.mContext = context;
            this.itemRootView = view;
        }

        public final void bindData(String str, Size size, ICommunityShareImageLayout iCommunityShareImageLayout) {
            if (iCommunityShareImageLayout != null) {
                iCommunityShareImageLayout.loadAsnyImage(this.itemRootView, str, size);
            }
        }
    }

    public interface OnImageLoadFinishCallback {
        void callback(Boolean bool, int i11);
    }

    public CommunityShareImageAdapter(Context context, int i11) {
        this.mContext = context;
        initInflater(context);
        this.mMaxViewWidth = i11;
    }

    private final void displayImage(Context context, String str, boolean z11, ImageView imageView) {
        if (str == null || str.length() == 0) {
            loadImageFinish(str, false);
            return;
        }
        int imageDefResource = getImageDefResource();
        if (z11) {
            ImageLoadedrManager.getInstance().displayWithTransform(context, str, imageDefResource, imageView, new LongImageFitStart(this.mImageRadius, this.mImageMaxHeight / this.mLargeImageWidth), new CommunityShareImageAdapter$displayImage$1(imageView, this, str));
            return;
        }
        ImageLoadedrManager.getInstance().displayWithTransform(context, str, imageDefResource, imageView, new c((g<T>[]) new g[]{new CenterCrop(), new m(this.mImageRadius)}), new CommunityShareImageAdapter$displayImage$2(this, str));
    }

    private final ViewGroup.LayoutParams getGroupLayoutParams(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        return layoutParams == null ? new ViewGroup.LayoutParams(-2, -2) : layoutParams;
    }

    private final int getImageDefResource() {
        if (CommunityManager.Companion.getInstance().isNightModel()) {
            return R.drawable.ic_def_huobi_icon_night;
        }
        return R.drawable.ic_def_huobi_icon_light;
    }

    private final void initInflater(Context context) {
        LayoutInflater layoutInflater;
        if (context == null) {
            layoutInflater = LayoutInflater.from(context);
        } else {
            layoutInflater = LayoutInflater.from(context).cloneInContext(CommunityThemeHelper.Companion.getThemeContext(context));
        }
        this.mLayoutInflater = layoutInflater;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0083  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void loadImages(android.content.Context r16, java.lang.String r17, android.view.View r18, com.huochat.community.model.Size r19, int r20) {
        /*
            r15 = this;
            r0 = r15
            r1 = r18
            r2 = r20
            if (r1 != 0) goto L_0x0008
            return
        L_0x0008:
            int r3 = com.huochat.community.R.id.ivCommunityPicItem
            android.view.View r3 = r1.findViewById(r3)
            android.widget.ImageView r3 = (android.widget.ImageView) r3
            int r4 = com.huochat.community.R.id.tvLongImageMark
            android.view.View r4 = r1.findViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r5 = 8
            r4.setVisibility(r5)
            r5 = 0
            r6 = 1
            if (r2 != r6) goto L_0x0095
            if (r19 == 0) goto L_0x0095
            int r2 = r19.getWidth()
            int r7 = r19.getHeight()
            float r8 = r0.mImageMaxHeight
            int r8 = com.huochat.community.util.DisplayTool.dp2px(r8)
            float r9 = r0.mImageMinWidth
            int r9 = com.huochat.community.util.DisplayTool.dp2px(r9)
            float r10 = r0.mLargeImageWidth
            int r10 = com.huochat.community.util.DisplayTool.dp2px(r10)
            float r11 = (float) r7
            r12 = 1075838976(0x40200000, float:2.5)
            float r13 = (float) r2
            float r12 = r12 * r13
            int r12 = (r11 > r12 ? 1 : (r11 == r12 ? 0 : -1))
            if (r12 < 0) goto L_0x0060
            r4.setVisibility(r5)
            android.view.ViewGroup$LayoutParams r1 = r15.getGroupLayoutParams(r1)
            r1.width = r10
            r1.height = r8
            android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_START
            r3.setScaleType(r1)
            r15.setImageViewLayoutParams(r3, r10, r8)
            r1 = r16
            r2 = r17
            r5 = r6
            goto L_0x00f2
        L_0x0060:
            float r4 = r13 / r11
            float r10 = (float) r9
            float r12 = (float) r8
            float r14 = r10 / r12
            int r4 = (r4 > r14 ? 1 : (r4 == r14 ? 0 : -1))
            if (r4 > 0) goto L_0x006d
            r7 = r8
        L_0x006b:
            r2 = r9
            goto L_0x0079
        L_0x006d:
            if (r2 >= r9) goto L_0x0073
            float r11 = r11 * r10
            float r11 = r11 / r13
            int r7 = (int) r11
            goto L_0x006b
        L_0x0073:
            if (r7 <= r8) goto L_0x0079
            float r13 = r13 * r12
            float r13 = r13 / r11
            int r2 = (int) r13
            r7 = r8
        L_0x0079:
            int r4 = r0.mMaxViewWidth
            if (r6 > r4) goto L_0x0080
            if (r4 >= r2) goto L_0x0080
            goto L_0x0081
        L_0x0080:
            r6 = r5
        L_0x0081:
            if (r6 == 0) goto L_0x0084
            r2 = r4
        L_0x0084:
            android.view.ViewGroup$LayoutParams r1 = r15.getGroupLayoutParams(r1)
            r1.width = r2
            r1.height = r7
            android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.CENTER_CROP
            r3.setScaleType(r1)
            r15.setImageViewLayoutParams(r3, r2, r7)
            goto L_0x00ee
        L_0x0095:
            if (r2 != r6) goto L_0x00b6
            android.view.ViewGroup$LayoutParams r2 = r15.getGroupLayoutParams(r1)
            r4 = -2
            r2.width = r4
            r4 = 1130233856(0x435e0000, float:222.0)
            int r4 = com.huochat.community.util.DisplayTool.dp2px(r4)
            r2.height = r4
            r1.setLayoutParams(r2)
            android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.CENTER_CROP
            r3.setScaleType(r1)
            int r1 = r2.width
            int r2 = r2.height
            r15.setImageViewLayoutParams(r3, r1, r2)
            goto L_0x00ee
        L_0x00b6:
            r4 = 1119092736(0x42b40000, float:90.0)
            int r4 = com.huochat.community.util.DisplayTool.dp2px(r4)
            r6 = 2
            if (r2 != r6) goto L_0x00ce
            int r2 = r0.mMaxViewWidth
            float r2 = (float) r2
            r4 = 1109393408(0x42200000, float:40.0)
            int r4 = com.huochat.community.util.DisplayTool.dp2px(r4)
        L_0x00c8:
            float r4 = (float) r4
            float r2 = r2 - r4
            float r4 = (float) r6
            float r2 = r2 / r4
            int r4 = (int) r2
            goto L_0x00db
        L_0x00ce:
            r6 = 3
            if (r2 < r6) goto L_0x00db
            int r2 = r0.mMaxViewWidth
            float r2 = (float) r2
            r4 = 1112014848(0x42480000, float:50.0)
            int r4 = com.huochat.community.util.DisplayTool.dp2px(r4)
            goto L_0x00c8
        L_0x00db:
            android.view.ViewGroup$LayoutParams r2 = r15.getGroupLayoutParams(r1)
            r2.width = r4
            r2.height = r4
            r1.setLayoutParams(r2)
            android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.CENTER_CROP
            r3.setScaleType(r1)
            r15.setImageViewLayoutParams(r3, r4, r4)
        L_0x00ee:
            r1 = r16
            r2 = r17
        L_0x00f2:
            r15.displayImage(r1, r2, r5, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huochat.community.adapter.CommunityShareImageAdapter.loadImages(android.content.Context, java.lang.String, android.view.View, com.huochat.community.model.Size, int):void");
    }

    private final void setImageViewLayoutParams(ImageView imageView, int i11, int i12) {
        if (imageView != null) {
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(i11, i12);
            }
            layoutParams.width = i11;
            layoutParams.height = i12;
            imageView.setLayoutParams(layoutParams);
        }
    }

    public int getItemCount() {
        List<String> list = this.mDataList;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public final int getMImageRadius() {
        return this.mImageRadius;
    }

    public void loadAsnyImage(View view, String str, Size size) {
        Context context = this.mContext;
        if (context != null) {
            loadImages(context, str, view, size, getItemCount());
        }
    }

    public void loadImageFinish(String str, boolean z11) {
        OnImageLoadFinishCallback onImageLoadFinishCallback = this.mOnImageLoadFinishCallback;
        if (onImageLoadFinishCallback != null) {
            synchronized (Integer.valueOf(this.mLoadImageSuccessCount)) {
                this.mLoadImageSuccessCount++;
            }
            if (this.mLoadImageSuccessCount == getItemCount()) {
                onImageLoadFinishCallback.callback(Boolean.TRUE, this.mLoadImageSuccessCount);
            }
        }
    }

    public final void notifyLayoutChanged(int i11) {
        this.mMaxViewWidth = i11;
        notifyDataSetChanged();
    }

    public final void setData(List<String> list, List<Size> list2, boolean z11, OnImageLoadFinishCallback onImageLoadFinishCallback) {
        this.mDataList = list;
        this.mSizeList = list2;
        this.mHasLinkMessage = z11;
        this.mOnImageLoadFinishCallback = onImageLoadFinishCallback;
        notifyDataSetChanged();
    }

    public void onBindViewHolder(ImageViewHolder imageViewHolder, int i11) {
        List<Size> list = this.mSizeList;
        String str = null;
        Size size = ((list == null || list.isEmpty()) || i11 >= this.mSizeList.size()) ? null : this.mSizeList.get(i11);
        List<String> list2 = this.mDataList;
        if (list2 != null) {
            str = list2.get(i11);
        }
        imageViewHolder.bindData(str, size, this);
    }

    public ImageViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
        LayoutInflater layoutInflater = this.mLayoutInflater;
        if (layoutInflater == null) {
            layoutInflater = null;
        }
        return new ImageViewHolder(this.mContext, layoutInflater.inflate(R.layout.item_community_share_image_list, (ViewGroup) null, false));
    }
}
