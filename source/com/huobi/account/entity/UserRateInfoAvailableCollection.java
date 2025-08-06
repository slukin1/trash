package com.huobi.account.entity;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import bj.o0;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.network.hbg.core.bean.UserStepRateInfo;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.huobi.account.ui.StepRateItemCardView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.m;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import pro.huobi.R;
import qg.b;
import qg.c;
import qg.d;
import qg.e;
import qg.f;
import tg.r;

public class UserRateInfoAvailableCollection implements Serializable {
    public static final int OTC_TAKER_DEDUCTION_PRECISION = 0;
    private static final long serialVersionUID = 8417161417220590111L;
    private String available;
    public List<StepRateItemCardView.Data> cardDataList;
    private boolean isUserMerchant = true;
    private UserStepRateInfo marginInterestRateInfo;
    private UserStepRateInfo otcRateInfo;
    private UserStepRateInfo stepUserRateInfo;

    private StepRateItemCardView.Data buildMarginData(FragmentActivity fragmentActivity) {
        StepRateItemCardView.Data data = new StepRateItemCardView.Data();
        data.u(R.string.step_rate_margin_rate_title);
        data.n(R.drawable.rate_lever_icon);
        data.p(fragmentActivity.getString(R.string.step_rate_daily_rate));
        data.m(true);
        data.q(new f(fragmentActivity));
        data.r(new e(fragmentActivity));
        if (this.marginInterestRateInfo == null) {
            return data;
        }
        makeMarginStepRate(fragmentActivity, data);
        return data;
    }

    private StepRateItemCardView.Data buildOtcData(Activity activity) {
        StepRateItemCardView.Data data = new StepRateItemCardView.Data();
        data.u(R.string.step_rate_otc_rate_title);
        data.n(R.drawable.rate_legalcurrency_icon);
        data.q(new b(activity));
        if (this.otcRateInfo == null) {
            return data;
        }
        if (!r.x().U() || this.isUserMerchant) {
            handleOtherOtcUserRate(activity, data);
        } else {
            handleChinaNoMerchantOtcUserRate(activity, data);
        }
        return data;
    }

    private StepRateItemCardView.Data buildTradeData(FragmentActivity fragmentActivity) {
        StepRateItemCardView.Data data = new StepRateItemCardView.Data();
        data.u(R.string.n_step_rate_trade_rate_title);
        data.n(R.drawable.rate_coin_icon);
        data.q(new d(fragmentActivity));
        data.r(new c(fragmentActivity));
        if (this.stepUserRateInfo == null) {
            return data;
        }
        makeTradeStepRate(fragmentActivity, data);
        return data;
    }

    private String getDiscountRate(String str, String str2) {
        return m.a(str).multiply(m.a(str2)).toString();
    }

    private String getOtcRateStr1(Activity activity, String str) {
        try {
            if (new BigDecimal(str).compareTo(BigDecimal.ZERO) == 0) {
                return activity.getString(R.string.step_rate_free);
            }
            return activity.getString(R.string.step_rate_basic_rate);
        } catch (Exception unused) {
            return "--";
        }
    }

    private String getOtcRateStr2(Activity activity, String str, String str2) {
        try {
            if (new BigDecimal(str2).compareTo(BigDecimal.ZERO) != 0) {
                if (new BigDecimal(str).compareTo(BigDecimal.ZERO) != 0) {
                    if (new BigDecimal(str).compareTo(BigDecimal.ONE) == 0) {
                        return activity.getString(R.string.step_rate_basic_rate);
                    }
                    String N = m.N(str, 0, 4);
                    return activity.getString(R.string.step_rate_basic_rate) + "*" + N;
                }
            }
            return activity.getString(R.string.step_rate_free);
        } catch (Exception unused) {
            return "--";
        }
    }

    private static String getRateString(Context context, String str) {
        try {
            if (new BigDecimal(str).compareTo(BigDecimal.ZERO) == 0) {
                return context.getString(R.string.step_rate_free);
            }
            return m.Q(str, PrecisionUtil.q(), 4);
        } catch (Exception unused) {
            return "--";
        }
    }

    private String getUserStepRateDiscount(Context context, UserStepRateInfo userStepRateInfo, boolean z11) {
        String str;
        if (userStepRateInfo == null) {
            return "";
        }
        if (z11) {
            str = getDiscountRate(userStepRateInfo.getMakerDeduction(), userStepRateInfo.getMakerFeeRate());
        } else {
            str = getDiscountRate(userStepRateInfo.getTakerDeduction(), userStepRateInfo.getTakerFeeRate());
        }
        return getRateString(context, str);
    }

    private void handleChinaNoMerchantOtcUserRate(Activity activity, StepRateItemCardView.Data data) {
        data.l(true);
        if (this.otcRateInfo.isPointSwitchOn()) {
            data.t(activity.getString(R.string.step_rate_free));
        } else if (this.otcRateInfo.isHtDeductionOn("ht")) {
            data.t(getOtcRateStr2(activity, this.otcRateInfo.getOtcTakerDeduction(), this.otcRateInfo.getOtcTakerFeeRate()));
        } else {
            data.t(getOtcRateStr1(activity, this.otcRateInfo.getOtcTakerFeeRate()));
        }
    }

    private void handleOtherOtcUserRate(Activity activity, StepRateItemCardView.Data data) {
        if (this.otcRateInfo.isPointSwitchOn()) {
            data.o(getOtcRateStr1(activity, this.otcRateInfo.getMakerFeeRate()));
            data.t(activity.getString(R.string.step_rate_free));
        } else if (this.otcRateInfo.isHtDeductionOn("ht")) {
            data.o(getOtcRateStr2(activity, this.otcRateInfo.getOtcMakerDeduction(), this.otcRateInfo.getOtcMakerFeeRate()));
            data.t(getOtcRateStr2(activity, this.otcRateInfo.getOtcTakerDeduction(), this.otcRateInfo.getOtcTakerFeeRate()));
        } else {
            data.o(getOtcRateStr1(activity, this.otcRateInfo.getOtcMakerFeeRate()));
            data.t(getOtcRateStr1(activity, this.otcRateInfo.getOtcTakerFeeRate()));
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public static /* synthetic */ void lambda$buildMarginData$2(FragmentActivity fragmentActivity, View view) {
        sn.f.c0(fragmentActivity, "margin");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public static /* synthetic */ void lambda$buildMarginData$3(FragmentActivity fragmentActivity, View view) {
        DialogUtils.X(fragmentActivity, fragmentActivity.getString(R.string.step_rate_interest_rate_desc), fragmentActivity.getString(R.string.step_rate_margin_more), (String) null, fragmentActivity.getString(R.string.allow_access_dialog_positive_btn), o0.f12469a);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public static /* synthetic */ void lambda$buildOtcData$4(Activity activity, View view) {
        sn.f.c0(activity, "otc");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public static /* synthetic */ void lambda$buildTradeData$0(FragmentActivity fragmentActivity, View view) {
        sn.f.c0(fragmentActivity, "trading");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public static /* synthetic */ void lambda$buildTradeData$1(FragmentActivity fragmentActivity, View view) {
        DialogUtils.X(fragmentActivity, fragmentActivity.getString(R.string.step_rate_fee_rate_desc), fragmentActivity.getString(R.string.step_rate_trade_more), (String) null, fragmentActivity.getString(R.string.allow_access_dialog_positive_btn), o0.f12469a);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    private void makeMarginOriginalRate(Activity activity, StepRateItemCardView.Data data) {
        data.o(getRateString(activity, this.marginInterestRateInfo.getMarginRate()));
    }

    private void makeMarginStepRate(Activity activity, StepRateItemCardView.Data data) {
        String stepRateType = this.marginInterestRateInfo.getStepRateType();
        stepRateType.hashCode();
        char c11 = 65535;
        switch (stepRateType.hashCode()) {
            case 48:
                if (stepRateType.equals("0")) {
                    c11 = 0;
                    break;
                }
                break;
            case 50:
                if (stepRateType.equals("2")) {
                    c11 = 1;
                    break;
                }
                break;
            case 51:
                if (stepRateType.equals("3")) {
                    c11 = 2;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                data.o(activity.getString(R.string.step_rate_special_interest_rate));
                data.s(true);
                return;
            case 1:
            case 2:
                if (this.marginInterestRateInfo.isHtDeductionOn("ht")) {
                    data.o(getRateString(activity, getDiscountRate(this.marginInterestRateInfo.getMarginDeduction(), this.marginInterestRateInfo.getMarginRate())));
                    return;
                } else {
                    makeMarginOriginalRate(activity, data);
                    return;
                }
            default:
                makeMarginOriginalRate(activity, data);
                return;
        }
    }

    private void makeTradeOriginalRate(Activity activity, StepRateItemCardView.Data data) {
        data.o(getRateString(activity, this.stepUserRateInfo.getMakerFeeRate()));
        data.t(getRateString(activity, this.stepUserRateInfo.getTakerFeeRate()));
    }

    private void makeTradeStepRate(Activity activity, StepRateItemCardView.Data data) {
        String stepRateType = this.stepUserRateInfo.getStepRateType();
        stepRateType.hashCode();
        char c11 = 65535;
        switch (stepRateType.hashCode()) {
            case 48:
                if (stepRateType.equals("0")) {
                    c11 = 0;
                    break;
                }
                break;
            case 50:
                if (stepRateType.equals("2")) {
                    c11 = 1;
                    break;
                }
                break;
            case 51:
                if (stepRateType.equals("3")) {
                    c11 = 2;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                String string = activity.getString(R.string.step_rate_special_rate);
                data.o(string);
                data.t(string);
                data.s(true);
                return;
            case 1:
            case 2:
                if (this.stepUserRateInfo.isHtDeductionOn("ht")) {
                    data.o(getUserStepRateDiscount(activity, this.stepUserRateInfo, true));
                    data.t(getUserStepRateDiscount(activity, this.stepUserRateInfo, false));
                    return;
                }
                makeTradeOriginalRate(activity, data);
                return;
            default:
                makeTradeOriginalRate(activity, data);
                return;
        }
    }

    public void buildCardDataList(FragmentActivity fragmentActivity) {
        ArrayList arrayList = new ArrayList();
        this.cardDataList = arrayList;
        arrayList.add(buildTradeData(fragmentActivity));
        this.cardDataList.add(buildMarginData(fragmentActivity));
        this.cardDataList.add(buildOtcData(fragmentActivity));
    }

    public boolean canEqual(Object obj) {
        return obj instanceof UserRateInfoAvailableCollection;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UserRateInfoAvailableCollection)) {
            return false;
        }
        UserRateInfoAvailableCollection userRateInfoAvailableCollection = (UserRateInfoAvailableCollection) obj;
        if (!userRateInfoAvailableCollection.canEqual(this)) {
            return false;
        }
        UserStepRateInfo stepUserRateInfo2 = getStepUserRateInfo();
        UserStepRateInfo stepUserRateInfo3 = userRateInfoAvailableCollection.getStepUserRateInfo();
        if (stepUserRateInfo2 != null ? !stepUserRateInfo2.equals(stepUserRateInfo3) : stepUserRateInfo3 != null) {
            return false;
        }
        UserStepRateInfo marginInterestRateInfo2 = getMarginInterestRateInfo();
        UserStepRateInfo marginInterestRateInfo3 = userRateInfoAvailableCollection.getMarginInterestRateInfo();
        if (marginInterestRateInfo2 != null ? !marginInterestRateInfo2.equals(marginInterestRateInfo3) : marginInterestRateInfo3 != null) {
            return false;
        }
        UserStepRateInfo otcRateInfo2 = getOtcRateInfo();
        UserStepRateInfo otcRateInfo3 = userRateInfoAvailableCollection.getOtcRateInfo();
        if (otcRateInfo2 != null ? !otcRateInfo2.equals(otcRateInfo3) : otcRateInfo3 != null) {
            return false;
        }
        String available2 = getAvailable();
        String available3 = userRateInfoAvailableCollection.getAvailable();
        if (available2 != null ? !available2.equals(available3) : available3 != null) {
            return false;
        }
        if (isUserMerchant() != userRateInfoAvailableCollection.isUserMerchant()) {
            return false;
        }
        List<StepRateItemCardView.Data> cardDataList2 = getCardDataList();
        List<StepRateItemCardView.Data> cardDataList3 = userRateInfoAvailableCollection.getCardDataList();
        return cardDataList2 != null ? cardDataList2.equals(cardDataList3) : cardDataList3 == null;
    }

    public String getAvailable() {
        return this.available;
    }

    public List<StepRateItemCardView.Data> getCardDataList() {
        return this.cardDataList;
    }

    public UserStepRateInfo getMarginInterestRateInfo() {
        return this.marginInterestRateInfo;
    }

    public UserStepRateInfo getOtcRateInfo() {
        return this.otcRateInfo;
    }

    public UserStepRateInfo getStepUserRateInfo() {
        return this.stepUserRateInfo;
    }

    public int hashCode() {
        UserStepRateInfo stepUserRateInfo2 = getStepUserRateInfo();
        int i11 = 43;
        int hashCode = stepUserRateInfo2 == null ? 43 : stepUserRateInfo2.hashCode();
        UserStepRateInfo marginInterestRateInfo2 = getMarginInterestRateInfo();
        int hashCode2 = ((hashCode + 59) * 59) + (marginInterestRateInfo2 == null ? 43 : marginInterestRateInfo2.hashCode());
        UserStepRateInfo otcRateInfo2 = getOtcRateInfo();
        int hashCode3 = (hashCode2 * 59) + (otcRateInfo2 == null ? 43 : otcRateInfo2.hashCode());
        String available2 = getAvailable();
        int hashCode4 = (((hashCode3 * 59) + (available2 == null ? 43 : available2.hashCode())) * 59) + (isUserMerchant() ? 79 : 97);
        List<StepRateItemCardView.Data> cardDataList2 = getCardDataList();
        int i12 = hashCode4 * 59;
        if (cardDataList2 != null) {
            i11 = cardDataList2.hashCode();
        }
        return i12 + i11;
    }

    public boolean isUserMerchant() {
        return this.isUserMerchant;
    }

    public void setAvailable(String str) {
        this.available = str;
    }

    public void setCardDataList(List<StepRateItemCardView.Data> list) {
        this.cardDataList = list;
    }

    public void setMarginInterestRateInfo(UserStepRateInfo userStepRateInfo) {
        this.marginInterestRateInfo = userStepRateInfo;
    }

    public void setOtcRateInfo(UserStepRateInfo userStepRateInfo) {
        this.otcRateInfo = userStepRateInfo;
    }

    public void setStepUserRateInfo(UserStepRateInfo userStepRateInfo) {
        this.stepUserRateInfo = userStepRateInfo;
    }

    public void setUserMerchant(boolean z11) {
        this.isUserMerchant = z11;
    }

    public String toString() {
        return "UserRateInfoAvailableCollection(stepUserRateInfo=" + getStepUserRateInfo() + ", marginInterestRateInfo=" + getMarginInterestRateInfo() + ", otcRateInfo=" + getOtcRateInfo() + ", available=" + getAvailable() + ", isUserMerchant=" + isUserMerchant() + ", cardDataList=" + getCardDataList() + ")";
    }
}
