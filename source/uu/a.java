package uu;

import okhttp3.Dns;
import org.aspectj.runtime.internal.AroundClosure;

public class a extends AroundClosure {
    public a(Object[] objArr) {
        super(objArr);
    }

    public Object run(Object[] objArr) {
        Object[] objArr2 = this.state;
        return ((Dns) objArr2[1]).lookup((String) objArr2[2]);
    }
}
