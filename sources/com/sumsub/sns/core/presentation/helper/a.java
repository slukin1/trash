package com.sumsub.sns.core.presentation.helper;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.sumsub.sns.R;
import com.sumsub.sns.core.theme.SNSColorElement;
import com.sumsub.sns.core.theme.SNSCustomizationTheme;
import com.sumsub.sns.core.theme.SNSJsonCustomization;
import com.sumsub.sns.core.theme.SNSMetricElement;
import com.sumsub.sns.core.theme.SNSThemeMetric;
import com.sumsub.sns.core.theme.SNSTypographyElement;
import com.sumsub.sns.internal.core.common.e0;
import com.sumsub.sns.internal.core.common.i;
import com.sumsub.sns.internal.core.common.z0;
import com.sumsub.sns.internal.core.theme.ImageElementName;
import com.sumsub.sns.internal.core.theme.b;
import com.sumsub.sns.internal.core.theme.d;
import d10.l;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.x;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f31095a = new a();

    public final d a() {
        SNSJsonCustomization customization = e0.f32018a.getCustomization();
        SNSCustomizationTheme theme = customization != null ? customization.getTheme() : null;
        if (theme instanceof d) {
            return (d) theme;
        }
        return null;
    }

    public final b.e b(d dVar, SNSMetricElement sNSMetricElement) {
        Map<String, b> c11 = dVar.c();
        b bVar = c11 != null ? c11.get(sNSMetricElement.getValue()) : null;
        if (bVar instanceof b.e) {
            return (b.e) bVar;
        }
        return null;
    }

    public final String c(d dVar, SNSMetricElement sNSMetricElement) {
        Map<String, b> c11 = dVar.c();
        b bVar = c11 != null ? c11.get(sNSMetricElement.getValue()) : null;
        b.f fVar = bVar instanceof b.f ? (b.f) bVar : null;
        if (fVar != null) {
            return fVar.b();
        }
        return null;
    }

    public final d a(l<? super d, Unit> lVar) {
        d a11 = a();
        if (a11 == null) {
            return null;
        }
        lVar.invoke(a11);
        return a11;
    }

    public final b.e b(SNSMetricElement sNSMetricElement) {
        d a11 = a();
        if (a11 != null) {
            return b(a11, sNSMetricElement);
        }
        return null;
    }

    public final Integer a(d dVar, SNSColorElement sNSColorElement, boolean z11) {
        b.a aVar;
        Map<String, b.a> a11 = dVar.a();
        if (a11 == null || (aVar = a11.get(sNSColorElement.getValue())) == null) {
            return null;
        }
        return z11 ? aVar.c() : aVar.d();
    }

    public final int[][] b() {
        return new int[][]{new int[]{R.attr.sns_stateInit}, new int[]{R.attr.sns_statePending}, new int[]{R.attr.sns_stateApproved}, new int[]{R.attr.sns_stateRejected}, new int[]{R.attr.sns_stateProcessing}, new int[0]};
    }

    public final Float a(d dVar, SNSMetricElement sNSMetricElement) {
        Map<String, b> c11 = dVar.c();
        b bVar = c11 != null ? c11.get(sNSMetricElement.getValue()) : null;
        b.C0385b bVar2 = bVar instanceof b.C0385b ? (b.C0385b) bVar : null;
        if (bVar2 != null) {
            return bVar2.b();
        }
        return null;
    }

    public final boolean a(View view) {
        return i.a(view.getResources().getConfiguration());
    }

    public final void a(TextView textView, String str) {
        if (x.b(str, SNSThemeMetric.TextAlignment.LEFT.getValue())) {
            textView.setGravity(8388611);
        } else if (x.b(str, SNSThemeMetric.TextAlignment.RIGHT.getValue())) {
            textView.setGravity(8388613);
        } else if (x.b(str, SNSThemeMetric.TextAlignment.CENTER.getValue())) {
            textView.setGravity(17);
        }
    }

    public final void a(View view, SNSColorElement sNSColorElement, int i11, l<? super Integer, Unit> lVar) {
        Integer a11;
        d a12 = a();
        if (!(a12 == null || (a11 = a(a12, sNSColorElement, a(view))) == null)) {
            i11 = a11.intValue();
        }
        lVar.invoke(Integer.valueOf(i11));
    }

    public final Unit a(View view, SNSColorElement sNSColorElement, l<? super Integer, Unit> lVar) {
        Integer a11;
        d a12 = a();
        if (a12 == null || (a11 = a(a12, sNSColorElement, a(view))) == null) {
            return null;
        }
        lVar.invoke(a11);
        return Unit.f56620a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r2 = a(r0, r3, a(r2));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(android.view.View r2, com.sumsub.sns.core.theme.SNSColorElement r3, int r4) {
        /*
            r1 = this;
            com.sumsub.sns.internal.core.theme.d r0 = r1.a()
            if (r0 == 0) goto L_0x0014
            boolean r2 = r1.a((android.view.View) r2)
            java.lang.Integer r2 = r1.a((com.sumsub.sns.internal.core.theme.d) r0, (com.sumsub.sns.core.theme.SNSColorElement) r3, (boolean) r2)
            if (r2 == 0) goto L_0x0014
            int r4 = r2.intValue()
        L_0x0014:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.presentation.helper.a.a(android.view.View, com.sumsub.sns.core.theme.SNSColorElement, int):int");
    }

    public final Integer a(View view, SNSColorElement sNSColorElement) {
        d a11 = a();
        if (a11 != null) {
            return a(a11, sNSColorElement, a(view));
        }
        return null;
    }

    public final Unit a(SNSMetricElement sNSMetricElement, l<? super Float, Unit> lVar) {
        Float a11;
        d a12 = a();
        if (a12 == null || (a11 = a(a12, sNSMetricElement)) == null) {
            return null;
        }
        lVar.invoke(a11);
        return Unit.f56620a;
    }

    public final Float a(SNSMetricElement sNSMetricElement) {
        d a11 = a();
        if (a11 != null) {
            return a(a11, sNSMetricElement);
        }
        return null;
    }

    public final Drawable a(Context context, String str) {
        return e0.f32018a.getIconHandler().onResolveIcon(context, str);
    }

    public static /* synthetic */ d a(a aVar, View view, Integer num, ColorStateList colorStateList, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            num = null;
        }
        if ((i11 & 2) != 0) {
            colorStateList = null;
        }
        return aVar.a(view, num, colorStateList);
    }

    public static /* synthetic */ ColorStateList a(a aVar, boolean z11, Integer num, ColorStateList colorStateList, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            num = null;
        }
        if ((i11 & 4) != 0) {
            colorStateList = null;
        }
        return aVar.a(z11, num, colorStateList);
    }

    public final BitmapDrawable a(d dVar, String str) {
        Bitmap e11;
        Map<String, b> b11 = dVar.b();
        b bVar = b11 != null ? b11.get(str) : null;
        b.c cVar = bVar instanceof b.c ? (b.c) bVar : null;
        if (cVar == null || (e11 = cVar.e()) == null) {
            return null;
        }
        return new BitmapDrawable(e11);
    }

    public final BitmapDrawable a(d dVar, String str, String str2) {
        Map<String, b.c> b11;
        b.c cVar;
        Map<String, b.c> b12;
        b.c cVar2;
        Map<String, b> b13 = dVar.b();
        b bVar = b13 != null ? b13.get(str2) : null;
        b.d dVar2 = bVar instanceof b.d ? (b.d) bVar : null;
        Bitmap e11 = (dVar2 == null || (b12 = dVar2.b()) == null || (cVar2 = b12.get(str)) == null) ? null : cVar2.e();
        Bitmap e12 = (dVar2 == null || (b11 = dVar2.b()) == null || (cVar = b11.get("default")) == null) ? null : cVar.e();
        if (e11 == null) {
            e11 = e12;
        }
        if (e11 != null) {
            return new BitmapDrawable(e11);
        }
        return null;
    }

    public final d a(TextView textView, SNSTypographyElement sNSTypographyElement, SNSColorElement sNSColorElement) {
        b.g gVar;
        d a11 = a();
        if (a11 == null) {
            return null;
        }
        Map<String, b.g> d11 = a11.d();
        if (!(d11 == null || (gVar = d11.get(sNSTypographyElement.getValue())) == null)) {
            Typeface h11 = gVar.h();
            if (h11 != null) {
                textView.setTypeface(h11);
            }
            textView.setTextSize((float) gVar.g());
        }
        a aVar = f31095a;
        Integer a12 = aVar.a(a11, sNSColorElement, aVar.a((View) textView));
        if (a12 != null) {
            int intValue = a12.intValue();
            if (textView instanceof EditText) {
                textView.setTextColor(new ColorStateList(new int[][]{new int[]{-16842910}, new int[0]}, new int[]{Color.argb(95, Color.red(intValue), Color.green(intValue), Color.blue(intValue)), intValue}));
            } else {
                textView.setTextColor(intValue);
            }
        }
        Integer a13 = aVar.a(a11, SNSColorElement.CONTENT_LINK, aVar.a((View) textView));
        if (a13 == null) {
            return a11;
        }
        textView.setLinkTextColor(a13.intValue());
        return a11;
    }

    public final Drawable a(String str) {
        d a11 = a();
        if (a11 == null) {
            return null;
        }
        if (StringsKt__StringsJVMKt.M(str, "DocType/", false, 2, (Object) null)) {
            return f31095a.a(a11, z0.a((List<String>) StringsKt__StringsKt.K0(StringsKt__StringsKt.W0(str, "/", (String) null, 2, (Object) null), new char[]{'_'}, false, 0, 6, (Object) null)), ImageElementName.VERIFICATION_STEP_ICONS.getValue());
        } else if (StringsKt__StringsJVMKt.M(str, "default/", false, 2, (Object) null)) {
            return f31095a.a(a11, str, ImageElementName.INSTRUCTIONS_IMAGES.getValue());
        } else {
            if (StringsKt__StringsJVMKt.M(str, "IdentityType/", false, 2, (Object) null)) {
                return f31095a.a(a11, StringsKt__StringsKt.W0(str, "/", (String) null, 2, (Object) null), ImageElementName.DOCUMENT_TYPE_ICONS.getValue());
            }
            return f31095a.a(a11, str);
        }
    }

    public final d a(View view, Integer num, ColorStateList colorStateList) {
        d a11 = a();
        if (a11 == null) {
            return null;
        }
        a aVar = f31095a;
        ColorStateList a12 = aVar.a(aVar.a(view), num, colorStateList);
        if (view instanceof ImageView) {
            ((ImageView) view).setImageTintList(a12);
            return a11;
        } else if (!(view instanceof TextView)) {
            return a11;
        } else {
            ((TextView) view).setTextColor(a12);
            return a11;
        }
    }

    public final ColorStateList a(boolean z11, Integer num, ColorStateList colorStateList) {
        d a11 = a();
        if (a11 != null) {
            if (num == null && (num = f31095a.a(a11, SNSColorElement.CONTENT_NEUTRAL, z11)) == null) {
                num = colorStateList != null ? Integer.valueOf(colorStateList.getColorForState(new int[]{R.attr.sns_stateInit}, -65281)) : null;
            }
            a aVar = f31095a;
            SNSColorElement sNSColorElement = SNSColorElement.CONTENT_WARNING;
            Integer a12 = aVar.a(a11, sNSColorElement, z11);
            if (a12 == null) {
                a12 = colorStateList != null ? Integer.valueOf(colorStateList.getColorForState(new int[]{R.attr.sns_statePending}, -65281)) : null;
                if (a12 == null) {
                    a12 = num;
                }
            }
            Integer a13 = aVar.a(a11, SNSColorElement.CONTENT_SUCCESS, z11);
            if (a13 == null) {
                a13 = colorStateList != null ? Integer.valueOf(colorStateList.getColorForState(new int[]{R.attr.sns_stateApproved}, -65281)) : null;
                if (a13 == null) {
                    a13 = num;
                }
            }
            Integer a14 = aVar.a(a11, SNSColorElement.CONTENT_CRITICAL, z11);
            if (a14 == null) {
                a14 = colorStateList != null ? Integer.valueOf(colorStateList.getColorForState(new int[]{R.attr.sns_stateRejected}, -65281)) : null;
                if (a14 == null) {
                    a14 = num;
                }
            }
            Integer a15 = aVar.a(a11, sNSColorElement, z11);
            if (a15 == null) {
                a15 = colorStateList != null ? Integer.valueOf(colorStateList.getColorForState(new int[]{R.attr.sns_stateProcessing}, -65281)) : null;
                if (a15 == null) {
                    a15 = num;
                }
            }
            Integer a16 = aVar.a(a11, SNSColorElement.CONTENT_WEAK, z11);
            if (a16 == null) {
                a16 = colorStateList != null ? Integer.valueOf(colorStateList.getDefaultColor()) : null;
                if (a16 == null) {
                    a16 = num;
                }
            }
            if (num != null) {
                return new ColorStateList(aVar.b(), new int[]{num.intValue(), a12.intValue(), a13.intValue(), a14.intValue(), a15.intValue(), a16.intValue()});
            }
        }
        return null;
    }
}
