package com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.inputmore;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.InputMoreActionUnit;
import java.util.List;

public class InputMoreLayout extends LinearLayout {
    public InputMoreLayout(Context context) {
        super(context);
        init();
    }

    private void init() {
        LinearLayout.inflate(getContext(), R.layout.chat_inputmore_layout, this);
    }

    public void init(List<InputMoreActionUnit> list) {
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(new ActionsPagerAdapter(viewPager, list));
    }

    public InputMoreLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public InputMoreLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        init();
    }
}
