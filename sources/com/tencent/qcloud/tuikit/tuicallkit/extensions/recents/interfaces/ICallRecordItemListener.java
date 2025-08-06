package com.tencent.qcloud.tuikit.tuicallkit.extensions.recents.interfaces;

import android.view.View;
import com.tencent.qcloud.tuikit.tuicallengine.TUICallDefine;

public interface ICallRecordItemListener {
    void onDetailViewClick(View view, TUICallDefine.CallRecords callRecords);

    void onItemClick(View view, int i11, TUICallDefine.CallRecords callRecords);

    void onItemDeleteClick(View view, int i11, TUICallDefine.CallRecords callRecords);
}
