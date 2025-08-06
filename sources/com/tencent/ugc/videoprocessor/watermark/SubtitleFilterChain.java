package com.tencent.ugc.videoprocessor.watermark;

import android.graphics.Bitmap;
import com.tencent.liteav.base.util.Size;
import com.tencent.ugc.TXVideoEditConstants;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class SubtitleFilterChain extends PasterBase {
    private CopyOnWriteArrayList<TXVideoEditConstants.TXSubtitle> mNormalizedList = new CopyOnWriteArrayList<>();
    private List<TXVideoEditConstants.TXSubtitle> mSubtitleList;

    private void clearSubtitleList(List<TXVideoEditConstants.TXSubtitle> list) {
        Bitmap bitmap;
        if (list != null) {
            for (TXVideoEditConstants.TXSubtitle next : list) {
                if (!(next == null || (bitmap = next.titleImage) == null || bitmap.isRecycled())) {
                    next.titleImage.recycle();
                    next.titleImage = null;
                }
            }
            list.clear();
        }
    }

    private TXVideoEditConstants.TXSubtitle construct(TXVideoEditConstants.TXSubtitle tXSubtitle, TXVideoEditConstants.TXRect tXRect) {
        TXVideoEditConstants.TXSubtitle tXSubtitle2 = new TXVideoEditConstants.TXSubtitle();
        tXSubtitle2.frame = tXRect;
        tXSubtitle2.titleImage = tXSubtitle.titleImage;
        tXSubtitle2.startTime = tXSubtitle.startTime;
        tXSubtitle2.endTime = tXSubtitle.endTime;
        return tXSubtitle2;
    }

    public void clear() {
        super.clear();
        clearSubtitleList(this.mNormalizedList);
        clearSubtitleList(this.mSubtitleList);
        this.mSubtitleList = null;
    }

    public List<TXVideoEditConstants.TXSubtitle> getSubtitleList() {
        return this.mNormalizedList;
    }

    public void normalized(int i11, int i12, int i13) {
        List<TXVideoEditConstants.TXSubtitle> list = this.mSubtitleList;
        if (list != null && list.size() != 0) {
            for (TXVideoEditConstants.TXSubtitle next : this.mSubtitleList) {
                if (next != null) {
                    this.mNormalizedList.add(construct(next, calculateRect(i11, i12, i13, next.frame)));
                }
            }
        }
    }

    public void setSubtitleList(List<TXVideoEditConstants.TXSubtitle> list, Size size) {
        this.mRenderSize = size;
        this.mSubtitleList = list;
        this.mNormalizedList.clear();
    }
}
