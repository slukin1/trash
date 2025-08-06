package com.bumptech.glide.request;

public interface RequestCoordinator {

    public enum RequestState {
        RUNNING(false),
        PAUSED(false),
        CLEARED(false),
        SUCCESS(true),
        FAILED(true);
        
        private final boolean isComplete;

        private RequestState(boolean z11) {
            this.isComplete = z11;
        }

        public boolean isComplete() {
            return this.isComplete;
        }
    }

    boolean a();

    void b(c cVar);

    boolean c(c cVar);

    boolean d(c cVar);

    void g(c cVar);

    RequestCoordinator getRoot();

    boolean i(c cVar);
}
