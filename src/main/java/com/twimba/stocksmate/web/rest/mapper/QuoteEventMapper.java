package com.twimba.stocksmate.web.rest.mapper;

import com.twimba.stocksmate.domain.*;
import com.twimba.stocksmate.web.rest.dto.QuoteEventDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity QuoteEvent and its DTO QuoteEventDTO.
 */
@Mapper(uses = {})
public interface QuoteEventMapper {

    QuoteEventDTO quoteEventToQuoteEventDTO(QuoteEvent quoteEvent);

    QuoteEvent quoteEventDTOToQuoteEvent(QuoteEventDTO quoteEventDTO);
}
