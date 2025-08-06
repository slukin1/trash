package com.huochat.community.fragment;

import android.app.Activity;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.app.ActivityCompat;
import com.bumptech.glide.request.e;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.ImageViewState;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huochat.community.CommunityManager;
import com.huochat.community.R;
import com.huochat.community.base.BaseChildFragment;
import com.huochat.community.model.MediaBean;
import com.huochat.community.util.ContextTool;
import com.huochat.community.util.FileTool;
import com.huochat.community.util.ImageLoadedrManager;
import com.huochat.community.util.ImageUtil;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.d;
import java.io.File;
import java.io.IOException;
import kotlin.jvm.internal.r;
import uk.co.senab.photoview.PhotoView;

public final class FragmentPicturePreview extends BaseChildFragment {
    public static final Companion Companion = new Companion((r) null);
    private MediaBean mediaBean;
    private PhotoView photoView;
    private PopupWindows popupWindows;
    private String qrCode;
    private SubsamplingScaleImageView subScaleView;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public final FragmentPicturePreview newInstance(MediaBean mediaBean) {
            FragmentPicturePreview fragmentPicturePreview = new FragmentPicturePreview();
            Bundle bundle = new Bundle();
            bundle.putSerializable("mediaBean", mediaBean);
            fragmentPicturePreview.setArguments(bundle);
            return fragmentPicturePreview;
        }
    }

    public final class PopupWindows extends PopupWindow {
        private final TextView tvIdentiryQRCode;

        public PopupWindows(Context context, View view) {
            View inflate = View.inflate(context, R.layout.view_image_preview_oprate_menu, (ViewGroup) null);
            inflate.startAnimation(AnimationUtils.loadAnimation(context, R.anim.bm_fade_ins));
            TextView textView = (TextView) inflate.findViewById(R.id.tv_menu_item_identify_qrcode);
            this.tvIdentiryQRCode = textView;
            ((LinearLayout) inflate.findViewById(R.id.linear_layout_popup)).startAnimation(AnimationUtils.loadAnimation(context, R.anim.bm_push_bottom_in_2));
            setWidth(-1);
            setHeight(-1);
            setBackgroundDrawable(new BitmapDrawable());
            setFocusable(true);
            setOutsideTouchable(true);
            setContentView(inflate);
            update();
            ((TextView) inflate.findViewById(R.id.item_popupwindows_Photo)).setOnClickListener(new g(this));
            ((TextView) inflate.findViewById(R.id.item_popupwindows_cancel)).setOnClickListener(new j(this));
            inflate.setOnClickListener(new h(this));
            textView.setOnClickListener(new i(this));
        }

        /* access modifiers changed from: private */
        @SensorsDataInstrumented
        public static final void _init_$lambda$0(PopupWindows popupWindows, View view) {
            popupWindows.dismiss();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        /* access modifiers changed from: private */
        @SensorsDataInstrumented
        public static final void _init_$lambda$1(PopupWindows popupWindows, View view) {
            popupWindows.dismiss();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        /* access modifiers changed from: private */
        @SensorsDataInstrumented
        public static final void _init_$lambda$2(PopupWindows popupWindows, View view) {
            popupWindows.dismiss();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        /* access modifiers changed from: private */
        @SensorsDataInstrumented
        public static final void _init_$lambda$3(PopupWindows popupWindows, View view) {
            popupWindows.dismiss();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        public final void setQRVisible(boolean z11) {
            this.tvIdentiryQRCode.setVisibility(z11 ? 0 : 8);
        }
    }

    /* access modifiers changed from: private */
    public final void closePage() {
        if (ContextTool.checkActivity((Activity) getActivity())) {
            ActivityCompat.finishAfterTransition(getActivity());
        }
    }

    private final void copyFile(String str, String str2) {
        File file = new File(str);
        if (file.exists()) {
            File file2 = new File(str2);
            if (!file2.exists()) {
                try {
                    file2.createNewFile();
                    file2.setLastModified(System.currentTimeMillis());
                    FileTool.copyFile(file, file2);
                    if (file2.length() > 0) {
                        scanGalleryImg(file2.getAbsolutePath());
                    }
                } catch (IOException e11) {
                    e11.printStackTrace();
                }
            }
        }
    }

    private final int getImageDefResource() {
        if (CommunityManager.Companion.getInstance().isNightModel()) {
            return R.drawable.ic_def_huobi_icon_night;
        }
        return R.drawable.ic_def_huobi_icon_light;
    }

    private final float getImageScale(Context context, String str, int i11, int i12) {
        try {
            if (!TextUtils.isEmpty(str)) {
                int[] imageWH = ImageUtil.getImageWH(str);
                if ((imageWH != null && imageWH.length == 2 && imageWH[0] > 0 && imageWH[1] > 0) && i11 > 0 && i12 > 0 && !(i11 == imageWH[0] && i12 == imageWH[1])) {
                    return ImageUtil.getImageScale(imageWH[0], imageWH[1]);
                }
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return ImageUtil.getImageScale(i11, i12);
    }

    private final String getThumbnailUrl(String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(CommunityManager.Companion.getInstance().getBaseUrl());
        sb2.append("/fileservice/file/oss/im/image/");
        return StringsKt__StringsJVMKt.M(str, sb2.toString(), false, 2, (Object) null) ? ImageUtil.getImageDisplayUrl(str, 1) : "";
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public static final void initView$lambda$0(FragmentPicturePreview fragmentPicturePreview, View view) {
        fragmentPicturePreview.closePage();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public final void resetSubScaleViewImageShowSize(String str, int i11, int i12) {
        PhotoView photoView2 = this.photoView;
        if (photoView2 != null) {
            photoView2.setVisibility(8);
        }
        try {
            SubsamplingScaleImageView subsamplingScaleImageView = this.subScaleView;
            if (subsamplingScaleImageView != null) {
                subsamplingScaleImageView.setVisibility(0);
                float imageScale = getImageScale(getContext(), str, i11, i12);
                subsamplingScaleImageView.setMinimumScaleType(3);
                subsamplingScaleImageView.setTileBackgroundColor(-1);
                subsamplingScaleImageView.setMinScale(0.8f * imageScale);
                subsamplingScaleImageView.setDoubleTapZoomScale(imageScale);
                subsamplingScaleImageView.setMaxScale(((float) 2) * imageScale);
                subsamplingScaleImageView.setImage(ImageSource.uri(Uri.fromFile(new File(str))), new ImageViewState(imageScale, new PointF(0.0f, 0.0f), 0));
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    private final void scanGalleryImg(String str) {
        try {
            MediaScannerConnection.scanFile(getContext(), new String[]{str}, (String[]) null, new d(this));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public static final void scanGalleryImg$lambda$3(FragmentPicturePreview fragmentPicturePreview, String str, Uri uri) {
        fragmentPicturePreview.getActivity().runOnUiThread(f.f38693b);
    }

    /* access modifiers changed from: private */
    public static final void scanGalleryImg$lambda$3$lambda$2() {
        HuobiToastUtil.m(BaseApplication.c(R.string.activity_group_qrcode_tpybcxc));
    }

    public final String getLargeImageDisplayUrl(String str) {
        d.b("#### [Community] PicturePreview  url（原图）: " + str);
        if (!TextUtils.isEmpty(str) && StringsKt__StringsJVMKt.M(str, "http", false, 2, (Object) null)) {
            str = ImageUtil.getImageDisplayUrl((Context) getActivity(), str);
        }
        d.b("#### [Community] PicturePreview  url（处理）: " + str);
        return str == null ? "" : str;
    }

    public int getLayoutId() {
        return R.layout.fragment_picture_preview;
    }

    public final View getSharedElement() {
        if (this.photoView.getVisibility() == 0) {
            return this.photoView;
        }
        return this.subScaleView;
    }

    public void initData(Bundle bundle) {
        int i11;
        Bundle arguments = getArguments();
        boolean z11 = true;
        if (arguments == null || !arguments.containsKey("mediaBean")) {
            z11 = false;
        }
        if (z11) {
            this.mediaBean = (MediaBean) arguments.getSerializable("mediaBean");
        }
        MediaBean mediaBean2 = this.mediaBean;
        if (mediaBean2 != null) {
            int imageDefResource = getImageDefResource();
            d.b("#### [Community] PicturePreview  width: " + mediaBean2.width + ", height:" + mediaBean2.height);
            int i12 = mediaBean2.width;
            if (i12 <= 0 || (i11 = mediaBean2.height) <= 0 || i11 < i12 * 3) {
                SubsamplingScaleImageView subsamplingScaleImageView = this.subScaleView;
                if (subsamplingScaleImageView != null) {
                    subsamplingScaleImageView.setVisibility(8);
                }
                PhotoView photoView2 = this.photoView;
                if (photoView2 != null) {
                    photoView2.setVisibility(0);
                }
                if (ContextTool.checkActivity((Activity) getActivity())) {
                    ImageLoadedrManager.getInstance().display((Context) getActivity(), ImageUtil.getOriginalUrl(mediaBean2.imageUrl), getThumbnailUrl(mediaBean2.imageUrl), (e) new FragmentPicturePreview$initData$1$2(), (ImageView) this.photoView, imageDefResource);
                    return;
                }
                return;
            }
            String thumbnailUrl = getThumbnailUrl(mediaBean2.imageUrl);
            String imageDisplayUrl = ImageUtil.getImageDisplayUrl(mediaBean2.imageUrl, 4);
            d.b("#### [Community] PicturePreview  url（缩略）: " + thumbnailUrl);
            ImageLoadedrManager.getInstance().displayLarge((Context) getActivity(), imageDisplayUrl, thumbnailUrl, (ImageView) this.photoView, imageDefResource);
            String largeImageDisplayUrl = getLargeImageDisplayUrl(mediaBean2.imageUrl);
            if (!StringsKt__StringsJVMKt.M(largeImageDisplayUrl, "http", false, 2, (Object) null)) {
                resetSubScaleViewImageShowSize(largeImageDisplayUrl, mediaBean2.width, mediaBean2.height);
            } else if (ContextTool.checkActivity((Activity) getActivity())) {
                ImageLoadedrManager.getInstance().downloadFile(getActivity(), largeImageDisplayUrl, new FragmentPicturePreview$initData$1$1(this, mediaBean2));
            }
        }
    }

    /* JADX WARNING: type inference failed for: r4v2, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void initView(android.view.View r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 == 0) goto L_0x000c
            int r1 = com.huochat.community.R.id.photoView
            android.view.View r1 = r4.findViewById(r1)
            uk.co.senab.photoview.PhotoView r1 = (uk.co.senab.photoview.PhotoView) r1
            goto L_0x000d
        L_0x000c:
            r1 = r0
        L_0x000d:
            r3.photoView = r1
            if (r1 == 0) goto L_0x0019
            com.huochat.community.fragment.FragmentPicturePreview$initView$1 r2 = new com.huochat.community.fragment.FragmentPicturePreview$initView$1
            r2.<init>(r3)
            r1.setOnPhotoTapListener(r2)
        L_0x0019:
            if (r4 == 0) goto L_0x0024
            int r0 = com.huochat.community.R.id.subScaleView
            android.view.View r4 = r4.findViewById(r0)
            r0 = r4
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView r0 = (com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView) r0
        L_0x0024:
            r3.subScaleView = r0
            if (r0 == 0) goto L_0x0030
            com.huochat.community.fragment.e r4 = new com.huochat.community.fragment.e
            r4.<init>(r3)
            r0.setOnClickListener(r4)
        L_0x0030:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huochat.community.fragment.FragmentPicturePreview.initView(android.view.View):void");
    }

    public final void saveImageToGallery(String str) {
    }
}
