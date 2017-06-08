package drd.flhspatriotbattalion;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import drd.flhspatriotbattalion.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BravoFragment extends Fragment {


    public BravoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_platoonpicker, container, false);
        Button a1, a2;
        TextView motto;
        motto = (TextView) view.findViewById(R.id.Motto);
        motto.setText(R.string.BravoMotto);
        TextView COC;
        COC = (TextView) view.findViewById(R.id.COC);

        TextView title;
        title = (TextView)view.findViewById(R.id.CompanyTitle);
        title.setText("Bravo");
        ImageView logo;
        logo = (ImageView)view.findViewById(R.id.CompanyLogo);


        String uri = "@drawable/bravo";
        int imageResource = getResources().getIdentifier(uri, null,getActivity().getPackageName());
        Drawable res = getResources().getDrawable(imageResource);
        logo.setImageDrawable(res);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setSubtitle("Bravo");
        COC.setText(R.string.BravoChain);
        a1 = (Button) view.findViewById(R.id.B1button);
        a2 = (Button) view.findViewById(R.id.B2button);
        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bravo1 bravo1 = new Bravo1();
                FragmentManager fragmentManager =  getFragmentManager();//use getfragmentmanger() for changing fragments withen fragments. Matrix? I know right!
                fragmentManager.beginTransaction().replace(R.id.Relative_Layout_For_Fragments,
                        bravo1,
                        bravo1.getTag()).addToBackStack(bravo1.getTag()).commit();
            }
        });
        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bravo2 bravo2  = new Bravo2();
                FragmentManager fragmentManager =  getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.Relative_Layout_For_Fragments,
                        bravo2,
                        bravo2.getTag()).addToBackStack(bravo2.getTag()).commit();
            }
        });

        Button a3,a4,a5;
        a3 = (Button) view.findViewById(R.id.B3button);
        a4 = (Button) view.findViewById(R.id.B4button);
        a5 = (Button) view.findViewById(R.id.B5button);
        a3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Bravo3 bravo3 = new Bravo3();
                FragmentManager fragmentManager =  getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.Relative_Layout_For_Fragments,
                       bravo3,
                        bravo3.getTag()).addToBackStack(bravo3.getTag()).commit();
            }
        });
        a4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Bravo4 bravo4 = new Bravo4();
                FragmentManager fragmentManager =  getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.Relative_Layout_For_Fragments,
                        bravo4,
                        bravo4.getTag()).addToBackStack(bravo4.getTag()).commit();
            }
        });
        /*
        a5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Bravo5 bravo5 = new bravo5();
                FragmentManager fragmentManager =  getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.Relative_Layout_For_Fragments,
                        bravo5,
                        bravo5.getTag()).addToBackStack(bravo5.getTag()).commit();
            }
        });
        */ //delete comment to have a fivith platoon
        a5.setEnabled(false);//commit this out to have a fifth platoon
        a5.setVisibility(View.GONE);



















        return view;
    }

}
