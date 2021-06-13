package espminvest.poo.wallet.respository;

import espminvest.poo.wallet.model.WalletModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Optional;

public interface WalletRepository extends CrudRepository<WalletModel, Integer> {

    @Override
    WalletModel save(WalletModel wallet);

    @Query("SELECT w FROM WalletModel w WHERE w.user_id = :userId")
    Optional<WalletModel> findByUserId(@Param("userId") Integer userId);

    Optional<WalletModel> findById(@Param("walletId") Integer walletId);

    // REF https://stackoverflow.com/questions/44022076/jparepository-not-supported-for-dml-operations-delete-query
    @Transactional
    @Modifying
    @Query("UPDATE WalletModel w SET w.balance = :value WHERE w.id = :walletId ")
    void updateBalance(@Param("value") Double value, @Param("walletId") Integer walletId);

}
