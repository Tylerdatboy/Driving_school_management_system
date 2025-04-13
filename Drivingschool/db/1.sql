-- drivingschool.aboutus definition

CREATE TABLE `aboutus` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `title` varchar(200) NOT NULL COMMENT 'title',
  `subtitle` varchar(200) DEFAULT NULL COMMENT '副title',
  `content` longtext NOT NULL COMMENT '内容',
  `picture1` longtext COMMENT '图片1',
  `picture2` longtext COMMENT '图片2',
  `picture3` longtext COMMENT '图片3',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COMMENT='About Us';


-- drivingschool.cheliangweihu definition

CREATE TABLE `cheliangweihu` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `chepaihao` varchar(200) DEFAULT NULL COMMENT '车牌号',
  `cheliangmingcheng` varchar(200) DEFAULT NULL COMMENT '车辆名称',
  `cheliangleixing` varchar(200) DEFAULT NULL COMMENT '车辆类型',
  `weihushijian` date DEFAULT NULL COMMENT '维护时间',
  `weihuneirong` longtext COMMENT '维护内容',
  `weihujieguo` longtext COMMENT '维护结果',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=99 DEFAULT CHARSET=utf8mb3 COMMENT='Vehicle maintenance';


-- drivingschool.coaching_schedule definition

CREATE TABLE `coaching_schedule` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `selectedCoach` varchar(50) NOT NULL COMMENT '教练名称',
  `studentName` varchar(50) NOT NULL COMMENT '学员名称',
  `scheduleDate` varchar(10) NOT NULL COMMENT '日期（格式：YYYY-MM-DD）',
  `startTime` varchar(5) NOT NULL COMMENT '开始时间（格式：HH:mm）',
  `endTime` varchar(5) NOT NULL COMMENT '结束时间（格式：HH:mm）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='教练日程安排表';


-- drivingschool.config definition

CREATE TABLE `config` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) NOT NULL COMMENT '配置参数名称',
  `value` varchar(100) DEFAULT NULL COMMENT '配置参数值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 COMMENT='配置文件';


-- drivingschool.fenpeijiaolian definition

CREATE TABLE `fenpeijiaolian` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `jiaolianzhanghao` varchar(200) NOT NULL COMMENT 'Coach account',
  `jiaolianxingming` varchar(200) DEFAULT NULL COMMENT 'Coach Name',
  `lianxidianhua` varchar(200) DEFAULT NULL COMMENT 'Contact Number',
  `xueyuanzhanghao` varchar(200) DEFAULT NULL COMMENT 'Student account',
  `xueyuanxingming` varchar(200) DEFAULT NULL COMMENT 'Student name',
  `xueyuanshouji` varchar(200) DEFAULT NULL COMMENT 'Student mobile phone',
  `fenpeishijian` datetime DEFAULT NULL COMMENT 'Allocate time',
  `crossuserid` bigint DEFAULT NULL COMMENT '跨表User id',
  `crossrefid` bigint DEFAULT NULL COMMENT '跨表主键id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb3 COMMENT='Assign coach';


-- drivingschool.jiaofeixinxi definition

CREATE TABLE `jiaofeixinxi` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `jiaxiaomingcheng` varchar(200) DEFAULT NULL COMMENT 'Name of driving school',
  `lianxifangshi` varchar(200) DEFAULT NULL COMMENT 'contact information',
  `jiaxiaodizhi` varchar(200) NOT NULL COMMENT 'Driving school address',
  `xueyuanzhanghao` varchar(200) DEFAULT NULL COMMENT 'Student account',
  `xueyuanxingming` varchar(200) DEFAULT NULL COMMENT 'Student name',
  `xueyuanshouji` varchar(200) DEFAULT NULL COMMENT 'Student mobile phone',
  `xuefei` float NOT NULL COMMENT 'tuition fee',
  `baomingshijian` datetime DEFAULT NULL COMMENT 'registration time',
  `ispay` varchar(200) DEFAULT '未支付' COMMENT 'Whether to pay or not',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=89 DEFAULT CHARSET=utf8mb3 COMMENT='Payment information';


-- drivingschool.jiaolianpingjia definition

CREATE TABLE `jiaolianpingjia` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `jiaolianzhanghao` varchar(200) DEFAULT NULL COMMENT 'Coach account',
  `jiaolianxingming` varchar(200) DEFAULT NULL COMMENT 'Coach Name',
  `lianxidianhua` varchar(200) DEFAULT NULL COMMENT 'Contact Number',
  `xueyuanzhanghao` varchar(200) DEFAULT NULL COMMENT 'Student account',
  `xueyuanxingming` varchar(200) DEFAULT NULL COMMENT 'Student name',
  `xueyuanshouji` varchar(200) DEFAULT NULL COMMENT 'Student mobile phone',
  `lianxikemu` varchar(200) DEFAULT NULL COMMENT 'Practice subjects',
  `pingjia` varchar(200) DEFAULT NULL COMMENT ' evaluate',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=119 DEFAULT CHARSET=utf8mb3 COMMENT='coach evaluate';


-- drivingschool.jiaxiaobaoming definition

CREATE TABLE `jiaxiaobaoming` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `jiaxiaomingcheng` varchar(200) DEFAULT NULL COMMENT 'Name of driving school',
  `lianxifangshi` varchar(200) DEFAULT NULL COMMENT 'contact information',
  `xuefei` float DEFAULT NULL COMMENT 'tuition fee',
  `fengmian` longtext COMMENT '封面',
  `jiaxiaodizhi` varchar(200) DEFAULT NULL COMMENT 'Driving school address',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=109 DEFAULT CHARSET=utf8mb3 COMMENT='Registration for Driving School';


-- drivingschool.jiaxiaocheliang definition

CREATE TABLE `jiaxiaocheliang` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `chepaihao` varchar(200) DEFAULT NULL COMMENT '车牌号',
  `cheliangmingcheng` varchar(200) NOT NULL COMMENT '车辆名称',
  `cheliangleixing` varchar(200) NOT NULL COMMENT '车辆类型',
  `kemu` varchar(200) DEFAULT NULL COMMENT '科目',
  `cheliangtupian` longtext COMMENT '车辆图片',
  `cheliangxiangqing` longtext COMMENT '车辆info',
  `jiaolianzhanghao` varchar(200) DEFAULT NULL COMMENT 'Coach account',
  `jiaolianxingming` varchar(200) DEFAULT NULL COMMENT 'Coach Name',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8mb3 COMMENT='Driving school vehicles';


-- drivingschool.jiaxiaojiaolian definition

CREATE TABLE `jiaxiaojiaolian` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `jiaolianzhanghao` varchar(200) NOT NULL COMMENT 'Coach account',
  `mima` varchar(200) NOT NULL COMMENT 'password',
  `jiaolianxingming` varchar(200) DEFAULT NULL COMMENT 'Coach Name',
  `nianling` int DEFAULT NULL COMMENT 'age',
  `xingbie` varchar(200) DEFAULT NULL COMMENT 'gender',
  `jiaoling` varchar(200) DEFAULT NULL COMMENT 'Length of teaching',
  `touxiang` longtext COMMENT 'picture',
  `lianxidianhua` varchar(200) DEFAULT NULL COMMENT 'Contact Number',
  `gerenjieshao` longtext COMMENT '个人介绍',
  `pquestion` varchar(200) DEFAULT NULL COMMENT 'security question',
  `panswer` varchar(200) DEFAULT NULL COMMENT 'Secret Answer',
  PRIMARY KEY (`id`),
  UNIQUE KEY `jiaolianzhanghao` (`jiaolianzhanghao`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb3 COMMENT='Driving school coach';


-- drivingschool.kaoshianpai definition

CREATE TABLE `kaoshianpai` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `jiaolianzhanghao` varchar(200) DEFAULT NULL COMMENT 'Coach account',
  `jiaolianxingming` varchar(200) DEFAULT NULL COMMENT 'Coach Name',
  `lianxidianhua` varchar(200) DEFAULT NULL COMMENT 'Contact Number',
  `xueyuanzhanghao` varchar(200) DEFAULT NULL COMMENT 'Student account',
  `xueyuanxingming` varchar(200) DEFAULT NULL COMMENT 'Student name',
  `xueyuanshouji` varchar(200) DEFAULT NULL COMMENT 'Student mobile phone',
  `kaoshishijian` datetime NOT NULL COMMENT 'Exam time',
  `kaoshikemu` varchar(200) DEFAULT NULL COMMENT 'Exam Subjects',
  `kaoshididian` varchar(200) NOT NULL COMMENT 'Exam place',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8mb3 COMMENT='Exam arrangements';


-- drivingschool.news definition

CREATE TABLE `news` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `title` varchar(200) NOT NULL COMMENT 'title',
  `introduction` longtext COMMENT 'Brief Introduction',
  `picture` longtext NOT NULL COMMENT '图片',
  `content` longtext NOT NULL COMMENT '内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=139 DEFAULT CHARSET=utf8mb3 COMMENT='Driving School Information';


-- drivingschool.storeup definition

CREATE TABLE `storeup` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `userid` bigint NOT NULL COMMENT 'User id',
  `refid` bigint DEFAULT NULL COMMENT '商品id',
  `tablename` varchar(200) DEFAULT NULL COMMENT '表名',
  `name` varchar(200) NOT NULL COMMENT '名称',
  `picture` longtext NOT NULL COMMENT '图片',
  `type` varchar(200) DEFAULT '1' COMMENT '类型(1:收藏,21:赞,22:踩,31:竞拍参与,41:关注)',
  `inteltype` varchar(200) DEFAULT NULL COMMENT '推荐类型',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='收藏表';


-- drivingschool.systemintro definition

CREATE TABLE `systemintro` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `title` varchar(200) NOT NULL COMMENT 'title',
  `subtitle` varchar(200) DEFAULT NULL COMMENT '副title',
  `content` longtext NOT NULL COMMENT '内容',
  `picture1` longtext COMMENT '图片1',
  `picture2` longtext COMMENT '图片2',
  `picture3` longtext COMMENT '图片3',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COMMENT='About Us';


-- drivingschool.token definition

CREATE TABLE `token` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` bigint NOT NULL COMMENT 'User id',
  `username` varchar(100) NOT NULL COMMENT 'userName',
  `tablename` varchar(100) DEFAULT NULL COMMENT '表名',
  `role` varchar(100) DEFAULT NULL COMMENT '角色',
  `token` varchar(200) NOT NULL COMMENT 'password',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `expiratedtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '过期时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3 COMMENT='token表';


-- drivingschool.users definition

CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(100) NOT NULL COMMENT 'userName',
  `password` varchar(100) NOT NULL COMMENT 'password',
  `role` varchar(100) DEFAULT 'admin' COMMENT '角色',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COMMENT='User 表';


-- drivingschool.xuexijihua definition

CREATE TABLE `xuexijihua` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `jiaolianzhanghao` varchar(200) DEFAULT NULL COMMENT 'Coach account',
  `jiaolianxingming` varchar(200) DEFAULT NULL COMMENT 'Coach Name',
  `lianxidianhua` varchar(200) DEFAULT NULL COMMENT 'Contact Number',
  `xueyuanzhanghao` varchar(200) DEFAULT NULL COMMENT 'Student account',
  `xueyuanxingming` varchar(200) DEFAULT NULL COMMENT 'Student name',
  `xueyuanshouji` varchar(200) DEFAULT NULL COMMENT 'Student mobile phone',
  `jihuashijian` datetime DEFAULT NULL COMMENT 'scheduled time',
  `jihuaneirong` longtext COMMENT '计划内容',
  `jihuaanpai` longtext COMMENT '计划安排',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=utf8mb3 COMMENT='study plan';


-- drivingschool.xueyuan definition

CREATE TABLE `xueyuan` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `xueyuanzhanghao` varchar(200) NOT NULL COMMENT 'Student account',
  `mima` varchar(200) NOT NULL COMMENT 'password',
  `xueyuanxingming` varchar(200) DEFAULT NULL COMMENT 'Student name',
  `xingbie` varchar(200) DEFAULT NULL COMMENT 'gender',
  `xueyuanshouji` varchar(200) DEFAULT NULL COMMENT 'Student mobile phone',
  `shenfenzheng` varchar(200) DEFAULT NULL COMMENT 'ID',
  `touxiang` longtext COMMENT 'picture',
  `pquestion` varchar(200) DEFAULT NULL COMMENT 'security question',
  `panswer` varchar(200) DEFAULT NULL COMMENT 'Secret Answer',
  PRIMARY KEY (`id`),
  UNIQUE KEY `xueyuanzhanghao` (`xueyuanzhanghao`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb3 COMMENT='student';


-- drivingschool.yuyuelianxi definition

CREATE TABLE `yuyuelianxi` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `jiaolianzhanghao` varchar(200) DEFAULT NULL COMMENT 'Coach account',
  `jiaolianxingming` varchar(200) DEFAULT NULL COMMENT 'Coach Name',
  `lianxidianhua` varchar(200) DEFAULT NULL COMMENT 'Contact Number',
  `xueyuanzhanghao` varchar(200) DEFAULT NULL COMMENT 'Student account',
  `xueyuanxingming` varchar(200) DEFAULT NULL COMMENT 'Student name',
  `xueyuanshouji` varchar(200) DEFAULT NULL COMMENT 'Student mobile phone',
  `yuyueshijian` datetime DEFAULT NULL COMMENT 'time of appointment',
  `yuyuebeizhu` varchar(200) DEFAULT NULL COMMENT 'Appointment remarks',
  `lianxikemu` varchar(200) NOT NULL COMMENT 'Practice subjects',
  `sfsh` varchar(200) DEFAULT '待审核' COMMENT '是否审核',
  `shhf` longtext COMMENT 'Review reply',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1742739190615 DEFAULT CHARSET=utf8mb3 COMMENT='Appointment Practice';