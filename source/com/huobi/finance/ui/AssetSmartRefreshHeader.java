package com.huobi.finance.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.hbg.lib.core.page.SmartRefreshHeader;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import ky.j;

public class AssetSmartRefreshHeader extends SmartRefreshHeader {

    /* renamed from: k  reason: collision with root package name */
    public boolean f46270k;

    /* renamed from: l  reason: collision with root package name */
    public a f46271l;

    public interface a {
        void a(int i11);
    }

    public AssetSmartRefreshHeader(Context context) {
        this(context, (AttributeSet) null);
    }

    public int getArrowViewHeightDp() {
        return 60;
    }

    public void onPulling(float f11, int i11, int i12, int i13) {
        super.onPulling(f11, i11, i12, i13);
        a aVar = this.f46271l;
        if (aVar != null) {
            aVar.a(i11);
        }
        this.f46270k = i11 == 0;
    }

    public void onReleasing(float f11, int i11, int i12, int i13) {
        super.onReleasing(f11, i11, i12, i13);
        a aVar = this.f46271l;
        if (aVar != null) {
            aVar.a(i11);
        }
        this.f46270k = i11 == 0;
    }

    public void onStateChanged(j jVar, RefreshState refreshState, RefreshState refreshState2) {
        super.onStateChanged(jVar, refreshState, refreshState2);
    }

    public void setOnHeightChangeListener(a aVar) {
        this.f46271l = aVar;
    }

    public AssetSmartRefreshHeader(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AssetSmartRefreshHeader(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f46270k = true;
    }
}
