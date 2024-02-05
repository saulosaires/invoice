package org.invoice.bank;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.invoice.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class BankFacade {
    private final BankService service;
    private final BankMapper mapper;

    public BankDto save(BankDto bankDto) {
        log.info("BankFacade.save dto:{}", bankDto);

        Bank bank = service.save(mapper.fromDto(bankDto));

        return mapper.toDto(bank);
    }

    public List<BankDto> findByUser() {
        return service.findByUserId().stream().map(mapper::toDto).toList();
    }

    public BankDto findById(UUID id) throws NotFoundException {
        return mapper.toDto(service.findById(id));
    }

    public void delete(UUID id) {
        service.delete(id);
    }
}
