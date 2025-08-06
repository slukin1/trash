package com.tencent.wxop.stat;

import android.app.ListActivity;

public class EasyListActivity extends ListActivity {
    public void onPause() {
        super.onPause();
        e.m(this);
    }

    public void onResume() {
        super.onResume();
        e.l(this);
    }
}
