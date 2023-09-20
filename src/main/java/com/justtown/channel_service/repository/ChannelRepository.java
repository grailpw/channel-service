package com.justtown.channel_service.repository;

import com.justtown.channel_service.entity.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChannelRepository extends JpaRepository<Channel, Long> {
    Optional<Channel> findByChannelName(String channelName);
    boolean existsByChannelName(String channelName);
}
