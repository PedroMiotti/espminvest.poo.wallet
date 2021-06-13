package espminvest.poo.wallet.rest;


import espminvest.poo.cambio.common.controller.CambioController;
import espminvest.poo.wallet.common.controller.CambioTransactionController;
import espminvest.poo.wallet.common.datatype.CambioTransactionBean;
import espminvest.poo.wallet.common.datatype.TransactionBean;
import espminvest.poo.wallet.common.datatype.WalletBean;
import espminvest.poo.wallet.service.CambioTransactionService;
import espminvest.poo.wallet.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class CambioTransactionResource implements CambioTransactionController {

    @Autowired
    private CambioController cambioController;
    @Autowired
    private WalletService walletService;
    @Autowired
    private CambioTransactionService cambioTransactionService;


    @Override
    public CambioTransactionBean buyCambioTransaction(int walletId, TransactionBean cambioTransaction) {
        return cambioTransactionService.buyCambioTransaction(walletId, cambioTransaction);
    }

    @Override
    public CambioTransactionBean sellCambioTransaction(int walletId, TransactionBean cambioTransaction) {
        return cambioTransactionService.sellCambioTransaction(walletId, cambioTransaction);
    }

    @Override
    public CambioTransactionBean getCambioTransactionById(String id) {
        return null;
    }

    @Override
    public List<CambioTransactionBean> getCambioTransactionByWalletId() {
        return null;
    }
}
