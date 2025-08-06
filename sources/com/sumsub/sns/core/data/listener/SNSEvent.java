package com.sumsub.sns.core.data.listener;

import androidx.annotation.Keep;
import com.sumsub.sns.core.a;
import java.util.List;
import java.util.Map;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.i;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.r;
import kotlin.l;
import kotlinx.serialization.ContextualSerializer;
import kotlinx.serialization.b;
import kotlinx.serialization.f;
import kotlinx.serialization.internal.q1;
import kotlinx.serialization.internal.r0;
import kotlinx.serialization.internal.v1;

@a
@f
@Keep
@Metadata(bv = {}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u001a2\u00020\u0001:\u0011\u001b\u001a\u001c\u001d\u001e\u001f !\"#$%&'()*B)\b\u0004\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e¢\u0006\u0004\b\u0013\u0010\u0014B;\b\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0013\u0010\u0019J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR%\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u0001\r+,-./01234567¨\u00068"}, d2 = {"Lcom/sumsub/sns/core/data/listener/SNSEvent;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "write$Self", "", "eventType", "Ljava/lang/String;", "getEventType", "()Ljava/lang/String;", "", "payload", "Ljava/util/Map;", "getPayload", "()Ljava/util/Map;", "<init>", "(Ljava/lang/String;Ljava/util/Map;)V", "", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/util/Map;Lkotlinx/serialization/internal/q1;)V", "Companion", "ApplicantDataUpdated", "CountrySelected", "DocumentTypeSelected", "EventParams", "EventType", "PhotoAccepted", "PhotoDeclined", "SNSEventAnalytics", "SNSEventApplicantLoaded", "SNSEventStepCompleted", "SNSEventStepInitiated", "ShowMoreGuidance", "SupportItemClicked", "UserStartedVerification", "VerificationStarted", "ViewItem", "Lcom/sumsub/sns/core/data/listener/SNSEvent$ApplicantDataUpdated;", "Lcom/sumsub/sns/core/data/listener/SNSEvent$CountrySelected;", "Lcom/sumsub/sns/core/data/listener/SNSEvent$DocumentTypeSelected;", "Lcom/sumsub/sns/core/data/listener/SNSEvent$PhotoAccepted;", "Lcom/sumsub/sns/core/data/listener/SNSEvent$PhotoDeclined;", "Lcom/sumsub/sns/core/data/listener/SNSEvent$SNSEventAnalytics;", "Lcom/sumsub/sns/core/data/listener/SNSEvent$SNSEventApplicantLoaded;", "Lcom/sumsub/sns/core/data/listener/SNSEvent$SNSEventStepCompleted;", "Lcom/sumsub/sns/core/data/listener/SNSEvent$SNSEventStepInitiated;", "Lcom/sumsub/sns/core/data/listener/SNSEvent$ShowMoreGuidance;", "Lcom/sumsub/sns/core/data/listener/SNSEvent$SupportItemClicked;", "Lcom/sumsub/sns/core/data/listener/SNSEvent$UserStartedVerification;", "Lcom/sumsub/sns/core/data/listener/SNSEvent$VerificationStarted;", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public abstract class SNSEvent {
    /* access modifiers changed from: private */
    public static final i<b<Object>> $cachedSerializer$delegate = LazyKt__LazyJVMKt.b(LazyThreadSafetyMode.PUBLICATION, SNSEvent$Companion$$cachedSerializer$delegate$1.INSTANCE);
    public static final Companion Companion = new Companion((r) null);
    private final String eventType;
    private final Map<String, Object> payload;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/sumsub/sns/core/data/listener/SNSEvent$ApplicantDataUpdated;", "Lcom/sumsub/sns/core/data/listener/SNSEvent;", "values", "", "", "(Ljava/util/List;)V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class ApplicantDataUpdated extends SNSEvent {
        public ApplicantDataUpdated(List<String> list) {
            super(EventType.ApplicantDataUpdated.name(), MapsKt__MapsJVMKt.e(l.a(EventParams.Value.getValue(), list)), (r) null);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¨\u0006\u0007"}, d2 = {"Lcom/sumsub/sns/core/data/listener/SNSEvent$Companion;", "", "Lkotlinx/serialization/b;", "Lcom/sumsub/sns/core/data/listener/SNSEvent;", "serializer", "<init>", "()V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
    public static final class Companion {
        public /* synthetic */ Companion(r rVar) {
            this();
        }

        private final /* synthetic */ i get$cachedSerializer$delegate() {
            return SNSEvent.$cachedSerializer$delegate;
        }

        public final b<SNSEvent> serializer() {
            return (b) get$cachedSerializer$delegate().getValue();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/sumsub/sns/core/data/listener/SNSEvent$CountrySelected;", "Lcom/sumsub/sns/core/data/listener/SNSEvent;", "countryCode", "", "byUser", "", "(Ljava/lang/String;Z)V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CountrySelected extends SNSEvent {
        public CountrySelected(String str, boolean z11) {
            super(EventType.CountrySelected.name(), MapsKt__MapsKt.l(l.a(EventParams.CountryCode.getValue(), str), l.a(EventParams.ByUser.getValue(), Boolean.valueOf(z11))), (r) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/sumsub/sns/core/data/listener/SNSEvent$DocumentTypeSelected;", "Lcom/sumsub/sns/core/data/listener/SNSEvent;", "countryCode", "", "documentType", "(Ljava/lang/String;Ljava/lang/String;)V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class DocumentTypeSelected extends SNSEvent {
        public DocumentTypeSelected(String str, String str2) {
            super(EventType.ItemClicked.name(), MapsKt__MapsKt.l(l.a(EventParams.ViewItem.getValue(), ViewItem.DocumentType.name()), l.a(EventParams.CountryCode.getValue(), str), l.a(EventParams.DocumentType.getValue(), str2)), (r) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/sumsub/sns/core/data/listener/SNSEvent$EventParams;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "idDocSetType", "isCancelled", "CountryCode", "DocumentType", "ByUser", "Type", "Value", "ViewItem", "ApplicantId", "EventPayload", "EventName", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public enum EventParams {
        idDocSetType("idDocSetType"),
        isCancelled("isCancelled"),
        CountryCode("CountryCode"),
        DocumentType("DocumentType"),
        ByUser("ByUser"),
        Type("Type"),
        Value("Value"),
        ViewItem("ViewItem"),
        ApplicantId("applicantId"),
        EventPayload("eventPayload"),
        EventName("eventName");
        
        private final String value;

        private EventParams(String str) {
            this.value = str;
        }

        public final String getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/sumsub/sns/core/data/listener/SNSEvent$EventType;", "", "(Ljava/lang/String;I)V", "Analytics", "StepInitiated", "StepCompleted", "CountrySelected", "ApplicantLoaded", "ApplicantDataUpdated", "ItemClicked", "VerificationStarted", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public enum EventType {
        Analytics,
        StepInitiated,
        StepCompleted,
        CountrySelected,
        ApplicantLoaded,
        ApplicantDataUpdated,
        ItemClicked,
        VerificationStarted
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/sumsub/sns/core/data/listener/SNSEvent$PhotoAccepted;", "Lcom/sumsub/sns/core/data/listener/SNSEvent;", "idDocSetType", "", "(Ljava/lang/String;)V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class PhotoAccepted extends SNSEvent {
        public PhotoAccepted(String str) {
            super(EventType.ItemClicked.name(), MapsKt__MapsKt.l(l.a(EventParams.ViewItem.getValue(), ViewItem.PhotoAccepted.name()), l.a(EventParams.idDocSetType.getValue(), str)), (r) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/sumsub/sns/core/data/listener/SNSEvent$PhotoDeclined;", "Lcom/sumsub/sns/core/data/listener/SNSEvent;", "idDocSetType", "", "(Ljava/lang/String;)V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class PhotoDeclined extends SNSEvent {
        public PhotoDeclined(String str) {
            super(EventType.ItemClicked.name(), MapsKt__MapsKt.l(l.a(EventParams.ViewItem.getValue(), ViewItem.RetakePhoto.name()), l.a(EventParams.idDocSetType.getValue(), str)), (r) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/sumsub/sns/core/data/listener/SNSEvent$SNSEventAnalytics;", "Lcom/sumsub/sns/core/data/listener/SNSEvent;", "event", "Lcom/sumsub/sns/core/data/model/SNSTrackEvents;", "(Lcom/sumsub/sns/core/data/model/SNSTrackEvents;)V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class SNSEventAnalytics extends SNSEvent {
        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public SNSEventAnalytics(com.sumsub.sns.core.data.model.SNSTrackEvents r5) {
            /*
                r4 = this;
                com.sumsub.sns.core.data.listener.SNSEvent$EventType r0 = com.sumsub.sns.core.data.listener.SNSEvent.EventType.Analytics
                java.lang.String r0 = r0.name()
                r1 = 2
                kotlin.Pair[] r1 = new kotlin.Pair[r1]
                com.sumsub.sns.core.data.listener.SNSEvent$EventParams r2 = com.sumsub.sns.core.data.listener.SNSEvent.EventParams.EventPayload
                java.lang.String r2 = r2.getValue()
                java.util.Map r3 = r5.getPayload()
                if (r3 != 0) goto L_0x0019
                java.util.Map r3 = kotlin.collections.MapsKt__MapsKt.h()
            L_0x0019:
                kotlin.Pair r2 = kotlin.l.a(r2, r3)
                r3 = 0
                r1[r3] = r2
                com.sumsub.sns.core.data.listener.SNSEvent$EventParams r2 = com.sumsub.sns.core.data.listener.SNSEvent.EventParams.EventName
                java.lang.String r2 = r2.getValue()
                java.lang.String r5 = r5.getActivity()
                kotlin.Pair r5 = kotlin.l.a(r2, r5)
                r2 = 1
                r1[r2] = r5
                java.util.Map r5 = kotlin.collections.MapsKt__MapsKt.l(r1)
                r1 = 0
                r4.<init>(r0, r5, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.data.listener.SNSEvent.SNSEventAnalytics.<init>(com.sumsub.sns.core.data.model.SNSTrackEvents):void");
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/sumsub/sns/core/data/listener/SNSEvent$SNSEventApplicantLoaded;", "Lcom/sumsub/sns/core/data/listener/SNSEvent;", "applicantId", "", "(Ljava/lang/String;)V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class SNSEventApplicantLoaded extends SNSEvent {
        public SNSEventApplicantLoaded(String str) {
            super(EventType.ApplicantLoaded.name(), MapsKt__MapsJVMKt.e(l.a(EventParams.ApplicantId.getValue(), str)), (r) null);
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/sumsub/sns/core/data/listener/SNSEvent$SNSEventStepCompleted;", "Lcom/sumsub/sns/core/data/listener/SNSEvent;", "applicantId", "", "idDocSetType", "isCancelled", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class SNSEventStepCompleted extends SNSEvent {
        public SNSEventStepCompleted(String str, String str2, boolean z11) {
            super(EventType.StepCompleted.name(), MapsKt__MapsKt.l(l.a(EventParams.ApplicantId.getValue(), str), l.a(EventParams.idDocSetType.getValue(), str2), l.a(EventParams.isCancelled.getValue(), Boolean.valueOf(z11))), (r) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/sumsub/sns/core/data/listener/SNSEvent$SNSEventStepInitiated;", "Lcom/sumsub/sns/core/data/listener/SNSEvent;", "applicantId", "", "idDocSetType", "(Ljava/lang/String;Ljava/lang/String;)V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class SNSEventStepInitiated extends SNSEvent {
        public SNSEventStepInitiated(String str, String str2) {
            super(EventType.StepInitiated.name(), MapsKt__MapsKt.l(l.a(EventParams.ApplicantId.getValue(), str), l.a(EventParams.idDocSetType.getValue(), str2)), (r) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sumsub/sns/core/data/listener/SNSEvent$ShowMoreGuidance;", "Lcom/sumsub/sns/core/data/listener/SNSEvent;", "()V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class ShowMoreGuidance extends SNSEvent {
        public static final ShowMoreGuidance INSTANCE = new ShowMoreGuidance();

        private ShowMoreGuidance() {
            super(EventType.ItemClicked.name(), MapsKt__MapsJVMKt.e(l.a(EventParams.ViewItem.getValue(), ViewItem.MoreGuidance.name())), (r) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/sumsub/sns/core/data/listener/SNSEvent$SupportItemClicked;", "Lcom/sumsub/sns/core/data/listener/SNSEvent;", "type", "", "value", "(Ljava/lang/String;Ljava/lang/String;)V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class SupportItemClicked extends SNSEvent {
        public SupportItemClicked(String str, String str2) {
            super(EventType.ItemClicked.name(), MapsKt__MapsKt.l(l.a(EventParams.ViewItem.getValue(), ViewItem.SupportItem.name()), l.a(EventParams.Type.getValue(), str), l.a(EventParams.Value.getValue(), str2)), (r) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sumsub/sns/core/data/listener/SNSEvent$UserStartedVerification;", "Lcom/sumsub/sns/core/data/listener/SNSEvent;", "()V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class UserStartedVerification extends SNSEvent {
        public static final UserStartedVerification INSTANCE = new UserStartedVerification();

        private UserStartedVerification() {
            super(EventType.ItemClicked.name(), MapsKt__MapsJVMKt.e(l.a(EventParams.ViewItem.getValue(), ViewItem.Continue.name())), (r) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/sumsub/sns/core/data/listener/SNSEvent$VerificationStarted;", "Lcom/sumsub/sns/core/data/listener/SNSEvent;", "applicantId", "", "(Ljava/lang/String;)V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class VerificationStarted extends SNSEvent {
        public VerificationStarted(String str) {
            super(EventType.VerificationStarted.name(), MapsKt__MapsJVMKt.e(l.a(EventParams.ApplicantId.getValue(), str)), (r) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/sumsub/sns/core/data/listener/SNSEvent$ViewItem;", "", "(Ljava/lang/String;I)V", "Continue", "SupportItem", "MoreGuidance", "RetakePhoto", "PhotoAccepted", "DocumentType", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public enum ViewItem {
        Continue,
        SupportItem,
        MoreGuidance,
        RetakePhoto,
        PhotoAccepted,
        DocumentType
    }

    public /* synthetic */ SNSEvent(String str, Map map, r rVar) {
        this(str, map);
    }

    public static final void write$Self(SNSEvent sNSEvent, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
        bVar.p(fVar, 0, sNSEvent.eventType);
        if (bVar.q(fVar, 1) || sNSEvent.payload != null) {
            bVar.y(fVar, 1, new r0(v1.f57779a, new ContextualSerializer(Reflection.b(Object.class), (b) null, new b[0])), sNSEvent.payload);
        }
    }

    public final String getEventType() {
        return this.eventType;
    }

    public final Map<String, Object> getPayload() {
        return this.payload;
    }

    public /* synthetic */ SNSEvent(int i11, String str, Map map, q1 q1Var) {
        this.eventType = str;
        if ((i11 & 2) == 0) {
            this.payload = null;
        } else {
            this.payload = map;
        }
    }

    private SNSEvent(String str, Map<String, ? extends Object> map) {
        this.eventType = str;
        this.payload = map;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SNSEvent(String str, Map map, int i11, r rVar) {
        this(str, (i11 & 2) != 0 ? null : map, (r) null);
    }
}
