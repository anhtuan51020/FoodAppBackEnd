package com.kma.food.web.rest;

import com.kma.food.repository.OrderDetailRepository;
import com.kma.food.service.OrderDetailService;
import com.kma.food.service.dto.OrderDetailDTO;
import com.kma.food.web.rest.errors.BadRequestAlertException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;
import java.util.Optional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link com.kma.food.domain.OrderDetail}.
 */
@RestController
@RequestMapping("/api")
public class OrderDetailResource {

    private final Logger log = LoggerFactory.getLogger(OrderDetailResource.class);

    private static final String ENTITY_NAME = "orderDetails";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final OrderDetailService orderDetailsService;

    private final OrderDetailRepository orderDetailsRepository;

    public OrderDetailResource(OrderDetailService orderDetailsService, OrderDetailRepository orderDetailsRepository) {
        this.orderDetailsService = orderDetailsService;
        this.orderDetailsRepository = orderDetailsRepository;
    }

    /**
     * {@code POST  /order-detail} : Create a new orderDetails.
     *
     * @param orderDetailsDTO the orderDetailsDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new orderDetailsDTO, or with status {@code 400 (Bad Request)} if the orderDetails has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/order-detail")
    public ResponseEntity<OrderDetailDTO> createOrderDetail(@Valid @RequestBody OrderDetailDTO orderDetailsDTO) throws URISyntaxException {
        log.debug("REST request to save OrderDetail : {}", orderDetailsDTO);
        if (orderDetailsDTO.getId() != null) {
            throw new BadRequestAlertException("A new orderDetails cannot already have an ID", ENTITY_NAME, "idexists");
        }
        OrderDetailDTO result = orderDetailsService.save(orderDetailsDTO);
        return ResponseEntity
            .created(new URI("/api/order-detail/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /order-detail/:id} : Updates an existing orderDetails.
     *
     * @param id the id of the orderDetailsDTO to save.
     * @param orderDetailsDTO the orderDetailsDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated orderDetailsDTO,
     * or with status {@code 400 (Bad Request)} if the orderDetailsDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the orderDetailsDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/order-detail/{id}")
    public ResponseEntity<OrderDetailDTO> updateOrderDetail(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody OrderDetailDTO orderDetailsDTO
    ) throws URISyntaxException {
        log.debug("REST request to update OrderDetail : {}, {}", id, orderDetailsDTO);
        if (orderDetailsDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, orderDetailsDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!orderDetailsRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        OrderDetailDTO result = orderDetailsService.save(orderDetailsDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, orderDetailsDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /order-detail/:id} : Partial updates given fields of an existing orderDetails, field will ignore if it is null
     *
     * @param id the id of the orderDetailsDTO to save.
     * @param orderDetailsDTO the orderDetailsDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated orderDetailsDTO,
     * or with status {@code 400 (Bad Request)} if the orderDetailsDTO is not valid,
     * or with status {@code 404 (Not Found)} if the orderDetailsDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the orderDetailsDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/order-detail/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<OrderDetailDTO> partialUpdateOrderDetail(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody OrderDetailDTO orderDetailsDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update OrderDetail partially : {}, {}", id, orderDetailsDTO);
        if (orderDetailsDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, orderDetailsDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!orderDetailsRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<OrderDetailDTO> result = orderDetailsService.partialUpdate(orderDetailsDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, orderDetailsDTO.getId().toString())
        );
    }

    @GetMapping("/order-detail/{id}")
    public ResponseEntity<OrderDetailDTO> getOrderDetail(@PathVariable Long id) {
        log.debug("REST request to get OrderDetail : {}", id);
        Optional<OrderDetailDTO> orderDetailsDTO = orderDetailsService.findOne(id);
        return ResponseUtil.wrapOrNotFound(orderDetailsDTO);
    }

    /**
     * {@code DELETE  /order-detail/:id} : delete the "id" orderDetails.
     *
     * @param id the id of the orderDetailsDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/order-detail/{id}")
    public ResponseEntity<Void> deleteOrderDetail(@PathVariable Long id) {
        log.debug("REST request to delete OrderDetail : {}", id);
        orderDetailsService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString()))
            .build();
    }
}
