package mk.edu.fikt.pmpdomasno;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Main3Activity extends AppCompatActivity {

    EditText zborce , opis , userName;
    Button button;
    FirebaseDatabase dataBase;
    DatabaseReference reference;
    Zbor zborPOJO;
    MainActivity mainActivity;
    private final static int RC_SIGN_IN = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        zborce = (EditText) findViewById(R.id.textZbor);
        opis = (EditText) findViewById(R.id.textOpis);
        userName = (EditText) findViewById(R.id.textUserName);
        button = (Button) findViewById(R.id.buttonZacuvuvaj);
        dataBase = FirebaseDatabase.getInstance();
        reference = dataBase.getReference("Zbor");
        zborPOJO = new Zbor();
    }
    private void getValues(){

        zborPOJO.setOpis(opis.getText().toString());
        zborPOJO.setZbor(zborce.getText().toString());
        zborPOJO.setUserName(userName.getText().toString());
    }

    public void Dodavaj(View view){
        Log.i("tag" , "works");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                getValues();
                reference.child(userName.getText().toString()).setValue(zborPOJO);
                Toast.makeText(Main3Activity.this, "Data Inserted to DB", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void goBackToPrebaruvaj(View view){
        finish();
    }
}
