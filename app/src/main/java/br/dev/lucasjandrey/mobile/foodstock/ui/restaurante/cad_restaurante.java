package br.dev.lucasjandrey.mobile.foodstock.ui.restaurante;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.snackbar.Snackbar;

import org.json.JSONException;
import org.json.JSONObject;

import br.dev.lucasjandrey.mobile.foodstock.R;
import br.dev.lucasjandrey.mobile.foodstock.model.Restaurante;

public class cad_restaurante extends Fragment {

    private View view = null;
    private EditText nome;
    private EditText descricao;
    private EditText endereco;
    private EditText horario;


    private RequestQueue requestQueue;
    private JsonObjectRequest jsonObjectReq;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        this.view = inflater.inflate(R.layout.fragment_cad_restaurante, container, false);

        this.nome = (EditText) view.findViewById(R.id.etNome);
        this.descricao = (EditText) view.findViewById(R.id.etDescricao);
        this.endereco = (EditText) view.findViewById(R.id.etEndereco);
        this.horario = (EditText) view.findViewById(R.id.etHorario);

        return this.view;
    }


    public void onClick(View view) {
        switch (view.getId()) {
            //verificando se é o botão salvar
            case R.id.btSalvar:
                //instanciando objeto de negócio
                Restaurante rest = new Restaurante();
                rest.setNome(this.nome.getText().toString());
                rest.setDescricao(this.descricao.getText().toString());
                rest.setEndereco(this.endereco.getText().toString());
                rest.setHorario(this.endereco.getText().toString());
                //Chamar WebService
                jsonObjectReq = new JsonObjectRequest(
                        Request.Method.POST,
                        "http://localhost/teste/cadRestaurante.php ",
                        rest.toJsonObject(), this::onResponse,  this::onErrorResponse);
                requestQueue.add(jsonObjectReq);
                break;
        }
    }



    public void onErrorResponse(VolleyError error) {
        Snackbar mensagem = Snackbar.make(view,
                "Ops! Houve um problema ao realizar o cadastro: " +
                        error.toString(),Snackbar.LENGTH_LONG);
        mensagem.show();

    }


    public void onResponse(Object response) {
        try {
            //instanciando objeto para manejar o JSON que recebemos
            JSONObject jason = new JSONObject(response.toString());
            //context e text são para a mensagem na tela o Toast
            Context context = view.getContext();
            //pegando mensagem que veio do json
            CharSequence mensagem = jason.getString("message");
            //duração da mensagem na tela
            int duration = Toast.LENGTH_SHORT;
            //verificando se salvou sem erro para limpar campos da tela
            if (jason.getBoolean("success")){
                //campos texto
                this.nome.setText("");
            }
            //mostrando a mensagem que veio do JSON
            Toast toast = Toast.makeText (context, mensagem, duration);
            toast.show();

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        //mensagem de sucesso


    }

}