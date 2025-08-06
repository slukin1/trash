package com.jumio.sdk.util;

import com.google.zxing.client.result.ExpandedProductParsedResult;
import com.hbg.lib.network.pro.core.bean.DefiChainInfo;
import com.sumsub.sns.internal.core.common.n0;
import com.tencent.android.tpns.mqtt.internal.security.SSLSocketFactoryFactory;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.x;
import kotlin.l;

public final class IsoCountryConverter {
    public static final IsoCountryConverter INSTANCE = new IsoCountryConverter();

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, String> f25016a = MapsKt__MapsKt.l(l.a("AFG", "AF"), l.a("ALA", "AX"), l.a("ALB", "AL"), l.a("DZA", "DZ"), l.a("ASM", "AS"), l.a("AND", "AD"), l.a("AGO", "AO"), l.a("AIA", "AI"), l.a(n0.f32118f, "AQ"), l.a("ATG", "AG"), l.a("ARG", "AR"), l.a("ARM", "AM"), l.a("ABW", "AW"), l.a("AUS", "AU"), l.a("AUT", "AT"), l.a("AZE", "AZ"), l.a("BHS", "BS"), l.a("BHR", "BH"), l.a("BGD", "BD"), l.a("BRB", "BB"), l.a("BLR", "BY"), l.a("BEL", "BE"), l.a("BLZ", "BZ"), l.a("BEN", "BJ"), l.a("BMU", "BM"), l.a("BTN", "BT"), l.a("BOL", "BO"), l.a("BES", "BQ"), l.a("BIH", "BA"), l.a("BWA", "BW"), l.a("BVT", "BV"), l.a("BRA", "BR"), l.a("IOT", "IO"), l.a("BRN", "BN"), l.a("BGR", "BG"), l.a("BFA", "BF"), l.a("BDI", "BI"), l.a("KHM", "KH"), l.a("CMR", "CM"), l.a("CAN", "CA"), l.a("CPV", "CV"), l.a("CYM", "KY"), l.a("CAF", "CF"), l.a("TCD", "TD"), l.a("CHL", "CL"), l.a("CHN", "CN"), l.a("CXR", "CX"), l.a("CCK", "CC"), l.a("COL", "CO"), l.a("COM", "KM"), l.a("COG", "CG"), l.a("COD", "CD"), l.a("COK", "CK"), l.a("CRI", "CR"), l.a("CIV", "CI"), l.a("HRV", "HR"), l.a("CUB", "CU"), l.a("CUW", "CW"), l.a("CYP", "CY"), l.a("CZE", "CZ"), l.a("DNK", "DK"), l.a("DJI", "DJ"), l.a("DMA", "DM"), l.a("DOM", "DO"), l.a("ECU", "EC"), l.a("EGY", "EG"), l.a("SLV", "SV"), l.a("GNQ", "GQ"), l.a("ERI", "ER"), l.a("EST", "EE"), l.a(DefiChainInfo.CHAIN_ETH, "ET"), l.a("FLK", "FK"), l.a("FRO", "FO"), l.a("FJI", "FJ"), l.a("FIN", "FI"), l.a("FRA", "FR"), l.a("GUF", "GF"), l.a("PYF", "PF"), l.a("ATF", "TF"), l.a("GAB", "GA"), l.a("GMB", "GM"), l.a("GEO", "GE"), l.a("DEU", "DE"), l.a("GHA", "GH"), l.a("GIB", "GI"), l.a("GRC", "GR"), l.a("GRL", "GL"), l.a("GRD", "GD"), l.a("GLP", "GP"), l.a("GUM", "GU"), l.a("GTM", "GT"), l.a("GGY", "GG"), l.a("GIN", "GN"), l.a("GNB", "GW"), l.a("GUY", "GY"), l.a("HTI", "HT"), l.a("HMD", "HM"), l.a("VAT", "VA"), l.a("HND", "HN"), l.a("HKG", "HK"), l.a("HUN", "HU"), l.a("ISL", "IS"), l.a("IND", "IN"), l.a("IDN", "ID"), l.a("IRN", "IR"), l.a("IRQ", "IQ"), l.a("IRL", "IE"), l.a("IMN", "IM"), l.a("ISR", "IL"), l.a("ITA", "IT"), l.a("JAM", "JM"), l.a("JPN", "JP"), l.a("JEY", "JE"), l.a("JOR", "JO"), l.a("KAZ", "KZ"), l.a("KEN", "KE"), l.a("KIR", "KI"), l.a("PRK", "KP"), l.a("KOR", "KR"), l.a("KWT", "KW"), l.a("KGZ", ExpandedProductParsedResult.KILOGRAM), l.a("LAO", "LA"), l.a("LVA", "LV"), l.a("LBN", ExpandedProductParsedResult.POUND), l.a("LSO", "LS"), l.a("LBR", "LR"), l.a("LBY", "LY"), l.a("LIE", "LI"), l.a("LTU", "LT"), l.a("LUX", "LU"), l.a("MAC", "MO"), l.a("MKD", "MK"), l.a("MDG", "MG"), l.a("MWI", "MW"), l.a("MYS", "MY"), l.a("MDV", "MV"), l.a("MLI", "ML"), l.a("MLT", "MT"), l.a("MHL", "MH"), l.a("MTQ", "MQ"), l.a("MRT", "MR"), l.a("MUS", "MU"), l.a("MYT", "YT"), l.a("MEX", "MX"), l.a("FSM", "FM"), l.a("MDA", "MD"), l.a("MCO", "MC"), l.a("MNG", "MN"), l.a("MNE", "ME"), l.a("MSR", "MS"), l.a("MAR", "MA"), l.a("MOZ", "MZ"), l.a("MMR", "MM"), l.a("NAM", "NA"), l.a("NRU", "NR"), l.a("NPL", "NP"), l.a("NLD", "NL"), l.a("ANT", "AN"), l.a("NCL", "NC"), l.a("NZL", "NZ"), l.a("NIC", "NI"), l.a("NER", "NE"), l.a("NGA", "NG"), l.a("NIU", "NU"), l.a("NFK", "NF"), l.a("MNP", "MP"), l.a("NOR", "NO"), l.a("OMN", "OM"), l.a("PAK", "PK"), l.a("PLW", "PW"), l.a("PSE", "PS"), l.a("PAN", "PA"), l.a("PNG", "PG"), l.a("PRY", "PY"), l.a("PER", "PE"), l.a("PHL", "PH"), l.a("PCN", "PN"), l.a("POL", "PL"), l.a("PRT", "PT"), l.a("PRI", "PR"), l.a("QAT", "QA"), l.a("REU", "RE"), l.a("ROU", "RO"), l.a("RUS", "RU"), l.a("RWA", "RW"), l.a("BLM", "BL"), l.a("SHN", "SH"), l.a("KNA", "KN"), l.a("LCA", "LC"), l.a("MAF", "MF"), l.a("SPM", "PM"), l.a("VCT", "VC"), l.a("WSM", "WS"), l.a("SMR", "SM"), l.a("STP", "ST"), l.a("SAU", "SA"), l.a("SEN", "SN"), l.a("SSD", "SS"), l.a("SRB", "RS"), l.a("SYC", "SC"), l.a("SLE", "SL"), l.a("SGP", "SG"), l.a("SXM", "SX"), l.a("SVK", "SK"), l.a("SVN", "SI"), l.a("SLB", "SB"), l.a("SOM", "SO"), l.a("ZAF", "ZA"), l.a("SGS", "GS"), l.a("ESP", "ES"), l.a("LKA", "LK"), l.a("SDN", "SD"), l.a("SUR", "SR"), l.a("SJM", "SJ"), l.a("SWZ", "SZ"), l.a("SWE", "SE"), l.a("CHE", "CH"), l.a("SYR", "SY"), l.a("TWN", "TW"), l.a("TJK", "TJ"), l.a("TZA", "TZ"), l.a("THA", "TH"), l.a(SSLSocketFactoryFactory.DEFAULT_PROTOCOL, "TL"), l.a("TGO", "TG"), l.a("TKL", "TK"), l.a("TON", "TO"), l.a("TTO", "TT"), l.a("TUN", "TN"), l.a("TUR", "TR"), l.a("TKM", "TM"), l.a("TCA", "TC"), l.a("TUV", "TV"), l.a("UGA", "UG"), l.a("UKR", "UA"), l.a("ARE", "AE"), l.a("GBR", "GB"), l.a("USA", "US"), l.a("UMI", "UM"), l.a("URY", "UY"), l.a("UZB", "UZ"), l.a("VUT", "VU"), l.a("VEN", "VE"), l.a("VNM", "VN"), l.a("VGB", "VG"), l.a("VIR", "VI"), l.a("WLF", "WF"), l.a("ESH", "EH"), l.a("XKX", "XK"), l.a("YEM", "YE"), l.a("ZMB", "ZM"), l.a("ZWE", "ZW"));

    public static final String convertToAlpha2(String str) {
        if (str == null) {
            return null;
        }
        Map<String, String> map = f25016a;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        return null;
    }

    public static final String convertToAlpha3(String str) {
        if (str == null) {
            return null;
        }
        Map<String, String> map = f25016a;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry next : map.entrySet()) {
            if (x.b((String) next.getValue(), str)) {
                linkedHashMap.put(next.getKey(), next.getValue());
            }
        }
        return (String) CollectionsKt___CollectionsKt.b0(linkedHashMap.keySet());
    }
}
