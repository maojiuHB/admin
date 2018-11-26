package cn.videon.meeting.voice.domain;

import io.swagger.annotations.ApiModel;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * 用户级别中间表
 */
@ApiModel(description = "用户级别中间表")
@Entity
@Table(name = "user_level")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class UserLevel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne    @JoinColumn(unique = true)
    private User user;

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "user_level_level",
               joinColumns = @JoinColumn(name = "user_levels_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "levels_id", referencedColumnName = "id"))
    private Set<Level> levels = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public UserLevel user(User user) {
        this.user = user;
        return this;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Level> getLevels() {
        return levels;
    }

    public UserLevel levels(Set<Level> levels) {
        this.levels = levels;
        return this;
    }

    public UserLevel addLevel(Level level) {
        this.levels.add(level);
        return this;
    }

    public UserLevel removeLevel(Level level) {
        this.levels.remove(level);
        return this;
    }

    public void setLevels(Set<Level> levels) {
        this.levels = levels;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserLevel userLevel = (UserLevel) o;
        if (userLevel.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), userLevel.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "UserLevel{" +
            "id=" + getId() +
            "}";
    }
}
