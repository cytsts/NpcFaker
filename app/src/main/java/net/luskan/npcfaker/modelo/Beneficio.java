package net.luskan.npcfaker.modelo;

import android.support.annotation.NonNull;

import java.util.List;

/**
 * Created by Clayton on 15/12/2016.
 */

public class Beneficio<T> implements IBeneficios<T> {
    List<T> mBeneficios;

    @Override
    public List<T> get() {
        return mBeneficios;
    }

    @Override
    public void set(@NonNull List<T> elementos) {
        mBeneficios = elementos;
    }

    @Override
    public void add(@NonNull T elemento) {
        mBeneficios.add(elemento);
    }
}
