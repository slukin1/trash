package com.jumio.core.extraction;

import com.jumio.analytics.MetaInfo;
import com.jumio.core.ServiceLocator;
import kotlin.jvm.internal.Lambda;

public interface ExtractionUpdateInterface<T> {
    public static final Companion Companion = Companion.f39176a;

    public static final class Companion {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ Companion f39176a = new Companion();

        public static final class a extends Lambda implements d10.a<ExtractionUpdateInterface<?>> {

            /* renamed from: a  reason: collision with root package name */
            public static final a f39177a = new a();

            public a() {
                super(0);
            }

            public final Object invoke() {
                return new DefaultExtractionUpdate();
            }
        }

        public static /* synthetic */ ExtractionUpdateInterface build$default(Companion companion, int i11, Object obj, MetaInfo metaInfo, int i12, Object obj2) {
            if ((i12 & 4) != 0) {
                metaInfo = null;
            }
            return companion.build(i11, obj, metaInfo);
        }

        public final <T> ExtractionUpdateInterface<T> build(int i11, T t11, MetaInfo metaInfo) {
            ExtractionUpdateInterface<T> extractionUpdateInterface = (ExtractionUpdateInterface) ServiceLocator.INSTANCE.getServiceImplementation(ExtractionUpdateInterface.class, a.f39177a);
            extractionUpdateInterface.setState(Integer.valueOf(i11));
            extractionUpdateInterface.setData(t11);
            extractionUpdateInterface.setMetaInfo(metaInfo);
            return extractionUpdateInterface;
        }
    }

    T getData();

    MetaInfo getMetaInfo();

    Integer getState();

    void setData(T t11);

    void setMetaInfo(MetaInfo metaInfo);

    void setState(Integer num);
}
