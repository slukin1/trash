package com.tencent.rtmp;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.liteav.base.datareport.Event4XReporter;
import com.tencent.rtmp.a.a;
import com.tencent.ugc.datereport.UGCDataReportDef;
import java.util.List;

public class TXImageSprite {
    private Context mContext;
    private a mImageSprite;

    public TXImageSprite(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public Bitmap getThumbnail(float f11) {
        a aVar = this.mImageSprite;
        if (aVar != null) {
            return aVar.getThumbnail(f11);
        }
        return null;
    }

    public void release() {
        a aVar = this.mImageSprite;
        if (aVar != null) {
            aVar.release();
            this.mImageSprite = null;
        }
    }

    public void setVTTUrlAndImageUrls(String str, List<String> list) {
        if (this.mImageSprite != null) {
            release();
        }
        if (str != null && list != null && list.size() != 0) {
            new Event4XReporter(UGCDataReportDef.COMMAND_ID_DAU, 1004, "", true, 1).reportDau(1555, 0, "");
            a aVar = new a(this.mContext);
            this.mImageSprite = aVar;
            aVar.setVTTUrlAndImageUrls(str, list);
        }
    }
}
