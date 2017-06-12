package drd.flhspatriotbattalion;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class CentralFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static RecyclerView.Adapter adapter;
    private FirebaseListAdapter<Announcements> mAdapter;
    private RecyclerView recyclerView;
    public CentralFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_central, container, false);
        if(container != null){


            container.removeAllViews();
        }
        // Inflate the layout for this fragment
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference wotdRef = database.getReference("WOTD");
        FragmentManager mFragmentManager = getFragmentManager();
        mFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);

        ((AppCompatActivity)getActivity()).getSupportActionBar().setSubtitle("Home");
        final TextView WOTD;
        final FloatingActionButton FAB;

        WOTD = (TextView) view.findViewById(R.id.wotd);


        wotdRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String wordoftheday = dataSnapshot.getValue(String.class);
               int a = wordoftheday.indexOf("Used");

                wordoftheday = wordoftheday.substring(0,a-1) + "\n"+wordoftheday.substring(a, wordoftheday.length());
                SpannableString content = new SpannableString(wordoftheday);
                content.setSpan(new UnderlineSpan(), a, a+18, 0);

                WOTD.setText(content);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        recyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        DatabaseReference cardRef = database.getReference().child("main");
        cardRef.keepSynced(true);
        FirebaseRecyclerAdapter<Announcements, myViewHolader> adapter = new FirebaseRecyclerAdapter<Announcements, myViewHolader>(Announcements.class, R.layout.cardview, myViewHolader.class, cardRef) {
            @Override
            protected void populateViewHolder(myViewHolader viewHolder, Announcements model, int position) {
                viewHolder.myTextView.setText(model.getAnnoucemnets());
            }
        };
        recyclerView.setAdapter(adapter);

        FAB = (FloatingActionButton) view.findViewById(R.id.fab);
        FAB.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        FAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Create_Fragment create_fragment = new Create_Fragment();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.Relative_Layout_For_Fragments,
                        create_fragment,
                        create_fragment.getTag()).addToBackStack(create_fragment.getTag()).commit();
            }
        });
        return view;
    }
    public static class myViewHolader extends RecyclerView.ViewHolder {
        public TextView myTextView;
        public myViewHolader(View itemView) {

            super(itemView);
            myTextView = (TextView) itemView.findViewById(R.id.annoucementTitle);
            this.myTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int height = (myTextView.getLineCount() * myTextView.getLineHeight()) + myTextView.getPaddingTop() + myTextView.getPaddingBottom();
                    if (myTextView.getHeight() == height) {
                        myTextView.setLines(1);
                    } else {
                        myTextView.setHeight(height);
                    }
                }
            });
        }
    }
}