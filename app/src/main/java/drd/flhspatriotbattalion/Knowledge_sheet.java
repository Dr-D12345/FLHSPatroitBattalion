package drd.flhspatriotbattalion;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import drd.flhspatriotbattalion.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Knowledge_sheet extends Fragment {


    public Knowledge_sheet() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_knowledge_sheet, container, false);


        ((AppCompatActivity)getActivity()).getSupportActionBar().setSubtitle("Knowledge");













        return view;
    }

}
