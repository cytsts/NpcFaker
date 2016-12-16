package net.luskan.mvp;

import android.os.Bundle;

/**
 * Created by Clayton on 13/12/2016.
 */

public interface CicloDeVida {
    void onCreate(Bundle extra);
    void onDestroy();
    void onSave(Bundle extra);
}
