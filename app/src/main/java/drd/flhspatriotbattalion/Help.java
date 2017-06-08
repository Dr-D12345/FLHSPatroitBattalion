package drd.flhspatriotbattalion;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessaging;


public class Help extends Fragment {
    Switch s1,s2,s3,s4,s5;

    public Help() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_help, container, false);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setSubtitle("Help and Options");

        boolean s1Checked, s2Checked,s3Checked, s4Checked, s5Checked;
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("MyData", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        s1 = (Switch) view.findViewById(R.id.switch1);
        s2 = (Switch) view.findViewById(R.id.switch2);
        s3 = (Switch) view.findViewById(R.id.switch3);
        s4 = (Switch) view.findViewById(R.id.switch4);
        s5 = (Switch) view.findViewById(R.id.switch5);
        s1Checked = sharedPreferences.getString("s1","").equals("checked");
        s2Checked = sharedPreferences.getString("s2","").equals("checked");
        s3Checked = sharedPreferences.getString("s3","").equals("checked");
        s4Checked = sharedPreferences.getString("s4","").equals("checked");
        s5Checked = sharedPreferences.getString("s5","").equals("checked");
        s1.setChecked(s1Checked);
        s2.setChecked(s2Checked);
        s3.setChecked(s3Checked);
        s4.setChecked(s4Checked);
        s5.setChecked(s5Checked);
        if (s1Checked){
            FirebaseMessaging.getInstance().subscribeToTopic("Parade");
        }else{
            FirebaseMessaging.getInstance().unsubscribeFromTopic("Parade");
        }
        if (s2Checked){
            FirebaseMessaging.getInstance().subscribeToTopic("DrillTeam");
        }else{
            FirebaseMessaging.getInstance().unsubscribeFromTopic("DrillTeam");
        }
        if (s3Checked){
            FirebaseMessaging.getInstance().subscribeToTopic("DrumCorps");
        }else{
            FirebaseMessaging.getInstance().unsubscribeFromTopic("DrumCorps");
        }
        if (s4Checked){
            FirebaseMessaging.getInstance().subscribeToTopic("HonorGuard");
        }else{
            FirebaseMessaging.getInstance().unsubscribeFromTopic("HonorGuard");
        }
        if (s5Checked){
            FirebaseMessaging.getInstance().subscribeToTopic("Raiders");
        }else{
            FirebaseMessaging.getInstance().unsubscribeFromTopic("Raiders");
        }
            s1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               String Checked = (isChecked)? "checked":"unchecked";

                editor.putString("s1", Checked);
                editor.apply();
            }
        });

        s2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String Checked = (isChecked)? "checked":"unchecked";

                editor.putString("s2", Checked);
                editor.apply();
            }
        });
        s3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String Checked = (isChecked)? "checked":"unchecked";
                editor.putString("s3", Checked);
                editor.apply();
            }
        });
        s4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String Checked = (isChecked)? "checked":"unchecked";
                editor.putString("s4", Checked);
                editor.apply();
            }
        });

        s5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String Checked = (isChecked)? "checked":"unchecked";
                editor.putString("s5", Checked);
                editor.apply();
            }
        });









        return  view;
    }



}