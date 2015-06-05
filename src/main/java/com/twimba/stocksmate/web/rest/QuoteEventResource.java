package com.twimba.stocksmate.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.twimba.stocksmate.domain.QuoteEvent;
import com.twimba.stocksmate.repository.QuoteEventRepository;
import com.twimba.stocksmate.repository.search.QuoteEventSearchRepository;
import com.twimba.stocksmate.web.rest.util.PaginationUtil;
import com.twimba.stocksmate.web.rest.dto.QuoteEventDTO;
import com.twimba.stocksmate.web.rest.mapper.QuoteEventMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * REST controller for managing QuoteEvent.
 */
@RestController
@RequestMapping("/api")
public class QuoteEventResource {

    private final Logger log = LoggerFactory.getLogger(QuoteEventResource.class);

    @Inject
    private QuoteEventRepository quoteEventRepository;

    @Inject
    private QuoteEventMapper quoteEventMapper;

    @Inject
    private QuoteEventSearchRepository quoteEventSearchRepository;

    /**
     * POST  /quoteEvents -> Create a new quoteEvent.
     */
    @RequestMapping(value = "/quoteEvents",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<Void> create(@Valid @RequestBody QuoteEventDTO quoteEventDTO) throws URISyntaxException {
        log.debug("REST request to save QuoteEvent : {}", quoteEventDTO);
        if (quoteEventDTO.getId() != null) {
            return ResponseEntity.badRequest().header("Failure", "A new quoteEvent cannot already have an ID").build();
        }
        QuoteEvent quoteEvent = quoteEventMapper.quoteEventDTOToQuoteEvent(quoteEventDTO);
        quoteEventRepository.save(quoteEvent);
        quoteEventSearchRepository.save(quoteEvent);
        return ResponseEntity.created(new URI("/api/quoteEvents/" + quoteEventDTO.getId())).build();
    }

    /**
     * PUT  /quoteEvents -> Updates an existing quoteEvent.
     */
    @RequestMapping(value = "/quoteEvents",
        method = RequestMethod.PUT,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<Void> update(@Valid @RequestBody QuoteEventDTO quoteEventDTO) throws URISyntaxException {
        log.debug("REST request to update QuoteEvent : {}", quoteEventDTO);
        if (quoteEventDTO.getId() == null) {
            return create(quoteEventDTO);
        }
        QuoteEvent quoteEvent = quoteEventMapper.quoteEventDTOToQuoteEvent(quoteEventDTO);
        quoteEventRepository.save(quoteEvent);
        quoteEventSearchRepository.save(quoteEvent);
        return ResponseEntity.ok().build();
    }

    /**
     * GET  /quoteEvents -> get all the quoteEvents.
     */
    @RequestMapping(value = "/quoteEvents",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Transactional(readOnly = true)
    public ResponseEntity<List<QuoteEventDTO>> getAll(@RequestParam(value = "page" , required = false) Integer offset,
                                  @RequestParam(value = "per_page", required = false) Integer limit)
        throws URISyntaxException {
        Page<QuoteEvent> page = quoteEventRepository.findAll(PaginationUtil.generatePageRequest(offset, limit));
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/quoteEvents", offset, limit);
        return new ResponseEntity<>(page.getContent().stream()
            .map(quoteEvent -> quoteEventMapper.quoteEventToQuoteEventDTO(quoteEvent))
            .collect(Collectors.toCollection(LinkedList::new)), headers, HttpStatus.OK);
    }

    /**
     * GET  /quoteEvents/:id -> get the "id" quoteEvent.
     */
    @RequestMapping(value = "/quoteEvents/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<QuoteEventDTO> get(@PathVariable Long id) {
        log.debug("REST request to get QuoteEvent : {}", id);
        return Optional.ofNullable(quoteEventRepository.findOne(id))
            .map(quoteEvent -> quoteEventMapper.quoteEventToQuoteEventDTO(quoteEvent))
            .map(quoteEventDTO -> new ResponseEntity<>(
                quoteEventDTO,
                HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * DELETE  /quoteEvents/:id -> delete the "id" quoteEvent.
     */
    @RequestMapping(value = "/quoteEvents/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public void delete(@PathVariable Long id) {
        log.debug("REST request to delete QuoteEvent : {}", id);
        quoteEventRepository.delete(id);
        quoteEventSearchRepository.delete(id);
    }

    /**
     * SEARCH  /_search/quoteEvents/:query -> search for the quoteEvent corresponding
     * to the query.
     */
    @RequestMapping(value = "/_search/quoteEvents/{query}",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public List<QuoteEvent> search(@PathVariable String query) {
        return StreamSupport
            .stream(quoteEventSearchRepository.search(queryString(query)).spliterator(), false)
            .collect(Collectors.toList());
    }
}
