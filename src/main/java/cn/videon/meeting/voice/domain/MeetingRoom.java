package cn.videon.meeting.voice.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

import cn.videon.meeting.voice.domain.enumeration.Status;

/**
 * 会议室
 * name：会议室名称
 * maxPeople：最大人数
 * imageUrl：会议室图片
 * status：会议室状态
 */
@ApiModel(description = "会议室 name：会议室名称 maxPeople：最大人数 imageUrl：会议室图片 status：会议室状态")
@Entity
@Table(name = "meeting_room")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class MeetingRoom implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "max_people")
    private Integer maxPeople;

    @Column(name = "image_url")
    private String imageUrl;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @ManyToOne
    @JsonIgnoreProperties("")
    private Level level;

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "meeting_room_meeting_room_function",
               joinColumns = @JoinColumn(name = "meeting_rooms_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "meeting_room_functions_id", referencedColumnName = "id"))
    private Set<MeetingRoomFunction> meetingRoomFunctions = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public MeetingRoom name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMaxPeople() {
        return maxPeople;
    }

    public MeetingRoom maxPeople(Integer maxPeople) {
        this.maxPeople = maxPeople;
        return this;
    }

    public void setMaxPeople(Integer maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public MeetingRoom imageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Status getStatus() {
        return status;
    }

    public MeetingRoom status(Status status) {
        this.status = status;
        return this;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Level getLevel() {
        return level;
    }

    public MeetingRoom level(Level level) {
        this.level = level;
        return this;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Set<MeetingRoomFunction> getMeetingRoomFunctions() {
        return meetingRoomFunctions;
    }

    public MeetingRoom meetingRoomFunctions(Set<MeetingRoomFunction> meetingRoomFunctions) {
        this.meetingRoomFunctions = meetingRoomFunctions;
        return this;
    }

    public MeetingRoom addMeetingRoomFunction(MeetingRoomFunction meetingRoomFunction) {
        this.meetingRoomFunctions.add(meetingRoomFunction);
        return this;
    }

    public MeetingRoom removeMeetingRoomFunction(MeetingRoomFunction meetingRoomFunction) {
        this.meetingRoomFunctions.remove(meetingRoomFunction);
        return this;
    }

    public void setMeetingRoomFunctions(Set<MeetingRoomFunction> meetingRoomFunctions) {
        this.meetingRoomFunctions = meetingRoomFunctions;
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
        MeetingRoom meetingRoom = (MeetingRoom) o;
        if (meetingRoom.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), meetingRoom.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "MeetingRoom{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", maxPeople=" + getMaxPeople() +
            ", imageUrl='" + getImageUrl() + "'" +
            ", status='" + getStatus() + "'" +
            "}";
    }
}
