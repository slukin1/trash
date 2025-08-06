package net.lucode.hackware.magicindicator.buildins.commonnavigator.titles;

import android.content.Context;
import net.lucode.hackware.magicindicator.buildins.ArgbEvaluatorHolder;

public class ColorTransitionPagerTitleView extends SimplePagerTitleView {
    public ColorTransitionPagerTitleView(Context context) {
        super(context);
    }

    public void onDeselected(int i11, int i12) {
    }

    public void onEnter(int i11, int i12, float f11, boolean z11) {
        setTextColor(ArgbEvaluatorHolder.a(f11, this.f58526c, this.f58525b));
    }

    public void onLeave(int i11, int i12, float f11, boolean z11) {
        setTextColor(ArgbEvaluatorHolder.a(f11, this.f58525b, this.f58526c));
    }

    public void onSelected(int i11, int i12) {
    }
}
