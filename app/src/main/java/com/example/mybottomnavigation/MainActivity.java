package com.example.mybottomnavigation;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
	
	private TextView mTextMessage;
	
	private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
		
		Fragment fragment;
		
		@Override
		public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
			switch(menuItem.getItemId()){
				case R.id.navigation_home:
					// tampilkan halaman home
					fragment = new HomeFragment();
					getSupportFragmentManager().beginTransaction()
						.replace(R.id.container_layout, fragment, fragment.getClass().getSimpleName())
						.commit();
					return true;
				case R.id.navigation_dashboard:
					// tampilkan halaman dashboard
					fragment = new DashboardFragment();
					getSupportFragmentManager().beginTransaction()
						.replace(R.id.container_layout, fragment, fragment.getClass().getSimpleName())
						.commit();
					return true;
				case R.id.navigation_notifications:
					// tampilkan halaman notifications
					fragment = new NotificationsFragment();
					getSupportFragmentManager().beginTransaction()
						.replace(R.id.container_layout, fragment, fragment.getClass().getSimpleName())
						.commit();
					return true;
			}
			return false;
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
		navigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener); // Digunakan untuk memberikan aksi ke BottomNavigationView
		
		if(savedInstanceState == null){
			navigation.setSelectedItemId(R.id.navigation_home); // Set bottom navigation view default selected item
		}
	}
}
