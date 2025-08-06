package cn.sharesdk.framework.authorize;

import cn.sharesdk.framework.Platform;

public interface AuthorizeHelper {
    AuthorizeListener getAuthorizeListener();

    String getAuthorizeUrl();

    b getAuthorizeWebviewClient(WebAuthorizeActivity webAuthorizeActivity);

    Platform getPlatform();

    String getRedirectUri();

    SSOListener getSSOListener();

    c getSSOProcessor(SSOAuthorizeActivity sSOAuthorizeActivity);
}
