package cn.videon.meeting.voice.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

import cn.videon.meeting.voice.domain.enumeration.Status;

/**
 * 会议
 * name：会议名字
 * recorder：记录者
 * compere：主持人
 * participator：参会人
 * startTime：开始时间
 * endTime：结束时间
 * result：会议结果
 * voiceInfo：话筒信息
 * level：会议级别
 * type：会议类型
 */
@ApiModel(description = "会议 name：会议名字 recorder：记录者 compere：主持人 participator：参会人 startTime：开始时间 endTime：结束时间 result：会议结果 voiceInfo：话筒信息 level：会议级别 type：会议类型")
@Entity
@Table(name = "meeting")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Meeting implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "recorder")
    private String recorder;

    @Column(name = "compere")
    private String compere;

    @Column(name = "participator")
    private String participator;

    @Column(name = "start_time")
    private Instant startTime;

    @Column(name = "end_time")
    private Instant endTime;

    @Column(name = "result")
    private String result;

    @Column(name = "voice_info")
    private String voiceInfo;

    @Column(name = "vn_level")
    private String level;

    @Column(name = "vn_type")
    private String type;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @ManyToOne
    @JsonIgnoreProperties("")
    private MeetingRoom meetingRoom;

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "meeting_meeting_room_function",
               joinColumns = @JoinColumn(name = "meetings_id", referencedColumnName = "id"),
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

    public Meeting name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRecorder() {
        return recorder;
    }

    public Meeting recorder(String recorder) {
        this.recorder = recorder;
        return this;
    }

    public void setRecorder(String recorder) {
        this.recorder = recorder;
    }

    public String getCompere() {
        return compere;
    }

    public Meeting compere(String compere) {
        this.compere = compere;
        return this;
    }

    public void setCompere(String compere) {
        this.compere = compere;
    }

    public String getParticipator() {
        return participator;
    }

    public Meeting participator(String participator) {
        this.participator = participator;
        return this;
    }

    public void setParticipator(String participator) {
        this.participator = participator;
    }

    public Instant getStartTime() {
        return startTime;
    }

    public Meeting startTime(Instant startTime) {
        this.startTime = startTime;
        return this;
    }

    public void setStartTime(Instant startTime) {
        this.startTime = startTime;
    }

    public Instant getEndTime() {
        return endTime;
    }

    public Meeting endTime(Instant endTime) {
        this.endTime = endTime;
        return this;
    }

    public void setEndTime(Instant endTime) {
        this.endTime = endTime;
    }

    public String getResult() {
        return result;
    }

    public Meeting result(String result) {
        this.result = result;
        return this;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getVoiceInfo() {
        return voiceInfo;
    }

    public Meeting voiceInfo(String voiceInfo) {
        this.voiceInfo = voiceInfo;
        return this;
    }

    public void setVoiceInfo(String voiceInfo) {
        this.voiceInfo = voiceInfo;
    }

    public String getLevel() {
        return level;
    }

    public Meeting level(String level) {
        this.level = level;
        return this;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getType() {
        return type;
    }

    public Meeting type(String type) {
        this.type = type;
        return this;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Status getStatus() {
        return status;
    }

    public Meeting status(Status status) {
        this.status = status;
        return this;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public MeetingRoom getMeetingRoom() {
        return meetingRoom;
    }

    public Meeting meetingRoom(MeetingRoom meetingRoom) {
        this.meetingRoom = meetingRoom;
        return this;
    }

    public void setMeetingRoom(MeetingRoom meetingRoom) {
        this.meetingRoom = meetingRoom;
    }

    public Set<MeetingRoomFunction> getMeetingRoomFunctions() {
        return meetingRoomFunctions;
    }

    public Meeting meetingRoomFunctions(Set<MeetingRoomFunction> meetingRoomFunctions) {
        this.meetingRoomFunctions = meetingRoomFunctions;
        return this;
    }

    public Meeting addMeetingRoomFunction(MeetingRoomFunction meetingRoomFunction) {
        this.meetingRoomFunctions.add(meetingRoomFunction);
        return this;
    }

    public Meeting removeMeetingRoomFunction(MeetingRoomFunction meetingRoomFunction) {
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
        Meeting meeting = (Meeting) o;
        if (meeting.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), meeting.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Meeting{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", recorder='" + getRecorder() + "'" +
            ", compere='" + getCompere() + "'" +
            ", participator='" + getParticipator() + "'" +
            ", startTime='" + getStartTime() + "'" +
            ", endTime='" + getEndTime() + "'" +
            ", result='" + getResult() + "'" +
            ", voiceInfo='" + getVoiceInfo() + "'" +
            ", level='" + getLevel() + "'" +
            ", type='" + getType() + "'" +
            ", status='" + getStatus() + "'" +
            "}";
    }
}
