package org.invoice.style;

import lombok.RequiredArgsConstructor;
import org.invoice.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static org.invoice.exception.ErrorType.STYLE_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class StyleService {

  private final StyleRepository repository;
  
  public Style save(Style style) {
    return repository.save(style);
  }

  public Style findById(UUID id) throws NotFoundException {
    return repository.findById(id).orElseThrow(() -> new NotFoundException(STYLE_NOT_FOUND, id));
  }

  public void delete(UUID id) {
    repository.deleteById(id);
  }
}
