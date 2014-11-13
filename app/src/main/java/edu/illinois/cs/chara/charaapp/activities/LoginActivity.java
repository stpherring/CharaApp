package edu.illinois.cs.chara.charaapp.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import edu.illinois.cs.chara.charaapp.R;
import edu.illinois.cs.chara.charaapp.holders.DataHolder;
import edu.illinois.cs.chara.charaapp.utils.JsonUtils;


public class LoginActivity extends ActionBarActivity {

    private static final String TAS_FILE_NAME = "TAs.json";

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
                if(verifyLogin(username, password)) {
                    Intent queueListIntent = new Intent(loginContext, QueueListActivity.class);
                    queueListIntent.putExtra("username", username);
                    startActivity(queueListIntent);
                    finish();
                }
                else {
                    Toast.makeText(loginContext, "Please enter a username and password", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    /*
     * Return true if username is a TA's netid and if the password matches.
     */
    private boolean verifyLogin(String username, String password) {
        // TODO - fix login. FileNotFoundError
        String data = JsonUtils.loadJSONFromAsset(this, TAS_FILE_NAME);
        boolean loginSuccess = false;

        if (data != null) {
            try {
                JSONObject TAObject = new JSONObject(data);
                JSONObject userObject = TAObject.getJSONObject(username);
                // error is thrown and caught if netid is not found
                if (userObject.getString("password").equals(password))
                    loginSuccess = true;
            } catch(JSONException j) {
                j.printStackTrace();
            } catch(NullPointerException e) {
                e.printStackTrace();
            }
        }
        return loginSuccess;
    }

    @Override
    public void onStart() {
        super.onStart();
        DataHolder holder = DataHolder.getInstance();
        holder.setQueues(null);
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
