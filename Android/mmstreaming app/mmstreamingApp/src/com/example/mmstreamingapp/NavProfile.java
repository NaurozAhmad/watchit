package com.example.mmstreamingapp;

import android.content.Context;

/**
 * Created by Ammo on 5/2/2015.
 */
public class NavProfile  implements NavDrawerItem {
    public static final int PROFILE_TYPE = 2;

    private int id ;
    private String label ;
    private int icon ;
    private boolean updateActionBarTitle ;

    private NavProfile() {
    }

    public static NavProfile create( int id, String label, String icon, boolean updateActionBarTitle, Context context ) {
        NavProfile profile = new NavProfile();
        profile.setId(id);
        profile.setLabel(label);
        profile.setIcon(context.getResources().getIdentifier( icon, "drawable", context.getPackageName()));
        profile.setUpdateActionBarTitle(updateActionBarTitle);
        return profile;
    }

    @Override
    public int getType() {
        return PROFILE_TYPE;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) 
    {
        this.label = label;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean updateActionBarTitle() {
        return this.updateActionBarTitle;
    }

    public void setUpdateActionBarTitle(boolean updateActionBarTitle) {
        this.updateActionBarTitle = updateActionBarTitle;
    }
}
