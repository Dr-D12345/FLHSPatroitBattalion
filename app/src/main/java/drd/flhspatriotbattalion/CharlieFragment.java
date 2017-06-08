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

/**
 * A simple {@link Fragment} subclass.
 */
public class CharlieFragment extends Fragment {


    public CharlieFragment() {
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
        motto.setText(R.string.CharlieMotto);
        TextView COC;
        COC = (TextView) view.findViewById(R.id.COC);
        COC.setText(R.string.CharlieChain);
        a1 = (Button) view.findViewById(R.id.B1button);
        a2 = (Button) view.findViewById(R.id.B2button);
        TextView title;
        title = (TextView)view.findViewById(R.id.CompanyTitle);
        title.setText("Charlie");
        ImageView logo;
        logo = (ImageView)view.findViewById(R.id.CompanyLogo);

        String uri = "@drawable/charlie";
        int imageResource = getResources().getIdentifier(uri, null,getActivity().getPackageName());
        Drawable res = getResources().getDrawable(imageResource);
        int size = title.getHeight();
        logo.setMaxHeight(size);
        logo.setImageDrawable(res);

        ((AppCompatActivity)getActivity()).getSupportActionBar().setSubtitle("Charlie");
        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Charlie1 charlie1 = new Charlie1();
                FragmentManager fragmentManager =  getFragmentManager();//use getfragmentmanger() for changing fragments withen fragments. Matrix? I know right!
                fragmentManager.beginTransaction().replace(R.id.Relative_Layout_For_Fragments,
                       charlie1,
                        charlie1.getTag()).addToBackStack(charlie1.getTag()).commit();
            }
        });
        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Charlie2 charlie2  = new Charlie2();
                FragmentManager fragmentManager =  getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.Relative_Layout_For_Fragments,
                       charlie2,
                        charlie2.getTag()).addToBackStack(charlie2.getTag()).commit();
            }
        });
        Button a3,a4,a5;
        a3 = (Button) view.findViewById(R.id.B3button);
        a4 = (Button) view.findViewById(R.id.B4button);
        a5 = (Button) view.findViewById(R.id.B5button);
        a3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Charlie3 charlie3 = new Charlie3();
                FragmentManager fragmentManager =  getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.Relative_Layout_For_Fragments,
                        charlie3,
                       charlie3.getTag()).addToBackStack(charlie3.getTag()).commit();
            }
        });
        a4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Charlie4 charlie4 = new Charlie4();
                FragmentManager fragmentManager =  getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.Relative_Layout_For_Fragments,
                        charlie4  ,
                        charlie4.getTag()).addToBackStack(charlie4.getTag()).commit();
            }
        });
        /*
        a5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Charlie5 charlie5 = new Charlie5();
                FragmentManager fragmentManager =  getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.Relative_Layout_For_Fragments,
                        charlie5,
                        charlie5.getTag()).addToBackStack(charlie5.getTag()).commit();
            }
        });
        */ //delete comment to have a fivith platoon
        a5.setEnabled(false);//commit this out to have a fifth platoon
        a5.setVisibility(View.GONE);

        return view;
    }

}
