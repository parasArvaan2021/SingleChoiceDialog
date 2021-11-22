package com.mil.en2fr.singlechoicedialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView show_single_choice_Dialog,show_multi_choice_dialog,show_simple_dialog;
    TextView show_selected_item;
    String[] country;
    String[] list=new String[]{"paras","paras","paras"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show_single_choice_Dialog =findViewById(R.id.txt_showdialog);
        show_multi_choice_dialog=findViewById(R.id.txt_show_multi_choice_dialog);
        show_simple_dialog=findViewById(R.id.txt_show_simple_dialog);
        show_selected_item=findViewById(R.id.txt_show_item);
        country=getResources().getStringArray(R.array.country_name);
        final boolean[] checkedItems = new boolean[country.length];

        show_single_choice_Dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alBuilder=new AlertDialog.Builder(MainActivity.this);
                alBuilder.setTitle("Single Choice dialog");
                alBuilder.setSingleChoiceItems(country, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        show_selected_item.setText(country[which]);
                        dialog.dismiss();
                    }
                });
                alBuilder.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                    }
                });
                AlertDialog alertDialog=alBuilder.create();
                alertDialog.show();
            }
        });

        show_multi_choice_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alBuilder=new AlertDialog.Builder(MainActivity.this);
                alBuilder.setTitle("multi Choice dialog");
                alBuilder.setMultiChoiceItems(country,checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        checkedItems[which]=isChecked;
                    }
                });
                alBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                alBuilder.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                    }
                });
                AlertDialog alertDialog=alBuilder.create();
                alertDialog.show();

            }
        });
        show_simple_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertBuilder=new AlertDialog.Builder(MainActivity.this);
                alertBuilder.setTitle("Simple Dialog");
                alertBuilder.setMessage("A material metaphor is the unifying theory of a rationalized space and a syatem of motion...");
                alertBuilder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                    }
                });
                alertBuilder.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                alertBuilder.setNeutralButton("Neutral", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                AlertDialog alertDialog=alertBuilder.create();
                alertDialog.show();
            }
        });

    }
}