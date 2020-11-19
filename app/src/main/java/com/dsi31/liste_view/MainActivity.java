package com.dsi31.liste_view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ArrayList<HashMap<String,String>> list= new ArrayList();


         int[] myImageList = new int[]{R.drawable.word, R.drawable.excel,
                R.drawable.powerpoint,R.drawable.outlook
                };

        HashMap<String,String>Log= new HashMap<String,String>();
        Log.put("title","word");
        Log.put("description","editeur de texte");
        Log.put("image",myImageList[0]+"");
        list.add(Log);
        Log= new HashMap<String,String>();
        Log.put("title","Excel");
        Log.put("description","tableur");
        Log.put("image",myImageList[1]+"");
        list.add(Log);
        Log= new HashMap<String,String>();
        Log.put("title","powerpoint");
        Log.put("description","logiciel de présentation");
        Log.put("image",myImageList[2]+"");
        list.add(Log);
        Log= new HashMap<String,String>();
        Log.put("title","outlook");
        Log.put("description","client de courrier électronique");
        Log.put("image",myImageList[3]+"");
        list.add(Log);
        String[]from={"title","description","image"};
        int[] to= { R.id.titreview, R.id.descr,R.id.Image};
        //LogAdapter logAdapter = new LogAdapter (this, Log, LogImg);
        final ListView list1 = findViewById(R.id.ListeView1);
        SimpleAdapter adapter = new SimpleAdapter(this,list,R.layout.ligne, from, to);
        list1.setAdapter(adapter);
        list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),list.get(position).get("title"),Toast.LENGTH_LONG).show();
            }

        });
        list1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Sélection Item");
                builder.setMessage("votre choix: "+list.get(position).get("title"));
                builder.setCancelable(true);
                builder.setPositiveButton("ok", null).show();

                return true;
            }
        });

    }

}