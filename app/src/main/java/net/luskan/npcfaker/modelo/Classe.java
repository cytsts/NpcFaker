package net.luskan.npcfaker.modelo;

import android.support.annotation.StringDef;

/**
 * Created by Clayton on 15/12/2016.
 */

public class Classe {
    @StringDef({BARBARO, BARDO, CLERIGO, DRUIDA, FEITICEIRO, GUERREIRO, LADINO, MAGO, MAONGE, PALADINO, RANGER})
    public @interface ClasseBasica {}

    public static final String BARBARO    = "BARBARO";
    public static final String BARDO      = "BARDO";
    public static final String CLERIGO    = "CLERIGO";
    public static final String DRUIDA     = "DRUIDA";
    public static final String FEITICEIRO = "FEITICEIRO";
    public static final String GUERREIRO  = "GUERREIRO";
    public static final String LADINO     = "LADINO";
    public static final String MAGO       = "MAGO";
    public static final String MAONGE     = "MAONGE";
    public static final String PALADINO   = "PALADINO";
    public static final String RANGER     = "RANGER";



}
