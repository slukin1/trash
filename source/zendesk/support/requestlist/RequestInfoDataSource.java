package zendesk.support.requestlist;

import com.google.gson.reflect.TypeToken;
import com.zendesk.service.ZendeskCallback;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Executor;
import jz.b;
import mz.a;
import mz.f;
import zendesk.support.Attachment;
import zendesk.support.Comment;
import zendesk.support.Request;
import zendesk.support.RequestProvider;
import zendesk.support.RequestUpdates;
import zendesk.support.SupportUiStorage;
import zendesk.support.User;
import zendesk.support.requestlist.RequestInfo;

public interface RequestInfoDataSource {
    public static final String LOCAL = "local_request_infos";
    public static final String REMOTE = "remote_request_infos";

    public static class Disk implements RequestInfoDataSource {
        private final Executor backgroundThreadExecutor;
        /* access modifiers changed from: private */
        public final String cacheKey;
        /* access modifiers changed from: private */
        public final Executor mainThreadExecutor;
        /* access modifiers changed from: private */
        public final SupportUiStorage supportUiStorage;

        public Disk(Executor executor, Executor executor2, SupportUiStorage supportUiStorage2, String str) {
            this.mainThreadExecutor = executor;
            this.backgroundThreadExecutor = executor2;
            this.supportUiStorage = supportUiStorage2;
            this.cacheKey = str;
        }

        public void load(final ZendeskCallback<List<RequestInfo>> zendeskCallback) {
            this.backgroundThreadExecutor.execute(new Runnable() {
                public void run() {
                    final List list = (List) Disk.this.supportUiStorage.read(Disk.this.cacheKey, new TypeToken<List<RequestInfo>>() {
                    }.getType());
                    Disk.this.mainThreadExecutor.execute(new Runnable() {
                        public void run() {
                            zendeskCallback.onSuccess(a.e(list));
                        }
                    });
                }
            });
        }

        public void save(final List<RequestInfo> list, final ZendeskCallback<List<RequestInfo>> zendeskCallback) {
            this.backgroundThreadExecutor.execute(new Runnable() {
                public void run() {
                    Disk.this.supportUiStorage.write(Disk.this.cacheKey, list);
                    if (zendeskCallback != null) {
                        Disk.this.mainThreadExecutor.execute(new Runnable() {
                            public void run() {
                                AnonymousClass2 r02 = AnonymousClass2.this;
                                zendeskCallback.onSuccess(list);
                            }
                        });
                    }
                }
            });
        }
    }

    public static class LocalDataSource implements RequestInfoDataSource {
        /* access modifiers changed from: private */
        public static final Comparator<RequestInfo> REQUEST_INFO_COMPARATOR = new RequestInfo.LastUpdatedComparator();
        /* access modifiers changed from: private */
        public final Disk disk;

        public LocalDataSource(Disk disk2) {
            this.disk = disk2;
        }

        public void insert(final RequestInfo requestInfo, final ZendeskCallback<List<RequestInfo>> zendeskCallback) {
            this.disk.load(new ZendeskCallback<List<RequestInfo>>() {
                public void onError(lz.a aVar) {
                    ZendeskCallback zendeskCallback = zendeskCallback;
                    if (zendeskCallback != null) {
                        zendeskCallback.onError(aVar);
                    }
                }

                public void onSuccess(List<RequestInfo> list) {
                    List<TypeT> a11 = a.a(list, requestInfo, new b<RequestInfo, RequestInfo, Boolean>() {
                        public Boolean apply(RequestInfo requestInfo, RequestInfo requestInfo2) {
                            boolean equals = requestInfo2.getLocalId().equals(requestInfo.getLocalId());
                            boolean z11 = true;
                            boolean z12 = f.c(requestInfo2.getRemoteId()) && requestInfo2.getRemoteId().equals(requestInfo.getRemoteId());
                            if (!equals && !z12) {
                                z11 = false;
                            }
                            return Boolean.valueOf(z11);
                        }
                    });
                    Collections.sort(a11, LocalDataSource.REQUEST_INFO_COMPARATOR);
                    LocalDataSource.this.disk.save(a11, zendeskCallback);
                }
            });
        }

        public void load(ZendeskCallback<List<RequestInfo>> zendeskCallback) {
            this.disk.load(zendeskCallback);
        }

        public void remove(final String str, final ZendeskCallback<List<RequestInfo>> zendeskCallback) {
            this.disk.load(new ZendeskCallback<List<RequestInfo>>() {
                public void onError(lz.a aVar) {
                    ZendeskCallback zendeskCallback = zendeskCallback;
                    if (zendeskCallback != null) {
                        zendeskCallback.onError(aVar);
                    }
                }

                public void onSuccess(List<RequestInfo> list) {
                    LocalDataSource.this.disk.save(a.f(list, new jz.a<RequestInfo, Boolean>() {
                        public Boolean apply(RequestInfo requestInfo) {
                            return Boolean.valueOf(!str.equals(requestInfo.getLocalId()));
                        }
                    }), zendeskCallback);
                }
            });
        }
    }

    public static class Network implements RequestInfoDataSource {
        /* access modifiers changed from: private */
        public final RequestProvider requestProvider;

        public Network(RequestProvider requestProvider2) {
            this.requestProvider = requestProvider2;
        }

        /* access modifiers changed from: private */
        public RequestInfo map(Request request, boolean z11) {
            Comment firstComment = request.getFirstComment();
            Comment lastComment = request.getLastComment();
            return new RequestInfo("", request.getId(), request.getStatus(), z11, request.getPublicUpdatedAt(), a.k(a.f(request.getLastCommentingAgents(), new jz.a<User, Boolean>() {
                public Boolean apply(User user) {
                    return Boolean.valueOf(user != null);
                }
            }), new jz.a<User, RequestInfo.AgentInfo>() {
                public RequestInfo.AgentInfo apply(User user) {
                    Attachment photo = user.getPhoto();
                    return new RequestInfo.AgentInfo(String.valueOf(user.getId()), user.getName(), photo != null ? photo.getContentUrl() : "");
                }
            }), new RequestInfo.MessageInfo(String.valueOf(firstComment.getId()), firstComment.getCreatedAt(), firstComment.getBody()), new RequestInfo.MessageInfo(String.valueOf(lastComment.getId()), lastComment.getCreatedAt(), lastComment.getBody()), new HashSet());
        }

        public void load(final ZendeskCallback<List<RequestInfo>> zendeskCallback) {
            this.requestProvider.getAllRequests(new ZendeskCallback<List<Request>>() {
                public void onError(lz.a aVar) {
                    zendeskCallback.onError(aVar);
                }

                public void onSuccess(final List<Request> list) {
                    Network.this.requestProvider.getUpdatesForDevice(new ZendeskCallback<RequestUpdates>() {
                        public void onError(lz.a aVar) {
                            zendeskCallback.onError(aVar);
                        }

                        public void onSuccess(final RequestUpdates requestUpdates) {
                            zendeskCallback.onSuccess(a.k(list, new jz.a<Request, RequestInfo>() {
                                public RequestInfo apply(Request request) {
                                    return Network.this.map(request, requestUpdates.isRequestUnread(request.getId()));
                                }
                            }));
                        }
                    });
                }
            });
        }
    }

    public static class RemoteDataSource implements RequestInfoDataSource {
        /* access modifiers changed from: private */
        public final Disk disk;
        private final Network network;

        public RemoteDataSource(Network network2, Disk disk2) {
            this.network = network2;
            this.disk = disk2;
        }

        public void load(final ZendeskCallback<List<RequestInfo>> zendeskCallback) {
            this.network.load(new ZendeskCallback<List<RequestInfo>>() {
                public void onError(final lz.a aVar) {
                    RemoteDataSource.this.disk.load(new ZendeskCallback<List<RequestInfo>>() {
                        public void onError(lz.a aVar) {
                            zendeskCallback.onError(aVar);
                        }

                        public void onSuccess(List<RequestInfo> list) {
                            zendeskCallback.onSuccess(list);
                            zendeskCallback.onError(aVar);
                        }
                    });
                }

                public void onSuccess(List<RequestInfo> list) {
                    RemoteDataSource.this.disk.save(list, zendeskCallback);
                }
            });
        }
    }

    public static class Repository implements RequestInfoDataSource {
        private final RequestInfoDataSource localDataSource;
        /* access modifiers changed from: private */
        public final RequestInfoMerger merger;
        /* access modifiers changed from: private */
        public final RequestInfoDataSource remoteDataSource;

        public Repository(RequestInfoDataSource requestInfoDataSource, RequestInfoDataSource requestInfoDataSource2, RequestInfoMerger requestInfoMerger) {
            this.localDataSource = requestInfoDataSource;
            this.remoteDataSource = requestInfoDataSource2;
            this.merger = requestInfoMerger;
        }

        public void load(final ZendeskCallback<List<RequestInfo>> zendeskCallback) {
            this.localDataSource.load(new ZendeskCallback<List<RequestInfo>>() {
                public void onError(lz.a aVar) {
                }

                public void onSuccess(final List<RequestInfo> list) {
                    Repository.this.remoteDataSource.load(new ZendeskCallback<List<RequestInfo>>() {
                        public void onError(lz.a aVar) {
                            zendeskCallback.onError(aVar);
                        }

                        public void onSuccess(List<RequestInfo> list) {
                            AnonymousClass1 r02 = AnonymousClass1.this;
                            zendeskCallback.onSuccess(Repository.this.merger.merge((List<RequestInfo>) list, list));
                        }
                    });
                }
            });
        }
    }

    void load(ZendeskCallback<List<RequestInfo>> zendeskCallback);
}
