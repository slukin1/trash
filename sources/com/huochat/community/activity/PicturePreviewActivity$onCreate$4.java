package com.huochat.community.activity;

import android.app.SharedElementCallback;
import android.view.View;
import com.huochat.community.fragment.FragmentPicturePreview;
import com.huochat.community.model.MediaBean;
import java.util.List;
import java.util.Map;

public final class PicturePreviewActivity$onCreate$4 extends SharedElementCallback {
    public final /* synthetic */ PicturePreviewActivity this$0;

    public PicturePreviewActivity$onCreate$4(PicturePreviewActivity picturePreviewActivity) {
        this.this$0 = picturePreviewActivity;
    }

    public void onMapSharedElements(List<String> list, Map<String, View> map) {
        try {
            map.clear();
            String str = ((MediaBean) this.this$0.mediaBeans.get(this.this$0.hackyViewPagerCircleImage.getCurrentItem())).imageUrl;
            FragmentPicturePreview fragmentPicturePreview = (FragmentPicturePreview) this.this$0.fragmentHashMap.get(str);
            map.put(str, fragmentPicturePreview != null ? fragmentPicturePreview.getSharedElement() : null);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }
}
