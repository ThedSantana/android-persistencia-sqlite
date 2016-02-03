package br.com.heiderlopes.persistenciaandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.heiderlopes.persistenciaandroid.R;
import br.com.heiderlopes.persistenciaandroid.model.Game;

/**
 * Created by heiderlopes on 08/01/16.
 */
public class GamesAdapter extends BaseAdapter {

    private Context context;
    private List<Game> games;
    private LayoutInflater layoutInflater;

    public GamesAdapter(Context context, List<Game> games) {
        this.context = context;
        this.games = games;
        layoutInflater = (LayoutInflater) context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE
        );
    }

    @Override
    public int getCount() {
        return games.size();
    }

    @Override
    public Object getItem(int i) {
        return games.get(i);
    }

    @Override
    public long getItemId(int i) {
        return games.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        GameViewHolder holder;

        if(view == null) {
            holder = new GameViewHolder();
            view = layoutInflater.inflate(R.layout.item_game, viewGroup, false);
            holder.tvTitulo = (TextView) view.findViewById(R.id.tvTitulo);
            view.setTag(holder);
        } else {
            holder = (GameViewHolder) view.getTag();
        }
        holder.tvTitulo.setText(games.get(i).getTitulo());
        return view;
    }

    private class GameViewHolder {
        protected TextView tvTitulo;
    }
}
