package com.operr.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.operr.api.entity.Item;

@RestController
@RequestMapping("item")
public class ItemRestController extends BaseRestController<Item>{

	/*private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private ItemService itemService;*/
}