package com.huobi.content.provider;

import android.content.Context;
import android.content.Intent;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.hbg.module.libkt.provider.HbgBaseContentProvider;
import com.huobi.content.ui.TopicListActivity;

@Route(path = "/provider/content/jump")
public class HbgContentProvider implements HbgBaseContentProvider {
    public void init(Context context) {
    }

    public void l(Context context, int i11, String str) {
        Intent intent = new Intent(context, TopicListActivity.class);
        intent.putExtra("fromType", i11);
        intent.putExtra("topicData", str);
        context.startActivity(intent);
    }
}
