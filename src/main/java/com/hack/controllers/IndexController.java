package com.hack.controllers;

import com.hack.bl.IndexBusiness;
import com.hack.models.IndexPrice;
import com.hack.models.IndexDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Class IndexController
 */
@Controller
public class IndexController {

  /**
   * Retrieve the id for the user with the passed email address.
   */
  @RequestMapping(value="/{code}", method = RequestMethod.GET)
  @ResponseBody
  public ResponseEntity<IndexPrice> getByCode(@PathVariable String code) {
      try {
          IndexPrice indexPrice = business.getByCode(code);
          return ResponseEntity.status(HttpStatus.FOUND).body(indexPrice);
      } catch (Exception ex) {
          return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
      }
  }


    @RequestMapping(value="/", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<IndexPrice>> getByCode() {
        try {
            List<IndexPrice> indexPrices = business.getAll();
            return ResponseEntity.status(HttpStatus.FOUND).body(indexPrices);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

  // ------------------------
  // PRIVATE FIELDS
  // ------------------------

  @Autowired
  private IndexBusiness business;


} // class IndexController
