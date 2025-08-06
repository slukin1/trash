package rl;

import a7.e;
import android.content.Context;
import android.graphics.Paint;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.future.util.FuturePrecisionUtil;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.option.core.bean.OptionMarketIndexInfo;
import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import com.hbg.module.market.R$string;
import com.huobi.homemarket.bean.MarketOptionSettingBean;
import com.huobi.homemarket.bean.OptionFieldTitleEnum;
import com.xiaomi.mipush.sdk.Constants;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import uo.a;

public final class m {
    public static void a(Context context, OptionMarketIndexInfo optionMarketIndexInfo, int i11, TextView textView, float f11, SymbolPrice symbolPrice) {
        if (optionMarketIndexInfo == null) {
            textView.setText((CharSequence) null);
            return;
        }
        textView.setText(e(context, optionMarketIndexInfo, i11, symbolPrice));
        textView.setWidth((int) f11);
    }

    public static List<MarketOptionSettingBean> b(Context context) {
        ArrayList arrayList = new ArrayList();
        String d11 = ConfigPreferences.d("user_config", "option_title_field");
        OptionFieldTitleEnum optionFieldTitleEnum = OptionFieldTitleEnum.OPTION_FIELD_TITLE_7;
        arrayList.add(new MarketOptionSettingBean(4, optionFieldTitleEnum, f(optionFieldTitleEnum, d11, context)));
        OptionFieldTitleEnum optionFieldTitleEnum2 = OptionFieldTitleEnum.OPTION_FIELD_TITLE_8;
        arrayList.add(new MarketOptionSettingBean(4, optionFieldTitleEnum2, f(optionFieldTitleEnum2, d11, context)));
        OptionFieldTitleEnum optionFieldTitleEnum3 = OptionFieldTitleEnum.OPTION_FIELD_TITLE_9;
        arrayList.add(new MarketOptionSettingBean(4, optionFieldTitleEnum3, f(optionFieldTitleEnum3, d11, context)));
        OptionFieldTitleEnum optionFieldTitleEnum4 = OptionFieldTitleEnum.OPTION_FIELD_TITLE_10;
        arrayList.add(new MarketOptionSettingBean(4, optionFieldTitleEnum4, f(optionFieldTitleEnum4, d11, context)));
        OptionFieldTitleEnum optionFieldTitleEnum5 = OptionFieldTitleEnum.OPTION_FIELD_TITLE_11;
        arrayList.add(new MarketOptionSettingBean(4, optionFieldTitleEnum5, f(optionFieldTitleEnum5, d11, context)));
        OptionFieldTitleEnum optionFieldTitleEnum6 = OptionFieldTitleEnum.OPTION_FIELD_TITLE_12;
        arrayList.add(new MarketOptionSettingBean(4, optionFieldTitleEnum6, f(optionFieldTitleEnum6, d11, context)));
        return arrayList;
    }

    public static float c(Context context, OptionMarketIndexInfo optionMarketIndexInfo, int i11, SymbolPrice symbolPrice, Paint paint) {
        return d(e(context, optionMarketIndexInfo, i11, symbolPrice).toString(), paint);
    }

    public static float d(String str, Paint paint) {
        return paint.measureText(str) + ((float) PixelUtils.a(30.0f));
    }

    public static Spanned e(Context context, OptionMarketIndexInfo optionMarketIndexInfo, int i11, SymbolPrice symbolPrice) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (optionMarketIndexInfo == null) {
            return spannableStringBuilder;
        }
        String str = "";
        boolean z11 = true;
        switch (i11) {
            case 0:
                spannableStringBuilder.append(e.y(optionMarketIndexInfo.getOptionRightType(), context));
                break;
            case 1:
                if (TextUtils.isEmpty(optionMarketIndexInfo.getBidOne())) {
                    spannableStringBuilder.append("--");
                    break;
                } else {
                    String m11 = i6.m.m(optionMarketIndexInfo.getBidOne(), FuturePrecisionUtil.y((String) null, (String) null, optionMarketIndexInfo.getOptionCode()));
                    spannableStringBuilder.append(i6.m.c(m11, m11));
                    break;
                }
            case 2:
                if (TextUtils.isEmpty(optionMarketIndexInfo.getMarkPrice())) {
                    spannableStringBuilder.append("--");
                    break;
                } else {
                    String m12 = i6.m.m(optionMarketIndexInfo.getMarkPrice(), FuturePrecisionUtil.y((String) null, (String) null, optionMarketIndexInfo.getOptionCode()));
                    spannableStringBuilder.append(i6.m.c(m12, m12));
                    break;
                }
            case 3:
                if (TextUtils.isEmpty(optionMarketIndexInfo.getIvMarkPrice())) {
                    spannableStringBuilder.append("--");
                    break;
                } else {
                    spannableStringBuilder.append(i6.m.Q(optionMarketIndexInfo.getIvMarkPrice(), 2, RoundingMode.DOWN.ordinal()));
                    break;
                }
            case 4:
                if (TextUtils.isEmpty(optionMarketIndexInfo.getAskOne())) {
                    spannableStringBuilder.append("--");
                    break;
                } else {
                    String m13 = i6.m.m(optionMarketIndexInfo.getAskOne(), FuturePrecisionUtil.y((String) null, (String) null, optionMarketIndexInfo.getOptionCode()));
                    spannableStringBuilder.append(i6.m.c(m13, m13));
                    break;
                }
            case 5:
                if (TextUtils.isEmpty(optionMarketIndexInfo.getDelta())) {
                    spannableStringBuilder.append("--");
                    break;
                } else {
                    String u11 = i6.m.u(optionMarketIndexInfo.getDelta(), 6);
                    spannableStringBuilder.append(i6.m.c(u11, u11));
                    break;
                }
            case 6:
                spannableStringBuilder.append(a.b(optionMarketIndexInfo.getIndexPrice(), optionMarketIndexInfo.getMarkPrice(), optionMarketIndexInfo.getAskOne(), false, context));
                break;
            case 7:
                if (symbolPrice == null) {
                    spannableStringBuilder.append("--");
                    break;
                } else {
                    double doubleValue = symbolPrice.getClose().doubleValue();
                    double doubleValue2 = symbolPrice.getOpen().doubleValue();
                    double d11 = doubleValue - doubleValue2;
                    if (Double.compare(d11, 0.0d) <= 0) {
                        z11 = false;
                    }
                    if (Double.compare(doubleValue, 0.0d) == 0) {
                        spannableStringBuilder.append("--");
                        break;
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        if (z11) {
                            str = "+";
                        }
                        sb2.append(str);
                        sb2.append(i6.m.i((d11 / doubleValue2) * 100.0d, PrecisionUtil.v(optionMarketIndexInfo.getSymbol())));
                        sb2.append("%");
                        spannableStringBuilder.append(sb2.toString());
                        if (!z11) {
                            if (Double.compare(d11, 0.0d) >= 0) {
                                spannableStringBuilder.setSpan(new ForegroundColorSpan(context.getResources().getColor(w.e())), 0, spannableStringBuilder.length(), 17);
                                break;
                            } else {
                                spannableStringBuilder.setSpan(new ForegroundColorSpan(context.getResources().getColor(w.d())), 0, spannableStringBuilder.length(), 17);
                                break;
                            }
                        } else {
                            spannableStringBuilder.setSpan(new ForegroundColorSpan(context.getResources().getColor(w.h())), 0, spannableStringBuilder.length(), 17);
                            break;
                        }
                    }
                }
            case 8:
                if (!e.E(TradeType.OPTION)) {
                    if (TextUtils.isEmpty(optionMarketIndexInfo.getVolume())) {
                        spannableStringBuilder.append("--");
                        break;
                    } else {
                        spannableStringBuilder.append(context.getString(R$string.contract_hold_num_value, new Object[]{i6.m.m(optionMarketIndexInfo.getVolume(), 0)}));
                        break;
                    }
                } else if (TextUtils.isEmpty(optionMarketIndexInfo.getAmount())) {
                    spannableStringBuilder.append("--");
                    break;
                } else {
                    String m14 = i6.m.m(optionMarketIndexInfo.getAmount(), FuturePrecisionUtil.s(optionMarketIndexInfo.getContractCode(), str, optionMarketIndexInfo.getOptionCode()));
                    spannableStringBuilder.append(i6.m.c(m14, m14) + optionMarketIndexInfo.getSymbol().toUpperCase());
                    break;
                }
            case 9:
                if (symbolPrice != null) {
                    if (!e.E(TradeType.OPTION)) {
                        spannableStringBuilder.append(context.getString(R$string.contract_hold_num_value, new Object[]{i6.m.i(symbolPrice.getVol().doubleValue(), 0)}));
                        break;
                    } else {
                        String i12 = i6.m.i(symbolPrice.getAmount().doubleValue(), FuturePrecisionUtil.s(optionMarketIndexInfo.getContractCode(), str, optionMarketIndexInfo.getOptionCode()));
                        spannableStringBuilder.append(i6.m.c(i12, i12) + optionMarketIndexInfo.getSymbol().toUpperCase());
                        break;
                    }
                } else {
                    spannableStringBuilder.append("--");
                    break;
                }
            case 10:
                if (TextUtils.isEmpty(optionMarketIndexInfo.getIndexPrice())) {
                    spannableStringBuilder.append("--");
                    break;
                } else {
                    String m15 = i6.m.m(optionMarketIndexInfo.getIndexPrice(), FuturePrecisionUtil.j(optionMarketIndexInfo.getSymbol()));
                    spannableStringBuilder.append(i6.m.c(m15, m15));
                    break;
                }
            case 11:
                if (TextUtils.isEmpty(optionMarketIndexInfo.getLatestPrice())) {
                    spannableStringBuilder.append("--");
                    break;
                } else {
                    String m16 = i6.m.m(optionMarketIndexInfo.getLatestPrice(), FuturePrecisionUtil.y((String) null, (String) null, optionMarketIndexInfo.getOptionCode()));
                    spannableStringBuilder.append(i6.m.c(m16, m16));
                    break;
                }
        }
        return spannableStringBuilder;
    }

    public static boolean f(OptionFieldTitleEnum optionFieldTitleEnum, String str, Context context) {
        if (str == null) {
            return true;
        }
        return str.contains(Constants.ACCEPT_TIME_SEPARATOR_SP + context.getString(optionFieldTitleEnum.getTitleRes()) + Constants.ACCEPT_TIME_SEPARATOR_SP);
    }

    public static void g(List<MarketOptionSettingBean> list, Context context) {
        StringBuilder sb2 = new StringBuilder();
        for (MarketOptionSettingBean next : list) {
            if (next.isSelected()) {
                sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP + context.getString(next.getFieldTitleEnum().getTitleRes()) + Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
        }
        ConfigPreferences.m("user_config", "option_title_field", sb2.toString());
    }
}
