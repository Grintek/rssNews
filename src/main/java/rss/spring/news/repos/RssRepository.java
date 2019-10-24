package rss.spring.news.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import rss.spring.news.domain.Rss;

import java.util.List;

public interface RssRepository extends JpaRepository<Rss, Long> {
    public Rss findByLink(String link);

    public List<Rss> findAllByOrderByPublishDataDesc();
}
