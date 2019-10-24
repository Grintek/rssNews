package rss.spring.news.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import rss.spring.news.domain.Rss;

public interface RssRepository extends JpaRepository<Rss, Long> {
    Rss findByLink(String link);
}
