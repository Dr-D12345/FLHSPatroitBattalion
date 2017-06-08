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
public class FoxtrotFragment extends Fragment {


    public FoxtrotFragment() {
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
        TextView COC;
        COC = (TextView) view.findViewById(R.id.COC);
        COC.setText(R.string.FoxtrotChain);
        motto.setText(R.string.FoxtrotMotto);
        a1 = (Button) view.findViewById(R.id.B1button);
        TextView title;
        title = (TextView)view.findViewById(R.id.CompanyTitle);
        title.setText("Foxtrot");
        ImageView logo;
        logo = (ImageView)view.findViewById(R.id.CompanyLogo);

        String uri = "@drawable/foxtrot";
        int imageResource = getResources().getIdentifier(uri, null,getActivity().getPackageName());
        Drawable res = getResources().getDrawable(imageResource);
        int size = title.getHeight();
        logo.setMaxHeight(size);
        logo.setImageDrawable(res);

        ((AppCompatActivity)getActivity()).getSupportActionBar().setSubtitle("Foxtrot");
        a2 = (Button) view.findViewById(R.id.B2button);
        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              Foxtrot1 foxtrot1 = new Foxtrot1();
                FragmentManager fragmentManager =  getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.Relative_Layout_For_Fragments,
                        foxtrot1,
                     foxtrot1.getTag()).addToBackStack(foxtrot1.getTag()).commit();
            }
        });
        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Foxtrot2 foxtrot2 = new Foxtrot2();
                FragmentManager fragmentManager =  getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.Relative_Layout_For_Fragments,
                        foxtrot2,
                        foxtrot2.getTag()).addToBackStack(foxtrot2.getTag()).commit();
            }
        });



        Button a3,a4,a5;
        a3 = (Button) view.findViewById(R.id.B3button);
        a4 = (Button) view.findViewById(R.id.B4button);
        a5 = (Button) view.findViewById(R.id.B5button);
        a3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Foxtrot3 foxtrot3 = new Foxtrot3();
                FragmentManager fragmentManager =  getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.Relative_Layout_For_Fragments,
                        foxtrot3,
                        foxtrot3.getTag()).addToBackStack(foxtrot3.getTag()).commit();
            }
        });
        a4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Foxtrot4 foxtrot4 = new Foxtrot4();
                FragmentManager fragmentManager =  getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.Relative_Layout_For_Fragments,
                        foxtrot4,
                       foxtrot4.getTag()).addToBackStack(foxtrot4.getTag()).commit();
            }
        });

        a5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Foxtrot5 foxtrot5= new Foxtrot5();
                FragmentManager fragmentManager =  getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.Relative_Layout_For_Fragments,
                        foxtrot5,
                        foxtrot5.getTag()).addToBackStack(foxtrot5.getTag()).commit();
            }
        });
         //delete comment to have a fivith platoon
      //  a5.setEnabled(false);//commit this out to have a fifth platoon
       // a5.setVisibility(View.GONE);

















        return view;
    }

}
