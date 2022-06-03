package sg.edu.rp.c346.id21021397.demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etElement;
    EditText etNumber;
    Button btnAdd;
    Button btnRemove;
    Button btnUpdate;
    ListView lvColour;
    ArrayList<String> alColours;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etElement = findViewById(R.id.editTextColour);
        etNumber = findViewById(R.id.editTextNumber);
        btnAdd = findViewById(R.id.buttonAddItem);
        btnRemove = findViewById(R.id.buttonRemoveItem);
        btnUpdate = findViewById(R.id.buttonUpdateItem);
        lvColour = findViewById(R.id.listViewColour);
        alColours = new ArrayList<>();
        alColours.add("Red");
        alColours.add("Orange");

        ArrayAdapter aaColour = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alColours);

        lvColour.setAdapter(aaColour);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = Integer.parseInt(etNumber.getText().toString());
                String element = etElement.getText().toString();
                alColours.add(pos,element);
                aaColour.notifyDataSetChanged();
            }
        });

        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = Integer.parseInt(etNumber.getText().toString());
                alColours.remove(pos);
                aaColour.notifyDataSetChanged();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = Integer.parseInt(etNumber.getText().toString());
                String element = etElement.getText().toString();
                alColours.set(pos,element);
                aaColour.notifyDataSetChanged();
            }
        });

        lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(getApplicationContext(),aaColour.getItem(position).toString(),Toast.LENGTH_SHORT).show();
            }
        });


    }
}