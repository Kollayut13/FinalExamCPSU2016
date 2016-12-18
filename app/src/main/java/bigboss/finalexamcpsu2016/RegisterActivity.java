package bigboss.finalexamcpsu2016;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText  editTextName,editTextUserName, editTextPassword;
    Button btnCreateAnAccount;
    LoginDataBaseHelper LoginDataBaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        LoginDataBaseHelper = new LoginDataBaseHelper(this);
        LoginDataBaseHelper = LoginDataBaseHelper.open();


        // Get Refferences of Views
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextUserName = (EditText) findViewById(R.id.editTextUserName);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);

        btnCreateAnAccount = (Button) findViewById(R.id.buttonCreateAnAccount);
        btnCreateAnAccount.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub

                String Name = editTextName.getText().toString();
                String userName = editTextUserName.getText().toString();
                String password = editTextPassword.getText().toString();


                if (userName.equals("") || password.equals("")) {
                    Toast.makeText(getApplicationContext(), "Registration failed!\n" + "Username already exists." , Toast.LENGTH_LONG).show();
                    return;
                }

                else {
                    // Save the Data in Database
                LoginDataBaseHelper.insertEntry(userName, password);
                    Toast.makeText(getApplicationContext(), "Create account successfully ", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();

        LoginDataBaseHelper.close();
    }
}
