package kr.co.springbootweeklymission.member.domain.entity;

import kr.co.springbootweeklymission.member.api.dto.request.MemberReqDTO;
import kr.co.springbootweeklymission.member.domain.model.MemberStatus;
import lombok.*;

import java.util.UUID;

@Getter
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Member {
    private UUID memberId;
    private MemberStatus memberStatus;

    @Builder
    private Member(UUID memberId,
                   MemberStatus memberStatus) {
        this.memberId = memberId;
        this.memberStatus = memberStatus;
    }

    public static Member toMember(MemberReqDTO.CREATE create) {
        return Member.builder()
                .memberId(UUID.randomUUID())
                .memberStatus(create.getMemberStatus())
                .build();
    }

    public boolean isBlackMember() {
        return this.memberStatus == MemberStatus.BLACK;
    }

    public void updateMemberInformation(MemberReqDTO.UPDATE update) {
        this.memberStatus = update.getMemberStatus();
    }
}
