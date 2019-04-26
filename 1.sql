/*
SQLyog Ultimate v11.25 (64 bit)
MySQL - 5.5.62 : Database - bishe_movie
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bishe_movie` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `bishe_movie`;

/*Table structure for table `t_movie` */

DROP TABLE IF EXISTS `t_movie`;

CREATE TABLE `t_movie` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) NOT NULL,
  `picture` varchar(256) NOT NULL,
  `release_time` varchar(256) NOT NULL,
  `score` double(3,1) DEFAULT NULL,
  `director` varchar(256) NOT NULL COMMENT '导演',
  `lead_role` varchar(256) NOT NULL COMMENT '主演',
  `type` int(11) NOT NULL COMMENT '类型',
  `screenwriter` varchar(256) NOT NULL COMMENT '编剧',
  `film_length` varchar(256) NOT NULL COMMENT '片长',
  `alias` varchar(256) NOT NULL COMMENT '影片别名',
  `synopsis` varchar(1024) NOT NULL COMMENT '剧情介绍',
  `create_time` varchar(14) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `t_movie` */

insert  into `t_movie`(`id`,`name`,`picture`,`release_time`,`score`,`director`,`lead_role`,`type`,`screenwriter`,`film_length`,`alias`,`synopsis`,`create_time`) values (1,'肖申克的救赎','xskdjs.jpg','1994-09-10',7.6,'弗兰克·德拉邦特','蒂姆·罗宾斯 / 摩根·弗里曼 / 鲍勃·冈顿 / 威廉姆·赛德勒 / 克兰西·布朗',1,'弗兰克·德拉邦特 / 斯蒂芬·金','142','月黑高飞(港) / 刺激1995(台) / 地狱诺言 / 铁窗岁月 / 消香克的救赎','20世纪40年代末，小有成就的青年银行家安迪（蒂姆·罗宾斯 Tim Robbins 饰）因涉嫌杀害妻子及她的情人而锒铛入狱。在这座名为肖申克的监狱内，希望似乎虚无缥缈，终身监禁的惩罚无疑注定了安迪接下来灰暗绝望的人生。未过多久，安迪尝试接近囚犯中颇有声望的瑞德（摩根·弗里曼 Morgan Freeman 饰），请求对方帮自己搞来小锤子。以此为契机，二人逐渐熟稔，安迪也仿佛在鱼龙混杂、罪恶横生、黑白混淆的牢狱中找到属于自己的求生之道。他利用自身的专业知识，帮助监狱管理层逃税、洗黑钱，同时凭借与瑞德的交往在犯人中间也渐渐受到礼遇。表面看来，他已如瑞德那样对那堵高墙从憎恨转变为处之泰然，但是对自由的渴望仍促使他朝着心中的希望和目标前进。而关于其罪行的真相，似乎更使这一切朝前推进了一步……','20190203171848'),(2,'阿甘正传','agzz.jpg','1994-06-23',9.4,'罗伯特·泽米吉斯','汤姆·汉克斯 / 罗宾·怀特 / 加里·西尼斯 / 麦凯尔泰·威廉逊 / 莎莉·菲尔德',2,'艾瑞克·罗斯 / Winston Groom','142','福雷斯特·冈普','阿甘（汤姆·汉克斯 饰）于二战结束后不久出生在美国南方阿拉巴马州一个闭塞的小镇，他先天弱智，智商只有75，然而他的妈妈是一个性格坚强的女性，她常常鼓励阿甘“傻人有傻福”，要他自强不息。 　　阿甘像普通孩子一样上学，并且认识了一生的朋友和至爱珍妮（罗宾·莱特·潘 饰），在珍妮和妈妈的爱护下，阿甘凭着上帝赐予的“飞毛腿”开始了一生不停的奔跑。 　　阿甘成为橄榄球巨星、越战英雄、乒乓球外交使者、亿万富翁，但是，他始终忘不了珍妮，几次匆匆的相聚和离别，更是加深了阿甘的思念。','20190203171848');

/*Table structure for table `t_review` */

DROP TABLE IF EXISTS `t_review`;

CREATE TABLE `t_review` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `user_name` varchar(256) NOT NULL,
  `movie_id` int(11) NOT NULL,
  `movie_name` varchar(256) NOT NULL,
  `score` double(3,1) NOT NULL,
  `review` varchar(2048) NOT NULL,
  `create_time` varchar(14) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8;

/*Data for the table `t_review` */

/*Table structure for table `t_users` */

DROP TABLE IF EXISTS `t_users`;

CREATE TABLE `t_users` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `t_users` */

insert  into `t_users`(`id`,`user_name`,`password`) values (1,'101','1');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
