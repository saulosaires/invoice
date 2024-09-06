package org.invoice.common;

import java.util.List;

public record InvoicePage<T>(

        List<T> content,
        Pageable pageable,
        boolean last,
        int totalPages,
        long totalElements,
        int size,
        int number,
        boolean first,
        int numberOfElements,
        boolean empty) {

  public record Pageable(
          int pageNumber,
          int pageSize,
          long offset,
          boolean unpaged,
          boolean paged
  ) {

  }

}

