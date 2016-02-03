package br.com.heiderlopes.persistenciaandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import br.com.heiderlopes.persistenciaandroid.adapter.GamesAdapter;
import br.com.heiderlopes.persistenciaandroid.dao.GameDAO;

public class ListaGamesActivity extends AppCompatActivity {

    private ListView lvGames;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_games);

        lvGames = (ListView)findViewById(R.id.lvGames);
        GameDAO dao = new GameDAO(this);
        lvGames.setAdapter(new GamesAdapter(this, dao.getAll()));
    }
}
