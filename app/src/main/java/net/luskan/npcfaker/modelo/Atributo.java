package net.luskan.npcfaker.modelo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Clayton on 14/12/2016.
 */

public class Atributo implements Parcelable {
    public final String atributo;
    public final int valor;

    private int modificador;

    public int getModificador(){
        return modificador;
    }

    public Atributo(String atributo, int valor) {
        this.atributo = atributo;
        this.valor = valor;
        this.modificador = Math.round(valor/2 - 10);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.atributo);
        dest.writeInt(this.valor);
    }

    protected Atributo(Parcel in) {
        this.atributo = in.readString();
        this.valor = in.readInt();
    }

    public static final Parcelable.Creator<Atributo> CREATOR = new Parcelable.Creator<Atributo>() {
        @Override
        public Atributo createFromParcel(Parcel source) {
            return new Atributo(source);
        }

        @Override
        public Atributo[] newArray(int size) {
            return new Atributo[size];
        }
    };
}
