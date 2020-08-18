package com.example.rest2.ui.Menu.Principal.Servicio_1;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.rest2.R;
import com.example.rest2.model.Model;
import com.example.rest2.service.Api;
import com.luseen.spacenavigation.SpaceItem;
import com.luseen.spacenavigation.SpaceNavigationView;
import com.luseen.spacenavigation.SpaceOnClickListener;

import java.util.List;

import link.fls.swipestack.SwipeStack;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PrincipalFragment extends Fragment {
    RecyclerView recyclerView;
    ImageView imagen;
    List<Model> modelAbonosData;
    Model m;
    SpaceNavigationView spaceNavigationView;
    SwipeStack swipeStack;
    AppCompatTextView estado;

    public PrincipalFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.principal_fragment, container, false);

        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerView);
        imagen = (ImageView) view.findViewById(R.id.imagen);
        estado = (AppCompatTextView) view.findViewById(R.id.headerText);
        spaceNavigationView = (SpaceNavigationView) view.findViewById(R.id.space);
        spaceNavigationView.initWithSaveInstanceState(savedInstanceState);
        spaceNavigationView.addSpaceItem(new SpaceItem("Acerca de", R.drawable.acerca));
        spaceNavigationView.addSpaceItem(new SpaceItem("Información", R.drawable.info));
        spaceNavigationView.setCentreButtonIcon(R.drawable.loading);
        //getUserListData();
        spaceNavigationView.setSpaceOnClickListener(new SpaceOnClickListener() {
            @Override
            public void onCentreButtonClick() {
                //getUserListData();
                     }

            @Override
            public void onItemClick(int itemIndex, String itemName) {
                Toast.makeText(getActivity().getApplicationContext(), "Desarrollado por omar lorenzine", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemReselected(int itemIndex, String itemName) {
                Toast.makeText(getActivity().getApplicationContext(), "Lista del servicio: https://dog.ceo/api/breeds/image/random", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        spaceNavigationView.onSaveInstanceState(outState);
    }

    /*private void getUserListData() {
        // display a progress dialog
        final ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setCancelable(false); // set cancelable to false
        progressDialog.setMessage("Please Wait"); // set message
        progressDialog.show(); // show progress dialog
        try {
            (Api.getClient().getimage()).enqueue(new Callback<Model>() {
                @Override
                public void onResponse(Call<Model> call, Response<Model> response) {
                      Log.d("responseGET", response.body().getStatus());
                    progressDialog.dismiss(); //dismiss progress dialog
                    PresenterPrincipal ps = new PresenterPrincipal();
                    Glide.with(getActivity())
                            .load(response.body().getMessage())
                            .error(R.drawable.error)
                            .placeholder(R.drawable.placeholder)
                            .into(imagen);
                   // imagen.setImageBitmap( ps.descargarImagen(response.body().getMessage()));
                    estado.setText(response.body().getStatus());
                }

                @Override
                public void onFailure(Call<Model> call, Throwable t) {
                    // if error occurs in network transaction then we can get the error in this method.
                    Toast.makeText(getActivity(), t.toString(), Toast.LENGTH_LONG).show();
                    progressDialog.dismiss(); //dismiss progress dialog
                }
            });
        }catch (Exception e){
            Toast.makeText(getActivity(), ""+e, Toast.LENGTH_LONG).show();
            Log.d("ERROR===========", ""+e);
        }
    }*/

}
