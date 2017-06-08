package drd.flhspatriotbattalion;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
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
public class AlphaFragment extends Fragment {


    public AlphaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      View view = inflater.inflate(R.layout.fragment_platoonpicker, container, false);
        Button a1, a2;
        TextView motto;

        motto = (TextView) view.findViewById(R.id.Motto);
        motto.setText(R.string.AlphaMotto);
        FragmentManager fragmentManager =  getFragmentManager();

        TextView title;
        title = (TextView)view.findViewById(R.id.CompanyTitle);
        title.setText("Alpha");
        ImageView logo;
        logo = (ImageView)view.findViewById(R.id.CompanyLogo);

        String uri = "@drawable/alpha";
        int imageResource = getResources().getIdentifier(uri, null,getActivity().getPackageName());
        Drawable res = getResources().getDrawable(imageResource);
        int size = title.getHeight();
        logo.setMaxHeight(size);
        logo.setImageDrawable(res);


        ((AppCompatActivity)getActivity()).getSupportActionBar().setSubtitle("Alpha");
        TextView COC;
        COC = (TextView) view.findViewById(R.id.COC);
        COC.setText(R.string.AlphaChain);

        a1 = (Button) view.findViewById(R.id.B1button);
        a2 = (Button) view.findViewById(R.id.B2button);
        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Alpha1 alpha1 = new Alpha1();
                FragmentManager fragmentManager =  getFragmentManager();//use getfragmentmanger() for changing fragments withen fragments. Matrix? I know right!
                fragmentManager.beginTransaction().replace(R.id.Relative_Layout_For_Fragments,
                        alpha1,
                        alpha1.getTag()).addToBackStack(alpha1.getTag()).commit();
            }
        });
        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Alpha2 alpha2 = new Alpha2();
                FragmentManager fragmentManager =  getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.Relative_Layout_For_Fragments,
                        alpha2,
                        alpha2.getTag()).addToBackStack(alpha2.getTag()).commit();
            }
        });
        Button a3,a4,a5;
        a3 = (Button) view.findViewById(R.id.B3button);
        a4 = (Button) view.findViewById(R.id.B4button);
        a5 = (Button) view.findViewById(R.id.B5button);
        a3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Alpha3 alpha3 = new Alpha3();
                FragmentManager fragmentManager =  getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.Relative_Layout_For_Fragments,
                        alpha3,
                        alpha3.getTag()).addToBackStack(alpha3.getTag()).commit();
            }
        });
        a4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Alpha4 alpha4 = new Alpha4();
                FragmentManager fragmentManager =  getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.Relative_Layout_For_Fragments,
                        alpha4,
                        alpha4.getTag()).addToBackStack(alpha4.getTag()).commit();
            }
        });
        /*
        a5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Alpha5 alpha5 = new Alpha5();
                FragmentManager fragmentManager =  getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.Relative_Layout_For_Fragments,
                        alpha5,
                        alpha5.getTag()).commit();
            }
        });
        */ //delete comment to have a fivith platoon
        a5.setEnabled(false);//commit this out to have a fifth platoon
        a5.setVisibility(View.GONE);















        return view;

    }

}
