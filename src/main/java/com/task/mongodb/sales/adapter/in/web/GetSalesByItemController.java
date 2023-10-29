package com.task.mongodb.sales.adapter.in.web;

import com.task.mongodb.common.Path;
import com.task.mongodb.common.WebAdapter;
import com.task.mongodb.sales.application.in.GetSalesByItemQuery;
import com.task.mongodb.sales.domain.Sale;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class GetSalesByItemController {
  private final GetSalesByItemQuery salesQuery;

  @GetMapping(Path.SALE_ITEM)
  public ResponseEntity<Iterable<Sale>> getByItem(@RequestParam(name = "item") String item) {
    return ResponseEntity.ok(salesQuery.getByItem(item));
  }

  @GetMapping(Path.SALE_ITEM_TOTAL)
  public ResponseEntity<String> getByItemTotal(@RequestParam(name = "item") String item) {
    return ResponseEntity.ok(salesQuery.getSumByItem(item));
  }
}
