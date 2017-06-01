package pl.akademiakodu.lukaszkolacz.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        createDialog();
        createCustomDialog();
    }


    public void createDialog() {
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Kurs Android")
                .setMessage("Podoba ci się kurs?")
                .setCancelable(false) // klikniecie poza okno nie spowoduje jego zamkniecia
                .setIcon(R.mipmap.ic_launcher) // podstawianie ikony do okna
                .setPositiveButton("Tak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).setNegativeButton("Nie", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Jak możęsz go nie lubić?! ", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }).show();
    }

    public void createCustomDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_test);
        dialog.setTitle("Test");

        Button exit = (Button) dialog.findViewById(R.id.buttonExit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
