package edu.illinois.cs.chara.charaapp.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import edu.illinois.cs.chara.charaapp.R;


public class LoginActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final EditText usernameText = (EditText) findViewById(R.id.login_username);
        final EditText passwordText = (EditText) findViewById(R.id.login_password);

        Button login = (Button) findViewById(R.id.login_confirm);
        final Context loginContext = this;
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameText.getText().toString();
                String password = passwordText.getText().toString();
                if(loginSuccess(username, password)) {
                    Intent queueListIntent = new Intent(loginContext, QueueListActivity.class);
                    startActivity(queueListIntent);
                }
                else {
                    Toast.makeText(loginContext, "Please enter a username and password", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private boolean loginSuccess(String username, String password) {
        return username.length() > 0 && password.length() > 0;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
