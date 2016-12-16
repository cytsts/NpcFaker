package net.luskan.mvp;

import android.os.AsyncTask;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * Created by Clayton on 13/12/2016.
 */

public class BasePresenter<V extends View> implements Presenter<V>{


    private WeakReference<V> mViewReferencia;

    @Override
    public V getView() {
        return mViewReferencia == null ? null : mViewReferencia.get();
    }

    @Override
    public void attachView(V view) {
        mViewReferencia = new WeakReference<V>(view);
    }

    @Override
    public void detachView(boolean retainInstance) {
        if (mViewReferencia != null) {
            mViewReferencia.clear();
            mViewReferencia = null;
        }
    }

    @Override
    public boolean isViewAttached() {
        return mViewReferencia != null && mViewReferencia.get() != null;
    }

    public class aa extends AsyncTask<String, String, List<String>>{

        @Override
        protected List<String> doInBackground(String... params) {
            return null;
        }
    }

}
