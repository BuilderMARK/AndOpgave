package com.example.andopgave.ui.logout;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.andopgave.R;
import com.example.andopgave.databinding.FragmentLogoutBinding;
import com.example.andopgave.model.Data.DAO;
import com.example.andopgave.ui.createCar.CreateCarViewModelImpl;
import com.google.firebase.auth.FirebaseAuth;

public class logout extends Fragment {

    private LogoutViewModel mViewModel;
    private Button btn_Logout;
    FirebaseAuth mAuth;
    private FragmentLogoutBinding binding;

    public static logout newInstance() {
        return new logout();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(this).get(LogoutViewModel.class);
        binding = FragmentLogoutBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        mAuth = DAO.getmAuth();
        bindings();
        onClickListeners();

        return root;
    }

    private void bindings() {
        btn_Logout = binding.BtnLogOut;
    }
    private void logout1() {
        mAuth.signOut();
        System.out.println("User logged out");
    }

    private void onClickListeners() {
        btn_Logout.setOnClickListener(view -> {
            System.out.println("Virker jeg");
          logout1();
          Navigation.findNavController(view).navigate(R.id.nav_dashBoard);
        });

    }


}