package com.example.atlasbottlingcompanyapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Register extends Activity {
    EditText ET_FULL_NAME,ET_CPA_ID,ET_TRANS_ID;
    String nom_d,nom_complet,nom_trajet,cpa,etat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.people_popupwindow);
        ET_FULL_NAME = findViewById(R.id.name);
        ET_CPA_ID = findViewById(R.id.cpaidp);
        ET_TRANS_ID = findViewById(R.id.transid);
    }

    public void fullnamePE(View view){
        nom_d = ET_FULL_NAME.getText().toString();
        nom_complet = ET_CPA_ID.getText().toString();
        nom_trajet = ET_TRANS_ID.getText().toString();
        cpa=MainActivity.coordonnes();
        etat = "entrant";
        String method = "register";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method,nom_d,nom_complet,nom_trajet,cpa,etat);
        finish();
    }
}
