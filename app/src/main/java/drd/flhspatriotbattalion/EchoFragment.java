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

import static drd.flhspatriotbattalion.R.id.Echo;

/**
 * A simple {@link Fragment} subclass.
 */
public class EchoFragment extends Fragment {


    public EchoFragment() {
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
        motto.setText(R.string.EchoMotto);
        TextView COC;
        COC = (TextView) view.findViewById(R.id.COC);
        COC.setText(R.string.EchoChain);
        a1 = (Button) view.findViewById(R.id.B1button);
        a2 = (Button) view.findViewById(R.id.B2button);
        TextView title;
        title = (TextView)view.findViewById(R.id.CompanyTitle);
        title.setText("Echo");
        ImageView logo;
        logo = (ImageView)view.findViewById(R.id.CompanyLogo);

        String uri = "@drawable/echo";
        int imageResource = getResources().getIdentifier(uri, null,getActivity().getPackageName());
        Drawable res = getResources().getDrawable(imageResource);
        int size = title.getHeight();
        logo.setMaxHeight(size);
        logo.setImageDrawable(res);

        ((AppCompatActivity)getActivity()).getSupportActionBar().setSubtitle("Echo");
        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Echo1 echo1 = new Echo1();
                FragmentManager fragmentManager =  getFragmentManager();//use getfragmentmanger() for changing fragments withen fragments. Matrix? I know right!
                fragmentManager.beginTransaction().replace(R.id.Relative_Layout_For_Fragments,
                        echo1,
                        echo1.getTag()).addToBackStack(echo1.getTag()).commit();

            }
        });
        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Echo2 echo2 = new Echo2();
                FragmentManager fragmentManager =  getFragmentManager();//use getfragmentmanger() for changing fragments withen fragments. Matrix? I know right!
                fragmentManager.beginTransaction().replace(R.id.Relative_Layout_For_Fragments,
                        echo2,
                        echo2.getTag()).addToBackStack(echo2.getTag()).commit();
            }
        });

        Button a3,a4,a5;
        a3 = (Button) view.findViewById(R.id.B3button);
        a4 = (Button) view.findViewById(R.id.B4button);
        a5 = (Button) view.findViewById(R.id.B5button);
        a3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Echo3 echo3 =new Echo3();
                FragmentManager fragmentManager =  getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.Relative_Layout_For_Fragments,
                         echo3,
                       echo3.getTag()).addToBackStack(echo3.getTag()).commit();
            }
        });
        a4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Echo4 echo4 = new Echo4();
                FragmentManager fragmentManager =  getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.Relative_Layout_For_Fragments,
                        echo4,
                       echo4.getTag()).addToBackStack(echo4.getTag()).commit();
            }
        });
        /*
        a5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Echo5 echo5= new Echo5();
                FragmentManager fragmentManager =  getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.Relative_Layout_For_Fragments,
                        echo5,
                        echo5.getTag()).addToBackStack(echo5.getTag()).commit();
            }
        });
        */ //delete comment to have a fivith platoon
        a5.setEnabled(false);//commit this out to have a fifth platoon
        a5.setVisibility(View.GONE);



















        return view;
    }

}
