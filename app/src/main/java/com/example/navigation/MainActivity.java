package com.example.navigation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ToggleButton;

import com.example.navigation_classwork.R;
import com.example.navigation_classwork.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setupNavigation();
        listeners();
    }

    private void setupNavigation() {
        binding.navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                // Handle navigation item selection here
                int itemId = item.getItemId();
                Fragment fragment;
                switch (itemId) {
                    case R.id.menuDashboard:
                        fragment = new DashboardFragment();
                        break;
                    case R.id.menuPesan:
                        fragment = new PesanFragment();
                        break;
                    case R.id.menuNotifikasi:
                        fragment = new NotifikasiFragment();
                        break;
                    case R.id.menuKalendar:
                        fragment = new KalendarFragment();
                        break;
                    case R.id.menuStatistik:
                        fragment = new StatistikFragment();
                        break;
                    case R.id.menuPengaturan:
                        fragment = new PengaturanFragment();
                        break;
                    default:
                        fragment = null;
                        break;
                }

                if (fragment != null) {
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragmentContainerView, fragment);
                    fragmentTransaction.commit();
                }

                // Close the drawer after item selection
                binding.drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    private void listeners() {
        DrawerLayout drawerLayout = binding.drawerLayout;
        View header = binding.navigationView.getHeaderView(0);
        RadioGroup toggleButtonGroup = header.findViewById(R.id.toggle);


        binding.imageMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        toggleButtonGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                DrawerLayout drawerLayout = binding.drawerLayout;
                View header = binding.navigationView.getHeaderView(0);
                RadioGroup toggleButtonGroup = header.findViewById(R.id.toggle);
                RadioButton checkedButton = (RadioButton) toggleButtonGroup.findViewById(radioGroup.getId());
                checkedButton.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.white));
                for (int j = 0; j < toggleButtonGroup.getChildCount(); j++) {
                    int currentChildID = toggleButtonGroup.getChildAt(j).getId();
                    if (currentChildID != radioGroup.getId()) {
                        RadioButton currentButton = toggleButtonGroup.findViewById(currentChildID);
                        currentButton.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.black));
                    }
                }

            }

        });
    }

}

