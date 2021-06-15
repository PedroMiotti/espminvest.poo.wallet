CREATE TABLE `espminvest.poo.wallet`.`cambiotransaction` (
  `ct_id` INT NOT NULL AUTO_INCREMENT,
  `wallet_id` INT NULL,
  `estimate_id` INT NULL,
  `ct_date` DATETIME NULL,
  `ct_qtd` DECIMAL(12,2) NULL,
  PRIMARY KEY (`ct_id`));

CREATE TABLE `espminvest.poo.wallet`.`stocktransaction` (
`st_id` INT NOT NULL AUTO_INCREMENT,
`wallet_id` INT NULL,
`estimate_id` INT NULL,
`st_date` DATETIME NULL,
`ct_qtd` DECIMAL(12,2) NULL,
PRIMARY KEY (`st_id`));
