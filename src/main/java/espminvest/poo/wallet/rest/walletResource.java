package espminvest.poo.wallet.rest;

import espminvest.poo.cambio.common.controller.CambioController;
import espminvest.poo.user.common.datatype.UserBean;
import espminvest.poo.wallet.common.datatype.WalletBean;
import espminvest.poo.wallet.common.controller.WalletController;

import espminvest.poo.wallet.service.WalletService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@EnableFeignClients(basePackages = {"espminvest.poo.cambio.common.controller", "espminvest.poo.user.common.controller", "espminvest.poo.wallet.common.controller"})
@RestController
public class walletResource implements WalletController {

    @Autowired
    private CambioController cambioController;
    @Autowired
    private WalletService walletService;

    @Override
    public WalletBean saveWallet(WalletBean wallet) {
        return walletService.saveWallet(wallet);
    }

    @Override
    public WalletBean getWalletByUserId(String id) {
        Integer userId = Integer.parseInt(id);
        return walletService.findBy(userId);
    }

    @Override
    public void deleteWallet(String id) {

    }
}
