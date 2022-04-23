package com.kma.food.service.impl;

import com.kma.food.domain.OrderDetail;
import com.kma.food.repository.OrderDetailRepository;
import com.kma.food.service.OrderDetailService;
import com.kma.food.service.dto.OrderDetailDTO;
import com.kma.food.service.mapper.OrderDetailMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link OrderDetail}.
 */
@Service
@Transactional
public class OrderDetailServiceImpl implements OrderDetailService {

    private final Logger log = LoggerFactory.getLogger(OrderDetailServiceImpl.class);

    private final OrderDetailRepository orderDetailsRepository;

    private final OrderDetailMapper orderDetailsMapper;

    public OrderDetailServiceImpl(OrderDetailRepository orderDetailsRepository, OrderDetailMapper orderDetailsMapper) {
        this.orderDetailsRepository = orderDetailsRepository;
        this.orderDetailsMapper = orderDetailsMapper;
    }

    @Override
    public OrderDetailDTO save(OrderDetailDTO orderDetailsDTO) {
        log.debug("Request to save OrderDetail : {}", orderDetailsDTO);
        OrderDetail orderDetails = orderDetailsMapper.toEntity(orderDetailsDTO);
        orderDetails = orderDetailsRepository.save(orderDetails);
        return orderDetailsMapper.toDto(orderDetails);
    }

    @Override
    public Optional<OrderDetailDTO> partialUpdate(OrderDetailDTO orderDetailsDTO) {
        log.debug("Request to partially update OrderDetail : {}", orderDetailsDTO);

        return orderDetailsRepository
            .findById(orderDetailsDTO.getId())
            .map(existingOrderDetail -> {
                orderDetailsMapper.partialUpdate(existingOrderDetail, orderDetailsDTO);

                return existingOrderDetail;
            })
            .map(orderDetailsRepository::save)
            .map(orderDetailsMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<OrderDetailDTO> findAll(Pageable pageable) {
        log.debug("Request to get all OrderDetail");
        return orderDetailsRepository.findAll(pageable).map(orderDetailsMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<OrderDetailDTO> findOne(Long id) {
        log.debug("Request to get OrderDetail : {}", id);
        return orderDetailsRepository.findById(id).map(orderDetailsMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete OrderDetail : {}", id);
        orderDetailsRepository.deleteById(id);
    }
}
