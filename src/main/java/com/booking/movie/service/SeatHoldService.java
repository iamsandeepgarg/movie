package com.booking.movie.service;

import com.booking.movie.dto.SeatHoldRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SeatHoldService {

    private final StringRedisTemplate redisTemplate;
    private static final int HOLD_SECONDS = 300;

    public void holdSeats(SeatHoldRequest seatHoldRequest){

        for (Long seatId : seatHoldRequest.seatIds()){
            String key  = buildKey(seatHoldRequest.showId(),seatId);

            Boolean success = redisTemplate.opsForValue()
                    .setIfAbsent(key, seatHoldRequest.userId().toString(), Duration.ofSeconds(HOLD_SECONDS));

            if(Boolean.FALSE.equals(success)){
                throw new RuntimeException("Seats already locked" + seatId );
            }
        }
    }

    public void releaseSeats(Long showId, List<Long> seatIds){
        for (Long seatId : seatIds){
            Boolean deleted = redisTemplate.delete(buildKey(showId, seatId));
        }
    }

    public void confirmBooking(Long showId, List<Long> seatIds){
        for (Long seatId : seatIds){
            if(!redisTemplate.hasKey(buildKey(showId, seatId))){
                throw new RuntimeException("Lock expired");
            }
        }
        releaseSeats(showId, seatIds);
    }

    private String buildKey(Long showId, Long seatId){
        return "seat:"+ showId + ":" + seatId;

    }

}
