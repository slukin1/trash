package com.huobi.otc.edgeengine.p2p;

import com.eclipsesource.v8.V8Object;
import com.huobi.edgeengine.ability.AbilityFunction;
import com.huobi.edgeengine.ability.AbstractAbility;
import i6.d;
import java.util.Objects;
import org.greenrobot.eventbus.EventBus;
import rj.b;

public class OtcMerchantSearchBridgeAbility extends AbstractAbility {
    public void a(b bVar, Object obj, AbilityFunction.a aVar) {
        if (aVar != null) {
            if (obj instanceof V8Object) {
                try {
                    if (((V8Object) obj).contains("action")) {
                        OtcMerchantSearchEvent otcMerchantSearchEvent = new OtcMerchantSearchEvent();
                        otcMerchantSearchEvent.e(((V8Object) obj).getString("action"));
                        if (((V8Object) obj).contains("uid")) {
                            otcMerchantSearchEvent.g((long) ((V8Object) obj).getInteger("uid"));
                        }
                        otcMerchantSearchEvent.f(aVar);
                        EventBus.d().k(otcMerchantSearchEvent);
                    }
                } catch (Exception e11) {
                    String message = e11.getMessage();
                    Objects.requireNonNull(message);
                    d.e("Exception in OTC-P2P JavaScript jump function merchantSearch", message);
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
