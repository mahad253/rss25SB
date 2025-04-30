package fr.univrouen.rss25SB.model;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAccessType;

@XmlRootElement(name = "item")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Item {

    private String guid;
    private String title;
    private String published;

    public Item() {}

    public Item(String guid, String title, String published) {
        this.guid = guid;
        this.title = title;
        this.published = published;
    }

    @XmlAttribute
    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    @XmlElement
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @XmlElement
    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    @Override
    public String toString() {
        return "Article : " + title + "\n(" + guid + ") Le = " + published;
    }
}
