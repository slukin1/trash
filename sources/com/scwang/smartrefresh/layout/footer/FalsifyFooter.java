package com.scwang.smartrefresh.layout.footer;

import android.content.Context;
import android.util.AttributeSet;
import com.scwang.smartrefresh.layout.header.FalsifyHeader;
import ky.f;
import ky.i;

public class FalsifyFooter extends FalsifyHeader implements f {
    public FalsifyFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onInitialized(i iVar, int i11, int i12) {
        super.onInitialized(iVar, i11, i12);
        iVar.f().f(false);
    }

    public boolean setNoMoreData(boolean z11) {
        return false;
    }

    public FalsifyFooter(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
