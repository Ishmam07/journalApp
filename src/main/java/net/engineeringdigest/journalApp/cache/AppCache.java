package net.engineeringdigest.journalApp.cache;

import jakarta.annotation.PostConstruct;
import net.engineeringdigest.journalApp.entity.ConfigJournalAppEntity;
import net.engineeringdigest.journalApp.repository.ConfigJournalAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AppCache {

    public Map<String, String> appCache = new HashMap<>();

    @Autowired
    private ConfigJournalAppRepository configJournalAppRepository;

    @PostConstruct
    public void init() {
        List<ConfigJournalAppEntity> all = configJournalAppRepository.findAll();


        for (ConfigJournalAppEntity e : all) {
            appCache.put(e.getKey(), e.getValue());
        }
    }
}
