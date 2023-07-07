package kr.co.springbootweeklymission.voucher.domain.repository;

import kr.co.springbootweeklymission.voucher.domain.entity.Voucher;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface VoucherRepository {
    Voucher save(Voucher voucher);

    Optional<Voucher> findById(UUID voucherId);

    List<Voucher> findAll();
}
