package com.twimba.stocksmate.repository.search;

import com.twimba.stocksmate.domain.QuoteEvent;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data ElasticSearch repository for the QuoteEvent entity.
 */
public interface QuoteEventSearchRepository extends ElasticsearchRepository<QuoteEvent, Long> {
}
