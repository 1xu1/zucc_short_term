/*
Navicat MySQL Data Transfer

Source Server         : short_term
Source Server Version : 50514
Source Host           : localhost:3306
Source Database       : short_term

Target Server Type    : MYSQL
Target Server Version : 50514
File Encoding         : 65001

Date: 2020-07-13 23:34:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `address_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` char(20) DEFAULT NULL,
  `province` char(20) DEFAULT NULL,
  `a_city` char(20) DEFAULT NULL,
  `area` char(20) DEFAULT NULL,
  `a_address` char(30) DEFAULT NULL,
  `con_name` char(20) DEFAULT NULL,
  `con_phone` char(20) DEFAULT NULL,
  `valid` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`address_id`),
  KEY `FK_Relationship_7` (`user_id`),
  CONSTRAINT `FK_Relationship_7` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address` VALUES ('1', '1', '浙江', '杭州', 'XX街', 'XXXXX', '徐宇翔', '6510', '1');
INSERT INTO `address` VALUES ('2', '1', '1', '1', '1', '1', '1', '1', '0');
INSERT INTO `address` VALUES ('3', '1', '1', '1', '1', '1', '1', '1', '0');
INSERT INTO `address` VALUES ('4', '1', '2', '2', '2', '2', '2', '2', '0');
INSERT INTO `address` VALUES ('5', '1', '', '', '', '', '', '', '0');
INSERT INTO `address` VALUES ('6', '3', '3', '3', '3', '3', '3', '3', '1');
INSERT INTO `address` VALUES ('7', '1', '2', '2', '2', '2', '22', '2', '1');
INSERT INTO `address` VALUES ('8', '4', '12', '12', '12', '12', '123', '12', '0');
INSERT INTO `address` VALUES ('9', '4', '1', '1', '1', '1', '1', '11', '1');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `user_id` char(20) NOT NULL,
  `pro_id` int(11) NOT NULL,
  `cm_star` int(11) DEFAULT NULL,
  `cm_content` char(255) DEFAULT NULL,
  `cm_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `cm_picture` char(255) DEFAULT NULL,
  `order_id` int(11) NOT NULL,
  `user_name` varchar(20) DEFAULT NULL,
  `phrase_count` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`order_id`),
  KEY `FK_comment2` (`pro_id`),
  KEY `fk_2` (`user_id`),
  CONSTRAINT `fk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `fk_3` FOREIGN KEY (`order_id`) REFERENCES `u_order` (`order_id`),
  CONSTRAINT `FK_comment2` FOREIGN KEY (`pro_id`) REFERENCES `production` (`pro_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1', '11', '5', '很棒', '2020-07-11 14:46:34', null, '3', '徐宇翔', '0');
INSERT INTO `comment` VALUES ('1', '5', '5', '很好', '2020-07-13 20:18:24', null, '7', '徐宇翔', '0');

-- ----------------------------
-- Table structure for discount_coupon
-- ----------------------------
DROP TABLE IF EXISTS `discount_coupon`;
CREATE TABLE `discount_coupon` (
  `dis_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` char(20) DEFAULT NULL,
  `dis_content` char(255) DEFAULT NULL,
  `dis_amout` float DEFAULT NULL,
  `cut_amout` float DEFAULT NULL,
  `start_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `end_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `valid` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`dis_id`),
  KEY `FK_Relationship_10` (`user_id`),
  CONSTRAINT `FK_Relationship_10` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of discount_coupon
-- ----------------------------
INSERT INTO `discount_coupon` VALUES ('1', '1', '100满减20', '100', '20', '2020-07-11 09:59:06', '2021-08-01 00:00:00', '1');
INSERT INTO `discount_coupon` VALUES ('2', '4', '满100减5', '100', '5', '2020-07-13 23:24:57', '2021-09-01 00:00:00', '0');

-- ----------------------------
-- Table structure for meet_discount
-- ----------------------------
DROP TABLE IF EXISTS `meet_discount`;
CREATE TABLE `meet_discount` (
  `md_id` int(11) NOT NULL AUTO_INCREMENT,
  `md_content` char(255) DEFAULT NULL,
  `md_amout` float(11,0) DEFAULT NULL,
  `discount` float DEFAULT NULL,
  `end_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `start_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `valid` int(11) NOT NULL DEFAULT '1',
  `user_id` char(255) DEFAULT NULL,
  PRIMARY KEY (`md_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of meet_discount
-- ----------------------------
INSERT INTO `meet_discount` VALUES ('1', '满100打7折', '100', '0.7', '2021-01-01 00:00:00', '2020-07-09 00:00:00', '1', '1');
INSERT INTO `meet_discount` VALUES ('2', '满100打9折', '100', '0.9', '2021-01-01 00:00:00', '2020-01-01 00:00:00', '1', '4');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `me_id` int(11) NOT NULL AUTO_INCREMENT,
  `me_name` char(20) DEFAULT NULL,
  `me_usage` char(255) DEFAULT NULL,
  `me_step` char(255) DEFAULT NULL,
  `me_picture` char(255) DEFAULT NULL,
  `valid` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`me_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '水煮白菜', '白菜', '加水煮熟', '1', '1');
INSERT INTO `menu` VALUES ('2', '水煮鱼', '海鱼', '加水煮熟', '.\\\\picture\\咸鱼.jpg', '1');
INSERT INTO `menu` VALUES ('3', '123', '121', '123', null, '0');
INSERT INTO `menu` VALUES ('4', '1', '1', '1', null, '0');
INSERT INTO `menu` VALUES ('5', '123', '123', '123', null, '0');

-- ----------------------------
-- Table structure for me_recommend
-- ----------------------------
DROP TABLE IF EXISTS `me_recommend`;
CREATE TABLE `me_recommend` (
  `me_id` int(11) NOT NULL,
  `pro_id` int(11) NOT NULL,
  `description` char(255) DEFAULT NULL,
  `me_re` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`me_re`),
  KEY `FK_me_recommend` (`me_id`),
  KEY `FK_me_recommend2` (`pro_id`),
  CONSTRAINT `FK_me_recommend` FOREIGN KEY (`me_id`) REFERENCES `menu` (`me_id`),
  CONSTRAINT `FK_me_recommend2` FOREIGN KEY (`pro_id`) REFERENCES `production` (`pro_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of me_recommend
-- ----------------------------
INSERT INTO `me_recommend` VALUES ('1', '7', '哇咔咔', '1');
INSERT INTO `me_recommend` VALUES ('2', '11', '', '2');
INSERT INTO `me_recommend` VALUES ('2', '8', '', '3');

-- ----------------------------
-- Table structure for production
-- ----------------------------
DROP TABLE IF EXISTS `production`;
CREATE TABLE `production` (
  `pro_id` int(11) NOT NULL AUTO_INCREMENT,
  `type_id` int(11) DEFAULT NULL,
  `pro_name` char(20) DEFAULT NULL,
  `pro_stock` int(11) DEFAULT NULL,
  `pro_price` float DEFAULT NULL,
  `pro_vip_price` float DEFAULT NULL,
  `pro_specification` char(255) DEFAULT NULL,
  `pro_more` char(255) DEFAULT NULL,
  `valid` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`pro_id`),
  KEY `FK_Relationship_3` (`type_id`),
  CONSTRAINT `FK_Relationship_3` FOREIGN KEY (`type_id`) REFERENCES `type` (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of production
-- ----------------------------
INSERT INTO `production` VALUES ('1', '1', '生猪肉', '200', '30', '25', '500g', '123', '1');
INSERT INTO `production` VALUES ('5', '1', '生羊肉', '198', '50', '45', '500g', '12', '1');
INSERT INTO `production` VALUES ('6', '1', '生牛肉2', '515', '75', '70', '500g', '123', '1');
INSERT INTO `production` VALUES ('7', '2', '白菜', '200', '10', '9', '500g', '新鲜的', '1');
INSERT INTO `production` VALUES ('8', '2', '皮皮虾', '500', '20', '15', '500', '哇啊啊啊啊啊', '0');
INSERT INTO `production` VALUES ('9', '3', '皮皮虾', '995', '20', '15', '500', '哇啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊', '1');
INSERT INTO `production` VALUES ('10', '3', '大鱿鱼', '4982', '235', '230', '500', '一起去挖大鱿鱼吧', '1');
INSERT INTO `production` VALUES ('11', '3', '海鱼', '2089', '20', '15', '500', '好吃的', '1');
INSERT INTO `production` VALUES ('12', '2', '大蒜', '195', '5', '4', '500', '啊，好臭', '1');
INSERT INTO `production` VALUES ('13', '2', '韭菜1', '998', '5', '4', '500g', '好吃又新鲜', '1');
INSERT INTO `production` VALUES ('14', '3', '1', '1', '1', '1', '1', '1', '0');

-- ----------------------------
-- Table structure for promotion
-- ----------------------------
DROP TABLE IF EXISTS `promotion`;
CREATE TABLE `promotion` (
  `pr_id` int(11) NOT NULL AUTO_INCREMENT,
  `pro_id` int(11) DEFAULT NULL,
  `pr_price` float DEFAULT NULL,
  `pr_quatity` int(11) DEFAULT NULL,
  `start_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `end_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `valid` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`pr_id`),
  KEY `FK_Relationship_11` (`pro_id`),
  CONSTRAINT `FK_Relationship_11` FOREIGN KEY (`pro_id`) REFERENCES `production` (`pro_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of promotion
-- ----------------------------
INSERT INTO `promotion` VALUES ('1', '1', '20', '95', '2020-07-11 22:54:09', '2020-07-11 22:04:35', '1');
INSERT INTO `promotion` VALUES ('2', '11', '1', '1', '2020-07-13 22:20:58', '2020-07-13 22:20:45', '0');

-- ----------------------------
-- Table structure for pro_shop
-- ----------------------------
DROP TABLE IF EXISTS `pro_shop`;
CREATE TABLE `pro_shop` (
  `shop_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` char(20) DEFAULT NULL,
  `pro_id` int(11) DEFAULT NULL,
  `quatity` int(11) DEFAULT NULL,
  `state` char(20) NOT NULL,
  PRIMARY KEY (`shop_id`),
  KEY `FK_Relationship_12` (`user_id`),
  KEY `2` (`pro_id`),
  CONSTRAINT `2` FOREIGN KEY (`pro_id`) REFERENCES `production` (`pro_id`),
  CONSTRAINT `FK_Relationship_12` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of pro_shop
-- ----------------------------
INSERT INTO `pro_shop` VALUES ('2', '1', '6', '20', '已接收');
INSERT INTO `pro_shop` VALUES ('3', '1', '11', '100', '已接收');

-- ----------------------------
-- Table structure for type
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type` (
  `type_id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` char(20) DEFAULT NULL,
  `count` int(11) unsigned zerofill NOT NULL DEFAULT '00000000000',
  `description` char(255) DEFAULT NULL,
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of type
-- ----------------------------
INSERT INTO `type` VALUES ('1', '生肉', '00000000002', '生的肉');
INSERT INTO `type` VALUES ('2', '蔬菜', '00000000003', '新鲜蔬菜');
INSERT INTO `type` VALUES ('3', '海鲜', '00000000004', '新鲜海鲜');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` char(20) NOT NULL,
  `user_pwd` char(20) NOT NULL,
  `register_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `manager` int(11) DEFAULT NULL,
  `name` char(20) DEFAULT NULL,
  `phone_number` char(20) DEFAULT NULL,
  `mail` char(20) DEFAULT NULL,
  `city` char(20) DEFAULT NULL,
  `VIP` int(11) DEFAULT NULL,
  `vip_end_date` datetime DEFAULT NULL,
  `valid` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '1', '2020-07-13 20:45:10', '1', '徐宇翔', '123', '123', '杭州', '1', '2021-01-01 00:00:00', '1');
INSERT INTO `user` VALUES ('2', '2', '2020-07-13 22:18:38', '0', '2', null, null, null, '0', null, '0');
INSERT INTO `user` VALUES ('3', '3', '2020-07-13 14:52:55', '0', '3', null, null, null, '0', null, '0');
INSERT INTO `user` VALUES ('4', '123', '2020-07-13 22:48:11', '0', '123', '123', '123', '123', '1', '2020-08-08 00:00:00', '1');
INSERT INTO `user` VALUES ('5', '5', '2020-07-13 21:57:44', '0', '5', null, null, null, '0', null, '1');
INSERT INTO `user` VALUES ('root', 'oracle', '2020-07-10 20:43:20', '1', 'root', null, null, null, '0', null, '1');

-- ----------------------------
-- Table structure for u_order
-- ----------------------------
DROP TABLE IF EXISTS `u_order`;
CREATE TABLE `u_order` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `address_id` int(11) NOT NULL,
  `user_id` char(20) NOT NULL,
  `pre_price` float DEFAULT NULL,
  `price` float DEFAULT NULL,
  `arrived_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `order_state` char(20) DEFAULT NULL,
  `coupon_id` int(11) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `pro_id` int(11) NOT NULL,
  `pro_quatity` int(11) NOT NULL,
  PRIMARY KEY (`order_id`),
  KEY `FK_Relationship_8` (`address_id`),
  KEY `FK_Relationship_9` (`user_id`),
  CONSTRAINT `FK_Relationship_8` FOREIGN KEY (`address_id`) REFERENCES `address` (`address_id`),
  CONSTRAINT `FK_Relationship_9` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of u_order
-- ----------------------------
INSERT INTO `u_order` VALUES ('3', '1', '1', '20', '15', '2020-07-11 11:23:55', '已送达', '-1', null, '11', '1');
INSERT INTO `u_order` VALUES ('4', '1', '1', '235', '210', '2020-07-13 14:20:29', '已退货', '1', '满减券', '10', '1');
INSERT INTO `u_order` VALUES ('5', '1', '1', '150', '100', '2020-07-13 22:38:57', '已下单', '-1', null, '0', '5');
INSERT INTO `u_order` VALUES ('6', '1', '1', '100', '75', '2020-07-13 13:47:12', '已送达', '-1', null, '9', '5');
INSERT INTO `u_order` VALUES ('7', '1', '1', '100', '90', '2020-07-13 14:16:09', '配送中', '-1', null, '5', '2');
INSERT INTO `u_order` VALUES ('8', '9', '4', '25', '20', '2020-07-13 22:30:17', '配送中', '-1', null, '12', '5');
INSERT INTO `u_order` VALUES ('9', '9', '4', '375', '370', '2020-07-15 22:34:50', '已下单', '2', '满减券', '6', '5');
INSERT INTO `u_order` VALUES ('10', '9', '4', '2820', '2755', '2020-07-15 22:55:10', '已下单', '2', '满减券', '10', '12');
INSERT INTO `u_order` VALUES ('11', '9', '4', '245', '214.2', '2020-07-15 23:05:42', '已下单', '2', '满折券', '13', '1');
INSERT INTO `u_order` VALUES ('12', '9', '4', '245', '214.2', '2020-07-15 23:05:42', '已下单', '2', '满折券', '13', '1');
INSERT INTO `u_order` VALUES ('13', '9', '4', '245', '214.2', '2020-07-15 23:05:42', '已下单', '2', '满折券', '10', '1');
INSERT INTO `u_order` VALUES ('14', '9', '4', '255', '240', '2020-07-15 23:13:11', '已下单', '2', '满减券', '11', '1');
INSERT INTO `u_order` VALUES ('15', '9', '4', '255', '240', '2020-07-15 23:13:11', '已下单', '2', '满减券', '10', '1');
INSERT INTO `u_order` VALUES ('16', '9', '4', '160', '120', '2020-07-15 23:18:08', '已下单', '-1', null, '11', '8');
INSERT INTO `u_order` VALUES ('17', '9', '4', '235', '225', '2020-07-15 23:19:41', '已下单', '-1', null, '10', '1');
INSERT INTO `u_order` VALUES ('18', '9', '4', '235', '225', '2020-07-15 23:21:00', '已下单', '2', '满减券', '10', '1');
INSERT INTO `u_order` VALUES ('19', '9', '4', '255', '240', '2020-07-15 23:24:57', '已下单', '2', '满减券', '11', '1');
INSERT INTO `u_order` VALUES ('20', '9', '4', '255', '240', '2020-07-15 23:24:57', '已下单', '2', '满减券', '10', '1');

-- ----------------------------
-- View structure for menu_more
-- ----------------------------
DROP VIEW IF EXISTS `menu_more`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost`  VIEW `menu_more` AS SELECT pro_name,me_id,description
FROM me_recommend,production
WHERE me_recommend.pro_id=production.pro_id ;

-- ----------------------------
-- View structure for order_more
-- ----------------------------
DROP VIEW IF EXISTS `order_more`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER  VIEW `order_more` AS SELECT user.user_id,u_order.order_id,production.pro_id,pro_name,pro_quatity,pre_price,price,arrived_time,order_state,pro_specification
FROM production,u_order,user
WHERE production.pro_id=u_order.pro_id and user.user_id=u_order.user_id ;

-- ----------------------------
-- View structure for pro_comment
-- ----------------------------
DROP VIEW IF EXISTS `pro_comment`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER  VIEW `pro_comment` AS SELECT name,cm_content,cm_star,cm_date,pro_id,phrase_count,order_id
FROM `comment`,`user`
WHERE comment.user_id=`user`.user_id ;

-- ----------------------------
-- View structure for pro_promotion
-- ----------------------------
DROP VIEW IF EXISTS `pro_promotion`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER  VIEW `pro_promotion` AS SELECT pro_name,pro_price,pr_price,pro_specification,pr_quatity,start_date,end_date,pr_id,pro_more
FROM production,promotion
WHERE production.pro_id=promotion.pro_id and promotion.valid=1 ;

-- ----------------------------
-- View structure for pro_shop_more
-- ----------------------------
DROP VIEW IF EXISTS `pro_shop_more`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER  VIEW `pro_shop_more` AS SELECT user.user_id,pro_name,pro_specification,quatity,state,shop_id,production.pro_id
FROM production,pro_shop,user
where `user`.user_id=pro_shop.user_id and production.pro_id=pro_shop.pro_id ;

-- ----------------------------
-- View structure for pro_sold
-- ----------------------------
DROP VIEW IF EXISTS `pro_sold`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER  VIEW `pro_sold` AS SELECT production.pro_id,pro_name,SUM(u_order.pro_quatity) pro_sold
FROM production,u_order
WHERE production.pro_id=u_order.pro_id
GROUP BY pro_id 
ORDER BY pro_sold ;
