package com.amazonaws.services.securitytoken.model.transform;

import com.amazonaws.services.securitytoken.model.DecodeAuthorizationMessageResult;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class DecodeAuthorizationMessageResultStaxUnmarshaller implements Unmarshaller<DecodeAuthorizationMessageResult, StaxUnmarshallerContext> {
    /* renamed from: b */
    public DecodeAuthorizationMessageResult a(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        DecodeAuthorizationMessageResult decodeAuthorizationMessageResult = new DecodeAuthorizationMessageResult();
        int a11 = staxUnmarshallerContext.a();
        int i11 = a11 + 1;
        if (staxUnmarshallerContext.b()) {
            i11 += 2;
        }
        while (true) {
            int c11 = staxUnmarshallerContext.c();
            if (c11 != 1) {
                if (c11 != 2) {
                    if (c11 == 3 && staxUnmarshallerContext.a() < a11) {
                        break;
                    }
                } else if (staxUnmarshallerContext.e("DecodedMessage", i11)) {
                    decodeAuthorizationMessageResult.setDecodedMessage(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.b().a(staxUnmarshallerContext));
                }
            } else {
                break;
            }
        }
        return decodeAuthorizationMessageResult;
    }
}
