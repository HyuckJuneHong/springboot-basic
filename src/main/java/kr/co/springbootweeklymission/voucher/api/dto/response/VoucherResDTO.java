package kr.co.springbootweeklymission.voucher.api.dto.response;

import kr.co.springbootweeklymission.voucher.domain.model.VoucherPolicy;
import lombok.*;

import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class VoucherResDTO {
    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class READ {
        private UUID voucherId;
        private int amount;
        private VoucherPolicy voucherPolicy;
    }

    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class FILE {
        private UUID voucherId;
        private int amount;
        private VoucherPolicy voucherPolicy;
    }
}
