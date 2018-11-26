package cn.videon.meeting.voice.service.mapper;

import cn.videon.meeting.voice.domain.*;
import cn.videon.meeting.voice.service.dto.ModificationDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Modification and its DTO ModificationDTO.
 */
@Mapper(componentModel = "spring", uses = {UserMapper.class, MeetingMapper.class})
public interface ModificationMapper extends EntityMapper<ModificationDTO, Modification> {

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "meeting.id", target = "meetingId")
    ModificationDTO toDto(Modification modification);

    @Mapping(source = "userId", target = "user")
    @Mapping(source = "meetingId", target = "meeting")
    Modification toEntity(ModificationDTO modificationDTO);

    default Modification fromId(Long id) {
        if (id == null) {
            return null;
        }
        Modification modification = new Modification();
        modification.setId(id);
        return modification;
    }
}
