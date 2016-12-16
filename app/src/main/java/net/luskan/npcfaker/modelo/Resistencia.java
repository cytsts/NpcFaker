package net.luskan.npcfaker.modelo;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.StringDef;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Clayton on 15/12/2016.
 */

public class Resistencia implements Parcelable {
    @StringDef({FORTITUDE, REFLEXO, VONTADE, MAGICA})
    public @interface TipoResistencia {}

    public static final String FORTITUDE = "FORTITUDE";
    public static final String REFLEXO   = "REFLEXO";
    public static final String VONTADE   = "VONTADE";
    public static final String MAGICA    = "MAGICA";

    @TipoResistencia
    public final String Nome;
    public final Atributo AtributoBase;
    public final int ModificadorClasse;
    public final Map<String, Integer> ModificadorDiverso;

    public Resistencia(@TipoResistencia String nome, Atributo atributoBase, int modificadorClasse, Map<String, Integer> modificadorDiverso) {
        Nome = nome;
        AtributoBase = atributoBase;
        ModificadorClasse = modificadorClasse;
        ModificadorDiverso = modificadorDiverso;
    }

    public Resistencia(Resistencia other) {
        this.Nome = other.Nome;
        this.AtributoBase = other.AtributoBase;
        this.ModificadorClasse = other.ModificadorClasse;
        this.ModificadorDiverso = other.ModificadorDiverso;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.Nome);
        dest.writeParcelable(this.AtributoBase, flags);
        dest.writeInt(this.ModificadorClasse);
        dest.writeInt(this.ModificadorDiverso.size());
        for (Map.Entry<String, Integer> entry : this.ModificadorDiverso.entrySet()) {
            dest.writeString(entry.getKey());
            dest.writeValue(entry.getValue());
        }
    }

    protected Resistencia(Parcel in) {
        this.Nome = parseTipoResistencia(in.readString());
        this.AtributoBase = in.readParcelable(Atributo.class.getClassLoader());
        this.ModificadorClasse = in.readInt();
        int ModificadorDiversoSize = in.readInt();
        this.ModificadorDiverso = new HashMap<String, Integer>(ModificadorDiversoSize);
        for (int i = 0; i < ModificadorDiversoSize; i++) {
            String key = in.readString();
            Integer value = (Integer) in.readValue(Integer.class.getClassLoader());
            this.ModificadorDiverso.put(key, value);
        }
    }

    private @TipoResistencia String parseTipoResistencia(String s) {
        switch (s.toUpperCase()){
            case FORTITUDE: return FORTITUDE;
            case REFLEXO:   return REFLEXO;
            case VONTADE:   return VONTADE;
            case MAGICA:    return MAGICA;
            default:  return FORTITUDE;
        }
    }

    public static final Parcelable.Creator<Resistencia> CREATOR = new Parcelable.Creator<Resistencia>() {
        @Override
        public Resistencia createFromParcel(Parcel source) {
            return new Resistencia(source);
        }

        @Override
        public Resistencia[] newArray(int size) {
            return new Resistencia[size];
        }
    };
}
