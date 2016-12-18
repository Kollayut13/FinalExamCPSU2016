package bigboss.finalexamcpsu2016;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText
        ;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    LoginDataBaseHelper LoginDataBaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        LoginDataBaseHelper=new  LoginDataBaseHelper(this);
        LoginDataBaseHelper=LoginDataBaseHelper.open();

        final EditText editTextUserName=(EditText) findViewById(R.id.editTextUserNameToLogin);
        final  EditText editTextPassword=(EditText) findViewById(R.id.editTextPasswordToLogin);
        Button btnLogin=(Button) findViewById(R.id.buttonLOGIN);
        Button btnRegister = (Button)findViewById(R.id.buttonREGISTER);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub

                /// Create Intent for SignUpActivity  abd Start The Activity
                Intent intentRegister = new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(intentRegister);
            }
        });


        btnLogin.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // get The User name and Password
                String userName= editTextUserName.getText().toString();
                String password= editTextPassword.getText().toString();

                // fetch the Password form database for respective user name
                String storedPassword= LoginDataBaseHelper.getSinlgeEntry(userName);

                // check if the Stored password matches with  Password entered by user
                if(password.equals(storedPassword))
                {
                    Toast.makeText(LoginActivity.this, "Congrats: Login Successfull", Toast.LENGTH_LONG).show();

                }
                else
                {
                    Toast.makeText(LoginActivity.this, "lnvaild username or password", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

}
