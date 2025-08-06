package com.zopim.android.sdk.api;

import com.zopim.android.sdk.breadcrumbs.Event;

interface BreadcrumbsApi {
    void sendEvents(Event... eventArr);
}
