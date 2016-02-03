package br.com.heiderlopes.persistenciaandroid.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.LinkedList;
import java.util.List;

import br.com.heiderlopes.persistenciaandroid.model.Game;

/**
 * Created by heiderlopes on 08/01/16.
 */
public class GameDAO {

    private SQLiteDatabase db;
    private SQLiteHelper banco;

    public GameDAO(Context context) {
        banco = new SQLiteHelper(context);
    }

    private static final String TABLE_GAMES = "games";

    private static final String KEY_ID = "id";
    private static final String KEY_TITULO = "titulo";

    private static final String[] COLUMNS = {KEY_ID, KEY_TITULO};

    public String add(Game game){
        long resultado;
        SQLiteDatabase db = banco.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_TITULO, game.getTitulo());
        resultado = db.insert(TABLE_GAMES,
                null,
                values);
        db.close();

        if(resultado == -1) {
            return "Erro ao inserir registro";
        } else {
            return "Registro inserido com sucesso";
        }
    }

    public List<Game> getAll() {
        List<Game> games = new LinkedList<>();

        String query = "SELECT  * FROM " + TABLE_GAMES;

        SQLiteDatabase db = banco.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        Game game = null;
        if (cursor.moveToFirst()) {
            do {
                game = new Game();
                game.setId(Integer.parseInt(cursor.getString(0)));
                game.setTitulo(cursor.getString(1));

                games.add(game);
            } while (cursor.moveToNext());
        }
        return games;
    }


}
