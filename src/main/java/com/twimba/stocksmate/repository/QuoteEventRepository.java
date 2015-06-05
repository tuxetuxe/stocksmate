package com.twimba.stocksmate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.twimba.stocksmate.domain.QuoteEvent;

/**
 * Spring Data JPA repository for the QuoteEvent entity.
 */
public interface QuoteEventRepository extends JpaRepository<QuoteEvent,Long> {

}
