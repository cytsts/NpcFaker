package net.luskan.npcfaker.modelo;

import android.os.Parcel;
import android.os.Parcelable;

import org.greenrobot.greendao.annotation.NotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Clayton on 15/12/2016.
 */

public class Talento implements Parcelable {
    public Talento(Talento other) {
        this.Nome = other.Nome;
        this.Detalhe = other.Detalhe;
        this.Requisitos = other.Requisitos;
        this.Beneficios = other.Beneficios;
    }

    public Talento(String nome, String detalhe, Map<String, IRequisitos> requisitos, Map<String, IBeneficios> beneficios) {

        Nome = nome;
        Detalhe = detalhe;
        Requisitos = requisitos;
        Beneficios = beneficios;
    }

    public String Nome;
    public String Detalhe;
    public Map<String, IRequisitos> Requisitos;
    public Map<String, IBeneficios> Beneficios;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.Nome);
        dest.writeString(this.Detalhe);
        dest.writeInt(this.Requisitos.size());
        for (Map.Entry<String, IRequisitos> entry : this.Requisitos.entrySet()) {
            dest.writeString(entry.getKey());
            dest.writeParcelable(entry.getValue(), flags);
        }
        dest.writeInt(this.Beneficios.size());
        for (Map.Entry<String, IBeneficios> entry : this.Beneficios.entrySet()) {
            dest.writeString(entry.getKey());
            dest.writeParcelable(entry.getValue(), flags);
        }
    }

    protected Talento(Parcel in) {
        this.Nome = in.readString();
        this.Detalhe = in.readString();
        int RequisitosSize = in.readInt();
        this.Requisitos = new HashMap<String, IRequisitos>(RequisitosSize);
        for (int i = 0; i < RequisitosSize; i++) {
            String key = in.readString();
            IRequisitos value = in.readParcelable(IRequisitos.class.getClassLoader());
            this.Requisitos.put(key, value);
        }
        int BeneficiosSize = in.readInt();
        this.Beneficios = new HashMap<String, IBeneficios>(BeneficiosSize);
        for (int i = 0; i < BeneficiosSize; i++) {
            String key = in.readString();
            IBeneficios value = in.readParcelable(IBeneficios.class.getClassLoader());
            this.Beneficios.put(key, value);
        }
    }

    public static final Parcelable.Creator<Talento> CREATOR = new Parcelable.Creator<Talento>() {
        @Override
        public Talento createFromParcel(Parcel source) {
            return new Talento(source);
        }

        @Override
        public Talento[] newArray(int size) {
            return new Talento[size];
        }
    };
}
