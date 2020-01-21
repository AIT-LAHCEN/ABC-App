package com.example.atlasbottlingcompanyapplication;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class BackgroundTask extends AsyncTask<String, Void, String> {
    Context ctx;
    String reg_url;

    BackgroundTask(Context ctx) {
        this.ctx = ctx;
    }

    /* Access modifiers changed, original: protected */
    public void onPreExecute() {
        this.reg_url = "http://192.168.71.103/abctrans/register.php";
    }

    /* Access modifiers changed, original: protected|varargs */
    public void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    /* Access modifiers changed, original: protected|varargs */
    public String doInBackground(String... params) {
        String str = "&";
        String str2 = "=";
        String str3 = "UTF-8";
        if (params[0].equals("register")) {
            String nom_d = params[1];
            String nom_complet = params[2];
            String nom_trajet = params[3];
            String cpa = params[4];
            String etat = params[5];
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.reg_url).openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, str3));
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(URLEncoder.encode("nom_d", str3));
                stringBuilder.append(str2);
                stringBuilder.append(URLEncoder.encode(nom_d, str3));
                stringBuilder.append(str);
                stringBuilder.append(URLEncoder.encode("nom_complet", str3));
                stringBuilder.append(str2);
                stringBuilder.append(URLEncoder.encode(nom_complet, str3));
                stringBuilder.append(str);
                stringBuilder.append(URLEncoder.encode("nom_trajet", str3));
                stringBuilder.append(str2);
                stringBuilder.append(URLEncoder.encode(nom_trajet, str3));
                stringBuilder.append(str);
                stringBuilder.append(URLEncoder.encode("cpa", str3));
                stringBuilder.append(str2);
                stringBuilder.append(URLEncoder.encode(cpa, str3));
                stringBuilder.append(str);
                stringBuilder.append(URLEncoder.encode("etat", str3));
                stringBuilder.append(str2);
                stringBuilder.append(URLEncoder.encode(etat, str3));
                bufferedWriter.write(stringBuilder.toString());
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
                httpURLConnection.getInputStream().close();
                httpURLConnection.disconnect();
                return "C'est Validé.....";
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    /* Access modifiers changed, original: protected */
    public void onPostExecute(String result) {
        Toast.makeText(ctx,result,Toast.LENGTH_LONG).show();
    }
}
