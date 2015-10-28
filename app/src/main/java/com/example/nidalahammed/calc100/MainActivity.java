package com.example.nidalahammed.calc100;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.widget.EditText;
import android.widget.Button;
import android.content.Intent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;


public class MainActivity extends AppCompatActivity {

    static String total ="";
    double v1,v2,v0;
    String sign="";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }
    public void onscale(View v)
    {

        final Animation animScale = AnimationUtils.loadAnimation(this, R.anim.anim_scale);
        v.startAnimation(animScale);

    }

    public void onalpha(View v)
    {

        final Animation animAlpha = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);
        v.startAnimation(animAlpha);

    }

    public void onrotate(View v)
    {

        final Animation animRotate = AnimationUtils.loadAnimation(this, R.anim.anim_rotate);
        v.startAnimation(animRotate);

    }



    public void onClick(View v){

        Button button = (Button)v;
        String str = button.getText().toString();
        total+=str;
       EditText edit= (EditText)findViewById(R.id.editText);
        edit.setText(total);
        v0=Double.parseDouble(total);





       // onalpha(v);
        onrotate(v);
       // onscale(v);



    }
    public void onAdd(View v)
    {

     //   v1= Double.parseDouble(total);
          v1= v0 ;
          total="";

        Button button = (Button)v;
        String strs=button.getText().toString();
        sign =strs ;

        EditText edit = (EditText)findViewById(R.id.editText);
        edit.setText("");

        onalpha(v);
        onrotate(v);

    }
    public void onClickNext(View v)
    { if(v.getId() == R.id.Bdisplay)
       { Intent i = new Intent(MainActivity.this, display.class);
           startActivity(i);
       }


        onalpha(v);
        onrotate(v);

    }
    public void onCalculator(View v)
    {

        EditText edit= (EditText)findViewById(R.id.editText);
    String str2= edit.getText().toString();
    v2=Double.parseDouble(str2);
    double grand_total=0;


        if (sign.equals("+")) {
            grand_total = v1 + v2;
        } else if (sign.equals("-")) {
            grand_total = v1 - v2;
        } else if (sign.equals("*")) {
            grand_total = v1 * v2;
        } else if (sign.equals("/"))


        {

            grand_total = v1 / v2;
        }


         v0=grand_total;

       edit.setText(grand_total + "");




        onalpha(v);
        onrotate(v);

    }


    public void onBack(View v)
    {  EditText edit = (EditText)findViewById(R.id.editText);

        String str=edit.getText().toString();
        if (str.length() >1 ) {
            str = str.substring(0, str.length() - 1);
            edit.setText(str);

            total=str;
        }
        else if (str.length() <=1 ) {
            edit.setText("0");

        }

        onalpha(v);
        onrotate(v);

    }


    public void onClear(View v)
    { //String str=edit.getText().toString();
        EditText edit = (EditText)findViewById(R.id.editText);
    edit.setText("");
    total="" ;

        if (edit.length() <=1 ) {
            edit.setText("0");}

        onalpha(v);
        onrotate(v);

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
}
