package drd.flhspatriotbattalion;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.StringDef;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class DeltaFragment extends Fragment {


    public DeltaFragment() {
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
        motto.setText(R.string.DeltaMotto);
        TextView COC;
        COC = (TextView) view.findViewById(R.id.COC);
        COC.setText(R.string.DeltaChain);
        a1 = (Button) view.findViewById(R.id.B1button);
        a2 = (Button) view.findViewById(R.id.B2button);
        TextView title;
        title = (TextView)view.findViewById(R.id.CompanyTitle);
        title.setText("Delta");
        ImageView logo;
        logo = (ImageView)view.findViewById(R.id.CompanyLogo);

        String uri = "@drawable/delta";
        int imageResource = getResources().getIdentifier(uri, null,getActivity().getPackageName());
        Drawable res = getResources().getDrawable(imageResource);
        int size = title.getHeight();
        logo.setMaxHeight(size);
        logo.setImageDrawable(res);

        ((AppCompatActivity)getActivity()).getSupportActionBar().setSubtitle("Delta");
        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Delta1 delta1 = new Delta1();
                FragmentManager fragmentManager =  getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.Relative_Layout_For_Fragments,
                        delta1,
                        delta1.getTag()).addToBackStack(delta1.getTag()).commit();
            }
        });
        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Delta2 delta2 = new Delta2();
                FragmentManager fragmentManager =  getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.Relative_Layout_For_Fragments,
                        delta2,
                        delta2.getTag()).addToBackStack(delta2.getTag()).commit();
            }
        });


        Button a3,a4,a5;
        a3 = (Button) view.findViewById(R.id.B3button);
        a4 = (Button) view.findViewById(R.id.B4button);
        a5 = (Button) view.findViewById(R.id.B5button);
        a3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Delta3 delta3= new Delta3();
                FragmentManager fragmentManager =  getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.Relative_Layout_For_Fragments,
                        delta3,
                        delta3.getTag()).addToBackStack(delta3.getTag()).commit();
            }
        });
        a4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Delta4 delta4 = new Delta4();
                FragmentManager fragmentManager =  getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.Relative_Layout_For_Fragments,
                        delta4,
                        delta4.getTag()).addToBackStack(delta4.getTag()).commit();
            }
        });
        /*
        a5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Delta5 delta5  = new Delta5();
                FragmentManager fragmentManager =  getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.Relative_Layout_For_Fragments,
                       delta5,
                        delta5.getTag()).addToBackStack(delta5.getTag()).commit();
            }
        });
        */ //delete comment to have a fivith platoon
        a5.setEnabled(false);//commit this out to have a fifth platoon
        a5.setVisibility(View.GONE);


















        return view;
    }

}
