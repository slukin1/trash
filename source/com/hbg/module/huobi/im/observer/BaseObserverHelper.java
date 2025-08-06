package com.hbg.module.huobi.im.observer;

import com.hbg.module.huobi.im.group.bean.OberverData;
import java.util.Observable;

public class BaseObserverHelper extends Observable {

    /* renamed from: a  reason: collision with root package name */
    public boolean f20530a = true;

    public void a(OberverData oberverData) {
        if (this.f20530a) {
            setChanged();
            notifyObservers(oberverData);
        }
    }
}
