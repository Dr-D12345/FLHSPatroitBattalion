package drd.flhspatriotbattalion;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.design.widget.NavigationView;
import android.support.v4.media.RatingCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.method.CharacterPickerDialog;
import android.util.AndroidRuntimeException;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


import com.fasterxml.jackson.databind.deser.impl.NullProvider;
import com.firebase.client.Firebase;
import com.firebase.ui.database.FirebaseListAdapter;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startService(new Intent(this, Notification.class));
       final SharedPreferences sharedPreferences = this.getSharedPreferences("MyData", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        final FirebaseDatabase database = FirebaseDatabase.getInstance();

        System.out.println("hippo" + sharedPreferences.getString("A6","") +" key "+ sharedPreferences.getString("key","") + "context" + sharedPreferences.getString("context",""));
     if (sharedPreferences.getString("A6","").equals("true") || sharedPreferences.getString("A6","").equals("false")) {

            DatabaseReference databaseReference = database.getReference("Admins").child(sharedPreferences.getString("key", "")).child(sharedPreferences.getString("context", ""));

                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.getValue().equals("false")) {
                            editor.putString("A6", "false");
                            editor.apply();
                            System.out.println("hippo2" + sharedPreferences.getString("A6", ""));

                        } else if (dataSnapshot.getValue().equals("True")) {
                            editor.putString("A6", "true");
                            editor.apply();
                        }

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                        System.out.println("hello" + databaseError.getCode());
                    }
                });


        }
       final CentralFragment centralFragment = new CentralFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.Relative_Layout_For_Fragments,
                centralFragment,
                centralFragment.getTag()).commit();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Francis Lewis");

        toolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
               this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        FragmentManager mFragmentManager =getSupportFragmentManager();

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if(mFragmentManager.findFragmentById(R.id.Relative_Layout_For_Fragments) instanceof CentralFragment) {
            Intent i = new Intent(this, MainActivity.class);
            Toast.makeText(this,"Refreshed",Toast.LENGTH_SHORT).show();
            startActivity(i);

        }else{
            super.onBackPressed();

            }

        }

//}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_help) {
            Help help = new Help();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.Relative_Layout_For_Fragments,
                    help,
                    help.getTag()).addToBackStack(help.getTag()).commit();
            return true;
        }else if (id == R.id.action_create){
            Create_Fragment create_fragment= new Create_Fragment();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.Relative_Layout_For_Fragments,
                    create_fragment,
                    create_fragment.getTag()).addToBackStack(create_fragment.getTag()).commit();

        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.Home){
            CentralFragment centralFragment = new CentralFragment();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.Relative_Layout_For_Fragments,
                    centralFragment,
                    centralFragment.getTag()).commit();
            System.out.println("Home Selected");
        }
        else if (id == R.id.Alpha) {
            AlphaFragment alphaFragment = new AlphaFragment();
            FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.Relative_Layout_For_Fragments,
                alphaFragment,
                alphaFragment.getTag()).addToBackStack(alphaFragment.getTag()).commit();
            // Handle the camera action

        } else if (id == R.id.Bravo) {
            BravoFragment bravoFragment = new BravoFragment();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.Relative_Layout_For_Fragments,
                    bravoFragment,
                    bravoFragment.getTag()).addToBackStack(bravoFragment.getTag()).commit();

        } else if (id == R.id.Charlie) {
            CharlieFragment charlieFragment = new CharlieFragment();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.Relative_Layout_For_Fragments,
                    charlieFragment,
                    charlieFragment.getTag()).addToBackStack(charlieFragment.getTag()).commit();
        }else if (id == R.id.Delta) {
            DeltaFragment deltaFragment = new DeltaFragment();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.Relative_Layout_For_Fragments,
                    deltaFragment,
                    deltaFragment.getTag()).addToBackStack(deltaFragment.getTag()).commit();

        } else if (id == R.id.Echo) {
            EchoFragment echoFragment = new EchoFragment();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.Relative_Layout_For_Fragments,
                   echoFragment,
                    echoFragment.getTag()).addToBackStack(echoFragment.getTag()).commit();
        }else if (id == R.id.Foxtrot) {
            FoxtrotFragment foxtrotFragment = new FoxtrotFragment();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.Relative_Layout_For_Fragments,
                    foxtrotFragment,
                    foxtrotFragment.getTag()).addToBackStack(foxtrotFragment.getTag()).commit();
        }else if (id == R.id.Knowledge_grooming) {
        Grooming grooming = new Grooming();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.Relative_Layout_For_Fragments,
                    grooming,
                    grooming.getTag()).addToBackStack(grooming.getTag()).commit();
        } else if (id == R.id.Knowledge_sheet) {
            Knowledge_sheet knowledge_sheet = new Knowledge_sheet();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.Relative_Layout_For_Fragments,
                    knowledge_sheet,
                   knowledge_sheet.getTag()).addToBackStack(knowledge_sheet.getTag()).commit();
        }else if (id== R.id.Knowledge_Ranks_Ribbons){
                RanksAndRibbions ranksAndRibbions  = new RanksAndRibbions();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.Relative_Layout_For_Fragments,
                    ranksAndRibbions,
                    ranksAndRibbions.getTag()).addToBackStack(ranksAndRibbions.getTag()).commit();
        }else if(id == R.id.Knowledge_Uniform){
            uniform Uniform = new uniform();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.Relative_Layout_For_Fragments,
                    Uniform,
                    Uniform.getTag()).addToBackStack(Uniform.getTag()).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
