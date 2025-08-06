package androidx.credentials.playservices.controllers;

import androidx.credentials.exceptions.GetCredentialException;
import d10.a;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$ObjectRef;

public final class CredentialProviderController$Companion$maybeReportErrorResultCodeGet$1 extends Lambda implements a<Unit> {
    public final /* synthetic */ Ref$ObjectRef<GetCredentialException> $exception;
    public final /* synthetic */ l<GetCredentialException, Unit> $onError;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CredentialProviderController$Companion$maybeReportErrorResultCodeGet$1(l<? super GetCredentialException, Unit> lVar, Ref$ObjectRef<GetCredentialException> ref$ObjectRef) {
        super(0);
        this.$onError = lVar;
        this.$exception = ref$ObjectRef;
    }

    public final void invoke() {
        this.$onError.invoke(this.$exception.element);
    }
}
