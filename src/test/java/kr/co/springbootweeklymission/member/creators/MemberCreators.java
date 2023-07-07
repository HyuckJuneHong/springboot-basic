package kr.co.springbootweeklymission.member.creators;

import kr.co.springbootweeklymission.member.api.dto.request.MemberReqDTO;
import kr.co.springbootweeklymission.member.domain.entity.Member;
import kr.co.springbootweeklymission.member.domain.model.MemberStatus;

import java.util.UUID;

public class MemberCreators {
    private MemberCreators() {
    }

    public static Member createBlackMember() {
        return Member.builder()
                .memberId(UUID.randomUUID())
                .memberStatus(MemberStatus.BLACK)
                .build();
    }

    public static Member createWhiteMember() {
        return Member.builder()
                .memberId(UUID.randomUUID())
                .memberStatus(MemberStatus.WHITE)
                .build();
    }

    public static Member updateMemberStatus(UUID memberId, MemberStatus memberStatus) {
        return Member.builder()
                .memberId(memberId)
                .memberStatus(memberStatus)
                .build();
    }

    public static MemberReqDTO.CREATE createBlackMemberCreateDTO() {
        return MemberReqDTO.CREATE.builder()
                .memberStatus(MemberStatus.BLACK)
                .build();
    }

    public static MemberReqDTO.UPDATE updateMemberInformation(MemberStatus memberStatus) {
        return MemberReqDTO.UPDATE.builder()
                .memberStatus(memberStatus)
                .build();
    }
}
