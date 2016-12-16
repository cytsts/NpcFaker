package net.luskan.npcfaker.modelo;

import android.support.annotation.NonNull;

import java.util.List;

/**
 * Created by Clayton on 15/12/2016.
 */

public class Requisito<T> implements IRequisitos<T> {
    List<T> mRequisitos;

    @Override
    public List<T> get() {
        return mRequisitos;
    }

    @Override
    public void set(@NonNull List<T> elementos) {
        mRequisitos = elementos;
    }

    @Override
    public void add(@NonNull T elemento) {
        mRequisitos.add(elemento);
    }
}
