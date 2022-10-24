package com.project.date.dto.request;

import com.project.date.dto.response.ChatMessageTestDto;
import com.project.date.model.ChatMessage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessageDto implements Serializable {

    // 메시지 타입 : 입장, 채팅
    public enum MessageType {
        TALK, UNREAD_MESSAGE_COUNT_ALARM, COMMENT_ALARM
    }

    private Long messageId;
    private MessageType type; // 메시지 타입
    private String roomId; // 공통으로 만들어진 방 번호
    private Long otherUserId; // 상대방
    private String nickname;
    private String otherImageUrl;

    @NotBlank
    @Size(max=2000)
    private String message; // 메시지

    private String createdAt;

    private Long userId;
    private int count;

    public ChatMessageDto(ChatMessage chatMessageDto, int count) {
        this.type = MessageType.UNREAD_MESSAGE_COUNT_ALARM; // 메시지 타입
        this.roomId = chatMessageDto.getRoomId(); // 방 이름
        this.otherUserId = chatMessageDto.getOtherUserId(); // 상대방 privateKey
        this.nickname = chatMessageDto.getUser().getNickname();
        this.otherImageUrl = chatMessageDto.getOtherImageUrl();
        this.count = count; //안읽은 메세지 개수
    }
}
