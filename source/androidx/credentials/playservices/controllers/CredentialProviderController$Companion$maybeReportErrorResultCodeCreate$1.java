package androidx.credentials.playservices.controllers;

import androidx.credentials.exceptions.CreateCredentialException;
import d10.a;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$ObjectRef;

public final class CredentialProviderController$Companion$maybeReportErrorResultCodeCreate$1 extends Lambda implements a<Unit> {
    public final /* synthetic */ Ref$ObjectRef<CreateCredentialException> $exception;
    public final /* synthetic */ l<CreateCredentialException, Unit> $onError;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CredentialProviderController$Companion$maybeReportErrorResultCodeCreate$1(l<? super CreateCredentialException, Unit> lVar, Ref$ObjectRef<CreateCredentialException> ref$ObjectRef) {
        super(0);
        this.$onError = lVar;
        this.$exception = ref$ObjectRef;
    }

    public final void invoke() {
        this.$onError.invoke(this.$exception.element);
    }
}
