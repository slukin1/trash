package com.jumio.core.util;

import com.jumio.core.ServiceLocator;
import com.jumio.core.interfaces.QAInterface;
import jumio.core.v0;
import kotlin.jvm.internal.Lambda;

public final class QAKt {

    public static final class a extends Lambda implements d10.a<QAInterface> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f39505a = new a();

        public a() {
            super(0);
        }

        public final Object invoke() {
            return new v0();
        }
    }

    public static final QAInterface getQA() {
        return (QAInterface) ServiceLocator.INSTANCE.getServiceImplementation(QAInterface.class, a.f39505a);
    }
}
