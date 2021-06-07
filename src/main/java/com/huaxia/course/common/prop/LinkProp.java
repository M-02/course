package com.huaxia.course.common.prop;

import java.util.Objects;

public class LinkProp {

    String menuName;

    String link;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkProp linkProp = (LinkProp) o;
        return Objects.equals(menuName, linkProp.menuName) &&
                Objects.equals(link, linkProp.link);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menuName, link);
    }

    public LinkProp(String menuName, String link) {
        this.menuName = menuName;
        this.link = link;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
