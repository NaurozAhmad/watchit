package mmstreaming.mmstreaming;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import static mmstreaming.mmstreaming.R.id.content_frame;

public class mainActivity extends AbstractNavDrawerActivity {



    @Override

        protected NavDrawerActivityConfiguration getNavDrawerConfiguration() {
            NavDrawerItem[] menu = new NavDrawerItem[] {
                NavProfile.create(100,"SignIn","@drawable/signin",true,this),
                    NavMenuItem.create(200,"MostRated","@drawable/ic_launcher",true,this),
                NavMenuSection.create( 300, "Categories"),

                    NavMenuItem.create(301, "Entertainment", "@drawable/entertainment", true, this),
                    NavMenuItem.create(302, "Sports", "@drawable/sports", true, this),
                    NavMenuItem.create(303, "Horror", "@drawable/ic_launcher", true, this),
                    NavMenuItem.create(304, "Islamic", "@drawable/islamic", true, this),
                    NavMenuItem.create(305, "Dramas", "@drawable/dramas", true, this),
                    NavMenuItem.create(306, "Animated", "@drawable/animated", true, this),
                NavMenuSection.create(400, "Others"),

                   NavMenuItem.create(401, "SignOut", "@drawable/ic_launcher", true, this)};




            NavDrawerActivityConfiguration navDrawerActivityConfiguration = new NavDrawerActivityConfiguration();
            navDrawerActivityConfiguration.setMainLayout(R.layout.activity_main);
            navDrawerActivityConfiguration.setDrawerLayoutId(R.id.drawer_layout);
            navDrawerActivityConfiguration.setLeftDrawerId(R.id.left_drawer);
            navDrawerActivityConfiguration.setNavItems(menu);
            navDrawerActivityConfiguration.setDrawerShadow(R.drawable.drawer_shadow);
            navDrawerActivityConfiguration.setDrawerOpenDesc(R.string.drawer_open);
            navDrawerActivityConfiguration.setDrawerCloseDesc(R.string.drawer_close);
            navDrawerActivityConfiguration.setBaseAdapter(
                    new NavDrawerAdapter(this, R.layout.navdraweritem, menu ));
            return navDrawerActivityConfiguration;
        }




    @Override
    protected void onNavItemSelected(int id) {
        switch ((int)id) {
            case 100:
                getSupportFragmentManager().beginTransaction().replace(content_frame, new SignIn()).commit();
                break;
            case 200:
                getSupportFragmentManager().beginTransaction().replace(content_frame, new MostRated()).commit();
                break;
            case 301:
                getSupportFragmentManager().beginTransaction().replace(content_frame, new Entertainment()).commit();
                break;
            case 302:
                getSupportFragmentManager().beginTransaction().replace(content_frame, new Sports()).commit();
                break;
            case 303:
                getSupportFragmentManager().beginTransaction().replace(content_frame, new Horror()).commit();
                break;
            case 304:
                getSupportFragmentManager().beginTransaction().replace(content_frame, new Islamic()).commit();
                break;
            case 305:
                getSupportFragmentManager().beginTransaction().replace(content_frame, new Dramas()).commit();
                break;
            case 306:
                getSupportFragmentManager().beginTransaction().replace(content_frame, new Animated()).commit();
                break;

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //  setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, new home()).commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
       if (id == R.id.action_search) {
       return true;
       }
        return super.onOptionsItemSelected(item);
    }
}
