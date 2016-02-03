package br.com.heiderlopes.persistenciaandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.com.heiderlopes.persistenciaandroid.dao.GameDAO;
import br.com.heiderlopes.persistenciaandroid.model.Game;

public class CadastrarActivity extends AppCompatActivity {

    private EditText etTitulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);
        etTitulo = (EditText)findViewById(R.id.etTitulo);
    }

    public void salvar(View v) {
        GameDAO dao = new GameDAO(this);
        Game game = new Game();
        game.setTitulo(etTitulo.getText().toString());
        Toast.makeText(this, dao.add(game), Toast.LENGTH_LONG).show();
        finish();
    }

}
