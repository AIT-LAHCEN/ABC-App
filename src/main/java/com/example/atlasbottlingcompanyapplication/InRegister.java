package com.example.atlasbottlingcompanyapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class InRegister extends Activity {
    EditText ET_FULL_NAMES,ET_CPA_IDS,ET_TRANS_IDS;
    String nom_d,nom_complet,nom_trajet,cpa,etat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.people_popw);
        ET_FULL_NAMES = findViewById(R.id.names);
        ET_CPA_IDS = findViewById(R.id.cpaidps);
        ET_TRANS_IDS = findViewById(R.id.transids);
    }

    public void fullnamePS(View view){
        nom_d = ET_FULL_NAMES.getText().toString();
        nom_complet = ET_CPA_IDS.getText().toString();
        nom_trajet = ET_TRANS_IDS.getText().toString();
        cpa=MainActivity.coordonnes();
        etat = "sortant";
        String method = "inregister";
        BackgroundTask2 backgroundTask = new BackgroundTask2(this);
        backgroundTask.execute(method,nom_d,nom_complet,nom_trajet,cpa,etat);
        finish();
    }
}

