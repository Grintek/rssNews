package rss.spring.news.component;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import rss.spring.news.domain.Rss;
import rss.spring.news.repos.RssRepository;
import rss.spring.news.service.InputRss;

import java.io.IOException;
import java.net.URL;

@Component
public class RssComponent {
    @Autowired
    private RssRepository rssRepo;

    @Scheduled(cron = "0 0 * * * ?")
    public void getRss() {
        SyndFeedInput input = new SyndFeedInput();
        try {
            URL feedSource = new URL("https://habr.com/ru/rss/best/daily/?fl=ru");
            SyndFeed feed = input.build(new XmlReader(feedSource));

            for (SyndEntry entry : feed.getEntries()) {
                Rss rss = new Rss(entry.getTitle(), entry.getDescription().getValue(),
                        entry.getLink(), entry.getPublishedDate());
                entry.getDescription().getValue();
                if(rssRepo.findByLink(rss.getLink()) == null){
                    rssRepo.save(rss);
                }
            }
        } catch (FeedException | IOException e) {
            e.printStackTrace();
        }
    }
}
