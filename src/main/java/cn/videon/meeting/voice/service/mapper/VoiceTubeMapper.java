package cn.videon.meeting.voice.service.mapper;

import cn.videon.meeting.voice.domain.*;
import cn.videon.meeting.voice.service.dto.VoiceTubeDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity VoiceTube and its DTO VoiceTubeDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface VoiceTubeMapper extends EntityMapper<VoiceTubeDTO, VoiceTube> {



    default VoiceTube fromId(Long id) {
        if (id == null) {
            return null;
        }
        VoiceTube voiceTube = new VoiceTube();
        voiceTube.setId(id);
        return voiceTube;
    }
}
