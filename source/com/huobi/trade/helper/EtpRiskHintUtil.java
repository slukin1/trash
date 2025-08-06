package com.huobi.trade.helper;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.R$color;
import com.hbg.lib.core.R$drawable;
import com.hbg.lib.core.R$string;
import com.hbg.lib.network.hbg.core.bean.EtpRebalInfo;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.m;
import java.math.BigDecimal;
import java.util.Locale;

public final class EtpRiskHintUtil {

    /* renamed from: a  reason: collision with root package name */
    public static int f82008a;

    /* renamed from: b  reason: collision with root package name */
    public static int f82009b;

    public static SpannableStringBuilder a(final Context context, String str, SpannableStringBuilder spannableStringBuilder, String str2, String str3, double d11, String str4, final View.OnClickListener onClickListener) {
        spannableStringBuilder.append(String.format(Locale.ENGLISH, context.getString(R$string.n_trade_etp_reminder_new), new Object[]{str2, str4, str}));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, R$color.baseColorMajorTheme100)), 0, spannableStringBuilder.length(), 17);
        String string = context.getString(R$string.n_trade_etp_introduce);
        int indexOf = StringUtils.g(spannableStringBuilder.toString()).indexOf(StringUtils.g(string));
        if (indexOf >= 0 && string.length() + indexOf <= spannableStringBuilder.length()) {
            spannableStringBuilder.setSpan(new URLSpan(spannableStringBuilder.toString()) {
                @SensorsDataInstrumented
                public void onClick(View view) {
                    View.OnClickListener onClickListener = onClickListener;
                    if (onClickListener != null) {
                        onClickListener.onClick(view);
                    }
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                }

                public void updateDrawState(TextPaint textPaint) {
                    textPaint.setColor(ContextCompat.getColor(context, R$color.baseColorMajorTheme100));
                }
            }, indexOf, string.length() + indexOf, 17);
            spannableStringBuilder.setSpan(new UnderlineSpan(), indexOf, string.length() + indexOf, 17);
        }
        return spannableStringBuilder;
    }

    public static SpannableStringBuilder b(final Context context, boolean z11, String str, String str2, final View.OnClickListener onClickListener) {
        String str3;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (z11) {
            str3 = String.format(Locale.ENGLISH, context.getString(R$string.n_trade_etp_up_explain_hint), new Object[]{str2, str, str2, str2, str, str});
        } else {
            str3 = String.format(Locale.ENGLISH, context.getString(R$string.n_trade_etp_down_explain_hint), new Object[]{str2, str, str2, str2, str, str});
        }
        spannableStringBuilder.append(str3);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, R$color.baseColorPrimaryText)), 0, spannableStringBuilder.length(), 17);
        String string = context.getString(R$string.n_trade_etp_adjust_info);
        int indexOf = StringUtils.g(spannableStringBuilder.toString()).indexOf(StringUtils.g(string));
        if (indexOf >= 0 && string.length() + indexOf <= spannableStringBuilder.length()) {
            spannableStringBuilder.setSpan(new URLSpan(spannableStringBuilder.toString()) {
                @SensorsDataInstrumented
                public void onClick(View view) {
                    View.OnClickListener onClickListener = onClickListener;
                    if (onClickListener != null) {
                        onClickListener.onClick(view);
                    }
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                }

                public void updateDrawState(TextPaint textPaint) {
                    textPaint.setColor(ContextCompat.getColor(context, R$color.baseColorMajorTheme100));
                }
            }, indexOf, string.length() + indexOf, 17);
        }
        String string2 = context.getString(R$string.n_trade_etp_for_reference_only);
        int indexOf2 = StringUtils.g(spannableStringBuilder.toString()).indexOf(StringUtils.g(string2));
        if (indexOf2 >= 0 && string2.length() + indexOf2 <= spannableStringBuilder.length()) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, R$color.otc_trade_desc_hint_color)), indexOf2, string2.length() + indexOf2, 17);
        }
        return spannableStringBuilder;
    }

    public static String c(String str) {
        int length = str.length();
        int i11 = 0;
        while (true) {
            if (i11 >= length) {
                i11 = -1;
                break;
            } else if (Character.isDigit(str.charAt(i11))) {
                break;
            } else {
                i11++;
            }
        }
        return StringUtils.i(i11 > 0 ? str.substring(0, i11) : "");
    }

    public static SpannableStringBuilder d(Context context, EtpRebalInfo etpRebalInfo, SpannableStringBuilder spannableStringBuilder, String str, String str2, double d11, String str3, View.OnClickListener onClickListener, boolean z11, boolean z12) {
        Context context2 = context;
        SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
        if (!z11 || TextUtils.isEmpty(etpRebalInfo.getEquityDeviationRate()) || d11 == 0.0d) {
            SpannableStringBuilder a11 = a(context, String.valueOf(etpRebalInfo.getLeverageRatio()), spannableStringBuilder, str, str2, d11, str3, onClickListener);
            f82008a = R$drawable.shape_trade_risk_reminder_blue_bg;
            f82009b = R$drawable.etp_kline_noticeboard_icon_normal;
            return a11;
        }
        BigDecimal subtract = BigDecimal.ONE.subtract(m.a(etpRebalInfo.getEquityDeviationRate()));
        BigDecimal add = BigDecimal.ONE.add(m.a(etpRebalInfo.getEquityDeviationRate()));
        if (m.a(String.valueOf(d11)).compareTo(m.a(String.valueOf(str2)).multiply(subtract)) < 0 || m.a(String.valueOf(d11)).compareTo(m.a(String.valueOf(str2)).multiply(add)) > 0) {
            spannableStringBuilder.append(String.format(Locale.ENGLISH, context.getString(R$string.n_trade_etp_nat_deviated_greatly), new Object[]{str}));
            if (z12) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, R$color.baseColorMajorTheme100)), 0, spannableStringBuilder.length(), 17);
            } else {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, R$color.baseColorShadeButtonRedStart)), 0, spannableStringBuilder.length(), 17);
            }
            if (z12) {
                f82008a = R$drawable.shape_trade_risk_reminder_blue_bg;
                f82009b = R$drawable.etp_kline_noticeboard_icon_normal;
            } else {
                f82008a = R$drawable.shape_trade_risk_reminder_red_bg;
                f82009b = R$drawable.etp_kline_noticeboard_icon_risk;
            }
            return spannableStringBuilder2;
        }
        SpannableStringBuilder a12 = a(context, String.valueOf(etpRebalInfo.getLeverageRatio()), spannableStringBuilder, str, str2, d11, str3, onClickListener);
        f82008a = R$drawable.shape_trade_risk_reminder_blue_bg;
        f82009b = R$drawable.etp_kline_noticeboard_icon_normal;
        return a12;
    }

    public static int e() {
        return f82008a;
    }

    public static SpannableStringBuilder f(EtpRebalInfo etpRebalInfo, Context context, String str, String str2, String str3, String str4, double d11, int i11, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, String str5, boolean z11, boolean z12) {
        final Context context2 = context;
        final View.OnClickListener onClickListener3 = onClickListener2;
        int i12 = R$drawable.shape_trade_risk_reminder_blue_bg;
        f82008a = i12;
        int i13 = R$drawable.etp_kline_noticeboard_icon_normal;
        f82009b = i13;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (etpRebalInfo == null) {
            SpannableStringBuilder a11 = a(context, String.valueOf(str5), spannableStringBuilder, str, str4, d11, str2, onClickListener);
            f82008a = i12;
            f82009b = i13;
            return a11;
        } else if (m.a(etpRebalInfo.getActualLeverage()).abs().compareTo(m.a(etpRebalInfo.getLeverageCoefficient()).multiply(m.a(String.valueOf(etpRebalInfo.getRebalThreshold()))).abs()) > 0) {
            if (etpRebalInfo.getOptionState() == EtpRebalInfo.OPTION_STATE_NORMAL) {
                spannableStringBuilder.append(String.format(Locale.ENGLISH, context2.getString(R$string.n_trade_etp_will_adjust), new Object[]{str, m.m(etpRebalInfo.getRebalNav(), i11), str3, str2, String.valueOf(etpRebalInfo.getLeverageRatio())}));
                spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context2, R$color.baseColorMajorTheme100)), 0, spannableStringBuilder.length(), 17);
                String string = context2.getString(R$string.n_trade_etp_adjust_info);
                int indexOf = StringUtils.g(spannableStringBuilder.toString()).indexOf(StringUtils.g(string));
                if (indexOf >= 0 && string.length() + indexOf <= spannableStringBuilder.length()) {
                    spannableStringBuilder.setSpan(new URLSpan(spannableStringBuilder.toString()) {
                        @SensorsDataInstrumented
                        public void onClick(View view) {
                            View.OnClickListener onClickListener = onClickListener3;
                            if (onClickListener != null) {
                                onClickListener.onClick(view);
                            }
                            SensorsDataAutoTrackHelper.trackViewOnClick(view);
                        }

                        public void updateDrawState(TextPaint textPaint) {
                            textPaint.setColor(ContextCompat.getColor(context2, R$color.baseColorMajorTheme100));
                        }
                    }, indexOf, string.length() + indexOf, 17);
                    spannableStringBuilder.setSpan(new UnderlineSpan(), indexOf, string.length() + indexOf, 17);
                }
                f82008a = i12;
                f82009b = i13;
                return spannableStringBuilder;
            } else if (etpRebalInfo.getTodayUnTimeRebalTime() == null) {
                return d(context, etpRebalInfo, spannableStringBuilder, str, str4, d11, str2, onClickListener, z11, z12);
            } else {
                spannableStringBuilder.append(String.format(Locale.ENGLISH, context2.getString(R$string.n_trade_etp_did_adjust), new Object[]{str, DateTimeUtils.A(etpRebalInfo.getTodayUnTimeRebalTime().longValue()), str2, String.valueOf(etpRebalInfo.getLeverageRatio())}));
                if (z12) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context2, R$color.baseColorMajorTheme100)), 0, spannableStringBuilder.length(), 17);
                } else {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context2, R$color.baseColorShadeButtonRedStart)), 0, spannableStringBuilder.length(), 17);
                }
                String string2 = context2.getString(R$string.n_trade_etp_adjust_info);
                int indexOf2 = StringUtils.g(spannableStringBuilder.toString()).indexOf(StringUtils.g(string2));
                if (indexOf2 >= 0 && string2.length() + indexOf2 <= spannableStringBuilder.length()) {
                    spannableStringBuilder.setSpan(new URLSpan(spannableStringBuilder.toString()) {
                        @SensorsDataInstrumented
                        public void onClick(View view) {
                            View.OnClickListener onClickListener = onClickListener3;
                            if (onClickListener != null) {
                                onClickListener.onClick(view);
                            }
                            SensorsDataAutoTrackHelper.trackViewOnClick(view);
                        }

                        public void updateDrawState(TextPaint textPaint) {
                            textPaint.setColor(ContextCompat.getColor(context2, R$color.baseColorMajorTheme100));
                        }
                    }, indexOf2, string2.length() + indexOf2, 17);
                    spannableStringBuilder.setSpan(new UnderlineSpan(), indexOf2, string2.length() + indexOf2, 17);
                }
                if (z12) {
                    f82008a = i12;
                    f82009b = i13;
                    return spannableStringBuilder;
                }
                f82008a = R$drawable.shape_trade_risk_reminder_red_bg;
                f82009b = R$drawable.etp_kline_noticeboard_icon_risk;
                return spannableStringBuilder;
            }
        } else if (etpRebalInfo.getTodayUnTimeRebalTime() == null) {
            return d(context, etpRebalInfo, spannableStringBuilder, str, str4, d11, str2, onClickListener, z11, z12);
        } else {
            spannableStringBuilder.append(String.format(Locale.ENGLISH, context2.getString(R$string.n_trade_etp_did_adjust), new Object[]{str, DateTimeUtils.A(etpRebalInfo.getTodayUnTimeRebalTime().longValue()), str2, String.valueOf(etpRebalInfo.getLeverageRatio())}));
            if (z12) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context2, R$color.baseColorMajorTheme100)), 0, spannableStringBuilder.length(), 17);
            } else {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context2, R$color.baseColorShadeButtonRedStart)), 0, spannableStringBuilder.length(), 17);
            }
            String string3 = context2.getString(R$string.n_trade_etp_adjust_info);
            int indexOf3 = StringUtils.g(spannableStringBuilder.toString()).indexOf(StringUtils.g(string3));
            if (indexOf3 >= 0 && string3.length() + indexOf3 <= spannableStringBuilder.length()) {
                spannableStringBuilder.setSpan(new URLSpan(spannableStringBuilder.toString()) {
                    @SensorsDataInstrumented
                    public void onClick(View view) {
                        View.OnClickListener onClickListener = onClickListener3;
                        if (onClickListener != null) {
                            onClickListener.onClick(view);
                        }
                        SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    }

                    public void updateDrawState(TextPaint textPaint) {
                        textPaint.setColor(ContextCompat.getColor(context2, R$color.baseColorMajorTheme100));
                    }
                }, indexOf3, string3.length() + indexOf3, 17);
                spannableStringBuilder.setSpan(new UnderlineSpan(), indexOf3, string3.length() + indexOf3, 17);
            }
            if (z12) {
                f82008a = i12;
                f82009b = i13;
                return spannableStringBuilder;
            }
            f82008a = R$drawable.shape_trade_risk_reminder_red_bg;
            f82009b = R$drawable.etp_kline_noticeboard_icon_risk;
            return spannableStringBuilder;
        }
    }

    public static int g() {
        return f82009b;
    }
}
