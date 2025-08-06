package com.huobi.view.chart.animation;

import android.animation.TimeInterpolator;

public class Easing {
    private static final float DOUBLE_PI = 6.2831855f;
    public static final EasingFunction EaseInBack = new EasingFunction() {
        public float getInterpolation(float f11) {
            return f11 * f11 * ((f11 * 2.70158f) - 1.70158f);
        }
    };
    public static final EasingFunction EaseInBounce = new EasingFunction() {
        public float getInterpolation(float f11) {
            return 1.0f - Easing.EaseOutBounce.getInterpolation(1.0f - f11);
        }
    };
    public static final EasingFunction EaseInCirc = new EasingFunction() {
        public float getInterpolation(float f11) {
            return -(((float) Math.sqrt((double) (1.0f - (f11 * f11)))) - 1.0f);
        }
    };
    public static final EasingFunction EaseInCubic = new EasingFunction() {
        public float getInterpolation(float f11) {
            return (float) Math.pow((double) f11, 3.0d);
        }
    };
    public static final EasingFunction EaseInElastic = new EasingFunction() {
        public float getInterpolation(float f11) {
            if (f11 == 0.0f) {
                return 0.0f;
            }
            if (f11 == 1.0f) {
                return 1.0f;
            }
            float f12 = f11 - 1.0f;
            return -(((float) Math.pow(2.0d, (double) (10.0f * f12))) * ((float) Math.sin((double) (((f12 - (0.047746483f * ((float) Math.asin(1.0d)))) * Easing.DOUBLE_PI) / 0.3f))));
        }
    };
    public static final EasingFunction EaseInExpo = new EasingFunction() {
        public float getInterpolation(float f11) {
            if (f11 == 0.0f) {
                return 0.0f;
            }
            return (float) Math.pow(2.0d, (double) ((f11 - 1.0f) * 10.0f));
        }
    };
    public static final EasingFunction EaseInOutBack = new EasingFunction() {
        public float getInterpolation(float f11) {
            float f12 = f11 * 2.0f;
            if (f12 < 1.0f) {
                return f12 * f12 * ((3.5949094f * f12) - 2.5949094f) * 0.5f;
            }
            float f13 = f12 - 2.0f;
            return ((f13 * f13 * ((3.5949094f * f13) + 2.5949094f)) + 2.0f) * 0.5f;
        }
    };
    public static final EasingFunction EaseInOutBounce = new EasingFunction() {
        public float getInterpolation(float f11) {
            if (f11 < 0.5f) {
                return Easing.EaseInBounce.getInterpolation(f11 * 2.0f) * 0.5f;
            }
            return (Easing.EaseOutBounce.getInterpolation((f11 * 2.0f) - 1.0f) * 0.5f) + 0.5f;
        }
    };
    public static final EasingFunction EaseInOutCirc = new EasingFunction() {
        public float getInterpolation(float f11) {
            float f12 = f11 * 2.0f;
            if (f12 < 1.0f) {
                return (((float) Math.sqrt((double) (1.0f - (f12 * f12)))) - 1.0f) * -0.5f;
            }
            float f13 = f12 - 2.0f;
            return (((float) Math.sqrt((double) (1.0f - (f13 * f13)))) + 1.0f) * 0.5f;
        }
    };
    public static final EasingFunction EaseInOutCubic = new EasingFunction() {
        public float getInterpolation(float f11) {
            float pow;
            float f12 = f11 * 2.0f;
            if (f12 < 1.0f) {
                pow = (float) Math.pow((double) f12, 3.0d);
            } else {
                pow = ((float) Math.pow((double) (f12 - 2.0f), 3.0d)) + 2.0f;
            }
            return pow * 0.5f;
        }
    };
    public static final EasingFunction EaseInOutElastic = new EasingFunction() {
        public float getInterpolation(float f11) {
            if (f11 == 0.0f) {
                return 0.0f;
            }
            float f12 = f11 * 2.0f;
            if (f12 == 2.0f) {
                return 1.0f;
            }
            float asin = ((float) Math.asin(1.0d)) * 0.07161972f;
            if (f12 < 1.0f) {
                float f13 = f12 - 1.0f;
                return ((float) Math.pow(2.0d, (double) (10.0f * f13))) * ((float) Math.sin((double) (((f13 * 1.0f) - asin) * Easing.DOUBLE_PI * 2.2222223f))) * -0.5f;
            }
            float f14 = f12 - 1.0f;
            return (((float) Math.pow(2.0d, (double) (-10.0f * f14))) * 0.5f * ((float) Math.sin((double) (((f14 * 1.0f) - asin) * Easing.DOUBLE_PI * 2.2222223f)))) + 1.0f;
        }
    };
    public static final EasingFunction EaseInOutExpo = new EasingFunction() {
        public float getInterpolation(float f11) {
            float f12;
            if (f11 == 0.0f) {
                return 0.0f;
            }
            if (f11 == 1.0f) {
                return 1.0f;
            }
            float f13 = f11 * 2.0f;
            if (f13 < 1.0f) {
                f12 = (float) Math.pow(2.0d, (double) ((f13 - 1.0f) * 10.0f));
            } else {
                f12 = (-((float) Math.pow(2.0d, (double) ((f13 - 1.0f) * -10.0f)))) + 2.0f;
            }
            return f12 * 0.5f;
        }
    };
    public static final EasingFunction EaseInOutQuad = new EasingFunction() {
        public float getInterpolation(float f11) {
            float f12 = f11 * 2.0f;
            if (f12 < 1.0f) {
                return 0.5f * f12 * f12;
            }
            float f13 = f12 - 1.0f;
            return ((f13 * (f13 - 2.0f)) - 1.0f) * -0.5f;
        }
    };
    public static final EasingFunction EaseInOutQuart = new EasingFunction() {
        public float getInterpolation(float f11) {
            float f12 = f11 * 2.0f;
            if (f12 < 1.0f) {
                return ((float) Math.pow((double) f12, 4.0d)) * 0.5f;
            }
            return (((float) Math.pow((double) (f12 - 2.0f), 4.0d)) - 2.0f) * -0.5f;
        }
    };
    public static final EasingFunction EaseInOutSine = new EasingFunction() {
        public float getInterpolation(float f11) {
            return (((float) Math.cos(((double) f11) * 3.141592653589793d)) - 1.0f) * -0.5f;
        }
    };
    public static final EasingFunction EaseInQuad = new EasingFunction() {
        public float getInterpolation(float f11) {
            return f11 * f11;
        }
    };
    public static final EasingFunction EaseInQuart = new EasingFunction() {
        public float getInterpolation(float f11) {
            return (float) Math.pow((double) f11, 4.0d);
        }
    };
    public static final EasingFunction EaseInSine = new EasingFunction() {
        public float getInterpolation(float f11) {
            return (-((float) Math.cos(((double) f11) * 1.5707963267948966d))) + 1.0f;
        }
    };
    public static final EasingFunction EaseOutBack = new EasingFunction() {
        public float getInterpolation(float f11) {
            float f12 = f11 - 1.0f;
            return (f12 * f12 * ((f12 * 2.70158f) + 1.70158f)) + 1.0f;
        }
    };
    public static final EasingFunction EaseOutBounce = new EasingFunction() {
        public float getInterpolation(float f11) {
            if (f11 < 0.36363637f) {
                return 7.5625f * f11 * f11;
            }
            if (f11 < 0.72727275f) {
                float f12 = f11 - 0.54545456f;
                return (7.5625f * f12 * f12) + 0.75f;
            } else if (f11 < 0.90909094f) {
                float f13 = f11 - 0.8181818f;
                return (7.5625f * f13 * f13) + 0.9375f;
            } else {
                float f14 = f11 - 0.95454544f;
                return (7.5625f * f14 * f14) + 0.984375f;
            }
        }
    };
    public static final EasingFunction EaseOutCirc = new EasingFunction() {
        public float getInterpolation(float f11) {
            float f12 = f11 - 1.0f;
            return (float) Math.sqrt((double) (1.0f - (f12 * f12)));
        }
    };
    public static final EasingFunction EaseOutCubic = new EasingFunction() {
        public float getInterpolation(float f11) {
            return ((float) Math.pow((double) (f11 - 1.0f), 3.0d)) + 1.0f;
        }
    };
    public static final EasingFunction EaseOutElastic = new EasingFunction() {
        public float getInterpolation(float f11) {
            if (f11 == 0.0f) {
                return 0.0f;
            }
            if (f11 == 1.0f) {
                return 1.0f;
            }
            return (((float) Math.pow(2.0d, (double) (-10.0f * f11))) * ((float) Math.sin((double) (((f11 - (0.047746483f * ((float) Math.asin(1.0d)))) * Easing.DOUBLE_PI) / 0.3f)))) + 1.0f;
        }
    };
    public static final EasingFunction EaseOutExpo = new EasingFunction() {
        public float getInterpolation(float f11) {
            if (f11 == 1.0f) {
                return 1.0f;
            }
            return -((float) Math.pow(2.0d, (double) ((f11 + 1.0f) * -10.0f)));
        }
    };
    public static final EasingFunction EaseOutQuad = new EasingFunction() {
        public float getInterpolation(float f11) {
            return (-f11) * (f11 - 2.0f);
        }
    };
    public static final EasingFunction EaseOutQuart = new EasingFunction() {
        public float getInterpolation(float f11) {
            return -(((float) Math.pow((double) (f11 - 1.0f), 4.0d)) - 1.0f);
        }
    };
    public static final EasingFunction EaseOutSine = new EasingFunction() {
        public float getInterpolation(float f11) {
            return (float) Math.sin(((double) f11) * 1.5707963267948966d);
        }
    };
    public static final EasingFunction Linear = new EasingFunction() {
        public float getInterpolation(float f11) {
            return f11;
        }
    };

    public interface EasingFunction extends TimeInterpolator {
        float getInterpolation(float f11);
    }
}
