package me.mingxing5212.chaihens.voucher.market.web;

import me.mingxing5212.chaihens.voucher.market.service.VoucherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 获取商户信息
 *
 * @author Mingxing Li
 * @date 24/1/16
 */
@RestController
@RequestMapping("/voucher/market")
public class VoucherMarketApi {
    private Logger logger = LoggerFactory.getLogger(VoucherMarketApi.class);

    @Autowired
    public VoucherService voucherService;

    @RequestMapping(method = RequestMethod.GET)
    public String getVoucher(@RequestParam Long voucherId) {
        return "Hi";
    }
}
