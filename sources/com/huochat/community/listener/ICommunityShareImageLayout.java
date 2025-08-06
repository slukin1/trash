package com.huochat.community.listener;

import android.view.View;
import com.huochat.community.model.Size;
import java.io.Serializable;

public interface ICommunityShareImageLayout extends Serializable {
    void loadAsnyImage(View view, String str, Size size);

    void loadImageFinish(String str, boolean z11);
}
