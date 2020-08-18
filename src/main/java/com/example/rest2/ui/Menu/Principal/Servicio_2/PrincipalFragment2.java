package com.example.rest2.ui.Menu.Principal.Servicio_2;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rest2.R;
import com.example.rest2.model.ModelService2;
import com.example.rest2.service.Api;
import com.luseen.spacenavigation.SpaceItem;
import com.luseen.spacenavigation.SpaceNavigationView;
import com.luseen.spacenavigation.SpaceOnClickListener;

import java.util.List;

import link.fls.swipestack.SwipeStack;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PrincipalFragment2 extends Fragment {
    RecyclerView recyclerView;
    List<ModelService2> modelData;
    SpaceNavigationView spaceNavigationView;
    SwipeStack swipeStack;
    AppCompatTextView estado;
    public PrincipalFragment2() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.secundario_fragment, container, false);
        estado = (AppCompatTextView) view.findViewById(R.id.headerText);
        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerView);
        spaceNavigationView = (SpaceNavigationView) view.findViewById(R.id.space);
        spaceNavigationView.initWithSaveInstanceState(savedInstanceState);
        spaceNavigationView.addSpaceItem(new SpaceItem("Acerca de", R.drawable.acerca));
        spaceNavigationView.addSpaceItem(new SpaceItem("Información", R.drawable.info));
        spaceNavigationView.setCentreButtonIcon(R.drawable.loading);
        getUserListData();
        spaceNavigationView.setSpaceOnClickListener(new SpaceOnClickListener() {
            @Override
            public void onCentreButtonClick() {
                getUserListData();
            }

            @Override
            public void onItemClick(int itemIndex, String itemName) {
                Toast.makeText(getActivity().getApplicationContext(), "Ejempllo loadAverage", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemReselected(int itemIndex, String itemName) {
                Toast.makeText(getActivity().getApplicationContext(), "Lista del servicio: http://localhost:8080/api/getAll", Toast.LENGTH_SHORT).show();
            }
        });

        return view;

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        spaceNavigationView.onSaveInstanceState(outState);
    }

    private void getUserListData() {
        // display a progress dialog
        final ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setCancelable(false); // set cancelable to false
        progressDialog.setMessage("Cargando..."); // set message
        progressDialog.show(); // show progress dialog
        try {

            (Api.getClient().getList()).enqueue(new Callback<List<ModelService2>>() {
                @Override
                public void onResponse(Call<List<ModelService2>> call, Response<List<ModelService2>> response) {
                      //Log.d("responseGET", response.body().getMessage().get(0));
                    progressDialog.dismiss(); //dismiss progress dialog
                    //estado.setText(response.body().getStatus());
                    modelData = response.body();
                    setDataInRecyclerView();
                }

                @Override
                public void onFailure(Call<List<ModelService2>> call, Throwable t) {
                    // if error occurs in network transaction then we can get the error in this method.
                    Toast.makeText(getActivity(), t.toString(), Toast.LENGTH_LONG).show();
                    progressDialog.dismiss(); //dismiss progress dialog
                }
            });
        }catch (Exception e){
            Toast.makeText(getActivity(), ""+e, Toast.LENGTH_LONG).show();
            Log.d("ERROR===========", ""+e);
        }
    }

    private void setDataInRecyclerView() {
        // set a LinearLayoutManager with default vertical orientation
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        // call the constructor of PresenterAdapter to send the reference and data to Adapter
        PresenterAdapter presenterAdapter = new PresenterAdapter(getActivity(), modelData);
        recyclerView.setAdapter(presenterAdapter); // set the Adapter to RecyclerView

    }

}
