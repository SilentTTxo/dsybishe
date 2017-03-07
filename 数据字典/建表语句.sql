CREATE TABLE `AD` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `IMG` text,
  `URL` text,
  `GOODSID` int(11) DEFAULT NULL,
  `MSG` text,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8
CREATE TABLE `GOODS` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` text,
  `PRICE` double DEFAULT NULL,
  `DES` text,
  `ISSELL` int(11) DEFAULT NULL,
  `GOODSTYPE` text,
  `ADDRESS` text,
  `SEX` text,
  `AGE` int(11) DEFAULT NULL,
  `TEL` text,
  `IMG` text,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8
CREATE TABLE `GOODSORDER` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ORDERTYPE` text,
  `PRICE` double DEFAULT NULL,
  `SUM` int(11) DEFAULT NULL,
  `GOODS` int(11) DEFAULT NULL,
  `UID` int(11) DEFAULT NULL,
  `STATE` int(11) DEFAULT NULL,
  `TPRICE` double DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8
CREATE TABLE `NOTICE` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TITLE` text,
  `NDESCRIBE` text,
  `TYPE` text,
  `NTIME` text,
  `URL` text,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8
CREATE TABLE `USER` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `USERNAME` text,
  `PASSWORD` text,
  `POWER` int(11) DEFAULT NULL,
  `MONEY` float(11,2) DEFAULT NULL,
  `IMG` text,
  `PAYPASSWORD` text,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `GOODSORDER2GOOODS` AS select `GOODSORDER`.`ID` AS `ID`,`GOODSORDER`.`ORDERTYPE` AS `ORDERTYPE`,`GOODSORDER`.`PRICE` AS `PRICE`,`GOODSORDER`.`SUM` AS `SUM`,`GOODSORDER`.`GOODS` AS `GOODS`,`GOODSORDER`.`UID` AS `UID`,`GOODSORDER`.`STATE` AS `STATE`,`GOODSORDER`.`TPRICE` AS `TPRICE`,`GOODS`.`NAME` AS `GOODSNAME`,`GOODS`.`IMG` AS `GOODSIMG`,`GOODS`.`TEL` AS `GOODSPHONE`,`GOODS`.`GOODSTYPE` AS `GOODSTYPE` from (`GOODSORDER` left join `GOODS` on((`GOODSORDER`.`GOODS` = `GOODS`.`ID`)))
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `goodsorderview` AS select `GOODSORDER`.`ID` AS `ID`,`GOODSORDER`.`ORDERTYPE` AS `ORDERTYPE`,`GOODSORDER`.`PRICE` AS `PRICE`,`GOODSORDER`.`SUM` AS `SUM`,`GOODSORDER`.`STATE` AS `STATE`,`GOODSORDER`.`TPRICE` AS `TPRICE`,`USER`.`USERNAME` AS `USERNAME`,`GOODS`.`NAME` AS `GOODSNAME` from ((`GOODSORDER` left join `USER` on((`GOODSORDER`.`UID` = `USER`.`ID`))) left join `GOODS` on((`GOODS`.`ID` = `GOODSORDER`.`GOODS`)))