package com.huobi.webview2.ui;

import a7.e;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.hbg.lib.common.network.NetworkStatus;
import com.hbg.lib.common.utils.SystemUtils;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.contract.entity.CalculateData;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.domain.DomainSwitcher;
import com.huobi.utils.a0;
import com.huochat.community.network.domain.DomainTool;
import i6.d;
import i6.k;
import java.util.Map;
import pro.huobi.R;
import su.b;
import x6.c;

public class ContractWebActivity extends HBBaseWebActivity implements b.C0210b {

    /* renamed from: b  reason: collision with root package name */
    public CalculateData f20893b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f20894c;

    public static String Ah(int i11) {
        String str = Fh(i11) + "/delivery_detail";
        d.b("ContractWebViewActivity-->getContractCalculatorUrl-->url:" + str);
        return str;
    }

    public static String Bh(int i11) {
        String str;
        if (i11 == 1) {
            str = Fh(i11) + "/information";
        } else if (i11 == 2) {
            str = Fh(i11) + "/swap/information";
        } else if (i11 == 3) {
            str = Fh(i11) + "/option-h5/information";
        } else if (i11 == 4) {
            str = Fh(i11) + "/linear_swap/information";
        } else {
            str = Fh(i11) + "/information";
        }
        d.b("ContractWebViewActivity-->getContractInfoUrl-->url:" + str);
        return str;
    }

    public static String Ch() {
        return Dh(1);
    }

    public static String Dh(int i11) {
        String str = Fh(i11) + "/insurance_fund";
        d.b("ContractWebViewActivity-->getContractCalculatorUrl-->url:" + str);
        return str;
    }

    public static String Eh(int i11) {
        if (i11 == 1) {
            return Fh(i11) + "/risk_level";
        } else if (i11 == 2) {
            return Fh(i11) + "/swap/risk_level";
        } else {
            return Fh(i11) + "/linear_swap/risk_level";
        }
    }

    public static String Fh(int i11) {
        if (i11 == 1) {
            return !SystemUtils.c() ? wi.b.f48056t : DomainTool.DOMAIN_PREFIX + DomainSwitcher.t();
        } else if (i11 == 2) {
            return !SystemUtils.c() ? wi.b.f48053q : DomainTool.DOMAIN_PREFIX + DomainSwitcher.t();
        } else if (i11 == 3) {
            return !SystemUtils.c() ? wi.b.f48056t : DomainTool.DOMAIN_PREFIX + DomainSwitcher.t();
        } else if (i11 == 4) {
            return !SystemUtils.c() ? wi.b.f48056t : DomainTool.DOMAIN_PREFIX + DomainSwitcher.t();
        } else {
            return !SystemUtils.c() ? wi.b.f48056t : DomainTool.DOMAIN_PREFIX + DomainSwitcher.t();
        }
    }

    public static String Gh(int i11) {
        String str;
        if (i11 == 1) {
            str = Fh(i11) + "/open_contract";
        } else if (i11 == 2) {
            str = Fh(i11) + "/swap/open_swap";
        } else if (i11 == 3) {
            str = Fh(i11) + "/option-h5/open_option";
        } else if (i11 == 4) {
            str = Fh(i11) + "/linear_swap/open_linear";
        } else {
            str = Fh(i11) + "/open_contract";
        }
        d.b("ContractWebViewActivity-->getOpenContractUrl-->url:" + str);
        return str;
    }

    public static String Hh(int i11) {
        String str = a0.j() + "/" + AppLanguageHelper.getInstance().getCurLanguageUrlLowerCase() + "/fee/h5-v3";
        d.b("ContractWebViewActivity-->getPriceRateUrl-->url:" + str);
        return str;
    }

    public static String Ih(int i11) {
        String str;
        if (i11 == 1) {
            str = Fh(i11) + "/option/simple_choose/";
        } else {
            str = Fh(i11) + "/option-h5/simple_choose/";
        }
        d.b("ContractWebViewActivity-->getContractCalculatorUrl-->url:" + str);
        return str;
    }

    public static Intent Jh(Activity activity, String str, Bundle bundle) {
        if (!NetworkStatus.c(activity)) {
            HuobiToastUtil.k(activity, R.string.string_network_disconnect);
            return null;
        }
        Intent intent = new Intent(activity, ContractWebActivity.class);
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("url", str);
        }
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        intent.addFlags(67108864);
        return intent;
    }

    public static String Kh(int i11) {
        String str;
        if (i11 == 1) {
            str = Fh(i11) + "/subaccount";
        } else if (i11 == 2) {
            str = Fh(i11) + "/swap/subaccount";
        } else if (i11 == 3) {
            str = Fh(i11) + "/option-h5/subaccount";
        } else if (i11 == 4) {
            str = Fh(i11) + "/linear_swap/subaccount";
        } else {
            str = Fh(i11) + "/subaccount";
        }
        d.b("ContractWebViewActivity-->getSubAccountUrl-->url:" + str);
        return str;
    }

    public static String Lh(int i11) {
        String str;
        if (i11 == 1) {
            str = Fh(i11) + "/data_center/limit";
        } else if (i11 == 2) {
            str = Fh(i11) + "/swap/data_center/limit";
        } else if (i11 == 3) {
            str = Fh(i11) + "/option-h5/data_center/limit";
        } else if (i11 == 4) {
            str = Fh(i11) + "/linear_swap/data_center/limit";
        } else {
            str = Fh(i11) + "/data_center/limit";
        }
        d.b("ContractWebViewActivity-->getTradeLimitUrl-->url:" + str);
        return str;
    }

    public static void Mh(Activity activity, String str, Bundle bundle) {
        if (!NetworkStatus.c(activity)) {
            HuobiToastUtil.k(activity, R.string.string_network_disconnect);
            return;
        }
        Intent intent = new Intent(activity, ContractWebActivity.class);
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("url", str);
        }
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        intent.addFlags(67108864);
        activity.startActivity(intent);
    }

    public static void Nh(Activity activity) {
        Oh(activity, 1);
    }

    public static void Oh(Activity activity, int i11) {
        String str;
        if (i11 == 1) {
            str = xh("list", "360000039122");
        } else if (i11 == 2) {
            str = xh("list", "900000017203");
        } else if (i11 == 3) {
            str = xh("list", "900000256146");
        } else if (i11 == 4) {
            str = xh("list", "900000256166");
        } else {
            str = xh("list", "360000039122");
        }
        d.i("ContractWebActivity : " + str);
        Bundle bundle = new Bundle();
        bundle.putInt("extra_type", i11);
        Mh(activity, str, bundle);
    }

    public static void Ph(Activity activity, String str, String str2, String str3) {
        Qh(activity, str, str2, str3, 1);
    }

    public static void Qh(Activity activity, String str, String str2, String str3, int i11) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("extra_calculate_data", new CalculateData(str, str2, str3));
        Mh(activity, zh(i11), bundle);
    }

    public static void Rh(Activity activity, String str) {
        Mh(activity, str, (Bundle) null);
    }

    public static void Sh(Activity activity, String str) {
        Th(activity, str, 1);
    }

    public static void Th(Activity activity, String str, int i11) {
        Mh(activity, Fh(i11) + str, (Bundle) null);
    }

    public static void Uh(Activity activity, String str, String str2, String str3, TradeType tradeType) {
        int i11;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            tradeType = TradeType.LINEAR_SWAP;
            str = "BTC";
            str2 = "BTC-USDT";
            str3 = str2;
        }
        String str4 = "cny";
        if (!str4.equals(LegalCurrencyConfigUtil.y())) {
            str4 = "usd";
        }
        TradeType tradeType2 = TradeType.CONTRACT;
        String str5 = "symbol";
        if (tradeType == tradeType2) {
            if (!e.E(tradeType2)) {
                str5 = "sheet";
            }
            i11 = 1;
        } else {
            TradeType tradeType3 = TradeType.SWAP;
            if (tradeType == tradeType3) {
                if (!e.E(tradeType3)) {
                    str5 = "sheet";
                }
                i11 = 2;
            } else {
                TradeType tradeType4 = TradeType.LINEAR_SWAP;
                if (!e.E(tradeType4)) {
                    str5 = e.G(tradeType4) ? "usdt" : "sheet";
                }
                i11 = 4;
            }
        }
        Bundle bundle = new Bundle();
        CalculateData calculateData = new CalculateData(str, str5, str4);
        calculateData.setContractCode(str2);
        calculateData.setCurrentContractCode(str3);
        bundle.putParcelable("extra_calculate_data", calculateData);
        Mh(activity, Bh(i11) + "?type=contract_elements", bundle);
    }

    public static void Vh(Activity activity, String str, String str2, String str3, String str4, String str5, int i11) {
        Bundle bundle = new Bundle();
        CalculateData calculateData = new CalculateData(str, str2, str3);
        calculateData.setContractCode(str4);
        calculateData.setCurrentContractCode(str5);
        bundle.putParcelable("extra_calculate_data", calculateData);
        Mh(activity, Bh(i11), bundle);
    }

    public static void Wh(Activity activity, String str, String str2, String str3, String str4) {
        Xh(activity, str, str2, str3, str4, 1);
    }

    public static void Xh(Activity activity, String str, String str2, String str3, String str4, int i11) {
        Bundle bundle = new Bundle();
        CalculateData calculateData = new CalculateData(str, str2, str3);
        calculateData.setContractCode(str4);
        bundle.putParcelable("extra_calculate_data", calculateData);
        Mh(activity, Ah(i11), bundle);
    }

    public static void Yh(Activity activity, String str, String str2, String str3, String str4, String str5) {
        Bundle bundle = new Bundle();
        CalculateData calculateData = new CalculateData(str, str2, str3);
        calculateData.setContractCode(str4);
        calculateData.setCurrentContractCode(str5);
        bundle.putParcelable("extra_calculate_data", calculateData);
        Mh(activity, Ch(), bundle);
    }

    public static void Zh(Object obj, String str, String str2, boolean z11, boolean z12) {
        ai(obj, str, str2, z11, z12, 1);
    }

    public static void ai(Object obj, String str, String str2, boolean z11, boolean z12, int i11) {
        boolean z13 = obj instanceof Activity;
        if (z13 || (obj instanceof Fragment)) {
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(str)) {
                bundle.putString("title", str);
            }
            bundle.putString("title_back", str2);
            bundle.putBoolean("isauth", z11);
            bundle.putInt("extra_type", i11);
            bundle.putBoolean("param_open", true);
            if (z12) {
                if (z13) {
                    ei((Activity) obj, Gh(i11), bundle);
                } else {
                    fi((Fragment) obj, Gh(i11), bundle);
                }
            } else if (z13) {
                Mh((Activity) obj, Gh(i11), bundle);
            } else {
                Mh(((Fragment) obj).getActivity(), Gh(i11), bundle);
            }
        }
    }

    public static void bi(Activity activity) {
        Bundle bundle = new Bundle();
        String str = "cny";
        if (!str.equals(LegalCurrencyConfigUtil.y())) {
            str = "usd";
        }
        CalculateData calculateData = new CalculateData("BTC", "symbol", str, FutureContractInfo.MARGIN_CROSS);
        calculateData.setContractCode("BTC-USDT");
        calculateData.setCurrentContractCode("BTC-USDT");
        bundle.putParcelable("extra_calculate_data", calculateData);
        Mh(activity, Fh(4) + "/linear_swap/data_center/limit?type=position_limit", bundle);
    }

    public static void ci(Activity activity) {
        di(activity, 1);
    }

    public static void di(Activity activity, int i11) {
        Mh(activity, Hh(i11), (Bundle) null);
    }

    public static void ei(Activity activity, String str, Bundle bundle) {
        if (activity != null) {
            if (!NetworkStatus.c(activity)) {
                HuobiToastUtil.k(activity, R.string.string_network_disconnect);
                return;
            }
            Intent intent = new Intent(activity, ContractWebActivity.class);
            intent.putExtras(bundle);
            intent.putExtra("url", str);
            intent.addFlags(67108864);
            activity.startActivityForResult(intent, 100);
        }
    }

    public static void fi(Fragment fragment, String str, Bundle bundle) {
        if (fragment != null && fragment.getActivity() != null) {
            if (!NetworkStatus.c(fragment.getActivity())) {
                HuobiToastUtil.k(fragment.getActivity(), R.string.string_network_disconnect);
                return;
            }
            Intent intent = new Intent(fragment.getActivity(), ContractWebActivity.class);
            intent.putExtras(bundle);
            intent.putExtra("url", str);
            intent.addFlags(67108864);
            fragment.startActivityForResult(intent, 100);
        }
    }

    public static void gi(Activity activity, int i11) {
        Mh(activity, Kh(i11), (Bundle) null);
    }

    public static void hi(Activity activity, String str, String str2, String str3, String str4, String str5, int i11) {
        Bundle bundle = new Bundle();
        CalculateData calculateData = new CalculateData(str, str2, str3);
        calculateData.setContractCode(str4);
        calculateData.setCurrentContractCode(str5);
        bundle.putParcelable("extra_calculate_data", calculateData);
        Mh(activity, Lh(i11), bundle);
    }

    public static void ii(Activity activity, String str, String str2, String str3, String str4, String str5, String str6, int i11) {
        Bundle bundle = new Bundle();
        CalculateData calculateData = new CalculateData(str, str2, str3, str6);
        calculateData.setContractCode(str4);
        calculateData.setCurrentContractCode(str5);
        bundle.putParcelable("extra_calculate_data", calculateData);
        Mh(activity, Lh(i11), bundle);
    }

    public static void ji(Activity activity, String str) {
        Mh(activity, Fh(1) + str, (Bundle) null);
    }

    public static void ki(Activity activity, int i11) {
        String str;
        if (i11 == 1) {
            str = Fh(i11) + "/contract/new_users_guide/";
        } else if (i11 == 2) {
            str = Fh(i11) + "/swap/new_users_guide/";
        } else if (i11 == 4) {
            str = Fh(i11) + "/linear_swap/new_users_guide/";
        } else {
            str = Fh(i11) + "/contract/new_users_guide/";
        }
        d.i("ContractWebActivity : " + str);
        Mh(activity, str, (Bundle) null);
    }

    public static void li(Activity activity, int i11) {
        Mh(activity, Ih(i11), (Bundle) null);
    }

    public static void mi(Activity activity, String str) {
        Mh(activity, Fh(1) + str, (Bundle) null);
        Intent Jh = Jh(activity, Fh(1) + str, (Bundle) null);
        if (Jh != null) {
            activity.startActivity(Jh);
        }
    }

    public static String xh(String str, String str2) {
        return DomainTool.DOMAIN_PREFIX + DomainSwitcher.w() + "/support/" + AppLanguageHelper.getInstance().getCurLanguageUrlLowerCase() + "/" + str + "/" + str2;
    }

    public static String yh(int i11, String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            str = "BTC-USDT";
        }
        if (i11 == 1) {
            str2 = Fh(i11) + "/public/agree_new/?contractCode=" + str;
        } else if (i11 == 2) {
            str2 = Fh(i11) + "/public/agree_new/?contractCode=" + str;
        } else if (i11 == 3) {
            str2 = Fh(i11) + "/public/agree_new/?contractCode=" + str;
        } else if (i11 == 4) {
            str2 = Fh(i11) + "/public/agree_new/?contractCode=" + str;
        } else {
            str2 = Fh(i11) + "/public/agree_new/?contractCode=" + str;
        }
        k.o("ContractKyc", "getAgreementV2Url url:" + str2);
        return str2;
    }

    public static String zh(int i11) {
        String str;
        if (i11 == 1) {
            str = Fh(i11) + "/calculator";
        } else if (i11 == 2) {
            str = Fh(i11) + "/swap/calculator";
        } else if (i11 == 3) {
            str = Fh(i11) + "/option-h5/calculator";
        } else if (i11 == 4) {
            str = Fh(i11) + "/linear_swap/calculator";
        } else {
            str = Fh(i11) + "/calculator";
        }
        d.b("ContractWebViewActivity-->getContractCalculatorUrl-->url:" + str);
        return str;
    }

    public void W4(String str) {
        Intent intent = new Intent();
        intent.putExtra("extra_result", str);
        setResult(200, intent);
        finish();
    }

    public Map<String, String> buildHeaders(Map<String, String> map) {
        map.put("Content-Type", "application/x-www-form-urlencoded");
        return map;
    }

    public String buildParams(String str) {
        return str;
    }

    public c getJavascriptInterface() {
        return new b(this.f20893b, this, this);
    }

    public void initIntent(Intent intent) {
        super.initIntent(intent);
        if (intent != null) {
            this.f20893b = (CalculateData) intent.getParcelableExtra("extra_calculate_data");
            this.f20894c = intent.getBooleanExtra("param_open", false);
        }
    }

    public boolean isFinishOnBackBtnClick() {
        return this.f20894c;
    }
}
