package com.project.date.dto.response;

import com.project.date.dto.request.ChatMessageDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageResponseDto {
    private String roomId;
    private String message;
    private String createdAt;
    private Long otherMemberId;
    private Long userId;

    public MessageResponseDto(ChatMessageDto roomMessage) {

        this.roomId = roomMessage.getRoomId();
        this.message = roomMessage.getMessage();
        this.createdAt = roomMessage.getCreatedAt();
        this.otherMemberId = roomMessage.getOtherMemberId();
        this.userId = roomMessage.getUserId();
    }
}
