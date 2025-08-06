package com.huobi.view.wraplayout;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.View;

public final class Compat {
    private static final CompatPlusImpl IMPL;

    public static class BaseCompatPlusImpl implements CompatPlusImpl {
        private BaseCompatPlusImpl() {
        }

        public int getPaddingEnd(View view) {
            return view.getPaddingRight();
        }

        public int getPaddingStart(View view) {
            return view.getPaddingLeft();
        }
    }

    public interface CompatPlusImpl {
        int getPaddingEnd(View view);

        int getPaddingStart(View view);
    }

    @TargetApi(17)
    public static class JbMr1CompatPlusImpl extends BaseCompatPlusImpl {
        private JbMr1CompatPlusImpl() {
            super();
        }

        public int getPaddingEnd(View view) {
            return view.getPaddingEnd();
        }

        public int getPaddingStart(View view) {
            return view.getPaddingStart();
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 17) {
            IMPL = new JbMr1CompatPlusImpl();
        } else {
            IMPL = new BaseCompatPlusImpl();
        }
    }

    private Compat() {
    }

    public static int getPaddingEnd(View view) {
        return IMPL.getPaddingEnd(view);
    }

    public static int getPaddingStart(View view) {
        return IMPL.getPaddingStart(view);
    }
}
