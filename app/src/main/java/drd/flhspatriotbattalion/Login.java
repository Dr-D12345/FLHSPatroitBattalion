package drd.flhspatriotbattalion;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import static com.firebase.ui.auth.ui.AcquireEmailHelper.RC_SIGN_IN;

public class Login extends AppCompatActivity  implements GoogleApiClient.OnConnectionFailedListener{
    private FirebaseAuth auth;
    private  FirebaseAuth.AuthStateListener AuthListener;


    private GoogleApiClient mGoogleApiClient;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {

            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);

            if (result.isSuccess()) {

                // Google Sign In was successful, authenticate with Firebase

                GoogleSignInAccount account = result.getSignInAccount();

                firebaseAuthWithGoogle(account);

            } else {

                // Google Sign In failed, update UI appropriately

                // [START_EXCLUDE]


                // [END_EXCLUDE]

            }
    }
    }
    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {

        // [END_EXCLUDE]



        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);

        auth.signInWithCredential(credential)

                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {

                    @Override

                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            FirebaseUser user = auth.getCurrentUser();
                            Toast.makeText(Login.this, "Hello there, "+user.getDisplayName(),

                                    Toast.LENGTH_SHORT).show();




                       } else {
                       // If sign in fails, display a message to the use
                            Toast.makeText(Login.this, "Authentication failed.",

                                    Toast.LENGTH_SHORT).show();



                        }



                        // [START_EXCLUDE]


                        // [END_EXCLUDE]

                    }

                });

    }
    private void revokeAccess() {

        // Firebase sign out

        auth.signOut();



        // Google revoke access

        Auth.GoogleSignInApi.revokeAccess(mGoogleApiClient).setResultCallback(

                new ResultCallback<Status>() {

                    @Override

                    public void onResult(@NonNull Status status) {



                    }

                });

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        SignInButton signInButton = (SignInButton) findViewById(R.id.sign_in_button);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        mGoogleApiClient = new GoogleApiClient.Builder(this)

                .enableAutoManage(this /* FragmentActivity */, this /* OnConnectionFailedListener */)

                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();
        auth = FirebaseAuth.getInstance();
        AuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user!= null){


                }else {

                }
            }
        };
    }

    @Override
    protected void onStart() {
        super.onStart();
        auth.addAuthStateListener(AuthListener);
    }
    private void signIn() {
     Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
     startActivityForResult(signInIntent, RC_SIGN_IN);
     }
    @Override
    protected void onStop() {
        super.onStop();
        if (AuthListener != null) {
            auth.removeAuthStateListener(AuthListener);
        }
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Toast.makeText(this, "Google Play Services error.", Toast.LENGTH_SHORT).show();
    }
}
