package MilitaryElite.interfaces;

import java.util.Collection;

public interface LieutenantGeneral {
    void addPrivate(Private priv);

    Collection<Private> getPrivates();
}
