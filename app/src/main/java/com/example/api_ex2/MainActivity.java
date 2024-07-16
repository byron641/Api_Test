package com.example.api_ex2;

import android.os.Bundle;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.converter.gson.GsonConverterFactory;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import retrofit2.Response;
import retrofit2.Retrofit;


public class MainActivity extends AppCompatActivity {

    private TextView textViewResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        textViewResult=findViewById(R.id.textViewResult);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PokemonApi pokemonApi = retrofit.create(PokemonApi.class);
        call<Pokemon> call = pokemonApi.getPokemon("ditto");

        call.enqueue(new Callback<Pokemon>(){

            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                if(!Response.isSuccessful()){
                    textViewResult.setText("Codigo: "+response.code());
                    return;
                }
            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {

            }
        }

        }
    }
