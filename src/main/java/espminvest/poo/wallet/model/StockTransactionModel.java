package espminvest.poo.wallet.model;

import espminvest.poo.stock.common.datatype.EstimateBean;
import espminvest.poo.wallet.common.datatype.StockTransactionBean;
import espminvest.poo.wallet.common.datatype.WalletBean;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "stocktransaction")
public class StockTransactionModel {

    @Id
    @Column(name = "st_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private int walletId;
    private int estimateId;
    @Column(name = "st_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Column(name = "st_qtd")
    private Double qtd;

    public StockTransactionModel(){}

    public StockTransactionModel(StockTransactionBean stockTransaction){
        this.walletId = stockTransaction.getWallet().getId();
        this.estimateId = stockTransaction.getEstimate().getId();
        this.date = stockTransaction.getDate();
        this.qtd = stockTransaction.getQtd();

    }

    public StockTransactionBean toBean(){
        WalletBean wallet = new WalletBean();
        wallet.setId(walletId);

        EstimateBean estimate = new EstimateBean();
        estimate.setId(estimateId);

        StockTransactionBean st = new StockTransactionBean();
        st.setId(id);
        st.setWallet(wallet);
        st.setEstimate(estimate);
        st.setDate(date);
        st.setQtd(qtd);

        return st;
    }
}
