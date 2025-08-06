package com.tencent.ugc.videoprocessor.watermark;

import android.graphics.Bitmap;
import com.tencent.liteav.base.util.Size;
import com.tencent.ugc.TXVideoEditConstants;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class PasterFilterChain extends PasterBase {
    private CopyOnWriteArrayList<TXVideoEditConstants.TXPaster> mNormalizedList = new CopyOnWriteArrayList<>();
    private List<TXVideoEditConstants.TXPaster> mPasterList;

    private void clearPasterList(List<TXVideoEditConstants.TXPaster> list) {
        Bitmap bitmap;
        if (list != null) {
            for (TXVideoEditConstants.TXPaster next : list) {
                if (!(next == null || (bitmap = next.pasterImage) == null || bitmap.isRecycled())) {
                    next.pasterImage.recycle();
                    next.pasterImage = null;
                }
            }
            list.clear();
        }
    }

    private TXVideoEditConstants.TXPaster construct(TXVideoEditConstants.TXPaster tXPaster, TXVideoEditConstants.TXRect tXRect) {
        TXVideoEditConstants.TXPaster tXPaster2 = new TXVideoEditConstants.TXPaster();
        tXPaster2.frame = tXRect;
        tXPaster2.pasterImage = tXPaster.pasterImage;
        tXPaster2.startTime = tXPaster.startTime;
        tXPaster2.endTime = tXPaster.endTime;
        return tXPaster2;
    }

    public void clear() {
        super.clear();
        clearPasterList(this.mNormalizedList);
        clearPasterList(this.mPasterList);
        this.mPasterList = null;
    }

    public List<TXVideoEditConstants.TXPaster> getPasterList() {
        return this.mNormalizedList;
    }

    public void normalized(int i11, int i12, int i13) {
        List<TXVideoEditConstants.TXPaster> list = this.mPasterList;
        if (list != null && list.size() != 0) {
            for (TXVideoEditConstants.TXPaster next : this.mPasterList) {
                if (next != null) {
                    TXVideoEditConstants.TXRect calculateRect = calculateRect(i11, i12, i13, next.frame);
                    if (calculateRect != null) {
                        this.mNormalizedList.add(construct(next, calculateRect));
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public void setPasterList(List<TXVideoEditConstants.TXPaster> list, Size size) {
        this.mRenderSize = size;
        this.mPasterList = list;
        clearPasterList(this.mNormalizedList);
    }
}
