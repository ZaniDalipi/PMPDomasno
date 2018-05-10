package mk.edu.fikt.pmpdomasno;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Main2Activity extends AppCompatActivity {

    FirebaseAuth Auth;
    FirebaseAuth.AuthStateListener AuthListener;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference reference;


    private ListView listView;

    @Override
    protected void onStart() {
        super.onStart();
        Auth.addAuthStateListener(AuthListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button button = (Button) findViewById(R.id.buttonLogOut);












        Auth = FirebaseAuth.getInstance();

        AuthListener = new FirebaseAuth.AuthStateListener() { // an listener that check if current user is null to get us to the first activity to login
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() == null){

                    startActivity(new Intent(Main2Activity.this , MainActivity.class));
                }
            }
        };

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Auth.signOut();
            }
        });




    }

    public void goToDodavaj(View view) {
        Intent intent = new Intent( this , Main3Activity.class);
        startActivity(intent);

    }
}
