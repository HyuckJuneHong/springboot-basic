package kr.co.springbootweeklymission.infrastructure.error.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public enum ResponseStatus {
    //fail command
    FAIL_DUPLICATED_KEY("해당 쿠폰은 이미 할당된 쿠폰입니다."),
    FAIL_NOT_FOUND_COMMAND("해당 명령어를 찾을 수 없습니다."),
    FAIL_NOT_SUPPORTED_UPDATE("파일 및 메모리 저장소에서 수정 기능은 지원하지 않습니다."),
    FAIL_NOT_SUPPORTED_DELETE("파일 및 메모리 저장소에서 삭제 기능은 지원하지 않습니다."),
    FAIL_NOT_SUPPORTED_SAVE("파일 및 메모리 저장소에서 저장 기능은 지원하지 않습니다."),
    FAIL_NOT_SUPPORTED_READ("파일 및 메모리 저장소에서 조회 기능은 지원하지 않습니다."),

    //fail member
    FAIL_NOT_FOUND_BLACK_MEMBER("I/O 문제로 블랙 회원이 조회되지 않았습니다."),
    FAIL_NOT_FOUND_MEMBER("해당 회원을 찾을 수 없습니다."),

    //fail Voucher
    FAIL_WRONG_DISCOUNT("할인전 가격보다 할인 가격이 더 클 수 없습니다."),
    FAIL_NOT_FOUND_VOUCHER("해당 바우처를 찾을 수 없습니다."),
    FAIL_NOT_FOUND_VOUCHER_POLICY("해당 할인 정책을 찾을 수 없습니다."),
    FAIL_IO_NOT_FOUND_VOUCHER("I/O 문제로 바우처가 저장되지 않았습니다."),
    FAIL_IO_NOT_SAVE_VOUCHER("I/O 문제로 바우처가 조회되지 않았습니다."),

    //fail Wallet
    FAIL_NOT_FOUND_WALLET("해당 지갑을 찾을 수 없습니다."),
    ;

    private String message;
}
