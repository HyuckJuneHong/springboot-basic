package kr.co.springbootweeklymission.voucher.domain.repository;

import kr.co.springbootweeklymission.voucher.domain.entity.Voucher;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryVoucherRepository implements VoucherRepository {
    private static final Map<UUID, Voucher> VOUCHER_MEMORY = new ConcurrentHashMap<>();

    @Override
    public Voucher save(Voucher voucher) {
        VOUCHER_MEMORY.put(voucher.getVoucherId(), voucher);
        return voucher;
    }

    @Override
    public Optional<Voucher> findById(UUID voucherId) {
        return Optional.ofNullable(VOUCHER_MEMORY.get(voucherId));
    }

    @Override
    public List<Voucher> findAll() {
        return VOUCHER_MEMORY.values()
                .stream()
                .toList();
    }

    public void clear() {
        VOUCHER_MEMORY.clear();
    }
}
