package com.example.andopgave.ui.logout;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.andopgave.databinding.FragmentLogoutBinding;
import com.example.andopgave.model.Data.DAO;
import com.example.andopgave.ui.login.Login;

public class logout extends Fragment {

    
    private LogoutViewModel mViewModel;
    private Button btn_Logout;
    private FragmentLogoutBinding binding;
    private Object logout;

    public static logout newInstance() {
        return new logout();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(this).get(LogoutViewModel.class);
        binding = FragmentLogoutBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        mViewModel.mAuth = DAO.getmAuth();
        bindings();
        onClickListeners();

        return root;
    }

    private void bindings() {
        btn_Logout = binding.BtnLogOut;
    }

    private void onClickListeners() {
        btn_Logout.setOnClickListener(view -> {
            mViewModel.logout();
            Toast.makeText(getContext(), "Bla",Toast.LENGTH_SHORT).show();
            startActivity(new Intent (getActivity(), Login.class));
        });

    }


}