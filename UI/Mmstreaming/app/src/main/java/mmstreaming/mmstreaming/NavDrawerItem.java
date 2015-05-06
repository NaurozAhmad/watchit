package mmstreaming.mmstreaming;

/**
 * Created by Ammo on 5/2/2015.
 */
public interface NavDrawerItem {
    public int getId();
    public String getLabel();
    public int getType();
    public boolean isEnabled();
    public boolean updateActionBarTitle();
}
