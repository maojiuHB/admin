package cn.videon.meeting.voice.config;

import java.time.Duration;

import cn.videon.meeting.voice.domain.Authority;
import cn.videon.meeting.voice.domain.User;
import cn.videon.meeting.voice.repository.UserRepository;
import org.ehcache.config.builders.*;
import org.ehcache.jsr107.Eh107Configuration;

import io.github.jhipster.config.jcache.BeanClassLoaderAwareJCacheRegionFactory;
import io.github.jhipster.config.JHipsterProperties;

import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.*;

@Configuration
@EnableCaching
public class CacheConfiguration {

    private final javax.cache.configuration.Configuration<Object, Object> jcacheConfiguration;

    public CacheConfiguration(JHipsterProperties jHipsterProperties) {
        BeanClassLoaderAwareJCacheRegionFactory.setBeanClassLoader(this.getClass().getClassLoader());
        JHipsterProperties.Cache.Ehcache ehcache =
            jHipsterProperties.getCache().getEhcache();

        jcacheConfiguration = Eh107Configuration.fromEhcacheCacheConfiguration(
            CacheConfigurationBuilder.newCacheConfigurationBuilder(Object.class, Object.class,
                ResourcePoolsBuilder.heap(ehcache.getMaxEntries()))
                .withExpiry(ExpiryPolicyBuilder.timeToLiveExpiration(Duration.ofSeconds(ehcache.getTimeToLiveSeconds())))
                .build());
    }

    @Bean
    public JCacheManagerCustomizer cacheManagerCustomizer() {
        return cm -> {
            cm.createCache(UserRepository.USERS_BY_LOGIN_CACHE, jcacheConfiguration);
            cm.createCache(User.class.getName(), jcacheConfiguration);
            cm.createCache(Authority.class.getName(), jcacheConfiguration);
            cm.createCache(User.class.getName() + ".authorities", jcacheConfiguration);
            cm.createCache(cn.videon.meeting.voice.domain.MeetingRoom.class.getName(), jcacheConfiguration);
            cm.createCache(cn.videon.meeting.voice.domain.MeetingRoom.class.getName() + ".meetings", jcacheConfiguration);
            cm.createCache(cn.videon.meeting.voice.domain.MeetingRoom.class.getName() + ".meetingRoomFunctions", jcacheConfiguration);
            cm.createCache(cn.videon.meeting.voice.domain.Meeting.class.getName(), jcacheConfiguration);
            cm.createCache(cn.videon.meeting.voice.domain.Meeting.class.getName() + ".meetingRoomFunctions", jcacheConfiguration);
            cm.createCache(cn.videon.meeting.voice.domain.DataDictionary.class.getName(), jcacheConfiguration);
            cm.createCache(cn.videon.meeting.voice.domain.Level.class.getName(), jcacheConfiguration);
            cm.createCache(cn.videon.meeting.voice.domain.UserLevel.class.getName(), jcacheConfiguration);
            cm.createCache(cn.videon.meeting.voice.domain.UserLevel.class.getName() + ".levels", jcacheConfiguration);
            cm.createCache(cn.videon.meeting.voice.domain.MeetingRoomFunction.class.getName(), jcacheConfiguration);
            cm.createCache(cn.videon.meeting.voice.domain.Modification.class.getName(), jcacheConfiguration);
            cm.createCache(cn.videon.meeting.voice.domain.VoiceTube.class.getName(), jcacheConfiguration);
            cm.createCache(cn.videon.meeting.voice.domain.Word.class.getName(), jcacheConfiguration);
            // jhipster-needle-ehcache-add-entry
        };
    }
}
