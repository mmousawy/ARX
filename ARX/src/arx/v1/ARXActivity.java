package arx.v1;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;

public class ARXActivity extends TabActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Resources res = getResources(); // Resource object to get Drawables
        TabHost tabHost = getTabHost();  // The activity TabHost
        TabHost.TabSpec spec;  // Resusable TabSpec for each tab
        Intent intent;  // Reusable Intent for each tab

        // Create an Intent to launch an Activity for the tab (to be reused)
        intent = new Intent().setClass(this, ARX_main_activity.class);

        // Initialize a TabSpec for each tab and add it to the TabHost
        spec = tabHost.newTabSpec("main").setIndicator("AR",
                          res.getDrawable(R.drawable.ic_tab_main))
                      .setContent(intent);
        tabHost.addTab(spec);

        // Do the same for the other tabs
        intent = new Intent().setClass(this, ARX_game_activity.class);
        spec = tabHost.newTabSpec("game").setIndicator("Game",
                          res.getDrawable(R.drawable.ic_tab_game))
                      .setContent(intent);
        tabHost.addTab(spec);

        intent = new Intent().setClass(this, ARX_map_activity.class);
        spec = tabHost.newTabSpec("map").setIndicator("Map",
                          res.getDrawable(R.drawable.ic_tab_map))
                      .setContent(intent);
        tabHost.addTab(spec);

        tabHost.setCurrentTab(2);
    }
}