package com.huobi.otc.edgeengine.p2p;

import com.eclipsesource.v8.V8Object;
import com.huobi.edgeengine.ability.AbilityFunction;
import com.huobi.edgeengine.ability.AbstractAbility;
import i6.d;
import java.util.Objects;
import org.greenrobot.eventbus.EventBus;
import rj.b;

public class OtcP2pFilterBridgeAbility extends AbstractAbility {
    public void a(b bVar, Object obj, AbilityFunction.a aVar) {
        if (aVar != null) {
            if (obj instanceof V8Object) {
                try {
                    if (((V8Object) obj).contains("action")) {
                        OtcFilterEvent otcFilterEvent = new OtcFilterEvent();
                        String string = ((V8Object) obj).getString("action");
                        otcFilterEvent.j(string);
                        if (((V8Object) obj).contains("params")) {
                            if (((V8Object) obj).getType("params") == 4) {
                                otcFilterEvent.p(((V8Object) obj).getString("params"));
                            } else if (((V8Object) obj).getType("params") == 6) {
                                V8Object object = ((V8Object) obj).getObject("params");
                                if ("onSwitchPage".equals(string)) {
                                    if (object.contains("target")) {
                                        otcFilterEvent.j(object.getString("target"));
                                    }
                                    if (object.contains("params")) {
                                        otcFilterEvent.p(object.getString("params"));
                                    }
                                }
                                if ("checkRiskState".equals(string)) {
                                    if (object.contains("method")) {
                                        otcFilterEvent.o(object.getString("method"));
                                    }
                                    if (object.contains("currencyName")) {
                                        otcFilterEvent.l(object.getString("currencyName"));
                                    }
                                }
                                if (object.contains("text")) {
                                    otcFilterEvent.q(object.getString("text"));
                                }
                                if (object.contains(TtmlNode.ATTR_TTS_FONT_SIZE)) {
                                    otcFilterEvent.m(object.getInteger(TtmlNode.ATTR_TTS_FONT_SIZE));
                                }
                                if (object.contains(TtmlNode.ATTR_TTS_FONT_WEIGHT)) {
                                    otcFilterEvent.n(object.getInteger(TtmlNode.ATTR_TTS_FONT_WEIGHT));
                                }
                            }
                        }
                        otcFilterEvent.k(aVar);
                        EventBus.d().k(otcFilterEvent);
                    }
                } catch (Exception e11) {
                    String message = e11.getMessage();
                    Objects.requireNonNull(message);
                    d.e("Exception in OTC-P2P JavaScript jump function", message);
                    aVar.a(false, e11.getMessage());
                }
            } else {
                aVar.a(false, (Object) null);
            }
        }
    }

    public boolean b() {
        return false;
    }
}
