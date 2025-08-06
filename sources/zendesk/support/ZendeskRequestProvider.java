package zendesk.support;

import com.zendesk.logger.Logger;
import com.zendesk.service.ErrorResponseAdapter;
import com.zendesk.service.ZendeskCallback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mz.a;
import mz.f;
import zendesk.core.AnonymousIdentity;
import zendesk.core.AuthenticationProvider;
import zendesk.core.AuthenticationType;
import zendesk.core.Identity;

final class ZendeskRequestProvider implements RequestProvider {
    private static final String ALL_REQUEST_STATUSES = "new,open,pending,hold,solved,closed";
    private static final String GET_REQUESTS_SIDE_LOAD = "public_updated_at,last_commenting_agents,last_comment,first_comment";
    private static final String LOG_TAG = "ZendeskRequestProvider";
    private static final int MAX_TICKET_FIELDS = 5;
    /* access modifiers changed from: private */
    public final AuthenticationProvider authenticationProvider;
    /* access modifiers changed from: private */
    public final SupportBlipsProvider blipsProvider;
    /* access modifiers changed from: private */
    public final SupportSdkMetadata metadata;
    /* access modifiers changed from: private */
    public final ZendeskRequestService requestService;
    /* access modifiers changed from: private */
    public final RequestSessionCache requestSessionCache;
    /* access modifiers changed from: private */
    public final RequestStorage requestStorage;
    private final SupportSettingsProvider settingsProvider;
    /* access modifiers changed from: private */
    public final ZendeskTracker zendeskTracker;

    public ZendeskRequestProvider(SupportSettingsProvider supportSettingsProvider, ZendeskRequestService zendeskRequestService, AuthenticationProvider authenticationProvider2, RequestStorage requestStorage2, RequestSessionCache requestSessionCache2, ZendeskTracker zendeskTracker2, SupportSdkMetadata supportSdkMetadata, SupportBlipsProvider supportBlipsProvider) {
        this.settingsProvider = supportSettingsProvider;
        this.requestService = zendeskRequestService;
        this.authenticationProvider = authenticationProvider2;
        this.requestStorage = requestStorage2;
        this.requestSessionCache = requestSessionCache2;
        this.zendeskTracker = zendeskTracker2;
        this.metadata = supportSdkMetadata;
        this.blipsProvider = supportBlipsProvider;
    }

    /* access modifiers changed from: private */
    public void addCommentInternal(final String str, EndUserComment endUserComment, final ZendeskCallback<Comment> zendeskCallback) {
        this.requestService.addComment(str, endUserComment, new ZendeskCallbackSuccess<Request>(zendeskCallback) {
            public void onSuccess(Request request) {
                ZendeskRequestProvider.this.zendeskTracker.requestUpdated();
                ZendeskRequestProvider.this.blipsProvider.requestUpdated(str);
                if (request.getId() == null || request.getCommentCount() == null) {
                    Logger.l(ZendeskRequestProvider.LOG_TAG, "The ID and / or comment count was missing. Cannot store comment totalUpdates.", new Object[0]);
                } else {
                    ZendeskRequestProvider.this.requestStorage.updateRequestData(Collections.singletonList(request));
                }
                ZendeskCallback zendeskCallback = zendeskCallback;
                if (zendeskCallback != null) {
                    zendeskCallback.onSuccess(request.getLastComment());
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void addServerTags(CreateRequest createRequest, SupportSdkSettings supportSdkSettings) {
        List b11 = a.b(createRequest.getTags(), supportSdkSettings.getContactZendeskTags());
        if (a.i(b11)) {
            Logger.b(LOG_TAG, "Adding tags to feedback...", new Object[0]);
            createRequest.setTags(b11);
        }
    }

    /* access modifiers changed from: private */
    public static void answerCallbackOnConversationsDisabled(ZendeskCallback zendeskCallback) {
        Logger.b(LOG_TAG, "Conversations disabled, this feature is not available on your plan or was disabled.", new Object[0]);
        if (zendeskCallback != null) {
            zendeskCallback.onError(new ErrorResponseAdapter("Access Denied"));
        }
    }

    /* access modifiers changed from: private */
    public static boolean areConversationsEnabled(SupportSdkSettings supportSdkSettings) {
        if (supportSdkSettings == null) {
            return false;
        }
        return supportSdkSettings.isConversationsEnabled();
    }

    /* access modifiers changed from: private */
    public static RequestUpdates calcRequestUpdates(List<RequestData> list) {
        HashMap hashMap = new HashMap(list.size());
        for (RequestData next : list) {
            int unreadComments = next.unreadComments();
            if (unreadComments != 0) {
                hashMap.put(next.getId(), Integer.valueOf(unreadComments));
            }
        }
        return new RequestUpdates(hashMap);
    }

    /* access modifiers changed from: private */
    public static List<TicketForm> convertTicketFormResponse(List<RawTicketForm> list, List<RawTicketField> list2) {
        ArrayList arrayList = new ArrayList();
        Map<Long, TicketField> createTicketFieldMap = createTicketFieldMap(list2);
        for (RawTicketForm createTicketFormFromResponse : list) {
            arrayList.add(createTicketFormFromResponse(createTicketFormFromResponse, createTicketFieldMap));
        }
        return arrayList;
    }

    private static Map<Long, TicketField> createTicketFieldMap(List<RawTicketField> list) {
        HashMap hashMap = new HashMap(list.size());
        for (RawTicketField next : list) {
            hashMap.put(Long.valueOf(next.getId()), TicketField.create(next));
        }
        return hashMap;
    }

    private static TicketForm createTicketFormFromResponse(RawTicketForm rawTicketForm, Map<Long, TicketField> map) {
        ArrayList arrayList = new ArrayList();
        for (Long next : rawTicketForm.getTicketFieldIds()) {
            if (!(next == null || map.get(next) == null)) {
                arrayList.add(map.get(next));
            }
        }
        return RawTicketForm.create(rawTicketForm, arrayList);
    }

    /* access modifiers changed from: private */
    public void getAllRequestsInternal(String str, AuthenticationType authenticationType, final ZendeskCallback<List<Request>> zendeskCallback) {
        if (f.e(str)) {
            str = ALL_REQUEST_STATUSES;
        }
        AnonymousClass3 r02 = new ZendeskCallbackSuccess<List<Request>>(zendeskCallback) {
            public void onSuccess(List<Request> list) {
                ZendeskRequestProvider.this.requestStorage.updateRequestData(list);
                ZendeskCallback zendeskCallback = zendeskCallback;
                if (zendeskCallback != null) {
                    zendeskCallback.onSuccess(list);
                }
            }
        };
        if (authenticationType == AuthenticationType.ANONYMOUS) {
            List<RequestData> requestData = this.requestStorage.getRequestData();
            ArrayList arrayList = new ArrayList(requestData.size());
            for (RequestData id2 : requestData) {
                arrayList.add(id2.getId());
            }
            if (a.g(arrayList)) {
                Logger.l(LOG_TAG, "getAllRequestsInternal: There are no requests to fetch", new Object[0]);
                if (zendeskCallback != null) {
                    zendeskCallback.onSuccess(new ArrayList());
                    return;
                }
                return;
            }
            this.requestService.getAllRequests(f.g(arrayList), str, GET_REQUESTS_SIDE_LOAD, r02);
            return;
        }
        this.requestService.getAllRequests(str, GET_REQUESTS_SIDE_LOAD, r02);
    }

    /* access modifiers changed from: private */
    public void internalCreateRequest(CreateRequest createRequest, AuthenticationType authenticationType, Identity identity, final ZendeskCallback<Request> zendeskCallback) {
        AnonymousClass2 r02 = new ZendeskCallbackSuccess<Request>(zendeskCallback) {
            public void onSuccess(Request request) {
                if (request == null || request.getId() == null) {
                    onError(new ErrorResponseAdapter("The request was created, but the ID is unknown."));
                    return;
                }
                ZendeskRequestProvider.this.zendeskTracker.requestCreated();
                ZendeskRequestProvider.this.blipsProvider.requestCreated(request.getId());
                ZendeskRequestProvider.this.requestStorage.updateRequestData(Collections.singletonList(request));
                ZendeskCallback zendeskCallback = zendeskCallback;
                if (zendeskCallback != null) {
                    zendeskCallback.onSuccess(request);
                }
            }
        };
        if (authenticationType != AuthenticationType.ANONYMOUS || identity == null || !(identity instanceof AnonymousIdentity)) {
            this.requestService.createRequest((String) null, createRequest, r02);
            return;
        }
        this.requestService.createRequest(((AnonymousIdentity) identity).getSdkGuid(), createRequest, r02);
    }

    public void addComment(String str, EndUserComment endUserComment, ZendeskCallback<Comment> zendeskCallback) {
        final String str2 = str;
        final EndUserComment endUserComment2 = endUserComment;
        final ZendeskCallback<Comment> zendeskCallback2 = zendeskCallback;
        this.settingsProvider.getSettings(new ZendeskCallbackSuccess<SupportSdkSettings>(zendeskCallback) {
            public void onSuccess(SupportSdkSettings supportSdkSettings) {
                if (ZendeskRequestProvider.areConversationsEnabled(supportSdkSettings)) {
                    ZendeskRequestProvider.this.addCommentInternal(str2, endUserComment2, zendeskCallback2);
                } else {
                    ZendeskRequestProvider.answerCallbackOnConversationsDisabled(zendeskCallback2);
                }
            }
        });
    }

    public void createRequest(final CreateRequest createRequest, final ZendeskCallback<Request> zendeskCallback) {
        if (!(createRequest != null)) {
            Logger.d(LOG_TAG, "configuration is invalid: request null", new Object[0]);
            if (zendeskCallback != null) {
                zendeskCallback.onError(new ErrorResponseAdapter("configuration is invalid: request null"));
                return;
            }
            return;
        }
        this.settingsProvider.getSettings(new ZendeskCallbackSuccess<SupportSdkSettings>(zendeskCallback) {
            public void onSuccess(SupportSdkSettings supportSdkSettings) {
                createRequest.setMetadata(ZendeskRequestProvider.this.metadata.getDeviceInfoAsMapForMetaData());
                ZendeskRequestProvider.this.addServerTags(createRequest, supportSdkSettings);
                ZendeskRequestProvider.this.internalCreateRequest(createRequest, supportSdkSettings.getAuthenticationType(), ZendeskRequestProvider.this.authenticationProvider.getIdentity(), zendeskCallback);
            }
        });
    }

    public void getAllRequests(ZendeskCallback<List<Request>> zendeskCallback) {
        getRequests((String) null, zendeskCallback);
    }

    public void getComments(final String str, final ZendeskCallback<CommentsResponse> zendeskCallback) {
        this.settingsProvider.getSettings(new ZendeskCallbackSuccess<SupportSdkSettings>(zendeskCallback) {
            public void onSuccess(SupportSdkSettings supportSdkSettings) {
                if (ZendeskRequestProvider.areConversationsEnabled(supportSdkSettings)) {
                    ZendeskRequestProvider.this.requestService.getComments(str, zendeskCallback);
                } else {
                    ZendeskRequestProvider.answerCallbackOnConversationsDisabled(zendeskCallback);
                }
            }
        });
    }

    public void getCommentsSince(String str, Date date, boolean z11, ZendeskCallback<CommentsResponse> zendeskCallback) {
        final String str2 = str;
        final Date date2 = date;
        final boolean z12 = z11;
        final ZendeskCallback<CommentsResponse> zendeskCallback2 = zendeskCallback;
        this.settingsProvider.getSettings(new ZendeskCallbackSuccess<SupportSdkSettings>(zendeskCallback) {
            public void onSuccess(SupportSdkSettings supportSdkSettings) {
                if (ZendeskRequestProvider.areConversationsEnabled(supportSdkSettings)) {
                    ZendeskRequestProvider.this.requestService.getCommentsSince(str2, date2, z12, zendeskCallback2);
                } else {
                    ZendeskRequestProvider.answerCallbackOnConversationsDisabled(zendeskCallback2);
                }
            }
        });
    }

    public void getRequest(final String str, final ZendeskCallback<Request> zendeskCallback) {
        this.settingsProvider.getSettings(new ZendeskCallbackSuccess<SupportSdkSettings>(zendeskCallback) {
            public void onSuccess(SupportSdkSettings supportSdkSettings) {
                if (ZendeskRequestProvider.areConversationsEnabled(supportSdkSettings)) {
                    ZendeskRequestProvider.this.requestService.getRequest(str, ZendeskRequestProvider.GET_REQUESTS_SIDE_LOAD, zendeskCallback);
                } else {
                    ZendeskRequestProvider.answerCallbackOnConversationsDisabled(zendeskCallback);
                }
            }
        });
    }

    public void getRequests(final String str, final ZendeskCallback<List<Request>> zendeskCallback) {
        this.settingsProvider.getSettings(new ZendeskCallbackSuccess<SupportSdkSettings>(zendeskCallback) {
            public void onSuccess(SupportSdkSettings supportSdkSettings) {
                if (ZendeskRequestProvider.areConversationsEnabled(supportSdkSettings)) {
                    ZendeskRequestProvider.this.getAllRequestsInternal(str, supportSdkSettings.getAuthenticationType(), zendeskCallback);
                } else {
                    ZendeskRequestProvider.answerCallbackOnConversationsDisabled(zendeskCallback);
                }
            }
        });
    }

    public void getTicketFormsById(List<Long> list, final ZendeskCallback<List<TicketForm>> zendeskCallback) {
        if (!a.g(list)) {
            final ArrayList arrayList = new ArrayList();
            if (list.size() > 5) {
                arrayList.addAll(list.subList(0, 5));
                Logger.b(LOG_TAG, "Maximum number of allowed ticket fields: %d.", 5);
            } else {
                arrayList.addAll(list);
            }
            if (!this.requestSessionCache.containsAllTicketForms(arrayList)) {
                this.settingsProvider.getSettings(new ZendeskCallbackSuccess<SupportSdkSettings>(zendeskCallback) {
                    public void onSuccess(SupportSdkSettings supportSdkSettings) {
                        if (supportSdkSettings.isTicketFormSupportAvailable()) {
                            ZendeskRequestProvider.this.requestService.getTicketFormsById(f.i(arrayList), new ZendeskCallbackSuccess<RawTicketFormResponse>(zendeskCallback) {
                                public void onSuccess(RawTicketFormResponse rawTicketFormResponse) {
                                    List access$1200 = ZendeskRequestProvider.convertTicketFormResponse(rawTicketFormResponse.getTicketForms(), rawTicketFormResponse.getTicketFields());
                                    ZendeskRequestProvider.this.requestSessionCache.updateTicketFormCache(access$1200);
                                    ZendeskCallback zendeskCallback = zendeskCallback;
                                    if (zendeskCallback != null) {
                                        zendeskCallback.onSuccess(access$1200);
                                    }
                                }
                            });
                            return;
                        }
                        ZendeskCallback zendeskCallback = zendeskCallback;
                        if (zendeskCallback != null) {
                            zendeskCallback.onError(new ErrorResponseAdapter("Ticket form support disabled."));
                        }
                    }
                });
            } else if (zendeskCallback != null) {
                zendeskCallback.onSuccess(this.requestSessionCache.getTicketFormsById(arrayList));
            }
        } else if (zendeskCallback != null) {
            zendeskCallback.onError(new ErrorResponseAdapter("Ticket forms must at least contain 1 Id"));
        }
    }

    public void getUpdatesForDevice(final ZendeskCallback<RequestUpdates> zendeskCallback) {
        if (!this.requestStorage.isRequestDataExpired()) {
            zendeskCallback.onSuccess(calcRequestUpdates(this.requestStorage.getRequestData()));
        } else {
            this.settingsProvider.getSettings(new ZendeskCallback<SupportSdkSettings>() {
                public void onError(lz.a aVar) {
                    zendeskCallback.onError(aVar);
                }

                public void onSuccess(SupportSdkSettings supportSdkSettings) {
                    if (!supportSdkSettings.isConversationsEnabled()) {
                        ZendeskRequestProvider.answerCallbackOnConversationsDisabled(zendeskCallback);
                    } else {
                        ZendeskRequestProvider.this.getAllRequestsInternal((String) null, supportSdkSettings.getAuthenticationType(), new ZendeskCallbackSuccess<List<Request>>(zendeskCallback) {
                            public void onSuccess(List<Request> list) {
                                zendeskCallback.onSuccess(ZendeskRequestProvider.calcRequestUpdates(ZendeskRequestProvider.this.requestStorage.getRequestData()));
                            }
                        });
                    }
                }
            });
        }
    }

    public void markRequestAsRead(String str, int i11) {
        this.requestStorage.markRequestAsRead(str, i11);
    }

    public void markRequestAsUnread(String str) {
        this.requestStorage.markRequestAsUnread(str);
    }
}
