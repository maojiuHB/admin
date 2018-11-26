package cn.videon.meeting.voice.service.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A DTO for the UserLevel entity.
 */
public class UserLevelDTO implements Serializable {

    private Long id;

    private Long userId;

    private Set<LevelDTO> levels = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Set<LevelDTO> getLevels() {
        return levels;
    }

    public void setLevels(Set<LevelDTO> levels) {
        this.levels = levels;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UserLevelDTO userLevelDTO = (UserLevelDTO) o;
        if (userLevelDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), userLevelDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "UserLevelDTO{" +
            "id=" + getId() +
            ", user=" + getUserId() +
            "}";
    }
}
