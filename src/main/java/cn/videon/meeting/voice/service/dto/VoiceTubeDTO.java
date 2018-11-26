package cn.videon.meeting.voice.service.dto;

import java.io.Serializable;
import java.util.Objects;
import cn.videon.meeting.voice.domain.enumeration.Status;

/**
 * A DTO for the VoiceTube entity.
 */
public class VoiceTubeDTO implements Serializable {

    private Long id;

    private String name;

    private String ip;

    private Status status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        VoiceTubeDTO voiceTubeDTO = (VoiceTubeDTO) o;
        if (voiceTubeDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), voiceTubeDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "VoiceTubeDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", ip='" + getIp() + "'" +
            ", status='" + getStatus() + "'" +
            "}";
    }
}
