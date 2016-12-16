package net.luskan.mvp;

import android.support.annotation.UiThread;

/**
 * Created by Clayton on 13/12/2016.
 */
public interface Presenter<V extends View> {

    @UiThread
    V getView();

    @UiThread
    void attachView(V view);

    @UiThread
    void detachView(boolean retainInstance);

    @UiThread
    boolean isViewAttached();


}
