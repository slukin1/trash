package com.iproov.sdk.p018import;

import android.content.Context;
import com.iproov.sdk.R;
import kotlin.jvm.internal.r;

/* renamed from: com.iproov.sdk.import.if  reason: invalid class name and invalid package */
public final class Cif extends Cdo {

    /* renamed from: case  reason: not valid java name */
    private static final float[] f977case = {0.517f, 0.509f, 0.501f, 0.493f, 0.485f, 0.477f, 0.4691f, 0.4611f, 0.4532f, 0.4453f, 0.4374f, 0.4296f, 0.4217f, 0.4139f, 0.4061f, 0.3984f, 0.3907f, 0.383f, 0.3753f, 0.3677f, 0.3601f, 0.3525f, 0.345f, 0.3375f, 0.3301f, 0.3227f, 0.3154f, 0.3081f, 0.3008f, 0.2936f, 0.2865f, 0.2794f, 0.2723f, 0.2653f, 0.2584f, 0.2515f, 0.2447f, 0.238f, 0.2313f, 0.2246f, 0.2181f, 0.2116f, 0.2051f, 0.1988f, 0.1925f, 0.1863f, 0.1801f, 0.1741f, 0.1681f, 0.1622f, 0.1564f, 0.1506f, 0.1449f, 0.1394f, 0.1339f, 0.1285f, 0.1232f, 0.1179f, 0.1128f, 0.1078f, 0.1028f, 0.098f, 0.0932f, 0.0886f, 0.084f, 0.0796f, 0.0752f, 0.071f, 0.0669f, 0.0628f, 0.0589f, 0.0551f, 0.0514f, 0.0479f, 0.0444f, 0.0411f, 0.0379f, 0.0348f, 0.0318f, 0.0289f, 0.0262f, 0.0236f, 0.0211f, 0.0188f, 0.0165f, 0.0145f, 0.0125f, 0.0107f, 0.009f, 0.0075f, 0.0061f, 0.0048f, 0.0037f, 0.0027f, 0.0019f, 0.0012f, 7.0E-4f, 3.0E-4f, 1.0E-4f};

    /* renamed from: for  reason: not valid java name */
    private static final float[] f978for = {0.4877f, 0.4756f, 0.4637f, 0.452f, 0.4404f, 0.4291f, 0.4179f, 0.4069f, 0.3962f, 0.3856f, 0.3751f, 0.3649f, 0.3548f, 0.3449f, 0.3352f, 0.3257f, 0.3163f, 0.3072f, 0.2981f, 0.2893f, 0.2806f, 0.2721f, 0.2637f, 0.2555f, 0.2475f, 0.2396f, 0.2319f, 0.2244f, 0.217f, 0.2097f, 0.2026f, 0.1957f, 0.1889f, 0.1823f, 0.1758f, 0.1694f, 0.1632f, 0.1571f, 0.1512f, 0.1454f, 0.1398f, 0.1343f, 0.1289f, 0.1237f, 0.1186f, 0.1136f, 0.1088f, 0.104f, 0.0995f, 0.095f, 0.0907f, 0.0864f, 0.0824f, 0.0784f, 0.0745f, 0.0708f, 0.0672f, 0.0636f, 0.0602f, 0.057f, 0.0538f, 0.0507f, 0.0478f, 0.0449f, 0.0421f, 0.0395f, 0.0369f, 0.0345f, 0.0321f, 0.0299f, 0.0277f, 0.0257f, 0.0237f, 0.0218f, 0.02f, 0.0183f, 0.0167f, 0.0151f, 0.0137f, 0.0123f, 0.011f, 0.0098f, 0.0087f, 0.0076f, 0.0067f, 0.0058f, 0.0049f, 0.0042f, 0.0035f, 0.0028f, 0.0023f, 0.0018f, 0.0014f, 0.001f, 7.0E-4f, 4.0E-4f, 2.0E-4f, 1.0E-4f, 0.0f};

    /* renamed from: new  reason: not valid java name */
    private static final float[] f979new = {0.9999f, 0.9998f, 0.9994f, 0.999f, 0.9985f, 0.9978f, 0.997f, 0.9961f, 0.9951f, 0.9939f, 0.9927f, 0.9913f, 0.9898f, 0.9882f, 0.9865f, 0.9847f, 0.9827f, 0.9807f, 0.9785f, 0.9763f, 0.9739f, 0.9714f, 0.9689f, 0.9662f, 0.9634f, 0.9605f, 0.9575f, 0.9544f, 0.9512f, 0.948f, 0.9446f, 0.9411f, 0.9375f, 0.9338f, 0.9301f, 0.9262f, 0.9223f, 0.9182f, 0.9141f, 0.9098f, 0.9055f, 0.9011f, 0.8966f, 0.892f, 0.8874f, 0.8826f, 0.8778f, 0.8729f, 0.8679f, 0.8628f, 0.8577f, 0.8524f, 0.8471f, 0.8417f, 0.8362f, 0.8307f, 0.8251f, 0.8194f, 0.8136f, 0.8078f, 0.8018f, 0.7959f, 0.7898f, 0.7837f, 0.7775f, 0.7712f, 0.7649f, 0.7585f, 0.7521f, 0.7456f, 0.739f, 0.7324f, 0.7256f, 0.7189f, 0.7121f, 0.7052f, 0.6983f, 0.6913f, 0.6842f, 0.6771f, 0.67f, 0.6628f, 0.6555f, 0.6482f, 0.6408f, 0.6334f, 0.626f, 0.6185f, 0.6109f, 0.6033f, 0.5957f, 0.588f, 0.5802f, 0.5725f, 0.5647f, 0.5568f, 0.5489f, 0.541f, 0.533f};

    /* renamed from: try  reason: not valid java name */
    private static final float[] f980try = {1.0E-4f, 2.0E-4f, 5.0E-4f, 9.0E-4f, 0.0013f, 0.0019f, 0.0026f, 0.0034f, 0.0043f, 0.0054f, 0.0065f, 0.0077f, 0.009f, 0.0105f, 0.012f, 0.0137f, 0.0154f, 0.0173f, 0.0192f, 0.0213f, 0.0234f, 0.0257f, 0.0281f, 0.0306f, 0.0331f, 0.0358f, 0.0386f, 0.0415f, 0.0444f, 0.0475f, 0.0507f, 0.054f, 0.0574f, 0.0609f, 0.0644f, 0.0681f, 0.0719f, 0.0758f, 0.0798f, 0.0838f, 0.088f, 0.0923f, 0.0967f, 0.1011f, 0.1057f, 0.1104f, 0.1151f, 0.12f, 0.1249f, 0.13f, 0.1351f, 0.1404f, 0.1457f, 0.1512f, 0.1567f, 0.1623f, 0.168f, 0.1739f, 0.1798f, 0.1858f, 0.1919f, 0.198f, 0.2043f, 0.2107f, 0.2172f, 0.2237f, 0.2304f, 0.2371f, 0.244f, 0.2509f, 0.2579f, 0.265f, 0.2722f, 0.2795f, 0.2869f, 0.2943f, 0.3019f, 0.3096f, 0.3173f, 0.3251f, 0.333f, 0.341f, 0.3491f, 0.3573f, 0.3656f, 0.3739f, 0.3824f, 0.3909f, 0.3995f, 0.4082f, 0.417f, 0.4259f, 0.4349f, 0.4439f, 0.4531f, 0.4623f, 0.4716f, 0.481f, 0.4904f};

    /* renamed from: if  reason: not valid java name */
    private float f981if = 0.9f;

    /* renamed from: com.iproov.sdk.import.if$do  reason: invalid class name */
    public static final class Cdo {
        private Cdo() {
        }

        public /* synthetic */ Cdo(r rVar) {
            this();
        }
    }

    static {
        new Cdo((r) null);
    }

    public Cif(Context context) {
        this.f966do = com.iproov.sdk.p029super.Cif.m1880do(context, R.raw.vertex_default, R.raw.fragment_blur_with_hoval);
    }

    /* renamed from: do  reason: not valid java name */
    public final void m1084do(float f11) {
        this.f981if = f11;
    }

    /* renamed from: for  reason: not valid java name */
    public void m1085for() {
        Cdo.m1064do(m1070do("totalPoints"), 99);
        Cdo.m1063do(m1070do("animationDuration"), 0.6f);
        Cdo.m1063do(m1070do("hovalWidthScale"), this.f981if);
        Cdo.m1065do(m1070do("ht_x"), f978for);
        Cdo.m1065do(m1070do("ht_y"), f979new);
        Cdo.m1065do(m1070do("hb_x"), f980try);
        Cdo.m1065do(m1070do("hb_y"), f977case);
    }
}
