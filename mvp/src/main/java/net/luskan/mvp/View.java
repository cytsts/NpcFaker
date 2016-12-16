package net.luskan.mvp;

import java.util.List;

/**
 * Created by Clayton on 13/12/2016.
 */

public interface View<M extends Modelo> {
    public List<M> getModelo();
    public void setData(List<M> data);
    public void showLoader(boolean atualizando);
    public void showProgess(int progesso);
}
