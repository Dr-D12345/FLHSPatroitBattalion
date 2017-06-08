package drd.flhspatriotbattalion;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.inputmethodservice.Keyboard;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

import drd.flhspatriotbattalion.R;

public class Create_Fragment extends Fragment {
public EditText content, password;
public Button send;
public  Boolean isCorrect = false;
public InputMethodManager mgr;
    public Create_Fragment() {
        // Required empty public construct
    }

    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment



        final DatabaseReference passwordRef = database.getReference().child("CFA");
        View view =  inflater.inflate(R.layout.fragment_create_, container, false);
        content = (EditText) view.findViewById(R.id.ContentInput);
        password = (EditText) view.findViewById(R.id.password);
        content.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                    (keyCode == KeyEvent.KEYCODE_ENTER)){
                // Perform action on key press
                    System.out.println("Enter is pressed");
                    password.requestFocus();
                    return true;
                }
            return false;
        }


        });
        send = (Button) view.findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String context = content.getText().toString();
                isCorrect = false;
                if (context.equals("")) {
                    Toast.makeText(getActivity(), "Please enter a Message", Toast.LENGTH_SHORT).show();
                } else {
                        final String passwordEntered = password.getText().toString();
                 if(passwordEntered.equals("r818")||passwordEntered.equals("R818")){
                    content.setText(R.string.R818);
                }else if(passwordEntered.equals("jmjm")){
                    content.setText("Marko likes Julianna.LOL :)");
               /*else if (passwordEntered.equals("arar")){
                         content.setText("Alan and Rebecca - Together forever.");
                 */}else if(passwordEntered.equals("jljl")){
                     content.setText("Jason is deepply in love wth Lea.");
                    }
                        passwordRef.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                                    String data = postSnapshot.getKey();

                                    System.out.println(passwordEntered);
                                    if (data.equals(passwordEntered)) {
                                        System.out.println("Access Granted");
                                        DatabaseReference create = passwordRef.child(data);
                                        create.addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(DataSnapshot dataSnapshot) {
                                                String string = dataSnapshot.getValue().toString();
                                                if (string.equals("a1")) {
                                                    database.getReference().child("Alpha").child("one").child("text").setValue(context);
                                                    Toast.makeText(getActivity(), "Sent", Toast.LENGTH_SHORT).show();
                                                    Intent i = new Intent(getActivity(), MainActivity.class);
                                                    startActivity(i);

                                                } else if (string.equals("a2")) {
                                                    database.getReference().child("Alpha").child("two").child("text").setValue(context);
                                                    Toast.makeText(getActivity(), "Sent", Toast.LENGTH_SHORT).show();
                                                    Intent i = new Intent(getActivity(), MainActivity.class);
                                                    startActivity(i);

                                                } else if (string.equals("a3")) {
                                                    database.getReference().child("Alpha").child("three").child("text").setValue(context);
                                                    Toast.makeText(getActivity(), "Sent", Toast.LENGTH_SHORT).show();
                                                    Intent i = new Intent(getActivity(), MainActivity.class);
                                                    startActivity(i);

                                                } else if (string.equals("a4")) {
                                                    database.getReference().child("Alpha").child("four").child("text").setValue(context);
                                                    Toast.makeText(getActivity(), "Sent", Toast.LENGTH_SHORT).show();
                                                    Intent i = new Intent(getActivity(), MainActivity.class);
                                                    startActivity(i);

                                                } else if (string.equals("a5")) {
                                                    database.getReference().child("Alpha").child("five").child("text").setValue(context);
                                                    Toast.makeText(getActivity(), "Sent", Toast.LENGTH_SHORT).show();
                                                    Intent i = new Intent(getActivity(), MainActivity.class);
                                                    startActivity(i);

                                                } else if (string.equals("b1")) {
                                                    database.getReference().child("Bravo").child("one").child("text").setValue(context);
                                                    Toast.makeText(getActivity(), "Sent", Toast.LENGTH_SHORT).show();
                                                    Intent i = new Intent(getActivity(), MainActivity.class);
                                                    startActivity(i);

                                                } else if (string.equals("b2")) {
                                                    database.getReference().child("Bravo").child("two").child("text").setValue(context);
                                                    Toast.makeText(getActivity(), "Sent", Toast.LENGTH_SHORT).show();
                                                    Intent i = new Intent(getActivity(), MainActivity.class);
                                                    startActivity(i);

                                                } else if (string.equals("b3")) {
                                                    database.getReference().child("Bravo").child("three").child("text").setValue(context);
                                                    Toast.makeText(getActivity(), "Sent", Toast.LENGTH_SHORT).show();
                                                    Intent i = new Intent(getActivity(), MainActivity.class);
                                                    startActivity(i);

                                                } else if (string.equals("b4")) {
                                                    database.getReference().child("Bravo").child("four").child("text").setValue(context);
                                                    Toast.makeText(getActivity(), "Sent", Toast.LENGTH_SHORT).show();
                                                    Intent i = new Intent(getActivity(), MainActivity.class);
                                                    startActivity(i);

                                                } else if (string.equals("b5")) {
                                                    database.getReference().child("Bravo").child("five").child("text").setValue(context);
                                                    Toast.makeText(getActivity(), "Sent", Toast.LENGTH_SHORT).show();
                                                    Intent i = new Intent(getActivity(), MainActivity.class);
                                                    startActivity(i);

                                                } else if (string.equals("c1")) {
                                                    database.getReference().child("Charlie").child("one").child("text").setValue(context);
                                                    Toast.makeText(getActivity(), "Sent", Toast.LENGTH_SHORT).show();
                                                    Intent i = new Intent(getActivity(), MainActivity.class);
                                                    startActivity(i);

                                                } else if (string.equals("c2")) {
                                                    database.getReference().child("Charlie").child("two").child("text").setValue(context);
                                                    Toast.makeText(getActivity(), "Sent", Toast.LENGTH_SHORT).show();
                                                    Intent i = new Intent(getActivity(), MainActivity.class);
                                                    startActivity(i);

                                                } else if (string.equals("c3")) {
                                                    database.getReference().child("Charlie").child("three").child("text").setValue(context);
                                                    Toast.makeText(getActivity(), "Sent", Toast.LENGTH_SHORT).show();
                                                    Intent i = new Intent(getActivity(), MainActivity.class);
                                                    startActivity(i);

                                                } else if (string.equals("c4")) {
                                                    database.getReference().child("Charlie").child("four").child("text").setValue(context);
                                                    Toast.makeText(getActivity(), "Sent", Toast.LENGTH_SHORT).show();
                                                    Intent i = new Intent(getActivity(), MainActivity.class);
                                                    startActivity(i);

                                                } else if (string.equals("c5")) {
                                                    database.getReference().child("Charlie").child("five").child("text").setValue(context);
                                                    Toast.makeText(getActivity(), "Sent", Toast.LENGTH_SHORT).show();
                                                    Intent i = new Intent(getActivity(), MainActivity.class);
                                                    startActivity(i);

                                                } else if (string.equals("d1")) {
                                                    database.getReference().child("Delta").child("one").child("text").setValue(context);
                                                    Toast.makeText(getActivity(), "Sent", Toast.LENGTH_SHORT).show();
                                                    Intent i = new Intent(getActivity(), MainActivity.class);
                                                    startActivity(i);

                                                } else if (string.equals("d2")) {
                                                    database.getReference().child("Delta").child("two").child("text").setValue(context);
                                                    Toast.makeText(getActivity(), "Sent", Toast.LENGTH_SHORT).show();
                                                    Intent i = new Intent(getActivity(), MainActivity.class);
                                                    startActivity(i);

                                                } else if (string.equals("d3")) {
                                                    database.getReference().child("Delta").child("three").child("text").setValue(context);
                                                    Toast.makeText(getActivity(), "Sent", Toast.LENGTH_SHORT).show();
                                                    Intent i = new Intent(getActivity(), MainActivity.class);
                                                    startActivity(i);

                                                } else if (string.equals("d4")) {
                                                    database.getReference().child("Delta").child("four").child("text").setValue(context);
                                                    Toast.makeText(getActivity(), "Sent", Toast.LENGTH_SHORT).show();
                                                    Intent i = new Intent(getActivity(), MainActivity.class);
                                                    startActivity(i);

                                                } else if (string.equals("d5")) {
                                                    database.getReference().child("Delta").child("five").child("text").setValue(context);
                                                    Toast.makeText(getActivity(), "Sent", Toast.LENGTH_SHORT).show();
                                                    Intent i = new Intent(getActivity(), MainActivity.class);
                                                    startActivity(i);

                                                } else if (string.equals("e1")) {
                                                    database.getReference().child("Echo").child("one").child("text").setValue(context);
                                                    Toast.makeText(getActivity(), "Sent", Toast.LENGTH_SHORT).show();
                                                    Intent i = new Intent(getActivity(), MainActivity.class);
                                                    startActivity(i);

                                                } else if (string.equals("e2")) {
                                                    database.getReference().child("Echo").child("two").child("text").setValue(context);
                                                    Toast.makeText(getActivity(), "Sent", Toast.LENGTH_SHORT).show();
                                                    Intent i = new Intent(getActivity(), MainActivity.class);
                                                    startActivity(i);

                                                } else if (string.equals("e3")) {
                                                    database.getReference().child("Echo").child("three").child("text").setValue(context);
                                                    Toast.makeText(getActivity(), "Sent", Toast.LENGTH_SHORT).show();
                                                    Intent i = new Intent(getActivity(), MainActivity.class);
                                                    startActivity(i);

                                                } else if (string.equals("e4")) {
                                                    database.getReference().child("Echo").child("four").child("text").setValue(context);
                                                    Toast.makeText(getActivity(), "Sent", Toast.LENGTH_SHORT).show();
                                                    Intent i = new Intent(getActivity(), MainActivity.class);
                                                    startActivity(i);

                                                } else if (string.equals("e5")) {
                                                    database.getReference().child("Echo").child("five").child("text").setValue(context);
                                                    Toast.makeText(getActivity(), "Sent", Toast.LENGTH_SHORT).show();
                                                    Intent i = new Intent(getActivity(), MainActivity.class);
                                                    startActivity(i);
                                                } else if (string.equals("f1")) {
                                                    database.getReference().child("Foxtrot").child("one").child("text").setValue(context);
                                                    Toast.makeText(getActivity(), "Sent", Toast.LENGTH_SHORT).show();
                                                    Intent i = new Intent(getActivity(), MainActivity.class);
                                                    startActivity(i);

                                                } else if (string.equals("f2")) {
                                                    database.getReference().child("Foxtrot").child("two").child("text").setValue(context);
                                                    Toast.makeText(getActivity(), "Sent", Toast.LENGTH_SHORT).show();
                                                    Intent i = new Intent(getActivity(), MainActivity.class);
                                                    startActivity(i);
                                                } else if (string.equals("f3")) {
                                                    database.getReference().child("Foxtrot").child("three").child("text").setValue(context);
                                                    Toast.makeText(getActivity(), "Sent", Toast.LENGTH_SHORT).show();
                                                    Intent i = new Intent(getActivity(), MainActivity.class);
                                                    startActivity(i);

                                                } else if (string.equals("f4")) {
                                                    database.getReference().child("Foxtrot").child("four").child("text").setValue(context);
                                                    Toast.makeText(getActivity(), "Sent", Toast.LENGTH_SHORT).show();
                                                    Intent i = new Intent(getActivity(), MainActivity.class);
                                                    startActivity(i);

                                                } else if (string.equals("f5")) {
                                                    database.getReference().child("Foxtrot").child("five").child("text").setValue(context);
                                                    Toast.makeText(getActivity(), "Sent", Toast.LENGTH_SHORT).show();
                                                    Intent i = new Intent(getActivity(), MainActivity.class);
                                                    startActivity(i);
                                                }else if (string.equals("ad")) {
                                                 Request();
                                                }
                                                else{
                                                    Toast.makeText(getActivity(), "Sorry Wrong Password :(", Toast.LENGTH_SHORT).show();
                                                }
                                            }
                                            @Override
                                            public void onCancelled(DatabaseError databaseError) {
                                                Toast.makeText(getActivity(), "Please connect to the internet.", Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                    }
                                }
                            }
                            @Override
                            public void onCancelled(DatabaseError databaseError) {
                            }
                        });

                }

                }



        });

















        return view;

    }

public void Request(){
    DatabaseReference AD = database.getReference("Requests").push();
    HashMap<String, String> request = new HashMap<String, String>();
    final String name = content.getText().toString();
    request.put(content.getText().toString(), "false");

    final String key = AD.getKey();
    AD.setValue(request);

    final DatabaseReference ADL = database.getReference("Requests").child(key).child(content.getText().toString());
    content.setText(key);
    ADL.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            System.out.println("code " + dataSnapshot);
         if (dataSnapshot.getValue().equals("True")){
             DatabaseReference Admin = database.getReference("Admins").push();
             HashMap<String, String> request2 = new HashMap<String, String>();

             request2.put(name, "True");

             Admin.setValue(request2);
             String key1 = Admin.getKey();

                SharedPreferences sharedPreferences = getActivity().getSharedPreferences("MyData", Context.MODE_PRIVATE);
                final SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("A6", "true");
                editor.putString("key", key1);
                editor.putString("context", name);
                editor.apply();

            }
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        Toast.makeText(getActivity(),"Something went wrong..", Toast.LENGTH_SHORT).show();
        }
    });



}

}