package com.huobi.index.presenter;

import android.content.Context;
import android.view.View;
import java.util.List;

public interface g {

    public interface a {
        void onUpdate();
    }

    public interface b {
        String a();

        String b();

        String c();

        String d(Context context);

        Double e();

        String f();

        View.OnClickListener getOnItemClickListener();

        String getTitle();
    }

    List<? extends b> a();

    void b(boolean z11);

    void onRefresh();
}
