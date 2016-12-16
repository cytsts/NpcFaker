package net.luskan.npcfaker.modelo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Clayton on 14/12/2016.
 */

public class Personagens implements Parcelable {
    public final Atributo Forca;
    public final Atributo Destreza;
    public final Atributo Constituicao;
    public final Atributo Inteligencia;
    public final Atributo Sabedoria;
    public final Atributo Carisma;

    public Personagens(Atributo forca, Atributo destreza, Atributo constituicao, Atributo inteligencia, Atributo sabedoria, Atributo carisma) {
        Forca = forca;
        Destreza = destreza;
        Constituicao = constituicao;
        Inteligencia = inteligencia;
        Sabedoria = sabedoria;
        Carisma = carisma;
    }

    public Personagens(Personagens other) {
        this.Forca = other.Forca;
        this.Destreza = other.Destreza;
        this.Constituicao = other.Constituicao;
        this.Inteligencia = other.Inteligencia;
        this.Sabedoria = other.Sabedoria;
        this.Carisma = other.Carisma;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.Forca, flags);
        dest.writeParcelable(this.Destreza, flags);
        dest.writeParcelable(this.Constituicao, flags);
        dest.writeParcelable(this.Inteligencia, flags);
        dest.writeParcelable(this.Sabedoria, flags);
        dest.writeParcelable(this.Carisma, flags);
    }

    protected Personagens(Parcel in) {
        this.Forca = in.readParcelable(Atributo.class.getClassLoader());
        this.Destreza = in.readParcelable(Atributo.class.getClassLoader());
        this.Constituicao = in.readParcelable(Atributo.class.getClassLoader());
        this.Inteligencia = in.readParcelable(Atributo.class.getClassLoader());
        this.Sabedoria = in.readParcelable(Atributo.class.getClassLoader());
        this.Carisma = in.readParcelable(Atributo.class.getClassLoader());
    }

    public static final Parcelable.Creator<Personagens> CREATOR = new Parcelable.Creator<Personagens>() {
        @Override
        public Personagens createFromParcel(Parcel source) {
            return new Personagens(source);
        }

        @Override
        public Personagens[] newArray(int size) {
            return new Personagens[size];
        }
    };
}
