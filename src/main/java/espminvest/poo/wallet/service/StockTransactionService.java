package espminvest.poo.wallet.service;

import espminvest.poo.stock.common.datatype.EstimateBean;
import espminvest.poo.stock.common.controller.StockController;
import espminvest.poo.stock.common.datatype.StockBean;
import espminvest.poo.wallet.common.datatype.StockTransactionBean;
import espminvest.poo.wallet.common.datatype.TransactionBean;
import espminvest.poo.wallet.common.datatype.WalletBean;

import espminvest.poo.wallet.model.StockTransactionModel;
import espminvest.poo.wallet.respository.StockTransactionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class StockTransactionService {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

    @Autowired
    private StockTransactionRepository stockTransactionRepository;

    @Autowired
    private StockController stockController;

    @Autowired
    private WalletService walletService;

    public StockTransactionBean buyStockTransaction(Integer walletId, TransactionBean stockTransaction){

        WalletBean wallet = walletService.findByWalletId(walletId);
        if(wallet == null){
            throw new RuntimeException("Wallet not found : " + walletId);
        }

        Date now = new Date();

        StockBean stock = stockController.getStock(String.valueOf(stockTransaction.getCurrencyId()));
        if (stock == null) {
            throw new RuntimeException("Stock does not exist : " + stockTransaction.getCurrencyId());
        }


        EstimateBean estimate = stockController.getEstimate(String.valueOf(stock.getId()), sdf.format(now));
        if (estimate == null) {
            throw new RuntimeException("Estimate not found : " + sdf.format(now));
        }

        StockTransactionBean st = new StockTransactionBean();
        st.setWallet(wallet);
        st.setEstimate(estimate);
        st.setQtd(stockTransaction.getQtd());
        st.setDate(now);

        Double transactionTotal = stockTransaction.getQtd() * estimate.getValue();
        Double newBalanceValue = (wallet.getBalance() == null ? 0 : wallet.getBalance()) - transactionTotal;

        if(transactionTotal > wallet.getBalance()){
            throw new RuntimeException("Error : Insuficient funds !");
        }
        else{
            walletService.updateBalance(newBalanceValue, walletId);
            return stockTransactionRepository.save(new StockTransactionModel(st)).toBean();
        }
    }

    public StockTransactionBean sellStockTransaction(Integer walletId, TransactionBean stockTransaction){

        WalletBean wallet = walletService.findByWalletId(walletId);
        if(wallet == null){
            throw new RuntimeException("Wallet not found : " + walletId);
        }

        Date now = new Date();

        StockBean stock = stockController.getStock(String.valueOf(stockTransaction.getCurrencyId()));
        if (stock == null) {
            throw new RuntimeException("Stock does not exist : " + stockTransaction.getCurrencyId());
        }


        EstimateBean estimate = stockController.getEstimate(String.valueOf(stock.getId()), sdf.format(now));
        if (estimate == null) {
            throw new RuntimeException("Estimate not found : " + sdf.format(now));
        }

        StockTransactionBean st = new StockTransactionBean();
        st.setWallet(wallet);
        st.setEstimate(estimate);
        st.setQtd(stockTransaction.getQtd());
        st.setDate(now);

        Double transactionTotal = stockTransaction.getQtd() * estimate.getValue();
        Double newBalanceValue = (wallet.getBalance() == null ? 0 : wallet.getBalance()) + transactionTotal;
        walletService.updateBalance(newBalanceValue, walletId);

        return stockTransactionRepository.save(new StockTransactionModel(st)).toBean();

    }
}
