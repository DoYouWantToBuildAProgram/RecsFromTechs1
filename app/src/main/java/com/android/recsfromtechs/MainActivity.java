package com.android.recsfromtechs;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;


public class MainActivity extends ActionBarActivity {

    private HashMap<String,String> usernames;



    //onCreate, as the name implies, this method is called when the app is "created" or opened
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //initializing our usernames map
        usernames = new HashMap<String,String>();

        //hardcoding a username and password for now because we don't have a registration page
        usernames.put("bob","password");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    //Called when the login button is pressed
    //essentially acts as an onclick listener, but this is done through xml and easier to write
    //if you go into activity_main.xml and look under the button
    // you'll see android:onClick="login"
    //that means whenever the button is clicked it will call login(View view),
    public void login(View view){

        //first we need to find the text that was entered
        // findViewById(R.id.idnamehere) is something we're going to use a lot
        //it connects the objects in our xml file to objects in our java file
        //EditText is the text box
        //to convert to string you have to call editText.toText().toString()

        EditText usernameText = (EditText) findViewById(R.id.username);
        EditText passwordText = (EditText) findViewById(R.id.password);

        String storedPassword = usernames.get(usernameText.getText().toString());

        if(storedPassword != null && storedPassword.equals(passwordText.getText().toString())){
            //the username exists in our usernames map and the password matches the password stored
            //storedPassword will be null if the username entered does not exist in our map
            //user should be logged in and taken to another page




            //Toasts! weird name, theyre just in-app notifications
            //Since we dont have a second page right now, we can use this to see if our login is working
            Context context = getApplicationContext();
            CharSequence text = "Login successful";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        } else {
            //Login was incorrect,
            Context context = getApplicationContext();
            CharSequence text = "username or password incorrect";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }







    }
}
