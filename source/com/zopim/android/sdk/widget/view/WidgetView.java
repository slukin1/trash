package com.zopim.android.sdk.widget.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.zopim.android.sdk.R;

public class WidgetView extends RelativeLayout {
    private int mPosition;

    public enum Anchor {
        TOP_LEFT(0),
        TOP_RIGHT(1),
        BOTTOM_LEFT(2),
        BOTTOM_RIGHT(3),
        UNKNOWN(-1);
        
        public final int position;

        private Anchor(int i11) {
            this.position = i11;
        }

        public static Anchor getType(int i11) {
            for (Anchor anchor : values()) {
                if (anchor.getValue() == i11) {
                    return anchor;
                }
            }
            return UNKNOWN;
        }

        public int getValue() {
            return this.position;
        }
    }

    public WidgetView(Context context) {
        super(context);
        this.mPosition = Anchor.UNKNOWN.getValue();
    }

    public Anchor getAnchor() {
        return Anchor.getType(this.mPosition);
    }

    public WidgetView(Context context, AttributeSet attributeSet) throws NullPointerException {
        super(context, attributeSet);
        Anchor anchor = Anchor.UNKNOWN;
        this.mPosition = anchor.getValue();
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.WidgetView, 0, 0);
        try {
            this.mPosition = obtainStyledAttributes.getInteger(R.styleable.WidgetView_anchor, anchor.getValue());
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public WidgetView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.mPosition = Anchor.UNKNOWN.getValue();
    }
}
