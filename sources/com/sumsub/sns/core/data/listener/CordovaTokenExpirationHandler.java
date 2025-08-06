package com.sumsub.sns.core.data.listener;

import androidx.annotation.Keep;
import com.sumsub.sns.core.a;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlinx.coroutines.h;

@a
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¨\u0006\u0006"}, d2 = {"Lcom/sumsub/sns/core/data/listener/CordovaTokenExpirationHandler;", "Lcom/sumsub/sns/core/data/listener/TokenExpirationHandler;", "()V", "onTokenExpired", "", "onTokenExpiredMain", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Keep
public abstract class CordovaTokenExpirationHandler implements TokenExpirationHandler {
    public String onTokenExpired() {
        return (String) h.b((CoroutineContext) null, new CordovaTokenExpirationHandler$onTokenExpired$1(this, (c<? super CordovaTokenExpirationHandler$onTokenExpired$1>) null), 1, (Object) null);
    }

    public abstract String onTokenExpiredMain();
}
