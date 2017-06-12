package drd.flhspatriotbattalion;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by derek on 10/20/2016.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private ArrayList<Announcements> dataSet;



    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView Title;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.Title = (TextView) itemView.findViewById(R.id.annoucementTitle);
        }


    }

    public CustomAdapter(ArrayList<Announcements> data) {
        this.dataSet = data;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        TextView Title = holder.Title;
        Title.setText(dataSet.get(position).getAnnoucemnets());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}