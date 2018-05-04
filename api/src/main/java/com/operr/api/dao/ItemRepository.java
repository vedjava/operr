package com.operr.api.dao;

import org.springframework.stereotype.Repository;
import com.operr.api.entity.Item;

@Repository
public interface ItemRepository extends BaseRepository<Item, Long>{
}