package com.huobi.view.showcaseview;

import android.widget.RelativeLayout;

public interface ShowcaseViewApi {
    void hide();

    boolean isShowing();

    void setBlocksTouches(boolean z11);

    void setButtonPosition(RelativeLayout.LayoutParams layoutParams);

    void setContentText(CharSequence charSequence);

    void setContentTitle(CharSequence charSequence);

    void setHideOnTouchOutside(boolean z11);

    void setStyle(int i11);

    void show();
}
