package rss.spring.news.domain;

import com.rometools.rome.feed.synd.SyndContent;
import org.hibernate.validator.constraints.SafeHtml;

import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.crypto.Data;
import java.util.Date;

@Entity
public class Rss {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    @Column(columnDefinition = "varchar(20000)")
    private String description;
    private String link;
    @Column(name = "publish_data")
    private Date publishData;

    public Rss() {
    }

    public Rss(String title, String description, String link, Date publishData) {
        this.title = title;
        this.description = description;
        this.link = link;
        this.publishData = publishData;
    }

    public Rss(String title, String link, Date publishData) {
        this.title = title;
        this.link = link;
        this.publishData = publishData;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Date getPublishData() {
        return publishData;
    }

    public void setPublishData(Date publishData) {
        this.publishData = publishData;
    }
}
