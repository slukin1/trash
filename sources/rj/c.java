package rj;

import com.hbg.module.content.custom.widget.DoubleCoinChart;
import com.hbg.module.content.custom.widget.RichTextWidget;
import com.hbg.module.content.custom.widget.TagViewWidget;
import com.huobi.copytrading.engine.CopytradingNativeAbility;
import com.huobi.copytrading.engine.ability.CopyTradingOpenRouteAbility;
import com.huobi.edgeengine.ability.ContainerBackAbility;
import com.huobi.edgeengine.ability.ConvertAbility;
import com.huobi.edgeengine.ability.DoubleCoinAbility;
import com.huobi.edgeengine.ability.NetworkStatusAbility;
import com.huobi.edgeengine.ability.PreviewImageAbility;
import com.huobi.edgeengine.ability.ShowDatePicker;
import com.huobi.edgeengine.ability.s;
import com.huobi.edgeengine.template.widget.Widget;
import com.huobi.edgeengine.util.EdgeEngineScene;
import com.huobi.edgeengine.widget.HotCoinChartWidget;
import com.huobi.edgeengine.widget.LightingAnimationWidget;
import com.huobi.edgeengine.widget.SearchHistoryWidget;
import com.huobi.engineutils.ability.AssetJumpAbility;
import com.huobi.engineutils.ability.EngineCurrencyCommonAbility;
import com.huobi.engineutils.widget.BottomLineTextWidget;
import com.huobi.otc.edgeengine.p2p.OtcMerchantSearchBridgeAbility;
import com.huobi.otc.edgeengine.p2p.OtcP2pFilterBridgeAbility;
import com.huobi.otc.edgeengine.p2p.widget.OtcBannerWidget;
import com.huobi.otc.edgeengine.p2p.widget.OtcPayMethodsEdgeWidget;
import com.huobi.trade.engine.TradeDataParser;
import com.huobi.tradingbot.engine.TradingBotNativeAbility;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import sj.f;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f47785a = new c();

    /* renamed from: b  reason: collision with root package name */
    public static final HashMap<String, List<Pair<String, Class<? extends s>>>> f47786b;

    /* renamed from: c  reason: collision with root package name */
    public static final HashMap<String, List<Pair<String, Class<? extends Widget>>>> f47787c;

    /* renamed from: d  reason: collision with root package name */
    public static final HashMap<String, List<Pair<String, Class<? extends f>>>> f47788d;

    static {
        Class<DoubleCoinAbility> cls = DoubleCoinAbility.class;
        Class<CopyTradingOpenRouteAbility> cls2 = CopyTradingOpenRouteAbility.class;
        Class<EngineCurrencyCommonAbility> cls3 = EngineCurrencyCommonAbility.class;
        HashMap<String, List<Pair<String, Class<? extends s>>>> hashMap = new HashMap<>();
        String scene = EdgeEngineScene.COPY_TRADING.getScene();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair("copyTradingBridge", CopytradingNativeAbility.class));
        arrayList.add(new Pair("openRoute", cls2));
        arrayList.add(new Pair("currencyCommon", cls3));
        Unit unit = Unit.f56620a;
        hashMap.put(scene, arrayList);
        EdgeEngineScene edgeEngineScene = EdgeEngineScene.EARN;
        String scene2 = edgeEngineScene.getScene();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new Pair("currencyCommon", cls3));
        hashMap.put(scene2, arrayList2);
        EdgeEngineScene edgeEngineScene2 = EdgeEngineScene.DOUBLE_COIN;
        String scene3 = edgeEngineScene2.getScene();
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(new Pair("doubleCoinShowDatePicker", ShowDatePicker.class));
        arrayList3.add(new Pair("doubleCoinAbility", cls));
        hashMap.put(scene3, arrayList3);
        String scene4 = EdgeEngineScene.TRADE_BOT.getScene();
        ArrayList arrayList4 = new ArrayList();
        arrayList4.add(new Pair("tradingBotBridge", TradingBotNativeAbility.class));
        arrayList4.add(new Pair("openRoute", cls2));
        arrayList4.add(new Pair("currencyCommon", cls3));
        hashMap.put(scene4, arrayList4);
        EdgeEngineScene edgeEngineScene3 = EdgeEngineScene.SIMPLE_EARN;
        String scene5 = edgeEngineScene3.getScene();
        ArrayList arrayList5 = new ArrayList();
        arrayList5.add(new Pair("doubleCoinAbility", cls));
        hashMap.put(scene5, arrayList5);
        EdgeEngineScene edgeEngineScene4 = EdgeEngineScene.HOT_COIN_RADAR;
        String scene6 = edgeEngineScene4.getScene();
        ArrayList arrayList6 = new ArrayList();
        arrayList6.add(new Pair("convertString", ConvertAbility.class));
        arrayList6.add(new Pair("openPreviewImage", PreviewImageAbility.class));
        arrayList6.add(new Pair("networkStatus", NetworkStatusAbility.class));
        hashMap.put(scene6, arrayList6);
        EdgeEngineScene edgeEngineScene5 = EdgeEngineScene.OTC_P2P;
        String scene7 = edgeEngineScene5.getScene();
        ArrayList arrayList7 = new ArrayList();
        arrayList7.add(new Pair("p2pFilterBridge", OtcP2pFilterBridgeAbility.class));
        hashMap.put(scene7, arrayList7);
        String scene8 = EdgeEngineScene.OTC_MERCHANT_SEARCH.getScene();
        ArrayList arrayList8 = new ArrayList();
        arrayList8.add(new Pair("merchantSearch", OtcMerchantSearchBridgeAbility.class));
        hashMap.put(scene8, arrayList8);
        f47786b = hashMap;
        HashMap<String, List<Pair<String, Class<? extends Widget>>>> hashMap2 = new HashMap<>();
        String scene9 = edgeEngineScene.getScene();
        ArrayList arrayList9 = new ArrayList();
        arrayList9.add(new Pair("LightingAnimationWidget", LightingAnimationWidget.class));
        arrayList9.add(new Pair("SearchHistoryWidget", SearchHistoryWidget.class));
        hashMap2.put(scene9, arrayList9);
        String scene10 = edgeEngineScene2.getScene();
        ArrayList arrayList10 = new ArrayList();
        arrayList10.add(new Pair("DoubleCoinChart", DoubleCoinChart.class));
        hashMap2.put(scene10, arrayList10);
        String scene11 = edgeEngineScene4.getScene();
        ArrayList arrayList11 = new ArrayList();
        arrayList11.add(new Pair("HotCoinChartView", HotCoinChartWidget.class));
        hashMap2.put(scene11, arrayList11);
        String scene12 = edgeEngineScene5.getScene();
        ArrayList arrayList12 = new ArrayList();
        arrayList12.add(new Pair("OtcBannerView", OtcBannerWidget.class));
        arrayList12.add(new Pair("OtcPayMethodsEdgeView", OtcPayMethodsEdgeWidget.class));
        hashMap2.put(scene12, arrayList12);
        f47787c = hashMap2;
        HashMap<String, List<Pair<String, Class<? extends f>>>> hashMap3 = new HashMap<>();
        String scene13 = edgeEngineScene3.getScene();
        ArrayList arrayList13 = new ArrayList();
        arrayList13.add(new Pair("trade_parser", TradeDataParser.class));
        hashMap3.put(scene13, arrayList13);
        f47788d = hashMap3;
    }

    public final List<Pair<String, Class<? extends s>>> a(String str) {
        List<Pair<String, Class<? extends s>>> list = f47786b.get(str);
        return list == null ? new ArrayList() : list;
    }

    public final ArrayList<Pair<String, Class<? extends s>>> b() {
        ArrayList<Pair<String, Class<? extends s>>> arrayList = new ArrayList<>();
        arrayList.add(new Pair("containerBack", ContainerBackAbility.class));
        arrayList.add(new Pair("currencyCommon", EngineCurrencyCommonAbility.class));
        arrayList.add(new Pair("jump", AssetJumpAbility.class));
        return arrayList;
    }

    public final ArrayList<Pair<String, Class<? extends Widget>>> c() {
        ArrayList<Pair<String, Class<? extends Widget>>> arrayList = new ArrayList<>();
        arrayList.add(new Pair("RichTextView", RichTextWidget.class));
        arrayList.add(new Pair("BottomLineTextView", BottomLineTextWidget.class));
        arrayList.add(new Pair("TagView", TagViewWidget.class));
        return arrayList;
    }

    public final List<Pair<String, Class<? extends f>>> d(String str) {
        List<Pair<String, Class<? extends f>>> list = f47788d.get(str);
        return list == null ? new ArrayList() : list;
    }

    public final List<Pair<String, Class<? extends Widget>>> e(String str) {
        List<Pair<String, Class<? extends Widget>>> list = f47787c.get(str);
        return list == null ? new ArrayList() : list;
    }
}
