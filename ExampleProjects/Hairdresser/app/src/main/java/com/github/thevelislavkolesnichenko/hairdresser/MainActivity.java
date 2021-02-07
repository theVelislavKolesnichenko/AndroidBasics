package com.github.thevelislavkolesnichenko.hairdresser;

import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.github.thevelislavkolesnichenko.hairdresser.adapters.CustomerAdapter;
import com.github.thevelislavkolesnichenko.hairdresser.data.Source;
import com.github.thevelislavkolesnichenko.hairdresser.listener.OnFragmentInteractionListener;
import com.github.thevelislavkolesnichenko.hairdresser.model.Customer;

import java.nio.file.Files;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements OnFragmentInteractionListener {

    private RecyclerView recyclerView;
    private CustomerAdapter adapter;

    Handler handler = new Handler();

    private Runnable runnableCode = new Runnable() {
        @Override
        public void run() {

            int rand = new Random().nextInt(3);
            boolean datachange = false;
            for (Customer customer : Source.getCustomers()) {
                switch (rand) {
                    case 1:
                        if(!customer.isState()) {
                            customer.setState(true);
                            adapter.notifyDataSetChanged();
                            datachange = true;
                        }
                        break;
                    case 2: {
                        adapter.add(new Customer("new Customer", "new Typa", false));
                        datachange = true;
                    }
                        break;
                    case 3:
                        if(customer.isState()) {
                            adapter.remove(customer);
                            datachange = true;
                        }
                        break;
                }
                if(datachange){
                    break;
                }
            }

            handler.postDelayed(this, 300);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv);

        adapter = new CustomerAdapter(Source.getCustomers());

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(adapter);

        handler.post(runnableCode);
    }

    @Override
    public void onFragmentInteraction(int position) {
        adapter.onFragmentInteraction(position);
    }
}
