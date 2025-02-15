package kr.co.springbootweeklymission.voucher.domain.repository;

import kr.co.springbootweeklymission.voucher.domain.entity.Voucher;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class InMemoryVoucherRepositoryTest {
    InMemoryVoucherRepository voucherRepository;

    @BeforeEach
    void beforeEach() {
        voucherRepository = new InMemoryVoucherRepository();
    }

    @AfterEach
    void afterEach() {
        voucherRepository.deleteAll();
    }

    @Test
    @DisplayName("바우처를_메모리방식으로_저장한다 - SUCCESS")
    void 바우처를_메모리방식으로_저장한다() {
        //given
        Voucher actual = Voucher.builder()
                .voucherId(UUID.randomUUID())
                .build();

        //when
        Voucher expected = voucherRepository.save(actual);

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("바우처를_메모리로부터_조회한다 - SUCCESS")
    void 바우처를_메모리로부터_조회한다() {
        //given
        UUID voucherId = UUID.randomUUID();
        Voucher actual = Voucher.builder().voucherId(voucherId).build();
        voucherRepository.save(actual);

        //when
        Voucher expected = voucherRepository.findById(voucherId).orElse(null);

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("메모리에_저장할_바우처들")
    @DisplayName("저장된_모든_바우처를_메모리로부터_조회한다 - SUCCESS")
    void 저장된_모든_바우처를_메모리로부터_조회한다(List<Voucher> actual) {
        //given
        actual.forEach(voucher -> voucherRepository.save(voucher));

        //when
        List<Voucher> expected = voucherRepository.findAll();

        //then
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }

    private static Stream<Arguments> 메모리에_저장할_바우처들() {
        List<Voucher> vouchers = new ArrayList<>();
        vouchers.add(Voucher.builder().voucherId(UUID.randomUUID()).build());
        vouchers.add(Voucher.builder().voucherId(UUID.randomUUID()).build());
        vouchers.add(Voucher.builder().voucherId(UUID.randomUUID()).build());
        return Stream.of(Arguments.of(vouchers));
    }
}
