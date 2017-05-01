package com.hack.bl;

import com.hack.models.IndexDao;
import com.hack.models.IndexPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by himanshu dhawan on 01-05-2017.
 */
@Component
public class IndexBusiness {

    public static void main(String[] args) {
        int random = (int) (((Math.random() * 100) % 5));
        System.out.println(random);
    }

    private IndexPrice createDiff(IndexPrice byCode) {
        double random = (int) (((Math.random() * 100) % 5));
        random = (random / 100) + 1;
        byCode.setPrice(byCode.getPrice() * random);
        byCode.setSource("Pricing");
        return byCode;
    }

    public IndexPrice getByCode(String code) {
        return createDiff(indexDao.getByCode(code));
    }

    public List<IndexPrice> getAll() {
        List<IndexPrice> listIndex = indexDao.getAll();
        for (IndexPrice index : listIndex) {
            createDiff(index);
        }
        return listIndex;
    }

    // Wire the IndexDao used inside this controller.
    @Autowired
    private IndexDao indexDao;
}
