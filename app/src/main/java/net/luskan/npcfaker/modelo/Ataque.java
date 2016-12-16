package net.luskan.npcfaker.modelo;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.IntDef;



/**
 * Created by Clayton on 15/12/2016.
 */

public class Ataque implements Parcelable {

    @IntDef({BASICO, CONCUSSAO, PERFURANTE, CORTANTE, MAGICO, FRIO, FOGO, ACIDO, SONICO, NECROTICO, AMAMANTE, SAGRADO})
    public @interface TipoDano {}

    public static final int BASICO = 2;
    public static final int CONCUSSAO= 5;
    public static final int PERFURANTE= 7;
    public static final int CORTANTE= 11;
    public static final int MAGICO= 13;
    public static final int FRIO= 17;
    public static final int FOGO= 19;
    public static final int ACIDO= 23;
    public static final int SONICO= 29;
    public static final int NECROTICO= 31;
    public static final int AMAMANTE = 37;
    public static final int SAGRADO = 41;



    public final String Nome;
    public final Atributo AtributoChave;
    public final double Distancia;
    public final int ModificadorBase;
    public final int Municao;


    private int tipoDano = BASICO;

    public int AddTipoDano(@TipoDano int TipoDano){
        tipoDano *= TipoDano;
        return tipoDano;
    }

    public boolean isTipoDanoValido(){
        return verificaTipoDano(BASICO, tipoDano);
    }


    public boolean isCONCUSSAO(){
        return verificaTipoDano(CONCUSSAO,  tipoDano);
    }

    public boolean isPERFURANTE(){
        return verificaTipoDano(PERFURANTE,  tipoDano);
    }
    public boolean isCORTANTE(){
        return verificaTipoDano(CORTANTE,  tipoDano);
    }
    public boolean isMAGICO(){
        return verificaTipoDano(MAGICO,  tipoDano);
    }
    public boolean isFRIO(){
        return verificaTipoDano(FRIO,  tipoDano);
    }
    public boolean isFOGO(){
        return verificaTipoDano(FOGO,  tipoDano);
    }
    public boolean isACIDO(){
        return verificaTipoDano(ACIDO,  tipoDano);
    }
    public boolean isSONICO(){
        return verificaTipoDano(SONICO,  tipoDano);
    }
    public boolean isNECROTICO(){
        return verificaTipoDano(NECROTICO,  tipoDano);
    }
    public boolean isAMAMANTE(){
        return verificaTipoDano(AMAMANTE,  tipoDano);
    }
    public boolean isSAGRADO(){
        return verificaTipoDano(SAGRADO,  tipoDano);
    }



    private boolean verificaTipoDano(@TipoDano int concussao, int tipoDano) {
        return (tipoDano % concussao == 0);
    }

    public Ataque(String nome, Atributo atributoChave, double distancia, int modificadorBase, int municao) {
        Nome = nome;
        AtributoChave = atributoChave;
        Distancia = distancia;
        ModificadorBase = modificadorBase;
        Municao = municao;
    }

    public Ataque(Ataque other) {
        this.Nome = other.Nome;
        this.AtributoChave = other.AtributoChave;
        this.Distancia = other.Distancia;
        this.ModificadorBase = other.ModificadorBase;
        this.tipoDano = other.tipoDano;
        this.Municao = other.Municao;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.Nome);
        dest.writeParcelable(this.AtributoChave, flags);
        dest.writeDouble(this.Distancia);
        dest.writeInt(this.ModificadorBase);
        dest.writeInt(this.Municao);
        dest.writeInt(this.tipoDano);
    }

    protected Ataque(Parcel in) {
        this.Nome = in.readString();
        this.AtributoChave = in.readParcelable(Atributo.class.getClassLoader());
        this.Distancia = in.readDouble();
        this.ModificadorBase = in.readInt();
        this.Municao = in.readInt();
        this.tipoDano = in.readInt();
    }

    public static final Creator<Ataque> CREATOR = new Creator<Ataque>() {
        @Override
        public Ataque createFromParcel(Parcel source) {
            return new Ataque(source);
        }

        @Override
        public Ataque[] newArray(int size) {
            return new Ataque[size];
        }
    };
}
