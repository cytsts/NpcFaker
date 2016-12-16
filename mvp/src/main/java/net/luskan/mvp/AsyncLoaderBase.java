package net.luskan.mvp;

import android.os.AsyncTask;

import java.util.List;

/**
 * Created by Clayton on 14/12/2016.
 */

public abstract class AsyncLoaderBase<Params, Progress, Result> extends AsyncTask<Params, Progress, List<Result>> {

    public interface LoaderListener<Result> {
        void onSuccess(List<Result> lista);
        void onError(Exception e);
    }

    private boolean shouldFail;
    private LoaderListener<Result> listener;

    @Override
    protected void onPostExecute(List<Result> result) {
        if (isCancelled() || result == null || result.isEmpty() || result.size() == 0) {
            return;
        }
        if (shouldFail) {
            listener.onError(new Exception("Oops something went wrong"));
        } else {
            listener.onSuccess(result);
        }
    }
}
