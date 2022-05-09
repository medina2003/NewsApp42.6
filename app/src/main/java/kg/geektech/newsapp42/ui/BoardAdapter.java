package kg.geektech.newsapp42.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import kg.geektech.newsapp42.R;

public class BoardAdapter extends RecyclerView.Adapter<BoardAdapter.BoardHolder> {
    private  String[] titles = new String[]{"Кыргызстан","Корея","Китай","Кыргызстан"};

    @NonNull
    @Override
    public BoardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.pager_board,parent,false);
        return new BoardHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BoardHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }

    public class BoardHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private Button buttonStart;
        public BoardHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textTitle);
            buttonStart = itemView.findViewById(R.id.buttonStart);
        }

        public void bind(int position) {
            textView.setText(titles[position]);
            if (position==titles.length - 1)buttonStart.setVisibility(View.VISIBLE);
            else buttonStart.setVisibility(View.INVISIBLE);
        }
    }
}
