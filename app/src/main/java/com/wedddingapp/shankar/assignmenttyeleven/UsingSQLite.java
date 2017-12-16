package com.wedddingapp.shankar.assignmenttyeleven;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class UsingSQLite extends Activity
{
    private SQLiteCountryAssistant sqlliteCountryAssistant;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.autocompleteProducts); //this is used to put Autocomplete

        sqlliteCountryAssistant = new SQLiteCountryAssistant(UsingSQLite.this);
        sqlliteCountryAssistant.openDB();

        // Insert a few countries that begin with "C"
        sqlliteCountryAssistant.insertProduct("Hp Injet Printer"); //inserting product
        sqlliteCountryAssistant.insertProduct("Hp Dot Matrixprinter");
        sqlliteCountryAssistant.insertProduct("Hp Desktop");


        String[] products = sqlliteCountryAssistant.getAllProducts();

        // Print out the values to the log
        for(int i = 0; i < products.length; i++)
        {
            Log.i(this.toString(), products[i]);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item, products);
        textView.setAdapter(adapter); //Arrayadapter we used to put the product in the form list
    }

    public void onDestroy()
    {
        super.onDestroy();
        sqlliteCountryAssistant.close();
    }
}