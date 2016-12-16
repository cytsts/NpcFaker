package net.luskan.npcfaker.modelo;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Clayton on 15/12/2016.
 */

public class Pericia implements Parcelable {
    public final String Nome;
    public final double Graduacao;
    public final Atributo AtributoChave;
    public final int ModificadorRacial;
    public final Map<String, Integer> ModificadorDiveso;

    public final String Detalhe;
    public final boolean isPenalidadeArmadura;
    public final boolean isSomenteTreinado;

    public Pericia(String nome, double graduacao, Atributo atributoChave, int modificadorRacial, Map<String, Integer> modificadorDiveso, String detalhe, boolean isPenalidadeArmadura, boolean isSomenteTreinado) {
        Nome = nome;
        Graduacao = graduacao;
        AtributoChave = atributoChave;
        ModificadorRacial = modificadorRacial;
        ModificadorDiveso = modificadorDiveso;
        Detalhe = detalhe;
        this.isPenalidadeArmadura = isPenalidadeArmadura;
        this.isSomenteTreinado = isSomenteTreinado;
    }

    public Pericia(Pericia other) {
        this.Nome = other.Nome;
        this.Graduacao = other.Graduacao;
        this.AtributoChave = other.AtributoChave;
        this.ModificadorRacial = other.ModificadorRacial;
        this.ModificadorDiveso = other.ModificadorDiveso;
        this.Detalhe = other.Detalhe;
        this.isPenalidadeArmadura = other.isPenalidadeArmadura;
        this.isSomenteTreinado = other.isSomenteTreinado;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.Nome);
        dest.writeDouble(this.Graduacao);
        dest.writeParcelable(this.AtributoChave, flags);
        dest.writeInt(this.ModificadorRacial);
        dest.writeInt(this.ModificadorDiveso.size());
        for (Map.Entry<String, Integer> entry : this.ModificadorDiveso.entrySet()) {
            dest.writeString(entry.getKey());
            dest.writeValue(entry.getValue());
        }
        dest.writeString(this.Detalhe);
        dest.writeByte(this.isPenalidadeArmadura ? (byte) 1 : (byte) 0);
        dest.writeByte(this.isSomenteTreinado ? (byte) 1 : (byte) 0);
    }

    protected Pericia(Parcel in) {
        this.Nome = in.readString();
        this.Graduacao = in.readDouble();
        this.AtributoChave = in.readParcelable(Atributo.class.getClassLoader());
        this.ModificadorRacial = in.readInt();
        int ModificadorDivesoSize = in.readInt();
        this.ModificadorDiveso = new HashMap<String, Integer>(ModificadorDivesoSize);
        for (int i = 0; i < ModificadorDivesoSize; i++) {
            String key = in.readString();
            Integer value = (Integer) in.readValue(Integer.class.getClassLoader());
            this.ModificadorDiveso.put(key, value);
        }
        this.Detalhe = in.readString();
        this.isPenalidadeArmadura = in.readByte() != 0;
        this.isSomenteTreinado = in.readByte() != 0;
    }

    public static final Parcelable.Creator<Pericia> CREATOR = new Parcelable.Creator<Pericia>() {
        @Override
        public Pericia createFromParcel(Parcel source) {
            return new Pericia(source);
        }

        @Override
        public Pericia[] newArray(int size) {
            return new Pericia[size];
        }
    };
}
