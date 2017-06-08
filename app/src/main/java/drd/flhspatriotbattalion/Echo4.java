package drd.flhspatriotbattalion;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Echo4 extends Fragment {

    public Echo4() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_platoon, container, false);
        final TextView content, title;
        final String platoonName = "Echo Fourth Platoon";
        content = (TextView) view.findViewById(R.id.Alpha1content);
        title =(TextView) view.findViewById(R.id.Title);
        title.setText(platoonName);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference().child("Echo").child("four").child("text");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue().toString();
                content.setText(text);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            content.setText(R.string.defaultText);
            }
        });
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("MyData", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        Switch s6;

        s6 = (Switch) view.findViewById(R.id.switch1);
        s6.setChecked( sharedPreferences.getString("E4","").equals("checked"));
        s6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String Checked = (isChecked)? "checked":"unchecked";
                editor.putString("E4", Checked);
                editor.apply();


                getActivity().stopService(new Intent(getActivity(), Notification.class));
                System.out.println("Service has been stopped");
                getActivity().startService(new Intent(getActivity(), Notification.class));

            }
        });
        Button report;
        report = (Button) view.findViewById(R.id.report);

        if (sharedPreferences.getString("A6", "").equals("true")){

            report.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    myRef.setValue("Sorry this Post has been taken down due inappropriate content");
                }
            });



        }else{

            report.setVisibility(View.GONE);


        }





        return view;
    }
}