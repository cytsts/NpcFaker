package net.luskan.npcfaker.modelo;

import android.support.annotation.NonNull;

import java.util.List;

/**
 * Created by Clayton on 15/12/2016.
 */

public interface IList<T> {
    List<T> get();
    void set(@NonNull List<T> elementos);
    void add(@NonNull T elemento);
}
