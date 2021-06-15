package espminvest.poo.wallet.rest;

import espminvest.poo.wallet.common.controller.StockTransactionController;
import espminvest.poo.wallet.common.datatype.StockTransactionBean;
import espminvest.poo.wallet.common.datatype.TransactionBean;
import espminvest.poo.wallet.service.StockTransactionService;
import espminvest.poo.wallet.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StockTransactionResource implements StockTransactionController {

    @Autowired
    private WalletService walletService;

    @Autowired
    private StockTransactionService stockTransactionService;


    @Override
    public StockTransactionBean buyStockTransaction(int walletId, TransactionBean stockTransaction) {
        return stockTransactionService.buyStockTransaction(walletId, stockTransaction);
    }

    @Override
    public StockTransactionBean sellStockTransaction(int walletId, TransactionBean stockTransaction) {
        return stockTransactionService.sellStockTransaction(walletId, stockTransaction);
    }

    @Override
    public StockTransactionBean getStockTransactionById(String id) {
        return null;
    }

    @Override
    public List<StockTransactionBean> getStockTransactionByWalletId() {
        return null;
    }
}
