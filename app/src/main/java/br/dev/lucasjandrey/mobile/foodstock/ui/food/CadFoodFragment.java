package br.dev.lucasjandrey.mobile.foodstock.ui.food;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import br.dev.lucasjandrey.mobile.foodstock.R;

public class CadFoodFragment extends Fragment {

    private View view = getView();
    private EditText foodName;

    public CadFoodFragment() {

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        this.view = inflater.inflate(R.layout.fragment_cad_food, container, false);

        //Binding



        return  this.view;
    }
}