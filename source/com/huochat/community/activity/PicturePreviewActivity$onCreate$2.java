package com.huochat.community.activity;

import androidx.viewpager.widget.ViewPager;
import com.huochat.community.model.MediaBean;

public final class PicturePreviewActivity$onCreate$2 implements ViewPager.OnPageChangeListener {
    public final /* synthetic */ PicturePreviewActivity this$0;

    public PicturePreviewActivity$onCreate$2(PicturePreviewActivity picturePreviewActivity) {
        this.this$0 = picturePreviewActivity;
    }

    public void onPageScrollStateChanged(int i11) {
        if (i11 == 0) {
            int currentItem = this.this$0.hackyViewPagerCircleImage.getCurrentItem();
            PicturePreviewActivity picturePreviewActivity = this.this$0;
            picturePreviewActivity.setCurrenturl(((MediaBean) picturePreviewActivity.mediaBeans.get(currentItem)).imageUrl);
        }
    }

    public void onPageScrolled(int i11, float f11, int i12) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0018, code lost:
        r6 = r6.getAdapter();
     */
    @android.annotation.SuppressLint({"StringFormatMatches"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onPageSelected(int r6) {
        /*
            r5 = this;
            com.huochat.community.activity.PicturePreviewActivity r0 = r5.this$0
            int r1 = com.huochat.community.R.string.bm_viewpager_indicator
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 1
            int r6 = r6 + r3
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r4 = 0
            r2[r4] = r6
            com.huochat.community.activity.PicturePreviewActivity r6 = r5.this$0
            com.huochat.community.widget.HackyViewPager r6 = r6.hackyViewPagerCircleImage
            if (r6 == 0) goto L_0x0027
            androidx.viewpager.widget.PagerAdapter r6 = r6.getAdapter()
            if (r6 == 0) goto L_0x0027
            int r6 = r6.getCount()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            goto L_0x0028
        L_0x0027:
            r6 = 0
        L_0x0028:
            r2[r3] = r6
            java.lang.String r6 = r0.getString(r1, r2)
            com.huochat.community.activity.PicturePreviewActivity r0 = r5.this$0
            android.widget.TextView r0 = r0.indicator
            if (r0 != 0) goto L_0x0037
            goto L_0x003a
        L_0x0037:
            r0.setText(r6)
        L_0x003a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huochat.community.activity.PicturePreviewActivity$onCreate$2.onPageSelected(int):void");
    }
}
