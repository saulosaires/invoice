package org.invoice.style;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StyleMapper {

  StyleDto toDto(Style style);

  Style fromDto(StyleDto dto);
}
