package com.vidroid.com.br.apps.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Set;

/**
 * Esta classe serve apenas para facilitar o processo de salvar e recuperar
 * informações através do SharedPreferences padrão da documentação e biblioteca
 * Android, poupando linhas de código.
 *
 * 2018,
 * Criado por Otavio Miguel - GitHub https://github.com/otaviomiguel19
 */

public class CustomSharedPreferences {

    private SharedPreferences sharedPreferences;
    public final static String ARQUIVO_PREFERENCIAS = "arquivoPreferencias";
    public final static int MODO_PREFERENCIAS_PRIVADO = 0;
    private SharedPreferences.Editor editor;

    public CustomSharedPreferences(Context context){
        sharedPreferences = context.getSharedPreferences(ARQUIVO_PREFERENCIAS, MODO_PREFERENCIAS_PRIVADO);
        editor = sharedPreferences.edit();
    }

    public void salvarString(String chave, String texto){
        editor.putString(chave, texto);
        editor.apply();
    }
    public void salvarBoolean(String chave, Boolean bool){
        editor.putBoolean(chave, bool);
        editor.apply();
    }

    public void salvarInt(String chave, int valor){
        editor.putInt(chave, valor);
        editor.apply();
    }

    public void salvarFloat(String chave, float valor){
        editor.putFloat(chave, valor);
        editor.apply();
    }

    public void salvarLong(String chave, long valor){
        editor.putLong(chave, valor);
        editor.apply();
    }

    public void salvarStringSet(String chave, Set<String> stringset){
        editor.putStringSet(chave, stringset);
        editor.apply();
    }

    public String recuperarString(String chave){
        if(sharedPreferences.contains(chave)){
            return sharedPreferences.getString(chave, "");
        }else{
            return "";
        }
    }
    public int recuperarInt(String chave){
        if(sharedPreferences.contains(chave)){
            return sharedPreferences.getInt(chave, -1);
        }else{
            return -1;
        }
    }
    public float recuperarFloat(String chave){
        if(sharedPreferences.contains(chave)){
            return sharedPreferences.getFloat(chave, -1);
        }else{
            return -1;
        }
    }
    public long recuperarLong(String chave){
        if(sharedPreferences.contains(chave)){
            return sharedPreferences.getLong(chave, -1);
        }else{
            return -1;
        }
    }
    public Boolean recuperarBoolean(String chave){
        if(sharedPreferences.contains(chave)){
            return sharedPreferences.getBoolean(chave, false);
        }else{
            return false;
        }
    }
    public Set<String> recuperarStringSet(String chave){
        if(sharedPreferences.contains(chave)){
            return sharedPreferences.getStringSet(chave, null);
        }else{
            return null;
        }
    }

}
